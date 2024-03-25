package DataAccessLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Data.DbConnection;
import DataAccessAbstractions.INutritionDao;
import Models.Nutrition;

public class NutritionDAO implements INutritionDao {
    private DbConnection dbConnection;

    public NutritionDAO() {
        this.dbConnection = DbConnection.getInstance();
    }

    public boolean createNutrition(Nutrition nutrition) {
        String sql = "INSERT INTO nutrition (nutrition_id, title, description) VALUES (?, ?, ?)";
        try {
            dbConnection.openConnection();
            Connection conn = dbConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, nutrition.getNutritionId());
            pstmt.setString(2, nutrition.getTitle());
            pstmt.setString(3, nutrition.getDescription());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println("Error creating nutrition: " + e.getMessage());
            return false;
        } finally {
            dbConnection.closeConnection();
        }
    }

    public Nutrition readNutrition(int nutritionId) {
        String sql = "SELECT * FROM nutrition WHERE nutrition_id = ?";
        Nutrition nutrition = null;
        try {
            dbConnection.openConnection();
            Connection conn = dbConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, nutritionId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                nutrition = new Nutrition(rs.getInt("nutrition_id"),
                        rs.getString("title"),
                        rs.getString("description"));
            }
            return nutrition;
        } catch (SQLException e) {
            System.out.println("Error reading nutrition: " + e.getMessage());
            return null;
        } finally {
            dbConnection.closeConnection();
        }
    }

    public boolean updateNutrition(Nutrition nutrition) {
        String sql = "UPDATE nutrition SET title = ?, description = ? WHERE nutrition_id = ?";
        try {
            dbConnection.openConnection();
            Connection conn = dbConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nutrition.getTitle());
            pstmt.setString(2, nutrition.getDescription());
            pstmt.setInt(3, nutrition.getNutritionId());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println("Error updating nutrition: " + e.getMessage());
            return false;
        } finally {
            dbConnection.closeConnection();
        }
    }

    public boolean deleteNutrition(int nutritionId) {
        String sql = "DELETE FROM nutrition WHERE nutrition_id = ?";
        try {
            dbConnection.openConnection();
            Connection conn = dbConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, nutritionId);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println("Error deleting nutrition: " + e.getMessage());
            return false;
        } finally {
            dbConnection.closeConnection();
        }
    }
}
