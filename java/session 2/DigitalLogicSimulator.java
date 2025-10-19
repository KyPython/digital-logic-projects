// Base class for all logic gates
abstract class LogicGate {
    protected String gateName;

    public LogicGate(String gateName) {
        this.gateName = gateName;
    }

    public String getGateName() {
        return gateName;
    }

    public abstract void displayTruthTable();
}

// Two-input gates
abstract class TwoInputGate extends LogicGate {
    public TwoInputGate(String gateName) {
        super(gateName);
    }

    public abstract int compute(int inputA, int inputB);

    @Override
    public void displayTruthTable() {
        System.out.println("\n=== " + gateName + " Truth Table ===");
        System.out.println("A | B | Output");
        System.out.println("--|---|-------");
        for (int a = 0; a <= 1; a++) {
            for (int b = 0; b <= 1; b++) {
                System.out.println(a + " | " + b + " |   " + compute(a, b));
            }
        }
    }
}

// Single-input gate
abstract class SingleInputGate extends LogicGate {
    public SingleInputGate(String gateName) {
        super(gateName);
    }

    public abstract int compute(int input);

    @Override
    public void displayTruthTable() {
        System.out.println("\n=== " + gateName + " Truth Table ===");
        System.out.println("Input | Output");
        System.out.println("------|-------");
        for (int a = 0; a <= 1; a++) {
            System.out.println("  " + a + "   |   " + compute(a));
        }
    }
}

// AND Gate: Output is 1 only when both inputs are 1
class AndGate extends TwoInputGate {
    public AndGate() {
        super("AND");
    }

    @Override
    public int compute(int inputA, int inputB) {
        return (inputA == 1 && inputB == 1) ? 1 : 0;
    }
}

// OR Gate: Output is 1 when at least one input is 1
class OrGate extends TwoInputGate {
    public OrGate() {
        super("OR");
    }

    @Override
    public int compute(int inputA, int inputB) {
        return (inputA == 1 || inputB == 1) ? 1 : 0;
    }
}

// NOT Gate: Output is the inverse of input
class NotGate extends SingleInputGate {
    public NotGate() {
        super("NOT");
    }

    @Override
    public int compute(int input) {
        return (input == 0) ? 1 : 0;
    }
}

// XOR Gate: Output is 1 when inputs are different
class XorGate extends TwoInputGate {
    public XorGate() {
        super("XOR");
    }

    @Override
    public int compute(int inputA, int inputB) {
        return (inputA != inputB) ? 1 : 0;
    }
}

// NAND Gate: NOT(AND) - Output is 0 only when both inputs are 1
class NandGate extends TwoInputGate {
    public NandGate() {
        super("NAND");
    }

    @Override
    public int compute(int inputA, int inputB) {
        return (inputA == 1 && inputB == 1) ? 0 : 1;
    }
}

// NOR Gate: NOT(OR) - Output is 1 only when both inputs are 0
class NorGate extends TwoInputGate {
    public NorGate() {
        super("NOR");
    }

    @Override
    public int compute(int inputA, int inputB) {
        return (inputA == 0 && inputB == 0) ? 1 : 0;
    }
}

// Main program to demonstrate the gates
public class DigitalLogicSimulator {
    public static void main(String[] args) {
        // Create instances of each gate
        AndGate andGate = new AndGate();
        OrGate orGate = new OrGate();
        NotGate notGate = new NotGate();
        XorGate xorGate = new XorGate();
        NandGate nandGate = new NandGate();
        NorGate norGate = new NorGate();

        // Display all truth tables
        andGate.displayTruthTable();
        orGate.displayTruthTable();
        notGate.displayTruthTable();
        xorGate.displayTruthTable();
        nandGate.displayTruthTable();
        norGate.displayTruthTable();

        // Demonstrate individual computations
        System.out.println("\n=== Individual Gate Computations ===");
        System.out.println("AND(1, 1) = " + andGate.compute(1, 1));
        System.out.println("OR(0, 1) = " + orGate.compute(0, 1));
        System.out.println("NOT(1) = " + notGate.compute(1));
        System.out.println("XOR(1, 1) = " + xorGate.compute(1, 1));
        System.out.println("NAND(1, 1) = " + nandGate.compute(1, 1));
        System.out.println("NOR(0, 0) = " + norGate.compute(0, 0));

        // Demonstrate combining gates (like real circuits)
        System.out.println("\n=== Combined Circuit Example ===");
        System.out.println("Computing: NOT(AND(1, 1)) using separate gates");
        int andResult = andGate.compute(1, 1);
        System.out.println("Step 1 - AND(1, 1) = " + andResult);
        int finalResult = notGate.compute(andResult);
        System.out.println("Step 2 - NOT(" + andResult + ") = " + finalResult);
        System.out.println("This is equivalent to NAND(1, 1) = " + nandGate.compute(1, 1));
    }
}