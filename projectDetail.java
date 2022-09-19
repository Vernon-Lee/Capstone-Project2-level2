public class projectDetail {
    //Attributes for project
    public int number;
    public String name;
    public String buildingType;
    public String address;
    public String ERFNumber;
    public long totFee;
    public long totPaid;
    public String deadline;


    public String toString() {
        String output = "\nProject number: " + number;
        output = output + "\nProject name: " + name;
        output = output + "\nType of building being designed: " + buildingType;
        output = output + "\nAddress for the project: " + address;
        output = output + "\nERF number: " + ERFNumber;
        output = output + "\nTotal fee being charged: " + totFee;
        output = output + "\nTotal amount paid: " + totPaid;
        output = output + "\nDeadline for the project: " + deadline;

        return output;
    }
}


