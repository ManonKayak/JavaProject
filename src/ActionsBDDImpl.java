import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * La class Actions bdd.
 *
 * Regroupe les différentes requêtes et actions à effectuer sur la table programmeur
 */
public class ActionsBDDImpl implements ActionsBDD {

    /**
     * Get Conn.
     *
     * permet d'etablir une connexion avec la base de donnée
     * @return la connexion obtenu
     */
    private Connection GetConn() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/programmeur",
                "root", "Vicente123@");
    }

    /**
     * Add dev.
     *
     * permet d'insérer un programmeur dans la base de donnée
     * @param dev le programmeur à ajouter
     */
    @Override
    public void AddDev(Programmeur dev) throws RuntimeException {
        try {
            var conn = GetConn();
            var stmt = conn.prepareStatement("INSERT INTO " +
                    "programmeur (ID, NOM, PRENOM, ADRESSE, PSEUDO, " +
                    "MANAGER, HOBBY, ANNAISSANCE, SALAIRE, PRIME) " +
                    "VALUES (?,?,?,?,?,?,?,?,?,?)");

            stmt.setInt(1, dev.getId());
            stmt.setString(2, dev.getNom());
            stmt.setString(3, dev.getPrenom());
            stmt.setString(4, dev.getAdresse());
            stmt.setString(5, dev.getPseudo());
            stmt.setString(6, dev.getManager());
            stmt.setString(7, dev.getHobby());
            stmt.setInt(8, dev.getAnNaissance());
            stmt.setDouble(9, dev.getSalaire());
            stmt.setDouble(10, dev.getPrime());

            stmt.executeUpdate();

            System.out.println("Le programmeur a bien ete ajoute !");

        }
        // Si l'on arrive pas à ajouter unn nouveau programmeur dans la base de donnée c'est qu'il en existe déjà un avec le même identifiant
        // L'identifiant étant unique cela nous renvoie une errreur
        catch (SQLException e) {
            System.out.println("Id non valide !");
        }
    }

    /**
     * Delete dev.
     *
     * @param id l'identifiant du programmeur à supprimer
     */
    @Override
    public void DeleteDev(int id) throws RuntimeException {
        try {
            var conn = GetConn();
            var stmt = conn.prepareStatement("DELETE FROM programmeur " +
                    "WHERE id = ?");

            stmt.setInt(1, id);

            stmt.executeUpdate();

        }
        catch (SQLException e) {
            System.out.println("Id non trouvee");
        }
    }

    /**
     * Get dev.
     *
     * @param id l'identifiant du programmeur cherché
     * @return le programmeur
     */
    @Override
    public Programmeur GetDev(int id) {
        try {
            var conn = GetConn();
            var stmt = conn.prepareStatement("SELECT * FROM programmeur WHERE ID = ?;");
            stmt.setInt(1,id);
            var res = stmt.executeQuery();
            res.next();
            return new Programmeur(res.getInt(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4),
                    res.getString(5),
                    res.getString(6),
                    res.getInt(7),
                    res.getFloat(8),
                    res.getFloat(9),
                    res.getString(10));

        }
        catch (SQLException e) {
            System.out.println("ID non trouvee");
            return null;
        }
    }

    /**
     * Get devs.
     *
     * @return la liste de tous les programmeurs
     */
    @Override
    public List<Programmeur> GetDevs(){
            try {
                var conn = GetConn();
                var stmt = conn.prepareStatement("SELECT * FROM programmeur");
                var res = stmt.executeQuery();
                var ret = new ArrayList<Programmeur>();

                while (res.next()) {
                    var dev = new Programmeur(res.getInt(1),
                            res.getString(2),
                            res.getString(3),
                            res.getString(4),
                            res.getString(5),
                            res.getString(6),
                            res.getInt(7),
                            res.getFloat(8),
                            res.getFloat(9),
                            res.getString(10));
                    ret.add(dev);

                }
                return ret;


            }
            catch (SQLException e) {
                System.out.println("Error: The table is empty");
                return null;
            }
    }

    /**
     * Change dev.
     *
     *permet de changer les informations d'un programmeur
     * @param dev le programmeur dont on veut changer les informations
     */
    public void ChangeDev(Programmeur dev) throws RuntimeException {
        // Ici l'utilisateur choisi l'élément qu'il souhaite changer
        System.out.println("Que souhaitez-vous modifier ?");
        System.out.println("1. Le nom");
        System.out.println("2. Le prenom");
        System.out.println("3. L'adresse");
        System.out.println("4. Le manager");
        System.out.println("5. Le hobby");
        System.out.println("6. L'annee de naissance");
        System.out.println("7. Le salaire");
        System.out.println("8. La prime");
        System.out.println("9. Le pseudo");

        Scanner scanModif = new Scanner(System.in);
        String modif = scanModif.nextLine();

        // Pour chaque cas, le nom de la colonne à modifier est différent
        // On a donc séparé tous les cas
        switch (modif){
            case "1":
                System.out.println("Entrez le nouveau nom du programmeur :");
                Scanner scanNomProg = new Scanner(System.in);
                String new_nom = scanNomProg.nextLine();
                dev.setNom(new_nom);
                try {
                    var conn = GetConn();
                    var stmt = conn.prepareStatement("UPDATE programmeur " +
                            "SET NOM = ?\n" +
                            "WHERE ID = ?");

                    stmt.setString(1, new_nom);
                    stmt.setInt(2, dev.getId());

                    stmt.executeUpdate();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;

            case "2":
                System.out.println("Entrez le nouveau prenom du programmeur :");
                Scanner scanPrenomProg = new Scanner(System.in);
                String new_prenom = scanPrenomProg.nextLine();
                dev.setPrenom(new_prenom);
                try{
                    var conn = GetConn();
                    var stmt = conn.prepareStatement("UPDATE programmeur " +
                            "SET PRENOM = ?\n" +
                            "WHERE ID = ?");
                    stmt.setString(1, new_prenom);
                    stmt.setInt(2, dev.getId());

                    stmt.executeUpdate();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;

            case "3":
                System.out.println("Entrez la nouvelle adresse du programmeur :");
                Scanner scanAdress = new Scanner(System.in);
                String new_adress = scanAdress.nextLine();
                dev.setAdresse(new_adress);
                try{
                    var conn = GetConn();
                    var stmt = conn.prepareStatement("UPDATE programmeur " +
                            "SET ADRESSE = ?\n" +
                            "WHERE ID = ?");
                    stmt.setString(1, new_adress);
                    stmt.setInt(2, dev.getId());

                    stmt.executeUpdate();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;

            case "4":
                System.out.println("Entrez le nouveau manager du programmeur :");
                Scanner scanManager = new Scanner(System.in);
                String new_manager = scanManager.nextLine();
                dev.setManager(new_manager);
                try{
                    var conn = GetConn();
                    var stmt = conn.prepareStatement("UPDATE programmeur " +
                            "SET MANAGER = ?\n" +
                            "WHERE ID = ?");
                    stmt.setString(1, new_manager);
                    stmt.setInt(2, dev.getId());
                    stmt.executeUpdate();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;

            case "5":
                System.out.println("Entrez le nouvel hobby du programmeur :");
                Scanner scanHobby = new Scanner(System.in);
                String new_hobby = scanHobby.nextLine();
                dev.setHobby(new_hobby);
                try{
                    var conn = GetConn();
                    var stmt = conn.prepareStatement("UPDATE programmeur " +
                            "SET HOBBY = ?\n" +
                            "WHERE ID = ?");
                    stmt.setString(1, new_hobby);
                    stmt.setInt(2, dev.getId());
                    stmt.executeUpdate();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;

            case "6":
                System.out.println("Entrez la nouvelle annee de naissance du programmeur :");
                Scanner scanAnNaissance = new Scanner(System.in);
                int new_AnNaissance = Integer.parseInt(scanAnNaissance.nextLine());
                dev.setAnNaissance(new_AnNaissance);
                try{
                    var conn = GetConn();
                    var stmt = conn.prepareStatement("UPDATE programmeur " +
                            "SET ANNAISSANCE = ?\n" +
                            "WHERE ID = ?");
                    stmt.setInt(1, new_AnNaissance);
                    stmt.setInt(2, dev.getId());
                    stmt.executeUpdate();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;

            case "7":
                System.out.println("Entrez le nouveau salaire du programmeur :");
                Scanner scanSalaire = new Scanner(System.in);
                float new_salaire = Float.parseFloat(scanSalaire.nextLine());
                dev.setSalaire(new_salaire);
                try{
                    var conn = GetConn();
                    var stmt = conn.prepareStatement("UPDATE programmeur " +
                            "SET SALAIRE = ?\n" +
                            "WHERE ID = ?");
                    stmt.setFloat(1, new_salaire);
                    stmt.setInt(2, dev.getId());
                    stmt.executeUpdate();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;

            case "8":
                System.out.println("Entrez la nouvelle prime du programmeur :");
                Scanner scanPrime = new Scanner(System.in);
                float new_prime = Float.parseFloat(scanPrime.nextLine());
                dev.setPrime(new_prime);
                try{
                    var conn = GetConn();
                    var stmt = conn.prepareStatement("UPDATE programmeur " +
                            "SET PRIME = ?\n" +
                            "WHERE ID = ?");
                    stmt.setFloat(1, new_prime);
                    stmt.setInt(2, dev.getId());
                    stmt.executeUpdate();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;

            case "9":
                System.out.println("Entrez le nouveau manager du programmeur :");
                Scanner scanPseudo = new Scanner(System.in);
                String new_pseudo = scanPseudo.nextLine();
                dev.setPseudo(new_pseudo);
                try{
                    var conn = GetConn();
                    var stmt = conn.prepareStatement("UPDATE programmeur " +
                            "SET PSEUDO = ?\n" +
                            "WHERE ID = ?");
                    stmt.setString(1, new_pseudo);
                    stmt.setInt(2, dev.getId());
                    stmt.executeUpdate();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            default:
                System.out.println("Option non valide !");
                break;
        }

    }
}
