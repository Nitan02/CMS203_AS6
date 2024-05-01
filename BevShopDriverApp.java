
public class BevShopDriverApp {
    public static void main(String[] args) {
        int tempAge, tempOrderNo;
        int numOfAlcoholDrinks = 0; // Counter variable for alcohol drinks

        Customer tempCustomer;
        int anInvalidTime = 8, anotherInvalidTime = 24;

        BevShop b = new BevShop();

        if (!b.validTime(anInvalidTime))
            System.out.println("Failed the test for invalid time!!");

        if (b.validTime(anotherInvalidTime))
            System.out.println("Failed the test for invalid time!!");

        System.out.println("The current order in process can have at most " + b.getMaxOrderForAlcohol() + " alcoholic beverages."); // 3
        System.out.println("The minimum age to order alcohol drink is " + b.getMinAgeForAlcohol()); // 21
        System.out.println("Start please a new order:"); // Start a new order
        
        b.startNewOrder(12, Day.MONDAY, "Would you please enter your name John\nWould you please enter your age ", 23);

        Order currentOrder = b.getCurrentOrder();
        if (currentOrder != null) {
            System.out.println("Total on the Order:" + currentOrder.calcOrderTotal()); // 0.0
        } else {
            System.out.println("No current order found!");
        }

        tempCustomer = b.getCurrentOrder().getCustomer();

        tempCustomer.setName("kim");
        tempCustomer.setAge(10);

        System.out.println(b.getCurrentOrder().getCustomer().getName()); // John
        System.out.println(b.getCurrentOrder().getCustomer().getAge()); // 23

        tempAge = b.getCurrentOrder().getCustomer().getAge();
        System.out.println("Your age is above 20 and you are eligible to order alcohol."); // true
        if (b.validAge(tempAge)) {
            System.out.println("Would you please add an alcohol drink"); // Add alcohol drink

            b.processAlcoholOrder("Mohito", Size.SMALL);
            numOfAlcoholDrinks++;
        }

        currentOrder = b.getCurrentOrder();
        if (currentOrder != null) {
            System.out.println("The current order of drinks is " + numOfAlcoholDrinks);
            System.out.println("The Total price on the Order: " + currentOrder.calcOrderTotal()); // 2.0
        } else {
            System.out.println("No current order found!");
        }

        if (numOfAlcoholDrinks < 4) {
            System.out.println("Your current alcohol drink order is less than 4");
        } else {
            System.out.println(b.eligibleForMore());
        } // true

        System.out.println("Would you please add a second alcohol drink"); // Add second alcohol
        // drink
        b.processAlcoholOrder("tonic", Size.LARGE);
        numOfAlcoholDrinks++;
        currentOrder = b.getCurrentOrder();
        if (currentOrder != null) {
            System.out.println("The current order of drinks is " + numOfAlcoholDrinks);
            System.out.println("The Total price on the Order: " + currentOrder.calcOrderTotal()); // 6.0
            System.out.println("Your current alcohol drink order is less than 4");
        } else {
            System.out.println("No current order found!");
        }
        System.out.println(b.getNumOfAlcoholDrink()); // 2

        System.out.println("Add third alcohol drink"); // Add third alcohol
        // drink
        b.processAlcoholOrder("wine", Size.SMALL);
        numOfAlcoholDrinks++;

        currentOrder = b.getCurrentOrder();
        if (currentOrder != null) {
            System.out.println("The current order of drinks is " + numOfAlcoholDrinks);
            System.out.println("The Total price on the Order: " + currentOrder.calcOrderTotal()); // 8.0
        } else {
            System.out.println("No current order found!");
        }

        System.out.println(b.getNumOfAlcoholDrink()); // 3

        System.out.println("You have a maximum alcohol drinks for this order"); // Maximum

        System.out.println("Would you please add a COFFEE to your order:"); // Add a COFFEE to order
        b.processCoffeeOrder("cappuchino", Size.SMALL, true, true);
        System.out.println(b.getNumOfAlcoholDrink()); // 3

        currentOrder = b.getCurrentOrder();
        if (currentOrder != null) {
        	System.out.println(numOfAlcoholDrinks++); 
        	System.out.println("Total items on your order is " + numOfAlcoholDrinks); 
            System.out.println("The Total price on the Order: " + currentOrder.calcOrderTotal()); // 11.0
            System.out.println("#------------------------------------#");
        } else {
            System.out.println("No current order found!");
        }

        tempOrderNo = b.getCurrentOrder().getOrderNo();

        if (b.findOrder(tempOrderNo) != -1) {
            
        } else {
            System.out.println("Order not found! Should not get to here!");
        }

        System.out.println("Would you please start a new order"); // Start a new order
        System.out.println("Would you please enter your name: Ray");
        System.out.println("Would you please enter your age: 18");
        b.startNewOrder(10, Day.SUNDAY, "Mary", 12);

        currentOrder = b.getCurrentOrder();
        if (currentOrder != null) {
            System.out.println("Total on the Order:" + currentOrder.calcOrderTotal()); // 0.0
        } else {
            System.out.println("No current order found!");
        }

        System.out.println("Would you please add a SMOOTHIE to order"); // Add a SMOOTHIE to
        // order
        b.processSmoothieOrder("Morning Boost", Size.LARGE, 2, true);
        currentOrder = b.getCurrentOrder();
        if (currentOrder != null) {
            System.out.println("Total on the Order:" + currentOrder.calcOrderTotal()); // 6.5
        } else {
            System.out.println("No current order found!");
        }

        System.out.println("Would you please add a COFFEE to order");
        b.processCoffeeOrder("Latte", Size.MEDIUM, false, false);
        currentOrder = b.getCurrentOrder();
        if (currentOrder != null) {
            System.out.println("Total on the Order:" + currentOrder.calcOrderTotal()); // 9.5
        } else {
            System.out.println("No current order found!");
        }

        System.out.println(b.getNumOfAlcoholDrink()); // 0
        if (b.validAge(b.getCurrentOrder().getCustomer().getAge())) {
            System.out.println("Should not get to here!!!");
            b.processAlcoholOrder("mohito", Size.MEDIUM);
        } else
            System.out.println("Age not appropriate for alcohol drink!!"); // Age
        // not
        // appropriate
        // for
        // alcohol
        // drink!!

        tempOrderNo = b.getCurrentOrder().getOrderNo();

        if (b.findOrder(tempOrderNo) != -1)
            System.out.println("Total on the Order:" + b.totalOrderPrice(tempOrderNo)); // 9.5
        else {
            System.out.println("Order not found. Should not get to here!!");
        }

        int numOfFruits = 6;
        if (b.isMaxFruit(numOfFruits)) {
            // Maximum number of fruits
            System.out.println(" The total number of fruits is 5 \nYou reached a Maximum number of fruits\n"); // Maximum number
            // of fruits
        }
        numOfFruits = 5;

        b.processSmoothieOrder("Detox", Size.LARGE, numOfFruits, false);
        currentOrder = b.getCurrentOrder();
        if (currentOrder != null) {
            System.out.println("Total price on the second Order: " + currentOrder.calcOrderTotal()); // 16.0
        } else {
            System.out.println("No current order found!");
        }

        System.out.println("Total amount for all orders: " + b.totalMonthlySale()); // 27.0
    }
}