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

    public static EntityManagerFactory getEntityManagerFactory() {
        Map properties = new HashMap();
        properties.put("javax.persistence.jdbc.user", "root");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaProyectoMapsPU", properties);

        return emf;
    }

    /*prueba con id 1*/
//    public static float mostrarLatitud() {
//        float latitud;
//        EntityManagerFactory emf = getEntityManagerFactory();
//        EntityManager em = emf.createEntityManager();
//
//        EntityTransaction trx = em.getTransaction();
//        trx.begin();
//
//        String hsql = "SELECT c FROM Lugares c where c.id=1";
//        Query query = em.createQuery(hsql);
//        Lugares lugares = (Lugares) query.getSingleResult();
//        latitud = lugares.getLatitud();
//
//        em.close();
//        emf.close();
//        return latitud;
//    }
//
//    /*prueba con id sdasdadasdasdasdas*/
//    public static float mostrarLongitud() {
//        float longitud;
//        EntityManagerFactory emf = getEntityManagerFactory();
//        EntityManager em = emf.createEntityManager();
//
//        EntityTransaction trx = em.getTransaction();
//        trx.begin();
//
//        String hsql = "SELECT c FROM Lugares c where c.id=1";
//
//        Query query = em.createQuery(hsql);
//        //List<Lugares> list = query.getResultList();
//        Lugares lugares = (Lugares) query.getSingleResult();
//        longitud = lugares.getLongitud();
//
//        em.close();
//        emf.close();
//        return longitud;
//    }

    public String[][] getResultadoPlaces() {
        return resultadoPlaces;
    }

    public void setResultadoPlaces(String[][] resultadoPlaces) {
        this.resultadoPlaces = resultadoPlaces;
    }

    public static ArrayList<Lugares> buscarLocalesLugareses(String zonaSalida) {
        MapsJava.setKey("AIzaSyDVMXmApLq3pv_tVPwqK5omqwTfNml2bT0");
        String key = "AIzaSyDVMXmApLq3pv_tVPwqK5omqwTfNml2bT0";
        MapsJava.APIkeyCheck(key);
        System.out.println(MapsJava.APIkeyCheck(key));
          Geocoding ObjGeocod = new Geocoding();
 Point2D.Double resultadoCD = null;
 ArrayList<Lugares> lugares= new ArrayList<Lugares>();
        Ubicacion ObjUbicacion2 = new Ubicacion(resultadoCD.x, resultadoCD.y);
        Places ObjPlace = new Places();
        try {
            String[][] resultado = ObjPlace.getPlaces(ObjUbicacion2.getLatitud(), ObjUbicacion2.getLongitud(),
                    3000, "", "", Places.Rankby.distance, null);

            for (int i = 0; i < resultado.length; i++) {
                System.out.println("Place " + i + ":");
                for (int j = 0; j < resultado[0].length; j++) {
                    System.out.print(resultado[i][0] + "\t");
                     System.out.print(resultado[i][1] + "\t");
                      System.out.print(resultado[i][2] + "\t");
                       System.out.print(resultado[i][3] + "\t");
                       System.out.print(resultado[i][4] + "\t");
                          String tramo = "Lugar " + i + ":" + "</br>";
            String nombre = resultado[i][0];
            String calle = resultado[i][1];
            double longitud =Double.parseDouble(resultado[i][2]) ;
             double latitud =Double.parseDouble(resultado[i][3]) ;
            
            Lugares l1= new Lugares(nombre, calle, longitud, latitud);
            lugares.add(l1);
            
 
                }
                System.out.println("");
            }
        } catch (Exception e) {
            error("Place");
        }

        return lugares;
    }
}