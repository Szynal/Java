package Data;

import java.util.ArrayList;

public class Statistic {

	public static double Average(@SuppressWarnings("rawtypes") ArrayList list) {
		double sum = 0d;

		for (int i = 0; i < list.size(); i++) {
			sum += (double) list.get(i);
		}

		return sum / list.size();
	}

}
