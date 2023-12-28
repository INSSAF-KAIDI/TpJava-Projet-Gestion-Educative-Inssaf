package main.Main;
import controllers.*;
import models.Enseignant;
import models.Filiere;
import models.Departement;
import services.DB;
import java.util.Scanner;
public class Main {

    public static java.lang.Object controllers;

    public static boolean isNull(Object ob) {
        return ob == null ;
    }
    public static int getIntInput(String... msg) {
        Scanner scan = new Scanner(System.in);
        String message = "Entrez un nombre entier : ";
        if (msg.length > 0 )
            message = msg[0] ;
        System.out.print(message);
        int num = scan.nextInt();
        return num;

    }

    public static String getStringInput(String prompt) {
        Scanner scanner = new Scanner(System.in) ;
        System.out.println(prompt);
        return scanner.nextLine();

    }

    public static float getFloatInput(String... msg) {
        Scanner scan = new Scanner(System.in);
        String message = "Enter a floating-point number: ";
        if (msg.length > 0)
            message = msg[0];
        System.out.print(message);

        float num = scan.nextFloat();

        return num;

    }
    public static void showPrincipalMenu(){
        System.out.println("-------------------------[ Bienvenu ]---------------------------");


        System.out.println("1: Pour gérer les départements");
        System.out.println("2: Pour gérer les filières");
        System.out.println("3: Pour gérer les enseignants");
        System.out.println("4: Pour gérer les modules");
        System.out.println("5: Pour gérer les étudiants");
        System.out.println("6: Pour gérer les notes");
        System.out.println("0: Pour sortir");

        int option = getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                DepartementsController.showMenu();
                break;
            case 2:
                FilieresController.showMenu();
                break;
            case 3:
                EnseignantsController.showMenu();
                break;
            case 4:
                ModulesController.showMenu();
                break;
            case 5:
                EtudiantsController.showMenu();
                break;
            case 6:
                NotesController.showMenu();
                break;
            default:
                System.out.println("Invalid option. Please enter a valid option.");
        }

        switch(option) {
            case 1:
                DepartementsController.showMenu();
                break;
            case 2:
                FilieresController.showMenu();
                break;
            case 3:
                EnseignantsController.showMenu();
                break;
            case 4:
                ModulesController.showMenu();
                break;
            case 5:
                EtudiantsController.showMenu();
                break;
            case 6:
                NotesController.showMenu();
                break;
            default:
                System.out.println("Invalid option. Please enter a valid option.");
        }
    }
    public static void main(String[] args) {

        src.services.DepartementServices.registerJDBCDriver();

        Enseignant enseignant = new Enseignant();
        enseignant.setNom("Amine");
        enseignant.setPrenom("Ben Charif");
        enseignant.setEmail("test@gmail.com");
        enseignant.setGrade("PES");
        enseignant.setId(DB.getEnsId());
        DB.enseignants.add(enseignant);


        Enseignant enseignant2 = new Enseignant();
        enseignant2.setNom("Ahmed");
        enseignant2.setPrenom("Ben");
        enseignant2.setEmail("ahmed@gmail.com");
        enseignant2.setGrade("PES");
        enseignant2.setId(DB.getEnsId());
        DB.enseignants.add(enseignant2);


        Departement departement = new Departement();
        departement.setIntitule("Computer Science");
        departement.setChef(enseignant);
        departement.setId(DB.getDeptId());
        DB.departements.add(departement);


        Filiere filiere = new Filiere();
        filiere.setIntitule("SITD");
        filiere.setChef(enseignant2);
        filiere.setDept(departement);
        DB.filieres.add(filiere);

        showPrincipalMenu();

    }
}