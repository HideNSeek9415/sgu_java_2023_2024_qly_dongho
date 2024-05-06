package dto;

public class Warranty {
    private int warrantyId;
    private int detailId;
    private String reason;
    private String status;

    public Warranty(int warranty_id, int detailId, String reason, String status) {
    	this.warrantyId=warranty_id;
        this.detailId = detailId;
        this.reason = reason;
        this.status = status;
    }

    public int getWarrantyId() {
        return warrantyId;
    }

    public void setWarrantyId(int warrantyId) {
        this.warrantyId = warrantyId;
    }

    public int getDetailId() {
        return detailId;
    }

    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
