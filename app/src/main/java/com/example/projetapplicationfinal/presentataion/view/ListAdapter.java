package com.example.projetapplicationfinal.presentataion.view;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.projetapplicationfinal.R;
import com.example.projetapplicationfinal.presentataion.model.Characters;

import java.util.List;

import static com.example.projetapplicationfinal.R.*;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<Characters> values;
    private Dialog myDialog;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Characters item);
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtHeader;
        public TextView txtFooter;
        public View layout;
        public ImageView imageIcon;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(id.firstLine);
            txtFooter = (TextView) v.findViewById(id.secondLine);
            imageIcon = (ImageView) v.findViewById(id.imageIcon);
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
        TextView txtclose, id, type, name, gender, origin, created,location, spieces;
        ImageView imageView;
        myDialog.setContentView(layout.custompopup);
        id = myDialog.findViewById(R.id.id);
        type = myDialog.findViewById(R.id.type);
        name = myDialog.findViewById(R.id.name);
        gender = myDialog.findViewById(R.id.gender);
        origin = myDialog.findViewById(R.id.origin);
        created= myDialog.findViewById(R.id.created);
        location = myDialog.findViewById(R.id.location);
        spieces = myDialog.findViewById(R.id.spieces);
        imageView = myDialog.findViewById(R.id.imageView);
        txtclose = (TextView) myDialog.findViewById(R.id.txtclose);


        id.setText(""+currentCharacters.getId());
        type.setText("Type : " + currentCharacters.getType());
        name.setText(currentCharacters.getName());
        gender.setText("Gender : " + currentCharacters.getGender());
        origin.setText("Origin : " + currentCharacters.getOrigin());
        created.setText("Created : " + currentCharacters.getCreated());
        location.setText("Location : " + currentCharacters.getLocation());
        spieces.setText("Spieces : " + currentCharacters.getSpecies());

            switch (currentCharacters.getId()){
                case 1:
                    imageView.setImageResource(drawable.a);
                    break;
                case 2:
                    imageView.setImageResource(drawable.b);
                    break;
                case 3:
                    imageView.setImageResource(drawable.c);;
                    break;
                case 4:
                    imageView.setImageResource(drawable.d);
                    break;
                case 5:
                    imageView.setImageResource(drawable.e);;
                    break;
                case 6:
                    imageView.setImageResource(drawable.f);;
                    break;
                case 7:
                    imageView.setImageResource(drawable.g);;
                    break;
                case 8:
                    imageView.setImageResource(drawable.h);;
                    break;
                case 9:
                    imageView.setImageResource(drawable.i);;
                    break;
                case 10:
                    imageView.setImageResource(drawable.j);;
                    break;
                case 11:
                    imageView.setImageResource(drawable.k);;
                    break;
                case 12:
                    imageView.setImageResource(drawable.l);;
                    break;
                case 13:
                    imageView.setImageResource(drawable.m);;
                    break;
                case 14:
                    imageView.setImageResource(drawable.n);;
                    break;
                case 15:
                    imageView.setImageResource(drawable.o);;
                    break;
                case 16:
                    imageView.setImageResource(drawable.p);;
                    break;
                case 17:
                    imageView.setImageResource(drawable.q);;
                    break;
                case 18:
                    imageView.setImageResource(drawable.r);;
                    break;
                case 19:
                    imageView.setImageResource(drawable.s);;
                    break;
                case 20:
                    imageView.setImageResource(drawable.t);;
                    break;

        }


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
    public ListAdapter(List<Characters> myDataset, OnItemClickListener listener) {
        this.values = myDataset;
        this.listener = listener;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(layout.row_layout, parent, false);
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
        holder.imageIcon.setImageResource(mipmap.a);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(currentCharacters);
            }
        });




        switch(currentCharacters.getId())

            {

                case 1:
                    holder.imageIcon.setImageResource(mipmap.a);
                    break;
                case 2:
                    holder.imageIcon.setImageResource(mipmap.b);
                    break;
                case 3:
                    holder.imageIcon.setImageResource(mipmap.c);
                    break;
                case 4:
                    holder.imageIcon.setImageResource(mipmap.d);
                    break;
                case 5:
                    holder.imageIcon.setImageResource(mipmap.e);
                    break;
                case 6:
                    holder.imageIcon.setImageResource(mipmap.f);
                    break;
                case 7:
                    holder.imageIcon.setImageResource(mipmap.g);
                    break;
                case 8:
                    holder.imageIcon.setImageResource(mipmap.h);
                    break;
                case 9:
                    holder.imageIcon.setImageResource(mipmap.i);
                    break;
                case 10:
                    holder.imageIcon.setImageResource(mipmap.j);
                    break;
                case 11:
                    holder.imageIcon.setImageResource(mipmap.k);
                    break;
                case 12:
                    holder.imageIcon.setImageResource(mipmap.l);
                    break;
                case 13:
                    holder.imageIcon.setImageResource(mipmap.m);
                    break;
                case 14:
                    holder.imageIcon.setImageResource(mipmap.n);
                    break;
                case 15:
                    holder.imageIcon.setImageResource(mipmap.o);
                    break;
                case 16:
                    holder.imageIcon.setImageResource(mipmap.p);
                    break;
                case 17:
                    holder.imageIcon.setImageResource(mipmap.q);
                    break;
                case 18:
                    holder.imageIcon.setImageResource(mipmap.r);
                    break;
                case 19:
                    holder.imageIcon.setImageResource(mipmap.s);
                    break;
                case 20:
                    holder.imageIcon.setImageResource(mipmap.t);
                    break;
            }

        holder.txtHeader.setOnClickListener(new View.OnClickListener()

            {
                @Override
                public void onClick (View v){
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