package vn.edu.tinhoc123.viewpagerex;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HelloFragment extends Fragment {
    private static final String LOG_TAG = "AndroidExample";
    private TextView tvHello;
    private  String strHelloText;
    private static int counter = 0;
    public HelloFragment(String strHelloText) {
        this.strHelloText = strHelloText;

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = (ViewGroup) inflater.inflate(
                R.layout.fragment_hello, container, false);

        counter++;
        if(counter % 2 == 0) {
            view.setBackgroundColor(Color.parseColor("#ebdef0"));
        } else  {
            view.setBackgroundColor(Color.parseColor("#e8f8f5"));
        }
        tvHello = view.findViewById(R.id.textViewHello);
        tvHello.setText(strHelloText);
        // Inflate the layout for this fragment
        return view;
    }

}