package com.example.user.bestfriends.list_kido;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.user.bestfriends.R;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonHolder> {

    List<Person> personList;

    public PersonAdapter(List<Person> personList) {
        this.personList = personList;
    }

    @NonNull
    @Override
    public PersonHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_kido, parent, false);
        return new PersonHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonHolder holder, int position) {
        holder.personPhoto.setImageResource(personList.get(position).getPersonPhoto());
        holder.personName.setText(personList.get(position).getPersonName());
        holder.containerPersonList.setOnLongClickListener(v -> {
            return false;
        });

        final int infoData = personList.get(position).getPersonID();


        //AppDatabase db; // = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production");
//        holder.containerPersonList.setOnLongClickListener(v -> deleteItem(infoData));
//        db.userDao().deletePerson(infoData);
    }

    private boolean deleteItem(Person infoData) {
        int currentPosition = personList.indexOf(infoData);
        personList.remove(currentPosition);
        notifyItemRemoved(currentPosition);
        return true;
    }


    @Override
    public int getItemCount() { return personList.size(); }

    public class PersonHolder extends RecyclerView.ViewHolder {

        ImageView personPhoto;
        TextView personName;
        CheckBox check_people;
        RelativeLayout containerPersonList;

        public PersonHolder(View view) {
            super(view);
            personPhoto = view.findViewById(R.id.person_photo);
            personName = view.findViewById(R.id.person_name);
            check_people = view.findViewById(R.id.check_people);
            containerPersonList = view.findViewById(R.id.listView);
        }
    }
}
