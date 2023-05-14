package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDAO {

    private DatabaseConnection databaseConnection;

    private int id;
    private static final String SELECT_ALL = "SELECT * from cars";

    public CarDAO(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public List<Car> getAllCars() {
        try (Connection connection = databaseConnection.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL);

            List<Car> cars = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String country = resultSet.getString(3);
                Car car = new Car(id, name, country);
                cars.add(car);
            }

            return cars;
        } catch (SQLException e) {

        }
        return new ArrayList<>();
    }

    public List<Car> getOneCar(int numberId) throws SQLException {
        Connection connection = databaseConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT name, country FROM cars WHERE id = " + numberId);
        List<Car> carOne = new ArrayList<>();
        while (resultSet.next() ) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String country = resultSet.getString(3);
            if (numberId == id) {
                Car car = new Car(id, name, country);
                carOne.add(car);
            }

        }
        return  carOne;
    }



    public void insertCar(Car car) throws SQLException {
        Connection connection = databaseConnection.getConnection();
        Statement statement = connection.createStatement();
        String query = "INSERT INTO cars VALUES (" + car.getId() + ", '" + car.getName() + "', '" + car.getCountry() + "');";
        statement.execute(query);
    }

    public void deleteCar(Car car) throws SQLException {
        Connection connection = databaseConnection.getConnection();
        Statement statement = connection.createStatement();
        String qqqq = "DELETE FROM cars WHERE id = " + car.getId() + " and name = '" + car.getName() + "' and country = '" + car.getCountry() + "' ;";
        statement.execute(qqqq);
    }

    public void updateCar(Car car) throws SQLException {
        Connection connection = databaseConnection.getConnection();
        Statement statement = connection.createStatement();
        String www ="UPDATE cars SET name = '"  + car.getName() +"',  country = '" + car.getCountry() +  "' WHERE id = "  + car.getId() + ";";
        statement.execute(www);
    }

}