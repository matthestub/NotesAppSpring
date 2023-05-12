package io.matthestub.notes.controller;

import io.matthestub.notes.NotesRepository;
import io.matthestub.notes.model.Note;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.awt.print.Pageable;
import java.util.List;

@RepositoryRestController
public class NoteController {
    public static final Logger logger = LoggerFactory.getLogger(NoteController.class);
    private NotesRepository notesRepository;

    public NoteController(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    @GetMapping(value = "/notes", params = {"!page", "!size", "!sort"})
    ResponseEntity<?> getAllNotes() {
        logger.warn("Exposing all the tasks!");
        return ResponseEntity.ok(notesRepository.findAll());
    }

    @GetMapping("/notes")
    ResponseEntity<List<Note>> getAllNotes(Sort page) {
        logger.info("Custom pageable");
        return ResponseEntity.ok(notesRepository.findAll(page));
    }

}
