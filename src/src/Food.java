package src;

public class Food {
    private String name;
    private int price;
    private int ID;
    private String category;
    private boolean available;

    public Food(String name, int price, int ID, String category, boolean available) {
        this.name = name;
        this.price = price;
        this.ID = ID;
        this.category = category;
        this.available = available;
    }

    @Override
    public String toString(){
        if(available){
            return name + " " + Integer.toString(price) + "[Price]  Available [" + category + "]"  ;
        }

        return name + " " + Integer.toString(price) + "[Price]  Unavailable [" + category + "]"  ;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public int getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public boolean isAvailable() {
        return available;
    }
}

