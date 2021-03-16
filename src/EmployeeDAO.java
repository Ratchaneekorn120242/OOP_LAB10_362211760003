import java.util.List;

public interface EmployeeDAO {

    //CRUD operations
    public List<Employee> getAllEmp();
    public void addEmp (Employee emp);
    public Employee findById(String id);
    public  void  updateEmp(Employee employee);
    public  void deletEmp (String id);
}
