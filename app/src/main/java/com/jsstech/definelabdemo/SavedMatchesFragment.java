package com.jsstech.definelabdemo;

import android.app.ActionBar;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class SavedMatchesFragment extends Fragment {




    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Saved Matches");

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_saved_matches,container,false);


    }
}