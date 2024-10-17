package hib;

import hib.model.Game;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main4 {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure()
                .setProperty("hibernate.connection.password", System.getenv("MYSQL_ROOT_PASSWORD"))
                .buildSessionFactory();

        sessionFactory.inSession((session -> {
            System.out.println(session.get(Game.class, 1));
        }));

        //consulta en una transacción (no necesario el commit)->inTransaction
        sessionFactory.inTransaction((session -> {
            Game g4 = session.get(Game.class, 4);
            g4.setYear(444);
        }));
    }
}
