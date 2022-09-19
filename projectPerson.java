public class projectPerson {
    // Attributes person
    String personDescription; // contractor, customer or architect
    String personName;
    String personEmail;
    String personAddress;
    long personTelNum;

    public String toString() {
        String output = "Description: " + personDescription;
        output = output + "\nName: " + personName;
        output = output + "\nEmail: " + personEmail;
        output = output + "\nAddress: " + personAddress;
        output = output + "\nTelephone number: 0" + personTelNum;

        return output;
    }
}
