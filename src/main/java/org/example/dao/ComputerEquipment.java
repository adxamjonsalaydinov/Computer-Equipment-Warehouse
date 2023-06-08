package org.example.dao;

public class ComputerEquipment {
    private int id;
    private String equipmentName;
    private String category;
    private double equipmentPrice;
    private int equipmentQuantity;

    public ComputerEquipment(int id, String equipmentName, String category, double equipmentPrice, int equipmentQuantity) {
        this.id = id;
        this.equipmentName = equipmentName;
        this.category = category;
        this.equipmentPrice = equipmentPrice;
        this.equipmentQuantity = equipmentQuantity;
    }

    public int getId() {
        return id;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public String getCategory() {
        return category;
    }

    public double getEquipmentPrice() {
        return equipmentPrice;
    }

    public int getEquipmentQuantity() {
        return equipmentQuantity;
    }

    @Override
    public String toString() {
        return String.format("%-5d%-20s%-20s%8.2f%5d", id, equipmentName, category, equipmentPrice, equipmentQuantity);
    }
}
