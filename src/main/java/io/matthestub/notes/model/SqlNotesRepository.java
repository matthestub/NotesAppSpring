package io.matthestub.notes;

import io.matthestub.notes.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotesRepository extends JpaRepository<Note, Integer> {

    @RestResource(path = "done", rel = "done")
    List<Note> findByDone(@Param("state") boolean state);
}
