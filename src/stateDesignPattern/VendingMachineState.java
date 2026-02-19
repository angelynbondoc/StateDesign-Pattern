package stateDesignPattern;

public interface VendingMachineState {
    void selectItem(VendingMachine machine, String item);
    void insertCoin(VendingMachine machine, double amount);
    void dispenseItem(VendingMachine machine);
    void setOutOfOrder(VendingMachine machine);
}