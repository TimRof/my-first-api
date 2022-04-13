package nl.inholland.myfirstapi.controller;

import com.google.gson.Gson;

public class Controller {

    public <T> T jsonToObject(String json, Class<T> classOfT) {
        return new Gson().fromJson(json, classOfT);
    }
}
