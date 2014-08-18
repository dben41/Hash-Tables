package assignment8;

import java.util.ArrayList;

public class QuadProbeHashTable extends HashTable
	{
		//
		private String[] storage;
		private HashFunctor hashFunctor;
		private static int hashValue;
		private int capacity;

		public QuadProbeHashTable(int capacity, HashFunctor functor) {
			this.storage = new String[capacity];
			this.hashFunctor = functor;
			this.capacity = storage.length;
		}

		public boolean add(String item) {
			boolean itemWasAdded = false;
			// setLambda();
			if (lambda > .5)
				// if lambda is greater than .5 resize
				reHash();
			if (!this.contains(item)) {
				// hash each item in the collection
				hashValue = hashFunctor.hash(item);
				// hash the value
				hashValue = Math.abs(hashValue) % storage.length - 1; 
				if (hashValue < 0) // the book has it in it
					hashValue += storage.length-1;
				if (hashValue > storage.length-1)
					wrapAround();
				// add at hash value
				if (storage[hashValue] == null) {
					storage[hashValue] = item;
					size++;
					setLambda();
					return true;
				}

				while (storage[hashValue] != null) {
					int j = 1;
					hashValue = hashValue + j * j;
					if (hashValue > storage.length-1)
						wrapAround();
					j++;
				}
				storage[hashValue] = item;
				// increment the capacity
				itemWasAdded = true;
				size++;
				setLambda();
			}
			return itemWasAdded;
		}

		public void clear() {
			for (int i = 0; storage.length > i; i++) {
				this.storage[i] = null;
				size = 0;
				this.setLambda();
			}
		}

		public boolean contains(String item) {
			hashValue = hashFunctor.hash(item);
			hashValue = Math.abs(hashValue); // TODO
			hashValue = hashValue % storage.length - 1; // hash the value
			if (hashValue < 0) // the book has it in it
				hashValue += storage.length-1;
			if (hashValue >= storage.length-1) {
				wrapAround();
			}
			// // add at hash value
			// if (storage[hashValue]==(item))
			// return true;
			if (storage[hashValue] != null)
				numberOfCollisions++;
			while (storage[hashValue] != null) {

				if (storage[hashValue] == (null))
					continue;
				else if (storage[hashValue].equals(item))
					return true;

				int j = 1;
				hashValue = hashValue + j * j;
				if (hashValue > storage.length-1)
					wrapAround();
				j++;
				if (storage[hashValue] == (null))
					continue;
				else if (storage[hashValue].equals(item))
					return true;
			}
			return false;
		}

		public static int findPrime(int oldPrime) {
			// make a for loop that starts on the oldPrime number and stops when
			// it finds a newOne
			int prime = oldPrime;
			for (int i = oldPrime + 1; i < oldPrime + 100; i++) {
				prime = i;
				// check to see if n is a multiple of 2
				if (i % 2 == 0)
					continue; // skip iteration
				if (i == 3 || i == 5 || i == 7 || i == 11) // if it is a small
				// prime number...
				// return it
					return prime;
				// if not, check the odds
				if (i % 3 == 0)
					continue; // skip iteration
				if (i % 5 == 0)
					continue; // skip iteration
				if (i % 7 == 0)
					continue; // skip iteration
				if (i % 11 == 0)
					continue; // skip iteration
				return prime; // the prime number we need
			}
			return 0; // java needs us to put this here, although it should not
			// ever need to get here
		}

		public void reHash() {
			// double the array size, and add a few to make it prime
			int newSize = findPrime(this.storage.length * 2);

			ArrayList<String> holder = new ArrayList(); // temp
			for (int i = 0; i < storage.length - 1; i++) {
				if (storage[i] != null)
					holder.add(storage[i]);
			}
			// make new storage with new size
			String[] replace = new String[newSize];
			this.storage = replace;
			this.size = 0;
			lambda = 0;
			this.addAll(holder);
		}

		public void wrapAround() {
			while (this.storage.length-1 < hashValue)
				hashValue = hashValue - this.storage.length;
		}

		// returns lamda

		// returns lamda
		public double getCapacity() {
			return storage.length;
		}

		public void setLambda() {
			lambda = (double) size / storage.length;
		}
	}
