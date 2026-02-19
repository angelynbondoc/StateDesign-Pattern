package stateDesignPattern;

public class ItemSelectedState implements VendingMachineState {

    @Override
    public void selectItem(VendingMachine machine, String item) {
        System.out.println("\nItem \"" + machine.getSelectedItem()
                + "\" is already selected. Please insert coins or dispense.");
    }

    @Override
    public void insertCoin(VendingMachine machine, double amount) {
        if (amount <= 0) {
            System.out.println("\nInvalid coin amount.");
            return;
        }
        machine.addBalance(amount);
        System.out.printf("Coin inserted: $%.2f | Balance: $%.2f%n",
                amount, machine.getBalance());
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        String item = machine.getSelectedItem();
        double price = machine.getItemPrice(item);

        if (machine.getBalance() < price) {
            System.out.printf("\nInsufficient balance. Need $%.2f, have $%.2f.%n",
                    price, machine.getBalance());
            return;
        }

        //deduct cost and transition to dispensing
        machine.deductBalance(price);
        machine.setState(new DispensingState());
        machine.dispenseItem(); //triggers the dispensing logic
    }

    @Override
    public void setOutOfOrder(VendingMachine machine) {
        machine.setState(new OutOfOrderState());
        System.out.println("\nMachine is now out of order. Returning balance: $"
                + String.format("%.2f", machine.getBalance()));
        machine.resetBalance();
        machine.setSelectedItem(null);
    }

    @Override
    public String toString() {
        return "ItemSelected";
    }
}