package com.springrestapi.course.services;

import com.springrestapi.course.entities.Course;

import java.util.List;

public interface CourseService {
    public List<Course> getCourses();

    public Course getCourses(long courseId);

    public Course addCourse(Course course);

    public Course updateCourse(Course course);

    public void deleteCourse(long parseLong);
}
