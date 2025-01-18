import java.sql.SQLException;
import java.util.List;

/**
 * The interface Actions bdd.
 */
public interface ActionsBDD {
    /**
     * Add dev.
     *
     * @param dev the dev
     * @throws SQLException the sql exception
     */
    void AddDev(Programmeur dev) throws SQLException;

    /**
     * Delete dev.
     *
     * @param id the id
     */
    void DeleteDev(int id);

    /**
     * Get dev programmeur.
     *
     * @param id the id
     * @return the programmeur
     */
    Programmeur GetDev(int id);

    /**
     * Get devs list.
     *
     * @return the list
     */
    List<Programmeur> GetDevs();

    /**
     * Change dev.
     *
     * @param dev the dev
     */
    void ChangeDev(Programmeur dev);
}
