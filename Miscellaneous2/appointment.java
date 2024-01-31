import java.time.*;

public class appointment {

    String location;
    LocalDate ld;
    LocalTime lt;
    String time_period; 
    boolean has_appointment;

    public appointment () { 
        //default constructor
        LocalDate emptyLD = LocalDate.of(0, 1, 1);
        LocalTime emptyLT = LocalTime.of(0, 0);

        this.location = "No location";
        this.ld = emptyLD;
        this.lt = emptyLT;
        this.time_period = "None";
        this.has_appointment = false;
    }

    public appointment (String location, LocalDateTime ldt) { 
        this.location = location;
        this.ld = LocalDate.of(ldt.getYear(), ldt.getMonth(), ldt.getDayOfMonth());

        //0-11 hour represents 12AM to 11AM, 12-23 hour represents 12PM to 11PM
        if(ldt.getHour() >= 13) {
            this.lt = LocalTime.of(ldt.getHour() - 12, ldt.getMinute());
        }
        else if (ldt.getHour() == 0) {
            this.lt = LocalTime.of(ldt.getHour() + 12, ldt.getMinute());
        }
        else {
            this.lt = LocalTime.of(ldt.getHour(), ldt.getMinute());
        }
        
        //0-11 hour represents AM, 12-23 hour represents PM
        if (ldt.getHour() >= 12) {
            this.time_period = "PM";
        }
        else {
            this.time_period = "AM";
        }

        this.has_appointment = true;
    }

    //getters
    public String getLocation() {
        return this.location;
    }

    public LocalDate getLD() {
        return this.ld;
    }

    public LocalTime getLT() {
        return this.lt;
    }

    public String getTP() {
        return this.time_period;
    }

    public boolean getHasAppointment() {
        return this.has_appointment;
    }

    //setters
    public void setLocation (String location) {
        this.location = location;
    }

    public void setLD (LocalDate ld) {
        this.ld = ld;
    }

    public void setLT (LocalTime lt) { //needed to set new time_period
        //set time first
        if(lt.getHour() >= 13) {
            this.lt = LocalTime.of(lt.getHour() - 12, lt.getMinute());
        }
        else if (lt.getHour() == 0) {
            this.lt = LocalTime.of(lt.getHour() + 12, lt.getMinute());
        }
        else {
            this.lt = LocalTime.of(lt.getHour(), lt.getMinute());
        }
        //now set time period
        if (lt.getHour() >= 12) {
            this.time_period = "PM";
        }
        else {
            this.time_period = "AM";
        }
    }

    //no setter for time_period because that is reliant on setLT method

    public void setHasAppointment (boolean has_appointment) {
        this.has_appointment = has_appointment;
    }
}
