package Lists;

import java.lang.reflect.Array;
import java.util.Arrays;

public class nurse2 {
	
	//an array of arrays nurseshifts[[0,1,2],[1,2]]
	//index = what number nurse we are on
	//create this string in the man and just everything to null
	public static boolean solve (int [][] shifts, int index, String [] taken, String [] names){
		boolean full = true;
		
		//checking have we filled every shift?
		for (int i =0; i<taken.length; i++){
			if (taken[i]== null) {
				//System.out.println("checking");
				full = false;//
				//System.out.println(full);
			}
			
			
		}
		//base case - done
		if (full){
			return true;
		}
//		if (index==names.length){
//			return false;
//		}
		
		for (int j=0; j<taken.length; j++)
		{
			for (int k=0; k<shifts[index].length; k++)
				
			{
				
				//System.out.println(Arrays.toString(taken));
				//System.out.println(shifts[index][k] + "check");
				if (shifts[index][k] == j && taken[j] == null){
					taken[j]=names[index];
////					//System.out.println(taken[j] + j);
					if (solve(shifts, index+1, taken, names))
					{
						return true;
					}
////						
//				}
//				
//				
				else {
					
					taken[index] = null;
					
				}			
				}			
		}
		}
		
		return false;
	}
	
	public static void main(String [] args)
	{
		int [][] shifts = {{0,4}, {0,2,5,7}, {1,4,6}, {1,2,4}, {4,6}, {2,7}, {0}, {1,3,5}};
		int index = 0;
		String [] taken = {null, null, null, null, null, null, null, null};
		String [] names = {"A","B", "C", "D", "E", "F", "G", "H"};
//		int [][] shifts = {{0,1}, {0}};
//		String [] taken = {null, null};
//		String [] names = {"A", "B"};
		
		
		
		if(solve(shifts, index, taken, names)) {
		//System.out.println(Arrays.toString(taken));
		for (int i = 0; i<names.length; i++)
		{
			System.out.println (i + taken[i]);
		}
		}
		else 
		{
			System.out.print("impossible");
		}
		
		
	}
}
