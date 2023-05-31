package ch.zhaw.iwi.devops.demo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class MotorcyclesTest {

    @Test
    void testMotorcycle() {
        var motorcycle = new Motorcycles(42, "TestCycle", "TestType");
        motorcycle.setId(42);
        assertEquals("TestCycle", motorcycle.getTitle());
        assertEquals("TestType", motorcycle.getMotorcycleType());
        assertEquals(42, motorcycle.getId());
    }

    @Test
    void testEmptyMotorcycle() {
        var motorcycle = new Motorcycles();
        motorcycle.setId(69);
        assertEquals(null, motorcycle.getTitle());
        assertEquals(null, motorcycle.getMotorcycleType());
        assertEquals(69, motorcycle.getId());
    }
}