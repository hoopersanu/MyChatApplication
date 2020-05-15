package com.example.mychatapplication.Model;

import java.util.HashMap;
import java.util.List;

public class Group {
    String id;
    String name;
    List<Integer> users;
    private String imageUrl;

    public Group(String id, String name, List<Integer> users){
        this.id = id;
        this.name = name;
        this.users = users;
        this.imageUrl = "default";

    }

    public Group(){
    }

    public HashMap toHashMap(){
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("id", id);
        hashMap.put("name", name);
        hashMap.put("users", users);
        hashMap.put("imageUrl", imageUrl);
        return hashMap;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getUsers() {
        return users;
    }

    public void setUsers(List<Integer> users) {
        this.users = users;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
