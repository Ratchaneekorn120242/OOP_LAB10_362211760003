import java.util.List;
import java.util.Scanner;

public class companyManagement {
    public static void main(String[] args) {
        // create instance
        EmployeeDAOImpl dao = EmployeeDAOImpl.getInstance();


        int s = 0;
        do {


            //display options list
            System.out.println("\n############################");
            System.out.println("please, select options below:");
            System.out.println("1.Display all employee data.");
            System.out.println("2.Add new employee.");
            System.out.println("3.Find employee by ID.");
            System.out.println("4.Update employee data.");
            System.out.println("5.Delete employee data");
            System.out.println("6.Exit.");
            Scanner sc = new Scanner(System.in);
            System.out.println("Please, select number (1-6): ");
             s = Integer.parseInt(sc.nextLine());

            switch (s) {
                case 1:
                    displayAllEmp(dao);
                    break;
                case 2:
                    addNewEmp(dao);
                    break;
                case 3:
                    findEmpByID(dao);
                    break;
                case 4:
                    updateEmp(dao);
                    break;
                case 5:
                    deleteEMP(dao);
                    break;
                case 6:
                    System.exit(1);
                default:
                    System.out.println("please, select specific number (1-6)!");
            }
        }while (s!=0);



        //display all employee data
        displayAllEmp(dao);
        //
        //addNewEmp(dao);


        //

        findEmpByID(dao);

        //
        updateEmp(dao);

        //
        deleteEMP(dao);



    }

    private static void deleteEMP(EmployeeDAOImpl dao) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter employee id that you want to delete?");
        String s = sc.nextLine();

        dao.deleteEmp(s);

    }

    private static void updateEmp(EmployeeDAOImpl dao) {
        //search employee data in
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an employee id?: ");
        String id = sc.nextLine();

        Employee emp = dao.findById(id);
        //update
        System.out.println("Employee info: ");
        System.out.println(emp.toString());
        //edit
        System.out.println("Enter new position?:");
        String p = sc.nextLine();
        emp.setPosition(p);

        //
        dao.updateEmp(emp);

    }

    private static Employee findEmpByID(EmployeeDAOImpl dao) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter an employee id:");
        String id = sc.nextLine();


        Employee emp = dao.findById("id");
        if (emp != null) {
            System.out.println(emp.toString());
        }
        return emp;
    }
    private static void addNewEmp(EmployeeDAOImpl dao) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter data for new employee:");
        System.out.println("Employee id:");
        String id = sc.nextLine();
        System.out.println("Employee name");
        String name = sc.nextLine();
        System.out.println("Employee position");
        String position = sc.nextLine();
        System.out.println("Employee email");
        String email = sc.nextLine();
        System.out.println("Employee salary");
        double salary = Double.parseDouble(sc.nextLine());

        Employee myEMP = new Employee(id,name,position,email,salary);
        dao.addEmp(myEMP);

    }

    private static void displayAllEmp(EmployeeDAOImpl dao) {
        List <Employee> emp = dao.getAllEmp();
        System.out.println("Employee Data");
        for (Employee e:emp){
            System.out.println(e.toString());
        }
    }
}
