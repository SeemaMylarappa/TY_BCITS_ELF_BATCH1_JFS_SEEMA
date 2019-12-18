package Others;

public class Product 
{
	private String pdname;
	private int pdid;
	private double price;
	public String getPdname() {
		return pdname;
	}
	public void setPdname(String pdname) {
		this.pdname = pdname;
	}
	public int getPdid() {
		return pdid;
	}
	public void setPdid(int pdid) {
		this.pdid = pdid;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString()
	{
		return "ProductDetails:\n  pdname:"+pdname+"\n pdid:"+pdid+"\n  price:"+price;
		}
	
	
}
