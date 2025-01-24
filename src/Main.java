import java.sql.*;

public class Main {
    /**
     * L'entrée dans le programme.
     *
     * @param args
     * @throws SQLException
     */
    // On avait une class start qui n'aurait fait qu'appeler la class Main
    // Nous savons que vous aviez demandez une ou deux lignes dans le main, mais ne n'avons pas vu l'intérêt de garder une class pour une seule ligne
    public static void main(String[] args) throws SQLException {
        try {
            // Demarre Docker Compose
            System.out.println("Démarrage de Docker Compose...");
            ProcessBuilder dockerCompose = new ProcessBuilder(
                    "docker-compose", "-f", "docker-compose.yml", "up", "-d"
            );
            Process composeProcess = dockerCompose.start();

            // Attend que la base de données soit prête
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

            // Execute l'application principale
            System.out.println("Lancement de l'application Java...");

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Teste si la table programmeur existe
        // Si une erreur apparait en selectionnant les programmeurs de la table,
        // cela est très probable qu'elle n'existe pas. On la créer donc
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/programmeur","root", "Vicente123@");
            PreparedStatement prstmt = connection.prepareStatement("SELECT * FROM programmeur");
            prstmt.executeQuery();
            prstmt.close();
            connection.close();
        }
        catch (SQLException e) {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/programmeur","root", "Vicente123@");
            Statement stmt = connection.createStatement();
            stmt.execute("CREATE TABLE programmeur(" +
                    "ID INT AUTO_INCREMENT PRIMARY KEY," +
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

        // Affiche le menu et permet de modifier la table
        Menu.afficherMenu();

    }
}