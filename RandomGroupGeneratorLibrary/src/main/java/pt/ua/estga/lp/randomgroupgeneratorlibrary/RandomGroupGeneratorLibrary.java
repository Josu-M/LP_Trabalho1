/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package pt.ua.estga.lp.randomgroupgeneratorlibrary;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class RandomGroupGeneratorLibrary {
    
    private List<Estudante> estudantes;
    private Set<Grupo> historico;
    
    public RandomGroupGeneratorLibrary()
    {
        this.estudantes = new ArrayList<>();
        this.historico = new HashSet<>(); 
    }
    
    public void inserirEstudante(Estudante e)
    {
    if (!estudantes.contains(e))
        {
        estudantes.add(e);
        }
    }
    //Carregar o histórico de grupos anteriores para evitar repetições e gerar novos grupos, garantindo a aleatoriedade e a não-repetição dos grupos
    public void carregarHistorico(List<Grupo> gruposPassados)
    {
        this.historico.addAll(gruposPassados);
    }
    
    public void inserirGrupoManual(Estudante a, Estudante b) throws Exception
    {
        Grupo novo = new Grupo(a, b);
        if (historico.contains(novo))
        {
            throw new Exception("Erro: Estes alunos ja trabalharam juntos!");
        }
       historico.add(novo);
    }
    
    public List<Grupo> gerarGruposAleatorios() throws Exception
    {
    List<Estudante> disponiveis = new ArrayList<>(estudantes);
    Collections.shuffle(disponiveis);
    List<Grupo> novosGrupos =  new ArrayList<>();
    
    // SUBSTITUIR POR ISTO:
    while (!disponiveis.isEmpty()) {
        Estudante e1 = disponiveis.remove(0);
        Estudante e2 = null; // Começa como nulo (lugar vazio)

        // Tenta encontrar um parceiro na lista de disponíveis
        for (int i = 0; i < disponiveis.size(); i++) {
            Estudante candidato = disponiveis.get(i);
            Grupo tentativa = new Grupo(e1, candidato);

            if (!historico.contains(tentativa)) {
                e2 = disponiveis.remove(i); // Encontrou par, remove-o da lista
                break;
            }

        }

        Grupo novoGrupo = new Grupo(e1, e2);
        novosGrupos.add(novoGrupo);

        // Só adicionamos ao histórico se for um par real (e2 não nulo)
        if (e2 != null) {
            historico.add(novoGrupo);
        }
    }
    return novosGrupos;
    }
    
}   