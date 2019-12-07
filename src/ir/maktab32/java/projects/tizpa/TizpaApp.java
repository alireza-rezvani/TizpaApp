package ir.maktab32.java.projects.tizpa;

import ir.maktab32.java.projects.tizpa.datasource.DataSource;
import ir.maktab32.java.projects.tizpa.model.TripMethod;
import ir.maktab32.java.projects.tizpa.utilities.Utilities;

import java.util.Scanner;

public class TizpaApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fromRegion;
        String toRegion;
        String tripMethodChooser;
        boolean isInputValid;

        do {
            System.out.println("\u29bf Where is Your Current Region?\t(Choose Between Regions 0, 1, 2, 3 or 4)");
            fromRegion = scanner.next();

            if (Utilities.isValueInRange(fromRegion,0,4))
                isInputValid = true;
            else {
                isInputValid = false;
                System.out.println("\t\u26a0 Invalid Region!\n");
            }

        }while (isInputValid == false);


        do {
            System.out.println("\u29bf Where do You Want to Go?\t(Choose Between Regions 0, 1, 2, 3 or 4)");
            toRegion = scanner.next();

            if (Utilities.isValueInRange(toRegion,0,4))
                isInputValid = true;
            else {
                isInputValid = false;
                System.out.println("\t\u26a0 Invalid Region!\n");
            }

        }while (isInputValid == false);


        do {
            System.out.println("\u29bf Choose Your Trip Method:");
            for (int i = 0; i < DataSource.tripMethods.length; i++)
                System.out.println("\tPress " + (i+1) + " for " + DataSource.tripMethods[i].getTitle());

            tripMethodChooser = scanner.next();

            if (Utilities.isValueInRange(tripMethodChooser,1,3))
                isInputValid = true;
            else {
                isInputValid = false;
                System.out.println("\t\u26a0 Invalid Method Number!\n");
            }

        }while (isInputValid == false);

        TripMethod selectedTripMethod = DataSource.tripMethods[Integer.parseInt(tripMethodChooser)-1];


        boolean isItTrafficPeak = false;
        System.out.println("\u29bf Is it Traffic's Peak Time?\t(y = Yes, Other Keys = No)");
        if (scanner.next().equals("y"))
            isItTrafficPeak = true;

        boolean isItRaining = false;
        System.out.println("\u29bf Is it Raining?\t(y = Yes, Other Keys = No)");
        if (scanner.next().equals("y"))
            isItRaining = true;

        double ratio;
        if (isItTrafficPeak && isItRaining)
            ratio = selectedTripMethod.getRainAndTrafficCoefficient();
        else if (isItTrafficPeak)
            ratio = selectedTripMethod.getTrafficCoefficient();
        else if (isItRaining)
            ratio = selectedTripMethod.getRainCoefficient();
        else
            ratio = 1;

        //to manage way back coefficients
        int index1 = Integer.parseInt(fromRegion);
        int index2 = Integer.parseInt(toRegion);
        if(index1 > index2){
            index1 = Integer.parseInt(toRegion);
            index2 = Integer.parseInt(fromRegion);
        }

        System.out.println("======================================================" +
                "\n\t\t\t\t\tResult\n======================================================" +
                "\n\u29bf " + selectedTripMethod.getTitle() +
                "\n\u29bf From Region " + fromRegion +
                "\n\u29bf To Region " + toRegion +
                "\n\u29bf Is it Traffic's Peak Time? " + isItTrafficPeak +
                "\n\u29bf Is it Raining? " + isItRaining +
                "\n------------------------------------------------------" +
                "\n\u2705 Your Trip's Price: (" + selectedTripMethod.getBasePrice() + " x "
                + DataSource.coefficients[index1][index2] + " x " + ratio + ") = "
                + (int)(selectedTripMethod.getBasePrice()*DataSource.coefficients[index1][index2]*ratio) + " Tomans.");
    }
}
