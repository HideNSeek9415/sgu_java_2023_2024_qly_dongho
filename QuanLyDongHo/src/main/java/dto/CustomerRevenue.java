package dto;

public class CustomerRevenue {
    private String customerName;
    private int totalRevenue;

    public CustomerRevenue(String customerName, int totalRevenue) {
        this.customerName = customerName;
        this.totalRevenue = totalRevenue;
    }


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(int totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
