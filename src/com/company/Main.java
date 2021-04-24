package com.company;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobiliePhone = new MobilePhone("069 47 00 396");
    public static void main(String[] args) {
	boolean quit = false;
	phoneStart();
	printActions();
	while(!quit){
        System.out.println("\nEnter action: (6 to show available actions");
        int action = scanner.nextInt();
        scanner.nextLine();
	    switch(action) {
            case 0:
                System.out.println("\nShutting down... ");
                quit = true;
                break;
            case 1:
                mobiliePhone.printContacts();
                break;
            case 2:
                addNewContact();
                break;
            case 3:
                updateContact();
                break;
            case 4:
                removeContact();
                break;
            case 5:
                queryContact();
                break;
            case 6:
                printActions();
                break;
        }


    }


    }

    public static void updateContact(){
        System.out.println("Enter your old contact: ");
        String old = scanner.nextLine();
        Contact existingContact = mobiliePhone.queryContacts(old);
        if(existingContact == null){
            System.out.println("Old contact cannot be found");
            return;
        }
        System.out.println("Enter name of your new contact: ");
        String newName = scanner.nextLine();
        System.out.println("Enter phone number of your new contact: ");
        String newPhone = scanner.nextLine();
        Contact newContact = new Contact(newName, newPhone);
        if(mobiliePhone.updateContact(existingContact,newContact)){
            System.out.println("Your contact updated successfully");
        }else{
            System.out.println("Error in updating... ");
        }
    }

    public static void removeContact(){
        System.out.println("Enter your old contact: ");
        String old = scanner.nextLine();
        Contact existingContact = mobiliePhone.queryContacts(old);
        if(existingContact == null){
            System.out.println("Old contact cannot be found");
            return;
        }
        if(mobiliePhone.removeContact(existingContact)){
            System.out.println("Removed successfully");
        }else{
            System.out.println("Error deleting contact");
        }

    }

    public static void queryContact(){
        System.out.println("Enter your old contact: ");
        String old = scanner.nextLine();
        Contact existingContact = mobiliePhone.queryContacts(old);
        if(existingContact == null){
            System.out.println("Old contact cannot be found");
            return;
        }
        System.out.println("Name: " + existingContact.getName() + " Phone number: "+ existingContact.getPhoneNumber());

    }


    public static void addNewContact(){
        System.out.println("Enter name of your new contact: ");
        String name = scanner.nextLine();
        System.out.println("Enter number of your new contact: ");
        String nr = scanner.nextLine();
        Contact newContact = new Contact(name, nr);
        if(mobiliePhone.addContact(newContact)){
            System.out.println("New contact added: Name -> "+ name + "\nNumber -> "+ nr);
        }else{
            System.out.println("This contact is already in your Contacts");
        }

    }

    public static void phoneStart(){
        System.out.println("Phone is starting...");
    }
    public static void printActions(){
        System.out.println("\nAvailable action:\npress:");
        System.out.println("0 - to shutdown\n" +
                "1 - to print contacts\n" +
                "2 - to add new contact\n" +
                "3 - to update an existing contact\n"+
                "4 - to reomve an existing contact\n"+
                "5 - query if an axisting contact exist\n"+
                "6 - to print a list of available actions.");
        System.out.println("Choose your action: ");
    }
}


