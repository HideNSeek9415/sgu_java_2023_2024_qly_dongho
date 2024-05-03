package dto;

import dao.EmployeeDAO;
import dao.SupplierDAO;
import java.util.Date;
import java.util.ArrayList;

public class ImportInvoice {
    private int importInvoiceId;
    private int employeeId;
    private int supplierId;
    private Date invoiceDate;
    public Employee employee;
    public Supplier supplier;
    private ArrayList<ImportInvoiceDetail> details = new ArrayList<>();
    
    public ArrayList<ImportInvoiceDetail> getDetails() {
		return details;
	}

	public void setDetails(ArrayList<ImportInvoiceDetail> details) {
		this.details = details;
	}

	public ImportInvoice(int importInvoiceId, int employeeId, int supplierId, Date date) {
        this.importInvoiceId = importInvoiceId;
        this.employeeId = employeeId;
        this.supplierId = supplierId;
        this.invoiceDate = date;
        employee = EmployeeDAO.getInstance().readByID(employeeId);
        supplier = SupplierDAO.getInstance().readByID(supplierId);
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
    
    public int getTotal() {
    	int total = 0;
    	for (ImportInvoiceDetail iid : details) {
    		total += iid.getQuantity() * iid.getImportPrice();
    	}
    	return total;
    }

}

