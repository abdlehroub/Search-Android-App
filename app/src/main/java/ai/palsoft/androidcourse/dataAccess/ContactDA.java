package ai.palsoft.androidcourse.dataAccess;

import java.util.ArrayList;

import ai.palsoft.androidcourse.Classes.Contact;

public class ContactDA {
    private ArrayList<Contact> contactsList = new ArrayList<>();


    public ContactDA(){
        contactsList.add(new Contact("Omar Imhimid", "05957429887"));
        contactsList.add(new Contact("Abdelrahman Imhimid", "0598745456"));
        contactsList.add(new Contact("Jihad Imhimid", "0589747423"));
        contactsList.add(new Contact("Wael Hamdan", "0598656874"));
        contactsList.add(new Contact("Zaid Qudimat", "0563258974"));
        contactsList.add(new Contact("Waseem Jawdat", "0527478954"));
        contactsList.add(new Contact("Mohammad Lehroub", "0599252874"));
        contactsList.add(new Contact("Qassem Sayara", "0565721335"));
        contactsList.add(new Contact("Mohammed Radwan", "0568974556"));
        contactsList.add(new Contact("Wadee Radwan", "0532748996"));

    }
    public void addContact(Contact contact){
        contactsList.add(contact);
    }

    public ArrayList<Contact> getContactsList() {
        return contactsList;
    }
}
