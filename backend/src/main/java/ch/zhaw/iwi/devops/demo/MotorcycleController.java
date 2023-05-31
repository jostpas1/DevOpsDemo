package ch.zhaw.iwi.devops.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CrossOrigin
@RestController
public class MotorcycleController {

    private Map<Integer, Motorcycles> motorcycles = new HashMap<>();
    private static final Logger logger = LoggerFactory.getLogger(MotorcycleController.class);
    

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        final String motorcycle_type = "Aufbauart Motorrad";
        this.motorcycles.put(1,new Motorcycles(1, "Naked", motorcycle_type));
        this.motorcycles.put(2,new Motorcycles(2, "Crossover", motorcycle_type));
        this.motorcycles.put(3,new Motorcycles(3, "Enduro", motorcycle_type));
        this.motorcycles.put(4,new Motorcycles(4, "Sport", motorcycle_type));
        this.motorcycles.put(5,new Motorcycles(5, "Tourer", motorcycle_type));
        logger.info("Init Data");
        }

    @GetMapping("/services/motorcycle")
    public List<PathListEntry<Integer>> motorcycle() {
        var result = new ArrayList<PathListEntry<Integer>>();
        for (var motorcycle : this.motorcycles.values()) {
            var entry = new PathListEntry<Integer>();
            entry.setKey(motorcycle.getId(), "motorcycleKey");
            entry.setName(motorcycle.getTitle());
            entry.getDetails().add(motorcycle.getMotorcycle_type());
            entry.setTooltip(motorcycle.getMotorcycle_type());
            result.add(entry);
        }
        return result;
    }

    @GetMapping("/services/motorcycle/{id}")
    public Motorcycles getMotorcycle(@PathVariable Integer id) {
        return this.motorcycles.get(id);
    }

    @PostMapping("/services/motorcycle")
    public void createMotorcycle(@RequestBody Motorcycles motorcycle) {
        var newId = this.motorcycles.keySet().stream().max(Comparator.naturalOrder()).orElse(0) + 1;
        motorcycle.setId(newId);
        this.motorcycles.put(newId, motorcycle);
    }

    @PutMapping("/services/motorcycle/{id}")
    public void createMotorcycle(@PathVariable Integer id, @RequestBody Motorcycles motorcycle) {
        motorcycle.setId(id);
        this.motorcycles.put(id, motorcycle);
    }

    @DeleteMapping("/services/motorcycle/{key}")
    public Motorcycles deleteMotorcycle(@PathVariable Integer id) {
        return this.motorcycles.remove(id);
    }

}