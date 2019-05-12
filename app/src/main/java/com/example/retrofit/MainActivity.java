package com.example.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import API_CLient.EmployeeAPI;
import model.Employee;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView tvdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvdata = findViewById(R.id.tvdata);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://dummy.restapiexample.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EmployeeAPI employeeAPI = retrofit.create(EmployeeAPI.class); //Interface call gareko
        Call<List<Employee>> listCall = employeeAPI.getAllEmployees(); //return aako value lai list gareko

        listCall.enqueue(new Callback<List<Employee>>() {
            @Override
            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                List<Employee> employeeList = response.body();

                for(Employee emp : employeeList)
                {
                    String content = "";
                    content += "ID : " + emp.getId() + "\n";
                    content += "Employee Name : " + emp.getEmployee_name() + "\n";
                    content += "Employee Salary : " + emp.getEmployee_salary() + "\n";
                    content += "Employee Age : " + emp.getEmployee_age() + "\n";
                    content += "Employee Image : " + emp.getProfile_image() + "\n";
                    content += "--------------------------------";

                    tvdata.append(content);

                }
            }

            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {
                tvdata.setText("Error " + t.getLocalizedMessage());

            }
        });

    }
}
