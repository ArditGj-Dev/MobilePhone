package com.company;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    public boolean addContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            System.out.println("Contact is already on list");
            return false;
        } else {
            myContacts.add(contact);
            return true;
        }
    }

    private int findContact(Contact contact) {
        return this.myContacts.indexOf(contact);
    }

    private int findContact(String contactName) {
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact = this.myContacts.get(i);
            if (contact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int foundPosition = findContact(oldContact);
        if (foundPosition < 0) {
            System.out.println(oldContact.getName() + ", cannot found");
            return false;
        } else {
            this.myContacts.set(foundPosition, newContact);
            System.out.println(oldContact.getName() + " was replaced with " + newContact.getName());
            return true;
        }
    }
    public Contact queryContacts(String name){
        int position = findContact(name);
        if(position>=0){
            return this.myContacts.get(position);
        }
        return null;
    }

    public boolean removeContact(Contact contact) {
        int foundPosition = findContact(contact);
        if (foundPosition < 0) {
            System.out.println(contact.getName() + ", cannot found");
            return false;
        }
        this.myContacts.remove(foundPosition);
        System.out.println(contact.getName() + " was deleted");
        return true;
    }

    public String queryContact(Contact contact) {
        if (findContact(contact) >= 0) {
            return contact.getName();
        }
        return null;
    }
    public void printContacts(){
        for(int i=0; i<myContacts.size();i++){
            System.out.println((i+1) + ". "+ myContacts.get(i).getName()+" --> "+
                               "   "+ myContacts.get(i).getPhoneNumber()+"\n");
        }
    }
}

