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
    
    public void carregarHistorico(List<Grupo> gruposPassados)
    {
        this.historico.addAll(gruposPassados);
    }
    
    public void inserirGrupoManual(Estudante a, Estudante b) throws Exception
    {
        Grupo novo = new Grupo(a, b);
        if (historico.contains(novo))
        {
            throw new Exception("Erro: Estes alunos já trabalharam juntos!");
        }
       historico.add(novo);
    }
    
    public List<Grupo> gerarGruposAleatorios() throws Exception
    {
    List<Estudante> disponiveis = new ArrayList<>(estudantes);
    Collections.shuffle(disponiveis);
    List<Grupo> novosGrupos =  new ArrayList<>();
    
    while (disponiveis.size() >= 2)
    {
    Estudante e1 = disponiveis.remove(0);
    boolean parEncontrado = false;  
    
    for (int i = 0; i < disponiveis.size(); i++)
    {
    Estudante e2 = disponiveis.get(i);
    Grupo tentativa = new Grupo(e1, e2);
    
    if (!historico.contains(tentativa))
    {
    novosGrupos.add(tentativa);
    historico.add(tentativa);
    disponiveis.remove(i);
    parEncontrado = true;
    break;
    }
    
    }
    
    if (!parEncontrado)
    {
    throw new Exception ("Impossível gerar grupos: restrições de repetição violadas para " + e1.getNome());
    }
    }
    return novosGrupos;
    }
    
}   