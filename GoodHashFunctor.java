package assignment8;

public class GoodHashFunctor implements HashFunctor
	{

		
		public int hash(String item) {
			int hashValue = 0;
			for (int i = 0; i < item.length(); i++) {
				hashValue = 37 * hashValue + item.charAt(i);  //37 because it was good number?
			}
			return hashValue;
		}

	}
