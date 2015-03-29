package prototype.hibernate.sessionfactory;

/**
 * Created by Norskan on 29.03.2015.
 */
public abstract class AbstractSession {
    public abstract void beginTransaction();

    public abstract void stopTransaction();

    public abstract Object get(Class klass, int id);

    public abstract void insert(Object entity);

    public abstract void delete(Object entity);

    public abstract void commit();

    protected abstract void close();
}
