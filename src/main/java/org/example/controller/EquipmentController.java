package org.example.controller;

import org.example.dao.ComputerEquipment;

import java.util.List;
import java.util.Scanner;

import static org.example.service.EquipmentService.*;

public class EquipmentController {

    public static void control() {
        Scanner scanner = new Scanner(System.in);
        List<ComputerEquipment> equipments = storeEquipments();
        while (true) {
            System.out.print("\nEnter command (1-3): ");
            int command = scanner.nextInt();
            scanner.nextLine();

            switch (command) {
                case 1 -> {
                    System.out.print("Enter search parameter (ID, name, category, price, or quantity): ");
                    String parameter = scanner.nextLine().trim().toLowerCase();
                    System.out.print("Enter search value: ");
                    String value = scanner.nextLine().trim().toLowerCase();
                    searchEquipment(parameter, value);
                }
                case 2 -> {
                    System.out.print("Enter sort order (ID, name, category, price, or quantity): ");
                    String order = scanner.nextLine().trim().toLowerCase();
                    listEquipment(order, equipments);
                }
                case 3 -> {
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

}
