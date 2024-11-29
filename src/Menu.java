import java.util.*;
public class Menu {
    void afficherMenu(ListeProgrammeurs listeProgrammeurs){

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

        switch(choix){
            case "1":
                // afficherTousProgrammeurs(listeProgrammeur);
                break;
            case "2":
                System.out.println("Entrez l'identifiant du programmeur a afficher :");
                Scanner scanIdProg = new Scanner(System.in);
                String IdProg = scanIdProg.nextLine();
                // afficherProgrammeurParId(IdProg, listeProgrammeur);
                break;
            case "3":

                break;
            case "4":
                break;
            case "5":
                break;
            case "6":
                break;
            default:
                break;
        }
    }
}
