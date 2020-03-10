from keras.models import Sequential
from keras.layers import Dense

import numpy as np
import keras
import sqlite3
import tensorflow as tf
import pandas as pd



class data:
    def __init__(self, train, test, cols):
        self.train = train
        self.test = test
        self.cols = cols

def within(x, y, z):
    return (abs(x - y) < z)

def print_pred(predictions, test_y):
    print("\n\npredictions\n\n")
    '''for i, p in enumerate(predictions):
        print("\n{}\n".format(i))
        print(p)'''
    
    perfect = 0
    over_est, under_est, within_3, within_5, within_10, total = 0, 0, 0, 0, 0, 0
    for i in range(len(test_y)):
        
    #for test_data, expec in zip(predictions, test_y):
        #class_id = test_data['class_ids'][0]
        #probability = test_data['probabilities'][class_id]
        pred = int(predictions[i])
        expec = test_y[i]
        #print("X=%s, Predicted=%s" % (expec, pred))
        if pred == expec:
            perfect += 1
        if within(pred, expec, 3):
            within_3 += 1
        if within(pred, expec, 5):
            within_5 += 1
        if within(pred, expec, 10):
            within_10 += 1
        if pred > expec:
            over_est += 1
        else:
            under_est += 1
        total += 1
        '''if probability > 0.5:
            print('Prediction is "{}" ({:.1f}%), expected "{}"'.format(
                class_id, 100 * probability, expec))'''

    print("\nResults:\n")
    print("{}, or {:.1f}%  of predictions were dead on balls accurate\n".
        format(perfect, (perfect / total) * 100))
    print("{}, or {:.1f}%  of predictions were within 3 of actual value\n".
        format(within_3, (within_3 / total) * 100))
    print("{}, or {:.1f}%  of predictions were within 5 of actual value\n".
        format(within_5, (within_5 / total) * 100))
    print("{}, or {:.1f}%  of predictions were within 10 of actual value\n".
        format(within_10, (within_10 / total) * 100))
    print("{}, or {:.1f}%  of predictions were above the actual value\n".
        format(over_est, (over_est / total) * 100))
    print("{}, or {:.1f}%  of predictions were below the actual value\n".
        format(under_est, (under_est / total) * 100))

def tryConnect():
    try:
        conn = sqlite3.connect('../RealGMdb.db')
        c = conn.cursor()
        print("connection established")
    except Error as e:
        print(e)
    return c

def getDataSet(c, year):
    query = "SELECT stre, spd, jmp, endu, ins, dnk, ft, fg, tp, oiq, diq, drb, pss, reb, hgt, three, A, B, Di, Dp, Po, Ps, R, ovr from Players where min > 0 and season = {}".format(year)
    c.execute(query)
    results = c.fetchall()
    return results

def getDataSets(c, year):
    query = "SELECT stre, spd, jmp, endu, ins, dnk, ft, fg, tp, oiq, diq, drb, pss, reb, hgt, three, A, B, Di, Dp, Po, Ps, R, ovr from Players where min > 0 and season != {}".format(year)
    c.execute(query)
    results = c.fetchall()
    return results


def cleanData(data, cols):
    dataSet = pd.DataFrame(data, columns=cols)
    dataSet = dataSet.drop(['firstName', 'lastName', 'pos'], axis=1)
    results = dataSet.pop('ovr')
    my_columns = []
    col_names.remove('firstName')
    col_names.remove('lastName')
    col_names.remove('pos')
    col_names.remove('ovr')
    for val in col_names:
        my_columns.append(tf.feature_column.numeric_column(key=val))
    return dataSet, results, my_columns

#depth is number of channels
def getCNN(width, height, depth, filters=(16, 32, 64), regression=False):
    inputShape = (height, width, depth)
    chanDim = -1

    inputs = Input(shape=inputShape)

    for (i, f) in enumerate(filters):
        #sets inputs for first conv layer
        if i == 0:
            x = inputs

        # CONV => RELU => BN => POOL
        x = Conv2D(f, (3, 3), padding="same")(x)
        x = Activation("relu")(x)
        x = BatchNormalization(axis=chanDim)(x)
        x = MaxPooling2D(pool_size=(2, 2))(x)

    x = Flatten()(x)
    x = Dense(16)(x)
    x = Activation("relu")(x)
    x = BatchNormalization(axis=chanDim)(x)
    x = Dropout(0.5)(x)

    x = Dense(4)(x)
    x = Activation("relu")(x)

    if regress:
        x = Dense(1, activation="linear")(x)

    model = Model(inputs, x)
    return model


#build keras nn 
def getModel():
	#input attributes(a) and skills(b)
	inputA = Input(shape=(16,))
	inputB = Input(shape=(8,))

    #setup architecture for each set of inputs
	x = Dense(16, activation='relu')(inputA)
	x = Dense(8, activation='relu')(x)
	x = Dense(4, activation='relu')(x)
	x = Model(inputs=inputA, outputs=x)

	y = Dense(4, activation='relu')(x)
	y = Dense(2, activation='relu')(x)
	y = Model(inputs=inputB, outputs=y)

	combined = concatenate([x.output, y.output])

	z = Dense(2, activation='relu')(combined)
	z = Dense(1, activation='linear')(z)

	return Model(inputs=[x.input, y.input], outputs=z)

def buildRegModel(dim, regress=False):
    model = keras.Sequential()
    model.add(Dense(16, input_dim=dim, activation="relu"))
    model.add(Dense(8, activation="relu"))
    model.add(Dense(8, activation="relu"))
    model.add(Dense(4, activation="relu"))
    #model.add(Dense(2, activation="relu"))

    if regress:
        model.add(Dense(1, activation="linear"))

    return model

def saveModel(model, name):
    # serialize model to JSON
    model_json = model.to_json()
    fileName = "{}.json".format(name)
    weightName = "{}.h5".format(name)
    with open(fileName, "w") as json_file:
        json_file.write(model_json)
    # serialize weights to HDF5
    model.save_weights(weightName)
    print("Saved model to disk")

def loadModel(name):
    # load json and create model
    fileName = "{}.json".format(name)
    weightName = "{}.h5".format(name)
    json_file = open(fileName, 'r')
    loaded_model_json = json_file.read()
    json_file.close()
    loaded_model = keras.models.model_from_json(loaded_model_json)
    # load weights into new model
    loaded_model.load_weights(weightName)
    print("Loaded model from disk")
    return loaded_model

def main():
    my_columns = []
    c = tryConnect()
    results = getDataSets(c, 2024)
    test = getDataSet(c, 2024)
    my_columns = [description[0] for description in c.description]

    training_data = pd.DataFrame(results, columns=my_columns)
    test_data = pd.DataFrame(test, columns=my_columns)
    train_y = training_data.pop('ovr')
    test_y = test_data.pop('ovr')
    

    #training_data, train_y, my_columns = cleanData(results, col_names)
    #test_data, test_y, my_columns = cleanData(test, col_names)

    model = loadModel('regModelTakeOne')
    #model = buildRegModel(training_data.shape[1], regress=True)
    opt = keras.optimizers.Adam(lr=1e-3, decay=1e-3 / 200)
    #model.compile(loss="mean_absolute_percentage_error", optimizer=opt)

    #print("training model...")
    #model.fit(training_data, train_y, validation_data=(test_data, test_y), epochs=5000, batch_size=100)

    #saveModel(model, "regModelTakeOne")
    print("making predictions...")
    preds = model.predict(test_data)
    print_pred(preds, test_y)

    diffs = preds.flatten() - test_y
    percentDiff = (diffs / test_y) * 100
    absPercentDiff = np.abs(percentDiff)

    mean = np.mean(absPercentDiff)
    std = np.std(absPercentDiff)

    print("mean: {:.2f}%, std: {:.2f}%".format(mean, std))




if __name__=="__main__":
    main()