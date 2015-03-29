package prototype.persisten.broker;

import prototype.domain.entities.PatientEntity;
import prototype.hibernate.pojo.PatientPojo;
import prototype.hibernate.sessionfactory.AbstractSession;

/**
 * Created by Norskan on 29.03.2015.
 */

class PatientBroker extends AbstractBroker{

    public PatientBroker(BrokerFacade facade) {
        super(facade, PatientPojo.class, PatientEntity.class);
    }

    public Object getByID(int id) {
        AbstractSession session = _facade.getHibernateSessionBroker().getSession();

        PatientPojo patientPojo = null;

        patientPojo = (PatientPojo)session.get(_pojoClass, 1);

        _facade.getHibernateSessionBroker().releaseSession(session);
        return (Object) new PatientEntity(patientPojo.getFirstName(),patientPojo.getLastName());
    }

    public Class getEntityClass() {
        return _entityClass;
    }
}
