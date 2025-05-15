package com.example.weeklytimesheets.Repo;

import com.example.weeklytimesheets.models.Weeklytimesheets;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface WeeklyTimesheetRepository extends JpaRepository<Weeklytimesheets, Long> {
    List<Weeklytimesheets> findByEmployeeIdAndWorkDateBetween(Long employeeId, LocalDate start, LocalDate end);
}