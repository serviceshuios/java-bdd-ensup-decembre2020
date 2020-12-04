package presentation;

import metier.CarteEtudiant;
import metier.Formation;
import metier.Personne;
import service.Iservice;
import service.ServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Lanceur {

    public static void main(String[] args) throws ParseException {
        // déclaration de la couche service
        Iservice service = new ServiceImpl();

        // ajout d'une carte
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        CarteEtudiant c = new CarteEtudiant(12347,sdf.parse("2023-10-12"));
        service.addCarteEtudiant(c);

        // Lister les personnes de la BDD
        //List<Personne> personnes = service.findAll();
        System.out.println("---LISTE DES PERSONNES");
        for(Personne p : service.findAll()){
            System.out.println(p);
        }

        System.out.println("---LISTE DES FORMATIONS");
        for(Formation fo : service.findAllFormations()){
            System.out.println(fo);
        }
        System.out.println("---AFFICHAGE PERSONNE AYANT POUR ID 1");
        //
        // System.out.println(service.getPersonne(4));
        /*System.out.println("---SUPPRESSION PERSONNE AYANT POUR ID 2");
        service.deletePersonne(service.getPersonne(2));
        System.out.println("---LISTE DES PERSONNES");
        for(Personne p : service.findAll()){
            System.out.println(p);
        }*/
       /* System.out.println("---AJOUT D'UNE PERSONNE A UNE FORMATION");
        Formation f1 = service.getFormation(1);
        Personne p4 = service.getPersonne(4);

        service.addPersonneFormation(p4,f1);*/
        // ajouter personne carte
        service.linkPersonneToCarte(service.getPersonne(5),service.getCarteEtudiant(2));
    }
}
