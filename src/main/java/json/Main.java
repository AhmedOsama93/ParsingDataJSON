package json;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {

        //parsing.printFile(path);
        while (true) {
            Parsing parsing = new Parsing();
            String path = "D:\\4th year 1st term\\SOA\\Assignments\\Assignment_3\\untitled1\\src\\sample.json";
            System.out.println("1:print all records");
            System.out.println("2:add new record");
            System.out.println("3:search");
            System.out.println("4:delete a record");
            System.out.println("5:exit");
            Scanner scanner = new Scanner(System.in);
            int input;
            try {
                input = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Wrong input");
                continue;
            }
            scanner.nextLine();
            switch (input) {
                case 1://print all records
                    parsing.printFile(path);
                    break;
                case 2://add new record
                    System.out.println("Enter the building name");
                    String BlName;
                    BlName = scanner.nextLine();
                    System.out.println("Enter the building city");
                    String city;
                    city = scanner.nextLine();
                    System.out.println("Enter the building FoundationYear");
                    String FoundationYear;
                    FoundationYear = scanner.nextLine();
                    try {
                        parsing.addBuliding(path, BlName, city, FoundationYear);
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3://search for a specific city or foundation year and retrieve the search
                    System.out.println("Enter search method (Building name or city or FoundationYear.)");
                    String method;
                    method = scanner.nextLine();
                    System.out.println("Enter your specific city or foundation year or building name");
                    String value;
                    value = scanner.nextLine();
                    parsing.searchByMethod(method, value);
                    break;
                case 4://delete
                    System.out.println("Enter method for Delete (BlName or city or FoundationYear.)");
                    String methodD;
                    methodD = scanner.nextLine();
                    System.out.println("Enter your specific city or foundation year or building name");
                    String valueD;
                    valueD = scanner.nextLine();
                    parsing.deleteByMethod(methodD, valueD);
                    break;
                case 5://exit
                    return;
                default:
                    System.out.println("Wrong input");
            }
        }
    }
}
