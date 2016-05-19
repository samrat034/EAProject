/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.edu.controller;
import mum.edu.service.PendingCourseSwitchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * @author zelalem
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
     @Autowired
    PendingCourseSwitchService pendingSwitchService;

    @RequestMapping(value = "/pendingSwitches", method = RequestMethod.GET)
    public String pendingSwitches(Model model) {
        model.addAttribute("pendingSwitches", pendingSwitchService.getAllPendingSwitches());
        return "pendingSwitches";
    }

    @RequestMapping(value = "/pendingSwitches", method = RequestMethod.POST)
    public String pendingSwitches(String cmd, int pendingSwitchId) {
        if ("Approve".equals(cmd)) {
            pendingSwitchService.approve(pendingSwitchId);
        } else {
            pendingSwitchService.reject(pendingSwitchId);
        }
        return "redirect:/admin/pendingSwitches";
    }
}
