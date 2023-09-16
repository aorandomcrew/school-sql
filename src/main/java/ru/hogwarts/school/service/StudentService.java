package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Collectors;


@Service
public class StudentService {
    private Long count = 0l;
    HashMap<Long, Student> students = new HashMap<>();

    public Collection<Student> getByAge(int age) {
        return students.values().stream()
                .filter(student -> student.getAge() == age)
                .collect(Collectors.toList());
    }


    public Student create(Student student) {
        student.setId(count++);
        students.put(count, student);
        return student;
    }


    public Student read(Long id) {
        return students.get(id);
    }


    public Student update(Long id, Student student) {
        students.put(student.getId(),student);
        return student;
    }

    public Student delete(Long id) {
        return students.remove(id);
    }

}
