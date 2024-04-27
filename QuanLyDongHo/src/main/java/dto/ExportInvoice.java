package dto;

import java.util.ArrayList;
import java.util.Date;

public class ExportInvoice {
    private int exportInvoiceId;
    private int employeeId;
    private int customerId;
    private Date invoiceDate;
	private ArrayList<ImportInvoiceDetail> details = new ArrayList<>();
    
    private String employeeName;
    private String customerName;
    
    public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

    public ArrayList<ImportInvoiceDetail> getDetails() {
		return details;
	}

	public void setDetails(ArrayList<ImportInvoiceDetail> details) {
		this.details = details;
	}

	public ExportInvoice(int exportInvoiceId, int employeeId, int customerId, Date invoiceDate) {
        this.exportInvoiceId = exportInvoiceId;
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.invoiceDate = invoiceDate;
    }

    // Getters and setters
    public int getExportInvoiceId() {
        return exportInvoiceId;
    }

    public void setExportInvoiceId(int exportInvoiceId) {
        this.exportInvoiceId = exportInvoiceId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

}
