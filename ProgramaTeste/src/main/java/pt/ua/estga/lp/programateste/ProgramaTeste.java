/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package pt.ua.estga.lp.programateste;
// Importar a tua biblioteca (estes imports podem variar consoante o nome do pacote que usaste)
import pt.ua.estga.lp.randomgroupgeneratorlibrary.RandomGroupGeneratorLibrary;
import pt.ua.estga.lp.randomgroupgeneratorlibrary.Estudante;
import pt.ua.estga.lp.randomgroupgeneratorlibrary.Grupo;

/**
 *
 * @author josue
 */

public class ProgramaTeste {

    public static void main(String[] args) {
        
        System.out.println("--- A Iniciar o Gerador de Grupos ---");

        // 1. Inicializar a tua biblioteca
        RandomGroupGeneratorLibrary gerador = new RandomGroupGeneratorLibrary();

        // -------------------------------------------------------------------
        // 2. LEITURA DE DADOS (Usando a IODataLibrary futuramente)
        // -------------------------------------------------------------------
        // Aqui vais usar a IODataLibrary para carregar os alunos[cite: 26]. 
        // Exemplo imaginário: 
        // List<Estudante> alunosDoFicheiro = IODataLibrary.lerEstudantes("alunos.txt");
        //
        // Como ainda não temos os ficheiros, vamos simular a entrada de 4 estudantes:
        System.out.println("A carregar estudantes...");
        Estudante e1 = new Estudante("Ana", 1111);
        Estudante e2 = new Estudante("Bruno", 2222);
        Estudante e3 = new Estudante("Carlos", 3333);
        Estudante e4 = new Estudante("Diana", 4444);
        
        gerador.adicionarEstudante(e1);
        gerador.adicionarEstudante(e2);
        gerador.adicionarEstudante(e3);
        gerador.adicionarEstudante(e4);


        // -------------------------------------------------------------------
        // 3. DEMONSTRAÇÃO DAS FUNCIONALIDADES
        // -------------------------------------------------------------------
        System.out.println("A demonstrar funcionalidades...");
        
        // a) Inserção Manual (Ainda temos de criar este método na biblioteca!)
        // gerador.inserirGrupoManual(new Grupo(e1, e2));
        
        // b) Gerar os restantes grupos aleatoriamente [cite: 27]
        // (Ainda temos de criar este método na biblioteca!)
        // List<Grupo> gruposGerados = gerador.gerarGruposAleatorios();

        // c) Mostrar os resultados na consola
        // System.out.println("\nGrupos Finais:");
        // for (Grupo g : gruposGerados) {
        //     System.out.println(g.toString());
        // }


        // -------------------------------------------------------------------
        // 4. GRAVAR RESULTADOS (Usando a IODataLibrary futuramente)
        // -------------------------------------------------------------------
        // No final, usas a biblioteca do professor para guardar o histórico[cite: 28].
        // Exemplo imaginário:
        // IODataLibrary.guardarGrupos("historico_novo.txt", gruposGerados);
        
        System.out.println("\nProcesso concluído! (A aguardar a implementação dos métodos...)");
    }
}