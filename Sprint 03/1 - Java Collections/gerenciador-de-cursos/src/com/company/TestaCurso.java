package com.company;

import java.util.ArrayList;
import java.util.List;

public class TestaCurso {

    public static void main(String[] args) {
        Curso javaColecoes = new Curso("Dominando as coleções do java", "Paulo Silveira");

        javaColecoes.adicionar(new Aula("Trabalhando com ArrayList", 21));
        javaColecoes.adicionar(new Aula("Criando uma aula", 20));
        javaColecoes.adicionar(new Aula("Modelando com coleções", 22));

        List<Aula> aulasImutavel = javaColecoes.getAulas();
        List<Aula> aulas = new ArrayList<>(aulasImutavel);

        System.out.println(aulas);


    }
}
