package service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import model.Reserva;
import model.ReservaPremium;
import model.ReservaSimple;

public class ReservaServiceImpl implements ReservaService {
	private Map<Integer,Reserva>listaM;



	public ReservaServiceImpl(Map<Integer, Reserva> listaM) {
		this.listaM =(listaM!=null)?listaM:new HashMap<>();
	}

	@Override
	public void mostrarTodasLasReservas() {
		if(listaM.isEmpty()) {System.out.println("la lista está vacia");return;}
		listaM.values().stream().forEach(System.out::println);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buscarReserva(int codigo) {
		Reserva b=listaM.get(codigo);
		if(b!=null) {System.out.println("reserva encontrada: "+b);}
		else {System.out.println("no se encontro la reserva");}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recaudacionTotal() {
		if(listaM.isEmpty()) {System.out.println("la lista está vacia");return;}
		double total=listaM.values().stream().mapToDouble(Reserva::calcularImporteFinal).sum();
		System.out.println("la recaudacion total es de: "+total);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reservaImporteFinalMayor() {
		if(listaM.isEmpty()) {System.out.println("la lista está vacia");return;}
		listaM.values().stream()
		.max(Comparator.comparing(Reserva::calcularImporteFinal))
		.ifPresent(r->{System.out.println("la reserva con mayor importe es: "+r);});
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarReservasPremium() {
		if(listaM.isEmpty()) {System.out.println("la lista está vacia");return;}
		listaM.values().stream().filter(r->r instanceof ReservaPremium)
		.count();
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarReservasImporteMayorA(double x) {
		if(listaM.isEmpty()) {System.out.println("la listaM está vacia");return;}
		System.out.println("reservas de importe mayores a: "+x);
		listaM.values().stream()
		.filter(r->r.calcularImporteFinal()>x)
		.forEach(System.out::println);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void promedioImporteFinalReservasSimple() {
		if(listaM.isEmpty()) {System.out.println("la listaM está vacia");return;}
		double promedio=listaM.values().stream()
				.filter(r->r instanceof ReservaSimple)
				.mapToDouble(Reserva::calcularImporteFinal)
				.average()
				.orElse(0);
		System.out.println("el promedio de las reservas simples es de: "+promedio);
		
		
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listaClientesReservaPremium() {
		if(listaM.isEmpty()) {System.out.println("la listaM está vacia");return;}
		listaM.values().stream()
		.filter(r->r instanceof ReservaPremium)
		.map(Reserva::getCliente)
		.forEach(System.out::println);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarCodigoDeMayorAMenorSegunImporteFinal() {
		if(listaM.isEmpty()) {System.out.println("la listaM está vacia");return;}
		listaM.values().stream()
		.sorted(Comparator.comparing(Reserva::calcularImporteFinal).reversed())	
		.map(Reserva::getCodigo)
		.forEach(System.out::println);
		// TODO Auto-generated method stub
		
	}
	
	
}
