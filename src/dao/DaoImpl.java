package dao;

import metier.CarteEtudiant;
import metier.Club;
import metier.Formation;
import metier.Personne;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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

    @Override
    public int addFormation(Formation f) {
        try {
            //1- créer la connexion
            cn = DriverManager.getConnection(url,username,mdp);
            //2- créer la requête
            String sql = "INSERT INTO formation(intitule, nbheures) VALUES(?,?)";
            st = cn.prepareStatement(sql);
            st.setString(1,f.getIntitule());
            st.setInt(2, f.getNbHeures());
            //3- exécuter la requête
            res=st.executeUpdate();
            //4- récupérer le résultat

            //5- fermer la connexion
            cn.close();
            System.out.println("la formation "+f +" a bien été ajoutée en BDD");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return res;
        }
    }

    @Override
    public List<Formation> findAllFormations() {
        List<Formation> formations = new ArrayList<Formation>();
        try {
            //1- créer la connexion
            cn = DriverManager.getConnection(url,username,mdp);
            //2- créer la requête
            String sql = "SELECT * FROM formation";
            st = cn.prepareStatement(sql);
            //3- exécuter la requête
            rs = st.executeQuery();
            //4- récupérer le résultat
            while(rs.next()) {
                //1- créer un objet de type formation
                Formation f = new Formation();
                f.setIdFormation(rs.getInt("idFormation"));
                f.setIntitule(rs.getString("intitule"));
                f.setNbHeures(rs.getInt("nbheures"));

                //2- ajouter l'objet personne à la liste créée
                formations.add(f);
            }
            //5- fermer la connexion
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return formations;
    }

    @Override
    public int addPersonneFormation(Personne p, Formation f) {


        try {
            //1- créer la connexion
            cn = DriverManager.getConnection(url,username,mdp);
            //2- créer la requête
            String sql = "UPDATE personne SET idFormation=? WHERE id=?";
            st = cn.prepareStatement(sql);
            st.setInt(1,f.getIdFormation());
            st.setInt(2,p.getId());
            //3- exécuter la requête
            res = st.executeUpdate();
            //4- récupérer le résultat

            //5- fermer la connexion
            cn.close();
            System.out.println("la personne " +p+" a bien été ajoutée à la formation "+f);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public Formation getFormation(int id) {
        Formation f = new Formation();

        try {
            //1- créer la connexion
            cn = DriverManager.getConnection(url,username,mdp);
            //2- créer la requête
            String sql = "SELECT * FROM formation where idFormation=?";
            st=cn.prepareStatement(sql);
            st.setInt(1,id);
            //3- exécuter la requête
            rs = st.executeQuery();
            //4- récupérer le résultat
            rs.next();
            f.setIdFormation(rs.getInt("idFormation"));
            f.setIntitule(rs.getString("intitule"));
            f.setNbHeures(rs.getInt("nbheures"));
            //5- fermer la connexion
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return f;
    }

    @Override
    public int addCarteEtudiant(CarteEtudiant c) {
        try {
            //1- créer la connexion
            cn = DriverManager.getConnection(url,username,mdp);
            //2- créer la requête
            String sql = "INSERT INTO carteEtudiant(numeroCarte,dateExpiration) VALUES(?,?)";
            st = cn.prepareStatement(sql);
            st.setInt(1,c.getNumeroCarte());
            st.setDate(2, new Date(c.getDateExpiration().getTime()));
            //3- exécuter la requête
            res=st.executeUpdate();
            //4- récupérer le résultat

            //5- fermer la connexion
            cn.close();
            System.out.println("la carte "+c +" a bien été ajoutée en BDD");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return res;
        }
    }

    @Override
    public int linkPersonneToCarte(Personne p, CarteEtudiant c) {


        try {
            //1- créer la connexion
            cn = DriverManager.getConnection(url,username,mdp);
            //2- créer la requête
            String sql = "UPDATE personne SET idCarte=? WHERE id=?";

            String sql2 = "SELECT * FROM personne where idCarte = ?";

            st = cn.prepareStatement(sql2);
            st.setInt(1,c.getIdCarte());
            rs = st.executeQuery();
            if(rs.next()){
                System.out.println("La carte est déja attribuée");
            }
            else {
                st = cn.prepareStatement(sql);
                st.setInt(1, c.getIdCarte());
                st.setInt(2, p.getId());
                //3- exécuter la requête
                res = st.executeUpdate();
                //4- récupérer le résultat
                System.out.println("la carte " +c+" a bien été attribuée à la personne "+p);
            }
            //5- fermer la connexion
            cn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public CarteEtudiant getCarte(int id) {
        CarteEtudiant c = new CarteEtudiant();

        try {
            //1- créer la connexion
            cn = DriverManager.getConnection(url,username,mdp);
            //2- créer la requête
            String sql = "SELECT * FROM carteEtudiant where idCarte=?";
            st=cn.prepareStatement(sql);
            st.setInt(1,id);
            //3- exécuter la requête
            rs = st.executeQuery();
            //4- récupérer le résultat
            rs.next();
            c.setIdCarte(rs.getInt("idCarte"));
            c.setNumeroCarte(rs.getInt("numeroCarte"));
            c.setDateExpiration(rs.getDate("dateExpiration"));
            //5- fermer la connexion
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return c;
    }

    @Override
    public int addClub(Club c) {
        try {
            //1- créer la connexion
            cn = DriverManager.getConnection(url,username,mdp);
            //2- créer la requête
            String sql = "INSERT INTO club(nom) VALUES(?)";
            st = cn.prepareStatement(sql);
            st.setString(1,c.getNom());
            //3- exécuter la requête
            res=st.executeUpdate();
            //4- récupérer le résultat

            //5- fermer la connexion
            cn.close();
            System.out.println("le club "+c +" a bien été ajoutée en BDD");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return res;
        }
    }

    @Override
    public Club getClub(int id) {
        Club c = new Club();

        try {
            //1- créer la connexion
            cn = DriverManager.getConnection(url,username,mdp);
            //2- créer la requête
            String sql = "SELECT * FROM club where idClub=?";
            st=cn.prepareStatement(sql);
            st.setInt(1,id);
            //3- exécuter la requête
            rs = st.executeQuery();
            //4- récupérer le résultat
            rs.next();
            c.setIdClub(rs.getInt("idClub"));
            c.setNom(rs.getString("nom"));
            //5- fermer la connexion
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return c;
    }

    @Override
    public int inscription(Club c, Personne p) {
        try {
            //1- créer la connexion
            cn = DriverManager.getConnection(url,username,mdp);
            //2- créer la requête
            String sql = "INSERT INTO inscription" +
                    "(idPersonne, idClub, dateInscription) VALUES(?,?,?)";
            st = cn.prepareStatement(sql);
            st.setInt(1,p.getId());
            st.setInt(2,c.getIdClub());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            st.setDate(3, Date.valueOf(LocalDate.now().toString()));
            //3- exécuter la requête
            res=st.executeUpdate();
            //4- récupérer le résultat

            //5- fermer la connexion
            cn.close();
            System.out.println(p+ " a bien été ajouté au club "+c );
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return res;
        }
    }

    @Override
    public List<Club> getClubPersonne(int idPersonne) {
        List<Club> clubs = new ArrayList<Club>();
        try {
            //1- créer la connexion
            cn = DriverManager.getConnection(url,username,mdp);
            //2- créer la requête
            String sql = "SELECT * FROM club, inscription, personne" +
                    " where inscription.idPersonne=personne.id" +
                    " and inscription.idClub = club.idClub" +
                    " and inscription.idPersonne=?";
            st = cn.prepareStatement(sql);
            st.setInt(1,idPersonne);
            //3- exécuter la requête
            rs = st.executeQuery();
            //4- récupérer le résultat
            while(rs.next()) {
                //1- créer un objet de type formation
                Club c = new Club();
                c.setIdClub(rs.getInt("idClub"));
                c.setNom(rs.getString("nom"));

                //2- ajouter l'objet personne à la liste créée
                clubs.add(c);
            }
            //5- fermer la connexion
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clubs;
    }
}
