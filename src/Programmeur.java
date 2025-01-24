/**
 * La class Programmeur.
 */
public class Programmeur {
    private int id;
    private String nom;
    private String prenom;
    private String adresse;
    private String manager;
    private String hobby;
    private int anNaissance;
    private double salaire;
    private double prime;
    private String pseudo;

    /**
     * Instantie un nouveau Programmeur.
     *
     * @param id          l'identifiant
     * @param nom         le nom
     * @param prenom      le prenom
     * @param adresse     l'adresse
     * @param manager     le manager
     * @param hobby       le hobby
     * @param anNaissance l'annee de naissance
     * @param salaire     le salaire
     * @param prime       la prime
     * @param pseudo      le pseudo
     */
    public Programmeur(int id, String nom, String prenom, String adresse,
                       String manager, String hobby, int anNaissance,
                       double salaire, double prime, String pseudo){
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.manager = manager;
        this.hobby = hobby;
        this.anNaissance = anNaissance;
        this.salaire = salaire;
        this.prime = prime;
        this.pseudo = pseudo;
    }

    /**
     * Gets id.
     *
     * @return l'identifiant du programmeur
     */
    public int getId() { return id; }

    /**
     * Sets id.
     *
     * @param id l'identifiant du programmeur
     */
    public void setId(int id) { this.id = id; }

    /**
     * Gets nom.
     *
     * @return le nom du programmeur
     */
    public String getNom() {
        return nom;
    }

    /**
     * Sets nom.
     *
     * @param nom le nom du programmeur
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Gets prenom.
     *
     * @return le prenom du programmeur
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Sets prenom.
     *
     * @param prenom le prenom du programmeur
     */
    public void setPrenom(String prenom) { this.prenom = prenom; }

    /**
     * Gets adresse.
     *
     * @return l'adresse du programmeur
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Sets adresse.
     *
     * @param adresse l'adresse du programmeur
     */
    public void setAdresse(String adresse) { this.adresse = adresse; }

    /**
     * Gets manager.
     *
     * @return le manager du programmeur
     */
    public String getManager() {
        return manager;
    }

    /**
     * Sets manager.
     *
     * @param manager le manager du programmeur
     */
    public void setManager(String manager) { this.manager = manager; }

    /**
     * Gets hobby.
     *
     * @return le hobby du programmeur
     */
    public String getHobby() {
        return hobby;
    }

    /**
     * Sets hobby.
     *
     * @param hobby le hobby du programmeur
     */
    public void setHobby(String hobby) { this.hobby = hobby; }

    /**
     * Gets an naissance.
     *
     * @return l'annee de naissance du programmeur
     */
    public int getAnNaissance() {
        return anNaissance;
    }

    /**
     * Sets an naissance.
     *
     * @param anNaissance l'annee de naissance du programmeur
     */
    public void setAnNaissance(int anNaissance) {
        this.anNaissance = anNaissance;
    }

    /**
     * Gets salaire.
     *
     * @return le salaire du programmeur
     */
    public double getSalaire() {
        return salaire;
    }

    /**
     * Sets salaire.
     *
     * @param salaire le salaire du programmeur
     */
    public void setSalaire(float salaire) {
        this.salaire = salaire;
    }

    /**
     * Gets prime.
     *
     * @return la prime du programmeur
     */
    public double getPrime() {
        return prime;
    }

    /**
     * Sets prime.
     *
     * @param prime la prime du programmeur
     */
    public void setPrime(float prime) {
        this.prime = prime;
    }

    /**
     * Gets pseudo.
     *
     * @return le pseudo du programmeur
     */
    public String getPseudo() {
        return pseudo;
    }

    /**
     * Sets pseudo.
     *
     * @param pseudo le pseudo du programmeur
     */
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    /**
     * To string.
     *
     * permet d'afficher le programmeur sous le format spécifié
     */
    @Override
    public String toString(){
        return  String.format("%-15s: %d%n","Id",this.id)+
                String.format("%-15s: %s%n","Nom",this.nom)+
                String.format("%-15s: %s%n","Prenom",this.prenom)+
                String.format("%-15s: %s%n","Adresse",this.adresse)+
                String.format("%-15s: %s%n","Responsable",this.manager)+
                String.format("%-15s: %s%n","Hobby",this.hobby)+
                String.format("%-15s: %d%n","Naissance",this.anNaissance)+
                String.format("%-15s: %.2f€%n","Salaire",this.salaire)+
                String.format("%-15s: %.2f€%n","Prime",this.prime)+
                String.format("%-15s: %s%n","Pseudo",this.pseudo);
    }
}
