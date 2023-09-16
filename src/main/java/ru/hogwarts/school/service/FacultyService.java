package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Collectors;

@Service
public class FacultyService {
    private HashMap<Long, Faculty> faculties = new HashMap<>();
    private Long count;

    public Collection<Faculty> getByColor(String color) {
        return faculties.values().stream()
                .filter(faculty -> faculty.getColor().equalsIgnoreCase(color))
                .collect(Collectors.toList());
    }


    public Faculty create(Faculty faculty) {
        faculty.setId(count++);
        faculties.put(count,faculty);
        return faculty;
    }


    public Faculty read(Long id) {
        return faculties.get(id);
    }


    public Faculty update(Long id, Faculty faculty) {
        faculties.put(faculty.getId(), faculty);
        return faculty;
    }

    public Faculty delete(Long id) {
        return faculties.remove(id);
    }
}
