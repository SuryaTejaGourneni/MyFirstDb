package com.example.weeklytimesheets.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "weeklytimesheets")
public class WeeklyTimesheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long employeeId;

    @Column(nullable = false)
    private Long projectId;

    @Column(nullable = false)
    private LocalDate workDate;

    @Column(nullable = false)
    private Double hoursWorked;

    public WeeklyTimesheet() {}

    public WeeklyTimesheet(Long employeeId, Long projectId, LocalDate workDate, Double hoursWorked) {
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