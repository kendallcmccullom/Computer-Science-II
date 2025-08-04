package JavaBasics;
//deciphers a message
//Kendall McCullom

public class ProgrammingSpell 
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
		String message = "";
		int spaceCount = 0;
		for (int i = 0; i < w.length; i++) 
		{
			if (i % 3 == 0) 
			{
				message += reverse(w[i]) + " ";
				spaceCount++;
			}
			else if (i % 2 == 0 && i % 3 != 0) 
			{
				message += w[i] + " ";
				spaceCount++;
			}
			if (spaceCount % 5 == 0 && spaceCount != 0) 
			{
				spaceCount = 0;
				message += "\r";
			}
		}
		System.out.print(message);
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
