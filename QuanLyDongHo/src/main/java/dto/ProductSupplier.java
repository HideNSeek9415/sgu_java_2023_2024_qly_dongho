package dto;

public class ProductSupplier {
    private int productId;
    private int supplierId;

    public ProductSupplier(int productId, int supplierId) {
        this.productId = productId;
        this.supplierId = supplierId;
    }

    // Getters and setters
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

}
