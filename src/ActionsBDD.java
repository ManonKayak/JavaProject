import java.util.List;

public interface ActionsBDD {
    public void AddDev(Programmeur dev);
    public void DeleteDev(int id);
    public Programmeur GetDev(int id);
    public List<Programmeur> GetDevs();
}
