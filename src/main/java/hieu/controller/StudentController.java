package hieu.controller;

import hieu.model.ClassRoom;
import hieu.model.Student;
import hieu.model.StudentForm;
import hieu.service.classroom.IClassRoomService;
import hieu.service.student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("students")
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @Autowired
    private IClassRoomService categoryService;
    @Value("C:\\Users\\Administrator\\Desktop\\image\\")
    private String fileUpload;

    @ModelAttribute(name = "classrooms")
    private List<ClassRoom> categories() {
        return categoryService.findAll();
    }

    @GetMapping
    private ModelAndView showAllStudent(String name) {
        if (name == null) {
            List<Student> students = this.studentService.findAll();
            ModelAndView modelAndView = new ModelAndView("/student/list");
            modelAndView.addObject("students", students);
            return modelAndView;
        } else {
            List<Student> students = this.studentService.findByName(name);
            ModelAndView modelAndView = new ModelAndView("/student/list");
            modelAndView.addObject("students", students);
            return modelAndView;
        }
    }

    @GetMapping("/create")
    private ModelAndView showCreateForm() {
        StudentForm studentForm = new StudentForm();
        ModelAndView modelAndView = new ModelAndView("/student/create");
        modelAndView.addObject("studentForm", studentForm);
        return modelAndView;
    }

    @PostMapping("/create")
    private ModelAndView createStudent(@ModelAttribute StudentForm studentForm) {
        MultipartFile imageFile = studentForm.getImage();
        String fileName = imageFile.getOriginalFilename();
        long currentTime = System.currentTimeMillis();
        fileName = currentTime + fileName;
        try {
            FileCopyUtils.copy(imageFile.getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Student newStudent = new Student(studentForm.getName(), studentForm.getDate(), studentForm.getAddress(), studentForm.getPhone(), studentForm.getEmail(),fileName,studentForm.getClassRoom());
        studentService.save(newStudent);
        ModelAndView modelAndView = new ModelAndView("redirect:/students");
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    private ModelAndView showFormEdit(@PathVariable Long id){
        Student oldStudent = this.studentService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/student/edit");
        modelAndView.addObject("student",oldStudent);
        return modelAndView;
    }
    @PostMapping("/edit/{id}")
    private ModelAndView editStudent(@PathVariable Long id, @ModelAttribute StudentForm studentForm) {
        Student oldStudent = this.studentService.findById(id);
        MultipartFile imageFile = studentForm.getImage();
        String image;
        String fileName = null;
        if (imageFile.getSize() == 0) {
            image = oldStudent.getImage();
        } else {
            fileName = imageFile.getOriginalFilename();
            long currentTime = System.currentTimeMillis();
            fileName = currentTime + fileName;
            image = fileName;
            try {
                FileCopyUtils.copy(imageFile.getBytes(), new File(fileUpload + fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Student newStudent = new Student(studentForm.getName(), studentForm.getDate(), studentForm.getAddress(), studentForm.getPhone(), studentForm.getEmail(), fileName, studentForm.getClassRoom());
        studentService.save(newStudent);
        ModelAndView modelAndView = new ModelAndView("redirect:/students");
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    private ModelAndView showFormDelete(@PathVariable Long id){
        Student student = this.studentService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/student/delete");
        modelAndView.addObject("student",student);
        return modelAndView;
    }
    @PostMapping("/delete/{id}")
    private  ModelAndView deleteStudent(@PathVariable Long id){
        Student student = this.studentService.findById(id);
        File file = new File(fileUpload + student.getImage());
        if (file.exists()){
            file.delete();
        }
        this.studentService.delete(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/students");
        return modelAndView;
    }
    @GetMapping("/view/{id}")
    private ModelAndView showStudentDetails(@PathVariable Long id){
        Student student = this.studentService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/student/view");
        modelAndView.addObject("student",student);
        return modelAndView;
    }

}
