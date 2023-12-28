package services;

import models.Departement;
import models.Enseignant;
import models.Filiere;

import java.util.ArrayList;

public class FiliereServices {

    /**
     * Adds a new Filiere to the system.
     * @param intitule The name of the Filiere.
     * @param chef The head of the Filiere (Enseignant).
     * @param dept The department of the Filiere.
     * @return The newly created Filiere.
     */
    public static Filiere addFiliere(String intitule, Enseignant chef, Departement dept) {
        Filiere newFiliere = new Filiere(intitule, chef, dept);
        DB.filieres.add(newFiliere);
        return newFiliere;
    }

    /**
     * Updates an existing Filiere.
     * @param id The ID of the Filiere to update.
     * @param intitule The new name of the Filiere.
     * @param chef The new head of the Filiere.
     * @param dept The new department of the Filiere.
     * @return The updated Filiere, or null if not found.
     */
    public static Filiere updateFiliere(int id, String intitule, Enseignant chef, Departement dept) {
        for (Filiere filiere : DB.filieres) {
            if (filiere.getId() == id) {
                filiere.setIntitule(intitule);
                filiere.setChef(chef);
                filiere.setDept(dept);
                return filiere;
            }
        }
        return null;
    }

    /**
     * Deletes a Filiere by its ID.
     * @param id The ID of the Filiere to delete.
     * @return The updated list of Filieres.
     */
    public static ArrayList<Filiere> deleteFiliereById(int id){
        Filiere toRemove = getFiliereById(id);
        if (toRemove != null) {
            DB.filieres.remove(toRemove);
        }
        return DB.filieres;
    }

    /**
     * Retrieves a Filiere by its ID.
     * @param id The ID of the Filiere.
     * @return The Filiere with the specified ID, or null if not found.
     */
    public static Filiere getFiliereById(int id){
        for (Filiere filiere : DB.filieres) {
            if (filiere.getId() == id) {
                return filiere;
            }
        }
        return null;
    }

    /**
     * Retrieves all Filieres.
     * @return A list of all Filieres.
     */
    public static ArrayList<Filiere> getAllFiliere(){
        return DB.filieres;
    }
}
