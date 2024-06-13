package My_project.spring_boot_CRUD_project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import My_project.spring_boot_CRUD_project.Entity.Student;
import My_project.spring_boot_CRUD_project.Service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentservice;
	
	@PostMapping("/add")
	public String addStudent(@RequestBody Student student) {
		
		return studentservice.addStudent(student);		
	}
	
	@PostMapping("/bulkAdd")
	public String addStudents(@RequestBody List<Student> students) {
		
		return studentservice.addStudents(students);
	}
	
	@DeleteMapping("/all/{roll}")
	public String deleteStudent(@PathVariable int roll) {
	
		return studentservice.deleteStudent(roll);
		
	}
	@PutMapping("/add")
	public String updateStudent(@RequestBody Student student) {
		
		return studentservice.updateStudent(student);
		
		}
	
	@RequestMapping("/all/{roll}")
	public Student getStudent(@PathVariable int roll) {
		
		return studentservice.getStudent(roll);
	}

}
