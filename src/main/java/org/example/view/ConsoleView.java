package org.example.view;


import static org.example.controller.EquipmentController.control;

public class

ConsoleView {

    public static void main(String[] args) {
        System.out.println("Computer Equipment Warehouse (Created on June 1, 2023)");
        System.out.println("Developer: Adhamjon Salaydinov (adhamjon_salaydinov@student.itpu.uz)");


        System.out.println("\nAvailable commands:");
        System.out.println("1. Search products");
        System.out.println("2. List all products");
        System.out.println("3. Exit");
        control();
    }
}
