import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Route {
    private List<Station> stations;
    private Map<String, Integer> distances;
    private Map<String, LocalTime> arrivalTimes;
    private Map<String, LocalTime> departureTimes;

    public Route() {
        stations = new ArrayList<>();
        distances = new HashMap<>();
        arrivalTimes = new HashMap<>();
        departureTimes = new HashMap<>();
    }

    public void addStation(Station station) {
        stations.add(station);
    }

    public void setDistance(String station, int distance) {
        distances.put(station, distance);
    }

    public void setArrivalTime(String station, String time) {
        LocalTime arrivalTime = LocalTime.parse(time);
        arrivalTimes.put(station, arrivalTime);
    }

    public void setDepartureTime(String station, String time) {
        LocalTime departureTime = LocalTime.parse(time);
        departureTimes.put(station, departureTime);
    }

    public List<Station> getStations() {
        return stations;
    }

    public int getDistance(String station) {
        return distances.getOrDefault(station, -1);
    }

    public LocalTime getArrivalTime(String station) {
        return arrivalTimes.get(station);
    }

    public LocalTime getDepartureTime(String station) {
        return departureTimes.get(station);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Station station : stations) {
            sb.append(station.getName()).append(" (")
                    .append(arrivalTimes.get(station.getName())).append(" - ")
                    .append(departureTimes.get(station.getName())).append(")").append(" -> ");
        }
        sb.setLength(sb.length() - 4);
        return sb.toString();
    }
}

