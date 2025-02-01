// Абстрактный класс Лифт
abstract class Elevator implements ElevatorStateProvider {
    protected String name;
    protected ElevatorState state;
    protected int currentFloor;
    protected Integer destinationFloor; // null - нет заказа

    public Elevator(String name) {
        this.name = name;
        this.state = ElevatorState.IDLE;
        this.currentFloor = 1; // Лифты всегда стартуют с 1 этажа
        this.destinationFloor = null;
    }

    @Override
    public ElevatorState state() {
        return state;
    }

    public void setDestination(int floor) {
        this.destinationFloor = floor;
        if (floor > currentFloor) {
            state = ElevatorState.MOVING_UP;
        } else if (floor < currentFloor) {
            state = ElevatorState.MOVING_DOWN;
        }
    }

    public void markAsIdle() {
        this.state = ElevatorState.IDLE;
        this.destinationFloor = null;
    }

    public boolean isAvailable() {
        return state == ElevatorState.IDLE;
    }

    public abstract boolean canHandle(CallType type);

    public void step() {
        if (state == ElevatorState.MOVING_UP) {
            currentFloor++;
            if (currentFloor == destinationFloor) {
                markAsIdle();
            }
        } else if (state == ElevatorState.MOVING_DOWN) {
            currentFloor--;
            if (currentFloor == destinationFloor) {
                markAsIdle();
            }
        }
    }

    @Override
    public String toString() {
        return name + " [Этаж: " + currentFloor + ", Статус: " + state + "]";
    }
}
