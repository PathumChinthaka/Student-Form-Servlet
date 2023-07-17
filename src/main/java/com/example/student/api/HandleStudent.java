package com.example.student.api;

import com.example.student.dto.StudentDTO;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/student", loadOnStartup = 1)
public class HandleStudent extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")) {
            resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        }

        Jsonb jsonb = JsonbBuilder.create();

        StudentDTO studentDTO = jsonb.fromJson(req.getReader(), StudentDTO.class);
        if (studentDTO.getName() == null || !studentDTO.getName().matches("")) {
            throw new RuntimeException("Invalid student name !");
        } else if (studentDTO.getCity() == null || !studentDTO.getCity().matches("")) {
            throw new RuntimeException("Invalid student city !");
        } else if (studentDTO.getEmail() == null || !studentDTO.getEmail().matches("")) {
            throw new RuntimeException("Invalid mail !");
        } else if (String.valueOf(studentDTO.getLevel()) == null || !studentDTO.getCity().matches("")) {
            throw new RuntimeException("Invalid student level!");
        }

        String name = req.getParameter("name");
        String city = req.getParameter("city");
        String email = req.getParameter("email");
        String level = req.getParameter("level");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/ javaeeproj1", "root", "1234");
            String sql = "INSERT INTO student ( name) VALUES (?, ?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, studentDTO.getName());
            statement.setString(2, studentDTO.getCity());
            statement.setString(3, studentDTO.getEmail());
            statement.setObject(4, studentDTO.getLevel());
            statement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
