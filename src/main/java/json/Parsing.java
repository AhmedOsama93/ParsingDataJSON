package json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Parsing {
    public String fileName ="D:\\4th year 1st term\\SOA\\Assignments\\Assignment_3\\untitled1\\src\\sample.json";
    public ArrayList<Building> parseFile(String fileName) {
        //Creating a JSONParser object
        JSONParser jsonParser = new JSONParser();
        ArrayList<Building> buildings = new ArrayList<>();
        JSONArray jsonArray =new JSONArray();
        try {
            //Parsing the contents of the JSON file
            jsonArray  =  (JSONArray)  jsonParser.parse(new FileReader(fileName));
            //Forming URL
            //Retrieving the array
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
    public void addBuliding(String fileName, String BlName, String city, String FoundationYear) throws IOException {
//        add a new building to JSON file
//        I took the building details from the user then I created newJsonObject from these details then I added it in JSONArray
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray =new JSONArray();
        JSONObject newJsonObject = new JSONObject();
        try {
            jsonArray = (JSONArray) jsonParser.parse(new FileReader(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        newJsonObject.put("BlName", BlName);
        newJsonObject.put("city", city);
        newJsonObject.put("FoundationYear", FoundationYear);
        jsonArray.add(newJsonObject);
        FileWriter file = new FileWriter(fileName);
        file.write(String.valueOf(jsonArray));
        file.close();
    }
    public void searchByMethod(String method, String value){
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray =new JSONArray();
        try {
            jsonArray = (JSONArray) jsonParser.parse(new FileReader(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Iterator iterator = jsonArray.iterator();
        while (iterator.hasNext()) {
            JSONObject jsonObject = (JSONObject) iterator.next();
            if(method.equals("BlName") && value.equals((String)jsonObject.get("BlName"))){
                System.out.println(jsonObject);
            }
            if(method.equals("city") && value.equals((String)jsonObject.get("city"))){
                System.out.println(jsonObject);
            }
            if(method.equals("FoundationYear") && value.equals((String)jsonObject.get("FoundationYear"))){
                System.out.println(jsonObject);
            }
        }
    }
    void printFile(String path) {
        List<Building> buildings = parseFile(path);
        for (Building building : buildings) {
            System.out.println(building.toString());
        }
    }

};


