package com.scheduleapp.service.impl;

import com.scheduleapp.model.classes;
import com.scheduleapp.model.courses;
import com.scheduleapp.repository.ClassesRepository;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class ClassesServiceImpl implements ClassesService {

    private final ClassesRepository classesRepository;

    public ClassesServiceImpl(ClassesRepository classesRepository) {

        this.classesRepository = classesRepository;
    }

    @Override
    public List<classes> getClasses() {
        return classesRepository.getClasses();
    }


    // Adding a class to the database
    // class ID is to be generated automatically
    // slots_taken are intialized to zero
    // students is initialized as an empty string
    // the only fields needed from the user is section, course, semester, capacity, professor

    // the check for the section is not yet included here

    @Override
    public classes addClasses(int section, courses courses, String semester, int capacity, String professor, String students) {

        // Generating the course code
        Date d=new Date();
        int year=d.getYear();

        String code = courses.getCourse_ID();
        String subst = code.substring(code.length()-3);

        class_ID = Integer.toString(year);
        class_ID = class_ID.concat(subst);
        class_ID = class_ID.concat(Integer.toString(section));

        classes = new classes(class_ID, courses, semester, capacity, 0, String professor, "");
        return ClassesRepository.addClasses(classes);
    }


    @Override
    public boolean deleteClassById(int class_Id) {
        return ClassesRepository.deleteClassById(class_Id);
    }

}