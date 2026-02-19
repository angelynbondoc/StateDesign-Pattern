package stateDesignPattern;

public class IdleState implements VendingMachineState {

    @Override
    public void selectItem(VendingMachine machine, String item) {
        if (!machine.hasItem(item)) {
            System.out.println("\nSorry, \"" + item + "\" is not available.");
            return;
        }
        machine.setSelectedItem(item);
        machine.setState(new ItemSelectedState());
        System.out.println("\nItem \"" + item + "\" selected. Please insert coins.");
    }

    @Override
    public void insertCoin(VendingMachine machine, double amount) {
        System.out.println("\nPlease select an item first before inserting coins.");
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        System.out.println("\nPlease select an item first.");
    }

    @Override
    public void setOutOfOrder(VendingMachine machine) {
        machine.setState(new OutOfOrderState());
        System.out.println("\nMachine is now out of order.");
    }

    @Override
    public String toString() {
        return "Idle";
    }
}