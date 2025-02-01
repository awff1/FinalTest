// Интерфейс вызова лифта
interface CallInterface {
    Elevator requestElevator(CallType type, int floor) throws Exception;
}
