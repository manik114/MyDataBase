package com.mk.manik.mydatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText eT;
    TextView tV;
    MySQLite mySQLite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eT = (EditText) findViewById(R.id.plain);
        tV = (TextView) findViewById(R.id.textView);
        mySQLite = new MySQLite(this,null,null,1);
        printDatabase();
    }

    public void saveButtonClicked(View view){
        Products products = new Products(eT.getText().toString());
        mySQLite.addProduct(products);
        printDatabase();
    }

    public void deleteButtonClicked(View view){
        String inputText = eT.getText().toString();
        mySQLite.deleteProduct(inputText);
        printDatabase();
    }

    public void printDatabase(){
        String databaseString = mySQLite.dataBaseToString();
       // ArrayAdapter adapter = new ArrayAdapter(this,databaseString);
        tV.setText(databaseString);
        eT.setText("");
    }
}
