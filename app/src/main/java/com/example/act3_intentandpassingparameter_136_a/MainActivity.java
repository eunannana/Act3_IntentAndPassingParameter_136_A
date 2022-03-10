package com.example.act3_intentandpassingparameter_136_a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // declare variable for button
    Button buttonLogin;

    // declare variable for EditText
    EditText ed_email, ed_password;

    // declare variable to save email and password
    String name, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // connect button_Login variable with button component on Layout
        buttonLogin=findViewById(R.id.btSignIn);

        // connect ed_Email variable with button component on Layout
        ed_email=findViewById(R.id.edEmail);

        // connect ed_Password variable with button component on Layout
        ed_password=findViewById(R.id.edPassword);

        // make function onclick on button_Login button
        buttonLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                validate();
            }
        });
    }
    public void validate() {
        name = ed_email.getText().toString();
        password = ed_password.getText().toString();

        // set the right email
        String email = "eunannana@gmail.com";

        // set the right password
        String pass = "thisisann";

        if (name.isEmpty() && password.isEmpty()) {
            ed_email.setError("e-mail is required!");
            ed_password.setError("password is required!");
        } else {
            if (name.equals(email) && password.equals(pass)) {
                Toast t = Toast.makeText(getApplicationContext(),
                        "Successful Login! Your e-mail : " + name + " and Your password : " + password + "", Toast.LENGTH_LONG);
                t.show();

                Bundle b = new Bundle();

                // input value from variable name with key "a" and input to the bundle
                b.putString("a", name.trim());

                //input value from variable password with key "b" and input to the bundle
                b.putString("b", password.trim());

                // make intent object move activity from mainactivity to result activity
                Intent i = new Intent(getApplicationContext(), ResultActivity.class);

                // input bundle into intent that want to send to ResultActivity
                i.putExtras(b);

                // move to ResultActivity
                startActivity(i);

            } else if (!name.equals(email) && password.equals(pass)) {
                Toast t = Toast.makeText(getApplicationContext(),
                        "Input the correct e-mail!", Toast.LENGTH_LONG);
                t.show();
            } else if (name.equals(email) && !password.equals(pass)) {
                Toast t = Toast.makeText(getApplicationContext(),
                        "Input the correct password!", Toast.LENGTH_LONG);
                t.show();

            } else {
                Toast t = Toast.makeText(getApplicationContext(),
                        "Input the correct e-mail and password!", Toast.LENGTH_LONG);
                t.show();

            }
        }
    }

}
