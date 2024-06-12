package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {

    private String packages[][]=
            {
                    {"package1:Full Body Checkup"," "," "," ", "999"},
                    {"package2:Blood Glucose Fasting"," "," "," ", "299"},
                    {"package3:Thyroid checkup"," "," "," ", "299"},
                    {"package4:COVID-19 Antibody"," "," "," ", "399"},
                    {"package5:Immunity checkup"," "," "," ", "699"}
            };
    private String[] package_details = {
            "Blood Glucose Fasting\n" +

                    "Complete Hemogram\n" +
                    "HbA1c\n" +
                    "Iron Studies \n" +
                    "Kidney Function Test\n" +
                    "LDH Lactate Dehydrogenase, Serum\n" +
                    "Lipid Profile\n" +
                    "Liver Function Test",
                    "Blood Glucose Fasting", "COVID-19 Antibody IgG",
                     "Thyroid Profile-Total (T3, T4 & TSH Ultra-sensitive)",
                     "Complete Hemogram\n" +
                    "CRP (C Reactive Protein) Quantitative, Serum\n"+
                     "Iron Studies\n" +
                    "Kidney Function Test\n" +
                    "Vitamin D Total-25 Hydroxy\n" +
                    "Liver Function Testin" +
                    "Lipid Profile"
    };
    HashMap<String,String>item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnGoToCart,btnBack;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);
        btnGoToCart= findViewById(R.id.buttonCartBack);
        btnBack= findViewById(R.id.buttonCheckout);
        listView= findViewById(R.id.ListViewLT);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestActivity.this,HomeActivity.class));
            }
        });
        list=new ArrayList();

        for (int i=0;i<packages.length;i++) {
            item = new HashMap<String, String>();

            item.put("Line1", packages[i][0]);
            item.put("Line2", packages[i][1]);
            item.put("lines", packages[1][2]);
            item.put("line4", packages[1][3]);

            item.put("Line5", "Total Cost:" + packages[1][4] + "/-");
            list.add(item);
        }
            sa = new SimpleAdapter(this, list,R.layout.multi_lines,
                    new String[] {"Line1","Line2", "lines", "lines", "lines" },
               new int[] {R.id.line_a, R.id.line_b, R.id. line_c, R.id.line_d, R.id.line_e});
            listView.setAdapter(sa);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent it=new Intent(LabTestActivity.this,LabTestDetailsActivity.class);
                    it.putExtra("text1",packages[i][0]);
                    it.putExtra("text2",package_details[i]);
                    it.putExtra("text3",packages[i][4]);
                    startActivity(it);
                }
            });
            btnGoToCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(LabTestActivity.this,CartLabActivity.class));
                }
            });
    }
}