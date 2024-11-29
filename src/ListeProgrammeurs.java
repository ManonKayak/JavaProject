import java.util.ArrayList;

public class ListeProgrammeurs {
    ArrayList<Programmeur> liste_programmeur_ = new ArrayList<>();

    public void addProgrammeur(Programmeur programmeur){
        liste_programmeur_.add(programmeur);
    }

    public void removeProgrammeur(Programmeur programmeur){
        liste_programmeur_.remove(programmeur);
    }
}
