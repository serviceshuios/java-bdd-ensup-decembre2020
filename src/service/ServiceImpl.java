package service;

import dao.DaoImpl;
import dao.IDao;
import metier.CarteEtudiant;
import metier.Club;
import metier.Formation;
import metier.Personne;

import java.util.List;

public class ServiceImpl implements Iservice{

    // attribut de passage d'information à la couche Dao
    private IDao dao = new DaoImpl();
    @Override
    public int addPersonne(Personne p) {
        System.out.println("-----Appel de la méthode ajout depuis le service ------");
        return dao.addPersonne(p);
    }

    @Override
    public int updatePersonne(Personne p) {
        return dao.updatePersonne(p);
    }

    @Override
    public int deletePersonne(Personne p) {
        return dao.deletePersonne(p);
    }

    @Override
    public Personne getPersonne(int id) {
        return dao.getPersonne(id);
    }

    @Override
    public List<Personne> findAll() {
        return dao.findAll();
    }

    @Override
    public int addFormation(Formation f) {
        return dao.addFormation(f);
    }

    @Override
    public List<Formation> findAllFormations() {
        return dao.findAllFormations();
    }

    @Override
    public int addPersonneFormation(Personne p, Formation f) {
        return dao.addPersonneFormation(p,f);
    }

    @Override
    public Formation getFormation(int id) {
        return dao.getFormation(id);
    }

    @Override
    public int addCarteEtudiant(CarteEtudiant c) {
        return dao.addCarteEtudiant(c);
    }

    @Override
    public int linkPersonneToCarte(Personne p, CarteEtudiant c) {
        return dao.linkPersonneToCarte(p,c);
    }

    @Override
    public CarteEtudiant getCarteEtudiant(int id) {
        return dao.getCarte(id);
    }

    @Override
    public int addClub(Club c) {
        return dao.addClub(c);
    }

    @Override
    public Club getClub(int id) {
        return dao.getClub(id);
    }

    @Override
    public int inscription(Club c, Personne p) {
        return dao.inscription(c,p);
    }

    @Override
    public List<Club> getClubPersonne(int idPersonne) {
        return dao.getClubPersonne(idPersonne);
    }
}
