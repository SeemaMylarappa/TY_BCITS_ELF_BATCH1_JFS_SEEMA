package Others;

public class ProductMain
{
public static void main(String[] args) 
{
	Product pd1=new Product();
	pd1.setPdname("Biscuit");
	pd1.setPdid(23);
	pd1.setPrice(10);
	
	
	Product pd2=new Product();
	pd2.setPdname("chocolate");
	pd2.setPdid(55);
	pd2.setPrice(30);
	
	Product pd3=new Product();
	pd3.setPdname("books");
	pd3.setPdid(55);
	pd3.setPrice(30);
	
	Object obj[]= {pd1,pd2,pd3};
	for (Object pro : obj) 
	{
		System.out.println(pro);
}
}
}

