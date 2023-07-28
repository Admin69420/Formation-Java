package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RequeteSimple {



    public static void create(Personne p){

        String requete=  "INSERT INTO personne VALUES (DEFAULT,'"
                +p.getNom() +"', '"
                +p.getPrenom() +"')";

        try (Connection connection = ConnectionFactory.createConnection();
             Statement statement = connection.createStatement()){
            statement.execute(requete);

        }catch (SQLException e){
            throw new RuntimeException("create error",e);
        }

    }

    public static Optional<Personne> getOne(long id){

        String requete=  "SELECT * FROM personne WHERE id="+id;

        try (Connection connection = ConnectionFactory.createConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(requete)){


            if( rs.next() ){
                Personne p = new Personne();
                p.setId(rs.getLong("id"));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));

                return Optional.of(p);

            }
            else
                return Optional.empty();


        }catch (SQLException e){
            throw new RuntimeException("create error",e);
        }

    }

    public static List<Personne> getAll(){

        String requete=  "SELECT * FROM personne";

        try (Connection connection = ConnectionFactory.createConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(requete)){

            List<Personne> liste = new ArrayList<>();

            while( rs.next() ){
                Personne p = new Personne();
                p.setId(rs.getLong("id"));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));

                liste.add(p);

            }

            return liste;


        }catch (SQLException e){
            throw new RuntimeException("create error",e);
        }

    }

    public static void delete(long id){
        String requete=  "DELETE FROM personne WHERE id=" + id;

        try (Connection connection = ConnectionFactory.createConnection();
             Statement statement = connection.createStatement()){
            statement.execute(requete);

        }catch (SQLException e){
            throw new RuntimeException("create error",e);
        }
    }

	public static void update(long id, Personne p){

        String requete = "UPDATE personne SET prenom = '" + p.getPrenom() + "', nom = '" + p.getNom() +"' WHERE id = "+id;

        try (Connection connection = ConnectionFactory.createConnection();
             Statement statement = connection.createStatement()){
            statement.executeUpdate(requete);

        }catch (SQLException e){
            throw new RuntimeException("create error",e);
        }
    }
}
