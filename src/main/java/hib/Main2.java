package hib;

import hib.model.Game;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main2 {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();


        try(Session session = sessionFactory.openSession()){

            //seleccionar juego
            Game g45 = session.get(Game.class, 45);
            System.out.println(g45);

            //update
            /*
            session.beginTransaction();
            g45.setYear(2222);
            session.getTransaction().commit();
             */

            //delete
            session.beginTransaction();
            session.remove(g45);
            session.getTransaction().commit();



        }


    }
}
