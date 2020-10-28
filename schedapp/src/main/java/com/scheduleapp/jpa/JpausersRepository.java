package com.scheduleapp.jpa;

import com.scheduleapp.model.users;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface JpausersRepository extends CrudRepository<users,Long> {

    @Query(value = "SELECT classes FROM schedules WHERE schedules.student_ID = :id",nativeQuery = true)
    String findclassString(@Param("id") String id);

    @Modifying
    @Query(value ="UPDATE schedules SET classes = REPLACE(classes, :course ,'') WHERE student_id= :user" ,nativeQuery = true)
    void updateSchedule(@Param("user") String user, @Param("course") String course);

    @Modifying
    @Query(value = "UPDATE Schedules SET Classes = CONCAT(CONCAT(classes,:course),' ') WHERE Schedules.student_id = :user", nativeQuery = true)
    void addCourse(@Param("user")String user, @Param("course")String course);
}
