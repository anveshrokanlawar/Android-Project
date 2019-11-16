package com.example.shelf;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adaptor_findbook extends RecyclerView.Adapter<Adaptor_findbook.Viewholder>  {

    private List<Modelclass_findbook> modelClassList_findbook;

    public Adaptor_findbook(List<Modelclass_findbook> modelClassList_findbook){
        this.modelClassList_findbook = modelClassList_findbook;
    }



    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout_find_book,viewGroup,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder viewholder, int position) {
        viewholder.imageView.setImageResource(modelClassList_findbook.get(position).getImageResource());
        viewholder.title.setText(modelClassList_findbook.get(position).getTitle());
        viewholder.author.setText(modelClassList_findbook.get(position).getAuthor());
        viewholder.edition.setText(modelClassList_findbook.get(position).getEdition());
        viewholder.useremail.setText(modelClassList_findbook.get(position).getUseremail());
        final String useremail=modelClassList_findbook.get(position).getUseremail();
        final String title=modelClassList_findbook.get(position).getTitle();
        viewholder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), UserActivity.class);
                intent.putExtra("email", useremail);
                intent.putExtra("title", title);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelClassList_findbook.size();
    }


    class Viewholder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView title;
        private TextView author;
        private TextView edition;
        private TextView useremail;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.titleTV);
            author = itemView.findViewById(R.id.author);
            edition = itemView.findViewById(R.id.edition);
            useremail = itemView.findViewById(R.id.useremail);
        }

        private void setData(int resource, String titleText, String authorText, String editionText,String useremailText){
            imageView.setImageResource(resource);
            title.setText(titleText);
            author.setText(authorText);
            edition.setText(editionText);
            useremail.setText(useremailText);
        }
    }

}