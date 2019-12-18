package Strings;
import java.util.Scanner;
public class Reverse3 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the string");
		String st=sc.nextLine();
		System.out.println("The new string is:"+countWord(st));
		
	}
	public static String countWord(String st) {
		String sw[]=st.split(" ");
		String st1="";
		for (int i = 0; i < sw.length; i++) {
			st1 = st1 +" "+ sw[i]+sw[i].length();
		}
		return st1;
	}
	
}
