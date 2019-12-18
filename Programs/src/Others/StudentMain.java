package Others;

public class StudentMain
{
	public static void main(String[] args)
	{
		Student sm=new Student();
		sm.setName("Manya");
		sm.setRollno(23);
		sm.setPerc(65.54);
		sm.setSection("8b");
	
		Student sm1=new Student();
		sm1.setName("Manyatha");
		sm1.setRollno(35);
		sm1.setPerc(56.54);
		sm1.setSection("8c");
		
		Student sm2=new Student();
		sm2.setName("Manvitha");
		sm2.setRollno(64);
		sm2.setPerc(87.54);
		sm2.setSection("9c");
		
		Object obj[]= {sm,sm1,sm2};
		for (Object stu : obj) {
			System.out.println(stu);
		}
	}
}
