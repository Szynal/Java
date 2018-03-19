package Data;

import java.util.ArrayList;
import java.util.Random;

/**
 * The class responsible for generating the List of Double objects.
 * 
 * @author Pawel Szynal
 *
 */
public class DataGenerator {

	/**
	 * The smallest list size possible to generate. (10^6)
	 */
	private static int minListSize = 10000;
	/**
	 * The largest list size possible to generate (10^9)
	 */
	private static int maxListSize = 1000000;

	/**
	 * <p>
	 * GenerateList
	 * </p>
	 * Creates a new random List generator using a single long seed. T
	 * 
	 * @param seed
	 *            the seed is the initial value of the internal state of the
	 *            pseudorandom number generator which is maintained by method
	 *            next(int).
	 * @param minValue
	 *            The smallest list value possible to generate.
	 * @param maxValue
	 *            The largest list value possible to generate.
	 * @return The generated list.
	 */
	public static ArrayList<Double> GenerateList(int seed, int minValue, int maxValue) {
		ArrayList<Double> list = new ArrayList<Double>();
		Random random = new Random(seed);

		int size = random.nextInt((maxListSize - minListSize) + 1) + minListSize;

		for (int i = 0; i < size; i++)
			list.add(minValue + (maxValue - minValue) * random.nextDouble());

		return list;
	}

}
