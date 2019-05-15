package com.example.jose.remme.Utils;

import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.jose.remme.R;

import org.w3c.dom.Text;

/**
 * Created by Jose on 13/02/2019.
 */

public class Utils {


    public static Dialog generateScrollTextDialog (final Dialog dialog, int width, int height, String title, String message){

        TextView btn_ok;
        TextView dialog_title;
        TextView dialog_message;

        dialog.setContentView(R.layout.dialog_info_login);

        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();

        lp.width = width; // Width
        lp.height = height; // Height

        dialogWindow.setAttributes(lp);

        //Inflate Views
        btn_ok = dialog.findViewById(R.id.btn_close_dialog);
        dialog_message = dialog.findViewById(R.id.dialog_message);
        dialog_title = dialog.findViewById(R.id.dialog_title);

        dialog_message.setText(message);
        dialog_title.setText(title);
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        return dialog;
    }
}


