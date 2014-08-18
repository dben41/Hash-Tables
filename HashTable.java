package assignment8;

import java.util.*;

/**
 * An abstract class facilitating the implementation of a concrete hash table.
 * 
 * @author Paymon Saebi & Daryl Bennett && Leland Stenquist
 * 
 */
public abstract class HashTable implements Set<String>
	{
		protected int size;
		protected double lambda;
		protected int numberOfCollisions;
		

		/**
		 * FILL IN MEMBER VARIABLES!
		 * 
		 * Any member variables that you would maintain in both your
		 * QuadProbeHashTable and your ChainingHashTable (such as, say, a size
		 * variable) probably belong here in the parent class. Should the
		 * variable(s) be public, private, or protected?
		 */

		public final boolean addAll(Collection<? extends String> items) {
			// check lambda value
			boolean itemsWereAdded = false;
					// loop through the collection
//			for (String c : items) {
//				if(!(this.contains(c)))	
//				{
//					this.add(c);
//					itemsWereAdded = true;
//				}
//			}
			for (String c : items) {
				if (this.add(c))
					itemsWereAdded = true;
			}
			// return true if any items were hashed
			return itemsWereAdded;
		}

		public final boolean containsAll(Collection<? extends String> items) {
			boolean itemContained = false;
			for (String c : items) {
				if(this.contains(c))	
				{
					itemContained = true;
				}
			}
			return itemContained;
		}

		public final boolean isEmpty() {
			return size == 0;
		}

		public final int size() {
			return size;
		}
		public double getLambda() {
			return lambda;
		}

		// returns lamda
		
	}
