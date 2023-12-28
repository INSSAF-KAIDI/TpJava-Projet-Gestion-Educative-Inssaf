package models;

/**
 * Represents a grade or score for a student within a specific field of study or department.
 */
public class Note {

    private float note;
    private Etudiant etudiant;
    private Filiere filiere;

    /**
     * Default constructor for creating a Note instance.
     */
    public Note() {
    }

    /**
     * Constructs a Note with specified score, student, and field of study.
     * @param note The score or grade.
     * @param etudiant The student associated with this grade.
     * @param filiere The field of study or department associated with this grade.
     */
    public Note(float note, Etudiant etudiant, Filiere filiere) {
        this.note = note;
        this.etudiant = etudiant;
        this.filiere = filiere;
    }

    /**
     * Gets the grade/score.
     * @return The numerical score or grade.
     */
    public float getNote() {
        return note;
    }

    /**
     * Sets the grade/score.
     * @param note The numerical score or grade to set.
     */
    public void setNote(float note) {
        this.note = note;
    }

    /**
     * Gets the associated student.
     * @return The Etudiant object.
     */
    public Etudiant getEtudiant() {
        return etudiant;
    }

    /**
     * Sets the associated student.
     * @param etudiant The Etudiant object to associate with this grade.
     */
    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    /**
     * Gets the associated field of study or department.
     * @return The Filiere object.
     */
    public Filiere getFiliere() {
        return filiere;
    }

    /**
     * Sets the associated field of study or department.
     * @param filiere The Filiere object to associate with this grade.
     */
    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public int getId() {
        return 0;
    }
}