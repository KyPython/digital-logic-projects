import numpy as np

# ==========================================
# PART 1: Boolean Logic Gates with NumPy
# ==========================================

def logical_and_gate(input_a, input_b):
    """
    Compute AND operation using NumPy.
    Returns 1 only when both inputs are 1.
    """
    return np.logical_and(input_a, input_b).astype(int)

def logical_or_gate(input_a, input_b):
    """
    Compute OR operation using NumPy.
    Returns 1 when at least one input is 1.
    """
    return np.logical_or(input_a, input_b).astype(int)

def logical_not_gate(input_signal):
    """
    Compute NOT operation using NumPy.
    Returns the inverse of the input.
    """
    return np.logical_not(input_signal).astype(int)

def logical_xor_gate(input_a, input_b):
    """
    Compute XOR operation using NumPy.
    Returns 1 when inputs are different.
    """
    return np.logical_xor(input_a, input_b).astype(int)

def display_truth_table(gate_function, gate_name, num_inputs=2):
    """
    Display truth table for any logic gate.
    """
    print(f"\n{'='*40}")
    print(f"{gate_name} Gate Truth Table")
    print(f"{'='*40}")

    if num_inputs == 2:
        print("A | B | Output")
        print("--|---|-------")
        for a in [0, 1]:
            for b in [0, 1]:
                result = gate_function(a, b)
                print(f"{a} | {b} |   {result}")
    else:
        print("A | Output")
        print("--|-------")
        for a in [0, 1]:
            result = gate_function(a)
            print(f"{a} |   {result}")

# ==========================================
# PART 2: Boolean Logic in Decision Trees
# ==========================================

class SimpleDecisionTreeNode:
    """
    A decision tree node that uses Boolean logic.
    This demonstrates how ML decision trees are built on Boolean operations.
    """

    def __init__(self, feature_name, threshold=None, operation='>=', prediction=None):
        self.feature_name = feature_name
        self.threshold = threshold
        self.operation = operation
        self.true_branch = None
        self.false_branch = None
        self.prediction = prediction

    def evaluate_condition(self, feature_value):
        """
        Evaluate a Boolean condition (like a logic gate).
        Returns True or False based on the condition.
        """
        if self.operation == '>=':
            return feature_value >= self.threshold
        elif self.operation == '>':
            return feature_value > self.threshold
        elif self.operation == '==':
            return feature_value == self.threshold
        else:
            return False

    def predict(self, features):
        """
        Make a prediction by traversing the tree.
        This is essentially a series of Boolean operations.
        """
        if self.prediction is not None:
            return self.prediction

        feature_value = features.get(self.feature_name)
        condition_result = self.evaluate_condition(feature_value)

        # Boolean decision: go left (True) or right (False)
        if condition_result:
            return self.true_branch.predict(features) if self.true_branch else None
        else:
            return self.false_branch.predict(features) if self.false_branch else None

def demonstrate_decision_tree_boolean_logic():
    """
    Show how decision trees use Boolean logic internally.
    Example: Predicting if someone should go outside based on weather.
    """
    print("\n" + "="*60)
    print("Decision Tree: Should I Go Outside?")
    print("="*60)

    # Build a simple decision tree
    # Root: Is it sunny? (temperature >= 60)
    root = SimpleDecisionTreeNode("temperature", threshold=60, operation='>=')

    # True branch: Is it too hot? (temperature >= 85)
    hot_check = SimpleDecisionTreeNode("temperature", threshold=85, operation='>=')
    hot_check.true_branch = SimpleDecisionTreeNode("", prediction="Stay inside - too hot!")
    hot_check.false_branch = SimpleDecisionTreeNode("", prediction="Go outside - nice weather!")

    # False branch: Is it raining?
    rain_check = SimpleDecisionTreeNode("is_raining", threshold=1, operation='==')
    rain_check.true_branch = SimpleDecisionTreeNode("", prediction="Stay inside - it's raining!")
    rain_check.false_branch = SimpleDecisionTreeNode("", prediction="Go outside - not too cold!")

    root.true_branch = hot_check
    root.false_branch = rain_check

    # Test cases
    test_cases = [
        {"temperature": 75, "is_raining": 0, "description": "Nice sunny day"},
        {"temperature": 95, "is_raining": 0, "description": "Very hot day"},
        {"temperature": 50, "is_raining": 1, "description": "Cold and rainy"},
        {"temperature": 50, "is_raining": 0, "description": "Cold but dry"},
    ]

    print("\nTest Cases:")
    print("-" * 60)
    for case in test_cases:
        prediction = root.predict(case)
        print(f"\n{case['description']}:")
        print(f"  Temperature: {case['temperature']}°F, Raining: {case['is_raining']}")
        print(f"  Decision: {prediction}")

# ==========================================
# PART 3: XOR Problem in Neural Networks
# ==========================================

def demonstrate_xor_problem():
    """
    The XOR problem: Why neural networks need hidden layers.
    XOR cannot be solved with a single layer (single Boolean operation).
    """
    print("\n" + "="*60)
    print("The XOR Problem: Why Neural Networks Need Multiple Layers")
    print("="*60)

    # XOR inputs and outputs
    inputs = np.array([[0, 0], [0, 1], [1, 0], [1, 1]])
    xor_outputs = np.array([0, 1, 1, 0])

    print("\nXOR Truth Table:")
    print("A | B | XOR")
    print("--|---|----")
    for i, (inp, out) in enumerate(zip(inputs, xor_outputs)):
        print(f"{inp[0]} | {inp[1]} |  {out}")

    print("\nWhy XOR is special for ML:")
    print("- Cannot be solved with a single linear decision boundary")
    print("- Requires at least 2 layers (hidden layer + output layer)")
    print("- This is why 'deep' learning exists!")

    print("\nSolution: Combine multiple Boolean operations")
    print("XOR(A, B) = (A AND NOT-B) OR (NOT-A AND B)")
    print("           = (A OR B) AND NOT(A AND B)")

    # Demonstrate the decomposition
    print("\nBreaking down XOR into simpler gates:")
    print("A | B | A OR B | A AND B | NOT(A AND B) | XOR")
    print("--|---|--------|---------|--------------|----")
    for inp in inputs:
        a, b = inp[0], inp[1]
        or_result = logical_or_gate(a, b)
        and_result = logical_and_gate(a, b)
        nand_result = logical_not_gate(and_result)
        xor_result = logical_xor_gate(a, b)
        print(f"{a} | {b} |   {or_result}    |    {and_result}    |      {nand_result}       |  {xor_result}")

# ==========================================
# PART 4: Vectorized Operations (ML-style)
# ==========================================

def demonstrate_vectorized_boolean_operations():
    """
    Show how Boolean operations work on entire datasets at once.
    This is how ML libraries process data efficiently.
    """
    print("\n" + "="*60)
    print("Vectorized Boolean Operations (ML-Style)")
    print("="*60)

    # Create sample data (like a mini dataset)
    dataset_a = np.array([0, 0, 1, 1, 0, 1])
    dataset_b = np.array([0, 1, 0, 1, 1, 1])

    print("\nDataset:")
    print(f"Feature A: {dataset_a}")
    print(f"Feature B: {dataset_b}")

    # Perform Boolean operations on entire arrays at once
    and_results = logical_and_gate(dataset_a, dataset_b)
    or_results = logical_or_gate(dataset_a, dataset_b)
    xor_results = logical_xor_gate(dataset_a, dataset_b)

    print("\nVectorized Results:")
    print(f"AND:       {and_results}")
    print(f"OR:        {or_results}")
    print(f"XOR:       {xor_results}")

    print("\nThis is how ML processes thousands of examples at once!")

# ==========================================
# MAIN PROGRAM
# ==========================================

def main():
    print("\n" + "="*60)
    print("BOOLEAN LOGIC IN MACHINE LEARNING")
    print("="*60)

    # Part 1: Show truth tables
    display_truth_table(logical_and_gate, "AND")
    display_truth_table(logical_or_gate, "OR")
    display_truth_table(logical_not_gate, "NOT", num_inputs=1)
    display_truth_table(logical_xor_gate, "XOR")

    # Part 2: Decision trees use Boolean logic
    demonstrate_decision_tree_boolean_logic()

    # Part 3: XOR problem
    demonstrate_xor_problem()

    # Part 4: Vectorized operations
    demonstrate_vectorized_boolean_operations()

    print("\n" + "="*60)
    print("KEY TAKEAWAYS:")
    print("="*60)
    print("1. Decision trees = chains of Boolean operations")
    print("2. Neural networks = complex combinations of Boolean logic")
    print("3. XOR shows why we need multiple layers (deep learning)")
    print("4. Vectorization = applying Boolean ops to entire datasets")
    print("5. Your digital logic skills directly apply to ML!")
    print("="*60 + "\n")

if __name__ == "__main__":
    main()

