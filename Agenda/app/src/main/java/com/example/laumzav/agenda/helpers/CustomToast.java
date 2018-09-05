package com.example.laumzav.agenda.helpers;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

public class CustomToast {

    public void makeMessage(Context context, String message){
        Toast toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.BOTTOM, 0, 36);
        toast.show();
    }

}
