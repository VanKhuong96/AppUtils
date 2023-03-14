package com.coka.progressdialog;

import android.app.Activity;
import android.content.Context;

public class ProgressDialogHolder {
    private CustomProgressDialog customProgressDialog;
    private static ProgressDialogHolder instance;
    private Context mContext;

    public ProgressDialogHolder(Context context) {
        this.mContext = context;
    }

    public static ProgressDialogHolder getInstance(Activity activity) {
        if (instance == null || instance.mContext != activity) {
            instance = new ProgressDialogHolder(activity);
        }
        return instance;
    }

    public void showDialog(String message) {
        if (customProgressDialog != null) {
            if (customProgressDialog.isShowing()) {
                return;
            }
            customProgressDialog.show();
            return;
        }
        customProgressDialog = CustomProgressDialog.show(mContext, message, false, null);
    }

    public void dismissDialog() {
        if (customProgressDialog != null) {
            customProgressDialog.dismiss();
        }
    }


}
