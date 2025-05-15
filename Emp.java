package Striver.customClassJava8;

import java.util.*;
import java.util.stream.Collectors;

public class Emp {
    private int id;
    private String name;
    private String department;
    private double salary;

    // Constructors, getters, setters, toString()

    public Emp(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return id + " - " + name + " - " + department + " - $" + salary;
    }

    public static void main(String[] args) {


        List<Emp> employees = Arrays.asList(
                new Emp(1, "Alice", "HR", 75000),
                new Emp(2, "Bob", "IT", 95000),
                new Emp(3, "Charlie", "Sales", 45000),
                new Emp(4, "David", "HR", 80000),
                new Emp(5, "Eve", "IT", 105000),
                new Emp(6, "Frank", "Sales", 48000),
                new Emp(7, "Grace", "IT", 99000),
                new Emp(8, "Hannah", "Finance", 120000),
                new Emp(9, "Eve", "Finance", 110000)

        );

        // 1) filter employees whose salary greater than 50000

        employees
                .stream()
                .filter(e->e.getSalary()>50000)
                .map(e->e.getName())
                .forEach(System.out::println);

        System.out.println("------------------------------------------------");
        // 2) names of all employees in IT dept

        employees
                .stream()
                .filter(a->a.getDepartment().equals("IT"))
                .map(Emp::getName)
                .forEach(System.out::println);

        System.out.println("------------------------------------------");

        // 3) sort employees by salary

       employees
                .stream()
                .sorted(Comparator.comparingDouble(Emp::getSalary))
               .forEach(e-> System.out.println(e.getName()+"---->"+e.getSalary()));

        //System.out.println(employeesBasedOnSalary);

        System.out.println("---------------------------------------------");
        // 4) no of employees in sales dept

       long employeesInSalesDept= employees
                .stream()
                .filter(e->e.getDepartment().equalsIgnoreCase("sales"))
                .count();

        System.out.println(employeesInSalesDept);

        // 5) List of all employee names
        System.out.println("---------------------------------------------");

        List<String> empName=employees
                .stream()
                //.forEach(e-> System.out.println(e.getName()));
                .map(e->e.getName())
                .collect(Collectors.toList());
        System.out.println(empName);

        System.out.println("---------------------------------------------");

        // 6) Group Employees by Department

        Map <String,List<String>>empBasedOnDept=employees
                .stream()
                .collect(Collectors.groupingBy(e->e.getDepartment(),Collectors.mapping(Emp::getName,Collectors.toList())));

        System.out.println(empBasedOnDept);

        System.out.println("---------------------------------------------");

        // 7) Highest Paid employee

       Optional<Emp>emp= employees
                .stream()
                .max(Comparator.comparingDouble(Emp::getSalary));

       emp.ifPresent(e-> System.out.println(e.getName()));

        System.out.println("---------------------------------------------");


        // 8) Avg salary of all employees

        double avgSalary=employees
                .stream()
                .map(Emp::getSalary)
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0);
        System.out.println(avgSalary);

        // 9) salary greater than 60000

        System.out.println("---------------------------------------------");


        List<String> salaryGreaterThan60000= employees
                .stream()
                .filter(e->e.getSalary()>60000)
                .map(e->e.getName())
                .collect(Collectors.toList());

        System.out.println(salaryGreaterThan60000);

        System.out.println("---------------------------------------------");

        // 10) Dept and employee count
        Map<String,Long>employeeCountInDept=employees
                .stream()
                .collect(Collectors.groupingBy(Emp::getDepartment,Collectors.counting()));

        System.out.println(employeeCountInDept);

        System.out.println("-------------------------------------");

        // 11) Second Highest paid employee

        Optional<Emp>secondHighestPaidEmployee=employees
                .stream()
                .distinct()
                .sorted(Comparator.comparingDouble(Emp::getSalary).reversed())
                .skip(1)
                .findFirst();

        secondHighestPaidEmployee.ifPresent(e-> System.out.println(e.getName()));

        System.out.println("----------------------------------");


        // 12) Employees names  by Length
        Map<Integer,List<String>>nameLength=employees
                .stream()
                .collect(Collectors.groupingBy(e->e.getName().length()
                        ,Collectors.mapping(Emp::getName,Collectors.toList())));

        System.out.println(nameLength);

        // 13) Duplicate employee names
        System.out.println("------------------------------------");
       Map<String,Long>e=employees
               .stream()
               .collect(Collectors.groupingBy(Emp::getName,Collectors.counting()));

        System.out.println(e);

        for(Map.Entry<String,Long>entry:e.entrySet()){
            if(entry.getValue()>1){
                System.out.println(entry.getKey());
            }
        }

        System.out.println("------------------------------------");

        // 14) Highest paid employee in each dept

        Map<String,Optional<Emp>>highestPaidEmployeeInEachDept=employees
                .stream()
                .collect(Collectors.groupingBy(Emp::getDepartment,
                        Collectors.maxBy(Comparator.comparingDouble(Emp::getSalary))));

        highestPaidEmployeeInEachDept.forEach((dept,ea)->
                System.out.println(dept+"->"+ea.map(Emp::getName).orElse("No Employee")));

        System.out.println("----------------------------------------------------");


        // 15) Highest average salary find which dept

        Map<String,Double>avgSalaryDept=employees
                .stream()
                .collect(Collectors.groupingBy(Emp::getDepartment,
                        Collectors.averagingDouble(Emp::getSalary)));

        System.out.println(avgSalaryDept);

        double highestDeptAvg=0;
        String highestDeptNameInAvg="";
        for(Map.Entry<String,Double>entry:avgSalaryDept.entrySet()){
            if(highestDeptAvg<entry.getValue()){
                highestDeptAvg=entry.getValue();
                highestDeptNameInAvg=entry.getKey();
            }
        }
        System.out.println(highestDeptNameInAvg+" with average "+ highestDeptAvg);

        System.out.println("----------------------------------------");
        // 16) Top 3 Earners
        List<String>top3Earners=employees
                .stream()
                .sorted(Comparator.comparingDouble(Emp::getSalary).reversed())
                .limit(3)
                .map(Emp::getName)
                .collect(Collectors.toList());

        System.out.println(top3Earners);
        System.out.println("----------------------------------------");

        // 17) All finance employees have salary greater than 70k
       boolean financeGreaterThan70000= employees
                .stream()
                .filter(eab->eab.getDepartment().equalsIgnoreCase("finance"))
                .allMatch(ea->ea.getSalary()>70000);

        System.out.println(financeGreaterThan70000);
        System.out.println("------------------------------------------------------------");
        // 17) Sort by Dept and then by salary descending

        System.out.println(employees
                .stream()
                .sorted(Comparator.comparing(Emp::getDepartment)
                        .thenComparing(Comparator.comparingDouble(Emp::getSalary).reversed()))
                .collect(Collectors.toList()));



    }
}
