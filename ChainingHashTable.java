package assignment8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ChainingHashTable extends HashTable
	{
		// set variables
		List<String>[] storage;
		HashFunctor hashFunctor;
		static int hashValue;
		int capacity;

		public ChainingHashTable(int capacity, HashFunctor functor) {
			this.storage = new List[capacity]; // make storage an array of lists
			for (int i = 0; i < storage.length; i++)
				// fill that array with linked lists
				storage[i] = new LinkedList<String>();
			hashFunctor = functor; // set hashFunctor to inputted functor
			// lambda is the size of all the lists added together divided by the
			// arrray's size
			this.capacity = storage.length;
		}

		public boolean add(String item) {

			if (getLambda() > 1)
				// if lambda is greater than .5 resize
				reHash();
			if (!this.contains(item)) {
				hashValue = hashFunctor.hash(item);
				hashValue = Math.abs(hashValue) % storage.length; // hash the
																	// value
				if (hashValue < 0) // the book has it in it
					hashValue += storage.length;
				storage[hashValue].add(item);
				size++;
				setLambda();
				return true;
			}
			// TODO Auto-generated method stub
			return false;
		}

		public void clear() {
			// TODO Auto-generated method stub
			for (int i = 0; i < storage.length; i++)
				storage[i].clear();
			size = 0;
		}

		public boolean contains(String item) {
			hashValue = hashFunctor.hash(item);
			hashValue = Math.abs(hashValue) % storage.length; // hash the value
			if (hashValue < 0) // the book has it in it
				hashValue += storage.length;
			if (!(storage[hashValue].isEmpty()))
				numberOfCollisions++;
			for (int i = 0; i < storage[hashValue].size(); i++)
				if (storage[hashValue].get(i).equals(item)){
					return true;
				}
			// TODO Auto-generated method stub
			return false;
		}

		public void reHash() {
			// double the array size, and add a few to make it prime
			int newSize = findPrime(this.storage.length * 2);

			ArrayList<String> holder = new ArrayList(); // temp
			storage = new List[newSize]; // make new storage with
											// new size
			for (int i = 0; i < storage.length; i++)
				// fill that array with linked lists
				storage[i] = new LinkedList<String>();
			this.size = 0;
			lambda = 0;
			this.addAll(holder);
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

		public void setLambda() {
			lambda = (double) size / storage.length;
		}
	}
