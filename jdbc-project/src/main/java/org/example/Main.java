package org.example;

import java.sql.*;


public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseConnection databaseConnection
                = new DatabaseConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "qazwsx");
        CarDAO carDAO = new CarDAO(databaseConnection);

        Car car = new Car(100, "qwerty", "ENGLAND");

//        System.out.println(carDAO.getAllCars());
        System.out.println(carDAO.getOneCar(1));//Не могу никак ошибку найти
//        carDAO.insertCar(car);
//        carDAO.deleteCar(car);
//        carDAO.updateCar(car);

    }
}