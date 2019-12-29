package Backend;

public class Account {

    private int id;
    private String name;
    private String address;
    private String city;

    public Account(int id, String name, String address, String city) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
    }

    // Ieder attribuut heeft een getter en setter.

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id =  id;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Id: " + this.getId() + "\n");
        sb.append("Name: " + this.getName() + "\n");
        sb.append("Address: " + this.getAddress() + "\n");
        sb.append("City: " + this.getCity() + "\n");

        return sb.toString();
    }
}
