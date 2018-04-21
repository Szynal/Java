package TSP;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class TSP {

	private Random r = new Random();

	private int vertices[];
	public int[][] graf;

	private int numberOfCities = 0;
	private boolean[] visited;

	private int sum = 99999;
	private int tmpSum = 0;

	private int counterTransition = 0;
	private int counter = 0, tmpCounter = 0;
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

	void TSP1(int graf[][], int end, int weight, int lvl, int path[]) {

		if (lvl == numberOfCities) // Jeœli wszystkie wierzcholki zostaly juz uzyte
		{
			// sprawdz, czy z obecnego miasta mozna dostac sie do miasta poczatkowego
			if (graf[path[lvl - 1]][path[0]] != 0) {
				// sumaTym zawiera swage obecnej drogi
				int sumaTym = weight + graf[path[lvl - 1]][path[0]];

				// jesli droga jest krotsza, to zaaktualizuj droge glowna
				if (sumaTym < sum) {
					this.copytoFinal(path);
					sum = sumaTym;
				}
			}

		}

		for (int i = 0; i < numberOfCities; i++) {
			// jesli sa jeszcze wierzcholki do odzwiedzenia, to rob to po kolei
			if (graf[path[lvl - 1]][i] != -1 && visited[i] == false) {
				int temp = end;
				weight += graf[path[lvl - 1]][i];

				// liczenie granicy, inny sposob gdy jest wiecej niz 1 wierzcholek w
				// dotychczas przebytej drodze
				if (lvl == 1)
					end -= ((firstMin(graf, path[lvl - 1]) + firstMin(graf, i)) / 2);
				else
					end -= ((secondMin(graf, path[lvl - 1]) + firstMin(graf, i)) / 2);

				// granica + waga to wlasciwa dolna granica
				// jesli dotychczasowa droga jest dluzsza niz najkrotsza do tej
				// pory znaleziona, to mozna "zaglebiac sie" dalej
				if (end + weight < sum) {
					path[lvl] = i;
					visited[i] = true;

					// rekurencja dla nastepnego poziomu
					TSP1(graf, end, weight, lvl + 1, path);
				}

				// W przeciwnym razie cofamy sie do stanu sprzed najnowszego wierzcholka
				// i sprawdzamy dalej
				weight -= graf[path[lvl - 1]][i];
				end = temp;
				for (int z = 0; z < visited.length; z++)
					visited[z] = false;
				for (int j = 0; j <= lvl - 1; j++)
					visited[path[j]] = true;
			}
		}
	}

	public void TSP(int graf[][]) {
		int path[] = new int[numberOfCities + 1];

		// Inicjalizacja tablic i zmiennych
		int end = 0;
		for (int z = 0; z < path.length; z++) {
			path[z] = -1;
			visited[z] = false;
		}

		// Poczatkowa granica- liczenie jej wyglada nastepujaco: 1/2 * suma
		// dwoch najkrotszych krawedzi wychodzacych z kazdego wierzcholka
		for (int i = 0; i < numberOfCities; i++)
			end += (firstMin(graf, i) + secondMin(graf, i));

		// Zaokraglenie w gore
		if (end % 2 == 0)
			end = end / 2;
		else
			end = (end + 1) / 2;

		// Pierwszy wierzcholek to wierzcholek 0
		visited[0] = true;
		path[0] = 0;

		// Wywolanie funkcji wlasciwej, liczacej TSP
		TSP1(graf, end, 0, 1, path);
	}

	public void naive(int vertex) {

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
					naive(i);
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
