import java.sql.SQLException;
import java.util.List;

/**
 * L'interface Actions bdd.
 */
public interface ActionsBDD {
    /**
     * Add dev.
     *
     * @param dev le programmeur à ajouter
     */
    void AddDev(Programmeur dev) throws SQLException;

    /**
     * Delete dev.
     *
     * @param id l'identifiant du programmeur à supprimer
     */
    void DeleteDev(int id);

    /**
     * Get dev.
     *
     * @param id l'identifiant du programmeur cherché
     * @return le programmeur
     */
    Programmeur GetDev(int id);

    /**
     * Get devs.
     *
     * @return la liste de tous les programmeurs
     */
    List<Programmeur> GetDevs();

    /**
     * Change dev.
     *
     *permet de changer les informations d'un programmeur
     * @param dev le programmeur dont on veut changer les informations
     */
    void ChangeDev(Programmeur dev);
}
