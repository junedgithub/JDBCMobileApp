package MobileApp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MobileDAO {
   static Connection con = null;
   static ResultSet rs = null;
    static String query = null;
    PreparedStatement pstmt = null;

    static List<MobileDTO> mobiles = new ArrayList<>();
    static {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "sql123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addMobile(int modelNo, String modelName, String company, int ram, String camera, double price) {

        query = "insert into mobile_info values(?,?,?,?,?,?)";
        try {
            pstmt= con.prepareStatement(query);
            pstmt.setInt(1,modelNo);
            pstmt.setString(2,modelName);
            pstmt.setString(3,company);
            pstmt.setInt(4,ram);
            pstmt.setString(5,camera);
            pstmt.setDouble(6,price);
            pstmt.executeUpdate();
            System.out.println("Added Successfully!!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList<MobileDTO> searchMobileByCompany(String company) {

        query = "select * from mobile_info where company = ?";

        try {
            pstmt= con.prepareStatement(query);
            pstmt.setString(1,company);
            rs = pstmt.executeQuery();
            while (rs.next())
            {
                int modelNo = rs.getInt(1);
                String modelName = rs.getString(2);
                String company1 = rs.getString(3);
                int ram = rs.getInt(4);
                String camera = rs.getString(5);
                double price = rs.getDouble(6);

                MobileDTO b = new MobileDTO();
                b.setModelNo(modelNo);
                b.setModelName(modelName);
                b.setCompany(company1);
                b.setRam(ram);
                b.setCamera(camera);
                b.setPrice(price);

                mobiles.add(b);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return (ArrayList<MobileDTO>) mobiles;
    }

    public ArrayList<MobileDTO> searchByPrice(double hPrice, double lPrice) {

        query = "select * from mobile_info where price between ? and ?";

        try {
            pstmt= con.prepareStatement(query);
            pstmt.setDouble(1, lPrice);
            pstmt.setDouble(2,hPrice);
            rs = pstmt.executeQuery();
            while (rs.next())
            {
                int modelNo = rs.getInt(1);
                String modelName = rs.getString(2);
                String company1 = rs.getString(3);
                int ram = rs.getInt(4);
                String camera = rs.getString(5);
                double price = rs.getDouble(6);

                MobileDTO b = new MobileDTO();
                b.setModelNo(modelNo);
                b.setModelName(modelName);
                b.setCompany(company1);
                b.setRam(ram);
                b.setCamera(camera);
                b.setPrice(price);

                mobiles.add(b);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
     return (ArrayList<MobileDTO>) mobiles;
    }

    public ArrayList<MobileDTO> searchByRam(int ram) {
        query = "select * from mobile_info where ram = ?";

        try {
            pstmt= con.prepareStatement(query);
            pstmt.setInt(1,ram);
            rs = pstmt.executeQuery();
            while (rs.next())
            {
                int modelNo = rs.getInt(1);
                String modelName = rs.getString(2);
                String company1 = rs.getString(3);
                int ram1 = rs.getInt(4);
                String camera = rs.getString(5);
                double price = rs.getDouble(6);

                MobileDTO b = new MobileDTO();
                b.setModelNo(modelNo);
                b.setModelName(modelName);
                b.setCompany(company1);
                b.setRam(ram);
                b.setCamera(camera);
                b.setPrice(price);

                mobiles.add(b);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

     return (ArrayList<MobileDTO>) mobiles;
    }

    public ArrayList<MobileDTO> searchByCamera(String LmegaPixel,String HmegaPixel) {

        query = "select * from mobile_info where camera between ? and ?";
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1,LmegaPixel);
            pstmt.setString(2,HmegaPixel);
            rs = pstmt.executeQuery();
            while (rs.next())
            {
                int modelNo = rs.getInt(1);
                String modelName = rs.getString(2);
                String company1 = rs.getString(3);
                int ram1 = rs.getInt(4);
                String camera = rs.getString(5);
                double price = rs.getDouble(6);

                MobileDTO b = new MobileDTO();
                b.setModelNo(modelNo);
                b.setModelName(modelName);
                b.setCompany(company1);
                b.setRam(ram1);
                b.setCamera(camera);
                b.setPrice(price);

                mobiles.add(b);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
     return (ArrayList<MobileDTO>) mobiles;
    }

    public void deleteMobile(int modelNo) {

        query = "delete from mobile_info where model_no = ?";

        try {
            pstmt= con.prepareStatement(query);
            pstmt.setInt(1,modelNo);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
