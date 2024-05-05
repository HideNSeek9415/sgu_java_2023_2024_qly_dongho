/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bll;

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
    
    
    // Add other methods for retrieving, updating, or processing warranty data
}
