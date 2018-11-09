package ca.cuanti.javautilpy.helpers.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Ivan Fretes
 * @email  <vanfretes@gmail.com> 
 * @link   http://www.cuanti.ca
 */

public class UrlGetRequest {
    String URLParam;
    
    public UrlGetRequest(String URLParam) {
        this.URLParam = URLParam;
    }
    
    public void setHeaders(){
        // No Implementado
    }
    
    
    public void customMsgErro(){
        // No Implementado
    }
    
    /**
     * Retorna el contenido encontrado en las URL Serializado
     * 
     * @return String or null
     */
    public String get() throws Exception{

            URL url = new URL(this.URLParam); 
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                                    + conn.getResponseCode());
            }

            StringBuilder sb = new StringBuilder();

            BufferedReader br = new BufferedReader(
                    new InputStreamReader((conn.getInputStream()))
            );

            String lineString;
            while ((lineString = br.readLine()) != null){
                sb.append(lineString);
            }
            
            conn.disconnect();
            return sb.toString();

    }
}
