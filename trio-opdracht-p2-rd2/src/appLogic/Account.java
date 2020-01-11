package appLogic;

/** Model Object for the Accounts screen. */
public class Account {
    private String email;
    private String name;
    private String address;
    private String city;

    /** Class constructor.
     *
     * @param email The user's registered email address.
     * @param name The user's full name.
     * @param address The user's full address, consisting of street name, house number and suffix.
     * @param city The user's city of residence.
     */
    public Account(String email, String name, String address, String city) {
        this.email = email;
        this.name = name;
        this.address = address;
        this.city = city;
    }

    /** Getters and setters. */
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
