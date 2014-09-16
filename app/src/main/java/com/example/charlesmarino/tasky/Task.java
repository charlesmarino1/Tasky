package com.example.charlesmarino.tasky;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by charlesmarino on 9/10/14.
 */
public class Task {

    String name, description, ID;

    public Task(JSONObject object) {

        try {
            this.name = object.getString("name");
            this.description = object.getString("description");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public Task( String ID, String name, String description) {
            this.name = name;
            this.description = description;
            this.ID = ID;
    }


    public static ArrayList<Task> fromJSON(JSONArray jsonObjects) {
        ArrayList<Task> tasks = new ArrayList<Task>();
        for (int i = 0; i < jsonObjects.length(); i++) {
            try {
                tasks.add(new Task(jsonObjects.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return tasks;
    }
}