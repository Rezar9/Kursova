import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

class Java {
    public static void main(String[] args) {
        TrainSchedule schedule = new TrainSchedule();
        schedule.addTrain(new Train("����", "Destination 1")
                .setDepartureDate(LocalDate.of(2023, 5, 29))
                .setDepartureTime(LocalTime.of(10, 30))
                .setPlatform(2)
                .addWagon("��������", 50) // ��������� ������ "Economy" � 50 ������
                .addWagon("����", 20) // ��������� ������ "Business" � 20 ������
                .addFacility("Wi-Fi") // ��������� �������� "Wi-Fi"
                .addFacility("�����-��������")); // ��������� �������� "AC"
        schedule.addTrain(new Train("���������-���������", "Destination 1")
                .setDepartureDate(LocalDate.of(2023, 5, 29))
                .setDepartureTime(LocalTime.of(11, 15))
                .setPlatform(1)
                .addWagon("��������", 60)
                .addWagon("����", 30)
                .addFacility("�����-����"));
        schedule.addTrain(new Train("��������-����", "Destination 1")
                .setDepartureDate(LocalDate.of(2023, 5, 29))
                .setDepartureTime(LocalTime.of(14, 0))
                .setPlatform(3)
                .addWagon("��������", 40)
                .addWagon("����", 10)
                .addFacility("�����-��������"));
        schedule.addTrain(new Train("���-�����", "Destination 1")
                .setDepartureDate(LocalDate.of(2023, 5, 29))
                .setDepartureTime(LocalTime.of(16, 45))
                .setPlatform(4)
                .addWagon("��������", 70)
                .addWagon("����", 25)
                .addFacility("Wi-Fi")
                .addFacility("�����-��������"));
        schedule.addTrain(new Train("�����-����", "Destination 1")
                .setDepartureDate(LocalDate.of(2023, 5, 29))
                .setDepartureTime(LocalTime.of(19, 20))
                .setPlatform(2)
                .addWagon("��������", 55)
                .addWagon("����", 15)
                .addFacility("�����-��������")
                .addFacility("���������� ����"));
        schedule.addTrain(new Train("�����-�����", "Destination 1")
                .setDepartureDate(LocalDate.of(2023, 5, 29))
                .setDepartureTime(LocalTime.of(22, 10))
                .setPlatform(1)
                .addWagon("��������", 45)
                .addWagon("����", 20)
                .addFacility("Wi-Fi"));

        schedule.displayTrainSchedule();

        // ��������� �������� �� �����
        Route route = new Route();
        route.addStation(new Station("����"));
        route.addStation(new Station("��������"));
        route.addStation(new Station("������������"));
        route.addStation(new Station("³�����"));
        route.addStation(new Station("���"));

        // ������������ �������� �� ���� ��������/����������� ��� ����� �������
        route.setDistance("����", 0);
        route.setDistance("��������", 150);
        route.setDistance("������������", 300);
        route.setDistance("³�����", 450);
        route.setDistance("���", 550);

        route.setArrivalTime("����", "10:30");
        route.setArrivalTime("��������", "12:45");
        route.setArrivalTime("������������", "15:20");
        route.setArrivalTime("³�����", "17:35");
        route.setArrivalTime("���", "20:15");

        route.setDepartureTime("����", "10:35");
        route.setDepartureTime("��������", "12:50");
        route.setDepartureTime("������������", "15:25");
        route.setDepartureTime("³�����", "17:40");
        route.setDepartureTime("���", "20:20");


        System.out.println("\n������� ����� ���� ��������� ��������:");
        schedule.displayTrainSchedule();
        TicketSearch ticketSearch = new TicketSearch(schedule);
        List<Ticket> tickets = ticketSearch.searchTickets("Destination 1", LocalDate.of(2023, 5, 29));
        System.out.println("\n������� ������:");
        for (Ticket ticket : tickets) {
            System.out.println(ticket);
        }
    }
}
