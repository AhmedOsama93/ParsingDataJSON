package json;

import java.io.IOException;

public class Main {
    public static void main(String args[]) {
        Parsing parsing=new Parsing();
        String path="D:\\4th year 1st term\\SOA\\Assignments\\Assignment_3\\untitled1\\src\\sample.json";
        parsing.printFile(path);
        try {
            parsing.addBuliding(path, "Elmo7afza", "Cairo","1919");
        }catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("*********************");
        parsing.searchByMethod("city","Cairo");
        //parsing.printFile(path);

    }
}
