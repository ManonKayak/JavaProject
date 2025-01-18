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

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) { this.adresse = adresse; }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) { this.manager = manager; }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) { this.hobby = hobby; }

    public int getAnNaissance() {
        return anNaissance;
    }

    public void setAnNaissance(int anNaissance) {
        this.anNaissance = anNaissance;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(float salaire) {
        this.salaire = salaire;
    }

    public double getPrime() {
        return prime;
    }

    public void setPrime(float prime) {
        this.prime = prime;
    }

    public String getPseudo() {
        return pseudo;
    }

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
