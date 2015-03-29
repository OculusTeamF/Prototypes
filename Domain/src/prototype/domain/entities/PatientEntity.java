package prototype.domain.entities;

/**
 * Created by Norskan on 29.03.2015.
 */
public class PatientEntity implements DomainEntity{
    private String _firstName;
    private String _lastName;

    public PatientEntity(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    public String getFirstName() {
        return _firstName;
    }

    public void setFirstName(String _firstName) {
        this._firstName = _firstName;
    }

    public String getLastName() {
        return _lastName;
    }

    public void setLastName(String _lastName) {
        this._lastName = _lastName;
    }
}
