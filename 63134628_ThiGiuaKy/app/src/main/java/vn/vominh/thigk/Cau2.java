package vn.vominh.thigk;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class Cau2 extends AppCompatActivity {
    private ListView songListView;
    private ArrayAdapter<Song> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cau2);
        songListView = findViewById(R.id.songListView);
        ArrayList<Song> songList = new ArrayList<>();
        songList.add(new Song("GODS", "NewJeans"));
        songList.add(new Song("Ignite", "Zedd"));
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, songList);
        songListView.setAdapter(adapter);
    }
}
