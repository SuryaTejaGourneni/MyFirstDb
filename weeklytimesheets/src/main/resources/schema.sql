CREATE TABLE timesheet (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    employee_id BIGINT NOT NULL,
    project_id BIGINT NOT NULL,
    work_date DATE NOT NULL,
    hours_worked DOUBLE
);