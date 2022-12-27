package json;

public class Main {
    public static void main(String args[]) {
        Parsing parsing=new Parsing();
        String path="D:\\4th year 1st term\\SOA\\Assignments\\Assignment_3\\untitled1\\src\\sample.json";
        parsing.printFile(path);
        parsing.addBuliding(path, "Elmo7afza", "Gize","1919");
        //parsing.printFile(path);

    }
}
