package dto;

import java.sql.Date;
import java.util.ArrayList;

public class ImportInvoice {
    private int importInvoiceId;
    private int employeeId;
    private int supplierId;
    private Date invoiceDate;
    private ArrayList<ImportInvoiceDetail> details = new ArrayList<>();
    
    private String employeeName;
    private String supplierName;

    public ArrayList<ImportInvoiceDetail> getDetails() {
		return details;
	}

	public void setDetails(ArrayList<ImportInvoiceDetail> details) {
		this.details = details;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

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

