package com.sportech20.iitd.sponsors;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.sportech20.iitd.Constants;
import com.sportech20.iitd.FirebaseDataHandler.GetScoresData;
import com.sportech20.iitd.R;
import com.sportech20.iitd.com.sportech20.iitd.sportResult.FemaleSportResultListRecyclerAdapter;
import com.sportech20.iitd.com.sportech20.iitd.sportResult.getDataFromFirebase;

import java.util.ArrayList;
import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SponsorsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SponsorsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    RecyclerView recyclerView;
    sponsorsAdapter sponsorsAdapter;



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public SponsorsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SponsorsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SponsorsFragment newInstance(String param1, String param2) {
        SponsorsFragment fragment = new SponsorsFragment();
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
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_sponsors, container, false);
        recyclerView=view.findViewById(R.id.sponsorsRView);
        ArrayList<sponsorsData> list=new ArrayList<>();
        list.add(new sponsorsData("https://www.thesouledstore.com/",R.drawable.souled));
        list.add(new sponsorsData("https://www.thegamerzgalaxy.com/",R.drawable.gamerz_galaxy));
        list.add(new sponsorsData("https://www.redbull.com/in-en/",R.drawable.red_bull));
        list.add(new sponsorsData("https://www.zomato.com/ncr/raynas-cafe-safdarjung-new-delhi",R.drawable.rayna));
        list.add(new sponsorsData("https://www.zomato.com/ncr/the-chai-story-hauz-khas-new-delhi",R.drawable.chai_story));
        list.add(new sponsorsData("https://www.delhivery.com/",R.drawable.delhivery));
        list.add(new sponsorsData("https://bajajsports.com/",R.drawable.bajaj));
        sponsorsAdapter = new sponsorsAdapter(getContext(), list);
        recyclerView.setAdapter(sponsorsAdapter);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(getContext()));



        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
