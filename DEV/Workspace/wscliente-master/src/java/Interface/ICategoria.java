package Interface;


import java.util.List;
import model.ModelCategoria;

/**
 *
 * @author aluno
 */
public interface ICategoria {
    
    public List<ModelCategoria> ObterListaCategoria();
    
    public ModelCategoria ObterCategoriaPorId(int idCategora);
    
    public List<ModelCategoria> ObterCategoriaPeloNome(String nomeCategoria);
    
}
