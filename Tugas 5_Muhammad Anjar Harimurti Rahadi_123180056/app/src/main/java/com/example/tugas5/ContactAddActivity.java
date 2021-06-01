package com.example.tugas5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.tugas5.database.ContactDao;
import com.example.tugas5.database.ContactDatabase;
import com.example.tugas5.model.Contact;

public class ContactAddActivity extends AppCompatActivity implements View.OnClickListener{

    public static final int REQUEST_ADD = 100;
    public static final int RESULT_ADD = 110;
    ContactDao contactDao;

    EditText etName, etPhone;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_add);

        contactDao = ContactDatabase.getInstance(this).contactDao();

        etName = findViewById(R.id.et_name);
        etPhone = findViewById(R.id.et_phone);
        btnAdd = findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (btnAdd.equals(v)) {
            String sName = etName.getText().toString();
            String sPhone = etPhone.getText().toString();

            Contact contact = new Contact(sName, sPhone);
            contactDao.insertData(contact);

            setResult(RESULT_ADD);
            finish();
        }
    }
}