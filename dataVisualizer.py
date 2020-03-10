import sqlite3
import pandas as pd
import matplotlib.pyplot as plt

def try_connect():
	try:
		conn = sqlite3.connect('../RealGMdb.db')
		c = conn.cursor()
		print("connection established")
	except Error as e:
		print(e)
	return c


def label_points(df, ax):
	for line in range(0,df.shape[0]):
		ax.text(df.x[line], df.y[line], df.group[line], horizontalalignment='center', size='medium', color='black', weight='semibold')

def main():
	labels = []
	c = try_connect()
	c.execute("SELECT * from Teams")
	rows = c.fetchall()
	df = pd.DataFrame(rows,
					  columns=['tid', 'cid', 'did', 'region', 'name', 'abbrev', 'season', 'wins', 'losses'])
	
	print("uuuh")
	for row in rows:
		plt.annotate(row[3], (row[7], row[8]), textcoords="offset points", zytext=(0,10))
		labels.append(row[3])
	print(labels)
	print("made it")
	for k, v in df.iterrows():
		ax.annotate(k, v)
	ax = df.plot.scatter(x='wins', y='losses', title='take 9')
	plt.show()
	c.close()



if __name__=="__main__":
	main()