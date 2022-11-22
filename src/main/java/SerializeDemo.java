
import java.io.*;

class Employee implements java.io.Serializable {

    public String name;
    public String address;
    //If a field is not serializable, it must be marked transient.
    public transient int SSN;
    public int number;

    public Employee(String name, String address, int SSN, int number) {
        this.name = name;
        this.address = address;
        this.SSN = SSN;
        this.number = number;
    }

    Employee() {
        
    }

    public void mailCheck() {
        System.out.println("Mailing a check to " + name + " " + address);
    }
}

public class SerializeDemo {

    public static void main(String[] args) {
        String path = "employee.ser";
        Employee employeeBefore = new Employee();
        employeeBefore.name = "Reyan Ali";
        employeeBefore.address = "Phokka Kuan, Ambehta Peer";
        employeeBefore.SSN = 11122333;
        employeeBefore.number = 101;
        serialization(employeeBefore, path);
        Employee employeeAfter = (Employee) deserializing(path);

        System.out.println("Deserialized Employee...");
        System.out.println("Name: " + employeeAfter.name);
        System.out.println("Address: " + employeeAfter.address);
        System.out.println("SSN: " + employeeAfter.SSN);
        System.out.println("Number: " + employeeAfter.number);
        employeeAfter.mailCheck();
         
    }

    public static void serialization(Object object, String path) {
        try {
            FileOutputStream fileOut
                    = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(object);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in " + path);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static Object deserializing(String path) {
        Object object = null;
        try {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            object = (Employee) in.readObject();
            in.close();
            fileIn.close();
            return object;
        } catch (IOException i) {
            System.out.println(i.getMessage());
            return object;
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            System.out.println(c.getMessage());
            return object;
        }

    }
}
