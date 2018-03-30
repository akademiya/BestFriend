package com.example.user.bestfriends.list_kido;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.user.bestfriends.R;
import com.example.user.bestfriends.list_kido.data.AppDatabase;

public class CreatePersonView extends AppCompatActivity {

    ImageView createPersonPhoto;
    EditText createPersonName;
    Button create_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_edit_list_kido);

        createPersonPhoto = findViewById(R.id.create_person_photo);
        createPersonName = findViewById(R.id.create_person_name);
        create_button = findViewById(R.id.create_button);

        final AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production")
                .allowMainThreadQueries()
                .build();

        create_button.setOnClickListener(v -> {
            Person person = new Person(
                    createPersonPhoto.getImageAlpha(),
                    createPersonName.getText().toString());
            db.userDao().insertAll(new Person(R.drawable.ic_person, createPersonName.getText().toString()));
            startActivity(new Intent(this, ListKidoView.class));
        });
    }
}