package com.minhvo.listviewlunchmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lvMeal = (ListView)findViewById(R.id.lvFood);

        ArrayList<Meal> dsMeal = new ArrayList<>();
        Meal m1 = new Meal("Cơm gà",30000,"Cơm, gà chiên, sốt.",R.drawable.cg);
        Meal m2 = new Meal("Cơm chiên dương châu",30000,"Cơm, gà chiên, sốt.",R.drawable.ccdc);
        Meal m3 = new Meal("Cơm tấm sườn bì chả",30000,"Cơm, gà chiên, sốt.",R.drawable.ctbc);
        Meal m4 = new Meal("Cơm nắm",30000,"Cơm, gà chiên, sốt.",R.drawable.onigiri);
        Meal m5 = new Meal("Nước lọc",30000,"Cơm, gà chiên, sốt.",R.drawable.water);
        dsMeal.add(m1);
        dsMeal.add(m2);
        dsMeal.add(m3);
        dsMeal.add(m4);
        dsMeal.add(m5);

        //
        MealAdapter mealAdapter = new MealAdapter(this,dsMeal);
        lvMeal.setAdapter(mealAdapter);

        //
        lvMeal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //
                Meal mealOption = dsMeal.get(i);
                //
                Toast.makeText(MainActivity.this, mealOption.getTenFood(),Toast.LENGTH_SHORT).show();


            }
        });
    }

    //

}