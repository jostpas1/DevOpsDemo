package ch.zhaw.iwi.devops.demo;

public class Motorcycles {

    private int id;
    private String title;
    private String motorcycle_type;

    public Motorcycles() {
    }
    
    public Motorcycles(int id, String title, String motorcycle_type) {
        this.id = id;
        this.title = title;
        this.motorcycle_type = motorcycle_type;
    }

    public int getId() {
        return id;
    }    

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getMotorcycle_type() {
        return motorcycle_type;
    }
    
}