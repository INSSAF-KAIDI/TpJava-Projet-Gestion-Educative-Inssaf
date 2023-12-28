package src.services;

import dbconnection.DatabaseConnector;
import models.Departement;
import models.Enseignant;
import models.Departement;
import services.EnseignantServices;

import java.sql.*;
import java.util.ArrayList;

public class DepartementServices {

    public static void registerJDBCDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //  Enseignant... chef which can accept zero or more Enseignant

    public static Departement addDept(String intitule, Enseignant... chef) {
        String sql = "INSERT INTO departements (intitule, chef_id) VALUES (?, ?)";
        Departement departement = new Departement();

        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, intitule);
            if (chef.length > 0 && chef[0] != null) {
                pstmt.setInt(2, chef[0].getId());
            } else {
                pstmt.setNull(2, java.sql.Types.INTEGER);
            }

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        departement.setId(generatedKeys.getInt(1));
                        departement.setIntitule(intitule);
                        if (chef.length > 0 && chef[0] != null) {
                            departement.setChef(chef[0]);
                        }
                    } else {
                        throw new SQLException("La création du département a échoué, aucun ID obtenu.");
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return departement;
    }

    public static Departement updateDept(int id, String intitule, Enseignant... chef) {
        String sql = "UPDATE departements SET intitule = ?, chef_id = ? WHERE id = ?";

        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, intitule);
            if (chef.length > 0 && chef[0] != null) {
                pstmt.setInt(2, chef[0].getId());
            } else {
                pstmt.setNull(2, java.sql.Types.INTEGER);
            }
            pstmt.setInt(3, id);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                return getDeptById(id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static boolean deleteDeptById(int id) {
        String sql = "DELETE FROM departements WHERE id = ?";

        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Departement getDeptById(int deptId) {
        String sql = "SELECT * FROM departements WHERE id = ?";
        Departement departement = null;

        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, deptId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String intitule = rs.getString("intitule");
                    Integer chefId = (rs.getInt("chef_id") != 0) ? rs.getInt("chef_id") : null; // Assuming chef_id can be null

                    departement = new Departement();
                    departement.setId(deptId);
                    departement.setIntitule(intitule);
                    // Optionally handle the chefId to set the chef of the department
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Or handle the exception as per your application's standards
        }

        return departement;
    }

    public static ArrayList<Departement> getAllDept() {
        ArrayList<Departement> departements = new ArrayList<>();
        String sql = "SELECT id, intitule, chef_id FROM departements";

        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Departement departement = new Departement();
                departement.setId(rs.getInt("id"));
                departement.setIntitule(rs.getString("intitule"));

                int chefId = rs.getInt("chef_id");
                if (!rs.wasNull()) {
                    Enseignant chef = EnseignantServices.getEnsById(chefId); // Implement this method
                    departement.setChef(chef);
                }
                departements.add(departement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departements;
    }
}