import java.util.List;
import java.util.Random;

/**
 * 
 * @author Pawel Szynal
 *
 */

public class Generator {

	private List<Double> list;
	/**
	 * 1 MB to 125000 double'i
	 */
	private int MB = 125000;

	public void randomGenerator(long seed) {

		Random generator = new Random(seed);
		for (int i = 0; i < seed * 0.5 * MB; i++) {

			list.add(generator.nextDouble() * (0.5));

		}

	}

}
