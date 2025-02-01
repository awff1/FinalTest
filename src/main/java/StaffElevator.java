// Лифт для сотрудников
class StaffElevator extends Elevator {
    public StaffElevator(String name) {
        super(name);
    }

    @Override
    public boolean canHandle(CallType type) {
        return type == CallType.STAFF;
    }
}
