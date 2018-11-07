
package ca.cuanti.javautilpy.helpers.json;


import com.google.gson.Gson;
import java.util.Arrays;
import java.util.List;

import ca.cuanti.javautilpy.helpers.url.UrlGetRequest;


/**
 *
 * @author Ivan Fretes
 * @email  <vanfretes@gmail.com> 
 * @link   http://www.cuanti.ca
 */


public class GJsonDecoder<T> {
    
    /**
     *
     * @param <T>
     * @param url - Link de los datos a consumir
     * @param  clazz - Clase[].class como parametro
     * 
     * @return Listado de elementos
     */
    public static <T> List<T> getArrayGJson(String url, Class<T[]> clazz){
       String json = new UrlGetRequest(url).get();
       T[] arr = new Gson().fromJson(json, clazz);
       
       return Arrays.asList(arr);
    }
    
    
    /**
     * 
     * @param <T>
     * @param url - Link de los datos a consumir
     * @param clazz - Clase.class
     * @return - Objeto Deserializado
     */
    public static <T> T getObjectGJson(String url, Class<T> clazz){
        String json = new UrlGetRequest(url).get();
        T data = new Gson().fromJson(json, clazz);
        return data;
    }

  
 
}   

