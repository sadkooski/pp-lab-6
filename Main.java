import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import company.abstracts.Employee;
import company.models.Manager;
import company.models.Worker;

public class Main {
    public static void main(String[] args) {
        Worker worker1 = new Worker("David", 8000, 1, "2022-01-01", "Junior Developer");
        Worker worker2 = new Worker("Mark", 3800, 2, "2023-03-15", "Senior Developer");
        Worker worker3 = new Worker("Bob", 3400, 2, "2020-12-10", "Tester");
        Worker worker4 = new Worker("Rob", 5400, 4, "2020-12-10", "Tester");
        Worker worker5 = new Worker("Harry", 4500, 4, "2020-12-10", "Tester");
        Worker worker6 = new Worker("Tom", 4800, 6, "2020-12-10", "Tester");

        Manager manager1 = new Manager("Michael", 5000, 5, "2019-05-10", "Team Head");
        Manager manager2 = new Manager("John", 6000, 7, "2019-05-10", "Team Lead");

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(worker1);
        employees.add(worker2);
        employees.add(worker3);
        employees.add(worker4);
        employees.add(worker5);
        employees.add(worker6);
        employees.add(manager1);
        employees.add(manager2);

        double totalSalary = 0;
        double totalManagerSalary = 0;
        double totalWorkerSalary = 0;

        for (Employee emp : employees) {
            totalSalary += emp.getSalary();
            if (emp instanceof Manager) {
                totalManagerSalary += emp.getSalary();
            } else if (emp instanceof Worker) {
                totalWorkerSalary += emp.getSalary();
            }
        }

        System.out.println("Całkowita suma pensji wszystkich pracowników: " + totalSalary);
        System.out.println("Całkowita suma pensji wszystkich menedżerów: " + totalManagerSalary);
        System.out.println("Całkowita suma pensji wszystkich pracowników: " + totalWorkerSalary);

        Map<Integer, List<Employee>> idMap = new HashMap<>();
        for (Employee emp : employees) {
            int id = emp.hashCode();
            if (!idMap.containsKey(id)) {
                idMap.put(id, new ArrayList<>());
            }
            idMap.get(id).add(emp);
        }

        for (Map.Entry<Integer, List<Employee>> entry : idMap.entrySet()) {
            int id = entry.getKey();
            List<Employee> employeesWithSameId = entry.getValue();
            if (employeesWithSameId.size() > 1) {
                System.out.println("Obiekty o identyfikatorze " + id + ":");
                for (Employee emp : employeesWithSameId) {
                    System.out.println("- " + emp.getName() + ", stanowisko: " + emp.getPosition());
                }
            }
        }
    }
}