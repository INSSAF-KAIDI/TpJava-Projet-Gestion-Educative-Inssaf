package services;

import dbconnection.DatabaseConnector;
import models.Departement;
import models.Enseignant;

import java.sql.*;
import java.util.ArrayList;

public class EnseignantServices {


    public static Enseignant addEns(String nom, String prenom, String email, String grade, Departement dept) {
        String sql = "INSERT INTO enseignants (nom, prenom, email, grade, departement_id) VALUES (?, ?, ?, ?, ?)";
        Enseignant enseignant = null;

        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, nom);
            pstmt.setString(2, prenom);
            pstmt.setString(3, email);
            pstmt.setString(4, grade);
            pstmt.setInt(5, dept.getId());

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int id = generatedKeys.getInt(1);
                        enseignant = new Enseignant(id, nom, prenom, email, grade, dept);
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return enseignant;
    }

    public static Enseignant updateEns(int id, String nom, String prenom, String email, String grade, Departement dept) {
        String sql = "UPDATE enseignants SET nom = ?, prenom = ?, email = ?, grade = ?, departement_id = ? WHERE id = ?";

        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nom);
            pstmt.setString(2, prenom);
            pstmt.setString(3, email);
            pstmt.setString(4, grade);
            pstmt.setInt(5, dept.getId());
            pstmt.setInt(6, id);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                return new Enseignant(id, nom, prenom, email, grade, dept);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static boolean deleteEnsById(int id) {
        String sql = "DELETE FROM enseignants WHERE id = ?";

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

    public static Enseignant getEnsById(int id) {
        String sql = "SELECT * FROM enseignants WHERE id = ?";
        Enseignant enseignant = null;

        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int enseignantId = rs.getInt("id");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String email = rs.getString("email");
                String grade = rs.getString("grade");
                int deptId = rs.getInt("departement_id");

                Departement dept = src.services.DepartementServices.getDeptById(deptId); // This method should be implemented in DepartementServices
                enseignant = new Enseignant(enseignantId, nom, prenom, email, grade, dept);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return enseignant;
    }

    public static ArrayList<Enseignant> getAllEns() {
        ArrayList<Enseignant> enseignants = new ArrayList<>();
        String sql = "SELECT * FROM enseignants";

        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String email = rs.getString("email");
                String grade = rs.getString("grade");
                int deptId = rs.getInt("departement_id");

                Departement dept = src.services.DepartementServices.getDeptById(deptId);
                Enseignant enseignant = new Enseignant(id, nom, prenom, email, grade, dept);
                enseignants.add(enseignant);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return enseignants;
    }
}
