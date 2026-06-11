package main;

import java.util.Map;
import java.util.Scanner;

import model.Reserva;
import repository.LecturaArchivo;
import service.ReservaService;
import service.ReservaServiceImpl;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        LecturaArchivo repo = new LecturaArchivo();
        Map<Integer, Reserva> mapaReservas = repo.leerArchivo("reservas.txt");
        
        ReservaService service = new ReservaServiceImpl(mapaReservas);
        String opcion = "";

        do {
            System.out.println();
            System.out.println("1. Mostrar todas las reservas");
            System.out.println("2. Buscar reserva por codigo");
            System.out.println("3. Calcular recaudacion total");
            System.out.println("4. Mostrar la reserva con mayor importe");
            System.out.println("5. Informar cantidad de reservas Premium");
            System.out.println("6. Mostrar reservas superiores a $100.000");
            System.out.println("7. Calcular promedio de importe en Reservas Simples");
            System.out.println("8. Listar clientes con Reservas Premium");
            System.out.println("9. Mostrar codigos ordenados de mayor a menor importe");
            System.out.println("0. Salir");
            System.out.println();
            System.out.print("Ingrese una opcion: ");
            
            opcion = scanner.nextLine();
            System.out.println();

            switch (opcion) {
                case "1":
                    service.mostrarTodasLasReservas();
                    break;
                case "2":
                    System.out.print("Ingrese el codigo de la reserva: ");
                    String inputCodigo = scanner.nextLine();
                    try {
                        int codigo = Integer.parseInt(inputCodigo);
                        System.out.println();
                        service.buscarReserva(codigo);;
                    } catch (NumberFormatException e) {
                        System.out.println();
                        System.out.println("Error: El codigo debe ser un valor numerico entero.");
                    }
                    break;
                case "3":
                    service.recaudacionTotal();;
                    break;
                case "4":
                    service.reservaImporteFinalMayor();
                    break;
                case "5":
                    service.listaClientesReservaPremium();
                    break;
                case "6":
                    service.mostrarReservasImporteMayorA(100000.0);
                    break;
                case "7":
                    service.promedioImporteFinalReservasSimple();;
                    break;
                case "8":
                    service.listaClientesReservaPremium();;
                    break;
                case "9":
                    service.mostrarCodigoDeMayorAMenorSegunImporteFinal();;
                    break;
                case "0":
                    System.out.println("adeu adeu");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
        } while (!opcion.equals("0"));
        
        scanner.close();
    }
}
