import java.time.*;

public class patient {

    String firstName;
    String lastName;
    appointment appointment_info = new appointment();

    public patient () {
        //default constructor - guest user
        this.firstName = "";
        this.lastName = "";
    }

    public patient (String firstName, String lastName) {
        //patient without appointment set
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public patient (String firstName, String lastName, String location, LocalDateTime ltd) {
        //patient with appointment set
        this.firstName = firstName;
        this.lastName = lastName;
        this.appointment_info = new appointment(location, ltd);
    }

    //getters
    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    //setters
    public void setFirstName(String newName) {
        this.firstName = newName;
        System.out.println("Your new name " + newName + " has been recognized and has now replaced your old name.");
    }

    public void setLastName(String newName) {
        this.lastName = newName;
        System.out.println("Your new last name " + newName + " has been recognized and has now replaced your old last name.");
    }

    void setAppointment (String location, LocalDate ld, LocalTime lt) {
        if (this.appointment_info.getHasAppointment() == true) {
            System.out.println("You already have an appointment set.");
        }
        else if (this.firstName == "" && this.lastName == "") {
            System.out.println("You must be a registered patient before setting an appointment.");
        }
        else {
            this.appointment_info.setLocation(location);
            this.appointment_info.setLD(ld);
            this.appointment_info.setLT(lt);
            this.appointment_info.setHasAppointment(true);

            System.out.println("You have made an appointment at " + this.appointment_info.getLocation() + " and is scheduled for " + this.appointment_info.getLD() + 
            " at " + this.appointment_info.getLT() + this.appointment_info.getTP() + ".");
        }
    }
    
    void checkAppointment () {
        if (appointment_info.getHasAppointment() == true) {
            System.out.println("You have an appointment located at " + this.appointment_info.getLocation() + " and is scheduled for " + this.appointment_info.getLD() + 
            " at " + this.appointment_info.getLT() + this.appointment_info.getTP() + ".");
        }
        else if (this.firstName == "" && this.lastName == "") {
            System.out.println("You must be a registered patient before checking for an appointment.");
        }
        else {
            System.out.println("You do not currently have an appointment.");
        }
    }

    void cancelAppointment () {
        if (this.firstName == "" && this.lastName == "") {
            System.out.println("You must be a registered patient to have any appointment scheduled beforehand.");
        }
        else {
            System.out.println("The appointment located at " + this.appointment_info.getLocation() + " that was scheduled for " 
            + this.appointment_info.getLD() + " at " + this.appointment_info.getLT() + this.appointment_info.getTP() + " has been cancelled.");
            this.appointment_info.setLocation("No location");

            LocalDate emptyLD = LocalDate.of(0, 1, 1);
            LocalTime emptyLT = LocalTime.of(0, 0);

            this.appointment_info.setLD(emptyLD);
            this.appointment_info.setLT(emptyLT); //this also sets the TP
            this.appointment_info.setHasAppointment(false);
        }
    }
}
