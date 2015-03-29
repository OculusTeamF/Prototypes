package prototype.persisten.broker;

import prototype.hibernate.sessionfactory.HibernateSessionBroker;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Norskan on 29.03.2015.
 */
public class BrokerFacade {

    private HashMap<Class, AbstractBroker> _brokerMapping;
    private HibernateSessionBroker _hibernateSessionBroker;

    private BrokerFacade() {
        _brokerMapping = new HashMap<Class, AbstractBroker>();
        addBroker(new PatientBroker(this));

        //get all pojoClasse from each broker
        Collection<Class> classes = new LinkedList();
        for(AbstractBroker broker : _brokerMapping.values()) {
            classes.add(broker._pojoClass);
        }

        _hibernateSessionBroker = new HibernateSessionBroker(classes);
    }

    public HibernateSessionBroker getHibernateSessionBroker() {
        return _hibernateSessionBroker;
    }

    private static BrokerFacade _selfe;
    public static BrokerFacade getInstanze() {
        if(_selfe == null) {
            _selfe = new BrokerFacade();
        }

        return _selfe;
    }

    private void addBroker(AbstractBroker broker) {
        _brokerMapping.put(broker._entityClass, broker);
    }

    public Object getByID(Class klass, int id) {
        return _brokerMapping.get(klass).getByID(id);
    }

}
