package models;
import java.util.ArrayList;

public class Enseignant {

    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String grade;
    private Departement dept;
    ArrayList<Module> modules = new ArrayList<>();

    @Override
    public String toString() {
        return "Enseignant{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", grade='" + grade + '\'' +
                ", departement=" + (dept != null ? dept.getIntitule() : "None") +
                '}';
    }

    /**
     * Default constructor. Initializes an instance of Enseignant without setting its fields.
     */
    public Enseignant() {
    }

    /**
     * Constructs an Enseignant with specified details.
     *
     * @param id    The ID of the Enseignant.
     * @param nom   The last name of the Enseignant.
     * @param prenom The first name of the Enseignant.
     * @param email The email of the Enseignant.
     * @param grade The academic grade or rank of the Enseignant.
     * @param dept  The department to which the Enseignant is assigned.
     */
    public Enseignant(int id, String nom, String prenom, String email, String grade, Departement dept) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.grade = grade;
        this.dept = dept;
    }

    /**
     * Gets the last name of the Enseignant.
     *
     * @return The last name of the Enseignant.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Sets the last name of the Enseignant.
     *
     * @param nom The new last name of the Enseignant.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Gets the first name of the Enseignant.
     *
     * @return The first name of the Enseignant.
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Sets the first name of the Enseignant.
     *
     * @param prenom The new first name of the Enseignant.
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Gets the email of the Enseignant.
     *
     * @return The email of the Enseignant.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the Enseignant.
     *
     * @param email The new email of the Enseignant.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the academic grade or rank of the Enseignant.
     *
     * @return The academic grade or rank of the Enseignant.
     */
    public String getGrade() {
        return grade;
    }

    /**
     * Sets the academic grade or rank of the Enseignant.
     *
     * @param grade The new academic grade or rank of the Enseignant.
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * Gets the department to which the Enseignant is assigned.
     *
     * @return The department of the Enseignant.
     */
    public Departement getDept() {
        return dept;
    }

    /**
     * Sets the department to which the Enseignant is assigned.
     *
     * @param dept The new department of the Enseignant.
     */
    public void setDept(Departement dept) {
        this.dept = dept;
    }

    /**
     * Gets the list of modules taught by the Enseignant.
     *
     * @return The list of modules.
     */
    public ArrayList<Module> getModules() {
        return modules;
    }

    /**
     * Sets the list of modules taught by the Enseignant.
     *
     * @param modules The new list of modules.
     */
    public void setModules(ArrayList<Module> modules) {
        this.modules = modules;
    }

    /**
     * Gets the ID of the Enseignant.
     *
     * @return The ID of the Enseignant.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the Enseignant.
     *
     * @param id The new ID of the Enseignant.
     */
    public void setId(int id) {
        this.id = id;
    }
}