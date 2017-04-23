package com.example.yushen.functionforapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.net.URL;

public class ChatWithPeople extends AppCompatActivity {

    Button girl1;
    Button girl2;
    Button boy1;
    Button boy2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_with_people);

        girl1=(Button)findViewById(R.id.girl1);
        girl2=(Button)findViewById(R.id.boy2);
        boy1=(Button)findViewById(R.id.boy2);
        boy2=(Button)findViewById(R.id.boy2);

        final Bundle bundle=new Bundle();

        girl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jump=new Intent(ChatWithPeople.this, ContactMessage.class);
                String sender="bradkate2016@gmail.com";
                bundle.putString("email",sender);
                jump.putExtras(bundle);
                startActivity(jump);
            }
        });

        girl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jump=new Intent(ChatWithPeople.this, ContactMessage.class);
                String sender="bradkate2016@gmail.com";
                bundle.putString("email",sender);
                jump.putExtras(bundle);
                startActivity(jump);
            }
        });

        boy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jump=new Intent(ChatWithPeople.this, ContactMessage.class);
                String sender="bradkate2016@gmail.com";
                bundle.putString("email",sender);
                jump.putExtras(bundle);
                startActivity(jump);
            }
        });

        boy2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jump=new Intent(ChatWithPeople.this, ContactMessage.class);
                String sender="bradkate2016@gmail.com";
                bundle.putString("email",sender);
                jump.putExtras(bundle);
                startActivity(jump);
            }
        });
    }
}
