from __future__ import absolute_import, division, print_function, unicode_literals
import numpy as np
import sqlite3
import tensorflow as tf
import pandas as pd

def within(x, y, z):
    return (abs(x - y) < z)

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

#def getModel():

def getEstimator(my_columns):
    classifier = tf.estimator.DNNClassifier(
        feature_columns=my_columns,
        hidden_units=[40,20,10],
        n_classes=100)
    return classifier

def input_fun(features, batch_size=100):
    """An input function for prediction."""
    # Convert the inputs to a Dataset without labels.
    return tf.data.Dataset.from_tensor_slices(dict(features)).batch(batch_size)

def input_fn(features, labels, training=True, batch_size=100):
    """An input function for training or evaluating"""
    # Convert the inputs to a Dataset.
    dataset = tf.data.Dataset.from_tensor_slices((dict(features), labels))

    # Shuffle and repeat if you are in training mode.
    if training:
        dataset = dataset.shuffle(1000).repeat()
    return dataset.batch(batch_size)

def print_pred(predictions, test_y):
    print("\n\npredictions\n\n")
    '''for i, p in enumerate(predictions):
        print("\n{}\n".format(i))
        print(p)'''
    
    perfect = 0
    over_est, under_est, within_3, within_5, within_10, total = 0, 0, 0, 0, 0, 0
    for test_data, expec in zip(predictions, test_y):
        class_id = test_data['class_ids'][0]
        probability = test_data['probabilities'][class_id]
        if class_id == expec:
            perfect += 1
        if within(class_id, expec, 3):
            within_3 += 1
        if within(class_id, expec, 5):
            within_5 += 1
        if within(class_id, expec, 10):
            within_10 += 1
        if class_id > expec:
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



def main():
    my_columns = []
    c = tryConnect()
    results = getDataSets(c, 2020)
    test = getDataSet(c, 2020)
    col_names = [description[0] for description in c.description]
    
    #set up data
    training_data = pd.DataFrame(results, columns=col_names)
    #training_data = training_data.drop(['firstName', 'lastName', 'pos'], axis=1)
    test_data = pd.DataFrame(test, columns=col_names)
    #test_data = test_data.drop(['firstName', 'lastName', 'pos'], axis=1)
    train_y = training_data.pop('ovr')
    test_y = test_data.pop('ovr')

    my_columns = []
    '''col_names.remove('firstName')
    col_names.remove('lastName')
    col_names.remove('pos')'''
    col_names.remove('ovr')
    for val in col_names:
        my_columns.append(tf.feature_column.numeric_column(key=val))

    #set up model
    classifier = getEstimator(my_columns)
    print("\n\nstarting training\n\n")
    classifier.train(
        input_fn=lambda: input_fn(training_data, train_y, training=True),
        steps=10000)
    '''print("\n\ndone training\n\n")
    eval_result = classifier.evaluate(
        input_fn=lambda: input_fn(test_data, test_y, training=False))
    print('\nTest set accuracy: {accuracy:0.3f}\n'.format(**eval_result))
    print("\n\ndone testing\n\n")'''

    predictions = classifier.predict(
        input_fn=lambda: input_fun(test_data))
    print_pred(predictions, test_y)
    





if __name__=="__main__":
    main()