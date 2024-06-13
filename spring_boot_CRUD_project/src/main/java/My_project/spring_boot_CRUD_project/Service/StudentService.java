package My_project.spring_boot_CRUD_project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import My_project.spring_boot_CRUD_project.Dao.StudentDAO;
import My_project.spring_boot_CRUD_project.Entity.Student;

@Service
public class StudentService {
	
	@Autowired
	private StudentDAO dao;

	public String addStudent(Student student) {
		dao.save(student);
		
		return "New Student has been added into Database, roll number : "+student.getRoll();
		
	}
	
	public String addStudents(List<Student> students) {
		dao.saveAll(students);
		
		return "All new Student has been added into Database";	
	}
	
	public String deleteStudent(int roll) {
		Student student = dao.getById(roll);
		dao.delete(student);
		return "Roll number is deleted ;"+ roll;
	}
	
	public String updateStudent(Student student) {
		dao.save(student);
		return "Roll number is updated :"+ student.getRoll();
		
		}
	
	public Student getStudent(int roll) {
		return dao.findById(roll).get();		
	}
	
	
	

}
