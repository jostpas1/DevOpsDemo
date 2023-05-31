package ch.zhaw.iwi.devops.demo;

public class Motorcycles {

    private int id;
    private String title;
    private String motorcycleType;

    public Motorcycles() {
    }
    
    public Motorcycles(int id, String title, String motorcycleType) {
        this.id = id;
        this.title = title;
        this.motorcycleType = motorcycleType;
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

    public String getMotorcycleType() {
        return motorcycleType;
    }
}
