package com.example.weeklytimesheets.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.weeklytimesheets.Repo.WeeklyTimesheetRepository;
import com.example.weeklytimesheets.models.Weeklytimesheets;

@RestController
@RequestMapping("/api/timesheets")
public class WeeklyTimesheetsController {

    @Autowired
    private WeeklyTimesheetRepository timesheetRepo;
    private WeeklyTimesheetsService timesheetService;

    @PostMapping
    public Weeklytimesheets logHours(@RequestBody Weeklytimesheets timesheet) {
        return timesheetRepo.save(timesheet);
    }

    public ResponseEntity<Weeklytimesheets> createTimesheet(@RequestBody Weeklytimesheets timesheet){
        return ResponseEntity.ok(WeeklyTimeSheetsService.saveTimesheet(Weeklytimesheets));
    }

    @GetMapping("/{employeeId}/week")
    public List<Weeklytimesheets> getWeekTimesheet(
        @PathVariable Long employeeId,
        @RequestParam("start") String start,
        @RequestParam("end") String end) {

        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);
        return timesheetRepo.findByEmployeeIdAndWorkDateBetween(employeeId, startDate, endDate);
    }
    public ResponseEntity<List<Weeklytimesheets>> getTimesheet(){
        return ResponseEntity.ok(weeklytimesheetService.getAllTimesheet());
    }
} 
