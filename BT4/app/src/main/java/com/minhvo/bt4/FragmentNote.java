package com.minhvo.bt4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class FragmentNote extends Fragment {
    TextView noteTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note, container, false);
        noteTextView = view.findViewById(R.id.noteTextView);
        return view;
    }

    public void updateNoteText(String text) {
        noteTextView.setText(text);
    }
}
