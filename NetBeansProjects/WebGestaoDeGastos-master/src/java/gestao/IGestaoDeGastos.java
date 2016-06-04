package gestao;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 *
 * @author aluno
 */
@WebService
@SOAPBinding(style = Style.RPC)
public interface IGestaoDeGastos {
    
}
