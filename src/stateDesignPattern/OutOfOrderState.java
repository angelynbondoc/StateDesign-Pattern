package stateDesignPattern;

public class OutOfOrderState implements VendingMachineState {

    @Override
    public void selectItem(VendingMachine machine, String item) {
        System.out.println("\nMachine is out of order. No operations allowed.");
    }

    @Override
    public void insertCoin(VendingMachine machine, double amount) {
        System.out.println("Machine is out of order. No operations allowed.");
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        System.out.println("Machine is out of order. No operations allowed.");
    }

    @Override
    public void setOutOfOrder(VendingMachine machine) {
        System.out.println("\nMachine is already out of order.");
    }

    public void restoreMachine(VendingMachine machine) {
        machine.setState(new IdleState());
        System.out.println("\nMachine has been restored. Now in Idle state.");
    }

    @Override
    public String toString() {
        return "OutOfOrder";
    }
}