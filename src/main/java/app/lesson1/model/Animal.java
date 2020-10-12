package app.lesson1.model;


public class Animal {

    private Long id;
    private String name;

    public Animal(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public void changeName(String name){
        this.setName(name);
    }

    public void changeId(Long id){
        this.setId(id);
    }
}
