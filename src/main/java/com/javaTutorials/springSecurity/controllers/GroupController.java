package com.javaTutorials.springSecurity.controllers;

import com.javaTutorials.springSecurity.entities.Group;
import com.javaTutorials.springSecurity.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@CrossOrigin
public class GroupController {

    private GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }


    @RequestMapping("/group")
    @ResponseBody
    @CrossOrigin
    public Group getGroupByName(@RequestParam String name) {
        return groupService.getGroupByName(name);
    }

    @RequestMapping("/groups")
    @ResponseBody
    @CrossOrigin
    public List<Group> getAllGroups() {
        return groupService.getAllGroups();
    }


    @RequestMapping("/")
    @ResponseBody
    @CrossOrigin
    public String landingPage() {
        return "welcome to my page";
    }
}
