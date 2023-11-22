package vn.edu.tinhoc123.viewpagerex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 viewPager2;
    private TabLayout tabLayout;
    ArrayList lstHello;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager2 = findViewById(R.id.viewPager);
        tabLayout =findViewById(R.id.tab_layout);
        lstHello= new ArrayList<String>();
        lstHello.add("Hello");
        lstHello.add("Bonjour");
        lstHello.add("Xin Chao");
        HelloFragmentStateAdapter adapter = new HelloFragmentStateAdapter(this, lstHello);
        viewPager2.setAdapter(adapter);






        new TabLayoutMediator(tabLayout, viewPager2,
                (tab, position) -> tab.setText("Tab " + (position + 1))
        ).attach();


    }
}