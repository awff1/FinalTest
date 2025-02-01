// Лифт для нечетных этажей
class OddFloorElevator extends Elevator {
    public OddFloorElevator(String name, ElevatorState state) {
        super(name);
    }

    @Override
    public boolean canHandle(CallType type) {
        return type == CallType.ODD_FLOOR;
    }
}
