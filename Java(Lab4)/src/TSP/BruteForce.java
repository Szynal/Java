package TSP;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class BruteForce {

	private Random r = new Random();

	private int vertices[];
	public int[][] graf;

	private int numberOfCities = 0;
	private boolean[] visited;

	private int sum = 99999;
	private int tmpSum = 0;

	private int counterTransition = 0;
	private int counter = 0;
	private int tmpCounter = 0;
	private int[] listOfTempVertex;
	private boolean used[][];

	private String newRow;
	private BufferedReader br = null;

	public void loadFromFile(String fileName) throws IOException {
		String line[];
		try

		{
			br = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException ex) {
			System.out.println("Nie ma takiego pliku");
			System.exit(0);
		}
		try {
			newRow = br.readLine();
			line = newRow.split(" ");
			numberOfCities = Integer.parseInt(line[0]);

			this.Cities(numberOfCities);

			int readingNumber = 0;

			for (int i = 0; i < numberOfCities; i++) {
				line = null;
				newRow = br.readLine();
				if (newRow != null) {
					line = newRow.split(" +");
					int whichAdd = 0;
					for (int j = 0; j < line.length; j++) {
						this.addToMatrix(readingNumber, whichAdd, Integer.parseInt(line[j]));
						whichAdd++;
					}
				}
				readingNumber++;
			}
		} finally {
		}
	}

	void Cities(int p) {
		this.setGraf(new int[p][p]);
		this.visited = new boolean[p + 1];
		this.vertices = new int[p];
		this.listOfTempVertex = new int[p];
		this.used = new boolean[p][p];
		this.vertices = new int[p + 1];

	}

	public void addToMatrix(int n, int m, int wartosc) {
		getGraf()[n][m] = wartosc;
		used[n][m] = true;
	}

	void copytoFinal(int droga[]) {
		for (int i = 0; i < numberOfCities; i++)
			vertices[i] = droga[i];
		vertices[numberOfCities] = droga[0];
	}

	int firstMin(int graf[][], int i) {
		int min = Integer.MAX_VALUE;
		for (int k = 0; k < numberOfCities; k++)
			if (graf[i][k] < min && i != k)
				min = graf[i][k];
		return min;
	}

	int secondMin(int graf[][], int i) {
		int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
		for (int j = 0; j < numberOfCities; j++) {
			if (i == j)
				continue;
			if (graf[i][j] <= first) {
				second = first;
				first = graf[i][j];
			} else if (graf[i][j] <= second && graf[i][j] != first)
				second = graf[i][j];
		}
		return second;
	}

	public String naive(int vertex, String fileName) {

		try {
			loadFromFile(fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		listOfTempVertex[tmpCounter] = vertex;// wierzcholek obecnie "omawiany", dodany do puli
		tmpCounter++;
		if (tmpCounter < numberOfCities)// jeslli nie doszlismy jeszcze do ostatniego miasta
		{
			visited[vertex] = true;// oznacz miasto jako odwiedzone
			for (int i = 0; i < numberOfCities; i++)
				if (used[vertex][i] == true && !visited[i])// jesli istnieje taka krawedz i wierzcholek docelowy
															// nie byl jeszcze odwiedzony
				{
					tmpSum += getGraf()[vertex][i];// suma tymczasowa zwiekszana jest o te droge
					naive(i, fileName);
					tmpSum -= getGraf()[vertex][i];
				}
			visited[vertex] = false;// wyzerowanie wierzcholkow dla poszukiwania nastepnego
		} else {
			if (used[0][vertex])// jesli jest polaczenie
			{
				tmpSum += getGraf()[vertex][0];
				if (tmpSum < sum)// jesli nowa odkryta droga jest mniej kosztowna niz poprzednia
				{
					sum = tmpSum;
					for (int i = 0; i < tmpCounter; i++)
						vertices[i] = listOfTempVertex[i];// przypisanie nowej drogi
					setCounter(tmpCounter);
				}
				tmpSum -= getGraf()[vertex][0];
			}
		}
		tmpCounter--;
		return display();
	}

	public String display() {
		String dsiplayString = "";
		for (int i = 0; i < numberOfCities; i++) {
			dsiplayString += (vertices[i]);
			if (i >= 0 && i < (numberOfCities - 1)) {
				dsiplayString += ("->");
			}
		}
		dsiplayString += ("\n");
		dsiplayString += ("Sum: " + sum);
		return dsiplayString;
	}

	public void generateCities(int quantity) {
		this.numberOfCities = quantity;
		this.Cities(quantity);
		for (int i = 0; i < numberOfCities; i++)
			for (int j = 0; j < numberOfCities; j++) {
				if (i != j && getGraf()[i][j] == 0) {
					this.addToMatrix(i, j, r.nextInt(100));
				}
			}
	}

	public int[][] getGraf() {
		return graf;
	}

	public void setGraf(int[][] graf) {
		this.graf = graf;
	}

	public int getCounterTransition() {
		return counterTransition;
	}

	public void setCounterTransition(int counterTransition) {
		this.counterTransition = counterTransition;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

}
