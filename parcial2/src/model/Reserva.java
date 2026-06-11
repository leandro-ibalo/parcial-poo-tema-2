package model;

public abstract class Reserva {
	protected int codigo;
	protected String cliente;
	protected int cantidadNoches;
	protected double precioPorNoche;	
	public Reserva( int codigo, String cliente, int cantidadNoches, double precioPorNoche) {
		super();
		this.codigo = codigo;
		this.cliente = cliente;
		this.cantidadNoches = cantidadNoches;
		this.precioPorNoche = precioPorNoche;
		
		
	}
	public int getCodigo() {
		return codigo;
	}
	public String getCliente() {
		return cliente;
	}
	public int getCantidadNoches() {
		return cantidadNoches;
	}
	public double getPrecioPorNoche() {
		return precioPorNoche;
	}
	public abstract double calcularImporteFinal();
}
