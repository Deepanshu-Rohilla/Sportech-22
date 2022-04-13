package com.sportech20.iitd.newSportFragment;

import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sportech20.iitd.Constants;
import com.sportech20.iitd.MainActivity;
import com.sportech20.iitd.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link newSportsFrag.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link newSportsFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class newSportsFrag extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private RecyclerView mRecyclerView;
    private GridLayoutManager mGridLayoutManager;
    private List<sportFragData> sportList;
    private newSportFragAdapter sportAdapter;

    public newSportsFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment newSportsFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static newSportsFrag newInstance(String param1, String param2) {
        newSportsFrag fragment = new newSportsFrag();
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
        View view = inflater.inflate(R.layout.fragment_new_sports, container, false);


        sportList = new ArrayList<>();
        sportList.add(new sportFragData(Constants.allSportsname[0], R.drawable.ic_running, false));
        sportList.add(new sportFragData(Constants.allSportsname[3], R.drawable.ic_chess_piece, false));
        sportList.add(new sportFragData(Constants.allSportsname[4], R.drawable.ic_cricket, false));
        sportList.add(new sportFragData(Constants.allSportsname[5], R.drawable.ic_football, false));
        sportList.add(new sportFragData(Constants.allSportsname[6], R.drawable.ic_hockey, false));
        sportList.add(new sportFragData(Constants.allSportsname[7], R.drawable.ic_squash, false));
        sportList.add(new sportFragData(Constants.allSportsname[1], R.drawable.ic_badminton, false));
        sportList.add(new sportFragData(Constants.allSportsname[2], R.drawable.ic_basketball, false));
        sportList.add(new sportFragData(Constants.allSportsname[8], R.drawable.ic_tennis, false));
        sportList.add(new sportFragData(Constants.allSportsname[9], R.drawable.ic_ping_pong, false));
        sportList.add(new sportFragData(Constants.allSportsname[10], R.drawable.ic_volleyball, false));
        //sportList.add(new sportFragData(Constants.allSportsname[11], R.drawable.ic_gym, false));

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

 /*class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

    private int spanCount;
    private int spacing;
    private boolean includeEdge;

    public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
        this.spanCount = spanCount;
        this.spacing = spacing;
        this.includeEdge = includeEdge;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view); // item position
        int column = position % spanCount; // item column

        if (includeEdge) {
            outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
            outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

            if (position < spanCount) { // top edge
                outRect.top = spacing;
            }
            outRect.bottom = spacing; // item bottom
        } else {
            outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
            outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
            if (position >= spanCount) {
                outRect.top = spacing; // item top
            }
        }
    }
}
*/