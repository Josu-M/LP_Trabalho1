/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt.ua.estga.lp.randomgroupgeneratorlibrary;
//Importa ferramentas para comparar objetos de forma segura:
import java.util.Objects;
/**
 *
 * @author SebastianMazoSimoes
 */

//Classe Grupo: Representa o par de estudantes e garante que sejam válidos os grupos. (A + B = B + A)
public class Grupo {
    
    private Estudante estudante1;
    private Estudante estudante2;
    
//Construtor para criar o grupo de dois alunos:
    
    public Grupo (Estudante e1, Estudante e2)
    {
    this.estudante1 = e1;
    this.estudante2 = e2;
    }
 
//Getters para poder aceder aos alunos do grupo desde outras partes do código:
  
    public Estudante getEstudante1()
    {
    return estudante1;
    }
    public Estudante getEstudante2()
    {
    return estudante2;
    }
    
    //Este método impede que os alunos sejam emparelhados mais do que uma vez:
     @Override
     public boolean equals(Object o)
     {
     if (this == o) return true;
     if ( o == null || getClass() != o.getClass()) return false;    
     Grupo grupo = (Grupo) o;
     
//O grupo A + B = B + A:
     
    return (Objects.equals(estudante1, grupo.estudante1) && Objects.equals(estudante2, grupo.estudante2)) ||
           (Objects.equals(estudante1, grupo.estudante2) && Objects.equals(estudante2, grupo.estudante1));
     }
     
//Somammos os códigos hash para que a ordem dos estudantes não altere o resultado final (Para que a Biblioteca encontre mais rapidamente os grupos no histórico):     
     
    @Override
    public int hashCode()
    {
    return Objects.hash(estudante1) + Objects.hash(estudante2);
    }
    
//Método que define como o grupo aparece escrito:
    @Override
    public String toString()
    {
    return "Grupo:" + estudante1.getnome() + "e" + estudante2.getnome();
    }
}
