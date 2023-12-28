package services;

import models.Note;
import models.Etudiant;
import models.Filiere;

import java.util.ArrayList;

/**
 * NoteServices provides functionalities to manage notes (grades) for students.
 */
public class NoteServices {

    /**
     * Adds a new note for a student.
     * @param note The grade to be added.
     * @param etudiant The student who receives the grade.
     * @param filiere The field of study or department related to the grade.
     * @return The newly added Note object.
     */
    public static Note addNote(float note, Etudiant etudiant, Filiere filiere) {
        Note newNote = new Note(note, etudiant, filiere);
        DB.notes.add(newNote);
        return newNote;
    }

    /**
     * Updates an existing note.
     * @param noteId The ID of the note to update.
     * @param newNote The new grade.
     * @return The updated Note object, or null if not found.
     */
    public static Note updateNote(int noteId, float newNote) {
        for (Note note : DB.notes) {
            if (note.getId() == noteId) {
                note.setNote(newNote);
                return note;
            }
        }
        return null;
    }

    /**
     * Deletes a note by its ID.
     * @param noteId The ID of the note to delete.
     */
    public static void deleteNoteById(int noteId) {
        Note noteToRemove = getNoteById(noteId);
        if (noteToRemove != null) {
            DB.notes.remove(noteToRemove);
        }
    }

    /**
     * Retrieves a note by its ID.
     * @param noteId The ID of the note.
     * @return The Note object, or null if not found.
     */
    public static Note getNoteById(int noteId) {
        for (Note note : DB.notes) {
            if (note.getId() == noteId) {
                return note;
            }
        }
        return null;
    }

    /**
     * Retrieves all notes.
     * @return A list of all Note objects.
     */
    public static ArrayList<Note> getAllNotes() {
        return DB.notes;
    }
}
