package com.javaTutorials.springSecurity.repositories;

import com.javaTutorials.springSecurity.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {

    Group findByName(String name);
}
