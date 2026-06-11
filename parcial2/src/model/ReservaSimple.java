package model;
public class ReservaSimple extends Reserva{
	
	

	public ReservaSimple(int codigo, String cliente, int cantidadNoches, double precioPorNoche) {
		super(codigo, cliente, cantidadNoches, precioPorNoche);
	}

	@Override
	public double calcularImporteFinal() {
		// TODO Auto-generated method stub
		return cantidadNoches*precioPorNoche;
	}

	@Override
	public String toString() {
		return "ReservaSimple [codigo=" + codigo + ", cliente=" + cliente + ", cantidadNoches=" + cantidadNoches
				+ ", precioPorNoche=" + precioPorNoche + ", importe final=" + calcularImporteFinal() + "]";
	}
	
	 
}