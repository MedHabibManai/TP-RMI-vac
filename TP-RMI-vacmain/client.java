import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Calculator calc = (Calculator) registry.lookup("CalculatorService");
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Enter operation code (1. Add, 2. Subtract, 3. Multiply, 4. Divide):");
                int c = scanner.nextInt();
                System.out.println("Enter first operand:");
                double o1 = scanner.nextDouble();
                System.out.println("Enter second operand:");
                double o2 = scanner.nextDouble();
                double r;
                switch (c) {
                    case 1:
                        r = calc.add(o1, o2);
                        break;
                    case 2:
                        r = calc.subtract(o1, o2);
                        break;
                    case 3:
                        r = calc.multiply(o1, o2);
                        break;
                    case 4:
                        r = calc.divide(o1, o2);
                        break;
                    default:
                        System.out.println("Invalid operation code.");
                        continue;
                }
                System.out.println("Result: " + r);
                System.out.println("Do you want to continue? (y/n)");
                String cont = scanner.next();
                if (!cont.equalsIgnoreCase("y")) {
                    break;
                }
            }
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
