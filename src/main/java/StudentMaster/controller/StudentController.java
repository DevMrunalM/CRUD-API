package StudentMaster.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import StudentMaster.model.Student;
import StudentMaster.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	
	@Autowired
	private StudentService studentservice;

	@GetMapping
	public List<Student> getAllStudents(){
		return studentservice.getAllStudents();
	}
	
	 @GetMapping("/{id}")
	    public Student getStudentById(@PathVariable Long id) {
	        return studentservice.getStudentById(id);
	    }

	    @PostMapping
	    public Student createStudent(@RequestBody Student student) {
	        return studentservice.createStudent(student);
	    }

	    @PutMapping("/{id}")
	    public Student updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
	        return studentservice.updateStudent(id, updatedStudent);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
	        studentservice.deleteStudent(id);
	        return ResponseEntity.ok("Student with ID " + id + " deleted successfully.");
	    }
	
}
