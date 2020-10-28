package com.scheduleapp.controller;

import com.scheduleapp.model.classes;
import com.scheduleapp.service.ClassesService;
import com.scheduleapp.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
public class ClassDisplayController {

    private final UsersService userService;
    private final ClassesService classService;

    public ClassDisplayController(UsersService userService, ClassesService classesService){
        this.classService = classesService;
        this.userService = userService;
    }

    @GetMapping("/classDisplay")
    public String CourseDisplay(Model model) {
        List<classes> classlist = classService.getClasses();
        model.addAttribute("courses",classlist);
        return "classDisplay";
    }
    @GetMapping("/sort")
    public String displaysort(Model model, @RequestParam int param1){
        List<classes> classList = classService.getSortedClasses(param1);
        model.addAttribute("courses",classList);
        return "classDisplay";
    }

    @GetMapping("/enroll/{course_ID}")
    public String enroll(Model model,@PathVariable String course_ID){
        System.out.println("test1");
        classService.addUser("00000000", course_ID);
        System.out.println("test2");
        userService.addCourse("00000000",course_ID);
        System.out.println("test3");
        List<classes> classlist = classService.getClasses();
        model.addAttribute("courses",classlist);
        return "classDisplay";
    }
}
