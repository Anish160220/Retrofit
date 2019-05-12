package API_CLient;

import java.util.List;

import model.Employee;
import model.EmployeeCUD;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface EmployeeAPI {

    // get all the employees
    @GET("employees") // api ko url herera base pahi ko get wala ho
    Call<List<Employee>> getAllEmployees(); // Request Call gareko

    // get employee od the basis of id
    @GET("employee/{empID}")
    Call<Employee> getEmployeeByID(@Path("empID") int empId);

    @POST("create")
    Call<Void> registerEmployee(@Body EmployeeCUD emp);
}
