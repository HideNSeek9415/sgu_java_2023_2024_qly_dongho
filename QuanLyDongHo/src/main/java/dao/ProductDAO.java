package dao;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dto.Product;

public class ProductDAO {
    private Connection connection;

    public ProductDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Product> getAllProducts() throws SQLException {
        List<Product> productList = new ArrayList<>();
        String query = "SELECT * FROM products";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

        	while (resultSet.next()) {
        		Product product = new Product(
                        resultSet.getInt("id"),
                        resultSet.getString("product_name"),
                        resultSet.getString("category"),
                        resultSet.getString("brand"),
                        resultSet.getDouble("sale_price"),
                        resultSet.getDouble("discount"),
                        resultSet.getDouble("discount_price"),
                        resultSet.getInt("quantity"),
                        resultSet.getString("product_status"),
                        resultSet.getString("image_url")
                );
                productList.add(product);
            }
        }

        return productList;
    }
}
