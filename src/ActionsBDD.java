import java.util.List;

public interface ActionsBDD {
    void AddDev(Programmeur dev);
    void DeleteDev(int id);
    Programmeur GetDev(int id);
    List<Programmeur> GetDevs();
}
