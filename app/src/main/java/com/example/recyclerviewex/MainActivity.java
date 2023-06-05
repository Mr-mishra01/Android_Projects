
package com.example.recyclerviewex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    ArrayList <ContactModel> arrContact = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_contact);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));


        arrContact.add(new ContactModel(R.drawable.boy,"xyz","868689699699"));
        arrContact.add(new ContactModel(R.drawable.boy1,"jnsf","546747699"));
        arrContact.add(new ContactModel(R.drawable.boy2,"xyznfnf","7657699699"));
        arrContact.add(new ContactModel(R.drawable.boy3,"hfif","23323699699"));
        arrContact.add(new ContactModel(R.drawable.girl,"oni","0908999699"));
        arrContact.add(new ContactModel(R.drawable.grl1,"lofu","3534699699"));
        arrContact.add(new ContactModel(R.drawable.women,"loju","857858595"));
        arrContact.add(new ContactModel(R.drawable.businesswoman,"maez","885075975"));
        arrContact.add(new ContactModel(R.drawable.d,"xujd","48749484948"));
        arrContact.add(new ContactModel(R.drawable.boy,"afyz","868689699699"));
        arrContact.add(new ContactModel(R.drawable.boy1,"jafaesf","546747699"));
        arrContact.add(new ContactModel(R.drawable.boy2,"aefaznfnf","7657699699"));
        arrContact.add(new ContactModel(R.drawable.boy3,"afaeif","23323699699"));
        arrContact.add(new ContactModel(R.drawable.girl,"qdaeani","0908999699"));


        RecyclerContactAdapter adapter = new RecyclerContactAdapter(this,arrContact);
        recyclerView.setAdapter(adapter);















    }
}