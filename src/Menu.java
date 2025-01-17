import java.util.*;
public class Menu {
    static void afficherMenu(List<Programmeur> listeProgrammeurs){

        boolean run = true;

        while(run){
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<< MENU >>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("1. Afficher tous les programmeurs");
            System.out.println("2. Afficher un programmeur");
            System.out.println("3. Supprimer un programmeur");
            System.out.println("4. Ajouter un programmeur");
            System.out.println("5. Modifier le salaire");
            System.out.println("6. Quitter le programme");
            System.out.println("Quel est votre choix ?");

            Scanner scanChoix = new Scanner(System.in);
            String choix = scanChoix.nextLine();

            Properties prop = new Properties();
            ActionsBDDImpl action = new ActionsBDDImpl(prop);

            switch(choix) {
                case "1":
                    List<Programmeur> programmeurs = action.GetDevs();
                    System.out.println(programmeurs);
                    break;
                case "2":
                    System.out.println("Entrez l'identifiant du programmeur a afficher :");
                    Scanner scanIdProg = new Scanner(System.in);
                    int IdProg = scanIdProg.nextInt();
                    Programmeur programmeur = action.GetDev(IdProg);
                    System.out.println(programmeur);
                    break;
                case "3":
                    System.out.println("Entrez l'identifiant du programmeur a supprimer :");
                    scanIdProg = new Scanner(System.in);
                    IdProg = scanIdProg.nextInt();
                    action.DeleteDev(IdProg);
                    System.out.println("Programmeur " + IdProg + " a ete supprime !");
                    break;
                case "4":
                    // on doit récupérer les infos pour pouvoir initialiser le programmeur
                    programmeur = new Programmeur();
                    action.AddDev(programmeur);
                    System.out.println("Le programmeur a bien ete ajoute !");
                    break;
                case "5":
                    System.out.println("Entrez l'identifiant du programmeur a modifier :");

                    break;
                case "6":
                    run = false;
                    break;
                default:
                    break;
            }
        }
    }
}
