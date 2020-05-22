package org.example.transfer;

import java.time.LocalDate;

//DTO (Data Transfer Object)
public class CreateTaskRequest {

    private String description;
    private LocalDate deadLine;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        this.deadLine = deadLine;
    }

    @Override
    public String toString() {
        return "CreateTaskRequest{" +
                "description='" + description + '\'' +
                ", deadLine=" + deadLine +
                '}';
    }
}
