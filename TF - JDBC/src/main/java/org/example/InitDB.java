package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InitDB {

    public static void initialisation(){
        String requete = """
            DROP TABLE IF EXISTS personne;
            CREATE TABLE personne (id serial PRIMARY KEY, prenom varchar(50), nom varchar(50));
            INSERT INTO personne VALUES (DEFAULT, 'Krystelle', 'Brosteau');
            INSERT INTO personne VALUES (DEFAULT, 'Ryan', 'Costache');
            INSERT INTO personne VALUES (DEFAULT, 'Kadir', 'Kiratli');
            INSERT INTO personne VALUES (DEFAULT, 'Jean-Marc', 'Lebrun');
            INSERT INTO personne VALUES (DEFAULT, 'Louis', 'Hendricx');
            INSERT INTO personne VALUES (DEFAULT, 'Hervé', 'Mwamba Muteba');
            INSERT INTO personne VALUES (DEFAULT, 'Marie-Cécile', 'Duez');
            """;

        try (Connection connection = ConnectionFactory.createConnection();
             Statement statement = connection.createStatement()){
            statement.execute(requete);

        }catch (SQLException e){
            throw new RuntimeException("error",e);
        }
    }
}
