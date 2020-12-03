package service;

import dao.DaoImpl;
import dao.IDao;
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
}
