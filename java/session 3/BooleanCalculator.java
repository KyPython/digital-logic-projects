import java.util.Scanner;

public class BooleanCalculator {
    // Constants for menu choices
    private static final int AND_OPERATION = 1;
    private static final int OR_OPERATION = 2;
    private static final int NOT_OPERATION = 3;
    private static final int XOR_OPERATION = 4;
    private static final int NAND_OPERATION = 5;
    private static final int NOR_OPERATION = 6;
    private static final int EXIT_PROGRAM = 7;

    // Binary constants
    private static final int BINARY_LOW = 0;
    private static final int BINARY_HIGH = 1;

    private Scanner scanner;
    private boolean isRunning;

    public BooleanCalculator() {
        this.scanner = new Scanner(System.in);
        this.isRunning = true;
    }

    public void run() {
        while (isRunning) {
            displayMenu();
            int userChoice = getUserChoice();
            processUserChoice(userChoice);
        }
        scanner.close();
    }

    private void displayMenu() {
        System.out.println("\n=== BOOLEAN LOGIC CALCULATOR ===");
        System.out.println("1. AND Operation");
        System.out.println("2. OR Operation");
        System.out.println("3. NOT Operation");
        System.out.println("4. XOR Operation");
        System.out.println("5. NAND Operation");
        System.out.println("6. NOR Operation");
        System.out.println("7. Exit Program");
        System.out.print("Select operation: ");
    }

    private int getUserChoice() {
        return scanner.nextInt();
    }

    private void processUserChoice(int choice) {
        switch (choice) {
            case AND_OPERATION:
                performAndOperation();
                break;
            case OR_OPERATION:
                performOrOperation();
                break;
            case NOT_OPERATION:
                performNotOperation();
                break;
            case XOR_OPERATION:
                performXorOperation();
                break;
            case NAND_OPERATION:
                performNandOperation();
                break;
            case NOR_OPERATION:
                performNorOperation();
                break;
            case EXIT_PROGRAM:
                exitProgram();
                break;
            default:
                displayInvalidChoiceMessage();
                break;
        }
    }

    private int readBinaryInput(String inputName) {
        System.out.print(inputName + " (0 or 1): ");
        return scanner.nextInt();
    }

    private void displayResult(String operation, int result) {
        System.out.println("Result: " + result);
    }

    private void displayTwoInputResult(int inputA, int inputB, String operation, int result) {
        System.out.println(inputA + " " + operation + " " + inputB + " = " + result);
    }

    private void displaySingleInputResult(int input, String operation, int result) {
        System.out.println(operation + " " + input + " = " + result);
    }

    // Boolean Logic Operations
    private int computeAnd(int inputA, int inputB) {
        return (inputA == BINARY_HIGH && inputB == BINARY_HIGH) ? BINARY_HIGH : BINARY_LOW;
    }

    private int computeOr(int inputA, int inputB) {
        return (inputA == BINARY_HIGH || inputB == BINARY_HIGH) ? BINARY_HIGH : BINARY_LOW;
    }

    private int computeNot(int input) {
        return (input == BINARY_LOW) ? BINARY_HIGH : BINARY_LOW;
    }

    private int computeXor(int inputA, int inputB) {
        return (inputA != inputB) ? BINARY_HIGH : BINARY_LOW;
    }

    private int computeNand(int inputA, int inputB) {
        return computeNot(computeAnd(inputA, inputB));
    }

    private int computeNor(int inputA, int inputB) {
        return computeNot(computeOr(inputA, inputB));
    }

    // Operation handlers
    private void performAndOperation() {
        int inputA = readBinaryInput("Input A");
        int inputB = readBinaryInput("Input B");
        int result = computeAnd(inputA, inputB);
        displayResult("AND", result);
        displayTwoInputResult(inputA, inputB, "AND", result);
    }

    private void performOrOperation() {
        int inputA = readBinaryInput("Input A");
        int inputB = readBinaryInput("Input B");
        int result = computeOr(inputA, inputB);
        displayResult("OR", result);
        displayTwoInputResult(inputA, inputB, "OR", result);
    }

    private void performNotOperation() {
        int input = readBinaryInput("Input");
        int result = computeNot(input);
        displayResult("NOT", result);
        displaySingleInputResult(input, "NOT", result);
    }

    private void performXorOperation() {
        int inputA = readBinaryInput("Input A");
        int inputB = readBinaryInput("Input B");
        int result = computeXor(inputA, inputB);
        displayResult("XOR", result);
        displayTwoInputResult(inputA, inputB, "XOR", result);
    }

    private void performNandOperation() {
        int inputA = readBinaryInput("Input A");
        int inputB = readBinaryInput("Input B");
        int result = computeNand(inputA, inputB);
        displayResult("NAND", result);
        displayTwoInputResult(inputA, inputB, "NAND", result);
    }

    private void performNorOperation() {
        int inputA = readBinaryInput("Input A");
        int inputB = readBinaryInput("Input B");
        int result = computeNor(inputA, inputB);
        displayResult("NOR", result);
        displayTwoInputResult(inputA, inputB, "NOR", result);
    }

    private void exitProgram() {
        System.out.println("Thank you for using Boolean Logic Calculator. Goodbye!");
        isRunning = false;
    }

    private void displayInvalidChoiceMessage() {
        System.out.println("Invalid choice. Please select a valid operation (1-7).");
    }

    public static void main(String[] args) {
        BooleanCalculator calculator = new BooleanCalculator();
        calculator.run();
    }
}