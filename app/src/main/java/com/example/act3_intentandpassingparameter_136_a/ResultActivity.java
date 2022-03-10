package com.example.act3_intentandpassingparameter_136_a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    // declare variable with data type TextView
    TextView txEmail, txPassword;

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // connect variable txEmail with TextView component in the layout
        txEmail = findViewById(R.id.tvEmail);

        // connect variable txPassword with TextView component in the layout
        txPassword = findViewById(R.id.tvPassword);

        // declare bundle variable that want to be used to take message that want to send to intent method
        Bundle bundle = getIntent().getExtras();

        // make string variable that want to be used to save data that want to be send from recent activity with key "a"
        String email = bundle.getString("a");

        // make string variable that want to be used to save data that want to be send from recent activity with key "b"
        String pass = bundle.getString("b");

        // show value from email variable into txEmail
        txEmail.setText(email);

        // show value from pass variable into txPassword
        txPassword.setText(pass);
    }
}
