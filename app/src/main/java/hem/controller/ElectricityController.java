package hem.controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import hem.config.DatabaseConnector;
import hem.model.Electricity;

public class ElectricityController {
    private Connection conn;

    public ElectricityController() {
        conn = DatabaseConnector.connect();
    }

    public void addElectricity(Electricity electricity) {
        String sql = "INSERT INTO electricity(name, jam, watt) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, electricity.getName());
            pstmt.setDouble(2, electricity.getJam());
            pstmt.setDouble(3, electricity.getWatt());
            pstmt.executeUpdate();
            System.out.println("Berhasil Tambahkan data");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("error");
        }
    }

    public List<Electricity> getAllElectricity() {
        List<Electricity> list = new ArrayList<>();
        String sql = "SELECT * FROM electricity";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Electricity electricity = new Electricity(
                        rs.getString("name"),
                        rs.getDouble("jam"),
                        rs.getDouble("watt")
                );
                list.add(electricity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public double calculateTotalConsumption() {
        String sql = "SELECT SUM(jam * watt) AS total_consumption FROM electricity";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getDouble("total_consumption");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void clearAllElectricity() {
        String sql = "DELETE FROM electricity";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Berhasil hapus semua data");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
