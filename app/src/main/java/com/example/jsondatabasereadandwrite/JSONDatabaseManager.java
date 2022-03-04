package com.example.jsondatabasereadandwrite;


/**
 * ONLY NEED TO COPY AND PASTE THE THE CLASS.
 * IF YOU WANT TO SEE EXAMPLE OF ITS IMPLEMENTATION BirdGameAndroid -> LeveCreate.java (Write line 168) -  CustomGameView.java (Read line 71)
 */

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class JSONDatabaseManager {

    private Context context;


    JSONDatabaseManager(Context context){
        this.context = context;

    }


    /**
     * These methods will read and convert the data into a Json Array
     */
    //Converts string data to
    public JSONArray jsonReadData(String fileName) {

        try {
            String dataFromFile = readFromFile(fileName+".json");
            JSONArray jsonArray = new JSONArray(dataFromFile);
            return jsonArray;


        }catch (JSONException e){
            e.printStackTrace();
        }
        return null;
    }

    //This reads from the file
    private String readFromFile(String fileName){
        File path = context.getFilesDir();
        File readFrom = new File(path,fileName+".json");
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
    /**
     * End code for Read
     */



    /**
     * These methods will convert the Json Array into string and store it into a file
     */
    /**
     * You will require to do the following:
     *
     *              int i = 0;
     *             for (TypeClass objectName : ArrayListOfObject) {
     *                 //Adding the JSON objects in the JSON Array
     *                 //The JSON objects are created in the Block class
     *                 jsonArray.put(block.getJson("Block" + i));
     *                 i++;
     *             }
     */
    public void jsonWriteData(String fileName,JSONArray jsonArray) {

        // Convert JsonObject to String Format
        String userString = jsonArray.toString();

        //Calling the method to write into the file
        // Define the File Path and its Name
        writeToFile(fileName+".json", userString);

    }


    /**
     * You can view your app's files view android studio.
     *
     * view→ tool windows→ device file explorer. Then choose your app. It should be in data/data/your app (app name equals to package name com.example.game;)
     */
    private void writeToFile(String fileName,String content){

        File path = context.getFilesDir();
        try {
            FileOutputStream writer = new FileOutputStream(new File(path, fileName));
            writer.write(content.getBytes());
            writer.close();
            System.out.println("SAVED");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * End code for Write
     */





}
