package bll;

import dao.ThongKeDAO;
import dto.BrandRevenue;
import dto.CustomerRevenue;

import java.sql.SQLException;
import java.util.ArrayList;

public class ThongKeBLL {
    private static ThongKeBLL instance;
    private ThongKeDAO thongKeDAO;

    // Phương thức instance
    public static ThongKeBLL getInstance() {
        if (instance == null) {
            instance = new ThongKeBLL();
        }
        return instance;
    }

    private ThongKeBLL() {
        // Khởi tạo đối tượng ThongKeDAO
        thongKeDAO = ThongKeDAO.getInstance();
    }

    public int getTotalRevenue(int year) throws SQLException {
        // Gọi phương thức từ DAO để lấy tổng doanh thu cho một năm cụ thể
        return thongKeDAO.getTotalRevenue(year);
    }

    public ArrayList<CustomerRevenue> getCustomerTotalRevenue() throws SQLException {
        // Gọi phương thức từ DAO để lấy thông tin về tổng doanh thu của từng khách hàng
        return thongKeDAO.getCustomerTotalRevenue();
    }
    
    public ArrayList<BrandRevenue> getBrandTotalRevenue() throws SQLException {
        // Gọi phương thức từ DAO để lấy thông tin về tổng doanh thu của từng khách hàng
        return thongKeDAO.getBrandTotalRevenue();
    }
}
