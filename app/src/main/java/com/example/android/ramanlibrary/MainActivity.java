package com.example.android.ramanlibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        LibDatabaseHandler db = new LibDatabaseHandler(this);

        add = (Button) findViewById(R.id.addButton); //get ID of buttons
        find = (Button) findViewById(R.id.findButton);
        checkIn = (Button) findViewById(R.id.checkInButton);
        checkOut = (Button) findViewById(R.id.checkOutButton);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddActivity.class));
            }
        });

    }
}
