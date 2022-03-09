package com.company;

import java.util.*;

public class TestaAlunos {

    public static void main(String[] args) {

        Collection<String> alunos = new HashSet<String>();
        alunos.add("Gustavo Betete");
        alunos.add("Nico Steppat");
        alunos.add("Pedro Sampaio");
        alunos.add("Sonia Abraum");
        alunos.add("Rodrigo Turini");
        alunos.add("Henrique Juliano");

        boolean GustavoEstaMatriculado = alunos.contains("Gustavo Betete");
        System.out.println(GustavoEstaMatriculado);

        alunos.remove("Sonia Abraum");

        System.out.println(alunos.size());

        for (String aluno: alunos) {
            System.out.println(aluno);
        }

        alunos.forEach(aluno -> {
            System.out.println(aluno);
        });

        System.out.println(alunos);

        List<String> alunosEmLista = new ArrayList<>(alunos);
    }
}

