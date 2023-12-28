package controllers;

import main.Main.Main;
import models.Etudiant;
import models.Filiere;
import services.EtudiantServices;
import services.FiliereServices;

import java.util.ArrayList;
public class EtudiantsController {

    /**
     * Affiche le menu des options disponibles pour la gestion des étudiants.
     */
    public static void showMenu() {
        System.out.println("-------------------------[ Étudiants ]---------------------------");
        System.out.println("1: Pour ajouter un étudiant");
        System.out.println("2: Pour afficher les étudiants");
        System.out.println("3: Pour modifier un étudiant");
        System.out.println("4: Pour supprimer un étudiant");
        System.out.println("0: Pour retourner au menu principal");

        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch (option) {
            case 1:
                createEtudiant();
                break;
            case 2:
                showEtudiants();
                break;
            case 3:
                editEtudiant();
                break;
            case 4:
                destroyEtudiant();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }

    /**
     * Affiche la liste des étudiants.
     */

    public static void showEtudiants() {
        for (Etudiant etudiant : services.EtudiantServices.getAllEtd()) {
            System.out.print("Id : " + etudiant.getId());
            System.out.print(" | Nom : " + etudiant.getNom() + " " + etudiant.getPrenom());
            System.out.print(" | Email : " + etudiant.getEmail());
            System.out.print(" | apogee : " + etudiant.getApogee());
            System.out.print(" | filiere : " + etudiant.getFiliere());
            System.out.println("");
        }
    }

    /**
     * create new student
     */
    public static void createEtudiant() {
        String nom = Main.getStringInput("Entrez le nom :");
        String prenom = Main.getStringInput("Entrez le prénom :");
        String email = Main.getStringInput("Entrez l'email :");
        int apogee = Main.getIntInput("Entrez apogee :");
        String filiere = Main.getStringInput("Entrez filiere :");
        services.EtudiantServices.addEtd(nom, prenom, email, apogee, filiere);

        showEtudiants();
        showMenu();
    }

    /**
     * Updates an existing student based on user input.
     */
    public static void editEtudiant() {
        showEtudiants();
        int id = Main.getIntInput("Sélectionnez un étudiant par id :");
        String nom = Main.getStringInput("Entrez le nom :");
        String prenom = Main.getStringInput("Entrez le prénom :");
        String email = Main.getStringInput("Entrez l'email :");
        int apogee = Main.getIntInput("Entrez apogee :");

        // Afficher les filières disponibles
        ArrayList<Filiere> filieres = FiliereServices.getAllFiliere();
        for (Filiere filiere : filieres) {
            System.out.println(filiere.getId() + " - " + filiere.getIntitule());
        }

        // Demander à l'utilisateur de choisir une filière
        int filiereId = Main.getIntInput("Choisissez une filière par son id :");
        Filiere filiere = services.FiliereServices.getFiliereById(filiereId);

       services.EtudiantServices.updateEtd(id, nom, prenom, email, apogee, filiere);

        showEtudiants();
        showMenu();
    }

    /**
     * Deletes a student based on its ID.
     */
    public static void destroyEtudiant() {
        showEtudiants();
        int id = Main.getIntInput("Sélectionnez un étudiant par id :");
        EtudiantServices.deleteEtdById(id);
        showEtudiants();
    }
}