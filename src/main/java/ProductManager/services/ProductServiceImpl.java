package ProductManager.services;

import ProductManager.model.Product;
import ProductManager.repository.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = Connect.getConnection();
             pst = con.prepareStatement("select * from product");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getInt("price"));
                product.setComment(rs.getString("comment"));
                products.add(product);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pst.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return products;
    }

    @Override
    public int save(Product product) {
        int result = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            int id = product.getId();
            String name = product.getName();
            int price = product.getPrice();
            String comment = product.getComment();
            con = Connect.getConnection();

            pst = con.prepareStatement("insert  into product(id,name,price,comment)\n" + "value (?,?,?,?)");
            pst.setInt(1, id);
            pst.setString(2, name);
            pst.setInt(3, price);
            pst.setString(4, comment);
            result = pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                pst.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

        @Override
    public Product findById(int id) {
        Product product = new Product();
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = Connect.getConnection();

            pst = con.prepareStatement("SELECT id,name,price,comment from product where id = ?");
            pst.setInt(1,id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getInt("price"));
                product.setComment(rs.getString("comment"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                pst.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return product;
    }

    @Override
    public void update(int id, Product product) {
        int result = 0;
        PreparedStatement pst = null;
        Connection con = null;
        try {
            con = Connect.getConnection();

            pst = con.prepareStatement("UPDATE product SET name = ?, price = ?, comment = ? WHERE  id = ?");

            pst.setString(1, product.getName());
            pst.setInt(2, product.getPrice());
            pst.setString(3,product.getComment());
            pst.setInt(4,product.getId());
            result = pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                pst.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void remove(int id) {
        Connection con = null;
        PreparedStatement pst = null;
        int result = 0;
        try {
            con = Connect.getConnection();

            pst = con.prepareStatement("DELETE FROM product WHERE  id = ?");
            pst.setInt(1,id);
            result = pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                pst.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
