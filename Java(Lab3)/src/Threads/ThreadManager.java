package Threads;

import Data.DataGenerator;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;

public class ThreadManager {

	private ArrayList<ThreadCalculator> threadCalculatorArrayList = new ArrayList<ThreadCalculator>();

	private HashMap<Integer, SoftReference<ArrayList>> softReferenceHashMapHashMap = new HashMap<Integer, SoftReference<ArrayList>>();

	private ReferenceQueue<ArrayList> referenceQueue = new ReferenceQueue<>();

	public ThreadManager(int numberOfThreads) {
		for (int i = 0; i < numberOfThreads; i++)
			threadCalculatorArrayList.add(new ThreadCalculator(i, this));
		for (ThreadCalculator threadCalculator : threadCalculatorArrayList) {
			Thread thread = new Thread(threadCalculator);
			thread.start();
		}
		// referenceQueue.
	}

	public ArrayList<ThreadCalculator> GetList(int seed, int minValue, int maxValue) {
		synchronized (softReferenceHashMapHashMap) {
			System.out.println("Requesting " + seed);
			softReferenceHashMapHashMap.putIfAbsent(seed,
					new SoftReference<>(DataGenerator.GenerateList(seed, minValue, maxValue), referenceQueue));

			if (softReferenceHashMapHashMap.get(seed).get() == null) {
				System.out.println("Seed " + seed + " not found");
				softReferenceHashMapHashMap.put(seed,
						new SoftReference<>(DataGenerator.GenerateList(seed, minValue, maxValue), referenceQueue));
			}

			ArrayList arrayList = softReferenceHashMapHashMap.get(seed).get();
			return arrayList == null ? null : arrayList;
		}
	}
}
