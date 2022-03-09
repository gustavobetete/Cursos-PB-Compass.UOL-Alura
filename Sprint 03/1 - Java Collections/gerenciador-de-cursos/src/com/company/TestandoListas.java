package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static jdk.nashorn.internal.objects.NativeArray.forEach;

public class TestandoListas {

    public static void main(String[] args) {

	    String aula1 = "Conhecendo mais de listas";
        String aula2 = "Modelando a classe aula";
        String aula3 = "Trabalhando com cursos e Sets";

        ArrayList<String> aulas = new ArrayList<>();
        aulas.add(aula1);
        aulas.add(aula2);
        aulas.add(aula3);

        System.out.println(aulas);

        aulas.remove(0); // remove index 0 ( seria a aula1)

        System.out.println(aulas);


        for(String aula : aulas){
            System.out.println("Aula:" + aula);
        }

        String primeiraAula = aulas.get(0);
        System.out.println("A primeira aula é: " +primeiraAula);

// for padrão

        for (int i = 0; i < aulas.size(); i++){
            System.out.println("Aula: " + aulas.get(i));
        }
        System.out.println(aulas.size());

// foreach

        aulas.forEach(aula -> {
            System.out.println("Percorrendo:");
            System.out.println("Aula " + aula);
        });

        aulas.add("Aumentando o nosso COnhecimento");
        System.out.println("Antes de ordenar: ");
        System.out.println(aulas);

        Collections.sort(aulas);  // ordem alfabetica
        System.out.println("Depois de ordenado: ");
        System.out.println(aulas);



    }
}
