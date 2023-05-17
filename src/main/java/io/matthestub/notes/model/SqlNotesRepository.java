package io.matthestub.notes.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SqlNotesRepository extends NoteRepository, JpaRepository<Note, Integer> {


    //or ... where id:=id in case I added annotation in front of the method arg like: @Param("id)
    @Override
    @Query(nativeQuery = true, value = "select count(*) > 0 from note where id=?1")
    boolean existsById(Integer Id);

}
