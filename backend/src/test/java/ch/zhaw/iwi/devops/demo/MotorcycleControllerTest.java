package ch.zhaw.iwi.devops.demo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MotorcycleControllerTest {

    @Test
    public void testCreate() {
        MotorcycleController controller = new MotorcycleController();
        Motorcycles newMotorcycle = new Motorcycles(1, "Test Motorcycle", "Test Type");
        controller.createMotorcycle(1, newMotorcycle);
        assertEquals(1, controller.motorcycle().size());
    }
}
