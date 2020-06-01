package layout;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ToggleButton;

import com.savvy.savvy_survey.R;
import com.savvy.savvy_survey.form;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link form_frag_4.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link form_frag_4#newInstance} factory method to
 * create an instance of this fragment.
 */

public class form_frag_4 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public void onBackPressed() {

    }
    public form_frag_4() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment form_frag_4.
     */
    // TODO: Rename and change types and number of parameters
    public static form_frag_4 newInstance(String param1, String param2) {
        form_frag_4 fragment = new form_frag_4();
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
    public View settingupcheckbox(final View view){

        ToggleButton toggleButton =(ToggleButton)view.findViewById(R.id.entrence_toggle);
        toggleButton.setOnCheckedChangeListener(new ToggleButton.OnCheckedChangeListener(){


        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked==true){
                disable(false);


            }
            if(isChecked==false){
                disable(true);


            }
        }public void disable(boolean bool){

            view.findViewById(R.id.Laundryroom_check1).setEnabled(bool);
            view.findViewById(R.id.Laundryroom_check2).setEnabled(bool);
            view.findViewById(R.id.Laundryroom_check3).setEnabled(bool);
            view.findViewById(R.id.Laundryroom_check4).setEnabled(bool);
            view.findViewById(R.id.Laundryroom_check5).setEnabled(bool);



        }
    }
        );

        return view;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_form_frag_4, container, false);
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
       // ((Formactivity)getActivity()).setnextbuttonid(4);
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
    public void getallinfo(form savvy){
        String RCSTRING = "";
        ArrayList<String> rc= new ArrayList<>();
        //remove
        EditText editText=getView().findViewById(R.id.Laundryroom_edit1);
        ToggleButton tog=(ToggleButton)getView().findViewById(R.id.Laundryroom_toggle);

        if(!tog.isChecked()){
            CheckBox checkbox[] = new CheckBox[12];
            checkbox[0] = (CheckBox) getView().findViewById(R.id.Laundryroom_check1);
            checkbox[1] = (CheckBox) getView().findViewById(R.id.Laundryroom_check2);
            checkbox[2] = (CheckBox) getView().findViewById(R.id.Laundryroom_check3);
            checkbox[3] = (CheckBox) getView().findViewById(R.id.Laundryroom_check4);
            checkbox[4] = (CheckBox) getView().findViewById(R.id.Laundryroom_check5);


            for (int i = 0; i < checkbox.length;i++) {
                if(checkbox[i].isChecked()) {
                    rc.add(checkbox[i].getText().toString());
                }
            }
            if(!editText.getText().toString().isEmpty()){

                rc.add(editText.getText().toString());

            }
        }else{
            if(rc.size()==0){
                rc.add("No touch ups needed");

            }

            rc.add("No touch ups needed");
        }

        savvy.setLaundryroom(rc.toArray(new String[rc.size()]));


    }
}
