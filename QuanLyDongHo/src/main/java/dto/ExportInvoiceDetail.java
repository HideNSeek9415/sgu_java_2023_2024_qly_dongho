package dto;

public class ExportInvoiceDetail {
    private int detailsId;
    private int exportInvoiceId;
    private int productId;
    private int sellPrice;
    
    private String productName;
    private Warranty warranty;

    public Warranty getWarranty() {
		return warranty;
	}

	public void setWarranty(Warranty warranty) {
		this.warranty = warranty;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public ExportInvoiceDetail(int detailsId, int exportInvoiceId, int productId, int sellPrice) {
        this.detailsId = detailsId;
        this.exportInvoiceId = exportInvoiceId;
        this.productId = productId;
        this.sellPrice = sellPrice;
    }

    // Getters and setters
    public int getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(int detailsId) {
        this.detailsId = detailsId;
    }

    public int getExportInvoiceId() {
        return exportInvoiceId;
    }

    public void setExportInvoiceId(int exportInvoiceId) {
        this.exportInvoiceId = exportInvoiceId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }

}

