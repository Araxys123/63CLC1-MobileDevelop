package vn.vominh.thigk;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class Cau3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cau3);

        ListView listView = findViewById(R.id.songListView);
        List<Song> songs = new ArrayList<>();
        songs.add(new Song("Rise", "123"));
        songs.add(new Song("Nautilus", "Creo"));
        songs.add(new Song("Red Horizon", "Creo"));

        SongAdapter adapter = new SongAdapter(this, songs);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song song = songs.get(position);
                String songInfo = "Title: " + song.getTitle() + ", Artist: " + song.getArtist();
                Toast.makeText(Cau3.this, songInfo, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

