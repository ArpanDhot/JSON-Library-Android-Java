package com.example.jsondatabasereadandwrite;

import org.json.JSONException;
import org.json.JSONObject;

public class ObjectGetterAndSetter {

    /**
     * This code should on the class in which you want to save the data into the JsonArray
     */
    //JSON getter and setter
    public JSONObject getJson(String JSONObj) {
        JSONObject json = new JSONObject();
        //This exception is required because value is not sure if it will be passed
        try {
            json.put("objectName", JSONObj);
            json.put("posX", this.getxPos());
            json.put("posY", this.getxPos());
            json.put("velX", this.getxVel());
            json.put("velY", this.getyVel());
            json.put("spriteSize", this.getSpriteSize());
            json.put("rectangleSize", this.getSpriteSize());
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return json;
    }

    public void setJson(JSONObject json) {
        try {
            this.setxPos(json.getInt("posX"));
            this.setyPos(json.getInt("posY"));
            this.setxVel(json.getInt("velX"));
            this.setyVel(json.getInt("velY"));
            this.setSpriteSize(json.getInt("spriteSize"));
            this.rectangle.set(0, 0, json.getInt("spriteSize"), json.getInt("spriteSize"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



}
