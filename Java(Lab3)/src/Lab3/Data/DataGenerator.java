package Data;

import java.util.ArrayList;
import java.util.Random;

import GUI.Frame;

/**
 * The class responsible for generating the List of Double objects.
 * 
 * @author Pawel Szynal
 *
 */
public class DataGenerator {

	/**
	 * The smallest list size possible to genera
	 */
	private static int minListSize;
	/**
	 * The largest list size possible to generate
	 */
	private static int maxListSize;

	private static int minValue;
	private static int maxValue;

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
	public static ArrayList<Double> GenerateList(int seed) {
		Frame dataFromframe = new Frame();

		minListSize = (Integer) dataFromframe.MinListSizeSpinner.getValue();
		maxListSize = (Integer) dataFromframe.MaxListSizeSpinner.getValue();
		minValue = (Integer) dataFromframe.MinListValueSpinner.getValue();
		maxValue = (Integer) dataFromframe.MaxListValueSpinner.getValue();

		ArrayList<Double> list = new ArrayList<Double>();
		Random random = new Random(seed);

		int size = random.nextInt((maxListSize - minListSize) + 1) + minListSize;
		for (int i = 0; i < size; i++)
			list.add(minValue + (maxValue - minValue) * random.nextDouble());

		return list;
	}

}
