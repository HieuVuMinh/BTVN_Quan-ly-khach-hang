public class Room {
    private int dayRent;
    private String typeRent;
    private double priceRent;
    private Human human;

    public Room(){};

    public Room(int dayRent, String typeRent, double priceRent, Human human) {
        this.dayRent = dayRent;
        this.typeRent = typeRent;
        this.priceRent = priceRent;
        this.human = human;
    }

    public int getDayRent() {
        return dayRent;
    }

    public void setDayRent(int dayRent) {
        this.dayRent = dayRent;
    }

    public String getTypeRent() {
        return typeRent;
    }

    public void setTypeRent(String typeRent) {
        this.typeRent = typeRent;
    }

    public double getPriceRent() {
        return priceRent;
    }

    public void setPriceRent(double priceRent) {
        this.priceRent = priceRent;
    }

    public Human getHuman() {
        return human;
    }

    public void setHuman(Human human) {
        this.human = human;
    }

    @Override
    public String toString() {
        return "Room{" + "name='" + human.getName() + '\'' + ", age=" + human.getAge() +
                ", identity='" + human.getIdentity() + '\'' + " dayRent=" + dayRent +
                ", typeRent='" + typeRent + '\'' + ", priceRent=" + priceRent + '}';
    }

}
