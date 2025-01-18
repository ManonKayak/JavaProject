/**
 * The type Programmeur.
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
     * Instantiates a new Programmeur.
     *
     * @param id          the id
     * @param nom         the nom
     * @param prenom      the prenom
     * @param adresse     the adresse
     * @param manager     the manager
     * @param hobby       the hobby
     * @param anNaissance the an naissance
     * @param salaire     the salaire
     * @param prime       the prime
     * @param pseudo      the pseudo
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
     * @return the id
     */
    public int getId() { return id; }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) { this.id = id; }

    /**
     * Gets nom.
     *
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Sets nom.
     *
     * @param nom the nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Gets prenom.
     *
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Sets prenom.
     *
     * @param prenom the prenom
     */
    public void setPrenom(String prenom) { this.prenom = prenom; }

    /**
     * Gets adresse.
     *
     * @return the adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Sets adresse.
     *
     * @param adresse the adresse
     */
    public void setAdresse(String adresse) { this.adresse = adresse; }

    /**
     * Gets manager.
     *
     * @return the manager
     */
    public String getManager() {
        return manager;
    }

    /**
     * Sets manager.
     *
     * @param manager the manager
     */
    public void setManager(String manager) { this.manager = manager; }

    /**
     * Gets hobby.
     *
     * @return the hobby
     */
    public String getHobby() {
        return hobby;
    }

    /**
     * Sets hobby.
     *
     * @param hobby the hobby
     */
    public void setHobby(String hobby) { this.hobby = hobby; }

    /**
     * Gets an naissance.
     *
     * @return the an naissance
     */
    public int getAnNaissance() {
        return anNaissance;
    }

    /**
     * Sets an naissance.
     *
     * @param anNaissance the an naissance
     */
    public void setAnNaissance(int anNaissance) {
        this.anNaissance = anNaissance;
    }

    /**
     * Gets salaire.
     *
     * @return the salaire
     */
    public double getSalaire() {
        return salaire;
    }

    /**
     * Sets salaire.
     *
     * @param salaire the salaire
     */
    public void setSalaire(float salaire) {
        this.salaire = salaire;
    }

    /**
     * Gets prime.
     *
     * @return the prime
     */
    public double getPrime() {
        return prime;
    }

    /**
     * Sets prime.
     *
     * @param prime the prime
     */
    public void setPrime(float prime) {
        this.prime = prime;
    }

    /**
     * Gets pseudo.
     *
     * @return the pseudo
     */
    public String getPseudo() {
        return pseudo;
    }

    /**
     * Sets pseudo.
     *
     * @param pseudo the pseudo
     */
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

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
