/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bll;

import java.util.ArrayList;

import dao.ExportInvoiceDAO;
import dao.WarrantyDAO;
import dto.Warranty;

public class WarrantyBLL {

    private WarrantyDAO warrantyDAO;
    
    public static WarrantyBLL getInstance() {
		return new WarrantyBLL();
	}
    

    public boolean addWarranty(Warranty object) {
		return WarrantyDAO.getInstance().create(object);
	}
    
    public boolean updateStatus1(int id) {
        return WarrantyDAO.getInstance().updateStatus(id);
    }
    
    public ArrayList<Warranty> getAllData(){
    	return WarrantyDAO.getInstance().readAllData();
    }
    // Add other methods for retrieving, updating, or processing warranty data
}
