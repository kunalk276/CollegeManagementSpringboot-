package com.collegemangement.serviceimplement;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegemangement.entity.Courses;
import com.collegemangement.repository.CoursesRepository;
import com.collegemangement.service.CoursesService;

import java.util.List;
import java.util.Optional;

@Service
public class CoursesServiceImple implements CoursesService {

    @Autowired
    private CoursesRepository coursesRepository;

    @Override
    public Courses saveCourse(Courses course) {
        return coursesRepository.save(course);
    }

    @Override
    public Courses updateCourse(Courses course) {
        Optional<Courses> existingCourse = coursesRepository.findById(course.getCid());
        if (existingCourse.isPresent()) {
            Courses updatedCourse = existingCourse.get();
            updatedCourse.setCourseName(course.getCourseName());
            updatedCourse.setDuration(course.getDuration());
            updatedCourse.setCourseFees(course.getCourseFees());
            return coursesRepository.save(updatedCourse);
        } else {
            // Handle the case when the course does not exist
            return null;
        }
    }
    @Override
    public void deleteCourse(int id) {
        coursesRepository.deleteById(id);
    }

    @Override
    public Courses getCourseById(int id) {
        Optional<Courses> course = coursesRepository.findById(id);
        return course.orElse(null);
    }

    @Override
    public List<Courses> getAllCourses() {
        return coursesRepository.findAll();
    }
}
