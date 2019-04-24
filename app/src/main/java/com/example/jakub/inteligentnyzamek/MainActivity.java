package com.example.jakub.inteligentnyzamek;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mDatabaseReference;

    @BindView(R.id.doorsOpenClickableImage)
    ImageView doorsOpenClickableImage;
    @BindView(R.id.rfidBlockClickableImage)
    ImageView rfidBlockClickableImage;

    FirebaseDatabaseClass firebaseDatabaseClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference("Control");
        firebaseDatabaseClass = new FirebaseDatabaseClass();
        starringFirebaseListener();
    }

    @OnClick(R.id.doorsOpenClickableImage)
    public void doorsOpen() {
        mDatabaseReference.child("openByApp").setValue(1).addOnCompleteListener(task -> System.out.println("Doors opened succesfully"));
    }

    @OnClick(R.id.rfidBlockClickableImage)
    public void blockCards() {
        if (firebaseDatabaseClass.getCardsBlocked() == 1) {
            mDatabaseReference.child("cardsBlocked").setValue(0).addOnCompleteListener(task -> System.out.println("RFID cards are now unlocked"));
        } else {
            mDatabaseReference.child("cardsBlocked").setValue(1).addOnCompleteListener(task -> System.out.println("RFID cards are now blocked"));
        }
    }


    public void starringFirebaseListener() {
        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    switch (Objects.requireNonNull(ds.getKey())) {
                        case "openByCard":
                            firebaseDatabaseClass.setOpenByCard(ds.getValue(Integer.class));
                            break;
                        case "cardsBlocked":
                            firebaseDatabaseClass.setCardsBlocked(ds.getValue(Integer.class));
                            break;
                        case "openByApp":
                            firebaseDatabaseClass.setOpenByApp(ds.getValue(Integer.class));
                            break;
                        case "colorRed":
                            firebaseDatabaseClass.setColorRed(ds.getValue(Integer.class));
                            break;
                        case "colorBlue":
                            firebaseDatabaseClass.setColorBlue(ds.getValue(Integer.class));
                            break;
                        case "colorGreen":
                            firebaseDatabaseClass.setColorGreen(ds.getValue(Integer.class));
                            break;
                    }
                    if (firebaseDatabaseClass.getCardsBlocked() == 1) {
                        rfidBlockClickableImage.setImageDrawable(getDrawable(R.drawable.lockedit));
                    } else {
                        rfidBlockClickableImage.setImageDrawable(getDrawable(R.drawable.unlockedit));
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}

