import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner fileIn = null;
        Scanner stdscan = new Scanner (System.in);
        int numFileItems = 0;
        File inputFile = new File ("input.txt");

        Client aClient = new Client();

        ArrayList<String> userRejectedClinics = new ArrayList<>();

        try {
            fileIn = new Scanner (inputFile);
            System.out.println("Input file exists. Proceeding to read the file.");

            while (fileIn.hasNextLine()){
                numFileItems++;
            }

            fileIn = new Scanner(inputFile);
            int index = 0;
            while (fileIn.hasNextLine()) {
                String line = fileIn.nextLine().trim();
                userRejectedClinics.add(line);
                System.out.println("Reading clinic: " + userRejectedClinics.get(index));  // Debug print
                index++;
            }

            aClient.setRejectedClinics(userRejectedClinics);

            System.out.println("Here are the clinics that didn't meet your needs: ");
            for (String clinic : userRejectedClinics){
                System.out.println(clinic);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Input file not found!");
            return; // Exit if the file doesn't exist
        }


        String careTypeInput = "";

        //Parallel arrays for the best and most affordable care facility for each are of medical concern (yes this was so tedious)
        String [] careTypes = {"ER", "Trauma Care", "General Medicine", "Pediatrics", "Geriatrics", "Cardiology", "Neurology", "Endocrinology", "Orthopedics", "Oncology", "Pulmonology", "Dermatology", "Ophthalmology", "Urology", "Imaging Service", "General Surgery", "Neurosurgery", "Obstetrics", "Gynecology", "Psychiatry", "Addiction Service", "Physical Therapy", "Palliative Care"};
        String [] cheapestCare = {"VCU Medical Center", "Retreat Doctor's Hospital", "CrossOver Healthcare Ministry", "Virginia Medicaid (FAMIS)", "Richmond PACE Senior Center and Services", "Pauley Heart Center at VCU Health", "VCU Health Department of Neurology", "Southside Medical Center", "OrthoVirginia", "VCU Massey Comprehensive Cancer Center", "VCU Health - Pulmonology and Critical Care Medicine", "Dermatology Associates of Virginia", "Lions Club Mechanicsville", "Virginia Urology", "Appomattox Imaging", "Stony Point Surgery Center", "Neurosurgical Associates", "Crossover Healthcare Ministry", "Crossover Healthcare Ministry", "Daily Planet Behavioral Health Clinic", "Daily Planet Behavioral Health Clinic", " Consulate Health Care Short-Term Rehabilitation", "VCU Palliative Care"};

        //General Healthcare facilities with a wide range of accepted insurances and cost accommodations.
        String [] generalCare = {"VCU Medical Center", "Health Brigade", "CrossOver Healthcare Ministry"};

        System.out.println("Please choose an area of medical concern from the following list to enter here: ");
        for (String careType : careTypes){
            System.out.println(careType);
        }

        careTypeInput = stdscan.next();
        aClient.setCareType(careTypeInput);
        System.out.println("User input: " + careTypeInput);

        String key = careTypeInput;
        int dexCareType = 0;
        for (int i = 0; i < careTypes.length; i++){
            if (careTypes[i].equals(careTypeInput)){
                dexCareType = i;
                break;
            }
        }

        aClient.suggestCare(key, userRejectedClinics, generalCare, cheapestCare, dexCareType);

    }
}