package org.example;

import java.util.ArrayList;
import java.util.Random;

class RuletaRusa {
    private ArrayList<String> jugadores;
    private int posicionActual;
    private int recamara; //
    private Random random;
    private int rondas; //

    public RuletaRusa() {
        this.jugadores = new ArrayList<>();
        this.random = new Random();
        this.rondas = 0;
        nuevoAleatorio(); //
    }

    public void nuevojugador(String nombre) {
        if (jugadores.size() < 6) {
            jugadores.add(nombre);
        } else {
            System.out.println("Hola el limite es de 6 jugadores.");
        }
    }

    public boolean disparar() {
        rondas++;
        if (posicionActual == recamara) {
            return true;
        } else {
            nuevoAleatorio();
            return false;
        }
    }

    public boolean juegoTerminado() {
        return rondas >= 6;
    }

    public void nuevoAleatorio() {
        this.posicionActual = random.nextInt(6);
    }

    public ArrayList<String> getJugadores() {
        return jugadores;
    }
}