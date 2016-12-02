package com.example.george.test_aegean_app;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link WinterFragPage.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link WinterFragPage#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WinterFragPage extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private ListView holidayscal = null;
    private String []  WinterGeneral = {"Έναρξη/Λήξη Μαθημάτων\n03/10/2016 - 20/01/2017","Περίοδος Ειδικών αναγκών και εξεταστικής\n23/01/2017 - 17/02/2017","Εθνικη Εορτή\n28/10/2016","Επέτειος Πολυτεχνείου\n17/11/2016","Διακοπές Χριστουγέννων\n22/12/2016 - 06/01/2017","Τριών Ιεραρχών\n30/01/2017"};
    private OnFragmentInteractionListener mListener ;

    public WinterFragPage() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WinterFragPage.
     */
    // TODO: Rename and change types and number of parameters
    public static WinterFragPage newInstance(String param1, String param2) {
        WinterFragPage fragment = new WinterFragPage();
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

        View view =  inflater.inflate(R.layout.fragment_winter_frag_page, container, false);
        ListView generalCal = (ListView) view.findViewById(R.id.winterGenCal);
        ArrayAdapter generalCalAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, WinterGeneral);

        generalCal.setAdapter(generalCalAdapter);


        return view;
        /*
        *       View rootView = inflater.inflate(R.layout.fragment_academaic_calendar_page, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        * */
        //Filling the two List Views

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
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
