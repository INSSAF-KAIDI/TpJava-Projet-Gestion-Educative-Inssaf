package services;

import models.Etudiant;
import models.Filiere;

import java.util.ArrayList;

/**
 * EtudiantServices fournit des services pour gérer les étudiants.
 * Cela inclut l'ajout, la mise à jour, la suppression et la récupération des informations des étudiants.
 */
public class EtudiantServices {

    /**
     * Ajoute un nouvel étudiant dans le système.
     * @param nom Le nom de l'étudiant.
     * @param prenom Le prénom de l'étudiant.
     * @param email L'email de l'étudiant.
     * @param apogee Le numéro apogée de l'étudiant.
     * @param filiere L'intitulé de la filière de l'étudiant.
     * @return L'étudiant nouvellement créé.
     */
    public static Etudiant addEtd(String nom, String prenom, String email, int apogee, String filiere) {

        Etudiant nouvelEtudiant = new Etudiant(nom, prenom, email, apogee, new Filiere(filiere));
        DB.etudiants.add(nouvelEtudiant);
        return nouvelEtudiant;
    }

    /**
     * Met à jour les informations d'un étudiant existant.
     * @param id L'identifiant de l'étudiant à mettre à jour.
     * @param nom Le nouveau nom.
     * @param prenom Le nouveau prénom.
     * @param email Le nouvel email.
     * @param apogee Le nouveau numéro apogée.
     * @param filiere La nouvelle filière.
     * @return L'étudiant mis à jour.
     */
    public static Etudiant updateEtd(int id, String nom, String prenom, String email, int apogee, Filiere filiere) {

        Etudiant etudiant = getEtdById(id);
        if (etudiant != null) {
            etudiant.setNom(nom);
            etudiant.setPrenom(prenom);
            etudiant.setEmail(email);
            etudiant.setApogee(apogee);
            etudiant.setFiliere(filiere);
        }
        return etudiant;
    }

    /**
     * Supprime un étudiant du système basé sur son identifiant.
     * @param id L'identifiant de l'étudiant à supprimer.
     * @return La liste mise à jour des étudiants.
     */
    public static ArrayList<Etudiant> deleteEtdById(int id) {

        Etudiant etudiant = getEtdById(id);
        if (etudiant != null) {
            DB.etudiants.remove(etudiant);
        }
        return DB.etudiants;
    }

    /**
     * Récupère un étudiant spécifique par son identifiant.
     * Parcourt la liste des étudiants et retourne l'étudiant dont l'ID correspond.
     *
     * @param id L'identifiant de l'étudiant à rechercher.
     * @return L'étudiant correspondant à l'ID donné, ou null si aucun étudiant n'est trouvé.
     */
    public static Etudiant getEtdById(int id) {
        for (Etudiant etudiant : DB.etudiants) {
            if (etudiant.getId() == id) {
                return etudiant;
            }
        }
        return null;
    }

    /**
     * Récupère la liste complète des étudiants.
     * Accède et retourne la collection complète des étudiants stockés dans la base de données.
     *
     * @return La liste de tous les étudiants.
     */
    public static ArrayList<Etudiant> getAllEtd(){
        return  DB.etudiants;
    }
}
