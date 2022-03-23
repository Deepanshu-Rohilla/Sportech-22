/*
package com.sportech20.iitd;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sportech20.iitd.com.sportech20.iitd.sportResult.getDataFromFirebase;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


*/
/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SportsFrag} interface
 * to handle interaction events.
 * Use the {@link SportsFrag#newInstance} factory method to
 * create an instance of this fragment.
 *//*

public class SportsFrag extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    List<sportsListData> list = new ArrayList<>();
    RecyclerView recyclerView;
    PhotoslistRecyclerAdapter adapter;

    RecyclerView scoresRecyclerView;
    ScoresListRecyclerAdapter scoresAdapter;
    RecyclerView recyclerView2;
    SportsListRecyclerAdapter adapter2;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DatabaseReference mDataReference;
    private OnFragmentInteractionListener mListener;

    public SportsFrag() {
        // Required empty public constructor
    }

    */
/**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SportsFrag.
     *//*

    // TODO: Rename and change types and number of parameters
    public static SportsFrag newInstance(String param1, String param2) {
        SportsFrag fragment = new SportsFrag();
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
        mDataReference = FirebaseDatabase.getInstance().getReference();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_sports, container, false);

        List<ScoresListData> list = new ArrayList<>();
        list = getDataForScores();


        list = getData();

*/
/*
        // Photos List
        List<PhotosListData> list1 = new ArrayList<>();
        list1 = getData();

        recyclerView
                = (RecyclerView)view.findViewById(
                R.id.photos_list_recycler);
        adapter
                = new PhotoslistRecyclerAdapter(
                list1, Objects.requireNonNull(getActivity().getApplication()));
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(getContext()));
        getDataFromFirebase getData = new getDataFromFirebase();
        //getData.getImportantMatchData("cricket", list, adapter, mDataReference);
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
     *//*

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


    private List<sportsListData> getData()
    {
        List<sportsListData> list = new ArrayList<>();
        list.add(new sportsListData("Athletics", (getResources().getDrawable(R.drawable.ic_sports_basketball_24px)),
                   "IITD", "IITK", "2/0", "3/0", "pool", "cricket"));
        list.add(new sportsListData("Badminton", (getResources().getDrawable(R.drawable.ic_sports_basketball_24px)),
                "IITD", "IITK", "2/0", "3/0", "pool", "cricket"));
        list.add(new sportsListData("Basketball", (getResources().getDrawable(R.drawable.ic_sports_basketball_24px)),
                "IITD", "IITK", "2/0", "3/0", "pool", "cricket"));
        list.add(new sportsListData("Chess", (getResources().getDrawable(R.drawable.ic_sports_basketball_24px)),
                "IITD", "IITK", "2/0", "3/0", "pool", "cricket"));
        list.add(new sportsListData("Cricket", (getResources().getDrawable(R.drawable.ic_sports_basketball_24px)),
                "IITD", "IITK", "2/0", "3/0", "pool", "cricket"));
        list.add(new sportsListData("Football", (getResources().getDrawable(R.drawable.ic_sports_soccer_24px)),
                "IITD", "IITK", "2/0", "3/0", "pool", "cricket"));

        list.add(new sportsListData("Hockey", (getResources().getDrawable(R.drawable.ic_sports_basketball_24px)),
                "IITD", "IITK", "2/0", "3/0", "pool", "cricket"));
        list.add(new sportsListData("Squash", (getResources().getDrawable(R.drawable.ic_sports_basketball_24px)),
                "IITD", "IITK", "2/0", "3/0", "pool", "cricket"));
        list.add(new sportsListData("Table tennis", (getResources().getDrawable(R.drawable.ic_sports_basketball_24px)),
                "IITD", "IITK", "2/0", "3/0", "pool", "cricket"));
        list.add(new sportsListData("Lawntennis", (getResources().getDrawable(R.drawable.ic_sports_basketball_24px)),
                "IITD", "IITK", "2/0", "3/0", "pool", "cricket"));
        list.add(new sportsListData("Volleyball", (getResources().getDrawable(R.drawable.ic_sports_basketball_24px)),
                "IITD", "IITK", "2/0", "3/0", "pool", "cricket"));
        list.add(new sportsListData("Weightlifting", (getResources().getDrawable(R.drawable.ic_sports_basketball_24px)),
                "IITD", "IITK", "2/0", "3/0", "pool", "cricket"));


        return list;
    }

    private List<ScoresListData> getDataForScores() {
        List<ScoresListData> list = new ArrayList<>();

        list.add(new ScoresListData("Even 120 minutes were not enough to separate winner from IITD and DTU as both ended at 2-2. It was only after penalties that IITD made their way to Finals by winning by 4-2.",getResources().getDrawable(R.mipmap.sportech_theme_foreground),0));
        list.add(new ScoresListData("Even 120 minutes were not enough to separate winner from IITD and DTU as both ended at 2-2. It was only after penalties that IITD made their way to Finals by winning by 4-2.",getResources().getDrawable(R.mipmap.sportech_theme_foreground),0));
        list.add(new ScoresListData("Even 120 minutes were not enough to separate winner from IITD and DTU as both ended at 2-2. It was only after penalties that IITD made their way to Finals by winning by 4-2.",getResources().getDrawable(R.mipmap.sportech_theme_foreground),0));
        return list;
    }



}
*/
