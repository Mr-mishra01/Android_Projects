
package com.example.recyclerviewex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.recyclerviewex.RecyclerContactAdapter;


import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
   private RecyclerView recyclerView;
   private  Bitmap imgdata;
  private   ArrayList <ContactModel> arrContact = new ArrayList<>();
   private RecyclerContactAdapter adapter = new RecyclerContactAdapter(this,arrContact);
   Button addButton;
    private static final int PICK_IMAGE_REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_contact);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setAdapter(adapter);
        addButton = findViewById(R.id.addButton);



        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddContactDialog();
            }
        });
    }


    void openAddContactDialog() {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_add_contact);
        dialog.setCancelable(true);

        final EditText nameEditText = dialog.findViewById(R.id.nameEditText);
        final EditText numberEditText = dialog.findViewById(R.id.numberEditText);
        final ImageView imagePreview = dialog.findViewById(R.id.imagePreview);
        Button selectImageButton = dialog.findViewById(R.id.selectImageButton);
        Button saveButton = dialog.findViewById(R.id.saveButton);






        selectImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to open the image gallery
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, PICK_IMAGE_REQUEST_CODE);
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String number = numberEditText.getText().toString();

                if (name.isEmpty() || number.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else {
                    // Create a new Contact object
                    ContactModel contactmodel = new ContactModel(imgdata,name, number);
                    imagePreview.setImageBitmap(imgdata);
                    // Add the contact to the list
                    arrContact.add(contactmodel);
                    // Notify the adapter of the data change
                    adapter.notifyDataSetChanged();
                    imgdata = null;
                    // Dismiss the dialog
                    dialog.dismiss();
                }
            }
        });
        dialog.show();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            Uri selectedImageUri = data.getData();

            try {
                // Get the bitmap from the selected image URI
                imgdata = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImageUri);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
