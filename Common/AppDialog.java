package com.enliteprovision.commons;

import android.content.Context;
import android.content.DialogInterface;
import android.view.Window;

import com.enliteprovision.R;

import androidx.appcompat.app.AlertDialog;


public class AppDialog {
    static AlertDialog dialog;

    public static AlertDialog showNoNetworkDialog(Context context) {
        if (dialog != null) {
            dialog.dismiss();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(context.getString(R.string.msg_no_network));
        builder.setCancelable(true);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        dialog = builder.create();
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.show();
        return dialog;
    }

    public static AlertDialog showAlertDialog(Context context, String msg) {
        if (dialog != null) {
            dialog.dismiss();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(msg);
        builder.setCancelable(true);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        dialog = builder.create();
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.show();
        return dialog;
    }

    public static AlertDialog showConfirmDialog(Context context, String msg,
                                                final AppDialogListener listener, boolean isShowCancel) {
        if (dialog != null) {
            dialog.dismiss();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(msg);
        builder.setCancelable(true);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (listener != null) {
                    listener.okClick(dialog);
                } else {
                    dialog.dismiss();
                }
            }
        });

        if (isShowCancel) {
            builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
        }
        dialog = builder.create();
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.show();
        return dialog;
    }


    public interface AppDialogListener {
        public void okClick(DialogInterface dialog);
    }

}