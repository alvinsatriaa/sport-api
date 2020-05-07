package com.example.sportapi.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sportapi.R;
import com.example.sportapi.adapter.SportAdapter;
import com.example.sportapi.model.sport.ResultItem;
import com.example.sportapi.view.viewmodel.SportViewModel;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class SportFragment extends Fragment {

    private SportAdapter sportAdapter;
    private RecyclerView rvSport;
    private SportViewModel sportViewModel;



    public SportFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sport, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sportAdapter = new SportAdapter(getContext());
        sportAdapter.notifyDataSetChanged();

        rvSport = view.findViewById(R.id.fragmentsport_rv);
        rvSport.setLayoutManager(new GridLayoutManager(getContext(),2));

        sportViewModel = new ViewModelProvider(this).get(SportViewModel.class);
        sportViewModel.setSportDiscover();
        sportViewModel.getSportDiscover().observe(this,getSportDiscover);

        rvSport.setAdapter(sportAdapter);
    }

    private Observer<ArrayList<ResultItem>> getSportDiscover = new Observer<ArrayList<ResultItem>>() {


        private Object ResultItem;

        @Override
        public void onChanged(ArrayList<ResultItem> resultItems) {
            if (ResultItem != null) {
                sportAdapter.setData((ArrayList<com.example.sportapi.model.sport.ResultItem>) ResultItem);
            }
        }
    };
}
