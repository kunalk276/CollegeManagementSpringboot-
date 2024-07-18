package com.collegemangement.service;

import com.collegemangement.entity.Courses;
import java.util.List;

public interface CoursesService {
    Courses saveCourse(Courses course);
    Courses updateCourse(Courses course);
    void deleteCourse(int id);
    Courses getCourseById(int id);
    List<Courses> getAllCourses();
}
