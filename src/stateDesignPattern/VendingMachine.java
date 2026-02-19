package stateDesignPattern;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {

    private VendingMachineState currentState;
    private final Map<String, Double> inventory = new HashMap<>();
    private String selectedItem;
    private double balance;

    public VendingMachine() {
        this.currentState = new IdleState();
        this.balance = 0.0;
    }

    public void selectItem(String item) {
        currentState.selectItem(this, item);
    }

    public void insertCoin(double amount) {
        currentState.insertCoin(this, amount);
    }

    public void dispenseItem() {
        currentState.dispenseItem(this);
    }

    public void setOutOfOrder() {
        currentState.setOutOfOrder(this);
    }
    
    public void restoreMachine() {
        if (currentState instanceof OutOfOrderState) {
            ((OutOfOrderState) currentState).restoreMachine(this);
        } else {
            System.out.println("\nMachine is not out of order.");
        }
    }
    
    public void addItem(String name, double price) {
        inventory.put(name, price);
        System.out.println("\nStocked item: \"" + name + "\" at $" + String.format("%.2f", price));
    }

    public boolean hasItem(String name) {
        return inventory.containsKey(name);
    }

    public double getItemPrice(String name) {
        return inventory.getOrDefault(name, 0.0);
    }

    public void removeItem(String name) {
        inventory.remove(name);
    }

    public void addBalance(double amount) {
        this.balance += amount;
    }

    public void deductBalance(double amount) {
        this.balance -= amount;
    }

    public void resetBalance() {
        this.balance = 0.0;
    }

    public double getBalance() {
        return balance;
    }

    public void setState(VendingMachineState state) {
        this.currentState = state;
    }

    public VendingMachineState getState() {
        return currentState;
    }

    public String getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(String item) {
        this.selectedItem = item;
    }

    public void printStatus() {
        System.out.println("State    : " + currentState);
        System.out.println("Selected : " + (selectedItem != null ? selectedItem : "None"));
        System.out.printf ("Balance  : $%.2f%n", balance);
        System.out.println("Inventory: " + inventory);
    }
}