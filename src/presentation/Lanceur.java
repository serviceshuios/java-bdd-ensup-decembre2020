package presentation;

import metier.Personne;
import service.Iservice;
import service.ServiceImpl;

import java.util.List;

public class Lanceur {

    public static void main(String[] args) {
        // déclaration de la couche service
        Iservice service = new ServiceImpl();

        // ajout d'une personne
        /*Personne p1 = new Personne("Benin","Antoine",42);
        System.out.println("-----Appel de la méthode ajout depuis le lanceur ------");
        service.addPersonne(p1);*/

        // Lister les personnes de la BDD
        //List<Personne> personnes = service.findAll();
        System.out.println("---LISTE DES PERSONNES");
        for(Personne p : service.findAll()){
            System.out.println(p);
        }
        System.out.println("---AFFICHAGE PERSONNE AYANT POUR ID 1");
        System.out.println(service.getPersonne(1));
        /*System.out.println("---SUPPRESSION PERSONNE AYANT POUR ID 2");
        service.deletePersonne(service.getPersonne(2));
        System.out.println("---LISTE DES PERSONNES");
        for(Personne p : service.findAll()){
            System.out.println(p);
        }*/
        System.out.println("---MODIFICATION PERSONNE AYANT POUR ID 3");
        Personne p2 = service.getPersonne(3);
        p2.setNom("Boulanger");
        p2.setPrenom("Patrick");
        p2.setAge(55);
        service.updatePersonne(p2);
        System.out.println("---LISTE DES PERSONNES");
        for(Personne p : service.findAll()){
            System.out.println(p);
        }
    }
}
