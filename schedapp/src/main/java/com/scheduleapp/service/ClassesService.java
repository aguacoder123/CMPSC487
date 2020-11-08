package com.scheduleapp.service;
import com.scheduleapp.model.classes;
import com.scheduleapp.repository.ClassesRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class ClassesService {
    private final ClassesRepository classesRepository;

    public ClassesService(ClassesRepository classesRepository){
        this.classesRepository = classesRepository;
    }

    public List<classes> getClasses(){
        return classesRepository.getClasses();
    }

    public void addUser(String user,String course){
        classesRepository.addUser(user,course);
    }

    public List<classes> getSortedClasses(int sortBy){
        List<classes> sortedList = classesRepository.getClasses();

        switch(sortBy) {
            case 1:
                Collections.sort(sortedList, Comparator.comparing(c -> c.getCourse_ID().getCourse_ID()));
                break;
            case 2:
                Collections.sort(sortedList, Comparator.comparing(c -> c.getCourse_ID().getCourse_title()));
                break;
            case 3:
                Collections.sort(sortedList, Comparator.comparing(c -> c.getCourse_ID().getDepartment()));
                break;
            case 4:
                Collections.sort(sortedList, Comparator.comparing(c -> c.getOpenSlots()));
                break;
            case 5:
                Collections.sort(sortedList, Comparator.comparing(c -> c.getProfessor()));
                break;
        }
        return sortedList;
    }

    public void removeStudent(String user, String course){
        classesRepository.removeStudent(user,course);
    }

    // addubg a class to the db
    // section is manually entered by the admin
    public classes addClasses(int section, courses courses, String semester, int capacity, String professor, String students);
}
