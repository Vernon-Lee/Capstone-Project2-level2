import java.util.InputMismatchException;
import java.util.Scanner;

public class Project {
    public static void main(String[] args) {
        Menu();

    }

    private static void Menu() {
        // main menu
        Scanner input = new Scanner(System.in);

        System.out.println("Enter one of the options below: ");
        System.out.println("1 - Capture Project Details");
        System.out.println("2 - Change project due date");
        System.out.println("3 - Change total amount of fee paid to date");
        System.out.println("4 - Update a contractor's contact details");
        System.out.println("5 - Finalize a project");
        System.out.println("6 - Exit");
        try {
            //ask user to give input
            System.out.print("\nPlease enter option here: ");
            int menuNum = input.nextInt();
            if (menuNum > 6) {
                System.out.println("Input out of range.");
                System.exit(0);
            }
            if (menuNum == 1) {
                // call 'projectObject' method
                System.out.println("Create project object");
                System.out.println(projectObject());
            } else if (menuNum == 2) {
                // call 'changeDueDate' method

                System.out.println("Project due date is changed to: " + changeDueDate());
            } else if (menuNum == 3) {
                // call 'changeFeePaid' method
                System.out.println("Total amount paid is changed to: " + changeFeePaid());
            } else if (menuNum == 4) {
                // call 'contactDetails' method
                System.out.println("Updated contractor's contact details: 0" + contactDetails());

            } else if (menuNum == 5) {
                // call 'finalized' method
                finalise();
            } else
                System.exit(0);

        } catch (InputMismatchException e) {
            System.out.println("Incorrect input, can only input 1,2,3,4,5 or 6");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    public static projectDetail projectObject() {
        try {
            // Allow user to give input
            Scanner scanner = new Scanner(System.in);

            Scanner number = new Scanner(System.in);
            System.out.println("Project number: ");
            int num = number.nextInt();

            System.out.println("Project name: ");
            String name = scanner.nextLine();

            System.out.println("Type of building being designed: ");
            String buildingType = scanner.nextLine();

            System.out.println("Address for the project: ");
            String address = scanner.nextLine();

            System.out.println("ERF number: ");
            String ERFNumber = scanner.nextLine();

            System.out.println("Total fee being charged: ");
            long totFee = number.nextLong();

            System.out.println("Total amount paid: ");
            long totPaid = number.nextLong();

            System.out.println("Deadline for the project(DD-MM-YY): ");
            String deadline = scanner.nextLine();
            number.close();
            scanner.close();

            // create project object
            projectDetail obj1 = new projectDetail();
            obj1.number = num;
            obj1.name = name;
            obj1.buildingType = buildingType;
            obj1.address = address;
            obj1.ERFNumber = ERFNumber;
            obj1.totFee = totFee;
            obj1.totPaid = totPaid;
            obj1.deadline = deadline;
            // print project object
            System.out.println(obj1);
            return obj1;
        } catch (InputMismatchException e) {
            System.out.println("Incorrect input was given.");
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    // Change the due date of the project
    public static String changeDueDate() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("\nChange due date of the project(DD-MM-YY): ");
            String dueDate = input.nextLine();
            input.close();
            projectDetail obj1 = new projectDetail();
            return obj1.deadline = dueDate;
        } catch (InputMismatchException e) {
            System.out.println("Incorrect input, can not input string.");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        throw new RuntimeException();
    }

    // Change the total amount of the fee paid
    public static long changeFeePaid() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("\nChange total fee paid: ");
            long feePaid = input.nextLong();
            input.close();
            projectDetail obj1 = new projectDetail();
            return obj1.totPaid = feePaid;
        } catch (InputMismatchException e) {
            System.out.println("Incorrect input was given.");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        throw new RuntimeException();
    }

    // Update contractor's contact details
    public static long contactDetails() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("\nUpdate contractor's contact details: ");
            long contact = input.nextLong();
            input.close();
            projectPerson contractor1 = new projectPerson();
            return contractor1.personTelNum = contact;
        } catch (InputMismatchException e) {
            System.out.println("Incorrect input was given.");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        throw new RuntimeException();
    }

    // finalise the project
    public static void finalise() {
        try {
            Scanner input = new Scanner(System.in);
            //customers contact details
            System.out.println("\nInput customers telephone number: ");
            long telNum = input.nextLong();
            //noinspection WriteOnlyObject
            projectPerson customer1 = new projectPerson();
            customer1.personTelNum = telNum;
            System.out.println();

            //tot outstanding amount
            System.out.println("Total amount for project: ");
            long totFee = input.nextLong();
            System.out.println("Total amount paid: ");
            long totPaid = input.nextLong();

            //noinspection WriteOnlyObject
            projectDetail obj1 = new projectDetail();
            obj1.totFee = totFee;
            obj1.totPaid = totPaid;
            long outstandingAmount = totFee - totPaid;


            //if full amount was paid, no invoice
            if (totFee == outstandingAmount) {
                System.out.println("\nNo fee needs to paid.");

            } else {
                System.out.println("\nTotal outstanding amount: " + outstandingAmount);
            }

            //mark project as finalized
            System.out.println("\nInput number of finalized project: ");
            int num = input.nextInt();
            input.close();
            obj1.number = num;
            System.out.println("Mark project number " + num + " as read.");

            //add completion date
            Scanner giveDate = new Scanner(System.in);
            System.out.println("\nInput date of completion: ");
            String date = giveDate.nextLine();
            giveDate.close();
            System.out.println("Date of completion: " + date);
        } catch (InputMismatchException e) {
            System.out.println("Incorrect input was given.");
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

    }
}

//The reason why I have multiple scanner objects in most of my methods is because if I use a single scanner object
//it causes the program to skip certain lines, and I don't understand why.