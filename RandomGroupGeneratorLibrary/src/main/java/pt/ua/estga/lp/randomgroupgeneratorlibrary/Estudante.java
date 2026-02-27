/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt.ua.estga.lp.randomgroupgeneratorlibrary;

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
        
 //Getters para o nome e nmec, Permite o acesso destes dados para outras partes do código
        public String getnome()
        {
            return nome;
        }
        
        public int getnmec()
        {
            return nmec;
        }
        
        
        
        
        
}
