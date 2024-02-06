package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        executeRequest();
    }

    public static void executeRequest() {
        try (Connection cn = DriverManager.getConnection(
                "jdbc:mysql://localhost/javadb",
                "root",
                "f32*AG17re9!")) {

            System.out.println("All employees:");
            getAllEmployees(cn);

            System.out.println("\nAll tasks:");
            getAllTasks(cn);

            System.out.println("\nGet all employees of 3 department:");
            getEmployeesByDepartment(cn, 3);

            System.out.println("\nAdd task for employee 3:");
            addTaskForSpecificEmployee(cn, 3, "Think more");

            System.out.println("\nAll tasks after adding new task:");
            getAllTasks(cn);

            System.out.println("\nGet all tasks fro employee 1:");
            getTasksForEmployee(cn, 1);

            System.out.println("\nDelete employee with id:");
            deleteEmployee(cn, 6);

            System.out.println("All employees after deleting employee:");
            getAllEmployees(cn);
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void getAllEmployees(Connection cn) {
        try (PreparedStatement ps = cn.prepareStatement("SELECT * FROM Employees");
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("empId");
                String lastName = rs.getString("lastName");
                String firstName = rs.getString("firstName");
                String position = rs.getString("position");
                int depId = rs.getInt("depId");

                if (position == null) position = "No position";

                System.out.println("Employee id: " + id);
                System.out.println("Name: " + firstName + " " + lastName);
                System.out.println("Position: " + position);
                System.out.println("Department id: " + depId);
                System.out.println();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void getAllTasks(Connection cn) {
        try (PreparedStatement ps = cn.prepareStatement("SELECT * FROM Tasks");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("taskId");
                String taskDesc = rs.getString("taskDesc");
                int empId = rs.getInt("empId");

                System.out.println("Task id: " + id);
                System.out.println("Description: " + taskDesc);
                System.out.println("Employee id: " + empId);
                System.out.println();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void getEmployeesByDepartment(Connection cn, int defDepId) {
        try (PreparedStatement ps = cn.prepareStatement("SELECT * FROM Employees WHERE depId = ?")) {
            ps.setInt(1, defDepId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) { // Iterate through the result set
                    int id = rs.getInt("empId");
                    String lastName = rs.getString("lastName");
                    String firstName = rs.getString("firstName");
                    String position = rs.getString("position");
                    int depId = rs.getInt("depId");

                    if (position == null) position = "No position";

                    System.out.println("Employee id: " + id);
                    System.out.println("Name: " + firstName + " " + lastName);
                    System.out.println("Position: " + position);
                    System.out.println("Department id: " + depId);
                    System.out.println();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void addTaskForSpecificEmployee(Connection cn, int empId, String taskDesc) {
        try (PreparedStatement ps = cn.prepareStatement("INSERT INTO Tasks (taskDesc, empId) VALUES (?, ?)")) {
            ps.setString(1, taskDesc);
            ps.setInt(2, empId);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Task added successfully for Employee ID: " + empId);
            } else {
                throw new SQLException("Failed to add task for Employee ID: " + empId);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void getTasksForEmployee(Connection cn, int empId) {
        try (PreparedStatement ps = cn.prepareStatement("SELECT * FROM Tasks WHERE empId = ?")) {
            ps.setInt(1, empId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("taskId");
                    String taskDesc = rs.getString("taskDesc");
                    int employeeId = rs.getInt("empId");

                    System.out.println("Task id: " + id);
                    System.out.println("Description: " + taskDesc);
                    System.out.println("Employee id: " + employeeId);
                    System.out.println();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void deleteEmployee(Connection cn, int empId) {
        try (PreparedStatement ps = cn.prepareStatement("DELETE FROM Employees WHERE empId = ?")) {
            ps.setInt(1, empId);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Employee deleted: " + empId);
            } else {
                throw new SQLException("Failed to delete employee with ID: " + empId);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}