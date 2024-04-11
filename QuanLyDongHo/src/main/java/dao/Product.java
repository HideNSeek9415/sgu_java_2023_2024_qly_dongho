package dto;

public class Product {
    private int id;
    private String productName;
    private String category;
    private String brand;
    private double salePrice;
    private double discount;
    private double discountPrice;
    private int quantity;
    private String productStatus;
    private String imageUrl;

    public Product(int id, String productName, String category, String brand, double salePrice, double discount, double discountPrice, int quantity, String productStatus, String imageUrl) {
        this.id = id;
        this.productName = productName;
        this.category = category;
        this.brand = brand;
        this.salePrice = salePrice;
        this.discount = discount;
        this.discountPrice = discountPrice;
        this.quantity = quantity;
        this.productStatus = productStatus;
        this.imageUrl = imageUrl;
    }

    public Product() {
    	
    }
    

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

