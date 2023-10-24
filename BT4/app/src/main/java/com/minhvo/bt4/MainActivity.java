package com.minhvo.bt4;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;


public class MainActivity extends AppCompatActivity {
    private FragmentNote noteFragment;
    private FragmentKeypad keypadFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noteFragment = new FragmentNote();
        keypadFragment = new FragmentKeypad();

        // Load the fragments into the main activity layout
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.noteContainer, noteFragment);
        transaction.add(R.id.keypadContainer, keypadFragment);
        transaction.commit();
    }

    public void appendToNoteFragment(String text) {
        noteFragment.updateNoteText(noteFragment.noteTextView.getText() + text);
    }
}
