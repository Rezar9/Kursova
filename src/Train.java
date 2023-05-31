import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

class Train {
    private String name;
    private String destination;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private int platform;
    private List<Wagon> wagons;
    private List<String> facilities;
    private Route route;

    public Train(String name, String destination) {
        this.name = name;
        this.destination = destination;
        wagons = new ArrayList<>();
        facilities = new ArrayList<>();
    }

    public Train setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
        return this;
    }

    public Train setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
        return this;
    }

    public Train setPlatform(int platform) {
        this.platform = platform;
        return this;
    }

    public Train addWagon(String type, int seats) {
        wagons.add(new Wagon(type, seats));
        return this;
    }

    public Train addFacility(String facility) {
        facilities.add(facility);
        return this;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public String getName() {
        return name;
    }

    public String getDestination() {
        return destination;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public int getPlatform() {
        return platform;
    }

    public List<Wagon> getWagons() {
        return wagons;
    }

    public List<String> getFacilities() {
        return facilities;
    }

    public Route getRoute() {
        return route;
    }

    public int getAvailableSeats() {
        int totalSeats = 0;
        for (Wagon wagon : wagons) {
            totalSeats += wagon.getSeats();
        }
        return totalSeats;
    }

    @Override
    public String toString() {
        return "Поїзд " + name + " до " + destination +
                " (" + departureDate + " " + departureTime + ")" +
                "\nПлатформа: " + platform +
                "\nВагони: " + wagons +
                "\nЗручності: " + facilities +
                "\nМаршрут: " + route +
                "\n";
    }
}

