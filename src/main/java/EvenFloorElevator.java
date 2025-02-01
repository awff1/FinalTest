// Лифт для четных этажей
class EvenFloorElevator extends Elevator {
    public EvenFloorElevator(String name, ElevatorState state) {
        super(name);
    }

    @Override
    public boolean canHandle(CallType type) {
        return type == CallType.EVEN_FLOOR;
    }
}
