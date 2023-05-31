import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
class TrainSchedule {
    private List<Train> trains;

    public TrainSchedule() {
        trains = new ArrayList<>();
    }

    public void addTrain(Train train) {
        trains.add(train);
    }

    public Train getTrain(String trainName) {
        for (Train train : trains) {
            if (train.getName().equals(trainName)) {
                return train;
            }
        }
        return null;
    }

    public List<Train> getTrains() {
        return trains;
    }

    public void displayTrainSchedule() {
        System.out.println("Розклад поїздів:");
        for (Train train : trains) {
            System.out.println(train);
        }
    }
}