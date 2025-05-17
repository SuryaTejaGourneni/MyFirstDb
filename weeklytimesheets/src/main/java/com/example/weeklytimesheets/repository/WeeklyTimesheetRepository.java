package com.example.weeklytimesheets.repository;

import com.example.weeklytimesheets.model.WeeklyTimesheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface WeeklyTimesheetRepository extends JpaRepository<WeeklyTimesheet, Long> {
    List<WeeklyTimesheet> findByEmployeeIdAndWorkDateBetween(Long employeeId, LocalDate start, LocalDate end);
}