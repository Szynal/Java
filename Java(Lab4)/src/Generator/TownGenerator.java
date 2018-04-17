package Generator;

import java.util.Random;

public class TownGenerator {

	public static float[][] GenerateTown(int numberOftown, int minimalCost, int maximumCost) {
		float[][] towns = new float[numberOftown][numberOftown];

		Random rand = new Random();

		for (int i = 0; i < numberOftown; i++) {
			for (int j = 0; j < numberOftown; j++) {
				if (i == j)
					towns[i][j] = 0;
				else
					towns[i][j] = rand.nextInt((maximumCost - minimalCost) + 1) + minimalCost;

			}
		}
		return towns;
	}

}
