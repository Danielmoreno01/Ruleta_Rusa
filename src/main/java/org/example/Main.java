package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RuletaRusa ruleta = new RuletaRusa();
        System.out.println("REGLAS DEL JUEGO\n" +
                "#1 Maximo 6 jugadores\n" +
                "#2 Si el jugador muere se acaba el juego\n" +
                "Cuantos jugadores inician?:");

        int numeroJuga = Integer.parseInt(scanner.nextLine());
        numeroJuga = Math.min(numeroJuga, 6);

        System.out.println("Ingrese los nombres de los jugadores:");
        for (int i = 0; i < numeroJuga; i++) {
            String nombreJuga= scanner.nextLine();
            ruleta.nuevojugador(nombreJuga);
        }

        int turno = 0;

        while (!ruleta.getJugadores().isEmpty()) {
            String Turno = ruleta.getJugadores().get(turno);
            System.out.println(Turno + " presiona Enter para disparar");
            scanner.nextLine();

            if (ruleta.disparar()) {
                System.out.println(Turno + " ha muerto. Fin del juego.");
                break;
            } else {
                System.out.println(Turno + "  .");
                turno = (turno + 1) % ruleta.getJugadores().size();
            }
        }

        System.out.println("Fin.");
        scanner.close();
    }
}

