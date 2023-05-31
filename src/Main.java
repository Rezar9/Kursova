import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

class Java {
    public static void main(String[] args) {
        TrainSchedule schedule = new TrainSchedule();
        schedule.addTrain(new Train("Лювів", "Destination 1")
                .setDepartureDate(LocalDate.of(2023, 5, 29))
                .setDepartureTime(LocalTime.of(10, 30))
                .setPlatform(2)
                .addWagon("Плацкарт", 50) // Додавання вагону "Economy" з 50 місцями
                .addWagon("Купе", 20) // Додавання вагону "Business" з 20 місцями
                .addFacility("Wi-Fi") // Додавання зручності "Wi-Fi"
                .addFacility("Вагон-ресторан")); // Додавання зручності "AC"
        schedule.addTrain(new Train("Пересянки-Сокільники", "Destination 1")
                .setDepartureDate(LocalDate.of(2023, 5, 29))
                .setDepartureTime(LocalTime.of(11, 15))
                .setPlatform(1)
                .addWagon("Плацкарт", 60)
                .addWagon("КУпе", 30)
                .addFacility("Вагон-кафе"));
        schedule.addTrain(new Train("Дрогобич-Львів", "Destination 1")
                .setDepartureDate(LocalDate.of(2023, 5, 29))
                .setDepartureTime(LocalTime.of(14, 0))
                .setPlatform(3)
                .addWagon("Плацкарт", 40)
                .addWagon("Купе", 10)
                .addFacility("Вагон-ресторан"));
        schedule.addTrain(new Train("Київ-Харків", "Destination 1")
                .setDepartureDate(LocalDate.of(2023, 5, 29))
                .setDepartureTime(LocalTime.of(16, 45))
                .setPlatform(4)
                .addWagon("Плацкарт", 70)
                .addWagon("КУпе", 25)
                .addFacility("Wi-Fi")
                .addFacility("Вагон-ресторан"));
        schedule.addTrain(new Train("Одеса-Львів", "Destination 1")
                .setDepartureDate(LocalDate.of(2023, 5, 29))
                .setDepartureTime(LocalTime.of(19, 20))
                .setPlatform(2)
                .addWagon("Плацкарт", 55)
                .addWagon("Купе", 15)
                .addFacility("Вагон-ресторан")
                .addFacility("Безкоштовні напої"));
        schedule.addTrain(new Train("Харків-Дніпро", "Destination 1")
                .setDepartureDate(LocalDate.of(2023, 5, 29))
                .setDepartureTime(LocalTime.of(22, 10))
                .setPlatform(1)
                .addWagon("Плацкарт", 45)
                .addWagon("КУпе", 20)
                .addFacility("Wi-Fi"));

        schedule.displayTrainSchedule();

        // Додавання маршруту до поїзда
        Route route = new Route();
        route.addStation(new Station("Львів"));
        route.addStation(new Station("Тернопіль"));
        route.addStation(new Station("Хмельницький"));
        route.addStation(new Station("Вінниця"));
        route.addStation(new Station("Київ"));

        // Встановлення відстаней та часів прибуття/відправлення для кожної станції
        route.setDistance("Львів", 0);
        route.setDistance("Тернопіль", 150);
        route.setDistance("Хмельницький", 300);
        route.setDistance("Вінниця", 450);
        route.setDistance("Київ", 550);

        route.setArrivalTime("Львів", "10:30");
        route.setArrivalTime("Тернопіль", "12:45");
        route.setArrivalTime("Хмельницький", "15:20");
        route.setArrivalTime("Вінниця", "17:35");
        route.setArrivalTime("Київ", "20:15");

        route.setDepartureTime("Львів", "10:35");
        route.setDepartureTime("Тернопіль", "12:50");
        route.setDepartureTime("Хмельницький", "15:25");
        route.setDepartureTime("Вінниця", "17:40");
        route.setDepartureTime("Київ", "20:20");


        System.out.println("\nРозклад поїзду після додавання маршруту:");
        schedule.displayTrainSchedule();
        TicketSearch ticketSearch = new TicketSearch(schedule);
        List<Ticket> tickets = ticketSearch.searchTickets("Destination 1", LocalDate.of(2023, 5, 29));
        System.out.println("\nЗнайдені квитки:");
        for (Ticket ticket : tickets) {
            System.out.println(ticket);
        }
    }
}
