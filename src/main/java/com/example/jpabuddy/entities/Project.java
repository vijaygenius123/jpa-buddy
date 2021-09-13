package com.example.jpabuddy.entities;

import javax.persistence.*;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Table(name = "project")
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @PastOrPresent
    @Column(name = "start_date")
    private LocalDate startDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "manager_id", nullable = false)
    private AppUser manager;

    public AppUser getManager() {
        return manager;
    }

    public void setManager(AppUser manager) {
        this.manager = manager;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}