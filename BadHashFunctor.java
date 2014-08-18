package assignment8;

public class BadHashFunctor implements HashFunctor

	{

		public int hash(String item) {
			// alphabetical
			int hashValue = 0;
			for (int i = 0; i < item.length(); i++) {
				char letterInQuestion = item.charAt(i);
				switch (letterInQuestion) {
				case 'a':
					hashValue = hashValue + 1;
					break;
				case 'b':
					hashValue = hashValue + 2;
					break;
				case 'c':
					hashValue = hashValue + 3;
					break;
				case 'd':
					hashValue = hashValue + 4;
					break;
				case 'e':
					hashValue = hashValue + 5;
					break;
				case 'f':
					hashValue = hashValue + 6;
					break;
				case 'g':
					hashValue = hashValue + 7;
					break;
				case 'h':
					hashValue = hashValue + 8;
					break;
				case 'i':
					hashValue = hashValue + 9;
					break;
				case 'j':
					hashValue = hashValue + 10;
					break;
				case 'k':
					hashValue = hashValue + 11;
					break;
				case 'l':
					hashValue = hashValue + 12;
					break;
				case 'm':
					hashValue = hashValue + 13;
					break;
				case 'n':
					hashValue = hashValue + 14;
					break;
				case 'o':
					hashValue = hashValue + 15;
					break;
				case 'p':
					hashValue = hashValue + 16;
					break;
				case 'q':
					hashValue = hashValue + 17;
					break;
				case 'r':
					hashValue = hashValue + 18;
					break;
				case 's':
					hashValue = hashValue + 19;
					break;
				case 't':
					hashValue = hashValue + 20;
					break;
				case 'u':
					hashValue = hashValue + 21;
					break;
				case 'v':
					hashValue = hashValue + 22;
					break;
				case 'w':
					hashValue = hashValue + 23;
					break;
				case 'x':
					hashValue = hashValue + 24;
					break;
				case 'y':
					hashValue = hashValue + 25;
					break;
				case 'z':
					hashValue = hashValue + 26;
					break;
				}

			}

			return hashValue;
		}

	}