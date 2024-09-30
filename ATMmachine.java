import java.util.Scanner;

class User {
    private String name;
    private int pin;
    private double balance;

    public User(String name, int pin, double initialBalance) {
        this.name = name;
        this.pin = pin;
        this.balance = initialBalance;
    }

    public boolean validatePin(int enteredPin) {
        return this.pin == enteredPin;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrawn: $" + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }
}

class ATMmachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a User with default balance of 1000
        User user = new User("John", 1234, 1000);

        System.out.println("Welcome to the ATM");

        // Authenticate User
        System.out.print("Please enter your PIN: ");
        int enteredPin = scanner.nextInt();

        if (user.validatePin(enteredPin)) {
            boolean exit = false;

            while (!exit) {
                // Display ATM menu
                System.out.println("\nATM Menu:");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Exit");

                System.out.print("Select an option: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Your balance is: $" + user.getBalance());
                        break;
                    case 2:
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        user.deposit(depositAmount);
                        break;
                    case 3:
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = scanner.nextDouble();
                        user.withdraw(withdrawAmount);
                        break;
                    case 4:
                        exit = true;
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        } else {
            System.out.println("Invalid PIN. Access denied.");
        }

        scanner.close();
    }
}
