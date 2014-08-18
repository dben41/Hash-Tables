package assignment8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class TimeHashTables
	{
		static ArrayList dictionary;
		static ArrayList<String> forContains;
		private static Random rand;
		static QuadProbeHashTable testQuad;
		static QuadProbeHashTable testQuadMediocre;
		static QuadProbeHashTable testQuadBad;
		static HashFunctor goodHashFunctor;
		static HashFunctor badHashFunctor;
		static HashFunctor mediocreHashFunctor;

		public static void main(String[] args) {
			rand = new Random();
			rand.setSeed(System.currentTimeMillis());
			goodHashFunctor = new GoodHashFunctor();
			mediocreHashFunctor = new MediocreHashFunctor();
			badHashFunctor = new BadHashFunctor();
			File file = new File("dictionary.txt");
			dictionary = readFromFile(file);
			forContains = arrayFiller(50);
			// testChainCollision();
			// timeQuadContainsAll();
			// System.out.println("quad done");
			// timeChainAddAll();
			goodHashFunctorContains();
			System.out.println("good hash done");
			medHashFunctorContains();
			System.out.println("med hash done");
			badHashFunctorContains();
			System.out.println("bad hash done");
		}

		public static void testQuadCollision() {

			// Preparation for the timing, generate some random numbers.
			for (int size = 100; size <= 2500; size = size + 100) {
				HashFunctor goodHash = new GoodHashFunctor();
				HashTable quadHashTable = new QuadProbeHashTable(101, goodHash);
				ArrayList<String> test = arrayFiller(size);

				quadHashTable.addAll(test);

				System.out.println(quadHashTable.numberOfCollisions + "");
			}
		}

		public static void testChainCollision() {
			// Preparation for the timing, generate some random numbers.
			for (int size = 100; size <= 2500; size = size + 100) {
				HashFunctor goodHash = new GoodHashFunctor();
				HashTable chainHashTable = new ChainingHashTable(101, goodHash);
				ArrayList<String> test = arrayFiller(size);

				chainHashTable.addAll(test);

				System.out.println(chainHashTable.numberOfCollisions + "");
			}
		}

		public static void timeQuadAddAll() {
			// Preparation for the timing, generate some random numbers.
			for (int size = 100; size <= 2500; size = size + 100) {
				// SETUP TASKS
				HashFunctor goodHash = new GoodHashFunctor();
				HashTable quadHashTable = new QuadProbeHashTable(101, goodHash);
				ArrayList<String> test = arrayFiller(size);

				// Timing code starting point
				long startTime, midpointTime, stopTime;

				// First, spin computing stuff until one second has gone by.
				// This allows this thread to stabilize.
				startTime = System.nanoTime();

				while (System.nanoTime() - startTime < 1000000000) {
				} // empty block

				// Now, run the test.
				long timesToLoop = 100;

				startTime = System.nanoTime();

				for (int i = 0; i <= timesToLoop; i++)
					quadHashTable.addAll(test);

				midpointTime = System.nanoTime();

				// Run an empty loop to capture the cost of running the loop.

				for (int i = 0; i <= timesToLoop; i++) {
				}
				stopTime = System.nanoTime();

				// Compute the time, subtract the cost of running the loop
				// from the cost of running the loop and computing square roots.
				// Average it over the number of runs.
				double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime))
						/ timesToLoop;

				System.out.println(averageTime + "");
			}
		}

		public static void timeChainAddAll() {
			// Preparation for the timing, generate some random numbers.
			for (int size = 100; size <= 2500; size = size + 100) {
				// SETUP TASKS
				HashFunctor goodHash = new GoodHashFunctor();
				HashTable chainHashTable = new ChainingHashTable(101, goodHash);
				ArrayList<String> test = arrayFiller(size);

				// Timing code starting point
				long startTime, midpointTime, stopTime;

				// First, spin computing stuff until one second has gone by.
				// This allows this thread to stabilize.
				startTime = System.nanoTime();

				while (System.nanoTime() - startTime < 1000000000) {
				} // empty block

				// Now, run the test.
				long timesToLoop = 100;

				startTime = System.nanoTime();

				for (int i = 0; i <= timesToLoop; i++)
					chainHashTable.addAll(test);

				midpointTime = System.nanoTime();

				// Run an empty loop to capture the cost of running the loop.

				for (int i = 0; i <= timesToLoop; i++) {
				}
				stopTime = System.nanoTime();

				// Compute the time, subtract the cost of running the loop
				// from the cost of running the loop and computing square roots.
				// Average it over the number of runs.
				double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime))
						/ timesToLoop;

				System.out.println(averageTime + "");
			}
		}

		public static void timeQuadContainsAll() {
			// Preparation for the timing, generate some random numbers.
			for (int size = 100; size <= 2500; size = size + 100) {
				// SETUP TASKS
				HashFunctor goodHash = new GoodHashFunctor();
				HashTable quadHashTable = new QuadProbeHashTable(101, goodHash);
				ArrayList<String> test = arrayFiller(size);
				// populate are HashTable
				quadHashTable.addAll(test);

				// Timing code starting point
				long startTime, midpointTime, stopTime;

				// First, spin computing stuff until one second has gone by.
				// This allows this thread to stabilize.
				startTime = System.nanoTime();

				while (System.nanoTime() - startTime < 1000000000) {
				} // empty block

				// Now, run the test.
				long timesToLoop = 100;

				startTime = System.nanoTime();

				for (int i = 0; i <= timesToLoop; i++)
					quadHashTable.containsAll(forContains);

				midpointTime = System.nanoTime();

				// Run an empty loop to capture the cost of running the loop.

				for (int i = 0; i <= timesToLoop; i++) {
				}
				stopTime = System.nanoTime();

				// Compute the time, subtract the cost of running the loop
				// from the cost of running the loop and computing square roots.
				// Average it over the number of runs.
				double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime))
						/ timesToLoop;

				System.out.println(averageTime + "");
			}
		}

		public static void timeChainContainsAll() {
			// Preparation for the timing, generate some random numbers.
			for (int size = 100; size <= 2500; size = size + 100) {
				// SETUP TASKS
				HashFunctor goodHash = new GoodHashFunctor();
				HashTable chainHashTable = new ChainingHashTable(101, goodHash);
				ArrayList<String> test = arrayFiller(size);
				// Populate our HashTable
				chainHashTable.addAll(test);

				// Timing code starting point
				long startTime, midpointTime, stopTime;

				// First, spin computing stuff until one second has gone by.
				// This allows this thread to stabilize.
				startTime = System.nanoTime();

				while (System.nanoTime() - startTime < 1000000000) {
				} // empty block

				// Now, run the test.
				long timesToLoop = 100;

				startTime = System.nanoTime();

				for (int i = 0; i <= timesToLoop; i++)
					chainHashTable.containsAll(forContains);

				midpointTime = System.nanoTime();

				// Run an empty loop to capture the cost of running the loop.

				for (int i = 0; i <= timesToLoop; i++) {
				}
				stopTime = System.nanoTime();

				// Compute the time, subtract the cost of running the loop
				// from the cost of running the loop and computing square roots.
				// Average it over the number of runs.
				double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime))
						/ timesToLoop;

				System.out.println(averageTime + "");
			}
		}

		public static void goodHashFunctorCollision() {

			for (int size = 100; size <= 2900; size = size + 100) {
				// SETUP TASKS
				ArrayList<String> test = arrayFiller(size);
				testQuad = new QuadProbeHashTable(101, goodHashFunctor);
				// rand = new Random(65);
				testQuad.addAll(test);
				System.out.println(testQuad.numberOfCollisions);
			}
		}

		public static void medHashFunctorCollision() {

			for (int size = 100; size <= 2900; size = size + 100) {
				// SETUP TASKS
				ArrayList<String> test = arrayFiller(size);
				testQuadMediocre = new QuadProbeHashTable(101,
						mediocreHashFunctor);
				testQuadMediocre.addAll(test);
				System.out.println(testQuadMediocre.numberOfCollisions);
			}
		}

		public static void badHashFunctorCollision() {

			for (int size = 100; size <= 2900; size = size + 100) {
				// SETUP TASKS
				ArrayList<String> test = arrayFiller(size);
				testQuadBad = new QuadProbeHashTable(101, badHashFunctor);
				testQuadBad.addAll(test);
				System.out.println(testQuadBad.numberOfCollisions);
			}
		}

		public static void goodHashFunctorContains() {

			for (int size = 100; size <= 2900; size = size + 100) {
				// SETUP TASKS
				ArrayList<String> test = arrayFiller(size);
				testQuad = new QuadProbeHashTable(size, goodHashFunctor);
				testQuad.addAll(test);
				// START TIMING CODE
				long startTime, midpointTime, stopTime;

				// First, spin computing stuff until one second has gone by.
				// This allows this thread to stabilize.
				startTime = System.nanoTime();

				while (System.nanoTime() - startTime < 1000000000) {
				} // empty block

				// Now, run the test.
				int timesToLoop = 10000;

				startTime = System.nanoTime();

				for (int i = 0; i <= timesToLoop; i++) {
				testQuad.containsAll(forContains);
				}
				
				midpointTime = System.nanoTime();
				for (int i = 0; i <= timesToLoop; i++) {}
				// Run a loop without the actual test Code to capture the cost
				// of running the test.

				stopTime = System.nanoTime();

				// Compute the time, subtract the cost of running the loop
				// from the cost of running the loop and computing square roots.
				// Average it over the number of runs.
				double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime))
						/ timesToLoop;

				System.out.println(averageTime);
			}
		}

		public static void medHashFunctorContains() {

			for (int size = 100; size <= 2900; size = size + 100) {
				// SETUP TASKS
				ArrayList<String> test = arrayFiller(size);
				testQuadMediocre = new QuadProbeHashTable(size,
						mediocreHashFunctor);

				testQuadMediocre.addAll(test);

				// START TIMING CODE
				long startTime, midpointTime, stopTime;

				// First, spin computing stuff until one second has gone by.
				// This allows this thread to stabilize.
				startTime = System.nanoTime();

				while (System.nanoTime() - startTime < 1000000000) {
				} // empty block

				// Now, run the test.
				int timesToLoop = 10000;

				startTime = System.nanoTime();
				
				for (int i = 0; i <= timesToLoop; i++) {
				testQuadMediocre.containsAll(forContains);
				}

				midpointTime = System.nanoTime();

				for (int i = 0; i <= timesToLoop; i++) {}
				// Run a loop without the actual test Code to capture the cost
				// of running the test.

				stopTime = System.nanoTime();

				// Compute the time, subtract the cost of running the loop
				// from the cost of running the loop and computing square roots.
				// Average it over the number of runs.
				double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime))
						/ timesToLoop;

				System.out.println(averageTime);
			}
		}

		public static void badHashFunctorContains() {

			for (int size = 100; size <= 2900; size = size + 100) {
				// SETUP TASKS
				ArrayList<String> test = arrayFiller(size);
				testQuadBad = new QuadProbeHashTable(size, badHashFunctor);

				testQuadBad.addAll(test);
				
				// START TIMING CODE
				long startTime, midpointTime, stopTime;

				// First, spin computing stuff until one second has gone by.
				// This allows this thread to stabilize.
				startTime = System.nanoTime();

				while (System.nanoTime() - startTime < 1000000000) {
				} // empty block

				// Now, run the test.
				int timesToLoop = 10000;

				startTime = System.nanoTime();

				for (int i = 0; i < timesToLoop; i++) {
					testQuadBad.containsAll(forContains);
				}

				midpointTime = System.nanoTime();

				// Run a loop without the actual test Code to capture the cost
				// of running the test.
				for (int i = 0; i < timesToLoop; i++) {}
				stopTime = System.nanoTime();

				// Compute the time, subtract the cost of running the loop
				// from the cost of running the loop and computing square roots.
				// Average it over the number of runs.
				double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime))
						/ timesToLoop;

				System.out.println(averageTime);
			}
		}

		public static ArrayList<String> readFromFile(File file) {
			ArrayList<String> words = new ArrayList<String>();

			try {
				/*
				 * Java's Scanner class is a simple lexer for Strings and
				 * primitive types (see the Java API, if you are unfamiliar).
				 */
				Scanner fileInput = new Scanner(file);

				/*
				 * The scanner can be directed how to delimit (or divide) the
				 * input. By default, it uses whitespace as the delimiter. The
				 * following statement specifies anything other than alphabetic
				 * characters as a delimiter (so that punctuation and such will
				 * be ignored). The string argument is a regular expression that
				 * specifies "anything but an alphabetic character". You need
				 * not understand any of this for the assignment.
				 */
				fileInput.useDelimiter("\\s*[^a-zA-Z]\\s*");

				while (fileInput.hasNext()) {
					String s = fileInput.next();

					if (!s.equals(""))
						words.add(s.toLowerCase());
				}

			} catch (FileNotFoundException e) {
				System.err.println("File " + file + " cannot be found.");
			}

			return words;
		}

		// fills the array
		private static ArrayList<String> arrayFiller(int size) {
			LinkedList<String> listTemp = new LinkedList<String>();
			ArrayList<String> arrayTemp = new ArrayList<String>(size);
			Random rnd = new Random();
			for (int i = 0; i < size; i++) {
				arrayTemp.add((String) dictionary.get(i));
			}
			for (int i = 0; i < arrayTemp.size(); i++) {
				String a = arrayTemp.get(i);
				int index = rnd.nextInt(arrayTemp.size());
				arrayTemp.set(i, arrayTemp.get(index));
				arrayTemp.set(index, a);

			}
			return arrayTemp;

		}
	}
