package Strings;
import java.util.Scanner;
public class Reverse7 
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the string");
		String st=sc.nextLine();
		String rw=reverseWord(st);
		System.out.println("The new String is:"+rw);
	}

	 static String reverseWord(String st) 
	 {
		 String s[]=st.split(" ");
			String rw="";
			for (int i = 0; i < s.length; i++) {
				if(i==0) {
				rw+=s[s.length-1]+" ";
				} else if(i%2==0) {
					rw+=s[i-2]+" ";
				} else {
					rw+=s[i]+" ";
				}
			}
			return rw;
	}
}
