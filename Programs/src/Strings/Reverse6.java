package Strings;
import java.util.Scanner;
public class Reverse6 
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the string");
		String st=sc.nextLine();
		String rev=" ";
		char ch[]=st.toCharArray();
		for(int i=0;i<ch.length;i++)
		{
			if(i%2==0)
			{
			int j=i;
			while(i<ch.length && ch[i]!=' ')
			{
				i++;
			}
			int k=i-1;
			while(k>=j)
			{
				rev=rev+ch[k];
				k--;
			}
			if(i<ch.length)
			{
				rev=rev+ch[i];
			}
			System.out.println(rev);
			}
		else
		{
			System.out.println(st);
		}
		}
	}
}
		

