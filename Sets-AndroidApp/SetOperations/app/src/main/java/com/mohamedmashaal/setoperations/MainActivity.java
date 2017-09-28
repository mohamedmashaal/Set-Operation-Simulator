package com.mohamedmashaal.setoperations;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.*;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SetUsingArrayLists theSet ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.set_logo);
        theSet = new SetUsingArrayLists();
    }

    protected void addBtn(View view){
        EditText elemet = (EditText) findViewById(R.id.elementBox);
        EditText index = (EditText) findViewById(R.id.elementIndex);

        theSet.addElement(Integer.parseInt(index.getText().toString()),elemet.getText().toString());

    }
    protected void delBtn(View view){
        EditText elemet = (EditText) findViewById(R.id.elementBox);
        EditText index = (EditText) findViewById(R.id.elementIndex);

        theSet.removeElement(Integer.parseInt(index.getText().toString()),elemet.getText().toString());

    }
    protected void printSet(View view){
        EditText index = (EditText) findViewById(R.id.setPrint);

        String res = theSet.printSet(Integer.parseInt(index.getText().toString()));

        TextView resBox = (TextView)findViewById(R.id.resultBox);
        System.out.println(res);
        resBox.setText(res);

    }
    protected void unBtn(View view){
        EditText set1 = (EditText) findViewById(R.id.set1Box);
        EditText set2 = (EditText) findViewById(R.id.set2Box);
        String res = theSet.union(Integer.parseInt(set1.getText().toString()),Integer.parseInt(set2.getText().toString()));

        TextView resBox = (TextView)findViewById(R.id.resultBox);
        resBox.setText(new StringBuilder().append("Union Set : ").append(res).toString());

    }
    protected void intrBtn(View view){
        EditText set1 = (EditText) findViewById(R.id.set1Box);
        EditText set2 = (EditText) findViewById(R.id.set2Box);
        String res = theSet.intersect(Integer.parseInt(set1.getText().toString()),Integer.parseInt(set2.getText().toString()));

        TextView resBox = (TextView)findViewById(R.id.resultBox);
        resBox.setText(new StringBuilder().append("Intersection Set : ").append(res).toString());

    }
    protected void compBtn(View view){
        EditText comp = (EditText) findViewById(R.id.setComp);
        String res = theSet.complement(Integer.parseInt(comp.getText().toString()));

        TextView resBox = (TextView)findViewById(R.id.resultBox);
        resBox.setText(new StringBuilder().append("Complement Set : ").append(res).toString());

    }
    protected void printAll(View view){
        String res = theSet.printAll();

        TextView resBox = (TextView)findViewById(R.id.resultBox);
        resBox.setText(res);

    }

}
