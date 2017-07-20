package com.example.deandrewmoore.healthmate;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import static android.R.id.message;

/**
 * Created by Deandrew Moore on 15/7/2017.
 */

public class Message {
    public static void message(Context context, String message)
    {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

}
