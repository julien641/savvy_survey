package com.savvy.savvy_survey;

import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Form_Frag.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Form_Frag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Form_Frag extends Base_frag {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    String timeStamp="";
    private OnFragmentInteractionListener mListener;

    public void onBackPressed() {

    }
    public Form_Frag() {
        // Required empty public constructor
    }
    public static Form_Frag newInstance(int fragid, int layoutid) {
        Form_Frag fragment = new Form_Frag();
        Bundle args = new Bundle();
        args.putInt(fragment.getSfragid(), fragid);
        args.putInt(fragment.getslayoutid(), layoutid);
        fragment.setArguments(args);
        return fragment;
    }

    public View settingupspinnerscalls_frag1(View view){
        Get_spinner_Data inspector = new Get_spinner_Data(
                    "",
                    "http://192.155.88.98:8080/getinspectorname",
                    "POST",
                    getActivity().getApplicationContext(),
                (Spinner) view.findViewById(R.id.inspectors),
                    R.layout.spinner_item,
                "Inspector_name"

            );
            inspector.execute();
        Get_spinner_Data size = new Get_spinner_Data(
                "",
                "http://192.155.88.98:8080/getsize",
                "POST",
                getActivity().getApplicationContext(),
                (Spinner) view.findViewById(R.id.unit_size),
                R.layout.spinner_item
                ,
                "Apartment_size"
        );
        size.execute();
        Get_spinner_Data location = new Get_spinner_Data("",
                "http://192.155.88.98:8080/getlocation",
                "POST",
                getActivity().getApplicationContext(),
                (Spinner) view.findViewById(R.id.Location),
                R.layout.spinner_item,
                "Location_name"

        );
        location.execute();

        return view;
    }
    public View setupfrag1(View view){

        timeStamp = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss")
                .format(Calendar.getInstance()
                        .getTime());
        TextView time  =(TextView) view.findViewById(R.id.begtime);
        time.setText(timeStamp);

        view=settingupspinnerscalls_frag1(view);

        return view;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater,container,savedInstanceState);
        // Inflate the layout for this fragment
        int frag_id=super.getArgfragid();
        switch(frag_id){
            case 0:
                setupfrag1(view);
                break;
            case 1:
                getData();
                setupfrag2(view,R.id.radio_liv_din);
                break;
            case 2:

                break;

        }

        return view;
    }
   public void getData(){





    }
public void setupfrag2(View view,int layout){



        settingupcheckbox(view,layout);
}



    public View settingupcheckbox( View view,int layout){

        ToggleButton toggleButton =(ToggleButton)view.findViewById(R.id.liv_din_radio);
        toggleButton.setOnCheckedChangeListener(new disabled_button(view,layout));

        RadioGroup notouch=(RadioGroup)view.findViewById(R.id.radio_liv_din);
        //notouch.setOnCheckedChangeListener(this);

        /*
        if(((CheckBox)view.findViewById(R.id.liv_din_check13)).isChecked()){



        }
*/
        return view;
    }
    public View setTimeStamp(View v){
        TextView time  =(TextView) v.findViewById(R.id.begtime);
        if(time!=null) {
            timeStamp = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss").format(Calendar.getInstance().getTime());
            time.setText(timeStamp);
        }
        return v;
    }
    /**
     * Could handle back press.
     * @return true if back press was handled
     */

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