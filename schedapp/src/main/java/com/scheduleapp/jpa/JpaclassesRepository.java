package com.scheduleapp.jpa;

import com.scheduleapp.model.classes;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface JpaclassesRepository extends CrudRepository<classes, Long> {

    @Query("select c FROM classes c where c.class_ID = :id")
    classes scheduleclass(@Param("id") String id);

    @Modifying
    @Query(value ="UPDATE classes SET students = REPLACE(students,:user,' '), slots_taken=slots_taken-1 WHERE class_id=:course", nativeQuery = true)
    void removeStudent(@Param("user") String user, @Param("course") String course);

    @Modifying
    @Query(value="UPDATE classes SET classes.students = CONCAT(CONCAT(students,:user),' '),slots_taken=slots_taken+1 WHERE classes.class_id=:course",nativeQuery = true)
    void addUser(@Param("user") String user, @Param("course") String course);
}