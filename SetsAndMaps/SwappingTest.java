package SetsAndMaps;

import java.util.Iterator;

public class SwappingTest
{	
	public static void main (String [] args)
	{
		Map<String, String> clothes = new ArrayMap<>();
		//Map<String, String> clothes = new LinkedMap<>();
		
		clothes.add("overalls", "green");
		clothes.add("spacesuit", "striped");
		clothes.add("nightshirt", "orange");
		clothes.add("jumpsuit", "purple");
		clothes.add("air muffs", "purple");
		
		System.out.println("Galaxer @!#3w's wardrobe:\n");
		Iterator<String> iter = clothes.iterator();
		while(iter.hasNext())
		{
			String f = iter.next();
			System.out.println(f + "\t" + clothes.get(f));
		}
		
		System.out.println("\n@!#3w would like to switch the colors of its jumpsuit and overalls");
		System.out.println("The color of the first item swapped: " + clothes.get("jumpsuit"));
		
		System.out.println("\nGalaxer @!#3w's wardrobe after the swap:\n");
		clothes.swapValues("jumpsuit", "overalls");
		
		Iterator<String> iter2 = clothes.iterator();
		while(iter2.hasNext())
		{
			String f = iter2.next();
			System.out.println(f + "\t" + clothes.get(f));
		}
		
		System.out.println("\n@!#3w would also like to switch the colors of its swimsuit and pajamas");
		System.out.println("The color of the first item swapped: " + clothes.get("swimsuit"));
		if(clothes.get("swimsuit") == null)
		{
			System.out.println("Hmm, it seems like @!#3w doesn't own a swimsuit\n");
		}
		else
		{
			clothes.swapValues("swimsuit", "pajamas");
		}
		
		System.out.println("@!#3w's wardrobe after the swap (no change):\n");
		Iterator<String> iter3 = clothes.iterator();
		while(iter3.hasNext())
		{
			String f = iter3.next();
			System.out.println(f + "\t" + clothes.get(f));
		}
	}
}