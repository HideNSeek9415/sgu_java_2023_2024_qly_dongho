package dto;

public class Supplier {
    private int supplierId;
    private String supplierName;
    private String email;
    private String supplierStatus;
    private String phoneNumber;

    public Supplier(int supplierId, String supplierName, String email, String supplierStatus, String phoneNumber) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.email = email;
        this.supplierStatus = supplierStatus;
        this.phoneNumber = phoneNumber;
    }

    // Getters and setters
    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getSupplierStatus() {
        return supplierStatus;
    }

    public void setSupplierStatus(String supplierStatus) {
        this.supplierStatus = supplierStatus;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}