package com.example.weeklytimesheets.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.weeklytimesheets.services.WeeklyTimesheetsService;
import com.example.weeklytimesheets.models.Weeklytimesheets;

@RestController
@RequestMapping("/api/timesheets")
public class WeeklyTimesheetsController {

    @Autowired
    private WeeklyTimesheetsService timesheetService;

    @PostMapping
    public ResponseEntity<Weeklytimesheets> createTimesheet(@RequestBody Weeklytimesheets timesheet) {
        return ResponseEntity.ok(timesheetService.saveTimesheet(timesheet));
    }

    @GetMapping("/{employeeId}/week")
    public ResponseEntity<List<Weeklytimesheets>> getWeekTimesheet(
        @PathVariable Long employeeId,
        @RequestParam("start") String start,
        @RequestParam("end") String end) {

        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);
        return ResponseEntity.ok(timesheetService.findByEmployeeIdAndWorkDateBetween(employeeId, startDate, endDate));
    }

    @GetMapping
    public ResponseEntity<List<Weeklytimesheets>> getTimesheets() {
        return ResponseEntity.ok(timesheetService.getAllTimesheets());
    }
}