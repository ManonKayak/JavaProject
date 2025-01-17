import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws SQLException {
        while(true){
        try {
            // Étape 1 : Démarrer Docker Compose
            System.out.println("Démarrage de Docker Compose...");
            ProcessBuilder dockerCompose = new ProcessBuilder(
                    "docker-compose", "-f", "docker-compose.yml", "up", "-d"
            );
            Process composeProcess = dockerCompose.start();

            // Étape 2 : Attendre que la base de données soit prête
            System.out.println("Attente que la base de données soit prête...");
            boolean baseDeDonneesPrete = false;
            while (!baseDeDonneesPrete) {
                ProcessBuilder verifierBase = new ProcessBuilder(
                        "docker", "exec", "programmeur_data", "mysqladmin", "ping", "-h", "localhost", "--silent"
                );
                Process verifierProcess = verifierBase.start();
                verifierProcess.waitFor();
                baseDeDonneesPrete = (verifierProcess.exitValue() == 0); // Si 0, la base est prête
                if (!baseDeDonneesPrete) {
                    Thread.sleep(2000); // Attendre 2 secondes avant de réessayer
                }
            }
            System.out.println("Base de données prête !");

            // Étape 3 : Exécuter l'application principale
            System.out.println("Lancement de l'application Java...");
            // Ici, mettez votre code principal
        } catch (Exception e) {
            e.printStackTrace();
        }

        ListeProgrammeurs listeProgrammeur = new ListeProgrammeurs();
            try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/programmeur","root", "Vicente123@");
            PreparedStatement prstmt = connection.prepareStatement("SELECT * FROM programmeur");
            ResultSet resultSet = prstmt.executeQuery();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            while(resultSet.next()){
                    int id = resultSet.getInt("ID");
                    String nom = resultSet.getString("NOM");
                    String prenom = resultSet.getString("PRENOM");
                    String adresse = resultSet.getString("ADRESSE");
                    String manager = resultSet.getString("MANAGER");
                    String hobby = resultSet.getString("HOBBY");
                    int anNaissance = resultSet.getInt("ANNAISSANCE");
                    float salaire = resultSet.getFloat("SALAIRE");
                    float prime = resultSet.getFloat("PRIME");
                    String pseudo = resultSet.getString("PSEUDO");
                    Programmeur programmeur = new Programmeur(id,nom, prenom,adresse,manager,hobby, anNaissance, salaire, prime, pseudo);
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
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/programmeur","root", "Vicente123@");
            Statement stmt = connection.createStatement();
            stmt.execute("CREATE TABLE programmeur(" +
                    "ID INT PRIMARY KEY," +
                    "NOM VARCHAR(50) NOT NULL," +
                    "PRENOM VARCHAR(50) NOT NULL," +
                    "ADRESSE VARCHAR(50) NOT NULL," +
                    "MANAGER VARCHAR(50) NOT NULL," +
                    "HOBBY VARCHAR(50) NOT NULL," +
                    "ANNAISSANCE INT NOT NULL," +
                    "SALAIRE FLOAT NOT NULL," +
                    "PRIME FLOAT NOT NULL," +
                    "PSEUDO VARCHAR(50) NOT NULL)");
        }
            Menu.afficherMenu(listeProgrammeur);

    }
}
}