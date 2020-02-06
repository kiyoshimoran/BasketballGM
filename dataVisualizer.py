import sqlite3
import pandas as pd
import matplotlib.pyplot as plt

def main():
	connect()


def connect():
	try:
		conn = sqlite3.connect('RealGMdb.db')
		c = conn.cursor()
		print("connection established")
	except Error as e:
		print(e)

	c.execute("SELECT * from Teams")
	rows = c.fetchall()
	df = pd.DataFrame(rows, 
		columns=['tid', 'cid', 'did', 'region', 'name', 'abbrev', 'season', 'wins', 'losses'])
	df.plot.scatter(x='wins', y='losses', title='take 9')
	
	
	plt.show()
	conn.close()


if __name__=="__main__":
	main()