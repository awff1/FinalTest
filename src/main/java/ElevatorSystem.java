import java.util.List;
import java.util.Random;

// Реализация системы лифтов
class ElevatorSystem implements CallInterface, StepInterface {
    private List<Elevator> elevators;
    private Random random = new Random();

    public ElevatorSystem(List<Elevator> elevators) {
        this.elevators = elevators;
    }

    @Override
    public Elevator requestElevator(CallType type, int floor) throws Exception {
        for (Elevator elevator : elevators) {
            if (elevator.isAvailable() && elevator.canHandle(type)) {
                elevator.setDestination(floor);
                return elevator;
            }
        }
        throw new Exception("Нет доступных лифтов для " + type + " на этаж " + floor);
    }

    @Override
    public void step() {
        for (Elevator elevator : elevators) {
            elevator.step();
        }
    }
}
