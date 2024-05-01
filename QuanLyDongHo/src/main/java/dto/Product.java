package dto;

public class Product {
    private int id;
    private String productName;
    private String category;
    private String brand;
    private int sellPrice;
    private boolean discount = false;
    private int discountPrice;
    private int quantity;
    private boolean productStatus;
    private String imageUrl;

    public Product(int id, String productName, String category, String brand, int sellPrice, boolean discount, int discountPrice, int quantity, boolean productStatus, String imageUrl) {
        this.id = id;
        this.productName = productName;
        this.category = category;
        this.brand = brand;
        this.sellPrice = sellPrice;
        this.discount = discount;
        this.discountPrice = discountPrice;
        this.quantity = quantity;
        this.productStatus = productStatus;
        this.imageUrl = imageUrl;
    }
    
    public String getStatus() {
    	return getProductStatus() ? getQuantity() > 0 ? isDiscount() ? "Đang giảm giá" : "Đang bán" : "Hết hàng" : "Không còn bán";
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

    public int getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

