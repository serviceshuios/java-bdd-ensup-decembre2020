package metier;

import java.util.ArrayList;
import java.util.List;

public class Personne {

    private int id;
    private String nom;
    private String prenom;
    private int age;
    private Formation formation;
    private CarteEtudiant carteEtudiant;
    private List<Club> clubs = new ArrayList<Club>();

    public CarteEtudiant getCarteEtudiant() {
        return carteEtudiant;
    }

    public void setCarteEtudiant(CarteEtudiant carteEtudiant) {
        this.carteEtudiant = carteEtudiant;
    }

    public Personne() {
    }

    public Personne(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Club> getClubs() {
        return clubs;
    }

    public void setClubs(List<Club> clubs) {
        this.clubs = clubs;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", age=" + age +
                '}';
    }
}
