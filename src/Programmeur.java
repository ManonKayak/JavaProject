public class Programmeur {
    private String nom;
    private String prenom;
    private String anNaissance;
    private String salaire;
    private String prime;
    private String pseudo;

    public Programmeur(String nom, String prenom, String anNaissance, String salaire, String prime, String pseudo){
        this.nom = nom;
        this.prenom = prenom;
        this.anNaissance = anNaissance;
        this.salaire = salaire;
        this.prime = prime;
        this.pseudo = pseudo;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAnNaissance() {
        return anNaissance;
    }

    public void setAnNaissance(String anNaissance) {
        this.anNaissance = anNaissance;
    }

    public String getSalaire() {
        return salaire;
    }

    public void setSalaire(String salaire) {
        this.salaire = salaire;
    }

    public String getPrime() {
        return prime;
    }

    public void setPrime(String prime) {
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
        return "Nom : "+this.nom+"  Prenom : "+this.prenom+"    Année de naissance : "+this.anNaissance+"   Salaire : "+this.salaire+"  Prime : "+this.prime+"  Pseudo : "+this.pseudo;
    }
}
