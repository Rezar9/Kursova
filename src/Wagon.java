
class Wagon {
    private String type;
    private int seats;

    public Wagon(String type, int seats) {
        this.type = type;
        this.seats = seats;
    }

    public String getType() {
        return type;
    }

    public int getSeats() {
        return seats;
    }

    @Override
    public String toString() {
        return type + " (" + seats + " μ³ρφό)";
    }
}