package ai.palsoft.androidcourse.Classes;

public class Contact {
    private String name;
    private String phoneNo;

    public Contact(String name, String specialization){
        this.name = name;
        this.phoneNo = specialization;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString(){
        return this.name + " | " + this.phoneNo;
    }
}
