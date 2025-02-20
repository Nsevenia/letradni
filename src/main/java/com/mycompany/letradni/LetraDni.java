/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.letradni;

/**
 * Clase LetraDni que permite calcular y verificar la letra de un DNI.
 * @author seven
 */
public class LetraDni {
    
    // Array con las letras del DNI según el módulo 23
    private static final char[] LETRAS_DNI = 
        {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

    /**
     * Método que calcula la letra correspondiente a un número de DNI.
     * @param numeroDNI Número del DNI sin la letra.
     * @return Letra del DNI correspondiente.
     */
    public static char AdivinarNumeroDNI(int numeroDNI) {
        return LETRAS_DNI[numeroDNI % 23];
    }

    /**
     * Método que comprueba si un DNI es válido.
     * @param dni DNI en formato "12345678X".
     * @return true si la letra del DNI es correcta, false en caso contrario.
     */
    public static boolean ComprobarDNI(String dni) {
        if (dni.length() != 9) return false; // Un DNI debe tener 9 caracteres
        
        try {
            int numeroDNI = Integer.parseInt(dni.substring(0, 8)); // Extrae los 8 primeros dígitos
            char letraDNI = dni.charAt(8); // Extrae la letra
            
            return letraDNI == AdivinarNumeroDNI(numeroDNI);
        } catch (NumberFormatException e) {
            return false; // Si hay error al convertir el número, el DNI no es válido
        }
    }

    /**
     * Método que prueba varios DNIs generados aleatoriamente.
     */
    public static void ProbarDNIs() {
        int[] numerosDNI = {12345678, 87654321, 45678912, 98765432, 10293847};
        
        for (int num : numerosDNI) {
            char letra = AdivinarNumeroDNI(num);
            String dniCompleto = num + "" + letra;
            System.out.println("DNI generado: " + dniCompleto + " -> " + ComprobarDNI(dniCompleto));
        }
    }

    /**
     * Método principal para ejecutar pruebas.
     */
    public static void main(String[] args) {
        ProbarDNIs();
    }
}