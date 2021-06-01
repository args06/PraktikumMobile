package com.example.tugas5.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tugas5.R;
import com.example.tugas5.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder>{

    private ArrayList<Contact> contact = new ArrayList<>();

    DeleteDialogListener deleteDialogListener;

    public ContactAdapter(ArrayList<Contact> contact) {
        this.contact = contact;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(contact.get(position));
    }

    @Override
    public int getItemCount() {
        return contact.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        CardView cvCardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            cvCardView = itemView.findViewById(R.id.cv_cardview);
        }

        void bind(Contact contact){
            tvName.setText(contact.getName());
            cvCardView.setOnLongClickListener(v -> {
                deleteDialogListener.deleteDialog(contact);
                return false;
            });
        }
    }

    public ArrayList<Contact> getContact() {
        return contact;
    }

    public void setContact(ArrayList<Contact> contact) {
        this.contact.clear();
        this.contact.addAll(contact);
        notifyDataSetChanged();
        System.out.println(contact.size());
    }

    public void onDeleteListener(DeleteDialogListener deleteDialogListener){
        this.deleteDialogListener = deleteDialogListener;
    }

    public interface DeleteDialogListener{
        void deleteDialog(Contact contact);
    }
}
