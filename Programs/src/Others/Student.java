package Others;

public class Student
{
	private String name;
	private int rollno;
	private double perc;
	private  String section;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public double getPerc() {
		return perc;
	}
	public void setPerc(double perc) {
		this.perc = perc;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	@Override
	public String toString()
	{
		return  "StudentDetails : \n 	name:" + name + "\n   Rollno:" + rollno + "\n	 perc:" + perc+"\n  section:"+section;
				
	}
	 
	
}

