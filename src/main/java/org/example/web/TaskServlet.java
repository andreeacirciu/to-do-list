package org.example.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.service.TaskService;
import org.example.transfer.CreateTaskRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/tasks")
public class TaskServlet extends HttpServlet {

    private TaskService taskService = new TaskService();

    //endpoint
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        //POJOs (= are doar proprietati si get si set)
        CreateTaskRequest request = objectMapper.readValue(req.getReader(), CreateTaskRequest.class);

        try {
            taskService.createTask(request);
        } catch (SQLException | ClassNotFoundException e) {
            resp.sendError(500, "There was an error while processing your request." + e.getMessage()); //500 = internal server error
        }
    }
}
