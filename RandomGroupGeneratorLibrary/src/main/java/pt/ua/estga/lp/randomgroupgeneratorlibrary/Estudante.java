/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt.ua.estga.lp.randomgroupgeneratorlibrary;
import java.util.Objects;
/**
 *
 * @author SebastianMazoSimoes
 */
//Classe Estudante:
    public class Estudante{
        
//Atributos:
        private String nome;
        private int nmec;
        
//Construtor para criar o objeto estudante e os seus dados:
        public Estudante (String nome, int nmec)
        {
        this.nome = nome;
        this.nmec = nmec;
        }
        
 //Getters para o nome e nmec, Permite o acesso destes dados para outras partes do código:
        public String getnome()
        {
            return nome;
        }
        
        public int getnmec()
        {
            return nmec;
        }
        
 
 //Este método permite identificar quando dois estudantes são iguais:
 
        @Override
        public boolean equals(Object o)
        {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Estudante estudante = (Estudante) o;
            return nmec == estudante.nmec; 
        }
 //Cria um código para cada aluno baseado no seu nmec, para assim ser encontrado rapidamente em listas de histórico:
         @Override
         public int hashCode() 
         {
         return Objects.hash(nmec);
         }
        
 //Facilita a visualização ao imprimir o objeto (nome + nmec):
        @Override
        public String toString()
        {
        return String.format("%s - %d", nome, nmec);
        }
        
        
}
