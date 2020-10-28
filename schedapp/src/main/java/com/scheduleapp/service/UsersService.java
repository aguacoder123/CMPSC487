package com.scheduleapp.service;

import com.scheduleapp.model.classes;
import com.scheduleapp.repository.ClassesRepository;
import com.scheduleapp.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    private final UsersRepository usersRepository;
    private final ClassesRepository classesRepository;

    public UsersService(UsersRepository usersRepository, ClassesRepository classesRepository){
        this.classesRepository = classesRepository;
        this.usersRepository = usersRepository;
    }

    public List<classes> getSchedule(String id){

        return usersRepository.getSchedule(id);
    }

    public void removeClass(String user, String course){
        usersRepository.updateSchedule(user, course);
    }

    public void addCourse(String user, String course){
        usersRepository.addCourse(user,course);
    }


}
