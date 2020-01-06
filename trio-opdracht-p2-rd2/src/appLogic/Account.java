package appLogic;

public class Account {

    private int accountId;
    private String name;
    private String address;
    private String city;

    public Account(int accountId, String name, String address, String city) {
        this.accountId = accountId;
        this.name = name;
        this.address = address;
        this.city = city;
    }

    // Every class atrribute has its own getter and setter.

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId =  accountId;
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
