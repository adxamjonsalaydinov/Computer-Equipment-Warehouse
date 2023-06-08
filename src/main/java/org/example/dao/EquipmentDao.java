package org.example.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EquipmentDao {

    public static List<ComputerEquipment> search(List<ComputerEquipment> inventory, String parameter, String value, List<ComputerEquipment> results) {
        for (ComputerEquipment computerEquipment : inventory) {
            switch (parameter) {
                case "id":
                    if (computerEquipment.getId() == Integer.parseInt(value)) {
                        results.add(computerEquipment);
                    }
                    break;
                case "name":
                    if (computerEquipment.getEquipmentName().toLowerCase().contains(value)) {
                        results.add(computerEquipment);
                    }
                    break;
                case "category":
                    if (computerEquipment.getCategory().toLowerCase().contains(value)) {
                        results.add(computerEquipment);
                    }
                    break;
                case "price":
                    if (computerEquipment.getEquipmentPrice() == Double.parseDouble(value)) {
                        results.add(computerEquipment);
                    }
                    break;
                case "quantity":
                    if (computerEquipment.getEquipmentQuantity() == Integer.parseInt(value)) {
                        results.add(computerEquipment);
                    }
                    break;
                default:
                    System.out.println("Invalid search parameter.");
            }
        }
        return results;
    }

    public static List<ComputerEquipment> list(String order, List<ComputerEquipment> computerEquipments) {
        List<ComputerEquipment> sorted = new ArrayList<>(computerEquipments);
        switch (order) {
            case "id":
                Collections.sort(sorted, Comparator.comparingInt(ComputerEquipment::getId));
                break;
            case "name":
                Collections.sort(sorted, Comparator.comparing(ComputerEquipment::getEquipmentName));
                break;
            case "category":
                Collections.sort(sorted, Comparator.comparing(ComputerEquipment::getCategory));
                break;
            case "price":
                Collections.sort(sorted, Comparator.comparingDouble(ComputerEquipment::getEquipmentPrice));
                break;
            case "quantity":
                Collections.sort(sorted, Comparator.comparingInt(ComputerEquipment::getEquipmentQuantity));
                break;
            default:
                System.out.println("Invalid sort order.");
        }
        return sorted;
    }
}
