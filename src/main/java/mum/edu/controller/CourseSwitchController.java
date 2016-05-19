/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.edu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author zelalem
 */
@Controller
@RequestMapping("/courseSwitch")
public class CourseSwitchController {
     @RequestMapping(path = "/", method = RequestMethod.GET)
    public String courseSwitch() {
        return "courseSwitch";
    }
}
