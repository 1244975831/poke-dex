package cn.edu.zucc.pb.listfragmentexample.Other;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import cn.edu.zucc.pb.listfragmentexample.R;


public class DatePickerFragment extends DialogFragment {
    public static final String EXTRA_DATE = "cn.edu.zucc.pb.extra_date";
    private Date date;

    public static DatePickerFragment newInstance(Date date){
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_DATE, date);

        DatePickerFragment fragment = new DatePickerFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_datepicker_layout, null);

        date = (Date)getArguments().getSerializable(EXTRA_DATE);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePicker datePicker = (DatePicker) view.findViewById(R.id.dialog_date_datePicker);
        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                date = new GregorianCalendar(year, monthOfYear, dayOfMonth).getTime();
                //save for rebuild the dialog(such as landscape to portrait
                getArguments().putSerializable(EXTRA_DATE, date);
            }
        });
        return new AlertDialog.Builder(getActivity())
                .setTitle(R.string.date_picker_title)
                .setView(view)
                .setPositiveButton(
                        android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (getTargetFragment() == null) {
                                    return;
                                }
                                Intent i = new Intent();
                                i.putExtra(EXTRA_DATE, date);
                                getTargetFragment().onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, i);
                            }
                        }

                )
                .create();
    }

//    @Override
//    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        return new AlertDialog.Builder(getActivity())
//                .setTitle(R.string.date_picker_title)
//                .setPositiveButton(
//                        android.R.string.ok,
//                        null
//                )
//                .create();
//    }
}
