package controllers;
import main.Main.Main;
import models.Departement;
import services.EnseignantServices;
import java.util.ArrayList;


/**
 * DepartementController manages user interactions for note operations.
 */
public class DepartementsController {

    /**
     * Shows options for Departement management and handles user input.
     */
    public static void showMenu() {
        System.out.println("-------------------------[ Départements ]---------------------------");

        System.out.println("1: Pour ajouter un département");
        System.out.println("2: Pour afficher les départements");
        System.out.println("3: Pour modifier un département");
        System.out.println("4: Pour supprimer un département");
        System.out.println("0: Pour retourner au menu principal");

        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch (option) {
            case 1:
                createDepartement();
                break;
            case 2:
                showDepartements();
                break;
            case 3:
                editDepartement();
                break;
            case 4:
                destroyDepartement();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }

    /**
     *  Displays all departement.
     */
    public static void showDepartements() {
        src.services.DepartementServices DepartementServices = new src.services.DepartementServices();
        ArrayList<Departement> departements = DepartementServices.getAllDept();

        System.out.println("-------------------------[ Liste des Départements ]---------------------------");
        System.out.println("ID\tIntitulé\tChef");

        for (Departement departement : departements) {
            String chefName = departement.getChef() != null ? departement.getChef().getNom() + " " + departement.getChef().getPrenom() : "";
            System.out.println(departement.getId() + "\t" + departement.getIntitule() + "\t" + chefName);
        }
        System.out.println("--------------------------------------------------------------------------");
    }

    /**
     * create new departement.
     */
    public static void createDepartement() {
        String intitule = Main.getStringInput("Entrez l'intitulé :");
        EnseignantsController.showEnseignants();
        int id = Main.getIntInput("Sélectionnez un enseignant par id :");

        src.services.DepartementServices.addDept(intitule, EnseignantServices.getEnsById(id));

        System.out.println("Département ajouté avec succès!");
        showMenu();
    }

    /**
     * Updates an existing module based on user input.
     */
    public static void editDepartement() {
        showDepartements();
        int id = Main.getIntInput("Sélectionnez un département par id :");
        String intitule = Main.getStringInput("Entrez le nouvel intitulé :");
        EnseignantsController.showEnseignants();
        int idEns = Main.getIntInput("Sélectionnez un enseignant par id :");

        Departement updatedDept = src.services.DepartementServices.updateDept(id, intitule, EnseignantServices.getEnsById(idEns));
        if (updatedDept != null) {
            System.out.println("Département mis à jour avec succès!");
        } else {
            System.out.println("Échec de la mise à jour du département.");
        }
        showMenu();
    }

    /**
     * Deletes a departement based on its ID.
     */
    public static void destroyDepartement() {
        showDepartements();
        int id = Main.getIntInput("Sélectionnez un département par id :");
        boolean deleted = src.services.DepartementServices.deleteDeptById(id);
        if (deleted) {
            System.out.println("Département supprimé avec succès!");
        } else {
            System.out.println("Échec de la suppression du département.");
        }
        showDepartements();
    }
}