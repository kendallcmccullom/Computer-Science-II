package StacksAndQueues;

//uses two stacks to perform calculations
//Kendall McCullom

import java.util.Scanner;

public class Calculate
{
	//returns true if item is an arithmetic operator
	public static boolean isOperator(String s)
	{
		if(s.equals("/") || s.equals("*")|| s.equals("+") || s.equals("-"))
		{
			return true;
		}
		return false;
	}				

	//performs arithmetic computation and returns result
	public static double performComputation(double one, double two, String o)
	{
		double solution = 0.0;
		if (o.equals("+"))
		{
			solution = one + two;
		}
		else if (o.equals("-"))
		{
			solution = two - one;
		}
		else if (o.equals("*"))
		{
			solution = one * two;
		}
		else if (o.equals("/"))
		{
			solution = two / one;
		}
		return solution;
	}

	public static void main (String [] args)
	{	
		Stack<String> operators = new ArrayStack< >(); 	
		Stack<Double> numbers = new LinkedStack< >(); 
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an expression to evaluate: ");
		String equation = input.nextLine();
		
		String[] splitted = equation.split(" ");
		
		Double answer = 0.0;
		
		for (int i = 0; i<splitted.length; i++)
		{
			if (splitted[i].equals("(") || splitted[i].equals("")) //second condition is if there are too many spaces when inputed by user
			{
				continue;
			}
			else if (isOperator(splitted[i]))
			{
				operators.push(splitted[i]);
			}
			else if (splitted[i].equals(")"))
			{
				double v1 = numbers.pop();
				double v2 = numbers.pop();
				String symbol = operators.pop();
				answer = performComputation(v1,v2,symbol);
				numbers.push(answer);
			}
			else if ((int)splitted[i].charAt(0) >=48 && (int)splitted[i].charAt(0) <=57)
			{
				Double doub =  Double.valueOf(splitted[i]);
				numbers.push(doub);
			}
			else
			{
				answer = null;
			}
		}
		
		if (answer == null)
		{
			System.out.println("Couldn't recognize a character, could not compute equation.");
		}
		else
		{
			System.out.println("Answer: " + answer);
		}
		input.close();
	}
}
