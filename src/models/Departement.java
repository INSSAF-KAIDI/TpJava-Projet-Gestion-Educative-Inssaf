package models;
import java.util.ArrayList;
public class Departement {

    private int id;
    private String intitule;
    private models.Enseignant chef;

    ArrayList<models.Filiere> filieres = new ArrayList<>();

    /**
     * Overrides the default toString method to provide a string representation of the department.
     * @return A string that describes the department.
     */
    @Override
    public String toString() {
        return "Departement{" +
                "intitule='" + intitule + '\'' +
                '}';
    }

    /**
     * Default constructor for Departement class.
     */
    public Departement() {
    }

    /**
     * Constructs a Departement with a specified name and head.
     * @param intitule Name of the department.
     * @param chef Head of the department.
     */
    public Departement(String intitule, Enseignant chef) {
        this.intitule = intitule;
        this.chef = chef;
    }

    // Getter and setter methods for each field in the class:

    /**
     * Gets the name (intitulé) of the department.
     * @return The name of the department.
     */
    public String getIntitule() {
        return intitule;
    }

    /**
     * Sets the title of the department.
     * @param intitule The new name of the department.
     */
    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    /**
     * Gets the head (chef) of the department.
     * @return The head of the department.
     */
    public Enseignant getChef() {
        return chef;
    }

    /**
     * Sets the head of the department.
     * @param chef The new head of the department.
     */
    public void setChef(Enseignant chef) {
        this.chef = chef;
    }

    /**
     * Gets the list of filieres in the department.
     * @return The list of filieres.
     */
    public ArrayList<Filiere> getFilieres() {
        return filieres;
    }

    /**
     * Sets the list of filieres in the department.
     * @param filieres The new list of filieres.
     */
    public void setFilieres(ArrayList<Filiere> filieres) {
        this.filieres = filieres;
    }

    /**
     * Gets the ID of the department.
     * @return The ID of the department.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the department.
     * @param id The new ID of the department.
     */
    public void setId(int id) {
        this.id = id;
    }
}