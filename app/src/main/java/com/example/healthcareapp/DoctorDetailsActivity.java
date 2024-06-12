package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1={
            {"Doctor_Name:Deepthi","Hospital_Address:Bangalore","Phone_num=24362737387","exp:2years","200"},
            {"Doctor_Name:Deeksha","Hospital_Address:Mangalore","Phone_num=2573822487","exp:2years","200"},
            {"Doctor_Name:Diya","Hospital_Address:Pune","Phone_num=29762737387","exp:2years","200"},
            {"Doctor_Name:Shruthi","Hospital_Address:Bangalore","Phone_num=974335387","exp:2years","200"},
            {"Doctor_Name:Shrunga","Hospital_Address:Bangalore","Phone_num=97432387","exp:2years","200"}
    };
    private String[][] doctor_details2={
            {"Doctor_Name:Trupthi","Hospital_Address:Bangalore","Phone_num=24363337387","exp:2years","200"},
            {"Doctor_Name:Dhisha","Hospital_Address:Mangalore","Phone_num=2573822487","exp:2years","200"},
            {"Doctor_Name:Dheeraj","Hospital_Address:Pune","Phone_num=29762744387","exp:2years","200"},
            {"Doctor_Name:Shrunga","Hospital_Address:Bangalore","Phone_num=97432387","exp:2years","200"},
            {"Doctor_Name:Shrunga","Hospital_Address:Bangalore","Phone_num=97432387","exp:2years","200"}
    };
    private String[][] doctor_details3={
            {"Doctor_Name:DeepthiShree","Hospital_Address:Bangalore","Phone_num=24362737387","exp:2years","200"},
            {"Doctor_Name:DeekshaShree","Hospital_Address:Mangalore","Phone_num=2573822487","exp:2years","200"},
            {"Doctor_Name:DiyaShree","Hospital_Address:Pune","Phone_num=29762737387","exp:2years","200"},
            {"Doctor_Name:ShruthiShree","Hospital_Address:Bangalore","Phone_num=974335387","exp:2years","200"},
            {"Doctor_Name:Shrunga","Hospital_Address:Bangalore","Phone_num=97432387","exp:2years","200"}
    };
    private String[][] doctor_details4={
            {"Doctor_Name:Kangana","Hospital_Address:Bangalore","Phone_num=24362737387","exp:2years","200"},
            {"Doctor_Name:Kavya","Hospital_Address:Mangalore","Phone_num=2573822487","exp:2years","200"},
            {"Doctor_Name:Hema","Hospital_Address:Pune","Phone_num=29762737387","exp:2years","200"},
            {"Doctor_Name:Kajal","Hospital_Address:Bangalore","Phone_num=974335387","exp:2years","200"},
            {"Doctor_Name:Shrunga","Hospital_Address:Bangalore","Phone_num=97432387","exp:2years","200"}
    };
    private String[][] doctor_details5={
            {"Doctor_Name:Arun","Hospital_Address:Bangalore","Phone_num=24362737387","exp:2years","200"},
            {"Doctor_Name:Akash","Hospital_Address:Mangalore","Phone_num=2573822487","exp:2years","200"},
            {"Doctor_Name:Arnav","Hospital_Address:Pune","Phone_num=29762737387","exp:2years","200"},
            {"Doctor_Name:Impana","Hospital_Address:Bangalore","Phone_num=974335387","exp:2years","200"},
            {"Doctor_Name:Shrunga","Hospital_Address:Bangalore","Phone_num=97432387","exp:2years","200"}
    };

TextView tv;
Button btn;
String [][] doctor_details={};
ArrayList List;
SimpleAdapter sa;
HashMap<String,String>item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        tv=findViewById(R.id.textViewCartTitle);
        btn=findViewById(R.id.ButtonBack);
        Intent it=getIntent();
        String title=it.getStringExtra("title");
        tv.setText(title);
        if(title.compareTo("Family_Physicians")==0)
        {
            doctor_details=doctor_details1;
        }
        else if(title.compareTo("Dietician")==0)
        {
            doctor_details=doctor_details2;
        }
       else if(title.compareTo("Dentist")==0)
        {
            doctor_details=doctor_details3;
        }
        else if(title.compareTo("Surgeon")==0)
        {
            doctor_details=doctor_details4;
        }
       else
        {
            doctor_details=doctor_details5;
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));

            }
        });
       List =new ArrayList();
       for(int i=0;i<doctor_details.length;i++)
       {
           item=new HashMap<String,String>();
           item.put("line1",doctor_details[i][0]);
           item.put("line2",doctor_details[i][1]);
           item.put("line3",doctor_details[i][2]);
           item.put("line4",doctor_details[i][3]);
           item.put("line5","cons fee:"+doctor_details[i][4]+"/-");
           List.add(item);
       }
       sa=new SimpleAdapter(this,List,R.layout.multi_lines,new String[]{"line1","line2","line3","line4","line5"},new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
       );
        ListView lst= findViewById(R.id.ListViewLT);
        lst.setAdapter(sa);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it =new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}