package repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import model.Reserva;
import model.ReservaPremium;
import model.ReservaSimple;

public class LecturaArchivo {

	public Map<Integer, Reserva> leerArchivo(String ruta) {
	    Map<Integer, Reserva> lista = new HashMap<>();

	    try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
	        String linea;
	        boolean primeraLinea = true;

	        while ((linea = br.readLine()) != null) {
	            if (linea.trim().isEmpty()) continue;

	            if (primeraLinea) {
	                primeraLinea = false;
	                continue; 
	            }

	            String[] p = linea.split(";");
	            String tipo = p[0].trim();
	            int codigo;

	            try {
	                codigo = Integer.parseInt(p[1].trim());
	            } catch (NumberFormatException e) {
	                System.out.println("errror ");
	                continue;
	            }

	            if (lista.containsKey(codigo)) {
	                System.out.println("error codigo repetido: " + codigo);
	                continue;
	            }

	            if (tipo.equalsIgnoreCase("S") && p.length == 5) {
	                String cliente = p[2].trim();
	                int cantidadNoches = Integer.parseInt(p[3].trim());
	                double precioPorNoche = Double.parseDouble(p[4].trim());

	                lista.put(codigo, new ReservaSimple(codigo, cliente, cantidadNoches, precioPorNoche));

	            } else if (tipo.equalsIgnoreCase("P") && p.length == 6) {
	                String cliente = p[2].trim();
	                int cantidadNoches = Integer.parseInt(p[3].trim());
	                double precioPorNoche = Double.parseDouble(p[4].trim());
	                String servicioExtra = p[5].trim();

	                lista.put(codigo, new ReservaPremium(codigo, cliente, cantidadNoches, precioPorNoche, servicioExtra));

	            } else {
	                System.out.println("error " + tipo + " en el codigo: " + codigo);
	            }
	        }

	    } catch (IOException e) {
	        System.out.println("error al leer el archvio");
	    } catch (NumberFormatException e) {
	        System.out.println("error en el archivo");
	    }

	    return lista;
	}
}
