package Strings;
import java.util.Scanner;
public class Reverse1 
{
public static void main(String[] args)  
{
	Scanner sc=new Scanner(System.in);
	System.out.println("enter the string");
	String st=sc.nextLine();
	String rev=" ";
	char ch[]=st.toCharArray();
	for(int i=ch.length-1;i>0;i--)
	{
		int j=i;
		while(i>=0 && ch[i]!=' ')
		{
			i--;
		}
		int k=i+1;
		while(k<=j)
		{
			rev=rev+ch[k];
			k++;
		}
		if(i>0)
		{
			rev=rev+ch[i];
		}
	}
	System.out.println(rev);
}
}
