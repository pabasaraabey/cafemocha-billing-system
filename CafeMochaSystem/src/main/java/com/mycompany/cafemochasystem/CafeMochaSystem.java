/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cafemochasystem;

import java.io.*;
import java.util.*;

public class CafeMochaSystem {

    private static final String MENU_FILE = "C:\\Users\\PC Solutions\\Documents\\NetBeansProjects\\CafeMochaSystem\\src\\main\\java\\com\\mycompany\\cafemochasystem/menu.txt";
    private static final String ORDERS_FILE = "C:\\Users\\PC Solutions\\Documents\\NetBeansProjects\\CafeMochaSystem\\src\\main\\java\\com\\mycompany\\cafemochasystem/orders.txt";
    private static final String USERNAME = "pabasara";
    private static final String PASSWORD = "12345";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try (scanner) {
            if (login()) {
                System.out.println("Login successful!");
                System.out.println("* * * * * * * * * * * * * * * * * * * * *");
                System.out.println("*  ( ( ( (                              *");
                System.out.println("*   ) ) ) )                             *");
                System.out.println("* |''''''''|_                           *");
                System.out.println("* |  Cafe  | ]- Welcome to Café Mocha - *");
                System.out.println("* |  Mocha |_]                          *");
                System.out.println("* \\       /                             *");
                System.out.println("*  `-----'                              *");
                System.out.println("* * * * * * * * * * * * * * * * * * * * *");
                
                boolean running = true;
                while (running) {
                    displayMainMenu();
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    
                    switch (choice) {
                        case 1 -> addNewOrder();
                        case 2 -> displayOrderDetails();
                        case 3 -> calculateAndPrintBill();
                        case 4 -> addNewMenuItem();
                        case 5 -> displayHelp();
                        case 6 -> {
                            running = false;
                            System.out.println("Logging out...!");
                            System.out.println("--- Thank you for using Cafe Mocha System! ---");
                        }
                        default -> System.out.println("Invalid choice. Please try again.");
                    }
                }
            } else {
                System.out.println("Login failed!, Exiting system.");
            }
        }
    }

    // Login to the system
    private static boolean login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        return USERNAME.equals(username) && PASSWORD.equals(password);
    }

    // Display main menu
    private static void displayMainMenu() {
        System.out.println("                                         ");
        System.out.println("* * * * * * * * * * * * * * * * * * * * *");
        System.out.println("*       --- Café Mocha System ---       *");
        System.out.println("* * * * * * * * * * * * * * * * * * * * *");
        System.out.println("*                                       *");
        System.out.println("*  1. Add New Customer Order            *");
        System.out.println("*  2. Display Order Details             *");
        System.out.println("*  3. Calculate and Print Bill          *");
        System.out.println("*  4. Add New Item to Menu              *");
        System.out.println("*  5. Help                              *");
        System.out.println("*  6. Exit                              *");
        System.out.println("*                                       *");
        System.out.println("* * * * * * * * * * * * * * * * * * * * *");
        System.out.print("Select an option: ");
        
    }
    // Add new customer order


        // Display menu
   private static void addNewOrder() {
    System.out.println("* * * * * * * * * * * * * * * * * * * * *");
    System.out.println("*                                       *");
    System.out.println("*        --- Add New Order ---          *");
    System.out.println("*                                       *");
    System.out.println("* * * * * * * * * * * * * * * * * * * * *");

    // Get Order Number
    String orderNumber;
    while (true) {
        System.out.print("Enter Order Number: ");
        orderNumber = scanner.nextLine().trim();
        if (!orderNumber.isEmpty()) break;
        System.out.println("Error: Order Number cannot be empty!");
    }

    // Get Customer Name
    String customerName;
    while (true) {
        System.out.print("Enter Customer Name: ");
        customerName = scanner.nextLine().trim();
        if (!customerName.isEmpty()) break;
        System.out.println("Error: Customer Name cannot be empty!");
    }

    // Get Customer Address
    String address;
    while (true) {
        System.out.print("Enter Customer Address: ");
        address = scanner.nextLine().trim();
        if (!address.isEmpty()) break;
        System.out.println("Error: Address cannot be empty!");
    }

    // Get Customer Telephone
    String telephone;
    while (true) {
        System.out.print("Enter Customer Telephone: ");
        telephone = scanner.nextLine().trim();
        if (!telephone.isEmpty()) break;
        System.out.println("Error: Telephone cannot be empty!");
    }

    // Display menu before taking order details
    displayMenu();

    // Get Order Items
    String items;
    while (true) {
        System.out.print("Enter items (e.g., Coffee,Cake): ");
        items = scanner.nextLine().trim();
        if (!items.isEmpty()) break;
        System.out.println("Error: You must order at least one item!");
    }

    // Get Quantities
    String quantities;
    while (true) {
        System.out.print("Enter quantities: ");
        quantities = scanner.nextLine().trim();
        if (!quantities.isEmpty()) break;
        System.out.println("Error: Please provide item quantities!");
    }

    // Save order to file
try (BufferedWriter writer = new BufferedWriter(new FileWriter(ORDERS_FILE, true))) {
        // Ensure all fields are correctly formatted
        String orderData = orderNumber + "," + customerName + "," + address + "," + telephone + "," + items + "," + quantities;
        writer.write(orderData);
        writer.newLine();
        System.out.println("Order saved successfully!");
    } catch (IOException e) {
        System.out.println("Error saving order: " + e.getMessage());
    }
}

    // Display order details
    private static void displayOrderDetails() {
        System.out.println("* * * * * * * * * * * * * * * * * * * * *");
        System.out.println("*                                       *");
        System.out.println("*          --- Oder Details ---         *");
        System.out.println("*                                       *");
        System.out.println("* * * * * * * * * * * * * * * * * * * * *");
        try (BufferedReader reader = new BufferedReader(new FileReader(ORDERS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                System.out.println("Order Number: " + details[0]);
                System.out.println("Customer Name: " + details[1]);
                System.out.println("Address: " + details[2]);
                System.out.println("Telephone: " + details[3]);
                System.out.println("Items: " + details[4]);
                System.out.println("Quantities: " + details[5]);
                System.out.println("-----------------------------");
            }
        } catch (IOException e) {
            System.out.println("Error reading orders: " + e.getMessage());
        }
    }

        // Calculate and print bill with improved design
private static void calculateAndPrintBill(){
    System.out.println("* * * * * * * * * * * * * * * * * * * * *");
    System.out.print("Enter Order Number: ");
    String orderNumber = scanner.nextLine();

    try (BufferedReader reader = new BufferedReader(new FileReader(ORDERS_FILE))) {
        String line;
        boolean found = false;

        while ((line = reader.readLine()) != null) {
            String[] details = line.split(",");

            //  Ensure the file contains all required parts
            if (details.length < 6) {
                System.out.println("Error: Incorrect order format in file. Skipping this entry.");
                continue; // Skip this line and move to the next one
            }

            if (details[0].equals(orderNumber)) {
                found = true;

                String[] items = details[4].split(","); // Get items list
                String[] quantities = details[5].split(","); // Get quantities list

                //  Ensure item count matches quantity count
                if (items.length != quantities.length) {
                    System.out.println("Error: Items and quantities count mismatch in order file.");
                    return;
                }

                System.out.println("* * * * * * * * * * * * * * * * * * * * * * * *");
                System.out.println("*  ( ( ( (                                    *");
                System.out.println("*   ) ) ) )                                   *");
                System.out.println("* |''''''''|_                                 *");
                System.out.println("* |  Cafe  | ]     - Total Bill For you  -    *");
                System.out.println("* |  Mocha |_]                                *");
                System.out.println("* \\       /                                   *");
                System.out.println("*  `-----'                                    *");
                System.out.println("* * * * * * * * * * * * * * * * * * * * * * * *");
                System.out.println("-----------------------------------------------");
                System.out.printf("| %-20s | %-5s | %-10s |%n", "Item", "Qty", "Total Price");
                System.out.println("-----------------------------------------------");

                double total = 0.0;

                for (int i = 0; i < items.length; i++) {
                    String itemName = items[i].trim();

                    // Ensure quantity is a valid number
                    int quantity;
                    try {
                        quantity = Integer.parseInt(quantities[i].trim());
                    } catch (NumberFormatException ex) {
                        System.out.println("Error: Invalid quantity format for item '" + itemName + "'.");
                        return;
                    }

                    double price = getItemPrice(itemName); // Fetch price from menu
                    double itemTotal = price * quantity;
                    total += itemTotal;

                    System.out.printf("| %-20s | %-5d | RS%-9.2f |%n", itemName, quantity, itemTotal);
                }

                double tax = total * 0.10;
                total += tax;

                System.out.println("-----------------------------------------------");
                System.out.printf("| %-20s | %-5s | RS%-9.2f |%n", "Tax (10%)", "", tax);
                System.out.println("-----------------------------------------------");
                System.out.printf("| %-20s | %-5s | RS%-9.2f |%n", "Total Bill", "", total);
                System.out.println("-----------------------------------------------");
                System.out.println("       Thank You for Visiting Café Mocha!      ");
                System.out.println("-----------------------------------------------");

                break;
            }
        }

        if (!found) {
            System.out.println("Order not found.");
        }
    } catch (IOException e) {
        System.out.println("Error reading orders: " + e.getMessage());
    } catch (NumberFormatException e) {
        System.out.println("Error: Invalid number format in order file.");
    } catch (Exception e) { // Catch any unexpected errors
        System.out.println("Unexpected error occurred: " + e.getMessage());
    }
}



    // Add new item to menu
    private static void addNewMenuItem() {
        System.out.println("* * * * * * * * * * * * * * * * * * * * *");
        System.out.println("*                                       *");
        System.out.println("*          --- Add New Item ---         *");
        System.out.println("*                                       *");
        System.out.println("* * * * * * * * * * * * * * * * * * * * *");
        System.out.print("Enter Item Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Item Description: ");
        String description = scanner.nextLine();
        System.out.print("Enter Item Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Item Category: ");
        String category = scanner.nextLine();

        // Save item to menu file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(MENU_FILE, true))) {
            writer.write(name + "," + description + "," + price + "," + category + "\n");
            System.out.println("Menu item added successfully!");
        } catch (IOException e) {
            System.out.println("Error saving menu item: " + e.getMessage());
        }
    }

    // Display help
    private static void displayHelp() {
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println("*                                                                 *");
        System.out.println("*                           --- Help ---                          *");
        System.out.println("*                                                                 *");
        System.out.println("*-----------------------------------------------------------------*");
        System.out.println("* 1. Add New Order: Record customer details and order information.*");
        System.out.println("* 2. Display Order Details: View details of customer orders.      *");
        System.out.println("* 3. Calculate Bill: Calculate the total bill for an order.       *");
        System.out.println("* 4. Add New Menu Item: Add new items to the menu.                *");
        System.out.println("* 5. Help: Display system usage guidelines.                       *");
        System.out.println("* 6. Exit: Log out and close the system.                          *");
        System.out.println("*-----------------------------------------------------------------*");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
    }

    // Display menu
    private static void displayMenu() {
        System.out.println("***************************************");
        System.out.println("*                                     *");
        System.out.println("*        --- Menu Items ---           *");
        System.out.println("*                                     *");
        System.out.println("***************************************");
        try (BufferedReader reader = new BufferedReader(new FileReader(MENU_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                System.out.println(details[0] + " - $" + details[2] + " (" + details[3] + ")");
            }
        } catch (IOException e) {
            System.out.println("Error reading menu: " + e.getMessage());
        }
    }

    // Get item price from menu
    private static double getItemPrice(String itemName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(MENU_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                if (details[0].equalsIgnoreCase(itemName)) {
                    return Double.parseDouble(details[2]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading menu: " + e.getMessage());
        }
        return 0.0;
    }
}