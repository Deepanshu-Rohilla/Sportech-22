package com.sportech20.iitd;

import android.content.Context;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.alespero.expandablecardview.ExpandableCardView;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.github.chrisbanes.photoview.OnPhotoTapListener;
import com.github.chrisbanes.photoview.PhotoView;
import com.sportech20.iitd.map.mapPointData;
import com.sportech20.iitd.map.mapPointRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import static com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.EASE_OUT_QUAD;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CampusMap.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CampusMap#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CampusMap extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView rvEateries, rvAtm, rvSports, rvHostels, rvGates;
    List<mapPointData> listAtm, listEateries, listSports, listHostels, listGates;
    mapPointRecyclerViewAdapter adapterAtm, adapterEateries, adapterSports, adapterHostels, adapterGates;

    private OnFragmentInteractionListener mListener;

    public CampusMap() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CampusMap.
     */
    // TODO: Rename and change types and number of parameters
    public static CampusMap newInstance(String param1, String param2) {
        CampusMap fragment = new CampusMap();
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
        final View view = inflater.inflate(R.layout.fragment_campus_map, container, false);
        // ExpandableCardView cardViewAtm = view.findViewById(R.id.atm_expandable);
        //ExpandableCardView cardViewField = view.findViewById(R.id.sports_expandable);
        // ExpandableCardView cardViewEateries = view.findViewById(R.id.eateries_expandable);

        final ExpandableCardView mRandomShit = view.findViewById(R.id.randomShit);
        final ExpandableCardView mAtm = view.findViewById(R.id.atm_expandable);
        final ExpandableCardView mEateries = view.findViewById(R.id.eateries_expandable);
        final ExpandableCardView mHostels = view.findViewById(R.id.hostels_expandable);
        final ExpandableCardView mGates = view.findViewById(R.id.gates_expandable);
        final ExpandableCardView mSport = view.findViewById(R.id.sports_expandable);

        final PinView imageView = view.findViewById(R.id.photo_view);
        imageView.setImage(ImageSource.resource(R.drawable.campus_map));

        imageView.setOnImageEventListener(new SubsamplingScaleImageView.OnImageEventListener() {
            @Override
            public void onReady() {
                Random random = new Random();
                if (imageView.isReady()) {
                    float maxScale = imageView.getMaxScale();
                    float minScale = imageView.getMinScale();
                    float scale = (random.nextFloat() * (maxScale - minScale)) + minScale;
                    PointF center = new PointF(random.nextInt(imageView.getSWidth()), random.nextInt(imageView.getSHeight()));
                    //imageView.setPin(center);

                    //Toast.makeText(getActivity(), center.x+","+center.y, Toast.LENGTH_SHORT).show();
                    SubsamplingScaleImageView.AnimationBuilder animationBuilder = imageView.animateScaleAndCenter(scale, center);
                    //animationBuilder.withDuration(2000).withEasing(EASE_OUT_QUAD).withInterruptible(false).start();


                }
            }

            @Override
            public void onImageLoaded() {

            }

            @Override
            public void onPreviewLoadError(Exception e) {

            }

            @Override
            public void onImageLoadError(Exception e) {

            }

            @Override
            public void onTileLoadError(Exception e) {

            }

            @Override
            public void onPreviewReleased() {

            }
        });


        Random random = new Random();
        if (imageView.isReady()) {
            float maxScale = imageView.getMaxScale();
            float minScale = imageView.getMinScale();
            float scale = (random.nextFloat() * (maxScale - minScale)) + minScale;
            PointF center = new PointF(random.nextInt(imageView.getSWidth()), random.nextInt(imageView.getSHeight()));
            imageView.setPin(center);
            Toast.makeText(getActivity(), center.x + "," + center.y, Toast.LENGTH_SHORT).show();
            SubsamplingScaleImageView.AnimationBuilder animationBuilder = imageView.animateScaleAndCenter(scale, center);
            animationBuilder.withDuration(2000).withEasing(EASE_OUT_QUAD).withInterruptible(false).start();

        }


        //  cardViewAtm.expand();
        mRandomShit.setVisibility(View.VISIBLE);
        mRandomShit.expand();
        // mRandomShit.collapse();
        mRandomShit.setVisibility(View.GONE);

        mRandomShit.setOnExpandedListener(new ExpandableCardView.OnExpandedListener() {
            @Override
            public void onExpandChanged(View v, boolean isExpanded) {
                rvAtm = view.findViewById(R.id.mapRecycler);
                listAtm = new ArrayList<>();
                listAtm.add(new mapPointData("GUEST HOUSE", "D5","https://maps.app.goo.gl/QLnXJDutX3ioc7nd8"));
                listAtm.add(new mapPointData("HOSTEL", "C4","https://maps.app.goo.gl/1z4ZtEyyfjVzoPTa7"));
                listAtm.add(new mapPointData("LHC", "M4","https://maps.app.goo.gl/NqRGV3dhDFSR2HES8"));
                listAtm.add(new mapPointData("MS", "K4","https://maps.app.goo.gl/Gjk4TTAy11MRDpNNALHC"));
                listAtm.add(new mapPointData("NEELKANTH", "R4","https://maps.app.goo.gl/NqRGV3dhDFSR2HES8UDAIGIRI"));
                listAtm.add(new mapPointData("SDA", "O1","https://maps.app.goo.gl/wxGvMnfrH7wFQsoS6"));
                listAtm.add(new mapPointData("UDAIGIRI", "H2","https://maps.app.goo.gl/YmUUNRYwkczQPU6a9"));
                adapterAtm = new mapPointRecyclerViewAdapter(listAtm, getContext());
                rvAtm.setLayoutManager(new LinearLayoutManager(getContext()));
                rvAtm.setAdapter(adapterAtm);

                rvEateries = view.findViewById(R.id.mapRecyclerEateries);
                listEateries = new ArrayList<>();
                listEateries.add(new mapPointData("CANTEEN", "K4","https://maps.google.com/?cid=7843688973958757659"));
                listEateries.add(new mapPointData("CCD", "L3","https://maps.app.goo.gl/1hBkB6QrBdvyNwJb8"));
                listEateries.add(new mapPointData("LIPTON, AMUL", "K4","https://maps.app.goo.gl/P39fZe4CXyiK9mkS7"));
                listEateries.add(new mapPointData("MOTHER DAIRY", "R3, C2","https://maps.app.goo.gl/BduWhJ8MWCzwt2Tz5"));
                listEateries.add(new mapPointData("NESCI, HPMC", "K4","https://maps.app.goo.gl/iLZm5oizVZbbmFku7"));
                listEateries.add(new mapPointData("SASSI", "B1","https://maps.app.goo.gl/iMndDNgCwxtuKy5E7"));
                listEateries.add(new mapPointData("SDA", "O1","https://maps.google.com/?cid=4187517067883292826"));
                listEateries.add(new mapPointData("TEA HALT", "M4, B4, C2","https://maps.app.goo.gl/mrWj7mXhFuZkuwdY8"));
                listEateries.add(new mapPointData("MASALA MIX", "F3","https://maps.app.goo.gl/AvTGMW63za8SKddZ9"));
                listEateries.add(new mapPointData("RAJDHANI", "C2","https://maps.google.com/?cid=11168387476863498914"));
                adapterEateries = new mapPointRecyclerViewAdapter(listEateries, getContext());
                rvEateries.setLayoutManager(new LinearLayoutManager(getContext()));
                rvEateries.setAdapter(adapterEateries);

                rvSports = view.findViewById(R.id.mapRecyclerSports);
                listSports = new ArrayList<>();
                listSports.add(new mapPointData("BASKETBALL", "H4","https://maps.app.goo.gl/b5q7ghC7qDYnZmwf7"));
                listSports.add(new mapPointData("ATHLETICS", "I5","https://maps.app.goo.gl/phGnKCgoUXtX2CL67"));
                listSports.add(new mapPointData("HOCKEY", "J5","https://maps.app.goo.gl/XEc5z3UxHaFPmWsp6"));
                listSports.add(new mapPointData("LAWN TENNIS", "C3","https://maps.app.goo.gl/fKnjfw9hi1wSrNvV6"));
                listSports.add(new mapPointData("VOLLEYBALL", "C2","https://maps.app.goo.gl/eoiKvQ6vFAPNyk3U6"));
                listSports.add(new mapPointData("Student Activity Center", "E4","https://maps.app.goo.gl/YgmP6aZ8EKMa5Hpy8"));
                listSports.add(new mapPointData("FOOTBALL", "G4","https://maps.app.goo.gl/o7UBF8EkyURd8X2g7"));
                listSports.add(new mapPointData("CRICKET", "H5","https://maps.app.goo.gl/xaSVD16mjAL6By3P6"));
                adapterSports = new mapPointRecyclerViewAdapter(listSports, getContext());
                rvSports.setLayoutManager(new LinearLayoutManager(getContext()));
                rvSports.setAdapter(adapterSports);

                rvHostels = view.findViewById(R.id.mapRecyclerHostel);
                listHostels = new ArrayList<>();
                listHostels.add(new mapPointData("ARAVALI", "B3","https://maps.app.goo.gl/jj7diMptKrx67pxFA"));
                listHostels.add(new mapPointData("GIRNAR", "H2","https://maps.app.goo.gl/iqxuCzaMLiVY7EEt9"));
                listHostels.add(new mapPointData("HIMADRI", "O2","https://maps.app.goo.gl/rgeCipuDC1izgBDw8"));
                listHostels.add(new mapPointData("JWALAMUKHI", "C1","https://maps.app.goo.gl/SF7ozvu1totTnGdY7"));
                listHostels.add(new mapPointData("KAILASH", "O2","https://maps.app.goo.gl/vE8pETSwLbF44Fw7A"));
                listHostels.add(new mapPointData("KARAKORAM", "B3","https://maps.app.goo.gl/WQDhHZ4EFfezPAuN6"));
                listHostels.add(new mapPointData("KUMAON", "D2","https://maps.app.goo.gl/KCuGLGBjigcGX31Z9"));
                listHostels.add(new mapPointData("NILGIRI", "B4","https://maps.app.goo.gl/vnMBZsnrsUKGnaJ9A"));
                listHostels.add(new mapPointData("SATPURA", "F2","https://maps.app.goo.gl/ui6mZp7y2GfCEoLG9"));
                listHostels.add(new mapPointData("SHIVALIK", "E3","https://maps.app.goo.gl/gbkP7gHWHDSTcYN39"));
                listHostels.add(new mapPointData("UDAIGIRI", "H2","https://maps.app.goo.gl/xCd4eBDbEDdgCrzu5"));
                listHostels.add(new mapPointData("VINDHYANCHAL", "E2","https://maps.app.goo.gl/A2VT75GjZFTQ8cvc7"));
                listHostels.add(new mapPointData("ZANSKAR", "F3","https://maps.app.goo.gl/dX91NuRgke1WDnn67"));
                adapterHostels = new mapPointRecyclerViewAdapter(listHostels, getContext());
                rvHostels.setLayoutManager(new LinearLayoutManager(getContext()));
                rvHostels.setAdapter(adapterHostels);

                rvGates = view.findViewById(R.id.mapRecyclerGates);
                listGates = new ArrayList<>();
                listGates.add(new mapPointData("ADHCHINI GATE", "S6","https://maps.app.goo.gl/u1uzjUpJaSDANMs16"));
                listGates.add(new mapPointData("BOYS HOSTEL GATE", "C1","https://maps.app.goo.gl/yMi5ukCLTSdp34vVA"));
                listGates.add(new mapPointData("JIA SARAI GATE", "H3"));
                listGates.add(new mapPointData("JNU GATE", "A5","https://maps.app.goo.gl/XjXzQaeywD2pLPBS9"));
                listGates.add(new mapPointData("MAIN GATE", "O1","https://maps.app.goo.gl/wBpADrkYenHtAyQv7"));
                listGates.add(new mapPointData("MEHRAULI GATE", "S3","https://maps.app.goo.gl/1GMbF2ZjULxf7nyg7"));
                adapterGates = new mapPointRecyclerViewAdapter(listGates, getContext());
                rvGates.setLayoutManager(new LinearLayoutManager(getContext()));
                rvGates.setAdapter(adapterGates);


            }
        });

        mAtm.setOnExpandedListener(new ExpandableCardView.OnExpandedListener() {
            @Override
            public void onExpandChanged(View v, boolean isExpanded) {
                if (isExpanded) {
                    if (mSport.isExpanded()) {
                        mSport.collapse();
                    }
                    if (mGates.isExpanded()) {
                        mGates.collapse();
                    }
                    if (mEateries.isExpanded()) {
                        mEateries.collapse();
                    }
                    if (mHostels.isExpanded()) {
                        mHostels.collapse();
                    }


                }
            }
        });

        mEateries.setOnExpandedListener(new ExpandableCardView.OnExpandedListener() {
            @Override
            public void onExpandChanged(View v, boolean isExpanded) {
                if (isExpanded) {
                    if (mSport.isExpanded()) {
                        mSport.collapse();
                    }
                    if (mGates.isExpanded()) {
                        mGates.collapse();
                    }

                    if (mHostels.isExpanded()) {
                        mHostels.collapse();
                    }
                    if (mAtm.isExpanded()) {
                        mAtm.collapse();
                    }
                }
            }
        });

        mGates.setOnExpandedListener(new ExpandableCardView.OnExpandedListener() {
            @Override
            public void onExpandChanged(View v, boolean isExpanded) {
                if (isExpanded) {
                    if (mSport.isExpanded()) {
                        mSport.collapse();
                    }

                    if (mEateries.isExpanded()) {
                        mEateries.collapse();
                    }
                    if (mHostels.isExpanded()) {
                        mHostels.collapse();
                    }
                    if (mAtm.isExpanded()) {
                        mAtm.collapse();
                    }
                }
            }
        });

        mHostels.setOnExpandedListener(new ExpandableCardView.OnExpandedListener() {
            @Override
            public void onExpandChanged(View v, boolean isExpanded) {
                if (isExpanded) {
                    if (mSport.isExpanded()) {
                        mSport.collapse();
                    }
                    if (mGates.isExpanded()) {
                        mGates.collapse();
                    }
                    if (mEateries.isExpanded()) {
                        mEateries.collapse();
                    }

                    if (mAtm.isExpanded()) {
                        mAtm.collapse();
                    }

                }
            }
        });

        mSport.setOnExpandedListener(new ExpandableCardView.OnExpandedListener() {
            @Override
            public void onExpandChanged(View v, boolean isExpanded) {
                if (isExpanded) {

                    if (mGates.isExpanded()) {
                        mGates.collapse();
                    }
                    if (mEateries.isExpanded()) {
                        mEateries.collapse();
                    }
                    if (mHostels.isExpanded()) {
                        mHostels.collapse();
                    }
                    if (mAtm.isExpanded()) {
                        mAtm.collapse();
                    }

                }
            }
        });






/*
        final PhotoView photoView = (PhotoView) view.findViewById(R.id.photo_view);
        photoView.setImageResource(R.drawable.campus_map_hor);
        photoView.getImageMatrix().mapPoints(new float[]{3f, 4f});
        photoView.setOnPhotoTapListener(new OnPhotoTapListener() {
            @Override
            public void onPhotoTap(ImageView view, float x, float y) {
                Toast.makeText(getActivity(), x+""+y, Toast.LENGTH_SHORT).show();
                photoView.setScale(1.1f,x*100,y,true);
            }
        });
*/


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
