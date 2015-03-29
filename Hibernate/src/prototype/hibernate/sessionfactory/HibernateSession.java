package prototype.hibernate.sessionfactory;

import org.hibernate.Session;

/**
 * Created by Norskan on 29.03.2015.
 */
final class HibernateSession extends AbstractSession {

    private final Session _session;

    protected HibernateSession(Session session) {
        _session = session;
    }

    public void beginTransaction() {
        if(!_session.isConnected()) {
            _session.beginTransaction();
        }
    }

    public void stopTransaction() {
        if(_session.isConnected()) {
            _session.close();
        }
    }

    public Object get(Class klass, int id) {
        return _session.get(klass, id);
    }

    public void insert(Object entity) {
        _session.save(entity);
    }

    public void delete(Object entity) {
        _session.delete(entity);
    }

    public void commit() {
        _session.getTransaction().commit();
    }

    protected void close() {
        _session.close();
    }
}
