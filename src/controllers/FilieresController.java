package controllers;


import main.Main.Main;
import models.Enseignant;
import models.Filiere;
import services.EnseignantServices;
import models.Departement;
import services.FiliereServices;;

public class FilieresController {

    /**
     * Shows options for Majors management and handles user input.
     */
    public static void showMenu() {
        System.out.println("-------------------------[ Filières ]---------------------------");
        System.out.println("1: Pour ajouter une filière");
        System.out.println("2: Pour afficher les filières");
        System.out.println("3: Pour modifier une filière");
        System.out.println("4: Pour supprimer une filière");
        System.out.println("0: Pour retourner au menu principal");

        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch (option) {
            case 1:
                createFiliere();
                break;
            case 2:
                showFilieres();
                break;
            case 3:
                editFiliere();
                break;
            case 4:
                destroyFiliere();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }

    /**
     * Displays all Majors
     */
    public static void showFilieres() {
        for (Filiere filiere : FiliereServices.getAllFiliere()) {
            System.out.print("Id : " + filiere.getId());
            System.out.print(" | Intitulé : " + filiere.getIntitule());
            System.out.print(" | Responsable : " + filiere.getChef());
            System.out.print(" | Departement : " + filiere.getDept());
            System.out.println("");
        }
    }


    /**
     * create new Major
     */
    public static void createFiliere() {
        String intitule = Main.getStringInput("Entrez l'intitulé de la filière :");

        int idChef = Main.getIntInput("Entrez l'ID du responsable de la filière :");
        Enseignant chef = EnseignantServices.getEnsById(idChef);

        int idDept = Main.getIntInput("Entrez l'ID du departement de la filière :");
        src.services.DepartementServices DepartementServices = new src.services.DepartementServices();
        Departement dept = DepartementServices.getDeptById(idDept);

        FiliereServices.addFiliere(intitule, chef, dept);

        showFilieres();
        showMenu();
    }


    /**
     * Updates an existing Major based on user input.
     */
    public static void editFiliere() {
        showFilieres();
        int id = Main.getIntInput("Sélectionnez une filière par id :");
        String intitule = Main.getStringInput("Entrez le nouvel intitulé de la filière :");

        int idChef = Main.getIntInput("Entrez le nom du nouvel enseignant de la filière :");
        Enseignant chef = EnseignantServices.getEnsById(idChef);
        while (chef == null) {
            System.out.println("Enseignant non trouvé. Veuillez réessayer.");
            idChef = Main.getIntInput("Entrez le nom du nouvel enseignant de la filière :");
            chef = EnseignantServices.getEnsById(idChef);
        }

        int idDept = Main.getIntInput("Entrez le nom du nouvel departement de la filière :");
        src.services.DepartementServices DepartementServices = new src.services.DepartementServices();
        Departement dept = DepartementServices.getDeptById(idDept);
        while (dept == null) {
            System.out.println("Département non trouvé. Veuillez réessayer.");
            idDept = Main.getIntInput("Entrez le nom du nouvel departement de la filière :");
            dept = DepartementServices.getDeptById(idDept);
        }

        FiliereServices.updateFiliere(id, intitule, chef, dept);

        showFilieres();
        showMenu();
    }

    /**
     *  Deletes a Majors based on its ID.
     */
    public static void destroyFiliere() {
        showFilieres();
        int id = Main.getIntInput("Sélectionnez une filière par id :");
        FiliereServices.deleteFiliereById(id);
        showFilieres();
    }
}