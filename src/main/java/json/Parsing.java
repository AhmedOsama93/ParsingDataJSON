package json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
public class Parsing {
        public static void main(String args[]) {
            //Creating a JSONParser object
            JSONParser jsonParser = new JSONParser();
            try {
                //Parsing the contents of the JSON file
                JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("D:\\4th year 1st term\\SOA\\Assignments\\Assignment_3\\untitled1\\src\\sample.json"));
                //Forming URL
                //Retrieving the array
                JSONArray jsonArray = (JSONArray) jsonObject.get("Buildings");
                System.out.println("Building details: ");
                //Iterating the contents of the array
                Iterator iterator = jsonArray.iterator();
                while(iterator.hasNext()) {
                    System.out.println(iterator.next());
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

