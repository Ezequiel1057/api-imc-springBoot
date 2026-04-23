package com.example.imc.util;

public class ImcCalculator  {

    public static double calculaAlturaCm(double alturaM){
        return alturaM * 100;
    }

    public static double calcularPesoIdeal(double alturaCm, double pesoKg){
        return (alturaCm - 100) - ((alturaCm - pesoKg) / 4) * (5.0 /100);
    }

    public static  double calcularImc(double alturaM, double pesoKg){
        return pesoKg / Math.pow(alturaM, 2);
    }

    public static  String interpretarImc(double imc){
        if(imc <= 20) return "Beixo Peso";
        if(imc <25) return "Normal";
        if(imc <= 30) return  "Acima do Peso ";

        return "Obeso";
    }



}
