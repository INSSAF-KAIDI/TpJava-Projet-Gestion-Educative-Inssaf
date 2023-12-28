package services;

import models.Enseignant;
import models.Filiere;
import models.Module;

import java.util.ArrayList;

/**
 * ModuleServices provides functionalities to manage modules in the system.
 */
public class ModuleServices {

    /**
     * Adds a new module to the system.
     * @param intitule The name of the module.
     * @param chef The Enseignant responsible for the module.
     * @param filiere The Filiere associated with the module.
     * @return The newly created Module object.
     */
    public static Module addModule(String intitule, Enseignant chef, Filiere filiere) {
        Module newModule = new Module(intitule, chef, filiere);
        DB.modules.add(newModule);
        System.out.println("New module added: " + newModule); // Debugging statement
        return newModule;
    }

    /**
     * Updates the details of an existing module.
     * @param id The ID of the module to update.
     * @param intitule The new name of the module.
     * @param chef The new Enseignant responsible for the module.
     * @param filiere The new Filiere associated with the module.
     * @return The updated Module object, or null if not found.
     */
    public static Module updateModule(int id, String intitule, Enseignant chef, Filiere filiere) {
        for (Module module : DB.modules) {
            if (module.getId() == id) {
                module.setIntitule(intitule);
                module.setChef(chef);
                module.setFiliere(filiere);
                return module;
            }
        }
        return null;
    }

    /**
     * Deletes a module by its ID.
     * @param id The ID of the module to delete.
     * @return The list of remaining modules after deletion.
     */
    public static ArrayList<Module> deleteModuleById(int id){
        Module moduleToRemove = getModuleById(id);
        if (moduleToRemove != null) {
            DB.modules.remove(moduleToRemove);
        }
        return DB.modules;
    }

    /**
     * Retrieves a module by its ID.
     * @param id The ID of the module.
     * @return The Module object with the specified ID, or null if not found.
     */
    public static Module getModuleById(int id){
        for (Module module : DB.modules) {
            if (module.getId() == id) return module;
        }
        return null;
    }

    /**
     * Retrieves all modules in the system.
     * @return A list of all Module objects.
     */
    public static ArrayList<Module> getAllModules() {
        return DB.modules;
    }

    public static void addFiliere(String intitule, Enseignant ensById, Filiere filiereById) {
    }

    public static void updateFiliere(int id, String intitule, Enseignant ensById, Filiere filiereById) {
    }
}
