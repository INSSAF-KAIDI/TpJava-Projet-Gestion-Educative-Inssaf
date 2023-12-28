package controllers;
import java.util.ArrayList;
import main.Main.Main;
import models.Etudiant;
import models.Filiere;
import models.Note;
import services.DB;
import services.NoteServices;

public class NotesController {

    /**
     * Shows options for note management and handles user input.
     */
    public static void showMenu() {
        System.out.println("-------------------------[ Notes ]---------------------------");
        System.out.println("1: Pour ajouter une note");
        System.out.println("2: Pour modifier une note");
        System.out.println("3: Pour supprimer une note");
        System.out.println("4: Pour afficher les notes");
        System.out.println("0: Pour retourner au menu principal");

        int option = main.Main.Main.getIntInput("Veuillez sélectionner une option : ");

        switch (option) {
            case 1:
                addNote();
                break;
            case 2:
                updateNote();
                break;
            case 3:
                deleteNote();
                break;
            case 4:
                viewAllNotes();
                break;
            default:
                main.Main.Main.showPrincipalMenu();
        }
    }

    /**
     * Displays all notes.
     */
    public static void showNotes() {
        ArrayList<Note> notes = NoteServices.getAllNotes();
        for (Note note : notes) {
            System.out.println("Note ID: " + note.getId() + " | Grade: " + note.getNote() +
                    " | Student ID: " + note.getEtudiant().getId() +
                    " | Filiere: " + note.getFiliere().getIntitule());
        }
    }

    /**
     * Adds a new note based on user input.
     */
    private static void addNote() {
        float grade = main.Main.Main.getFloatInput("Enter the note: ");
        int studentId = main.Main.Main.getIntInput("Enter student ID: ");
        int filiereId = main.Main.Main.getIntInput("Enter filiere ID: ");

        Etudiant etudiant = getEtudiantById(studentId);
        Filiere filiere = getFiliereById(filiereId);

        if (etudiant != null && filiere != null) {
            Note note = NoteServices.addNote(grade, etudiant, filiere);
            System.out.println("Note added: " + note);
            showNotes();
        } else {
            System.out.println("Student or filiere not found.");
        }
    }

    /**
     * Updates an existing note based on user input.
     */
    private static void updateNote() {
        int noteId = main.Main.Main.getIntInput("Enter note ID: ");
        float newGrade = main.Main.Main.getFloatInput("Enter new grade: ");

        Note updatedNote = NoteServices.updateNote(noteId, newGrade);
        if (updatedNote != null) {
            System.out.println("Note updated: " + updatedNote);
            showNotes();
        } else {
            System.out.println("Note not found.");
        }
    }

    /**
     * Deletes a note based on its ID.
     */
    private static void deleteNote() {
        int noteId = main.Main.Main.getIntInput("Enter note ID to delete: ");
        NoteServices.deleteNoteById(noteId);
        System.out.println("Note deleted.");
        showNotes();
    }

    /**
     * Displays all notes.
     */
    private static void viewAllNotes() {
        showNotes(); // Utilizing showNotes method to display all notes
    }

    /**
     * Retrieves an Etudiant by their ID.
     * @param studentId The ID of the student.
     * @return The Etudiant object, or null if not found.
     */
    private static Etudiant getEtudiantById(int studentId) {
        for (Etudiant etudiant : DB.etudiants) {
            if (etudiant.getId() == studentId) {
                return etudiant;
            }
        }
        return null;
    }

    /**
     * Retrieves a Filiere by its ID.
     * @param filiereId The ID of the filiere.
     * @return The Filiere object, or null if not found.
     */
    private static Filiere getFiliereById(int filiereId) {
        for (Filiere filiere : DB.filieres) {
            if (filiere.getId() == filiereId) {
                return filiere;
            }
        }
        return null;
    }
}
