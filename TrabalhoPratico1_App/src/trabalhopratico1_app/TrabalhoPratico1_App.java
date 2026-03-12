/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabalhopratico1_app;
import pt.ua.estga.lp.randomgroupgeneratorlibrary.*;
import lp.trabalho1.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author SebastianMazoSimoes
 */
public class TrabalhoPratico1_App {
     public static void main(String[] args) {
    
        String ficheiroAlunos = "estudantes.txt";
        String ficheiroHistorico = "historico.txt";
        String ficheiroSaida = "resultados.txt";
        
        // Instanciar as bibliotecas
        RandomGroupGeneratorLibrary gerador = new RandomGroupGeneratorLibrary();
        IODataClass io = new IODataClass();
        Scanner teclado = new Scanner(System.in);
        
        try {
            
            
            
            // Ler Alunos do ficheiro
            
            StudentInfo[] estudantesInput = io.loadStudentUC(ficheiroAlunos);
            
            if (estudantesInput != null && estudantesInput.length > 0) {
                System.out.println("Sucesso: Foram detectados " + estudantesInput.length + " alunos.");
                
                for (StudentInfo s : estudantesInput)
                {
                    String nomeLimpo = s.getStudentName().trim().toLowerCase();
                    int id = s.getStudentID();
                    Estudante novo = new Estudante(nomeLimpo, id);
                    gerador.inserirEstudante(novo);
                    
                    System.out.println( novo.getNome() + "," + novo.getNmec() );
                }
            }
            
            //Inserçao manual
            System.out.print("\nDeseja inserir mais alunos manualmente? (s/n): ");
            String opcao = teclado.nextLine();
            
            while (opcao.equalsIgnoreCase("s"))
            {
                System.out.print("Nome do estudante: ");
                String nomeManual = teclado.nextLine().trim().toLowerCase();
                
                System.out.print("NMEC: ");
                int nmecManual = Integer.parseInt(teclado.nextLine());
                
                Estudante eManual = new Estudante(nomeManual, nmecManual);
                gerador.inserirEstudante(eManual);
                
                System.out.println("Estudante " + nomeManual + " inserido com sucesso!");
                System.out.print("\nInserir outro? (s/n): ");
                opcao = teclado.nextLine();
            }

            // Carregar Histórico
            GroupInfo[] historicoInput = io.loadGroups(ficheiroHistorico);
            if (historicoInput != null && historicoInput.length > 0) {
                List<Grupo> listaComSimetria = new ArrayList<>();
                for (GroupInfo g : historicoInput) {
                    if (g.getSt1() != null && g.getSt2() != null) {
                        
                        String n1 = g.getSt1().getStudentName().trim().toLowerCase();
                        int id1 = g.getSt1().getStudentID();
                        String n2 = g.getSt2().getStudentName().trim().toLowerCase();
                        int id2 = g.getSt2().getStudentID();
                        
                    
                        
                        Estudante e1 = new Estudante(n1, id1);
                        Estudante e2 = new Estudante(n2, id2);
                        
                        listaComSimetria.add(new Grupo(e1, e2));
                        listaComSimetria.add(new Grupo(e2, e1));
                    }
                }
                gerador.carregarHistorico(listaComSimetria);
                System.out.println("Historico carregado: " + listaComSimetria.size() + " grupos anteriores.");
            }

            //  Gerar novos grupos
            System.out.println("\nA gerar novos grupos aleatorios...");
            List<Grupo> novosGrupos = gerador.gerarGruposAleatorios();

            //  Exibir no Terminal e preparar para Gravar
            if (novosGrupos != null && !novosGrupos.isEmpty()) {
                String[] resultadosParaGravar = new String[novosGrupos.size()];
                
                
                System.out.println("\n  Novos grupos gerados: \n");
             
                
                for (int i = 0; i < novosGrupos.size(); i++) {
                    Grupo g = novosGrupos.get(i);
                    String linha;
                    
                    // Verificação de segurança para números ímpares de alunos
                    if (g.getEstudante2() != null) {
                        linha = g.getEstudante1().getNome() + "," + g.getEstudante1().getNmec() + " e " + 
                                    g.getEstudante2().getNome() + "," + g.getEstudante2().getNmec();
                    } else {
                        linha = g.getEstudante1().getNome() + "," + g.getEstudante1().getNmec() + "(Sem par)";
                    }
                    
                    // Guardar para o ficheiro.txt
                    resultadosParaGravar[i] = linha;
                    
                    // Mostrar no terminal
                    System.out.println("Grupo " + (i + 1) + ": " + linha);
                }
                System.out.println("\n\n");

                //  Gravar no ficheiro de resultados
                io.outputGroups(ficheiroSaida, resultadosParaGravar);
                System.out.println("Sucesso! Todos os grupos foram guardados em: " + ficheiroSaida);
                
            } else {
                System.out.println("Aviso: Nao foi possivel gerar novos grupos, todas as combinacoes ja foram feitas.");
            }

        } catch (Exception e) {
            System.err.println("\n[ERRO CRÍTICO]: " + e.getMessage());
           
            
    }
        finally {
            teclado.close();
        }
}


}

