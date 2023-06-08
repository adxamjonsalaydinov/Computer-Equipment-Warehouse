package org.example.service;


import org.example.dao.ComputerEquipment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.example.dao.EquipmentDao.list;
import static org.example.dao.EquipmentDao.search;

public class EquipmentService {

    public static void searchEquipment(String parameter, String value) {
        List<ComputerEquipment> results = new ArrayList<>();
        List<ComputerEquipment> inventory = storeEquipments();

        search(inventory, parameter, value, results);
        if (results.isEmpty()) {
            System.out.println("No products found.");
            return;
        }
        System.out.println("Search results:");
        for (ComputerEquipment computerEquipment : results) {
            System.out.println(computerEquipment);
        }
    }

    public static void listEquipment(String order, List<ComputerEquipment> computerEquipments) {
        List<ComputerEquipment> sorted = list(order, computerEquipments);
        System.out.println("Product list:");
        for (ComputerEquipment equipment : sorted) {
            System.out.println(equipment);
        }
    }

    public static List<ComputerEquipment> storeEquipments() {
        List<ComputerEquipment> inventory = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/ComputerEquipment.csv"))) {
            String line = reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                int id = Integer.parseInt(fields[0]);
                String name = fields[1];
                String category = fields[2];
                double price = Double.parseDouble(fields[3]);
                int quantity = Integer.parseInt(fields[4]);
                ComputerEquipment computerEquipment = new ComputerEquipment(id, name, category, price, quantity);
                inventory.add(computerEquipment);
            }
        } catch (IOException e) {
            System.err.println("Error reading ComputerEquipment.csv file: " + e.getMessage());
        }
        return inventory;
    }
}
