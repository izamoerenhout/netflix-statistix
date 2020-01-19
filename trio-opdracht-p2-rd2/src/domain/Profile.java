package domain;

/** Model Object for the Profiles screen. */
public class Profile {
    private String email;
    private String accountName;
    private String profileName;
    private int age;

    /** Class constructor.
     *
     * @param email The user's registered email address.
     * @param accountName The user's full name.
     * @param profileName The user's profile name.
     * @param age The user's age.
     */
    public Profile(String email, String accountName, String profileName, int age) {
        this.email = email;
        this.accountName = accountName;
        this.profileName = profileName;
        this.age = age;
    }

    /** Getters and setters */
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
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
}
