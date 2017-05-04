/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.awt.geom.Point2D;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import maps.java.Geocoding;
import maps.java.MapsJava;
import maps.java.Places;
import maps.java.Route;
import modelo.Lugares;
import modelo.Ubicacion;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import static utilities.LugaresDAO.error;

/**
 *
 * @author admin
 */
public class Lugares2DAO {

    private static WebApplicationContext context;
    Places ObjPlaces = new Places();
    Ubicacion ObjUbicacion = new Ubicacion();
    String[][] resultadoPlaces;
    private double fov = 0.0;
    Route ObjRuta = new Route();
    String[][] resultadoRuta;
    ArrayList<String> localesComida = new ArrayList<>();

    public Lugares2DAO() {

        
    }

    private static void iniciar() {

        try {
            ServletContext sc = ServletActionContext.getServletContext();
            context = WebApplicationContextUtils.getRequiredWebApplicationContext(sc);
        } catch (Throwable e) {
            System.out.println("*****fallo de inicializacion****)");
            throw new ExceptionInInitializerError(e);
        }
    }

    public static WebApplicationContext getWebApplicationContext() {
        iniciar();
        return context;

    }

    public String[][] getResultadoPlaces() {
        return resultadoPlaces;
    }

    public void setResultadoPlaces(String[][] resultadoPlaces) {
        this.resultadoPlaces = resultadoPlaces;
    }

    public static ArrayList<Lugares> buscarLocales(String ZonaSalida)  {

        MapsJava.setKey("AIzaSyDVMXmApLq3pv_tVPwqK5omqwTfNml2bT0");
        String key = "AIzaSyDVMXmApLq3pv_tVPwqK5omqwTfNml2bT0";
        MapsJava.APIkeyCheck(key);
        System.out.println(MapsJava.APIkeyCheck(key));
        Geocoding ObjGeocod = new Geocoding();
        Point2D.Double resultadoCD = null;
        try {
            resultadoCD = ObjGeocod.getCoordinates(ZonaSalida);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Lugares2DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Lugares2DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Lugares> lugares = new ArrayList<Lugares>();
        Ubicacion ObjUbicacion2 = new Ubicacion(resultadoCD.x, resultadoCD.y);
        Places ObjPlace = new Places();
        try {
            ArrayList<String> localesComida = new ArrayList<>();
            localesComida.add("food");
            String[][] resultado = ObjPlace.getPlaces(ObjUbicacion2.getLatitud(), ObjUbicacion2.getLongitud(),
                    300000, "", "", Places.Rankby.distance,    localesComida);

            for (int i = 0; i < resultado.length; i++) {
                System.out.println("Place " + i + ":");

                System.out.print(resultado[i][0] + "\t");
                System.out.print(resultado[i][1] + "\t");
                System.out.print(resultado[i][2] + "\t");
                System.out.print(resultado[i][3] + "\t");
                System.out.print(resultado[i][4] + "\t");
                String tramo = "Lugar " + i + ":" + "</br>";
                String nombre = resultado[i][0];
                String calle = resultado[i][1];
                double longitud = Double.parseDouble(resultado[i][2]);
                double latitud = Double.parseDouble(resultado[i][3]);

                Lugares l1 = new Lugares(nombre, calle, longitud, latitud);
                lugares.add(l1);

                //  Lugares l1= new Lugares( resultado[i][0]);
                //  lugares.add(l1);
                System.out.println("");
            }
        } catch (Exception e) {
            error("Place");
        }

        return lugares;
    }

    public static void main(String ar[]) throws Exception {
       
Lugares2DAO.buscarLocales("Puerta del sol");
      

    }
}
