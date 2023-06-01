package ch.zhaw.iwi.devops.demo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

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


}