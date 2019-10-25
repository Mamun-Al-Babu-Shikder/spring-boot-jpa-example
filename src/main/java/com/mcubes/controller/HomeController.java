package com.mcubes.controller;

import com.mcubes.dao.StudentDao;
import com.mcubes.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

/**
 * Created by A.A.MAMUN on 10/25/2019.
 */
@Controller
public class HomeController {

    @Autowired
    StudentDao studentDao;

    @GetMapping("/home")
    private String homePage(Model model) {

        // Fetch student list by jpa.
        List<Student> studentList = (List<Student>) studentDao.findAll();
        // Sent Student List to View with the help of 'model' object
        model.addAttribute("studentList", studentList);
        return "home";
    }

    /*
    Save Student information.
     */
    @PostMapping("/save")
    private String saveStudent(@RequestParam String roll, @RequestParam String name, @RequestParam String address,
                               @RequestParam String dept)
    {
        Student student = new Student();
        student.setRoll(roll);
        student.setName(name);
        student.setAddress(address);
        student.setDepartment(dept);
        studentDao.save(student);

        return "redirect:/home";
    }

    /*
    Update student information.
    In JPA update means save data that override the existing table row.
     */
    @PostMapping("/update")
    private String updateStudent(@RequestParam Integer id, @RequestParam String roll, @RequestParam String name,
                                 @RequestParam String address, @RequestParam String dept){


        Student student = new Student();
        student.setId(id);
        student.setRoll(roll);
        student.setName(name);
        student.setAddress(address);
        student.setDepartment(dept);

        // Save student object
        studentDao.save(student);

        return "redirect:home";
    }

    @GetMapping("/delete")
    private String deleteStudent(@RequestParam Integer id) {

        //You can read student object and delete this using the following way;
        /*
        Optional<Student> studentOptional = studentDao.findById(id);
        studentDao.delete(studentOptional.get());
        */
        // You also can delete student by creating your own query at 'student dao'.
        studentDao.deleteStudentById(id);
        return "redirect:/home";
    }

}
