package prototype.hibernate.sessionfactory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.Collection;

/**
 * Created by Norskan on 29.03.2015.
 */
public final class HibernateSessionBroker {

    private final ServiceRegistry _serviceRegistry;
    private final SessionFactory _sessionFactory;

    public HibernateSessionBroker(Collection<Class> classes) {

        //hibernate configuration
        Configuration configuration = new Configuration();
        configuration.configure();

        for(Class c : classes) {
            configuration.addAnnotatedClass(c);
        }


        _serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        _sessionFactory = configuration.buildSessionFactory(_serviceRegistry);
    }

    public AbstractSession getSession() {
        return new HibernateSession(_sessionFactory.openSession());
    }

    public void releaseSession(AbstractSession session) {
        session.close();
    }
}
