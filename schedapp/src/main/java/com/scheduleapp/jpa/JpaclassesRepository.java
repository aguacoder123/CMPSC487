package com.scheduleapp.jpa;

import com.scheduleapp.model.classes;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface JpaclassesRepository extends CrudRepository<classes, Long> {

    // retrieving class from schedule
    @Query("select c FROM classes c where c.class_ID = :id")
    classes scheduleclass(@Param("id") String id);

    // remove student from class
    @Modifying
    @Query(value ="UPDATE classes SET students = REPLACE(students,:user,' '), slots_taken=slots_taken-1 WHERE class_id=:course", nativeQuery = true)
    void removeStudent(@Param("user") String user, @Param("course") String course);

    // add user to class
    @Modifying
    @Query(value="UPDATE classes SET classes.students = CONCAT(CONCAT(students,:user),' '),slots_taken=slots_taken+1 WHERE classes.class_id=:course",nativeQuery = true)
    void addUser(@Param("user") String user, @Param("course") String course);

    // editing a class
    // admin can edit semester, capacity, professor
    // using semester, capacity, professor as parameters
    @Modifying
    @Query(value="UPDATE classes SET classes.semester = :semester, classes.capacity=:capacity, classes.professor=:professor WHERE classes.class_id=:course ",nativeQuery = true)
    void editClass(@Param("semester") String semester, @Param("capacity") int capacity, @Param("professor") String professor);
}