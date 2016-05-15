package mum.edu.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mum.edu.domain.Course;
import mum.edu.service.CourseService;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String listCourses(Model model) {
        model.addAttribute("course", courseService.getAllCourses());
        return "course/list";
    }

    @RequestMapping(value = {"/create"}, method = RequestMethod.GET)
    public String getCreateCourseForm(@ModelAttribute("course") Course newCourse) {
        return "course/detail";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String ProcessCreateCourseForm(Course course,
            BindingResult result, RedirectAttributes red) {
        if (result.hasErrors()) {
            return "course/detail";
        }
        courseService.createCourse(course);
        red.addFlashAttribute("course", course);
        return "redirect:/course/list";
    }

    @RequestMapping(value = "/course/{id}", method = RequestMethod.GET)
    public String getupdateCourseForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("course", courseService.getCourse(id));
        model.addAttribute("allCourses", courseService.getAllCourses());
        model.addAttribute("aCourse", new Course());  
        return "course/detail";
    }

    @RequestMapping(value = "/course/{id}", method = RequestMethod.POST)
    public String processupdateCourseForm(@Valid Course course,
            BindingResult result, RedirectAttributes red) {
        if (result.hasErrors()) {
            return "course/detail";
        }
        courseService.updateCourse(course);
        return "redirect:/course/list";
    }

    @RequestMapping(value = "/addPrerequisites", method = RequestMethod.POST)
    public String addPrerequisites(int courseId, int prerequisiteId) {
        courseService.addPrerequisite(courseId, prerequisiteId);
        return "redirect:/course/course/" + courseId;
    }
    
   @RequestMapping(value = "/course/delete", method = RequestMethod.GET)
    public String deletePrerequisite(int courseId, int prerequisiteId){
        courseService.deletePrerequisite(courseId, prerequisiteId);
       return "redirect:/course/course/" + courseId;
    }   
    

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String courseDelete(@PathVariable("id") int id) {
        courseService.deleteCourse(id);
        return "redirect:/course/list";
    }
}
