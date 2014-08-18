package assignment8;

public class MediocreHashFunctor implements HashFunctor
	{

		@Override
		
		public int hash(String item)

		{

			int hashValue = 0;
			for (int i = 0; i < item.length(); i++)
				hashValue += item.charAt(i);

			return hashValue;  //if hashvalue is greater than capacity, then we do wrapAround

		}
	}
