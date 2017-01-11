package lesson0;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyTraining {
    protected static final File dir = new File("./lesson0/doc.txt");

    public static void main(String[] args) {
        Map<Uuid, Employee> employees = new HashMap<>();
        Employee employee1 = new Employee("Name1", 1000.00);
        Employee employee2 = new Employee("Name2", 2000.00);
        Employee employee3 = new Employee("Name3", 3000.00);
        Employee employee4 = new Employee("Name4", 4000.00);
        Employee employee5 = new Employee("Name5", 5000.00);

        employees.put(Uuid.NUMBER_1, employee1);
        employees.put(Uuid.NUMBER_2, employee2);
        employees.put(Uuid.NUMBER_3, employee3);
        employees.put(Uuid.NUMBER_4, employee4);
        employees.put(Uuid.NUMBER_5, employee5);

//        writeObj(employees);

//        readObject();

        System.out.println(Uuid.NUMBER_1 + " num = " + Uuid.NUMBER_2.ordinal() + "        " + Uuid.NUMBER_5.getNum());


    }

    private static void readObject() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dir))) {
            System.out.println(ois.readObject());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void writeObj(Map<Uuid, Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dir));) {
            oos.writeObject(employees);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

class Employee implements Serializable {
    private String name;
    private double salary;
//    List<String> contacts;

    public Employee() {
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("name='").append(name).append('\'');
        sb.append(", salary=").append(salary);
        sb.append('}');
        return sb.toString();
    }
}

enum Uuid {
    NUMBER_1(1),
    NUMBER_2(2),
    NUMBER_3(3),
    NUMBER_4(4),
    NUMBER_5(5);

    int num;

    Uuid(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}