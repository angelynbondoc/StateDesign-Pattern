package stateDesignPattern;

public class DispensingState implements VendingMachineState {

    @Override
    public void selectItem(VendingMachine machine, String item) {
        System.out.println("\nPlease wait — dispensing in progress.");
    }

    @Override
    public void insertCoin(VendingMachine machine, double amount) {
        System.out.println("\nPlease wait — dispensing in progress.");
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        String item = machine.getSelectedItem();
        System.out.println("\nDispensing \"" + item + "\"... Please collect your item.");

        //remove item from inventory
        machine.removeItem(item);
        machine.setSelectedItem(null);

        //return change
        double change = machine.getBalance();
        if (change > 0) {
            System.out.printf("\nReturning change: $%.2f%n", change);
            machine.resetBalance();
        }

        //automatically transition back to Idle
        machine.setState(new IdleState());
        System.out.println("\nDispensing complete. Returning to Idle state.");
    }

    @Override
    public void setOutOfOrder(VendingMachine machine) {
        System.out.println("Cannot set out of order while dispensing.");
    }

    @Override
    public String toString() {
        return "Dispensing";
    }
}