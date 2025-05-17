package com.example.weeklytimesheets.controller;

import com.example.weeklytimesheets.model.WeeklyTimesheet;
import com.example.weeklytimesheets.service.WeeklyTimesheetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

@RestController
@RequestMapping("/api/timesheets")
public class WeeklyTimesheetController {

    private final WeeklyTimesheetService service;

    public WeeklyTimesheetController(WeeklyTimesheetService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<WeeklyTimesheet> create(@RequestBody WeeklyTimesheet timesheet) {
        WeeklyTimesheet saved = service.save(timesheet);
        if (saved == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<WeeklyTimesheet>> getAll() {
        List<WeeklyTimesheet> timesheets = service.getAll();
        if (timesheets == null || timesheets.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(timesheets);
    }

    @GetMapping("/{employeeId}/week")
    public ResponseEntity<List<WeeklyTimesheet>> getByEmployeeAndWeek(
            @PathVariable Long employeeId,
            @RequestParam(name = "start") String start,
            @RequestParam(name = "end") String end) {
        try {
            LocalDate startDate = LocalDate.parse(start);
            LocalDate endDate = LocalDate.parse(end);
            List<WeeklyTimesheet> result = service.getByEmployeeAndWeek(employeeId, startDate, endDate);
            if (result == null || result.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(result);
        } catch (DateTimeParseException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
