package io.matthestub.notes.model;

import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface NoteRepository {

    List<Note> findAll();
    Iterable<Note> findAll(Sort page);
    Optional<Note> findById(Integer id);
    boolean existsById(Integer Id);
    Note save(Note note);

}
