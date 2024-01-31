import java.time.*;

public class patientTest {

    public static void main (String arg[]) {
        LocalDate myLD = LocalDate.of(2024, Month.JANUARY, 29);
        LocalTime myLT = LocalTime.of(14, 30);
        LocalDateTime myLTD = LocalDateTime.of(myLD, myLT);

        patient pat1 = new patient("Bobs", "Burgers", "The Hospital", myLTD);
        System.out.print("Dear " + pat1.getFirstName() + " " + pat1.getLastName() + ":");
        pat1.cancelAppointment();
        System.out.print("Dear " + pat1.getFirstName() + " " + pat1.getLastName() + ":");
        pat1.setAppointment("Hospital", myLD, myLT);
        System.out.print("Dear " + pat1.getFirstName() + " " + pat1.getLastName() + ":");
        pat1.checkAppointment();

        patient pat2 = new patient("Max", "Millian");
        System.out.print("Dear " + pat2.getFirstName() + " " + pat2.getLastName() + ":");
        pat2.checkAppointment();

        patient pat3 = new patient();
        System.out.print("Dear " + pat3.getFirstName() + " " + pat3.getLastName() + ":");
        pat3.checkAppointment();
        pat3.setFirstName("Patrick");
        pat3.setLastName("Star");
    }
}
