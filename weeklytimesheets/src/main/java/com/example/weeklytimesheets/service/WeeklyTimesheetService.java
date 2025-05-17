package com.example.weeklytimesheets.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.weeklytimesheets.model.WeeklyTimesheet;
import com.example.weeklytimesheets.repository.WeeklyTimesheetRepository;

@Service
public class WeeklyTimesheetService {
    private final WeeklyTimesheetRepository repository;

    public WeeklyTimesheetService(WeeklyTimesheetRepository repository) {
        this.repository = repository;
    }

    public WeeklyTimesheet save(WeeklyTimesheet timesheet) {
        return repository.save(timesheet);
    }

    public List<WeeklyTimesheet> getAll() {
        return repository.findAll();
    }

    public List<WeeklyTimesheet> findTimesheetsForWeek(Long employeeId, LocalDate start, LocalDate end) {
        return repository.findByEmployeeIdAndWorkDateBetween(employeeId, start, end);
    }
}
