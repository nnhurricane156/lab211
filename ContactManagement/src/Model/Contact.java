package Model;

public class Contact {
    private int id;
    private static int nextId = 1;
    private String fullName;
    private String group;
    private String address;
    private String phone;

    public Contact(String fullName, String group, String address, String phone) {
        this.id = nextId++;
        this.fullName = fullName;
        this.group = group;
        this.address = address;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLastName() {
        if (fullName == null || fullName.isEmpty()) {
            return "";
        }

        String[] temp = fullName.split(" ");
        return temp[temp.length - 1];
    }
    public String getFirstName() {
        if (fullName == null || fullName.isEmpty()) {
            return "";
        }

        String[] temp = fullName.split(" ");
        return temp[0];
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("%-15d%-15s%-15s%-15s%-15s%-15s%-15s",id,fullName,getFirstName(),getLastName(),group,address,phone);
    }
}
