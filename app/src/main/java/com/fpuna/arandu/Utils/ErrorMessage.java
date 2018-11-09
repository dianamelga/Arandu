package com.fpuna.arandu.Utils;

import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import javax.net.ssl.SSLException;

public class ErrorMessage {

    public String get(Throwable throwable) {
        String mensaje = throwable.getMessage();
        if(throwable instanceof ConnectException ||
                throwable.getMessage().contains("EHOSTUNREACH"))  {
            mensaje = "Servidor no disponible.";
        }else if(throwable instanceof SocketTimeoutException)  {
            if (throwable.getMessage() != null) {
                if (throwable.getMessage().contains("failed to connect to") ||
                        throwable instanceof SSLException ||
                        throwable instanceof UnknownHostException) {
                    mensaje = "Sin conexión.";
                }
            }else {
                mensaje = "El servidor tardó mucho en responder.";
            }
        }else if(throwable instanceof SocketException) {
            if (throwable.getMessage() != null){
                if (throwable.getMessage().contains("ECONNREFUSED") ||
                        throwable.getMessage().contains("refused")){
                    mensaje = "Servicio no disponible";
                }
            }
        }

        return mensaje;
    }


}
