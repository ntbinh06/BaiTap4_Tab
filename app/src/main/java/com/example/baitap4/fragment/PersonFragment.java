package com.example.baitap4.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.baitap4.R;
import com.example.baitap4.person.PersonViewPagerAdapter;
import com.example.baitap4.widget.CustomViewPaper;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PersonFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PersonFragment extends Fragment {

    private TabLayout tabLayout;
    private CustomViewPaper viewPager;
    private View mView;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public PersonFragment() {
        // Required empty public constructor
    }

    public static PersonFragment newInstance(String param1, String param2) {
        PersonFragment fragment = new PersonFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_person, container, false);

        tabLayout = mView.findViewById(R.id.tab_layout); // Đảm bảo ID đúng
        viewPager = mView.findViewById(R.id.person_viewpaper); // Sửa ID thành view_pager

        PersonViewPagerAdapter adapter = new PersonViewPagerAdapter(getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT); // Thêm dấu chấm phẩy
        viewPager.setAdapter(adapter);
        viewPager.setPagingEnable(false);

        tabLayout.setupWithViewPager(viewPager);

        return mView;
    }
}