package com.example.weeklytimesheets.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.weeklytimesheets.Repo.WeeklyTimesheetRepository;
import com.example.weeklytimesheets.models.Weeklytimesheets;

@Service
public class WeeklyTimeSheetsService {
    @Autowired
    private WeeklyTimesheetRepository timesheetRepo;

    public List<Weeklytimesheets> getAllTimesheets(){
        return timesheetRepo.findAll();
    }

    public Weeklytimesheets saveTimesheets(Weeklytimesheets Weeklytimesheets){
        return timesheetRepo.save(timesheet);
    }
}
