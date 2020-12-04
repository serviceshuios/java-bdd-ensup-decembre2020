package metier;

import java.util.Date;

public class CarteEtudiant {
    private int idCarte;
    private int numeroCarte;
    private Date dateExpiration;

    private Personne personne;

    public int getIdCarte() {
        return idCarte;
    }

    public void setIdCarte(int idCarte) {
        this.idCarte = idCarte;
    }

    public int getNumeroCarte() {
        return numeroCarte;
    }

    public void setNumeroCarte(int numeroCarte) {
        this.numeroCarte = numeroCarte;
    }

    public Date getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public CarteEtudiant() {

    }

    public CarteEtudiant(int numeroCarte, Date dateExpiration) {
        this.numeroCarte = numeroCarte;
        this.dateExpiration = dateExpiration;
    }

    @Override
    public String toString() {
        return "CarteEtudiant{" +
                "idCarte=" + idCarte +
                ", numeroCarte=" + numeroCarte +
                ", dateExpiration=" + dateExpiration +
                '}';
    }
}
