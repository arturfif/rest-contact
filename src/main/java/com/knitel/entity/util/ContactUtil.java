package com.knitel.entity.util;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.knitel.entity.Contact;

import java.util.List;

public class ContactUtil {

    public static JsonObject toJson(List<Contact> contacts) {
        Gson gson = new Gson();
        JsonObject object = new JsonObject();
        JsonElement element = gson.toJsonTree(contacts);
        object.add("contacts", element);
        return object;
    }

}
