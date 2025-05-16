package com.example.weeklytimesheets.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.weeklytimesheets.Repo.WeeklyTimesheetRepository;
import com.example.weeklytimesheets.models.Weeklytimesheets;

@Service
public class WeeklyTimesheetsService {
    @Autowired
    private WeeklyTimesheetRepository timesheetRepo;

    public List<Weeklytimesheets> getAllTimesheets() {
        return timesheetRepo.findAll();
    }

    public Weeklytimesheets saveTimesheets(Weeklytimesheets Weeklytimesheets){
        return timesheetRepo.save(timesheet);
    }

    public List<Weeklytimesheets> findByEmployeeIdAndWorkDateBetween(Long employeeId, LocalDate start, LocalDate end) {
        return timesheetRepo.findByEmployeeIdAndWorkDateBetween(employeeId, start, end);
    }
}