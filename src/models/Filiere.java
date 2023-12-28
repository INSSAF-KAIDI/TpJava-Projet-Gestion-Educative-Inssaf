package models;
import java.util.ArrayList;
public class Filiere {

    private int id;
    private String intitule;
    private Enseignant chef;
    private Departement dept;

    ArrayList<Module> modules = new ArrayList<Module>();

    @Override
    public String toString() {
        return "Id: " + id + " | intitule: " + intitule;

    }

    /**
     * Default constructor for creating a major instance.
     */
    public Filiere() {
    }

    /**
     * Constructs a major with specified title, responsible teacher, and departement .
     * @param intitule The title of the major.
     * @param chef The teacher responsible for the module.
     * @param dept The departement related major.
     */
    public Filiere(String intitule, Enseignant chef, Departement dept) {
        this.intitule = intitule;
        this.chef = chef;
        this.dept = dept;
    }

    public Filiere(String filiere) {
    }

    /**
     * Gets the title of the major.
     * @return The title or name of the major.
     */
    public String getIntitule() {
        return intitule;
    }

    /**
     * Sets the title of the major.
     * @param intitule The title or name to set for the major.
     */
    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    /**
     * Gets the responable of the major.
     * @return The responsable of the major.
     */
    public Enseignant getChef() {
        return chef;
    }

    /**
     * Sets the responasble of the major.
     * @param chef The title or name to set for the major.
     */
    public void setChef(Enseignant chef) {
        this.chef = chef;
    }

    /**
     * Gets the depertement of the major.
     * @return The departement of the major.
     */
    public Departement getDept() {
        return dept;
    }

    public void setDept(Departement dept) {
        this.dept = dept;
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public void setModules(ArrayList<Module> modules) {
        this.modules = modules;
    }
    /**
     * Gets the identifier of the major.
     * @return The unique identifier of the major.
     */

    public int getId() {
        return id;
    }

    /**
     * Sets the identifier of the major.
     * @param id The unique identifier to set for the major.
     */
    public void setId(int id) {
        this.id = id;
    }
}
