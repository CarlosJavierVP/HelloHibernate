package hib;

import hib.model.Game;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Main {
    public static void main(String[] args) {
        //hibernate -> ORM gestor objeto relacional

        //Conexión a través de hibernate
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();


        try(Session session = sessionFactory.openSession()){
            Query<Game> query = session.createQuery("select g from Game g", Game.class);

            Query<String> query2 = session.createQuery("select g.title from Game g", String.class);

            Query<String> query3 = session.createQuery("select distinct g.platform from Game g", String.class);

            var resultado = query.list();
            //query.getResultList();

            resultado.forEach(System.out::println);


            //las operaciones de escritura se hacen en el marco de una transacción
            session.beginTransaction(); //comeinzo del marco de transacción
            Game g = new Game();
            g.setTitle("BG3");
            g.setDescription("descripción");
            g.setYear(2023);
            g.setPlatform("PC");
            //g.setUserId(1);

            session.persist(g);
            session.getTransaction().commit();
        }

    }
}
