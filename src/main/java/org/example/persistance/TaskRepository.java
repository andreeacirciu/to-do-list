package org.example.persistance;

import org.example.transfer.CreateTaskRequest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TaskRepository {

    public void createTask(CreateTaskRequest request) throws IOException, SQLException {

        //preventing SQL Injection by using PreparedStatement
        String sql = "INSERT INTO task (description, deadline) VALUES (?, ?)";

        //try-with-resources inchide singur resursele nu mai trebuie sa pun try-finnaly
        try (Connection connection = DatabaseConfiguration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, request.getDescription());
            preparedStatement.setDate(2, Date.valueOf(request.getDeadLine()));

            preparedStatement.executeUpdate();
        }
    }
}
