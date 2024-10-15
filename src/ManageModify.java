/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Dell
 */
public class ManageModify {
    public static List<Manager> findAll() {
        List<Manager> managerList = new ArrayList<>();
        
        Connection connection = null;
        Statement statement = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thuyettrinh", "root", "");
            
            String sql = "select * from quanli";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {                
                Manager mng = new Manager(resultSet.getInt("ID"), 
                resultSet.getString("Name"),
                resultSet.getString("Gender"), 
                resultSet.getString("MaKH"), resultSet.getString("MaHoaDon"), 
                resultSet.getString("Ngay"));
                managerList.add(mng);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManageModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ManageModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ManageModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }}
         return managerList;
    }
     public static void insert(Manager mng) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thuyettrinh", "root", "");
            
            //query
            String sql = "insert into quanli(Name, Gender, MaKH, MaHoaDon, Ngay) values(?, ?, ?, ?, ?)";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, mng.getName());
            statement.setString(2, mng.getGender());
            statement.setString(3, mng.getMaKH());
            statement.setString(4, mng.getMaHoaDon());
            statement.setString(5, mng.getNgay());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ManageModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ManageModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ManageModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    public static void update(Manager mng) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thuyettrinh", "root", "");
            
            //query
            String sql = "update quanli set Name=?,Gender=?,MaKH=?,MaHoaDon=?,Ngay=? where ID = ?";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, mng.getName());
            statement.setString(2, mng.getGender());
            statement.setString(3, mng.getMaKH());
            statement.setString(4, mng.getMaHoaDon());
            statement.setString(5, mng.getNgay());
            statement.setInt(6, mng.getID());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ManageModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ManageModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ManageModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public static void delete(int ID) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thuyettrinh", "root", "");
            
            String sql = "delete from quanli where ID = ?";
            statement = connection.prepareCall(sql);
            
            statement.setInt(1,ID);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ManageModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ManageModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ManageModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public static List<Manager> findByName(String Name) {
        List<Manager> managerList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thuyettrinh", "root", "");
            
            //query
            String sql = "select * from quanli where Name like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+Name+"%");
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                Manager mng = new Manager(resultSet.getInt("ID"), 
                        resultSet.getString("Name"),
                        resultSet.getString("Gender"), 
                        resultSet.getString("MaKH"), resultSet.getString("MaHoaDon"), 
                        resultSet.getString("Ngay"));
                managerList.add(mng);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManageModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ManageModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ManageModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return managerList;
    }
}


