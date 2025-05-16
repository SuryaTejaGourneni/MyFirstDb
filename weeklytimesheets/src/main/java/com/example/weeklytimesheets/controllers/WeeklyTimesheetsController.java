package com.example.weeklytimesheets.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.weeklytimesheets.models.Weeklytimesheets;
import com.example.weeklytimesheets.services.WeeklyTimesheetsService;

@RestController
@RequestMapping("/api/timesheets")
public class WeeklyTimesheetsController {

    @Autowired
    private WeeklyTimesheetsService timesheetService;

    
    @PostMapping
    public ResponseEntity<Weeklytimesheets> createTimesheet(@RequestBody Weeklytimesheets timesheet) {
        Weeklytimesheets saved = timesheetService.saveTimesheets(timesheet);
        return ResponseEntity.ok(saved);
    }

    
    @GetMapping("/{employeeId}/week")
    public ResponseEntity<List<Weeklytimesheets>> getWeekTimesheet(
            @PathVariable Long employeeId,
            @RequestParam("start") String start,
            @RequestParam("end") String end) {

        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);
        List<Weeklytimesheets> timesheets = timesheetService.findByEmployeeIdAndWorkDateBetween(employeeId, startDate, endDate);
        return ResponseEntity.ok(timesheets);
    }

    
    @GetMapping
    public ResponseEntity<List<Weeklytimesheets>> getTimesheet() {
        return ResponseEntity.ok(timesheetService.getAllTimesheets());
    }
}
