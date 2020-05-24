package org.example;

import org.example.domain.Task;
import org.example.persistance.TaskRepository;
import org.example.transfer.CreateTaskRequest;
import org.example.transfer.UpdateTaskRequest;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, SQLException, ClassNotFoundException {
        CreateTaskRequest request = new CreateTaskRequest();
        request.setDescription("Learn JDBC");
        request.setDeadLine(LocalDate.now().plusWeeks(2));

        TaskRepository taskRepository = new TaskRepository();
        taskRepository.createTask(request);

//        UpdateTaskRequest updateRequest = new UpdateTaskRequest();
//        updateRequest.setDone(true);
//
//        taskRepository.updateTask(1, updateRequest);

//        taskRepository.deleteTask(2);

        List<Task> tasks = taskRepository.getTasks();
        System.out.println(tasks);
    }
}
