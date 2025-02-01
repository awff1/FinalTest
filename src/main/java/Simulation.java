import java.util.Random;

// Класс симуляции работы лифтов
class Simulation {
    public static void runSimulation(ElevatorSystem system) {
        Random random = new Random();
        CallType[] callTypes = CallType.values();
        int maxFloor = 16;

        for (int i = 1; i <= 10000; i++) {
            system.step(); // Двигаем лифты на 1 шаг
            if (i % 20 == 0) { // Каждые 20 итераций вызываем лифт
                CallType type = callTypes[random.nextInt(callTypes.length)];
                int floor = 2 + random.nextInt(maxFloor - 1); // Случайный этаж (от 2 до maxFloor)

                System.out.println(">>> Вызов лифта: " + type + " на этаж " + floor);
                try {
                    Elevator elevator = system.requestElevator(type, floor);
                    System.out.println("Назначен лифт: " + elevator);
                } catch (Exception e) {
                    System.out.println("Ошибка: " + e.getMessage());
                }
            }
        }
    }
}

