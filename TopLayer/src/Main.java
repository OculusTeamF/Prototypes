import prototype.domain.entities.PatientEntity;
import prototype.persisten.broker.BrokerFacade;

/**
 * Created by Norskan on 29.03.2015.
 */
public class Main {
    public static void main(String[] args) {
        BrokerFacade brokerFacade = BrokerFacade.getInstanze();

        PatientEntity patientEntity = (PatientEntity)brokerFacade.getByID(PatientEntity.class,1);

        System.out.println(patientEntity.getFirstName());
        System.out.println(patientEntity.getLastName());
    }
}
