/**
 * Created by Ny Derry on 7/12/2017.
 */


import java.util.Scanner;
import java.io.*;
import java.io.FileWriter;

public class Organizations {

    String organizations;
    static String welcomeMessage = "Thank you for organizing an activity today!!";
    Volunteer[] volunteerList = new Volunteer[0];
    int numberOfVolunteers = 0;

    //List of Methods for Organizations
    public Organizations(String organizationName) {
        organizations = organizationName;
    }

    public static void printWelcomeMessage() {
        System.out.println(welcomeMessage);
    }

    public void printOrganizations() {
        System.out.println(organizations);
    }

    //Add Volunteer to Volunteer List
    public void addVolunteer(Volunteer newVolunteer) {
        if (numberOfVolunteers >= 0) {
            Volunteer[] newarray = new Volunteer[(numberOfVolunteers + 1)];
            System.arraycopy(volunteerList, 0, newarray, 0, numberOfVolunteers);
            volunteerList = newarray;
        }
        volunteerList[numberOfVolunteers] = newVolunteer;
        numberOfVolunteers++;
    }

    //Assign Volunteer to Volunteer List
    public void assignVolunteer(String title) {
        String string1 = title;
        if (volunteerList.length == 0) {
            System.out.println("Sorry, this volunteer is not available");
        }
        for (int i = 0; i < volunteerList.length; i++) {
            if (string1.equals(volunteerList[i].volunteerName) && volunteerList[i].isAssigned() == false) {
                volunteerList[i].Assign();
                System.out.println("You successfully assigned " + volunteerList[i].getVolunteerName());
                break;
            } else if (string1.equals(volunteerList[i].volunteerName) && volunteerList[i].isAssigned() == true) {
                System.out.println("Sorry, this volunteer is already assigned.");
                break;
            } else if (string1.equals(volunteerList[i].volunteerName) == false) {
                System.out.println("Sorry, this volunteer is not on our volunteer list");
                break;
            }
        }
    }

    //Reject volunteer
    public void rejectVolunteer(String volunteerName) {
        String string1 = volunteerName;
        for (int i = 0; i < volunteerList.length; i++) {
            if (string1.equals(volunteerList[i].volunteerName) && volunteerList[i].isAssigned() == true) {
                volunteerList[i].Reject();
                System.out.println("You have rejected " + volunteerList[i].getVolunteerName() + " and returned them onto the Volunteer List.");
                break;
            }
        }
    }

    public void printAvailableVolunteers() {
        if (volunteerList.length > 0) {
            for (int i=0; i<numberOfVolunteers; i++) {
                System.out.println(volunteerList[i].volunteerName);
            }
        } else {
            System.out.println("No volunteers on the volunteer list currently.");
        }
    }

    public Volunteer[] getVolunteerList() {
        return volunteerList;
    }

    public static void main(String[] args) {

        Scanner userEntry = new Scanner(System.in);
        System.out.println("Welcome to the Organization Coordinator Application.");

        //Create two organizations
        Organizations girlScouts = new Organizations("Girl Scouts of Southeastern Michigan");
        Organizations pTSA = new Organizations("Parent Student Teacher Association");

        //Add Volunteer names
        girlScouts.addVolunteer(new Volunteer("Abigail"));
        girlScouts.addVolunteer(new Volunteer("Brian"));
        girlScouts.addVolunteer(new Volunteer("Carol"));
        pTSA.addVolunteer(new Volunteer("Donna"));
        girlScouts.addVolunteer(new Volunteer("Eric"));
        girlScouts.addVolunteer(new Volunteer("Francine"));
        pTSA.addVolunteer(new Volunteer("Gary"));
        pTSA.addVolunteer(new Volunteer("Harry"));
        pTSA.addVolunteer(new Volunteer("Iris"));
        pTSA.addVolunteer(new Volunteer("Jake"));
        pTSA.addVolunteer(new Volunteer("Kam"));
        girlScouts.addVolunteer(new Volunteer("Larry"));

        //Print welcome
        System.out.println("This application will link you to available volunteers.");
        printWelcomeMessage();
        System.out.println();

        System.out.println("Today's Organizations:");
        girlScouts.printOrganizations();
        pTSA.printOrganizations();
        System.out.println();

        //Print volunteer list
        System.out.println("Volunteers available for the Girl Scouts:");
        girlScouts.printAvailableVolunteers();
        System.out.println();
        System.out.println("Volunteers available for PTSA:");
        pTSA.printAvailableVolunteers();
        System.out.println();

        //Assign Abigail
        System.out.println("Please assign a volunteer for your Girl Scout Activity!");
        girlScouts.assignVolunteer(Validator.getString(userEntry, "\nEnter the volunteer's name: (Abigail) ")); // Validator does not seem to work?
        System.out.println();



        //Reject Abigail
        System.out.println("Reject Abigail to the Girl Scout Volunteer List:");
        girlScouts.rejectVolunteer("Abigail");
        System.out.println();

        //Print Girl Scout volunteers
        System.out.println("Volunteers available for the Girl Scouts:");
        girlScouts.printAvailableVolunteers();



    /*
    try{

        FileWriter writer = new FileWriter("c:\test5.txt");
        for(String str: volunteerList) {  // cannot resolve the non-static vs. static arraylist "volunteerList"
        writer.write(str);
        }
            writer.close();

        }

        catch (IOException e) {
            e.printStackTrace();
}
       */

    }

}
