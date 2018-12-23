package com.javaTutorials.springSecurity.services;


import com.javaTutorials.springSecurity.entities.Event;
import com.javaTutorials.springSecurity.entities.Group;
import com.javaTutorials.springSecurity.entities.User;
import com.javaTutorials.springSecurity.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GroupService {

    private GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public Group getGroupByName(String name) {
        addGroup(name);
        return groupRepository.findByName(name);
    }

    private void addGroup(String name) {
        User user = new User("Suseel bam", "my email address");
        Set<User> users = new HashSet<>();
        users.add(user);

        Group group = new Group();
        group.setName(name);
        group.setAddress("4120 Appian Way Ct.");
        group.setCity("columbus");
        group.setCountry("USA");
        group.setUser(user);
        group.setEvents(Collections.singleton(new Event(new Date(), "best event", "description", users)));

        groupRepository.save(group);
    }

    public List<Group> getAllGroups() {

        return groupRepository.findAll();
    }
}
