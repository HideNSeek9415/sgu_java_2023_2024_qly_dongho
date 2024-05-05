package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.BrandRevenue;
import dto.CustomerRevenue;
import dto.ExportInvoice;

public class ThongKeDAO extends ObjectDAO implements ICrud<ExportInvoice> {

    public static ThongKeDAO getInstance() {
        return new ThongKeDAO();
    }

    private ThongKeDAO() {}

    public int getTotalRevenue(int year) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DataConnection.connect();
            String query = "SELECT SUM(export_invoice_details.sell_price) AS total_revenue " +
                           "FROM export_invoice_details " +
                           "JOIN export_invoices ON export_invoice_details.export_invoice_id = export_invoices.export_invoice_id " +
                           "WHERE YEAR(export_invoices.invoice_date) = ? " +
                           "AND export_invoices.export_invoice_status = 1";
            statement = connection.prepareStatement(query);
            statement.setInt(1, year);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("total_revenue");
            }
        } finally {
            // Close the resources in the finally block to ensure they are always closed
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return 0; 
    }
    
    public ArrayList<CustomerRevenue> getCustomerTotalRevenue() throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<CustomerRevenue> customerRevenueList = new ArrayList<>();

        try {
            connection = DataConnection.connect();
            String query = "SELECT customers.full_name, SUM(export_invoice_details.sell_price) AS total_revenue " +
                           "FROM export_invoices " +
                           "JOIN customers ON export_invoices.customer_id = customers.id " +
                           "JOIN export_invoice_details ON export_invoices.export_invoice_id = export_invoice_details.export_invoice_id " +
                           "WHERE export_invoices.export_invoice_status = 1 " +
                           "GROUP BY customers.full_name";
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String customerName = resultSet.getString("full_name");
                int totalRevenue = resultSet.getInt("total_revenue");

                // Tạo đối tượng CustomerRevenue và thêm vào danh sách
                CustomerRevenue customerRevenue = new CustomerRevenue(customerName, totalRevenue);
                customerRevenueList.add(customerRevenue);
            }
        } finally {
            // Đóng các tài nguyên trong khối finally để đảm bảo chúng luôn được đóng
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return customerRevenueList;
    }


    public ArrayList<BrandRevenue> getBrandTotalRevenue() throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<BrandRevenue> brandRevenueList = new ArrayList<>();

        try {
            connection = DataConnection.connect();
            String query = "SELECT p.brand, COUNT(eid.details_id) AS total_sold " +
	    			    	"FROM products p " +
	    			    	"JOIN export_invoice_details eid ON p.id = eid.product_id " +
	    			    	"JOIN export_invoices ei ON ei.export_invoice_id = eid.export_invoice_id " +
	    			    	"WHERE ei.export_invoice_status = 1 " +
	    			    	"GROUP BY p.brand";

            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String brandName = resultSet.getString("brand");
                int totalRevenue = resultSet.getInt("total_sold");

                // Tạo đối tượng CustomerRevenue và thêm vào danh sách
                BrandRevenue brandRevenue = new BrandRevenue(brandName, totalRevenue);
                brandRevenueList.add(brandRevenue);
            }
        } finally {
            // Đóng các tài nguyên trong khối finally để đảm bảo chúng luôn được đóng
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return brandRevenueList;
    }
    

    @Override
    public boolean create(ExportInvoice Obj) {
        // Implement the create method as per your requirements
        return false;
    }

    @Override
    public ExportInvoice readByID(int ID) {
        // Implement the readByID method as per your requirements
        return null;
    }

    @Override
    public ArrayList<ExportInvoice> readAllData() {
        // Implement the readAllData method as per your requirements
        return null;
    }

    @Override
    public boolean update(int ID, ExportInvoice Obj) {
        // Implement the update method as per your requirements
        return false;
    }

    @Override
    public boolean delete(int id) {
        // Implement the delete method as per your requirements
        return false;
    }

    @Override
    public boolean recovery(int id) {
        // Implement the recovery method as per your requirements
        return false;
    }
}
