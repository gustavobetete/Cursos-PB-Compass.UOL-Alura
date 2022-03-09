package com.company;

import java.util.Map;
import java.util.Set;

public class TestaBuscaAlunoNoCurso {
    public static void main(String[] args) {
        Curso javaColecoes = new Curso("Dominando as coleções do java", "Paulo Silveira");

        javaColecoes.adicionar(new Aula("Trabalhando com ArrayList", 21));
        javaColecoes.adicionar(new Aula("Criando uma aula", 20));
        javaColecoes.adicionar(new Aula("Modelando com coleções", 24));

        Aluno a1 = new Aluno("Gustavo Betete", 12025);
        Aluno a2 = new Aluno("Guilherme Silveira", 10100);
        Aluno a3 = new Aluno("Nico Steppat", 16106);

        javaColecoes.matricula(a1);
        javaColecoes.matricula(a2);
        javaColecoes.matricula(a3);

        System.out.println("Quem é o aluno com matricula 16106?");
        Aluno aluno = javaColecoes.buscaMatriculado(16106);
        System.out.println("Aluno: " + aluno);

        Map<Integer, Set<Aluno>> matriculaParaAluno;
    }
}
