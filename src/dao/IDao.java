package dao;

import metier.Personne;

import java.util.List;

public interface IDao {
    int addPersonne(Personne p);
    int updatePersonne(Personne p);
    int deletePersonne(Personne p);
    Personne getPersonne(int id);
    List<Personne> findAll();
}
