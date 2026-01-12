import java.util.*;

public class Client {

    //data field declarations
    private String careType;
    private ArrayList<String> rejectedClinics;

    //method definitions


    /**
     * Default constructor that initializes data fields for Client info
     */
    public Client() {
        careType = null;
        rejectedClinics = null;
        System.out.println("IN THE DEFAULT CONSTRUCTOR");
    }

    /**
     * Non-default constructor that takes user input for their necessary medical care type
     * @param medCare The user's selected care type
     */
    public Client(String medCare) {
        careType = medCare;
        rejectedClinics = new ArrayList<>();
    }

    /**
     * Sets the user's care type, probably right after they enter it with the scanner
     * @param careType
     */
    public void setCareType (String careType) { this.careType = careType; }

    /**
     * Sets the user's rejected clinics, after they are all read from the file
     * and added to the ArrayList
     * @param rejectedClinics
     */
    public void setRejectedClinics(ArrayList<String> rejectedClinics) { this.rejectedClinics = rejectedClinics; }


    /**
     * Kind of convoluted, but this method encompasses the process of suggesting clinics to the Client
     * based on their input and their rejected clinics.
     * @param key The user's input for care type
     * @param rejectedClincs the ArrayList of clinics that didn't work
     * @param generalCare a list of general and primary care clinics in case the specialized one doesn't work out
     * @param cheapestCare the list of affordable clinics that correspond with each care type
     * @param index the index at which the key is found
     */
    public void suggestCare (String key, ArrayList<String> rejectedClincs, String [] generalCare, String [] cheapestCare, int index){

        int position = 0;
        boolean found = false;

        while ((found == false) && (position < rejectedClinics.size())) {
            System.out.println("Checking clinic: " + rejectedClinics.get(position));

            if (key.equals(rejectedClinics.get(position))) {
                found = true;
                System.out.println ("The best option for this type of care does not fit your needs. Below there will be a list of general care facilities that may help you instead.");
                for (String general : generalCare) {
                    System.out.println(general);
                }
            } else {
                System.out.println("The best option for " + key + " is " + cheapestCare[index]);
            }
            position++;
        }
    }
}
