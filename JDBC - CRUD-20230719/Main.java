package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Personne p = new Personne();
        p.name="Dupont";
        p.firstname="Julien";

        try {
            Connection connection = ConnectionFactory.createConnection();
            System.out.println("Connected");
            Statement statement = connection.createStatement();
            statement.execute(RequeteSQL.creationTable("personne"));
            statement.execute(RequeteSQL.create(p));

        }catch (SQLException e){
            throw new RuntimeException("error",e);
        }
    }
}