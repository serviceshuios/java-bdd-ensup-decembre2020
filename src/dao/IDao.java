package dao;

import metier.CarteEtudiant;
import metier.Formation;
import metier.Personne;

import java.util.List;

public interface IDao {
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

    CarteEtudiant getCarte(int id);
}
