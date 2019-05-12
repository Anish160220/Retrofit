package com.example.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import API_CLient.EmployeeAPI;
import model.Employee;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchEmployeeActivity extends AppCompatActivity {
    private final static String BASE_URL = ("http://dummy.restapiexample.com/api/v1/");
    private EditText etEmpNo;
    private TextView tvdata;
    private Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_employee);

        etEmpNo = findViewById(R.id.etEmpID);
        tvdata = findViewById(R.id.tvData);
        btnSearch = findViewById(R.id.btnSearch);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadData();
            }

            private void loadData() {
                Retrofit retrofit =  new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                EmployeeAPI employeeAPI = retrofit.create(EmployeeAPI.class);

                Call<Employee> listCall = employeeAPI.getEmployeeByID(Integer.parseInt(etEmpNo.getText().toString()));

                listCall.enqueue(new Callback<Employee>() {
                    @Override
                    public void onResponse(Call<Employee> call, Response<Employee> response) {
                        Toast.makeText(SearchEmployeeActivity.this,response.body().toString(),Toast.LENGTH_SHORT).show();
                        String content = "";
                        content += "ID : " + response.body().getId() + "\n";
                        content += "Name : " + response.body().getEmployee_name() + "\n";
                        content += "Age : " + response.body().getEmployee_age() + "\n";
                        content += "Salary : " + response.body().getEmployee_salary() + "\n";

                        tvdata.setText(content);


                    }

                    @Override
                    public void onFailure(Call<Employee> call, Throwable t) {
                        Toast.makeText(SearchEmployeeActivity.this,"Error",Toast.LENGTH_SHORT).show();


                    }
                });

            }
        });
    }
}
