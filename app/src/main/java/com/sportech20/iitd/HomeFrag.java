package com.sportech20.iitd;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFrag.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFrag extends Fragment  {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private static final String TAG = "HomeFrag";

    RecyclerView recyclerView;
    PhotoslistRecyclerAdapter adapter;
    List<ScoresListData> listScore = new ArrayList<>();
    RecyclerView scoresRecyclerView;
    ScoresListRecyclerAdapter scoresAdapter;

    DatabaseReference mDataReference;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public static final String MAPVIEW_BUNDLE_KEY = "MapViewBundleKey";
    private boolean isRotate=false;


    private OnFragmentInteractionListener mListener;

    public HomeFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFrag newInstance(String param1, String param2) {
        HomeFrag fragment = new HomeFrag();
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

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

//        final FloatingActionButton fab=view.findViewById(R.id.fabAdd);
        final FloatingActionButton fabMic=view.findViewById(R.id.fabMic);
        final FloatingActionButton fabCall=view.findViewById(R.id.fabCall);
        final FloatingActionButton fabWeb=view.findViewById(R.id.fabWeb);
        final FloatingActionButton fabYoutube=view.findViewById(R.id.fabYoutube);



/*
        scoresRecyclerView
                = (RecyclerView)view.findViewById(
                R.id.homescreen_scorecard);
        scoresAdapter
                = new ScoresListRecyclerAdapter(
                listScore, Objects.requireNonNull(getActivity().getApplication()));
        scoresRecyclerView.setAdapter(scoresAdapter);
   //     scoresRecyclerView.setLayoutManager(
   //             new LinearLayoutManager(getContext()));
        scoresRecyclerView.setLayoutManager(
               new CustomLinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        getDataFromFirebase gettingData = new getDataFromFirebase();*/
     /*   gettingData.getSportData("cricket", "male", "live", listScore, scoresAdapter, mDataReference);
        gettingData.getSportData("football", "male", "live", listScore, scoresAdapter, mDataReference);
        gettingData.getSportData("basketball", "male", "live", listScore, scoresAdapter, mDataReference);
        gettingData.getSportData("lawntennis", "male", "live", listScore, scoresAdapter, mDataReference);
        gettingData.getSportData("basketball", "female", "live", listScore, scoresAdapter, mDataReference);

        gettingData.getSportData("badminton", "male", "live", listScore, scoresAdapter, mDataReference);
*/
        //gettingData.getSportData("Athletics","female","live",listScore,scoresAdapter,mDataReference);
/*
        GetScoresData.getLiveMatches(listScore,scoresAdapter,mDataReference);
        // For perfect Scrolling
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(scoresRecyclerView);*/

//        ViewAnimation.init(fabMic);
//        ViewAnimation.init(fabCall);
//        ViewAnimation.init(fabWeb);

//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                isRotate = ViewAnimation.rotateFab(v, !isRotate);
//                if(isRotate){
//                    ViewAnimation.showIn(fabCall);
//                    ViewAnimation.showIn(fabMic);
//                    ViewAnimation.showIn(fabWeb);
//                }else{
//                    ViewAnimation.showOut(fabCall);
//                    ViewAnimation.showOut(fabMic);
//                    ViewAnimation.showOut(fabWeb);
//                }
//            }
//        });
//
        fabCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity(), "Opening Facebook", Toast.LENGTH_SHORT).show();
                openURL("https://www.facebook.com/iitd.sportech/");

            }
        });

        fabMic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(getActivity(), "Opening Instagram", Toast.LENGTH_SHORT).show();
                openURL("https://www.instagram.com/sportech.iitd");
            }
        });


        fabWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openURL("https://www.sportech-iitd.in/");

                //Toast.makeText(getActivity(), "Opening Website", Toast.LENGTH_SHORT).show();
            }
        });

        fabYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openURL("https://www.youtube.com/channel/UCetcAidWe9NBZG4qd9Zd71g/");

                //Toast.makeText(getActivity(), "Opening Youtube", Toast.LENGTH_SHORT).show();
            }
        });

        // Animate cardViews
        /*
        CardView cardView=view.findViewById(R.id.scheduleCard);
  *//*      ObjectAnimator animation = ObjectAnimator.ofFloat(cardView, "translationX", 100f);
        animation.setDuration(2000);
        animation.start();


      *//*  final CardView cardView2=view.findViewById(R.id.supportCard);
         *//*    ObjectAnimator animation2 = ObjectAnimator.ofFloat(cardView2, "translationX", 100f);
        animation2.setDuration(2000);
        animation2.start();
        final int c=1000;*//*


        ScrollView scrollView=view.findViewById(R.id.scrollView);
        scrollView.setSmoothScrollingEnabled(true);
        scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                Log.d(TAG, "onScrollChange: "+scrollY);

                if(oldScrollY<scrollY){
                    if(scrollY>100){
                    ObjectAnimator animation2 = ObjectAnimator.ofFloat(cardView2, "translationX", 50f);
                    animation2.setDuration(800);
                    animation2.start();}
                }else if(scrollY<50){cardView2.setX(-100);}
            }
        });*/
/*
        mapView = view.findViewById(R.id.mapView);
        initGoogleMap(savedInstanceState);
*/

        setUpCardViews(view);


        return view;
    }

    void openURL(String url)
    {
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
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

    void setUpCardViews(View view) {
        CardView cardView=view.findViewById(R.id.scheduleCard);

        CardView cardView2=view.findViewById(R.id.matchesCard);

        CardView cardView3=view.findViewById(R.id.supportCard);

        CardView cardView4=view.findViewById(R.id.mapCard);

        CardView cardView5=view.findViewById(R.id.ocCard);

        CardView cardView6=view.findViewById(R.id.sponsors_card);

        TextView techTeam=view.findViewById(R.id.developedByText);


        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onScheduleClick(v);
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onMatchesClick(v);
            }
        });

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSupportClick(v);
            }
        });

        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onMapClick(v);
            }
        });

        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTeamOCList(v);
            }
        });

        cardView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSponsorsClick(v);
            }
        });

        techTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTeamTechList(v);
            }
        });
    }
    private void onScheduleClick(View view)
    {
       // Toast.makeText(getActivity(), "Open Schedule Activity", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getContext(), ScheduleActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Objects.requireNonNull(getContext()).startActivity(intent);
    }
    private void onMatchesClick(View view){
        //Toast.makeText(getActivity(), "Open Matches Activity", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getContext(), SportsList.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Objects.requireNonNull(getContext()).startActivity(intent);
        //getActivity().overridePendingTransition(R.anim.fade_out_fast, R.anim.fade_in_fast);
    }

    private void onSupportClick(View view){
        Toast.makeText(getActivity(), "Opening Helpdesk", Toast.LENGTH_SHORT).show();
        openURL("mailto:bsa.iitd21@gmail.com");
    }

    private void onMapClick(View view)
    {
        //Toast.makeText(getActivity(), "Opening Map", Toast.LENGTH_SHORT).show();
        MainActivity.bottomNavigation.show(nav_bar_ids.About,true);
    }

    private void onTeamOCList(View view){
        Intent intent = new Intent(getContext(), TeamMembers.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("type",Constants.TeamOCType);
        Objects.requireNonNull(getContext()).startActivity(intent);
    }

    private void onTeamTechList(View view){
        Intent intent = new Intent(getContext(), TeamMembers.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("type",Constants.TeamTechType);
        Objects.requireNonNull(getContext()).startActivity(intent);
    }

    private void onSponsorsClick(View view){

        MainActivity.bottomNavigation.show(nav_bar_ids.Sports,true);

    }

    /*private List<ScoresListData> getDataForScores() {
        List<ScoresListData> list = new ArrayList<>();

        list.add(new ScoresListData("Even 120 minutes were not enough to separate winner from IITD and DTU as both ended at 2-2. It was only after penalties that IITD made their way to Finals by winning by 4-2.",getResources().getDrawable(R.mipmap.sportech_theme_foreground),0));
        list.add(new ScoresListData("Even 120 minutes were not enough to separate winner from IITD and DTU as both ended at 2-2. It was only after penalties that IITD made their way to Finals by winning by 4-2.",getResources().getDrawable(R.mipmap.sportech_theme_foreground),0));
        list.add(new ScoresListData("Even 120 minutes were not enough to separate winner from IITD and DTU as both ended at 2-2. It was only after penalties that IITD made their way to Finals by winning by 4-2.",getResources().getDrawable(R.mipmap.sportech_theme_foreground),0));
        return list;
    }*/
}
