package dao;

import metier.Personne;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoImpl implements IDao{
    // les informations d'accès à la base de données
    final String url = "jdbc:mysql://localhost:3306/personnes_ensup"+
            "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
    final String username="root";
    final String mdp="";

    // initialisation des variables java permettant de dialoguer avec la base de données
    // connecter à la base de données
    Connection cn = null;
    // executer la requête
    PreparedStatement st = null;
    // récupérer le résultat
    ResultSet rs = null;
    // nombre de mises à jour
    int res=0;

    @Override
    public int addPersonne(Personne p) {


        try {
            //1- créer la connexion
            cn = DriverManager.getConnection(url,username,mdp);
            //2- créer la requête
            String sql = "INSERT INTO personne(nom, prenom, age) VALUES(?,?,?)";
            st = cn.prepareStatement(sql);
            st.setString(1,p.getNom());
            st.setString(2, p.getPrenom());
            st.setInt(3,p.getAge());
            //3- exécuter la requête
            res=st.executeUpdate();
            //4- récupérer le résultat

            //5- fermer la connexion
            cn.close();
            System.out.println("la personne "+p +" a bien été ajoutée en BDD");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return res;
        }
    }

    @Override
    public int updatePersonne(Personne p) {
        try {
            //1- créer la connexion
            cn = DriverManager.getConnection(url,username,mdp);
            //2- créer la requête
            String sql="UPDATE personne SET nom=?, prenom=?, age=? where id=?";
            st=cn.prepareStatement(sql);
            st.setString(1,p.getNom());
            st.setString(2,p.getPrenom());
            st.setInt(3,p.getAge());
            st.setInt(4,p.getId());
            //3- exécuter la requête
            res = st.executeUpdate();
            //4- récupérer. le résultat

            //5- fermer la connexion
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }

    @Override
    public int deletePersonne(Personne p) {
        try {
            //1- créer la connexion
            cn = DriverManager.getConnection(url,username,mdp);
            //2- créer la requête
            String  sql ="DELETE FROM personne where id=?";
            st=cn.prepareStatement(sql);
            st.setInt(1,p.getId());
            //3- exécuter la requête
            res = st.executeUpdate();
            //4- récupérer. le résultat

            //5- fermer la connexion
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }

    @Override
    public Personne getPersonne(int id) {
        Personne p = new Personne();

        try {
            //1- créer la connexion
            cn = DriverManager.getConnection(url,username,mdp);
            //2- créer la requête
            String sql = "SELECT * FROM personne where id=?";
            st=cn.prepareStatement(sql);
            st.setInt(1,id);
            //3- exécuter la requête
            rs = st.executeQuery();
            //4- récupérer le résultat
                rs.next();
                p.setId(rs.getInt("id"));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                p.setAge(rs.getInt("age"));
            //5- fermer la connexion
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return p;
    }

    @Override
    public List<Personne> findAll() {
        List<Personne> personnes = new ArrayList<Personne>();
        try {
            //1- créer la connexion
            cn = DriverManager.getConnection(url,username,mdp);
            //2- créer la requête
            String sql = "SELECT * FROM personne";
            st = cn.prepareStatement(sql);
            //3- exécuter la requête
            rs = st.executeQuery();
            //4- récupérer le résultat
            while(rs.next()) {
                //1- créer un objet de type personne
                    Personne p = new Personne();
                    p.setId(rs.getInt("id"));
                    p.setNom(rs.getString("nom"));
                    p.setPrenom(rs.getString("prenom"));
                    p.setAge(rs.getInt("age"));
                //2- ajouter l'objet personne à la liste créée
                 personnes.add(p);
            }
            //5- fermer la connexion
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personnes;
    }
}
