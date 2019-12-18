package Patterns;
import java.util.Scanner;
public class Patt1 
{
	public static void main(String[] args)
	{
	  Scanner sc=new Scanner(System.in);
	  System.out.println("enter the n value");
	  int n=sc.nextInt();
	  for(int i=1; i<=n; i++)
	  {
		  for(int j=1; j<=n-i; j++)
		  {
			  System.out.print(" ");
		  }
		  for(int j=1; j<=i; j++)
		  {
			  System.out.print("*");
		  }
		  System.out.println();
	  }
	  for(int i=n-1; i>0; i--)
	  {
		  for(int j=1; j<=n-i; j++)
		  {
			  System.out.print(" ");
		  }
		  for(int j=1; j<=i; j++)
		  {
			  System.out.print("*");
		  }
		  System.out.println();
	  
	}
	}
}
