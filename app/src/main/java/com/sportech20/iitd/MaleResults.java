package com.sportech20.iitd;

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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sportech20.iitd.FirebaseDataHandler.GetScoresData;
import com.sportech20.iitd.com.sportech20.iitd.sportResult.MaleSportResultListData;
import com.sportech20.iitd.com.sportech20.iitd.sportResult.MaleSportResultListRecyclerAdapter;
import com.sportech20.iitd.com.sportech20.iitd.sportResult.getDataFromFirebase;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MaleResults.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MaleResults#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MaleResults extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    RecyclerView recycler;
    MaleSportResultListRecyclerAdapter adapter;
    public static MaleResults contextMaleRes;

    public DatabaseReference mDataReference;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public MaleResults() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MaleResults.
     */
    // TODO: Rename and change types and number of parameters
    public static MaleResults newInstance(String param1, String param2) {
        MaleResults fragment = new MaleResults();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contextMaleRes=this;
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
        View view= inflater.inflate(R.layout.fragment_male_results, container, false);


        List<MaleSportResultListData> list = new ArrayList<>();
        //list = getData();

        recycler
                = (RecyclerView)view.findViewById(
                R.id.sport_result_recycler);
        adapter
                = new MaleSportResultListRecyclerAdapter(
                list, Objects.requireNonNull(getActivity().getApplication()));
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(
                new LinearLayoutManager(getContext()));
        getDataFromFirebase gettingData = new getDataFromFirebase();
        Intent intent=getActivity().getIntent();
        String sport_name = intent.getStringExtra("Sport");
        //gettingData.getSportData(sport_name, "male", "live", list, adapter, mDataReference);
        FrameLayout frameLayout=view.findViewById(R.id.frameLayMaleRes);
        frameLayout.setBackgroundResource(Constants.backgroundForSport.get(sport_name));
        GetScoresData.getPastMatches(list,adapter,mDataReference,sport_name);
        GetScoresData.getLiveMatches(list,adapter,mDataReference,sport_name);
        //GetScoresData.getFutureMatches(list,adapter,mDataReference,sport_name);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    public void scrollTo(int item,int off){
        //recycler.scrollToPosition(item);
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


    private List<MaleSportResultListData> getData() {
        List<MaleSportResultListData> list = new ArrayList<>();



        /*list.add(new MaleSportResultListData());
        list.add(new MaleSportResultListData());
        list.add(new MaleSportResultListData());
*/
        return list;
    }
}
