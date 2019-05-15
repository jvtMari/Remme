package com.example.jose.remme.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jose.remme.R;


public class TodoTabFragment extends Fragment {

    private static final String LOGIN_MODE = "login_mode";
    private String login_mode;


    public TodoTabFragment() {
    }

    public static TodoTabFragment newInstance(String login_mode) {
        TodoTabFragment fragment = new TodoTabFragment();
        Bundle args = new Bundle();
        args.putString(LOGIN_MODE, login_mode);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            login_mode = getArguments().getString(login_mode);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_todo_tab, container, false);
        return fragmentView;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
