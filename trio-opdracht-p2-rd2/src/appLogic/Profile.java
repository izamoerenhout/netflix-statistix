package appLogic;

import java.util.ArrayList;

public class Profile {

    private int id;
    private String profileName;
    private int age;
    private ArrayList<Watched> watchedPrograms;

    public Profile(int id, String profileName, int age) {
        this.id = id;
        this.profileName = profileName;
        this.age = age;
        this.watchedPrograms = new ArrayList<>();
    }

    // Every class atrribute has its own getter and setter.

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<Watched> getWatchedPrograms() {
        return watchedPrograms;
    }

    public void setWatchedPrograms(ArrayList<Watched> watchedPrograms) {
        this.watchedPrograms = watchedPrograms;
    }
}
