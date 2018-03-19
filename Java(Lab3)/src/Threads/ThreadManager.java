package Threads;

import Data.DataGenerator;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;

public class ThreadManager {

	/**
	 * <p>
	 * List of threads
	 * </p>
	 * {@link java.util.ArrayList}
	 */
	private ArrayList<Threads.ThreadTarget> threadsArrayList = new ArrayList<Threads.ThreadTarget>();

	/**
	 * <p>
	 * A softReference HashMap (memory-sensitive caches)
	 * </p>
	 * 
	 * HashMap is roughly equivalent to Hashtable, except that it is unsynchronized
	 * and permits nulls and allows to quickly compare data.
	 * {@link java.util.HashMap}
	 * 
	 * Soft reference objects, which are cleared at the discretion of the garbage
	 * collector in response to memory demand. Soft references are most often used
	 * to implement memory-sensitive caches.
	 */
	@SuppressWarnings("rawtypes")
	private HashMap<Integer, SoftReference<ArrayList>> hashMap = new HashMap<Integer, SoftReference<ArrayList>>();

	/**
	 * <p>
	 * A new reference-object queue.
	 * </p>
	 * Counts the situations in which a collection has been removed from the cache
	 * 
	 * {@link java.lang.ref.ReferenceQueue}
	 */
	@SuppressWarnings("rawtypes")
	private ReferenceQueue<ArrayList> referenceQueue = new ReferenceQueue<>();

	/**
	 * <p>
	 * Creates new threads based on the parameter
	 * </p>
	 * {@link java.lang.Thread}
	 * 
	 * @param numberOfThreads
	 */
	public ThreadManager(int numberOfThreads) {

		for (int i = 0; i < numberOfThreads; i++) {
			threadsArrayList.add(new Threads.ThreadTarget(i, this));
		}

		for (Threads.ThreadTarget threadTarget : threadsArrayList) {
			Thread thread = new Thread(threadTarget);
			thread.start();
		}
		// referenceQueue.
	}

	@SuppressWarnings("unchecked")
	public ArrayList<ThreadTarget> GetList(int seed, int minValue, int maxValue) {

		synchronized (hashMap) {

			System.out.println("Requesting " + seed);

			// If the specified key is not already associated with a value ...
			hashMap.putIfAbsent(seed,
					new SoftReference<>(DataGenerator.GenerateList(seed, minValue, maxValue), referenceQueue));

			// Create a new list and overwrite the old list if data beyond memory-sensitive
			// caches
			if (hashMap.get(seed).get() == null) {
				System.out.println("Seed " + seed + " not found");
				hashMap.put(seed,
						new SoftReference<>(DataGenerator.GenerateList(seed, minValue, maxValue), referenceQueue));
			}

			@SuppressWarnings("rawtypes")
			ArrayList arrayList = hashMap.get(seed).get();
			return (arrayList == null) ? null : arrayList;
		}
	}

}
