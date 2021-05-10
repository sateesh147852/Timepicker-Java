package com.timepicker;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class TimePickerDialogFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    private OnTimeSelected onTimeSelected;
    private Calendar calendar;

    public TimePickerDialogFragment(OnTimeSelected onTimeSelected){
        this.onTimeSelected = onTimeSelected;
        calendar = Calendar.getInstance();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new TimePickerDialog(getContext(),this,calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),false);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        onTimeSelected.onTimeSelected(hourOfDay,minute);
    }

    interface OnTimeSelected{
        void onTimeSelected(int hourOfDay, int minute);
    }
}
