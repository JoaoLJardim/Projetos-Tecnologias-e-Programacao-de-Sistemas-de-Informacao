public class Main {
    public static void main(String[] args) {
        Supervisor supervisor = new Supervisor("Pedro", "123456789",3);
        Employee employee = new Supervisor("Ana", "987654321",5);

        System.out.println(supervisor.toString());
        System.out.println(employee.toString());
    }
}
