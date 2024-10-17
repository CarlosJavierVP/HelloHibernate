package hib;

import hib.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main5 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .setProperty("hibernate.connection.password", System.getenv("MYSQL_ROOT_PASSWORD"))
                .buildSessionFactory();

        sessionFactory.inSession((s)->{
            System.out.println(s.get(User.class, 1));
        });


    }
}
