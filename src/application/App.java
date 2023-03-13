package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        System.out.print("How many employees will be registered? ");
        int n = sc.nextInt();

        List<Employee> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("Employee #" + (i + 1));
            System.out.print("Id: ");
            int id = sc.nextInt();

            while (hasId(list, id)) {
                System.out.print("Id already taken. Try again: ");
                id = sc.nextInt();
            }

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Salary: ");
            double salary = sc.nextDouble();

            Employee emp = new Employee(id, name, salary);
            list.add(emp);
            // OU
            // list.add(new Employee(id, name, salary));
        }

        System.out.println("Enter the employee id that will have salary increase: ");
        int id = sc.nextInt();
        Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);

        /*
         * OUTRA FORMA
         * 
         * Integer pos = position(list, id); //position é uma função auxiliar no fim do
         * cod.
         * if(pos == null){
         * System.out.println("This id does not exist!")
         * } else{
         * System.out.print("Enter the percentage: ");
         * double percentage = sc.nextDouble();
         * list.get(pos).increaseSalary(percent)
         * }
         * 
         */

        if (emp == null) {

            System.out.println("This id does not exist!");

        } else {
            System.out.print("Enter the percentage: ");
            double percentage = sc.nextDouble();
            emp.increaseSalary(percentage);
        }

        System.out.println("List of employees: ");
        for (Employee employee : list) {
            System.out.println(employee);

        }
        sc.close();
    }

    /*
     * FUNCAO AUXILIAR IRA RECEBER UMA LISTA E UM ID E PROCURAR NA LISTA O ID
     * INSERIDO PELO USUARIO
     * SE ACHAR VAI RETORNAR SE ACHOU OU NAO VALIDANDO O ID PARA NAO REPETIR
     */
    public static boolean hasId(List<Employee> list, int id) {
        Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return emp != null;
    }

    /*
     * OUTRA FORMA DE PROCURAR O ID NA LISTA PARA MODIFICAR O SALARIO
     * 
     * public static Integer position(List<Employee> list, int id){
     * for(int i = 0; i < list.size(); i++){
     * if(list.get(i).getId() == id){
     * return i;
     * }
     * }
     * return null;
     * }
     */
}
