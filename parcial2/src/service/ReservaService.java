package service;

public interface ReservaService {
	void  mostrarTodasLasReservas();
	void buscarReserva(int codigo);
	void recaudacionTotal();
	void reservaImporteFinalMayor();
	void mostrarReservasPremium();
	void mostrarReservasImporteMayorA(double x);
	void promedioImporteFinalReservasSimple();
	void listaClientesReservaPremium();
	void mostrarCodigoDeMayorAMenorSegunImporteFinal();
}
