package com.gmail.peeman34.eglisaofficial;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import java.util.Calendar;

/**
 * Created by pee on 8/5/2016.
 */

public class PickerDialog extends DialogFragment
{
    public PickerDialog() {
        super();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

       DateSettings dateSettings = new DateSettings(getActivity());
        Calendar calender = Calendar.getInstance();
        int year = calender.get(Calendar.YEAR);
        int month = calender.get(Calendar.MONTH);
        int day = calender.get(Calendar.DAY_OF_YEAR);
        DatePickerDialog dialog;
        dialog = new DatePickerDialog(getActivity(),dateSettings, year, month,day);

         return dialog;


    }

    public void show(FragmentManager supportFragmentManager, String date_picker) {
    }
}
