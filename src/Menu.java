import java.util.*;
public class Menu {
    public static void attendreUneTouche(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Appuyez sur Entrée pour continuer...");
        scanner.nextLine(); // Attend que l'utilisateur appuie sur Entrée
    }
    static void afficherMenu(){

        boolean run = true;

        while(run){
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<< MENU >>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("1. Afficher tous les programmeurs");
            System.out.println("2. Afficher un programmeur");
            System.out.println("3. Supprimer un programmeur");
            System.out.println("4. Ajouter un programmeur");
            System.out.println("5. Modifier une information de programmeur");
            System.out.println("6. Quitter le programme");
            System.out.println("Quel est votre choix ?");

            Scanner scanChoix = new Scanner(System.in);
            String choix = scanChoix.nextLine();

            ActionsBDDImpl action = new ActionsBDDImpl();
            List<Programmeur> listeProgrammeurs = action.GetDevs();

            switch(choix) {
                case "1":
                    List<Programmeur> programmeurs = action.GetDevs();
                    for (Programmeur element : programmeurs){
                        System.out.println(element);
                    }
                    attendreUneTouche();
                    break;

                case "2":
                    System.out.println("Entrez l'identifiant du programmeur a afficher :");
                    Scanner scanIdProg = new Scanner(System.in);
                    int IdProg = scanIdProg.nextInt();
                    Programmeur programmeur = action.GetDev(IdProg);
                    if(programmeur != null) System.out.println(programmeur);
                    else System.out.println("Le programmeur "+IdProg+" n'a pas ete trouve");
                    attendreUneTouche();
                    break;

                case "3":
                    System.out.println("Entrez l'identifiant du programmeur a supprimer :");
                    scanIdProg = new Scanner(System.in);
                    IdProg = scanIdProg.nextInt();
                    action.DeleteDev(IdProg);
                    System.out.println("Programmeur " + IdProg + " a ete supprime !");
                    attendreUneTouche();
                    break;

                case "4":
                    System.out.println("Entrez les informations du nouveau programmeur :");
                    System.out.println("Id :");
                    scanIdProg = new Scanner(System.in);
                    IdProg = scanIdProg.nextInt();

                    System.out.println("Nom :");
                    Scanner scanNomProg = new Scanner(System.in);
                    String NomProg = scanNomProg.nextLine();

                    System.out.println("Prenom :");
                    Scanner scanPrenomProg = new Scanner(System.in);
                    String PrenomProg = scanPrenomProg.nextLine();

                    System.out.println("Adresse :");
                    Scanner scanAdresseProg = new Scanner(System.in);
                    String AdresseProg = scanAdresseProg.nextLine();

                    System.out.println("Manager :");
                    Scanner scanManagerProg = new Scanner(System.in);
                    String ManagerProg = scanManagerProg.nextLine();

                    System.out.println("Hobby :");
                    Scanner scanHobbyProg = new Scanner(System.in);
                    String HobbyProg = scanHobbyProg.nextLine();

                    System.out.println("AnNaissance :");
                    Scanner scanNaissanceProg = new Scanner(System.in);
                    int NaissanceProg = scanNaissanceProg.nextInt();

                    System.out.println("Salaire :");
                    Scanner scanSalaireProg = new Scanner(System.in).useLocale(Locale.US);
                    float SalaireProg = scanSalaireProg.nextFloat();

                    System.out.println("Prime :");
                    Scanner scanPrimeProg = new Scanner(System.in).useLocale(Locale.US);
                    float PrimeProg = scanPrimeProg.nextFloat();

                    System.out.println("Pseudo :");
                    Scanner scanPseudoProg = new Scanner(System.in);
                    String PseudoProg = scanPseudoProg.nextLine();

                    programmeur = new Programmeur(IdProg, NomProg, PrenomProg, AdresseProg, ManagerProg, HobbyProg, NaissanceProg, SalaireProg, PrimeProg, PseudoProg);
                    action.AddDev(programmeur);
                    attendreUneTouche();
                    break;

                case "5":
                    System.out.println("Entrez l'identifiant du programmeur a modifier :");
                    scanIdProg = new Scanner(System.in);
                    IdProg = scanIdProg.nextInt();
                    programmeur = action.GetDev(IdProg);
                    if(programmeur != null){
                        action.ChangeDev(programmeur);
                    }
                    else System.out.println("Le programmeur "+IdProg+" n'a pas ete trouve");
                    attendreUneTouche();
                    break;

                case "6":
                    run = false;
                    System.exit(0);
                    break;

                default:
                    System.out.println("Option non valide !");
                    attendreUneTouche();
                    break;
            }
        }
    }
}
