package com.example.weeklytimesheets.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "weeklytimesheets")
public class Weeklytimesheets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long employeeId;
    private Long projectId;
    private LocalDate workDate;
    private Double hoursWorked;

    public Weeklytimesheets() {}

    public Weeklytimesheets(Long employeeId, Long projectId, LocalDate workDate, Double hoursWorked) {
    this.employeeId = employeeId;
    this.projectId = projectId;
    this.workDate = workDate;
    this.hoursWorked = hoursWorked;
}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }

    public Long getProjectId() { return projectId; }
    public void setProjectId(Long projectId) { this.projectId = projectId; }

    public LocalDate getWorkDate() { return workDate; }
    public void setWorkDate(LocalDate workDate) { this.workDate = workDate; }

    public Double getHoursWorked() { return hoursWorked; }
    public void setHoursWorked(Double hoursWorked) { this.hoursWorked = hoursWorked; }
}
