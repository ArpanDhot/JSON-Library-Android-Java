package com.example.jsondatabasereadandwrite;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteJson {

    private void jsonLoadData() {
        int i = 0;
        for (Block block : blocks) {
            //Adding the JSON objects in the JSON Array
            //The JSON objects are created in the position class
            jsonArray.put(block.getJson("Block" + i));
            i++;
        }

        // Convert JsonObject to String Format
        String userString = jsonArray.toString();

        //Calling the method to write into the file
        // Define the File Path and its Name
        writeToFile("jsonDataBase.json", userString);

    }


    /**
     * You can view your app's files view android studio.
     *
     * view→ tool windows→ device file explorer. Then choose your app. It should be in data/data/your app (app name equals to package name com.example.game;)
     */
    public void writeToFile(String fileName,String content){

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
}
