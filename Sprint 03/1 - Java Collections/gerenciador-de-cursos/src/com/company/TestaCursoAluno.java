package com.company;

import java.util.Iterator;
import java.util.Set;

public class TestaCursoAluno {
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

        System.out.println("Todos os alunos matriculados: ");

        Set<Aluno> alunos = javaColecoes.getAlunos();
        Iterator<Aluno> iterator = alunos.iterator();
        while(iterator.hasNext()) {
            Aluno proximo = iterator.next();
            System.out.println(proximo);
        }


        javaColecoes.getAlunos().forEach(a -> {
            System.out.println(a);
        });

        System.out.println("O aluno " + a1.getNome() + " Esta matriculado?");
        System.out.println(javaColecoes.estaMatriculados(a1)); // retorna true

        Aluno betete = new Aluno("Gustavo Betete", 12025);
        System.out.println("E esse Betete, esta matriculado?");
        System.out.println(javaColecoes.estaMatriculados(betete));

        System.out.println("O a1 é equals ao Betete?");
        System.out.println(a1.equals(betete));// retorna true

        //obrigatoriamente o seguinte é true:

        System.out.println(a1.hashCode() == betete.hashCode());
    }

}
