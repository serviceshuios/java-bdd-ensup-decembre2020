package metier;

import java.util.ArrayList;
import java.util.List;

public class Club {
    private int idClub;
    private String nom;

    private List<Personne> personnes = new ArrayList<Personne>();

    public Club() {
    }

    public Club(String nom) {
        this.nom = nom;
    }

    public int getIdClub() {
        return idClub;
    }

    public void setIdClub(int idClub) {
        this.idClub = idClub;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Personne> getPersonnes() {
        return personnes;
    }

    public void setPersonnes(List<Personne> personnes) {
        this.personnes = personnes;
    }

    @Override
    public String toString() {
        return "Club{" +
                "idClub=" + idClub +
                ", nom='" + nom + '\'' +
                '}';
    }
}
