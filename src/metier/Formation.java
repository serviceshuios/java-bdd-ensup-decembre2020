package metier;

import java.util.ArrayList;
import java.util.List;

public class Formation {
    private int idFormation;
    private String intitule;
    private int nbHeures;

    private List<Personne> personnes = new ArrayList<Personne>();
    public Formation() {
    }

    public Formation(String intitule, int nbHeures) {
        this.intitule = intitule;
        this.nbHeures = nbHeures;
    }

    public List<Personne> getPersonnes() {
        return personnes;
    }

    public void setPersonnes(List<Personne> personnes) {
        this.personnes = personnes;
    }

    public int getIdFormation() {
        return idFormation;
    }

    public void setIdFormation(int idFormation) {
        this.idFormation = idFormation;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public int getNbHeures() {
        return nbHeures;
    }

    public void setNbHeures(int nbHeures) {
        this.nbHeures = nbHeures;
    }
}
