package com.example.pract20chayka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
 EditText edName,edSName,edMail;
 Button btnRead,btnSave;
 private DatabaseReference myDataBase;
 private String User_Key="User";


private void init()
{
    edName=findViewById(R.id.edName);
    edSName=findViewById(R.id.edSName);
    edMail=findViewById(R.id.edMail);
    Button btnSave=(Button) findViewById(R.id.btnSave);
    Button btnRead=(Button) findViewById(R.id.btnRead);

    myDataBase=FirebaseDatabase.getInstance().getReference(User_Key);

}
    public void onClick(View view)
    {    if(view.getId() == R.id.btnSave) {
        String id=myDataBase.getKey();
        String name=edName.getText().toString();
        String SName=edSName.getText().toString();
        String Mail=edMail.getText().toString();
        User newUser=new User(id,name,SName,Mail);
        myDataBase.push().setValue(newUser);
        if(!TextUtils.isEmpty(name)&&!TextUtils.isEmpty(SName)&&!TextUtils.isEmpty(Mail))
        {
            myDataBase.push().setValue(newUser);
            Toast.makeText(this,"Сохранено",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"Пустое поле", Toast.LENGTH_SHORT).show();
        }

    }
        if(view.getId() == R.id.btnRead){
            Intent intent = new Intent(MainActivity.this, ReadActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }


}