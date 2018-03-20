package Threads;

import java.util.Random;

import GUI.Frame;
import GUI.Program;

import static java.lang.Thread.sleep;

public class ThreadTarget implements Runnable {
	private int id;
	private Random random;
	private int minSeed;
	private int maxSeed;
	private int minTime = 100;
	private int maxTime = 10000;
	private ThreadManager threadManager;
	Program program;
	Frame data;

	/**
	 * *
	 * <p>
	 * Constructor ThreadTarget
	 * </p>
	 * Set id and generate random number. Show info about thread's id;
	 * 
	 * @param id
	 * @param threadManager
	 */
	public ThreadTarget(int id, ThreadManager threadManager) {
		this.id = id;
		this.threadManager = threadManager;
		random = new Random();
		StartTreadInfo(id);
	}

	@Override
	/**
	 * {@link java.lang.Thread}
	 */
	public void run() {
		random = new Random();
		data = new Frame();

		maxSeed = (Integer) data.MaxSeedValueSpinner.getValue();
		minSeed = (Integer) data.MinSeedValueSpinner.getValue();
		while (true) {

			int seed = random.nextInt(maxSeed - minSeed + 1) + minSeed;

			Program.textArea.append("Thread " + id + " seed " + seed + "\n");
			Program.textArea.append("Thread " + id + " seed " + seed + " average: "
					+ Data.Statistic.Average(threadManager.GetList(seed)) + "\n");

			try {
				//
				sleep(minTime + random.nextInt(maxTime - minSeed + 1));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void StartTreadInfo(int id) {
		Program.textArea.append("Thread " + id + " START" + "\n");

	}

}
