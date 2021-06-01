package com.example.tugas5;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tugas5.adapter.ContactAdapter;
import com.example.tugas5.database.ContactDao;
import com.example.tugas5.database.ContactDatabase;
import com.example.tugas5.model.Contact;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ContactAdapter.DeleteDialogListener{

    RecyclerView rvRecyclerView;
    FloatingActionButton fabAdd;
    ContactDao contactDao;

    private ArrayList<Contact> listContacts = new ArrayList<>();
    private ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactDao = ContactDatabase.getInstance(this).contactDao();

        fabAdd = findViewById(R.id.fab_add);

        rvRecyclerView = findViewById(R.id.rv_recycler_view);
        rvRecyclerView.setHasFixedSize(true);
        rvRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        contactAdapter = new ContactAdapter(listContacts);
        contactAdapter.onDeleteListener(this);
        loadData();
        rvRecyclerView.setAdapter(contactAdapter);

        fabAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (fabAdd.equals(v)) {
            Intent intent = new Intent(this, ContactAddActivity.class);
            startActivityForResult(intent, ContactAddActivity.REQUEST_ADD);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ContactAddActivity.REQUEST_ADD) {
            if (resultCode == ContactAddActivity.RESULT_ADD) {
                loadData();
                showSnackBar("Data Berhasil Ditambahkan");
            }
        } else if (requestCode == DetailActivity.REQUEST_EDIT){
            if (resultCode == DetailActivity.RESULT_EDIT) {
                loadData();
                showSnackBar("Data Berhasil Diedit");
            }
        }
    }

    void loadData() {
        ArrayList<Contact> tempo = new ArrayList<>();

        List<Contact> data = contactDao.getAllData();
        tempo.clear();
        tempo.addAll(data);
        listContacts = tempo;
        contactAdapter.setContact(listContacts);
        System.out.println("Panjang ListContact: " + listContacts.size());
        System.out.println("Panjang Data: " + data.size());
        if (data.size() == 0){
            showSnackBar("Data Kosong");
        }
    }

    private void showSnackBar(String message){
        Snackbar.make(rvRecyclerView, message, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void deleteDialog(Contact contact) {
        System.out.println(contact.getName());

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Pilih operasi yang ingin anda lakukan");
        builder.setCancelable(true);

        builder.setPositiveButton("Hapus", (dialog, which) -> {
            contactDao.deleteData(contact);
            dialog.dismiss();
            loadData();
            showSnackBar("Data Berhasil Dihapus");
        });

        builder.setNeutralButton("Cancel", (dialog, which) -> {
            dialog.cancel();
        });

        builder.setNegativeButton("Edit", (dialog, which) -> {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_DATA, contact);
            startActivityForResult(intent, DetailActivity.REQUEST_EDIT);
        });

        builder.show();
    }
}