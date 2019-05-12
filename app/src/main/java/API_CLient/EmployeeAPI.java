package API_CLient;

import java.util.List;

import model.Employee;
import retrofit2.Call;
import retrofit2.http.GET;

public interface EmployeeAPI {

@GET("employees") // api ko url herera base pahi ko get wala ho
    Call<List<Employee>> getAllEmployees(); // Request Call gareko
}
