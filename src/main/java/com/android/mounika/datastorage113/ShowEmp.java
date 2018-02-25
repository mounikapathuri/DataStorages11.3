package com.android.mounika.datastorage113;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by mounika on 06/10/2017.
 */

class ShowEmp extends Activity {
    TextView tvName, tvAge;    //Creating references of TextVies.
    ImageView empPhoto;      //Creating references of ImageView.

    @Override
//onCreate method.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_details);    //Setting content view with its Layout.

        //Setting references with its IDs.
        tvName = (TextView) findViewById(R.id.name_tv);
        tvAge = (TextView) findViewById(R.id.age_tv);
        empPhoto = (ImageView) findViewById(R.id.employee_photo);

        //Getting the Intent object which is passed.
        Intent intent = getIntent();

        //Creating reference of DBHelper class.
        DBHelper db = new DBHelper(getApplicationContext());

        //fetching the id of student which is passed in the intent.
        int id = intent.getIntExtra("stud_id", 0);

        //Getting the Student object by its ID using the method of DBHelper class.
        Employee employee = db.getDataByID(id);


        //Setting the Views According to the information in the object.
        tvName.setText("Name : " + employee.nameOfEmployee);
        tvAge.setText("Age : " + employee.ageOfEmployee);
        empPhoto.setImageBitmap(employee.employeePhoto);
    }
}
