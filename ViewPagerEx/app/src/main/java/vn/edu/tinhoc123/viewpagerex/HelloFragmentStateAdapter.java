package vn.edu.tinhoc123.viewpagerex;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

public class HelloFragmentStateAdapter extends FragmentStateAdapter {
    List<String> lstHelo;
    public HelloFragmentStateAdapter(@NonNull FragmentActivity fragmentActivity, List<String> lstH)  {
        super(fragmentActivity);
        lstHelo = lstH;

    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        String s= lstHelo.get(position);
        return new HelloFragment(s);
    }

    @Override
    public int getItemCount() {
        return lstHelo.size();
    }
}
