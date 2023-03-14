package com.coka.progressdialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class CustomProgressDialog extends Dialog {
    public CustomProgressDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        ImageView imageView=findViewById(R.id.spinnerImageView);
        imageView.setBackgroundResource(R.drawable.spinner);
        AnimationDrawable spinner= (AnimationDrawable) imageView.getBackground();
        spinner.start();
    }
    public static CustomProgressDialog show(Context context,CharSequence message,boolean cancelable,OnCancelListener cancelListener){
        CustomProgressDialog dialog=new CustomProgressDialog(context,R.style.custom_progress);
        dialog.setTitle("");
        dialog.setContentView(R.layout.custom_progress_dialog);
        if (message==null||message.length()==0){
            dialog.findViewById(R.id.tvMessage).setVisibility(View.GONE);
        }else {
            TextView tvMessage=dialog.findViewById(R.id.tvMessage);
            tvMessage.setText(message);
        }
        dialog.setCancelable(cancelable);
        dialog.setOnCancelListener(cancelListener);
        dialog.getWindow().getAttributes().gravity = Gravity.CENTER;
        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
        lp.dimAmount = 0.2f;
        dialog.getWindow().setAttributes(lp);
        dialog.show();
        return dialog;
    }
}
