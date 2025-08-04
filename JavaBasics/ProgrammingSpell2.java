package JavaBasics;
//deciphers a message
//Kendall McCullom

public class ProgrammingSpell2 
{
	// reverses the characters in a string
	public static String reverse(String s) 
	{
		String reversedString = "";
		for (int i = s.length() - 1; i >= 0; i--) 
		{
			char ch = s.charAt(i);
			reversedString += ch;
		}
		return reversedString;
	}

	// prints every third word reversed, and all remaining even-indexed words as is
	public static void castTheSpell(String[] w) 
	{
		int spaceCount = 0;
		String [] spaces1 = new String [w.length];
		
		for (int i = 0; i < w.length; i++) 
		{
			if (i % 3 == 0) 
			{	
				spaces1 [spaceCount] = reverse(w[i]);
				spaceCount++;
			}
			else if (i % 2 == 0 && i % 3 != 0) 
			{
				spaces1 [spaceCount] = w[i];
				spaceCount++;
			}
		}

		for (int k = 0; k < spaceCount; k++)
		{
			if (k!=0 && k%5==0) //&& spaces1[k]!=null)
			{
				System.out.print("\n" + spaces1[k]);
			}
			else
			{
				System.out.print(spaces1[k]+ " ");
			}
		}
	}

	public static void main(String[] args) 
	{
		String[] words = { "elbuoD", "Thrice", "double,", "liot", "and", "anxiety", "elbuort", "Water", "Fire", "nrub",
				"and", "but", "nordluac", "stew", "bubble", "nohtyP", "is", "cisaB", "tsuj", "very", "so", "éssap",
				"Java", "Perl", "won", "then", "rules", "eht", "day!", "night!" };
		System.out.println("Here is the spell that was cast:");
		castTheSpell(words);
	}
}
