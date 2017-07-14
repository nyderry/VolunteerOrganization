/**
 * Created by Ny Derry on 7/12/2017.
 */
public class Volunteer {

    Boolean isAssigned = false;
    String volunteerName;

    public Volunteer(String personsName) {
        volunteerName = personsName;
    }

    public void Assign() {
        isAssigned = true;
    }

    public void Reject() {
        isAssigned = false;
    }

    public boolean isAssigned() {
        if (isAssigned == true) {
            return true;
        } else {
            return false;
        }
    }

    public String getVolunteerName() {
        return volunteerName;
    }


}
