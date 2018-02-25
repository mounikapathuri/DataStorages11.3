package com.android.mounika.datastorage113;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public EditText nameET, ageET;    //Creating references of EditTexts.
    public Button showData;       //Creating reference of Button.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Setting references to its IDs.
        nameET = (EditText) findViewById(R.id.name_et);
        ageET = (EditText) findViewById(R.id.age_et);
        showData = (Button) findViewById(R.id.show_btn);

        //Creating anonymous class declaration for the onClick event for button.
        showData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating reference of DBHelper.
                DBHelper db = new DBHelper(getApplicationContext());

                //Creating object of Student.
                Employee employee = new Employee();

                //Initializing values of object.
                employee.nameOfEmployee = nameET.getText().toString();
                employee.ageOfEmployee = ageET.getText().toString();
                employee.employeePhoto = BitmapFactory.decodeResource(getResources(), R.drawable.acadgild);

                //Adding the Object data into database.
                int id = db.addData(employee);

                //Creating intent to switch to another Activity.
                Intent intent = new Intent(MainActivity.this, ShowEmp.class);
                //Putting student ID in the intent.
                intent.putExtra("stud_id", id);
                //Starting Activity.
                startActivity(intent);
            }
        });

    }
}
