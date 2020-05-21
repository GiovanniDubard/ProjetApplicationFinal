package com.example.projetapplicationfinal;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<Characters> values;
    private Dialog myDialog;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtHeader;
        public TextView txtFooter;
        public View layout;
        public ImageView imageIcon;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
            imageIcon = (ImageView) v.findViewById(R.id.imageIcon);
            myDialog = new Dialog((v.getContext()));
        }
    }

    private void setOnClick(TextView txtHeader, final Characters characters) {
        txtHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopup(characters);
            }
        });
    }

    private void showPopup(Characters currentCharacters) {
        TextView txtclose, id, type, Name, Gender, Origin, created,Location, Spieces;
        ImageView imageView;
        myDialog.setContentView(R.layout.custompopup);
        id = myDialog.findViewById(R.id.id);
        type = myDialog.findViewById(R.id.type);
        Name = myDialog.findViewById(R.id.Name);
        Gender = myDialog.findViewById(R.id.Gender);
        Origin = myDialog.findViewById(R.id.Origin);
        created= myDialog.findViewById(R.id.created);
        Location = myDialog.findViewById(R.id.Location);
        Spieces = myDialog.findViewById(R.id.Spieces);
        imageView = myDialog.findViewById(R.id.imageView);
        txtclose = (TextView) myDialog.findViewById(R.id.txtclose);






        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();


    }

    public void add(int position, Characters item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ListAdapter(List<Characters> myDataset) {
        values = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final Characters currentCharacters = values.get(position);
        holder.txtHeader.setText(currentCharacters.getName());
        holder.txtFooter.setText(currentCharacters.getStatus());
        holder.imageIcon.setImageResource(R.mipmap.a);


        switch (currentCharacters.getId()){

            case 1:
                holder.imageIcon.setImageResource(R.mipmap.a);
                break;
            case 2:
                holder.imageIcon.setImageResource(R.mipmap.b);
                break;
            case 3:
                holder.imageIcon.setImageResource(R.mipmap.c);
                break;
            case 4:
                holder.imageIcon.setImageResource(R.mipmap.d);
                break;
            case 5:
                holder.imageIcon.setImageResource(R.mipmap.e);
                break;
            case 6:
                holder.imageIcon.setImageResource(R.mipmap.f);
                break;
            case 7:
                holder.imageIcon.setImageResource(R.mipmap.g);
                break;
            case 8:
                holder.imageIcon.setImageResource(R.mipmap.h);
                break;
            case 9:
                holder.imageIcon.setImageResource(R.mipmap.i);
                break;
            case 10:
                holder.imageIcon.setImageResource(R.mipmap.j);
                break;
            case 11:
                holder.imageIcon.setImageResource(R.mipmap.k);
                break;
            case 12:
                holder.imageIcon.setImageResource(R.mipmap.l);
                break;
            case 13:
                holder.imageIcon.setImageResource(R.mipmap.m);
                break;
            case 14:
                holder.imageIcon.setImageResource(R.mipmap.n);
                break;
            case 15:
                holder.imageIcon.setImageResource(R.mipmap.o);
                break;
            case 16:
                holder.imageIcon.setImageResource(R.mipmap.p);
                break;
            case 17:
                holder.imageIcon.setImageResource(R.mipmap.q);
                break;
            case 18:
                holder.imageIcon.setImageResource(R.mipmap.r);
                break;
            case 19:
                holder.imageIcon.setImageResource(R.mipmap.s);
                break;
            case 20:
                holder.imageIcon.setImageResource(R.mipmap.t);
                break;
        }

        holder.txtHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(currentCharacters);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }

}