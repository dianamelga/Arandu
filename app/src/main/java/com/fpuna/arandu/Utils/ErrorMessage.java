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
                throwable instanceof  UnknownHostException  ||
                throwable instanceof SSLException) {
                if(throwable.getMessage() != null) {
                    if (throwable.getMessage().contains("EHOSTUNREACH") ||
                            throwable.getMessage().contains("Unable to resolve host")) {
                        mensaje = "Servidor no disponible.";
                    }
                }
        }else if(throwable instanceof SocketTimeoutException)  {
            if (throwable.getMessage() != null) {
                if (throwable.getMessage().contains("failed to connect to")) {
                    mensaje = "Sin conexión.";
                }
            }
            mensaje = "El servidor tardó mucho en responder.";

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
