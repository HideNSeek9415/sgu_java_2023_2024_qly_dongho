package dto;

import dao.EmployeeDAO;
import dao.SupplierDAO;
import java.sql.Date;
import java.util.ArrayList;

public class ImportInvoice {
    private int importInvoiceId;
    private int employeeId;
    private int supplierId;
    private Date invoiceDate;
    private String fullNameEmployee;
    private String supplierName;
    private ArrayList<ImportInvoiceDetail> details = new ArrayList<>();

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }


    
    
public String getFullNameEmployee() {
        return fullNameEmployee;
    }

    public void setFullNameEmployee(String fullNameEmployee) {
        this.fullNameEmployee = fullNameEmployee;
    }
    
    public ArrayList<ImportInvoiceDetail> getDetails() {
		return details;
	}

	public void setDetails(ArrayList<ImportInvoiceDetail> details) {
		this.details = details;
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
    
    public void setEmployeeFullName() {
        Employee employee = EmployeeDAO.getInstance().readByID(employeeId);
        if (employee != null) {
            fullNameEmployee = employee.getFullName();
        } else {
            fullNameEmployee = "";
        }
    }
    
    public void setSupplierFullName() {
    Supplier supplier = SupplierDAO.getInstance().readByID(supplierId);
    if (supplier != null) {
        supplierName = supplier.getSupplierName();
    } else {
        supplierName = "";
    }
}
}

