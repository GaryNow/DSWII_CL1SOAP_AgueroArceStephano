package pe.edu.cibertec.dswii_cl1soap_agueroarcestephano.repository;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class ExamenRepository {

    public double calcularEstacionamiento(int horas, int minutos) {
        double tarifaPorHora = 1500;
        int totalMinutos = horas * 60 + minutos;
        int totalHoras = (totalMinutos + 59) / 60;
        return totalHoras * tarifaPorHora;
    }


    public double calcularPromedio(int nota1, int nota2, int nota3, int nota4) {
        int[] notas = {nota1, nota2, nota3, nota4};
        Arrays.sort(notas);
        int[] notasSeleccionadas = {notas[1], notas[2], notas[3]};
        double promedio = notasSeleccionadas[0] * 0.2 + notasSeleccionadas[1] * 0.3 + notasSeleccionadas[2] * 0.5;

        return promedio;
    }


    public boolean verificarDNI(int anioNacimiento) {
        int edad = 2024 - anioNacimiento;
        return edad >= 18;
    }

    public int[] obtenerNumerosPares() {
        int[] pares = new int[6];
        int index = 0;
        for (int i = 20; i >= 10; i--) {
            if (i % 2 == 0) {
                pares[index++] = i;
            }
        }
        return pares;
    }

    public double calcularDescuento(int cantidad, double precio) {
        double total = cantidad * precio;
        if (total > 200) {
            total *= 0.8;
        }
        return total;
    }
}