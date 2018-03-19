package Threads;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Thread.sleep;

public class ThreadCalculator implements Runnable {
	private int id;
	private Random random;
	private static final int minSeed = 5;
	private static final int maxSeed = 50;
	private static final int minTime = 100;
	private static final int maxTime = 10000;
	private ThreadManager threadManager;

	public ThreadCalculator(int id, ThreadManager threadManager) {
		this.id = id;
		this.threadManager = threadManager;
		random = new Random();
		System.out.println("Thread " + id + " start working");
	}

	@Override
	public void run() {
		random = new Random();
		while (true) {
			int seed = random.nextInt(maxSeed - minSeed + 1) + minSeed;

			System.out.println("Thread " + id + " seed " + seed);
			System.out
					.println("Thread " + id + " seed " + seed + " average " + calcAverage(threadManager.GetList(seed)));

			try {
				sleep(minTime + random.nextInt(maxTime - minSeed + 1));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private double calcAverage(ArrayList list) {
		double sum = 0d;

		for (Object x : list) {
			sum += (double) x;
		}

		return sum / list.size();
	}
}
