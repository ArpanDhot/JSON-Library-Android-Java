package com.example.jsondatabasereadandwrite;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadJson {

    //This converts the string into JsonArray and then you can access each JsonObject
    // https://www.youtube.com/watch?v=h71Ia9iFWfI&t=167s&ab_channel=ProgrammingExperts
    private void jsonLoadData() {

        try {
            String data = readFromFile("jsonDataBase.json");
            JSONArray jsonArray = new JSONArray(data);


            for(int i=0; i<jsonArray.length();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                System.out.println("THE LOCATION OF THE FIRS ELEMENT IS: "+jsonObject.getInt("posX"));
            }

        }catch (JSONException e){
            e.printStackTrace();
        }




    }

    //This reads from the file
    private String readFromFile(String fileName){
        File path = context.getFilesDir();
        File readFrom = new File(path,fileName);
        byte[] content = new byte[(int) readFrom.length()];
        try {
            FileInputStream stream = new FileInputStream(readFrom);
            stream.read(content);
            return  new String(content);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            return  e.toString();
        }

        return "CODE DID NOT WORK";
    }
}
