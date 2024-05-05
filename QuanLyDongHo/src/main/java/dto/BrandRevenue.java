package dto;

public class BrandRevenue {
	String brandName;
	int total_sold;
	
	public BrandRevenue(){}
	public BrandRevenue(String brandName, int total_sold){
		this.brandName = brandName;
		this.total_sold = total_sold;
	}
	
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public int getTotal_sold() {
		return total_sold;
	}
	public void setTotal_sold(int total_sold) {
		this.total_sold = total_sold;
	}
	
	
}
