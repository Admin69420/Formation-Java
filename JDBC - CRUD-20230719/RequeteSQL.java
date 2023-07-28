package org.example;

public class RequeteSQL {

	public static String creationTable(String nomTable){
        return "CREATE TABLE " +
                 nomTable
                +" (colonne1 varchar(50), colonne2 varchar(50))";
    }

    public static String create(Personne p){
        return "INSERT INTO personne VALUES ('"
                +p.name+"', '"
                +p.firstname+"')";
    }


}
