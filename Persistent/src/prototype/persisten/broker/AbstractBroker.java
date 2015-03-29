package prototype.persisten.broker;

/**
 * Created by Norskan on 29.03.2015.
 */
abstract class AbstractBroker {

    protected Class _pojoClass;
    protected Class _entityClass;
    protected BrokerFacade _facade;

    public AbstractBroker(BrokerFacade facade, Class pojoClass, Class entityClass) {
        _facade = facade;
        _pojoClass = pojoClass;
        _entityClass = entityClass;
    }

    public abstract Object getByID(int i);
}
