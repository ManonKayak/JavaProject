import java.sql.SQLException;
import java.util.List;

public interface ActionsBDD {
    void AddDev(Programmeur dev) throws SQLException;
    void DeleteDev(int id);
    Programmeur GetDev(int id);
    List<Programmeur> GetDevs();
}
