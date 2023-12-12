package app.scrollfrom.contactsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
     FloatingActionButton btnOpenDialog;
     RecyclerContactAdapter adapter;
     RecyclerView recyclerView;
   ArrayList<ContactModel>arrayContact=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleView);
        btnOpenDialog =findViewById(R.id.btnOpenDialog);

        btnOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_update);
                EditText edtName = dialog.findViewById(R.id.edtName);
                EditText edtNumber= dialog.findViewById(R.id.edtNumber);
                Button btnAction= dialog.findViewById(R.id.btnAction);

                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = "", number = "";
                        if (!edtName.getText().toString().equals("")) {
                          name = edtName.getText().toString();
                        } else {
                            Toast.makeText(MainActivity.this, "Please Enter Name", Toast.LENGTH_SHORT).show();
                        }

                        if (!edtNumber.getText().toString().equals("")) {
                        number = edtNumber.getText().toString();
                        } else {
                            Toast.makeText(MainActivity.this, "Please Enter Number", Toast.LENGTH_SHORT).show();
                        }
                        arrayContact.add(new ContactModel(name, number));

                        adapter.notifyItemInserted(arrayContact.size()-1);
                        recyclerView.scrollToPosition(arrayContact.size()-1);
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrayContact.add(new ContactModel(R.drawable.boy,"Lokesh","7008133832"));
        arrayContact.add(new ContactModel(R.drawable.boy,"Rabi","7008133831"));
        arrayContact.add(new ContactModel(R.drawable.boy,"A","98248028"));
        arrayContact.add(new ContactModel(R.drawable.boy,"B","882838727"));
        arrayContact.add(new ContactModel(R.drawable.boy,"Lokesh","7008133832"));
        arrayContact.add(new ContactModel(R.drawable.boy,"Rabi","7008133831"));
        arrayContact.add(new ContactModel(R.drawable.boy,"A","98248028"));
        arrayContact.add(new ContactModel(R.drawable.boy,"B","882838727"));
        arrayContact.add(new ContactModel(R.drawable.boy,"Lokesh","7008133832"));
        arrayContact.add(new ContactModel(R.drawable.boy,"Rabi","7008133831"));
        arrayContact.add(new ContactModel(R.drawable.boy,"A","98248028"));
        arrayContact.add(new ContactModel(R.drawable.boy,"B","882838727"));
        arrayContact.add(new ContactModel(R.drawable.boy,"Lokesh","7008133832"));
        arrayContact.add(new ContactModel(R.drawable.boy,"Rabi","7008133831"));
        arrayContact.add(new ContactModel(R.drawable.boy,"A","98248028"));
        arrayContact.add(new ContactModel(R.drawable.boy,"B","882838727"));
         adapter=new RecyclerContactAdapter(this,arrayContact);
        recyclerView.setAdapter(adapter);
   }
}