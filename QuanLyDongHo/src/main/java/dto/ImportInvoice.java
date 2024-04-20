package dto;

import java.sql.Date;

public class ImportInvoice {
    private int importInvoiceId;
    private int employeeId;
    private int supplierId;
    private Date invoiceDate;

    public ImportInvoice(int importInvoiceId, int employeeId, int supplierId, Date invoiceDate) {
        this.importInvoiceId = importInvoiceId;
        this.employeeId = employeeId;
        this.supplierId = supplierId;
        this.invoiceDate = invoiceDate;
    }

    // Getters and setters
    public int getImportInvoiceId() {
        return importInvoiceId;
    }

    public void setImportInvoiceId(int importInvoiceId) {
        this.importInvoiceId = importInvoiceId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }
}

