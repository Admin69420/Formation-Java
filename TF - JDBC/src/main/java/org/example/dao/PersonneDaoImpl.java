package org.example.dao;

import org.example.ConnectionFactory;
import org.example.Personne;
import org.example.dao.PersonneDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonneDaoImpl implements PersonneDAO {


	@Override
    public void create(Personne p){

        String requete=  "INSERT INTO personne VALUES (DEFAULT,?,?)";

        try (Connection connection = ConnectionFactory.createConnection();
             PreparedStatement statement = connection.prepareStatement(requete)){

            statement.setString(1,p.getPrenom());
            statement.setString(2,p.getNom());

            statement.execute();

        }catch (SQLException e){
            throw new RuntimeException("create error",e);
        }

    }

    @Override
    public Optional<Personne> getOne(Long id){

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

    @Override
    public List<Personne> getAll(){

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

    @Override
    public void delete(Long id){
        String requete=  "DELETE FROM personne WHERE id=" + id;

        try (Connection connection = ConnectionFactory.createConnection();
             Statement statement = connection.createStatement()){
            statement.execute(requete);

        }catch (SQLException e){
            throw new RuntimeException("create error",e);
        }
    }

    @Override
	public boolean update(Long id, Personne p){

        String requete = "UPDATE personne SET prenom = ?, nom = ? WHERE id = "+id;

        try (Connection connection = ConnectionFactory.createConnection();
             PreparedStatement statement = connection.prepareStatement(requete)){

            statement.setString(1, p.getPrenom());
            statement.setString(2,p.getNom());

            statement.executeUpdate();
            return true;

        }catch (SQLException e){
            throw new RuntimeException("create error",e);
        }
    }
}
