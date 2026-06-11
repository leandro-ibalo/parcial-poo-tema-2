package model;
public class ReservaPremium extends Reserva{
	private String servicioExtra;

	public ReservaPremium(int codigo, String cliente, int cantidadNoches, double precioPorNoche,
			String servicioExtra) {
		super(codigo, cliente, cantidadNoches, precioPorNoche);
		this.servicioExtra = servicioExtra;
	}

	@Override
	public double calcularImporteFinal() {
		// TODO Auto-generated method stub
		double total=cantidadNoches*precioPorNoche;
		if(servicioExtra.equalsIgnoreCase("SPA")) {
			return  total+20000;
		}else if(servicioExtra.equalsIgnoreCase("COCHERA")) {
			return total+10000;
		}else {
			return total+500;
		}
	}

	@Override
	public String toString() {
		return "ReservaPremium [servicioExtra=" + servicioExtra + ", codigo=" + codigo + ", cliente=" + cliente
				+ ", cantidadNoches=" + cantidadNoches + ", precioPorNoche=" + precioPorNoche
				+ ",importe final=" + calcularImporteFinal() + "]";
	}
	
	
	
	
}