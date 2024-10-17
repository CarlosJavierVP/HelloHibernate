package hib;

import hib.model.Game;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Main3 {
    public static void main(String[] args) {


        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();


        try(Session session = sessionFactory.openSession()){

            //filtrar juego
            Query<Game> query = session.createQuery("select g from Game g where g.platform=:platform", Game.class);
            //pasar parámetros en la consulta
            query.setParameter("platform", "PC");
            List<Game> games = query.getResultList();
            games.forEach(System.out::println);

        }

    }
}
