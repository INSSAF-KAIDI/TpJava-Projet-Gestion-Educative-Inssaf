package models;
import java.util.ArrayList;
public class Etudiant {

    private int id;
    private String nom;
    private String prenom;
    private String email;
    private int apogee;
    private Filiere filiere;
    ArrayList<Note> notes = new ArrayList<>();

    /**
     * Provides a string representation of the student for display or logging.
     * This is typically used for debugging and logging purposes to get a quick look at the state of an object.
     * @return A string that describes the student.
     */

    @Override
    public String toString() {
        return "Id: " + id + " | Nom: " + nom + " | Email: " + email + " | Apogee: " + apogee;
    }

    /**
     * Default constructor for the Etudiant class.
     * It initializes an Etudiant object without setting any of its properties.
     */
    public Etudiant() {
    }

    /**
     * Constructs a new student with given details.
     * This constructor allows creating an Etudiant object with all its relevant information.
     * @param nom Last name of the student.
     * @param prenom First name of the student.
     * @param email Email address of the student.
     * @param apogee Apogee number of the student.
     * @param filiere Study program or department of the student.
     */
    public Etudiant(String nom, String prenom, String email, int apogee, Filiere filiere) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.apogee = apogee;
        this.filiere = filiere;
    }

    // Getters and setters for each field:

    public String getNom() {
        return nom;
    }

    /**
     * Sets the last name of the student.
     * @param nom The new last name to be set.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    /**
     * Sets the first name of the student.
     * @param prenom The new first name to be set.
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the student.
     * @param email The new email address to be set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public int getApogee() {
        return apogee;
    }

    /**
     * Sets the apogee number of the student.
     * @param apogee The new apogee number to be set.
     */
    public void setApogee(int apogee) {
        this.apogee = apogee;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    /**
     * Sets the study program or department (filiere) for the student.
     * @param filiere The new study program or department to be set.
     */
    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    /**
     * Sets the list of grades or scores (notes) obtained by the student.
     * @param notes The new list of notes to be set.
     */
    public void setNotes(ArrayList<Note> notes) {
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the student.
     * @param id The new ID to be set.
     */
    public void setId(int id) {
        this.id = id;
    }
}
