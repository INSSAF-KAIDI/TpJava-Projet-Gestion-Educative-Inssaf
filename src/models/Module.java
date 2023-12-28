package models;

import models.Enseignant;
import models.Filiere;

public class Module {
    private int id;
    private String intitule;
    private Enseignant chef;
    private Filiere filiere;

    @Override
    public String toString() {
        return "Module{" +
                "id=" + id +
                ", intitule='" + intitule + '\'' +
                '}';
    }

    /**
     * Default constructor for creating a Module instance.
     */
    public Module() {
    }


    /**
     * Constructs a Module with specified title, responsible teacher, and field of study.
     * @param intitule The title of the module.
     * @param chef The teacher responsible for the module.
     * @param filiere The field of study or department related to the module.
     */
    public Module(String intitule, Enseignant chef, Filiere filiere) {
        this.intitule = intitule;
        this.chef = chef;
        this.filiere = filiere;
    }

    /**
     * Gets the title of the module.
     * @return The title or name of the module.
     */
    public String getIntitule() {
        return intitule;
    }

    /**
     * Sets the title of the module.
     * @param intitule The title or name to set for the module.
     */
    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    /**
     * Gets the responsible teacher for the module.
     * @return The Enseignant object representing the teacher.
     */
    public Enseignant getChef() {
        return chef;
    }

    /**
     * Sets the responsible teacher for the module.
     * @param chef The Enseignant object to set as the teacher of the module.
     */
    public void setChef(Enseignant chef) {
        this.chef = chef;
    }

    /**
     * Gets the field of study or department associated with the module.
     * @return The Filiere object representing the field of study or department.
     */
    public Filiere getFiliere() {
        return filiere;
    }

    /**
     * Sets the field of study or department associated with the module.
     * @param filiere The Filiere object to associate with the module.
     */
    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    /**
     * Gets the identifier of the module.
     * @return The unique identifier of the module.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the identifier of the module.
     * @param id The unique identifier to set for the module.
     */
    public void setId(int id) {
        this.id = id;
    }
}
