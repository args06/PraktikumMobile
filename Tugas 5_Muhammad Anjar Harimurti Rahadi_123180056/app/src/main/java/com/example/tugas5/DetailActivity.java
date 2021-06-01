package com.example.tugas5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tugas5.database.ContactDao;
import com.example.tugas5.database.ContactDatabase;
import com.example.tugas5.model.Contact;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_DATA = "EXTRA_DATA";

    public static final int REQUEST_EDIT = 200;
    public static final int RESULT_EDIT = 210;

    Contact contact;
    EditText etName, etPhone;
    ContactDao contactDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        contact = getIntent().getParcelableExtra(EXTRA_DATA);

        contactDao = ContactDatabase.getInstance(this).contactDao();

        etName = findViewById(R.id.et_name);
        etName.setText(contact.getName());

        etPhone = findViewById(R.id.et_phone);
        etPhone.setText(contact.getPhoneNumber());

        Button btnUpdate = findViewById(R.id.btn_update);
        btnUpdate.setOnClickListener(v -> {
            String sName = etName.getText().toString();
            String sPhone = etPhone.getText().toString();

            if (sName.trim().equals("")){
                etName.setError("Nama Harus Diisi");
            } else if (sPhone.trim().equals("")){
                etPhone.setError("Alamat Harus Diisi");
            } else {
                editData(sName, sPhone);
            }
        });
    }

    private void editData(String sName, String sPhone){
        Contact updateNote = new Contact(contact.getId(), sName, sPhone);
        contactDao.updateData(updateNote);

        setResult(RESULT_EDIT);
        finish();
    }
}