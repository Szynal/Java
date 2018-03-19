package Threads;

import java.util.ArrayList;
import java.util.Random;
import Data.Statistic;
import static java.lang.Thread.sleep;

public class ThreadTarget implements Runnable {
	private int id;
	private Random random;
	private int minSeed = 5;
	private int maxSeed = 50;
	private int minTime = 100;
	private int maxTime = 10000;
	private ThreadManager threadManager;

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
		while (true) {
			int seed = random.nextInt(maxSeed - minSeed + 1) + minSeed;

			System.out.println("Thread " + id + " seed " + seed);
			System.out.println("Thread " + id + " seed " + seed + " average "
					+ Data.Statistic.Average(threadManager.GetList(seed, 50, 100)));

			try {
				//
				sleep(minTime + random.nextInt(maxTime - minSeed + 1));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void StartTreadInfo(int id) {
		System.out.println("Thread " + id + " start working");
	}

}
