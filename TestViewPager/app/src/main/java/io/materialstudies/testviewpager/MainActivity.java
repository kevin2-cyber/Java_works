package io.materialstudies.testviewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

import io.materialstudies.testviewpager.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // enable viewBinding
    ActivityMainBinding binding;

    // creating an object of ViewPager
    ViewPager mViewPager;

    // creating an object of TabLayout
    TabLayout mTabLayout;

    // images array
    int[] images = {R.drawable.ic_flag_of_argentina, R.drawable.ic_flag_of_australia, R.drawable.ic_flag_of_belgium,
                    R.drawable.ic_flag_of_brazil, R.drawable.ic_flag_of_fiji, R.drawable.ic_flag_of_denmark,
                    R.drawable.ic_flag_of_germany, R.drawable.ic_flag_of_india, R.drawable.ic_flag_of_kuwait,
                    R.drawable.ic_flag_of_new_zealand};

    // creating an object of the viewPagerAdapter
    ViewPagerAdapter mViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        Objects.requireNonNull(getSupportActionBar()).hide();

        // Initializing the ViewPager Object
        mViewPager = binding.viewPagerMain;

        // Initializing the TabLayout Object
        mTabLayout = binding.tabLayout;

        // Initializing the ViewPagerAdapter
        mViewPagerAdapter = new ViewPagerAdapter(MainActivity.this, images);

        // Adding the Adapter to the ViewPager
        mViewPager.setAdapter(mViewPagerAdapter);

        // setting up with viewPager
        mTabLayout.setupWithViewPager(mViewPager);
    }
}