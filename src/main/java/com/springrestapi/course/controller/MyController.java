package com.springrestapi.course.controller;

//import org.springframework.stereotype.Controller;

import com.springrestapi.course.entities.Course;
import com.springrestapi.course.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {
    @Autowired
    private CourseService courseService;

    //get the course
    @GetMapping("/courses")
    public List<Course> getCourses() {
        return this.courseService.getCourses();
    }

    //Get Course By Id
    @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId) {
        return this.courseService.getCourses(Long.parseLong(courseId));
    }

    //Add new Course
    @PostMapping("/courses")
    public Course getCourse(@RequestBody Course course) {
        return this.courseService.addCourse(course);
    }

    //Update Course
    @PutMapping("/courses")
    public Course addCourse(@RequestBody Course course) {
        return this.courseService.updateCourse(course);
    }

    //Delete Course By Id
    @DeleteMapping("/courses/{courseID}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
        try {
            this.courseService.deleteCourse(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}