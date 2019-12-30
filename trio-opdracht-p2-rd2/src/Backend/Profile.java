package Backend;

public class Profile {

    private int id;
    private String profileName;
    private int age;

    public Profile(int id, String profileName, int age) {
        this.id = id;
        this.profileName = profileName;
        this.age = age;
    }

    // Ieder attribuut heeft een getter en setter.


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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Id: " + this.getId() + "\n");
        sb.append("Profile name: " + this.getProfileName() + "\n");
        sb.append("Age: " + this.getAge() + "\n");

        return sb.toString();
    }
}
