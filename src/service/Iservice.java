package service;

import metier.CarteEtudiant;
import metier.Club;
import metier.Formation;
import metier.Personne;

import java.util.List;

public interface Iservice {
    int addPersonne(Personne p);
    int updatePersonne(Personne p);
    int deletePersonne(Personne p);
    Personne getPersonne(int id);
    List<Personne> findAll();
    int addFormation(Formation f);
    List<Formation> findAllFormations();
    int addPersonneFormation(Personne p, Formation f);
    Formation getFormation(int id);
    int addCarteEtudiant(CarteEtudiant c);
    int linkPersonneToCarte(Personne p, CarteEtudiant c);

    CarteEtudiant getCarteEtudiant(int id);

    int addClub(Club c);
    Club getClub(int id);
    int inscription(Club c, Personne p);
    List<Club> getClubPersonne(int idPersonne);
}
