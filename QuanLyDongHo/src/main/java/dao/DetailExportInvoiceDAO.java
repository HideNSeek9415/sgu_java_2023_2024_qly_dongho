/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.ExportInvoiceDetail;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ThaiSon
 */
public class DetailExportInvoiceDAO extends ObjectDAO implements ICrud<ExportInvoiceDetail> {

    public static DetailExportInvoiceDAO getInstance() {
        return new DetailExportInvoiceDAO();
    }

    public boolean create(ExportInvoiceDetail Obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ExportInvoiceDetail readByID(int ID) {
        ExportInvoiceDetail exportDetail = null;
        String sql = "SELECT * FROM export_invoice_details WHERE export_invoice_id = ?";
        try {
            rs = runQuery2(sql, ID);
            if (rs.next()) {
                exportDetail = new ExportInvoiceDetail(
                        rs.getInt("details_id"),
                        rs.getInt("export_invoice_id"),
                        rs.getInt("product_id"),
                        rs.getInt("sell_price")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exportDetail;
    }

    public ArrayList<ExportInvoiceDetail> readAllData(int ID) {
        ArrayList<ExportInvoiceDetail> exportDetails = new ArrayList<>();
        String sql = "SELECT * FROM export_invoice_details WHERE export_invoice_id = ?";
        try {
            rs = runQuery2(sql, ID);
            while (rs.next()) {
                ExportInvoiceDetail exportDetail = new ExportInvoiceDetail(
                        rs.getInt("details_id"),
                        rs.getInt("export_invoice_id"),
                        rs.getInt("product_id"),
                        rs.getInt("sell_price")
                );
                exportDetails.add(exportDetail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exportDetails;
    }

    public boolean update(int ID, ExportInvoiceDetail Obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean recovery(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<ExportInvoiceDetail> readAllData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
