package controllers;
import java.util.List;
import main.Main.Main;
import models.Enseignant;
import models.Departement;
import services.EnseignantServices;
public class EnseignantsController {

    /**
     * Shows options for Enseignant management and handles user input.
     */
    public static void showMenu() {
        System.out.println("-------------------------[ Enseignants ]---------------------------");
        System.out.println("1: Pour ajouter un enseignant");
        System.out.println("2: Pour afficher les enseignants");
        System.out.println("3: Pour modifier un enseignant");
        System.out.println("4: Pour supprimer un enseignant");
        System.out.println("0: Pour retourner au menu principal");

        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch (option) {
            case 1:
                createEnseignant();
                break;
            case 2:
                showEnseignants();
                break;
            case 3:
                editEnseignant();
                break;
            case 4:
                destroyEnseignant();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }

    /**
     * Displays all Enseignant
     */
    public static void showEnseignants() {
        List<Enseignant> enseignants = EnseignantServices.getAllEns();
        if (enseignants.isEmpty()) {
            System.out.println("Aucun enseignant disponible.");
        } else {
            for (Enseignant enseignant : enseignants) {
                System.out.println("Id: " + enseignant.getId() + " | Nom: " + enseignant.getNom() + " " + enseignant.getPrenom() + " | Email: " + enseignant.getEmail() + "| Grade: " + enseignant.getGrade() + "| Departement : " + enseignant.getDept());
            }
        }
    }

    /**
     * create new enseignant
     */
    public static void createEnseignant() {
        String nom = Main.getStringInput("Entrez le nom : ");
        String prenom = Main.getStringInput("Entrez le prénom : ");
        String email = Main.getStringInput("Entrez l'email : ");
        String grade = Main.getStringInput("Entrez le grade : ");
        Departement dept = selectDepartment(); // You need to implement this method

        Enseignant newEnseignant = EnseignantServices.addEns(nom, prenom, email, grade, dept);

        if (newEnseignant != null) {
            System.out.println("Enseignant ajouté avec succès.");
        } else {
            System.out.println("Erreur lors de l'ajout de l'enseignant.");
        }

        showEnseignants();
        showMenu();
    }

    /**
     * Updates an existing Enseignant based on user input.
     */
    public static void editEnseignant() {
        showEnseignants();
        int id = Main.getIntInput("Sélectionnez un enseignant par id : ");
        String nom = Main.getStringInput("Entrez le nom : ");
        String prenom = Main.getStringInput("Entrez le prénom : ");
        String email = Main.getStringInput("Entrez l'email : ");
        String grade = Main.getStringInput("Entrez le grade : ");
        Departement dept = selectDepartment(); // You need to implement this method

        Enseignant updatedEnseignant = EnseignantServices.updateEns(id, nom, prenom, email, grade, dept);

        if (updatedEnseignant != null) {
            System.out.println("Enseignant mis à jour avec succès.");
        } else {
            System.out.println("Erreur lors de la mise à jour de l'enseignant.");
        }

        showEnseignants();
        showMenu();
    }

    /**
     * Deletes a Enseignant based on its ID.
     */
    public static void destroyEnseignant() {
        showEnseignants();
        int id = Main.getIntInput("Sélectionnez un enseignant par id : ");
        boolean isDeleted = EnseignantServices.deleteEnsById(id);

        if (isDeleted) {
            System.out.println("Enseignant supprimé avec succès.");
        } else {
            System.out.println("Erreur lors de la suppression de l'enseignant.");
        }

        showEnseignants();
        showMenu();
    }

    private static Departement selectDepartment() {
        src.services.DepartementServices DepartementServices = new src.services.DepartementServices();
        List<Departement> departements = DepartementServices.getAllDept();

        if (departements.isEmpty()) {
            System.out.println("Aucun département disponible.");
            return null;
        }

        System.out.println("Sélectionnez un département:");
        for (Departement dept : departements) {
            System.out.println("Id: " + dept.getId() + " | Intitulé: " + dept.getIntitule());
        }

        int deptId = Main.getIntInput("Entrez l'ID du département: ");
        Departement selectedDept = DepartementServices.getDeptById(deptId);

        if (selectedDept == null) {
            System.out.println("Département non trouvé. Veuillez essayer à nouveau.");
            return null;
        }

        return selectedDept;
    }
}