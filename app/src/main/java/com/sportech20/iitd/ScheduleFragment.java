package com.sportech20.iitd;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sportech20.iitd.newSportFragment.newSportFragAdapter;
import com.sportech20.iitd.newSportFragment.sportFragData;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ScheduleFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ScheduleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScheduleFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

//    ArrayList<DataModel> arrayList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private GridLayoutManager mGridLayoutManager;
    private List<sportFragData> sportList;
    private newSportFragAdapter sportAdapter;

    public ScheduleFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ScheduleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ScheduleFragment newInstance(String param1, String param2) {
        ScheduleFragment fragment = new ScheduleFragment();
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
        /*View view = inflater.inflate(R.layout.fragment_schedule, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.scheduleRecycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        arrayList.add(new DataModel("ATHLETICS"));
        arrayList.add(new DataModel("BADMINTON(M)"));
        arrayList.add(new DataModel("BADMINTON(W)"));
        arrayList.add(new DataModel("BASKETBALL(M)"));
        arrayList.add(new DataModel("BASKETBALL(W)"));
        arrayList.add(new DataModel("CHESS"));
        arrayList.add(new DataModel("CRICKET"));
        arrayList.add(new DataModel("FOOTBALL"));
        arrayList.add(new DataModel("HOCKEY"));
        arrayList.add(new DataModel("LAWN TENNIS(M)"));
        arrayList.add(new DataModel("LAWN TENNIS(W)"));
        arrayList.add(new DataModel("SQUASH"));
        arrayList.add(new DataModel("TABLE TENNIS(M)"));
        arrayList.add(new DataModel("TABLE TENNIS(W)"));
        arrayList.add(new DataModel("VOLLEYBALL(M)"));
        arrayList.add(new DataModel("VOLLEYBALL(W)"));
        arrayList.add(new DataModel("WEIGHTLIFTING"));


        CustomAdapter customAdapter = new CustomAdapter(arrayList);
        recyclerView.setAdapter(customAdapter);
        return view;*/
        View view = inflater.inflate(R.layout.fragment_new_sports, container, false);


        sportList = new ArrayList<>();
        sportList.add(new sportFragData("Athletics", R.drawable.ic_running, true));
        sportList.add(new sportFragData("Chess", R.drawable.ic_chess_piece, true));
        sportList.add(new sportFragData("Cricket", R.drawable.ic_cricket, true));
        sportList.add(new sportFragData("Football", R.drawable.ic_football, true));
        sportList.add(new sportFragData("Hockey", R.drawable.ic_hockey, true));
        sportList.add(new sportFragData("Squash", R.drawable.ic_squash, true));
        sportList.add(new sportFragData("Badminton(M)", R.drawable.ic_badminton, true));
        sportList.add(new sportFragData("Badminton(W)", R.drawable.ic_badminton, true));
        sportList.add(new sportFragData("Basketball(M)", R.drawable.ic_basketball, true));
        sportList.add(new sportFragData("Basketball(W)", R.drawable.ic_basketball, true));
        sportList.add(new sportFragData("Lawn Tennis (M)", R.drawable.ic_ping_pong, true));
        sportList.add(new sportFragData("Lawn Tennis (W)", R.drawable.ic_ping_pong, true));
        sportList.add(new sportFragData("Table Tennis (M)", R.drawable.ic_tennis, true));
        sportList.add(new sportFragData("Table Tennis (W)", R.drawable.ic_tennis, true));
        sportList.add(new sportFragData("Volleyball (M)", R.drawable.ic_volleyball, true));
        sportList.add(new sportFragData("Volleyball (W)", R.drawable.ic_volleyball, true));
        //sportList.add(new sportFragData("WEIGHTLIFTING", R.drawable.ic_gym, true));

        mRecyclerView = view.findViewById(R.id.sportFragRecycleView);
        sportAdapter = new newSportFragAdapter(getContext(), sportList);
        mRecyclerView.setAdapter(sportAdapter);
        mGridLayoutManager = new GridLayoutManager(getContext(), 2);
     /*   int spanCount = 3; // 3 columns
        int spacing = 50; // 50px
        boolean includeEdge = false;
        mRecyclerView.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));*/
        mRecyclerView.setLayoutManager(mGridLayoutManager);

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

