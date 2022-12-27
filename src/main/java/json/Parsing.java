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
    public JSONArray addBuliding(String fileName, String BlName, String city, String FoundationYear){
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = new JSONObject();
        JSONObject newJsonObject = new JSONObject();
        try {
            jsonObject = (JSONObject) jsonParser.parse(new FileReader(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONArray jsonArray = (JSONArray) jsonObject.get("Buildings");
        newJsonObject.put("BlName", BlName);
        newJsonObject.put("city", city);
        newJsonObject.put("FoundationYear", FoundationYear);
        jsonArray.add(newJsonObject);
        jsonObject.put("Buildings",newJsonObject);
        return jsonArray;

    }
    void printFile(String path) {
        List<Building> buildings = parseFile(path);
        for (Building building : buildings) {
            System.out.println(building.toString());
        }
    }
};


