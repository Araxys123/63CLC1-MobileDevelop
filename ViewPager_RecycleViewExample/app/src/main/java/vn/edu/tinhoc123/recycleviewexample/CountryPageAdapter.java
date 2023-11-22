package vn.edu.tinhoc123.recycleviewexample;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class CountryPageAdapter extends FragmentStateAdapter {
    List<Country> lstDataSource;

    public CountryPageAdapter(@NonNull FragmentActivity fragmentActivity, List<Country> dataSource ) {
        super(fragmentActivity);
        lstDataSource = dataSource;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Country c = lstDataSource.get(position);
        CountryFragment countryFragment = new CountryFragment(c);
        return countryFragment;
    }

    @Override
    public int getItemCount() {
        return lstDataSource.size();
    }
}
