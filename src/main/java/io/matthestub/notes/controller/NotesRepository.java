package io.matthestub.notes.controller;

import io.matthestub.notes.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepository extends JpaRepository<Note, Integer> {

}
