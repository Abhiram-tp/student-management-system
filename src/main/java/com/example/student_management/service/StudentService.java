package com.example.student_management.service;

import org.springframework.stereotype.Service;
import com.example.student_management.model.Student;
import com.example.student_management.repository.StudentRepository;

import java.util.List;
import java.util.Optional;


@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

        public Optional<Student> updateStudent(Long id, Student updatedStudent) {
        Optional<Student> existing = studentRepository.findById(id);
        if (existing.isPresent()) {
            Student student = existing.get();
            student.setName(updatedStudent.getName());
            student.setEmail(updatedStudent.getEmail());
            student.setCourse(updatedStudent.getCourse());
            student.setAge(updatedStudent.getAge());
            return Optional.of(studentRepository.save(student));
        } else {
            return Optional.empty();
        }
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

}
