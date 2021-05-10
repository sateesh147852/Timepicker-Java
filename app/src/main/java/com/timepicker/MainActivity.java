package com.timepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.timepicker.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements TimePickerDialogFragment.OnTimeSelected {

    private ActivityMainBinding binding;
    private TimePickerDialogFragment dialogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initialize();
    }

    private void initialize(){
        dialogFragment = new TimePickerDialogFragment(this);
        binding.tvTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogFragment.show(getSupportFragmentManager(),"TimePicker");
            }
        });
    }

    @Override
    public void onTimeSelected(int hourOfDay, int minute) {
        Toast.makeText(this, hourOfDay + " "+minute, Toast.LENGTH_SHORT).show();
    }
}