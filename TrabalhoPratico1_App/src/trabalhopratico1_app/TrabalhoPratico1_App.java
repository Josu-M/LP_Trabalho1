/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabalhopratico1_app;
import pt.ua.estga.lp.randomgroupgeneratorlibrary.*;
import lp.trabalho1.*;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author SebastianMazoSimoes
 */
public class TrabalhoPratico1_App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        String ficheiroAlunos = "students.txt";
        String ficheiroHistorico = "history.txt";
        String ficheiroSaida = "new_groups.txt";
        
        
    try {
          RandomGroupGeneratorLibrary lib = new RandomGroupGeneratorLibrary();
          IODataClass io = new IODataClass();
          
          System.out.println("---Inicializando Sistema---");
          
//Ler alunos do ficheiro através de IODataLibrary
            List<StudentInfo> alunosLidos = io.readStudents(ficheiroAlunos);
            if (alunosLidos == null || alunosLidos.isEmpty())
            {
            throw new Exception("O ficheiro de alunos está vazio ou não foi encontrado.");
            }
//Converter StudentInfo para o meu objeto Estudante 

    for (StudentInfo info : alunosLidos)
        {
            Estudante e = new Estudante(info.getNmec(), info.getNome());
            lib.inserirEstudante(e);
        }
    System.out.println("Alunos carregados:" + alunosLidos.size());
        }    
    
//Ler histórico de grupos anteriores se existir


    }
    
}
