import org.example.dao.ComputerEquipment;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.example.dao.EquipmentDao.list;
import static org.example.dao.EquipmentDao.search;

public class EquipmentServiceTest {

    @Test
    public void search_ShouldReturnMatchingItems_WhenSearchingById() {
        // Arrange
        List<ComputerEquipment> inventory = createSampleInventory();
        List<ComputerEquipment> results = new ArrayList<>();

        // Act
        List<ComputerEquipment> searchResults = search(inventory, "id", "2", results);

        // Assert
        Assert.assertEquals(1, searchResults.size());
        Assert.assertEquals(2, searchResults.get(0).getId());
    }

    @Test
    public void search_ShouldReturnMatchingItems_WhenSearchingByName() {
        // Arrange
        List<ComputerEquipment> inventory = createSampleInventory();
        List<ComputerEquipment> results = new ArrayList<>();

        // Act
        List<ComputerEquipment> searchResults = search(inventory, "name", "keyboard", results);

        // Assert
        Assert.assertEquals(2, searchResults.size());
        Assert.assertEquals("Keyboard", searchResults.get(0).getEquipmentName());
        Assert.assertEquals("Wireless Keyboard", searchResults.get(1).getEquipmentName());
    }

    @Test
    public void list_ShouldSortItemsById() {
        // Arrange
        List<ComputerEquipment> computerEquipments = createSampleInventory();

        // Act
        List<ComputerEquipment> sortedList = list("id", computerEquipments);

        // Assert
        Assert.assertEquals(3, sortedList.size());
        Assert.assertEquals(1, sortedList.get(0).getId());
        Assert.assertEquals(2, sortedList.get(1).getId());
        Assert.assertEquals(3, sortedList.get(2).getId());
    }

    @Test
    public void list_ShouldSortItemsByPrice() {
        // Arrange
        List<ComputerEquipment> computerEquipments = createSampleInventory();

        // Act
        List<ComputerEquipment> sortedList = list("price", computerEquipments);

        // Assert
        Assert.assertEquals(3, sortedList.size());
        Assert.assertEquals(49.99, sortedList.get(0).getEquipmentPrice(), 0.01);
        Assert.assertEquals(99.99, sortedList.get(1).getEquipmentPrice(), 0.01);
        Assert.assertEquals(149.99, sortedList.get(2).getEquipmentPrice(), 0.01);
    }

    private List<ComputerEquipment> createSampleInventory() {
        List<ComputerEquipment> inventory = new ArrayList<>();
        inventory.add(new ComputerEquipment(1, "Laptop", "Electronics", 99.99, 10));
        inventory.add(new ComputerEquipment(2, "Keyboard", "Peripherals", 49.99, 5));
        inventory.add(new ComputerEquipment(3, "Wireless Keyboard", "Peripherals", 149.99, 2));
        return inventory;
    }
}
