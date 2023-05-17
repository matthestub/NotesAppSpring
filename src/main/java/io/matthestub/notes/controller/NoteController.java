package io.matthestub.notes.controller;

import io.matthestub.notes.model.Note;
import io.matthestub.notes.model.NoteRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class NoteController {
    public static final Logger logger = LoggerFactory.getLogger(NoteController.class);
    private final NoteRepository noteRepository;

    public NoteController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @GetMapping(value = "/notes", params = {"!page", "!size", "!sort"})
    ResponseEntity<List<Note>> getAllNotes() {
        logger.warn("Exposing all the tasks!");
        return ResponseEntity.ok(noteRepository.findAll());
    }

    @GetMapping("/notes")
    ResponseEntity<Iterable<Note>> getAllNotes(Sort page) {
        logger.info("Custom pageable");
        return ResponseEntity.ok(noteRepository.findAll(page));
    }

    @GetMapping("/notes/{id}")
    ResponseEntity<Note> getNoteById(@PathVariable() int id) {
        logger.info("Searching for note with id = "+id);
        return noteRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/notes")
    ResponseEntity<Note> createNewNote(@RequestBody @Valid Note noteToCreate) {
        logger.info("Creating new note");
        Note savedNote = noteRepository.save(noteToCreate);
        return ResponseEntity.created(URI.create("/"+savedNote.getId())).body(savedNote);
    }

    @PutMapping("/notes/{id}")
    ResponseEntity<?> updateNote(@PathVariable int id, @Valid @RequestBody Note noteToUpdate) {
        logger.info("Updating note with id = "+id);
        if (!noteRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        } else {
            noteToUpdate.setId(id);
            noteRepository.save(noteToUpdate);
            return ResponseEntity.noContent().build();
        }
    }
}
