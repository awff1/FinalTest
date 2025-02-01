

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Elevator> elevators = new ArrayList<>();

        // 3 лифта для четных этажей
        for (int i = 1; i <= 3; i++) {
            elevators.add(new EvenFloorElevator("Четный лифт " + i, ElevatorState.IDLE));
        }
        // 3 лифта для нечетных этажей
        for (int i = 1; i <= 3; i++) {
            elevators.add(new OddFloorElevator("Нечетный лифт " + i, ElevatorState.IDLE));
        }
        // 1 лифт для сотрудников
        elevators.add(new StaffElevator("Лифт для сотрудников"));

        // Создаем систему управления лифтами
        ElevatorSystem system = new ElevatorSystem(elevators);

        // Запускаем симуляцию работы лифтов
        Simulation.runSimulation(system);
    }
}
