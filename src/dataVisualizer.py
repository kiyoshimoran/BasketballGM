import sqlite3
import pandas as pd
import matplotlib.pyplot as plt

def main():
	c = connect()
	c.execute("SELECT * from Teams")
	rows = c.fetchall()
	df = pd.DataFrame(rows, 
		columns=['tid', 'cid', 'did', 'region', 'name', 'abbrev', 'season', 'wins', 'losses'])
	df.plot.scatter(x='wins', y='losses', title='take 9')
	label_point(df.x, df.y, df.val, ax)
	plt.show()
	c.close()

def connect():
	try:
		conn = sqlite3.connect('RealGMdb.db')
		c = conn.cursor()
		print("connection established")
	except Error as e:
		print(e)
	return c


def label_points(x, y, val, ax):
	a = pd.concat({'x': x, 'y': y, 'val': val}, axis=1)
	for i, point in a.iterrows():
		ax.text(point['x'], point['y'], str(point['val']))






if __name__=="__main__":
	main()