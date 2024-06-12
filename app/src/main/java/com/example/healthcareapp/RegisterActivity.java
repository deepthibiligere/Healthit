package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        EditText edUsername,edMail,edPassword,edConfirmPassword;
        TextView tv;
        Button btn;
        edUsername =findViewById(R.id.editTextRegUsername);
        edPassword=findViewById(R.id.editTextAppContactNumber);
        edMail=findViewById(R.id.editTextAppAddress);
        edConfirmPassword=findViewById(R.id.editTextAppFees);
        tv =findViewById(R.id.textViewExistingUser);
        btn =findViewById(R.id.buttonAppBack);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,RegisterActivity.class));
            }
        });
       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String username=edUsername.getText().toString();
               String email=edMail.getText().toString();
               String password=edPassword.getText().toString();
               Database db=new Database(getApplicationContext(),"healthcare",null,1);
               String confirm_password=edConfirmPassword.getText().toString();

               if(username.length()==0||password.length()==0||confirm_password.length()==0)
               {
                   Toast.makeText(getApplicationContext(),"Please fill the details",Toast.LENGTH_SHORT).show();
               }
               else
               {
                   if(password.compareTo(confirm_password)==0){
                        if(isvalid(password))
                        {
                            db.Register(username,email,password);

                            Toast.makeText(getApplicationContext(),"Record inserted!",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this, loginActivity.class));
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Password must contain 8 characters,digits and letters!",Toast.LENGTH_SHORT).show();
                        }
                   }
                   else {
                       Toast.makeText(getApplicationContext(),"Password and confirm password did not match!",Toast.LENGTH_SHORT).show();
                   }
               }

           }
       });

    }
    public static boolean isvalid(String passwordhere) {
        int f1 = 0, f2 = 0, f3 = 0;
        if (passwordhere.length() < 8) {
            return false;
        } else {
            for (int p = 0; p < passwordhere.length(); p++) {
                if (Character.isLetter(passwordhere.charAt(p))) {
                    f1 = 1;
                }
            }
            for (int r = 0; r < passwordhere.length(); r++) {
                if (Character.isDigit(passwordhere.charAt(r))) {
                    f2 = 1;
                }
            }
            for (int s = 0; s < passwordhere.length(); s++) {
                char c=passwordhere.charAt(s);
                if(c>=33&&c<=46||c==64) {
                    f3 = 1;
                }
            }
            if (f1 == 1 && f2 == 1 && f3 == 1)
                return true;
            return false;
        }
    }
}