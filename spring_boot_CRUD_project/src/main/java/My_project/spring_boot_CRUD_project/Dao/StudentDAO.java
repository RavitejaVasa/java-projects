package My_project.spring_boot_CRUD_project.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import My_project.spring_boot_CRUD_project.Entity.Student;

public interface StudentDAO extends JpaRepository<Student, Integer>{
	
	
		
	}