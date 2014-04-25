package gcom.gui.operacional;

import gcom.fachada.Fachada;
import gcom.gui.ActionServletException;
import gcom.gui.GcomAction;
import gcom.gui.ManutencaoRegistroActionForm;
import gcom.operacional.ProducaoAgua;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


/**
 * @author Vin�cius Medeiros
 * @date 11/06/2008
 */

public class RemoverProducaoAguaAction extends GcomAction {
	
	public ActionForward execute(ActionMapping actionMapping,
            ActionForm actionForm, HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) {

        ManutencaoRegistroActionForm manutencaoRegistroActionForm = (ManutencaoRegistroActionForm) actionForm;

        String[] ids = manutencaoRegistroActionForm.getIdRegistrosRemocao();

        // Seta o caminho de retorno
        ActionForward retorno = actionMapping.findForward("telaSucesso");

        // Obt�m a inst�ncia da fachada
        Fachada fachada = Fachada.getInstancia();
        
        // Mensagem de erro quando o usu�rio tenta excluir sem ter selecionado
        // nenhum registro
        if (ids == null || ids.length == 0) {
            
        	throw new ActionServletException("atencao.registros.nao_selecionados");
        
        }

        fachada.remover(ids, ProducaoAgua.class.getName(),null, null);
        
        if (retorno.getName().equalsIgnoreCase("telaSucesso")) {
            montarPaginaSucesso(httpServletRequest,
            		ids.length + " Produ��o(�es) de �gua removida(s) com sucesso.",
                    "Realizar outra Manuten��o de Produ��o de �gua",
                    "exibirFiltrarProducaoAguaAction.do?menu=sim");
        }

        return retorno;

	}
}
