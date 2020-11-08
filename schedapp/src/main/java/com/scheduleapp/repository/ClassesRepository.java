package com.scheduleapp.repository;


import com.scheduleapp.jpa.JpaclassesRepository;
import com.scheduleapp.model.classes;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClassesRepository {

    private final JpaclassesRepository repository;

    public ClassesRepository(JpaclassesRepository repository){
        this.repository = repository;
    }

    public List<classes> getClasses(){
        return (List<classes>) repository.findAll();
    }

    public void removeStudent(String user,String course){
        repository.removeStudent(user,course);
    }

    public void addUser(String user, String course){
        repository.addUser(user,course);
    }

    // edits classes
    public void editClass(String semester, int capacity, String professor) { repository.editClass(semester, capacity, professor); }

    // adds classes to db
    // not sure if this needs to be here too
    public classes addClasses(classes classes) { getClasses().add(classes); return classes; }

}
