
import java.util.*;

public class FirstClass {

    public static void main(String[] args) {
        while (true) {
            try {
                Scanner scan = new Scanner(System.in);
                float angleA, angleB;
                double sideA, sideB, sideC;
                int choice;
                System.out.println("\nWhat do you want to solve?");
                System.out.println("1) Side & Side & Side ");
                System.out.println("2) Side & Angle & Side ");
                System.out.println("3) Side & Angle & Angle ");
                System.out.println("4) To exit");
                choice = scan.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Enter three sides:");
                        sideA = scan.nextDouble();
                        sideB = scan.nextDouble();
                        sideC = scan.nextDouble();
                        Triangle triangle1 = new Triangle(sideA, sideB, sideC);
                        System.out.println(triangle1.equals(triangle1));
                        System.out.println("Hash is: " + triangle1.hashCode());
                        System.out.format("sum area is:%.2f\n", triangle1.SumArea());
                        System.out.format("sum scope is: %.2f\n", triangle1.SumScope());
                        System.out.format("sum height is:%.2f\n", triangle1.height());
                        System.out.println("This is: " + triangle1.FindTypeTriangle());
                        break;
                    case 2:
                        System.out.println("Enter side angle side:");
                        sideA = scan.nextDouble();
                        angleA = scan.nextFloat();
                        sideC = scan.nextDouble();
                        Triangle triangle2 = new Triangle(sideA, angleA, sideC);
                        System.out.println("Hash is: " + triangle2.hashCode());
                        System.out.format("sum area is:%.2f\n", triangle2.SumArea());
                        System.out.format("sum scope is:%.2f\n", triangle2.SumScope());
                        System.out.format("sum height is:%.2f\n", triangle2.height());
                        System.out.println("This is" + triangle2.FindTypeTriangle());
                        break;
                    case 3:
                        System.out.println("Enter side angle angle:");
                        sideA = scan.nextDouble();
                        angleA = scan.nextFloat();
                        angleB = scan.nextFloat();
                        Triangle triangle3 = new Triangle(sideA, angleA, angleB);
                        System.out.println("Hash is: " + triangle3.hashCode());
                        System.out.println(triangle3);
                        break;
                    case 4:
                       
                    System.exit(0);
                    default:
                        System.out.println("Enter a valid number!");
                        break;
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

}
