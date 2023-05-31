import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

class TicketSearch {
    private TrainSchedule trainSchedule;

    public TicketSearch(TrainSchedule trainSchedule) {
        this.trainSchedule = trainSchedule;
    }

    public List<Ticket> searchTickets(String destination, LocalDate date) {
        List<Ticket> tickets = new ArrayList<>();
        for (Train train : trainSchedule.getTrains()) {
            if (train.getDestination().equals(destination) && train.getDepartureDate().equals(date)) {
                tickets.add(new Ticket(train.getName(), train.getDepartureTime(), train.getAvailableSeats()));
            }
        }
        return tickets;
    }
}

class Ticket {
    private String trainName;
    private LocalTime departureTime;
    private int availableSeats;

    public Ticket(String trainName, LocalTime departureTime, int availableSeats) {
        this.trainName = trainName;
        this.departureTime = departureTime;
        this.availableSeats = availableSeats;
    }

    public String getTrainName() {
        return trainName;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    @Override
    public String toString() {
        return "Поїзд " + trainName + ", відправлення о " + departureTime + ", вільні місця: " + availableSeats;
    }
}