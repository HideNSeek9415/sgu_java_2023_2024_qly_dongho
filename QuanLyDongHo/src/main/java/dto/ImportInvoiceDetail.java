package dto;

public class ImportInvoiceDetail {
    private int detailsId;
    private int importInvoiceId;
    private int productId;
    private int quantity;
    private int importPrice;
    
    private String productName;

    public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}


    public ImportInvoiceDetail(int detailsId, int importInvoiceId, int productId, int quantity, int importPrice) {
        this.detailsId = detailsId;
        this.importInvoiceId = importInvoiceId;
        this.productId = productId;
        this.quantity = quantity;
        this.importPrice = importPrice;
    }

    public int getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(int detailsId) {
        this.detailsId = detailsId;
    }

    public int getImportInvoiceId() {
        return importInvoiceId;
    }

    public void setImportInvoiceId(int importInvoiceId) {
        this.importInvoiceId = importInvoiceId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(int importPrice) {
        this.importPrice = importPrice;
    }

}

