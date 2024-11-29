import java.sql.*;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        ListeProgrammeurs listeProgrammeur = new ListeProgrammeurs();

        try{
            Class.forName("jbdc:mysql://localhost:3306/bdtpjava");
            Connection connection = DriverManager.getConnection("jbdc:mysql://localhost:3306/bdtpjava", "root", "Manon2004!");
            PreparedStatement prstmt = connection.prepareStatement("SELECT * FROM programmeur");
            ResultSet resultSet = prstmt.executeQuery();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            while(resultSet.next()){
                    String nom = resultSet.getString("NOM");
                    String prenom = resultSet.getString("PRENOM");
                    String anNaissance = resultSet.getString("ANNAISSANCE");
                    String salaire = resultSet.getString("SALAIRE");
                    String prime = resultSet.getString("PRIME");
                    String pseudo = resultSet.getString("PSEUDO");
                    Programmeur programmeur = new Programmeur(nom, prenom, anNaissance, salaire, prime, pseudo);
                    listeProgrammeur.addProgrammeur(programmeur);
            }

            for(Programmeur programmeur : listeProgrammeur.liste_programmeur_){
                System.out.println(programmeur);
            }
            for(Programmeur programmeur : listeProgrammeur.liste_programmeur_){
                if(!Objects.equals(programmeur.getNom(), "Simpson")){
                    System.out.println(programmeur);
                }
            }

            prstmt.close();
            connection.close();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}