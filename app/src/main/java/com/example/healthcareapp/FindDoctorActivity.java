package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FindDoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);
        CardView exit=findViewById(R.id.cardFindDoctorExit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  startActivity(new Intent(FindDoctorActivity.this,HomeActivity.class));
            }
        });
        CardView familyphysician=findViewById(R.id.cardFindDoctorFamilyPhysician);
        familyphysician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=(new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class));
                it.putExtra("title","Family Physician");
                startActivity(it);
            }
        });
        CardView dietician=findViewById(R.id.cardFindDoctorDietician);
        dietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=(new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class));
                it.putExtra("title","Dietician");
                startActivity(it);
            }
        });
        CardView dentist=findViewById(R.id.cardFindDoctorDentist);
        dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=(new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class));
                it.putExtra("title","Dentist");
                startActivity(it);
            }
        });
        CardView surgeon =findViewById(R.id.cardFindDoctorSurgeon);
        surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=(new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class));
                it.putExtra("title","Surgeon");
                startActivity(it);
            }
        });
        CardView cardiologists =findViewById(R.id.cardFindDoctorCardio);
        cardiologists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=(new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class));
                it.putExtra("title","Cardiologists");
                startActivity(it);
            }
        });
    }
}