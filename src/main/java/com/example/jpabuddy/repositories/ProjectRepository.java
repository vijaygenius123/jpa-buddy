package com.example.jpabuddy.repositories;

import com.example.jpabuddy.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByName(String name);

    @Query("select p from Project p left join p.tasks tasks where tasks.endDate is null")
    List<Project> findProjectsWithUnfinishedTasks();
}