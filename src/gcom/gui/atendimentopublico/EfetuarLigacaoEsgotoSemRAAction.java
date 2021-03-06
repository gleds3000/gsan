package gcom.gui.atendimentopublico;

import gcom.atendimentopublico.ligacaoesgoto.FiltroLigacaoEsgoto;
import gcom.atendimentopublico.ligacaoesgoto.LigacaoEsgoto;
import gcom.atendimentopublico.ligacaoesgoto.LigacaoEsgotoDiametro;
import gcom.atendimentopublico.ligacaoesgoto.LigacaoEsgotoMaterial;
import gcom.atendimentopublico.ligacaoesgoto.LigacaoEsgotoPerfil;
import gcom.atendimentopublico.ligacaoesgoto.LigacaoEsgotoSituacao;
import gcom.cadastro.imovel.Imovel;
import gcom.fachada.Fachada;
import gcom.gui.ActionServletException;
import gcom.gui.GcomAction;
import gcom.interceptor.RegistradorOperacao;
import gcom.seguranca.acesso.Operacao;
import gcom.seguranca.acesso.usuario.Usuario;
import gcom.seguranca.acesso.usuario.UsuarioAcao;
import gcom.seguranca.acesso.usuario.UsuarioAcaoUsuarioHelper;
import gcom.util.ConstantesSistema;
import gcom.util.Util;
import gcom.util.filtro.ParametroSimples;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class EfetuarLigacaoEsgotoSemRAAction extends GcomAction {

	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {

		ActionForward retorno = actionMapping.findForward("telaSucesso");
		HttpSession sessao = httpServletRequest.getSession(false);

		EfetuarLigacaoEsgotoSemRAActionForm efetuarLigacaoEsgotoSemRAActionForm = (EfetuarLigacaoEsgotoSemRAActionForm) actionForm;

		Fachada fachada = Fachada.getInstancia();
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");
		
		LigacaoEsgoto ligacaoEsgoto = new LigacaoEsgoto();

		String matriculaImovel = efetuarLigacaoEsgotoSemRAActionForm.getMatriculaImovel();

		String materialLigacao = efetuarLigacaoEsgotoSemRAActionForm.getMaterialLigacao();
		String perfilLigacao = efetuarLigacaoEsgotoSemRAActionForm.getPerfilLigacao();
		String percentual = efetuarLigacaoEsgotoSemRAActionForm.getPercentualColeta().toString().replace(",", ".");
		String percentualEsgoto = efetuarLigacaoEsgotoSemRAActionForm.getPercentualEsgoto().toString().replace(",", ".");
		String dataLigacao = efetuarLigacaoEsgotoSemRAActionForm.getDataLigacao();
		String indicadorCaixaGordura = efetuarLigacaoEsgotoSemRAActionForm.getIndicadorCaixaGordura();
		String indicadorLigacaoEsgoto = efetuarLigacaoEsgotoSemRAActionForm.getIndicadorLigacao();
		String diametroLigacao = efetuarLigacaoEsgotoSemRAActionForm.getDiametroLigacao();

		if (matriculaImovel != null && !matriculaImovel.equals("")) {

			Imovel imovel = new Imovel();
			imovel.setId(new Integer(matriculaImovel));

			ligacaoEsgoto.setImovel(imovel);
			ligacaoEsgoto.setUltimaAlteracao(new Date());
			ligacaoEsgoto.setId(imovel.getId());

			LigacaoEsgotoSituacao ligacaoEsgotoSituacao = new LigacaoEsgotoSituacao();
			ligacaoEsgotoSituacao.setId(LigacaoEsgotoSituacao.LIGADO);
			
			if(indicadorCaixaGordura != null && !indicadorCaixaGordura.equals("")) {
				ligacaoEsgoto.setIndicadorCaixaGordura(new Short(indicadorCaixaGordura));
			} else {
				throw new ActionServletException("atencao.informe_campo_obrigatorio", null,
						"Caixa de Gordura");
			}
			
			if(indicadorLigacaoEsgoto != null && !indicadorLigacaoEsgoto.equals("")) {
				ligacaoEsgoto.setIndicadorLigacaoEsgoto(new Short(indicadorLigacaoEsgoto));
			} else {
				throw new ActionServletException("atencao.informe_campo_obrigatorio", null,
						"Liga��o");
			}

			if (diametroLigacao != null
					&& !diametroLigacao.equals("")
					&& !diametroLigacao.trim().equalsIgnoreCase(
							"" + ConstantesSistema.NUMERO_NAO_INFORMADO)) {
				LigacaoEsgotoDiametro ligacaoEsgotoDiametro = new LigacaoEsgotoDiametro();
				ligacaoEsgotoDiametro.setId(new Integer(diametroLigacao));
				ligacaoEsgoto.setLigacaoEsgotoDiametro(ligacaoEsgotoDiametro);
			} else {
				throw new ActionServletException(
						"atencao.informe_campo_obrigatorio", null,
						"Diametro da Liga��o");
			}

			if (materialLigacao != null
					&& !materialLigacao.equals("")
					&& !materialLigacao.trim().equalsIgnoreCase(
							"" + ConstantesSistema.NUMERO_NAO_INFORMADO)) {
				LigacaoEsgotoMaterial ligacaoEsgotoMaterialMaterial = new LigacaoEsgotoMaterial();
				ligacaoEsgotoMaterialMaterial
						.setId(new Integer(materialLigacao));
				ligacaoEsgoto
						.setLigacaoEsgotoMaterial(ligacaoEsgotoMaterialMaterial);
			} else {
				throw new ActionServletException(
						"atencao.informe_campo_obrigatorio", null,
						"Material da Liga��o");
			}

			if (perfilLigacao != null
					&& !perfilLigacao.equals("")
					&& !perfilLigacao.trim().equalsIgnoreCase(
							"" + ConstantesSistema.NUMERO_NAO_INFORMADO)) {
				LigacaoEsgotoPerfil ligacaoEsgotoPerfil = new LigacaoEsgotoPerfil();
				ligacaoEsgotoPerfil.setId(new Integer(perfilLigacao));
				ligacaoEsgoto.setLigacaoEsgotoPerfil(ligacaoEsgotoPerfil);
			} else {
				throw new ActionServletException(
						"atencao.informe_campo_obrigatorio", null,
						"Perfil da Liga��o");
			}

			if (percentual != null && !percentual.equals("")) {

				BigDecimal percentualInformadoColeta = new BigDecimal(
						percentual);
				if (percentualInformadoColeta != null
						&& !percentualInformadoColeta.equals("")
						&& (percentualInformadoColeta.intValue() <= ConstantesSistema.NUMERO_MAXIMO_CONSUMO_MINIMO_FIXADO)) {
					ligacaoEsgoto
							.setPercentualAguaConsumidaColetada(percentualInformadoColeta);
				}
			} else {
				throw new ActionServletException(
						"atencao.informe_campo_obrigatorio", null,
						"Percentual de Coleta");
			}

			if (percentualEsgoto != null && !percentualEsgoto.equals("")) {

				BigDecimal percentualEsgotoColeta = new BigDecimal(percentualEsgoto);
				ligacaoEsgoto.setPercentual(percentualEsgotoColeta);
			}

			if (dataLigacao != null && !dataLigacao.equals("")) {
				ligacaoEsgoto.setDataLigacao(Util.converteStringParaDate(dataLigacao));
				if (ligacaoEsgoto.getDataLigacao().after(new Date())) {
					throw new ActionServletException(
							"atencao.data_menor_que_atual", null, "Liga��o");
				}
			}

			RegistradorOperacao registradorOperacao = new RegistradorOperacao(
					Operacao.OPERACAO_LIGACAO_ESGOTO__SEM_RA_EFETUAR,
					imovel.getId(), imovel.getId(),
					new UsuarioAcaoUsuarioHelper(usuario,
							UsuarioAcao.USUARIO_ACAO_EFETUOU_OPERACAO));
			registradorOperacao.registrarOperacao(ligacaoEsgoto);
			
			fachada.atualizarImovelExecucaoOrdemServicoLigacaoEsgoto(imovel,
					ligacaoEsgotoSituacao);

			FiltroLigacaoEsgoto filtroLigacaoEsgoto = new FiltroLigacaoEsgoto();
			filtroLigacaoEsgoto.adicionarParametro(new ParametroSimples(
					FiltroLigacaoEsgoto.ID, imovel.getId()));
			Collection colecaoLigacaoEsgotoBase = fachada.pesquisar(
					filtroLigacaoEsgoto, LigacaoEsgoto.class.getName());

			if (colecaoLigacaoEsgotoBase != null
					&& !colecaoLigacaoEsgotoBase.isEmpty()) {
				fachada.atualizar(ligacaoEsgoto);
			} else {
				fachada.inserir(ligacaoEsgoto);
			}

			montarPaginaSucesso(httpServletRequest,
					"Liga��o de Esgoto sem RA efetuada com Sucesso",
					"Efetuar outra Liga��o de Esgoto sem RA",
					"exibirEfetuarLigacaoEsgotoSemRAAction.do?menu=sim");

			return retorno;
		} else {
			throw new ActionServletException(
					"atencao.informe_campo_obrigatorio", null,
					"Matr�cula Im�vel");
		}
	}

}
