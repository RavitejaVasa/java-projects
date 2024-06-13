package My_project.Hostel_boot_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import My_project.Hostel_boot_project.entity.Student;

@RestController
public class HostelController {

    @Autowired
    private RestTemplate restTemplate;

    static final String STUDENT_URL_MS = "http://localhost:8082/";

    @GetMapping("/find/{roll}")
    public Student fetchStudent(@PathVariable int roll) {
        try {
            Student student = restTemplate.exchange(STUDENT_URL_MS + "/find/{roll}" + roll, HttpMethod.GET, null, Student.class).getBody();
            System.out.println("Student from the report project: " + student);
            return student;
        } catch (HttpClientErrorException.NotFound e) {
            System.err.println("Student not found: " + e.getMessage());
            // Handle the 404 error accordingly, maybe return a default response or throw a custom exception
            throw new RuntimeException("Student not found", e);
        } catch (ResourceAccessException e) {
            System.err.println("Error accessing resource: " + e.getMessage());
            // Handle the connection error accordingly
            throw new RuntimeException("Service is not available", e);
        }
    }

    @GetMapping("/find")
    public String fetchStudents() {
        try {
            return restTemplate.exchange(STUDENT_URL_MS + "/find", HttpMethod.GET, null, String.class).getBody();
        } catch (HttpClientErrorException.NotFound e) {
            System.err.println("Resource not found: " + e.getMessage());
            // Handle the 404 error accordingly
            return "No students found";
        } catch (ResourceAccessException e) {
            System.err.println("Error accessing resource: " + e.getMessage());
            // Handle the connection error accordingly
            return "Service is not available";
        }
    }
}
