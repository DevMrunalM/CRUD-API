package StudentMaster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import StudentMaster.model.Student;
import StudentMaster.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;


@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	public Student getStudentById(Long id){
		return studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found with ID: " + id));
	}
	
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public Student updateStudent(Long id, Student updatedStudent) {
		Student existingStudent = getStudentById(id);
        existingStudent.setName(updatedStudent.getName());
        existingStudent.setAge(updatedStudent.getAge());
        existingStudent.setEmail(updatedStudent.getEmail());
       

        return studentRepository.save(existingStudent);
	}
	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}

}
