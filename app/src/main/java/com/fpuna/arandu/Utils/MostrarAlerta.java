package com.fpuna.arandu.Utils;


import android.content.Context;
import android.content.DialogInterface;

import android.support.v7.app.AlertDialog;






 public  class MostrarAlerta {

    public static void mensaje(Context context, String mensaje){
        AlertDialog.Builder builder =
                new AlertDialog.Builder(context);

        builder.setMessage("")
                .setTitle("Información")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.setMessage(mensaje);
        alertDialog.show();

    }

    public static void mensaje (final Context context, Throwable e){
         final String masInfo = e.getMessage();
         //masInfo = appExceptionLog(context,e);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Información");
        builder.setMessage(e.getMessage());

        builder.setPositiveButton("Aceptar",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                return;
            }
        });

        builder.setNegativeButton("Más información", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                mensaje(context,masInfo);
            }
        });

        builder.show();


    }





}
