package com.scudderapps.e_tracker.Activity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.scudderapps.e_tracker.DATA.EmployeeData;
import com.scudderapps.e_tracker.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterEmployee extends AppCompatActivity {

    private Calendar c;
    private int month, day, year;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM, yyyy");

    private EditText name, code, pass, phone, email;
    private TextView dob;
    private Button save;
    private String eName, ePass, eEmail, eCode, ePhone, eDob;

    private EmployeeData employeeData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_employee);

        employeeData = new EmployeeData();

        name = findViewById(R.id.name);
        dob =  findViewById(R.id.dob);
        code =  findViewById(R.id.ecode);
        pass =  findViewById(R.id.password);
        phone =  findViewById(R.id.phoneNumber);
        email =  findViewById(R.id.email);
        save = findViewById(R.id.save);

        c = Calendar.getInstance();
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        year = c.get(Calendar.YEAR);
        c.set(year, month, day);

        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(RegisterEmployee.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        c.set(year, monthOfYear, dayOfMonth);
                        RegisterEmployee.this.eDob = dateFormat.format(c.getTime());
                        dob.setText(RegisterEmployee.this.eDob);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                eName = name.getText().toString();
                ePass = pass.getText().toString();
                eEmail = email.getText().toString();
                eCode = code.getText().toString();
                ePhone = phone.getText().toString();
                eDob = dob.getText().toString();

                employeeData.setName(eName);
                employeeData.setEmail(eEmail);
                employeeData.setCode(eCode);
                employeeData.setPassword(ePass);
                employeeData.setPhone(ePhone);
                employeeData.setDate(eDob);

                MainActivity.employeeDatabase.employeeDAO().addEmployee(employeeData);

                Toast.makeText(RegisterEmployee.this, "Details Saved", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
