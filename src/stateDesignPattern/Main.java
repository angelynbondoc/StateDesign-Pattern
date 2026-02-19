package stateDesignPattern;

public class Main {

    public static void main(String[] args) {

        VendingMachine machine = new VendingMachine();

        //what the machine has
        machine.addItem("Cola",   1.50);
        machine.addItem("Chips",  1.00);
        machine.addItem("Water",  0.75);

        System.out.println("\nNormal Purchase");
        machine.printStatus();

        machine.insertCoin(1.00);
        //select item
        machine.selectItem("Cola");
        machine.printStatus();
        //selecting another item 
        machine.selectItem("Chips");
        //insert coins
        machine.insertCoin(1.00);
        machine.insertCoin(0.75);
        machine.printStatus();
        //dispense
        machine.dispenseItem();
        machine.printStatus();

        System.out.println("\nInsufficient Balance");
        machine.selectItem("Chips");
        machine.insertCoin(0.50);          
        machine.dispenseItem();            
        machine.insertCoin(0.50);          
        machine.dispenseItem();            
        machine.printStatus();

        System.out.println("\nItem Not Available");
        machine.selectItem("Cola");        
        machine.printStatus();

        System.out.println("\nOut-of-Order State");
        machine.selectItem("Water");
        machine.setOutOfOrder();           //balance should be returned
        machine.printStatus();

        //operations should be blocked
        machine.selectItem("Water");
        machine.insertCoin(1.00);
        machine.dispenseItem();

        //restore the machine
        machine.restoreMachine();
        machine.printStatus();

        //normal operation resumes
        machine.selectItem("Water");
        machine.insertCoin(1.00);
        machine.dispenseItem();
        machine.printStatus();
    }
}