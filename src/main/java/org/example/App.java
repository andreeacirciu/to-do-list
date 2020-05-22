package org.example;

import org.example.persistance.TaskRepository;
import org.example.transfer.CreateTaskRequest;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, SQLException {
        CreateTaskRequest request = new CreateTaskRequest();
        request.setDescription("Learn JDBC");
        request.setDeadLine(LocalDate.now().plusWeeks(2));

        TaskRepository taskRepository = new TaskRepository();
        taskRepository.createTask(request);
    }
}
