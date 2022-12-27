package json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//"D:\\4th year 1st term\\SOA\\Assignments\\Assignment_3\\untitled1\\src\\sample.json"
public class Parsing {
    public ArrayList<Building> parseFile(String fileName) {
        //Creating a JSONParser object
        JSONParser jsonParser = new JSONParser();
        ArrayList<Building> buildings = new ArrayList<>();

        try {
            //Parsing the contents of the JSON file
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(fileName));
            //Forming URL
            //Retrieving the array
            JSONArray jsonArray = (JSONArray) jsonObject.get("Buildings");
            System.out.println("Building details: ");
            //Iterating the contents of the array
            Iterator iterator = jsonArray.iterator();
            while (iterator.hasNext()) {
                JSONObject jsonObjec = (JSONObject) iterator.next();
                String blName = (String) jsonObjec.get("BlName");
                String city = (String) jsonObjec.get("city");
                String FoundationYear = (String) jsonObjec.get("FoundationYear");
                buildings.add(new Building(blName, city, FoundationYear));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return buildings;
    }

    void printFile(String path) {
        List<Building> buildings = parseFile(path);
        for (Building building : buildings) {
            System.out.println(building.toString());
        }
    }
};


