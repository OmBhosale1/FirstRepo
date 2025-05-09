package Java_CaseStudy;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n==== Coin Collection Menu ====");
            System.out.println("1. Add Coin");
            System.out.println("2. Show full collection");
            System.out.println("3. List coins by country");
            System.out.println("4. List coins by year of minting");
            System.out.println("5. List coins sorted by current value");
            System.out.println("6. Search");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addMenu(sc);
                    break;
                case 2:
                    CaseStudy.showDatabase();
                    break;
                case 3:
                    CaseStudy.listOnCountry();
                    break;
                case 4:
                    CaseStudy.listOnYOM();
                    break;
                case 5:
                    CaseStudy.listOnCurrentVal();
                    break;
                case 6:
                    searchMenu(sc);
                    break;
                case 0:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);

        sc.close();
    }

    public static void addMenu(Scanner sc) throws SQLException {
        int addChoice;
        System.out.println("\n---- Add Coin Menu ----");
        System.out.println("1. Add a single coin");
        System.out.println("2. Bulk insert coins");
        System.out.print("Enter your choice: ");
        addChoice = sc.nextInt();

        switch (addChoice) {
            case 1:
                CaseStudy.addCoin();
                break;
            case 2:
                CaseStudy.addBulkCoins();
                break;
            default:
                System.out.println("Invalid choice! Returning to main menu.");
        }
    }

    public static void searchMenu(Scanner sc) throws SQLException {
        int searchChoice;
        System.out.println("\n---- Search Menu ----");
        System.out.println("1. Search by Country + Denomination");
        System.out.println("2. Search by Country + Year of Minting");
        System.out.println("3. Search by Country + Denomination + Year of Minting");
        System.out.println("4. Search by Acquired Date + Country");
        System.out.print("Enter your choice: ");
        searchChoice = sc.nextInt();

        switch (searchChoice) {
            case 1:
                CaseStudy.searchCD();
                break;
            case 2:
                CaseStudy.searchCY();
                break;
            case 3:
                CaseStudy.searchCDY();
                break;
            case 4:
                CaseStudy.searchAC();
                break;
            default:
                System.out.println("Invalid choice! Returning to main menu.");
        }
    }
}
  