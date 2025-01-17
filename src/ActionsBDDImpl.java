import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class ActionsBDDImpl implements ActionsBDD {
    private Properties _prop;
    public ActionsBDDImpl(Properties prop) {
        _prop = prop;
    }

    private Connection GetConn() throws SQLException {
        return DriverManager.getConnection(_prop.getProperty("DB_URL"),
                _prop.getProperty("DB_USER"), _prop.getProperty("DB_PSSWD"));
    }

    @Override
    public void AddDev(Programmeur dev) throws RuntimeException {
        try {
            var conn = GetConn();
            var stmt = conn.prepareStatement("INSERT INTO " +
                    "programmer (lastname, firstname, address, pseudo, " +
                    "manager, hobby, birth_year, salary, bonus) " +
                    "VALUES (?,?,?,?,?,?,?,?,?)");

            stmt.setString(1, dev.getNom());
            stmt.setString(2, dev.getPrenom());
            stmt.setString(3, dev.getAdresse());
            stmt.setString(4, dev.getPseudo());
            stmt.setString(5, dev.getManager());
            stmt.setString(6, dev.getHobby());
            stmt.setInt(7, dev.getAnNaissance());
            stmt.setFloat(8, dev.getSalaire());
            stmt.setFloat(9, dev.getPrime());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void DeleteDev(int id) throws RuntimeException {
        try {
            var conn = GetConn();
            var stmt = conn.prepareStatement("DELETE FROM programmer " +
                    "WHERE id = ?");

            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Id non trouvee");
        }
    }

    @Override
    public Programmeur GetDev(int id) {
        try {
            var conn = GetConn();
            var stmt = conn.prepareStatement("SELECT " +
                    "(id, lastname, firstname, address, manager, " +
                    "hobby, birth_year, salary, bonus, pseudo) " +
                    "FROM programmer " +
                    "WHERE id = ?");

            stmt.setInt(1, id);

            var res = stmt.executeQuery();

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

        } catch (SQLException e) {
            System.out.println("ID non trouvee");
            return null;
        }
    }

    @Override
    public List<Programmeur> GetDevs(){
            try {
                var conn = GetConn();
                var stmt = conn.prepareStatement("SELECT " +
                        "(id, lastname, firstname, address, manager, " +
                        "hobby, birth_year, salary, bonus, pseudo) " +
                        "FROM programmer");

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
                    return ret;
                }


            } catch (SQLException e) {
                System.out.println("Error: The table is empty");
                return null;
            }

            return null;
    }

    @Override
    public void ChangeDev(Programmeur dev) throws RuntimeException {
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

        switch (modif){
            case "1":
                System.out.println("Entrez le nouveau nom du programmeur :");
                Scanner scanNomProg = new Scanner(System.in);
                String new_nom = scanNomProg.nextLine();
                dev.setNom(new_nom);
                try {
                    var conn = GetConn();
                    var stmt = conn.prepareStatement("UPDATE programmer" +
                            "SET NOM = ?\n" +
                            "WHERE id = ?");

                    stmt.setString(2, new_nom);
                    stmt.setInt(3, dev.getId());

                    stmt.executeUpdate();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;

            case "2":
                break;

            case "3":
                break;

            case "4":
                break;

            case "5":
                break;

            case "6":
                break;

            case "8":
                break;

            case "9":
            default:
                System.out.println("Option non valide !");
                break;
        }

    }
}
