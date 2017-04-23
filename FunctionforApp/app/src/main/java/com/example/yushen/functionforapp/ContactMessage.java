package com.example.yushen.functionforapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ContactMessage extends AppCompatActivity {
    Button send;
    Button cancel;
    TextView showsender;
    EditText content;
    EditText emailenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_message);
        send=(Button)findViewById(R.id.button_send);
        cancel=(Button)findViewById(R.id.button_cancel);

        showsender=(TextView)findViewById(R.id.TextView_emailaddress);
        content=(EditText) findViewById(R.id.editText_emailcontent);
        emailenter=(EditText)findViewById(R.id.editText_sender);


        final String add=getIntent().getExtras().getString("email");
        showsender.setText(add);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailintent=new Intent(Intent.ACTION_SEND);
                emailintent.putExtra(Intent.EXTRA_EMAIL,add);
                //emailintent.putExtra(Intent.EXTRA_SUBJECT, content.getText().toString());
                emailintent.putExtra(Intent.EXTRA_TEXT, content.getText().toString());
                emailintent.setType("text/plain");
                startActivity(emailintent);
            }
        });

    }
}
