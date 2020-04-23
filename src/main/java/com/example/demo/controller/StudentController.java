package com.example.demo.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentCurdRepository;
import com.example.demo.service.StudentService;

@Controller
@RequestMapping("/students/")
public class StudentController 
{
	@Autowired
	StudentCurdRepository studentRepository;
	
	@Autowired
	StudentService studentService;

    @Autowired
    public StudentController(StudentCurdRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("signup")
    public String showSignUpForm(Student student) {
        return "student/add-student";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) 
    {
    
    	model.addAttribute("students", studentRepository.findAll());
        return "student/main-student";
    }

    @PostMapping("add")
    public String addStudent(@Valid Student student, BindingResult result, Model model)
    {
        if (result.hasErrors())
        {
            return "student/add-student";
        }

        studentRepository.save(student);
        return "redirect:list";
    }

   /* @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model)
    {
        Student student = studentRepository.findById(id).orElseThrow(()->IllegalArgumentException(id));
        
        
        model.addAttribute("student", student);
        return "student/update-student";
    }*/
    @RequestMapping(path = {"/edit", "/edit/{id}"})
    public String editStudentById(Model model, @PathVariable("id") Optional<Long> id) throws Exception 
    {
        if (id.isPresent()) {
        	Student entity = studentService.getStudentById(id.get());
            model.addAttribute("student", entity);
        } else {
            model.addAttribute("student", new Student());
        }
        return "student/update-student";
    }
    @PostMapping("update/{id}")
    public String updateStudent(@PathVariable("id") long id, @Valid Student student, BindingResult result,
        Model model) {
        if (result.hasErrors()) {
            student.setId(id);
            return "student/update-student";
        }
        studentRepository.save(student);
        model.addAttribute("students", studentRepository.findAll());
        return "student/main-student";
    }
    
    @RequestMapping(path = "/delete/{id}")
    public String deleteStudentId(Model model, @PathVariable("id") Long id) throws Exception 
    {
    	studentService.deleteStudentId(id);
    	model.addAttribute("students", studentRepository.findAll());
        return "student/main-student";
    }

   /* @GetMapping("delete/{id}")
    public String deleteStudent(@PathVariable("id") long id, Model model) {
        Optional<Student> student = studentRepository.findById(id);
            
        studentRepository.deleteById(id);
        model.addAttribute("students", studentRepository.findAll());
        return "student/index";
    }*/
}

