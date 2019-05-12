package com.example.retrofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashboardActivity extends AppCompatActivity {
    private Button btnShowAll, btnRegisterEmployee, btnSearchEmployee, btnUpdateDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        btnShowAll = findViewById(R.id.btnShowAll);
        btnRegisterEmployee = findViewById(R.id.btnRegisterEmployee);
        btnSearchEmployee = findViewById(R.id.btnSearchEmployee);
        btnUpdateDelete = findViewById(R.id.btnUpdateDelete);

        btnSearchEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this,SearchEmployeeActivity.class);
                startActivity(intent);
            }
        });

        btnShowAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btnRegisterEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this,RegisterEmployeeActivity.class);
                startActivity(intent);
            }
        });
    }
}
