package ch.zhaw.iwi.devops.demo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MotorcycleControllerTest {

    @Test
    public void testCreate() {
        MotorcycleController controller = new MotorcycleController();
        Motorcycles newMotorcycle = new Motorcycles(1, "Test Motorcycle", "Test Type");
        controller.createMotorcycle(newMotorcycle);
        assertEquals(1, controller.motorcycle().size());
    }

    @Test
    public void testGetMotorcycle() {
        MotorcycleController controller = new MotorcycleController();
        Motorcycles newMotorcycle = new Motorcycles(1, "Test Motorcycle", "Test Type");
        controller.createMotorcycle(newMotorcycle);

        Motorcycles fetchedMotorcycle = controller.getMotorcycle(1);
        assertEquals(newMotorcycle.getTitle(), fetchedMotorcycle.getTitle());
    }

    @Test
    public void testDeleteMotorcycle() {
        MotorcycleController controller = new MotorcycleController();
    
        // Erstellen eines Motorrad und hinzufügen
        Motorcycles newMotorcycle = new Motorcycles(1, "Test Motorcycle", "Test Type");
        controller.createMotorcycle(newMotorcycle);
    
        // Sicherstellen, dass das Motorrad existiert
        assertNotNull(controller.getMotorcycle(1));
    
        // Löschen des Motorrads
        controller.deleteMotorcycle(1);
    
        // Sicherstellen, dass das Motorrad gelöscht wurde
        assertNull(controller.getMotorcycle(1));
    }
    
}