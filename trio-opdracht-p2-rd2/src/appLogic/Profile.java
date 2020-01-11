package appLogic;

public class Profile {
    private String email;
    private String accountName;
    private String profileName;
    private int age;

    public Profile(String email, String accountName, String profileName, int age) {
        this.email = email;
        this.accountName = accountName;
        this.profileName = profileName;
        this.age = age;
    }

    // Every class atrribute has its own getter and setter.

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}
