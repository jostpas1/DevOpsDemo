package ch.zhaw.iwi.devops.demo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class MotorcyclesTest {

    @Test
    void testMotorcyle() {
        var motorcycle = new Motorcycles(42, "TestCycle", "TestType");
        motorcycle.setId(42);
        assertEquals("TestCycle", motorcycle.getTitle());
        assertEquals("TestType", motorcycle.getMotorcycle_type());
        assertEquals(42, motorcycle.getId());
    }

    @Test
    void testEmptyMotorcyle() {
        var motorcycle = new Motorcycles();
        motorcycle.setId(69);
        assertEquals(null, motorcycle.getTitle());
        assertEquals(null, motorcycle.getMotorcycle_type());
        assertEquals(69, motorcycle.getId());
    }
    
}