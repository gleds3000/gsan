package gcom.gui.cobranca;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * [UC0243] Inserir Comando de A��o de Cobran�a - Tipo de Comando Cronograma
 * 
 * @author Rafael Santos
 * @since 24/01/2006
 */
public class InserirComandoAcaoCobrancaEventualCriterioRotaActionForm extends
		ActionForm {
	private static final long serialVersionUID = 1L;

	private String gerenciaRegional;

	private String unidadeNegocio;

	private String localidadeOrigemID;

	private String localidadeDestinoID;

	private String inscricaoTipo;

	private String nomeLocalidadeOrigem;

	private String nomeLocalidadeDestino;

	private String setorComercialOrigemCD;

	private String setorComercialOrigemID;

	private String nomeSetorComercialOrigem;

	private String setorComercialDestinoCD;

	private String setorComercialDestinoID;

	private String nomeSetorComercialDestino;

	private String rotaInicial;

	private String rotaFinal;

	private String idCliente;

	private String nomeCliente;

	private String clienteRelacaoTipo;

	private String periodoInicialConta;

	private String periodoFinalConta;

	private String periodoVencimentoContaInicial;

	private String periodoVencimentoContaFinal;

	private String[] cobrancaAcao;

	private String cobrancaAtividade;

	private String cobrancaGrupo;

	private String indicador;

	private String cobrancaAtividadeIndicadorExecucao;

	private String idComando;

	private String titulo;

	private String descricaoSolicitacao;

	private String prazoExecucao;
	
	private String quantidadeMaximaDocumentos;
	
	private String indicadorImoveisDebito;
	
	private String indicadorGerarBoletimCadastro;
	
	private String codigoClienteSuperior;
	
	private String nomeClienteSuperior;
	
	private String valorLimiteObrigatoria;
	
	private String logradouroId;
	
	private String logradouroDescricao;
	
	private String consumoMedioInicial;
	
	private String consumoMedioFinal;
	
	private String tipoConsumo;
	
	private String periodoInicialFiscalizacao;

	private String periodoFinalFiscalizacao;
	
	private String[] situacaoFiscalizacao;
	
	private String numeroQuadraInicial;
	private String numeroQuadraFinal;


	public String getLogradouroDescricao() {
		return logradouroDescricao;
	}

	public void setLogradouroDescricao(String logradouroDescricao) {
		this.logradouroDescricao = logradouroDescricao;
	}

	public String getLogradouroId() {
		return logradouroId;
	}

	public void setLogradouroId(String logradouroId) {
		this.logradouroId = logradouroId;
	}

	public ActionErrors validate(ActionMapping actionMapping,
			HttpServletRequest httpServletRequest) {
		/** @todo: finish this method, this is just the skeleton. */
		return null;
	}

	public void reset(ActionMapping actionMapping,
			HttpServletRequest httpServletRequest) {

		/*
		 * gerenciaRegional = null;
		 * 
		 * localidadeOrigemID = null;
		 * 
		 * localidadeDestinoID = null;
		 * 
		 * inscricaoTipo = null;
		 * 
		 * nomeLocalidadeOrigem = null;
		 * 
		 * nomeLocalidadeDestino = null;
		 * 
		 * setorComercialOrigemCD = null;
		 * 
		 * setorComercialOrigemID = null;
		 * 
		 * nomeSetorComercialOrigem = null;
		 * 
		 * setorComercialDestinoCD = null;
		 * 
		 * setorComercialDestinoID = null;
		 * 
		 * nomeSetorComercialDestino = null;
		 * 
		 * rotaInicial = null;
		 * 
		 * rotaFinal = null;
		 * 
		 * idCliente = null;
		 * 
		 * nomeCliente = null;
		 * 
		 * clienteRelacaoTipo = null;
		 * 
		 * periodoInicialConta = null;
		 * 
		 * periodoFinalConta = null;
		 * 
		 * periodoVencimentoContaInicial = null;
		 * 
		 * periodoVencimentoContaFinal = null;
		 * 
		 * cobrancaAcao = null;
		 * 
		 * cobrancaAtividade = null;
		 * 
		 * cobrancaGrupo = null;
		 * 
		 * indicador = null;
		 * 
		 * cobrancaAtividadeIndicadorExecucao = null;
		 */
	}

	/**
	 * @return Returns the gerenciaRegional.
	 */
	public String getGerenciaRegional() {
		return gerenciaRegional;
	}

	/**
	 * @param gerenciaRegional
	 *            The gerenciaRegional to set.
	 */
	public void setGerenciaRegional(String gerenciaRegional) {
		this.gerenciaRegional = gerenciaRegional;
	}

	/**
	 * @return Returns the localidadeOrigemID.
	 */
	public String getLocalidadeOrigemID() {
		return localidadeOrigemID;
	}

	/**
	 * @param localidadeOrigemID
	 *            The localidadeOrigemID to set.
	 */
	public void setLocalidadeOrigemID(String localidadeOrigemID) {
		this.localidadeOrigemID = localidadeOrigemID;
	}

	/**
	 * @return Returns the inscricaoTipo.
	 */
	public String getInscricaoTipo() {
		return inscricaoTipo;
	}

	/**
	 * @param inscricaoTipo
	 *            The inscricaoTipo to set.
	 */
	public void setInscricaoTipo(String inscricaoTipo) {
		this.inscricaoTipo = inscricaoTipo;
	}

	/**
	 * @return Returns the nomeLocalidadeOrigem.
	 */
	public String getNomeLocalidadeOrigem() {
		return nomeLocalidadeOrigem;
	}

	/**
	 * @param nomeLocalidadeOrigem
	 *            The nomeLocalidadeOrigem to set.
	 */
	public void setNomeLocalidadeOrigem(String nomeLocalidadeOrigem) {
		this.nomeLocalidadeOrigem = nomeLocalidadeOrigem;
	}

	/**
	 * @return Returns the localidadeDestinoID.
	 */
	public String getLocalidadeDestinoID() {
		return localidadeDestinoID;
	}

	/**
	 * @param localidadeDestinoID
	 *            The localidadeDestinoID to set.
	 */
	public void setLocalidadeDestinoID(String localidadeDestinoID) {
		this.localidadeDestinoID = localidadeDestinoID;
	}

	/**
	 * @return Returns the nomeLocalidadeDestino.
	 */
	public String getNomeLocalidadeDestino() {
		return nomeLocalidadeDestino;
	}

	/**
	 * @param nomeLocalidadeDestino
	 *            The nomeLocalidadeDestino to set.
	 */
	public void setNomeLocalidadeDestino(String nomeLocalidadeDestino) {
		this.nomeLocalidadeDestino = nomeLocalidadeDestino;
	}

	/**
	 * @return Returns the setorComercialOrigemCD.
	 */
	public String getSetorComercialOrigemCD() {
		return setorComercialOrigemCD;
	}

	/**
	 * @param setorComercialOrigemCD
	 *            The setorComercialOrigemCD to set.
	 */
	public void setSetorComercialOrigemCD(String setorComercialOrigemCD) {
		this.setorComercialOrigemCD = setorComercialOrigemCD;
	}

	/**
	 * @return Returns the setorComercialOrigemID.
	 */
	public String getSetorComercialOrigemID() {
		return setorComercialOrigemID;
	}

	/**
	 * @param setorComercialOrigemID
	 *            The setorComercialOrigemID to set.
	 */
	public void setSetorComercialOrigemID(String setorComercialOrigemID) {
		this.setorComercialOrigemID = setorComercialOrigemID;
	}

	/**
	 * @return Returns the nomeSetorComercialOrigem.
	 */
	public String getNomeSetorComercialOrigem() {
		return nomeSetorComercialOrigem;
	}

	/**
	 * @param nomeSetorComercialOrigem
	 *            The nomeSetorComercialOrigem to set.
	 */
	public void setNomeSetorComercialOrigem(String nomeSetorComercialOrigem) {
		this.nomeSetorComercialOrigem = nomeSetorComercialOrigem;
	}

	/**
	 * @return Returns the nomeSetorComercialDestino.
	 */
	public String getNomeSetorComercialDestino() {
		return nomeSetorComercialDestino;
	}

	/**
	 * @param nomeSetorComercialDestino
	 *            The nomeSetorComercialDestino to set.
	 */
	public void setNomeSetorComercialDestino(String nomeSetorComercialDestino) {
		this.nomeSetorComercialDestino = nomeSetorComercialDestino;
	}

	/**
	 * @return Returns the setorComercialDestinoCD.
	 */
	public String getSetorComercialDestinoCD() {
		return setorComercialDestinoCD;
	}

	/**
	 * @param setorComercialDestinoCD
	 *            The setorComercialDestinoCD to set.
	 */
	public void setSetorComercialDestinoCD(String setorComercialDestinoCD) {
		this.setorComercialDestinoCD = setorComercialDestinoCD;
	}

	/**
	 * @return Returns the setorComercialDestinoID.
	 */
	public String getSetorComercialDestinoID() {
		return setorComercialDestinoID;
	}

	/**
	 * @param setorComercialDestinoID
	 *            The setorComercialDestinoID to set.
	 */
	public void setSetorComercialDestinoID(String setorComercialDestinoID) {
		this.setorComercialDestinoID = setorComercialDestinoID;
	}

	/**
	 * @return Returns the rota.
	 */
	public String getRotaInicial() {
		return rotaInicial;
	}

	/**
	 * @param rota
	 *            The rota to set.
	 */
	public void setRotaInicial(String rota) {
		this.rotaInicial = rota;
	}

	/**
	 * @return Returns the rotaFinal.
	 */
	public String getRotaFinal() {
		return rotaFinal;
	}

	/**
	 * @param rotaFinal
	 *            The rotaFinal to set.
	 */
	public void setRotaFinal(String rotaFinal) {
		this.rotaFinal = rotaFinal;
	}

	/**
	 * @return Returns the idCliente.
	 */
	public String getIdCliente() {
		return idCliente;
	}

	/**
	 * @param idCliente
	 *            The idCliente to set.
	 */
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	/**
	 * @return Returns the nomeCliente.
	 */
	public String getNomeCliente() {
		return nomeCliente;
	}

	/**
	 * @param nomeCliente
	 *            The nomeCliente to set.
	 */
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	/**
	 * @return Returns the clienteRelacaoTipo.
	 */
	public String getClienteRelacaoTipo() {
		return clienteRelacaoTipo;
	}

	/**
	 * @param clienteRelacaoTipo
	 *            The clienteRelacaoTipo to set.
	 */
	public void setClienteRelacaoTipo(String clienteRelacaoTipo) {
		this.clienteRelacaoTipo = clienteRelacaoTipo;
	}

	/**
	 * @return Returns the periodoFinalConta.
	 */
	public String getPeriodoFinalConta() {
		return periodoFinalConta;
	}

	/**
	 * @param periodoFinalConta
	 *            The periodoFinalConta to set.
	 */
	public void setPeriodoFinalConta(String periodoFinalConta) {
		this.periodoFinalConta = periodoFinalConta;
	}

	/**
	 * @return Returns the periodoInicialConta.
	 */
	public String getPeriodoInicialConta() {
		return periodoInicialConta;
	}

	/**
	 * @param periodoInicialConta
	 *            The periodoInicialConta to set.
	 */
	public void setPeriodoInicialConta(String periodoInicialConta) {
		this.periodoInicialConta = periodoInicialConta;
	}

	/**
	 * @return Returns the periodoVencimentoContaFinal.
	 */
	public String getPeriodoVencimentoContaFinal() {
		return periodoVencimentoContaFinal;
	}

	/**
	 * @param periodoVencimentoContaFinal
	 *            The periodoVencimentoContaFinal to set.
	 */
	public void setPeriodoVencimentoContaFinal(
			String periodoVencimentoContaFinal) {
		this.periodoVencimentoContaFinal = periodoVencimentoContaFinal;
	}

	/**
	 * @return Returns the periodoVencimentoContaInicial.
	 */
	public String getPeriodoVencimentoContaInicial() {
		return periodoVencimentoContaInicial;
	}

	/**
	 * @param periodoVencimentoContaInicial
	 *            The periodoVencimentoContaInicial to set.
	 */
	public void setPeriodoVencimentoContaInicial(
			String periodoVencimentoContaInicial) {
		this.periodoVencimentoContaInicial = periodoVencimentoContaInicial;
	}



	public String[] getCobrancaAcao() {
		return cobrancaAcao;
	}

	public void setCobrancaAcao(String[] cobrancaAcao) {
		this.cobrancaAcao = cobrancaAcao;
	}

	/**
	 * @return Returns the cobrancaAtividade.
	 */
	public String getCobrancaAtividade() {
		return cobrancaAtividade;
	}

	/**
	 * @param cobrancaAtividade
	 *            The cobrancaAtividade to set.
	 */
	public void setCobrancaAtividade(String cobrancaAtividade) {
		this.cobrancaAtividade = cobrancaAtividade;
	}

	/**
	 * @return Returns the cobrancaGrupo.
	 */
	public String getCobrancaGrupo() {
		return cobrancaGrupo;
	}

	/**
	 * @param cobrancaGrupo
	 *            The cobrancaGrupo to set.
	 */
	public void setCobrancaGrupo(String cobrancaGrupo) {
		this.cobrancaGrupo = cobrancaGrupo;
	}

	/**
	 * @return Returns the indicador.
	 */
	public String getIndicador() {
		return indicador;
	}

	/**
	 * @param indicador
	 *            The indicador to set.
	 */
	public void setIndicador(String indicador) {
		this.indicador = indicador;
	}

	/**
	 * @return Retorna o campo cobrancaAtividadeIndicadorExecucao.
	 */
	public String getCobrancaAtividadeIndicadorExecucao() {
		return cobrancaAtividadeIndicadorExecucao;
	}

	/**
	 * @param cobrancaAtividadeIndicadorExecucao
	 *            O cobrancaAtividadeIndicadorExecucao a ser setado.
	 */
	public void setCobrancaAtividadeIndicadorExecucao(
			String cobrancaAtividadeIndicadorExecucao) {
		this.cobrancaAtividadeIndicadorExecucao = cobrancaAtividadeIndicadorExecucao;
	}

	public String getIdComando() {
		return idComando;
	}

	public void setIdComando(String idComando) {
		this.idComando = idComando;
	}

	/**
	 * @return Retorna o campo unidadeNegocio.
	 */
	public String getUnidadeNegocio() {
		return unidadeNegocio;
	}

	/**
	 * @param unidadeNegocio
	 *            O unidadeNegocio a ser setado.
	 */
	public void setUnidadeNegocio(String unidadeNegocio) {
		this.unidadeNegocio = unidadeNegocio;
	}

	public String getDescricaoSolicitacao() {
		return descricaoSolicitacao;
	}

	public void setDescricaoSolicitacao(String descricaoSolicitacao) {
		this.descricaoSolicitacao = descricaoSolicitacao;
	}

	public String getPrazoExecucao() {
		return prazoExecucao;
	}

	public void setPrazoExecucao(String prazoExecucao) {
		this.prazoExecucao = prazoExecucao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public String getIndicadorGerarBoletimCadastro() {
		return indicadorGerarBoletimCadastro;
	}

	public void setIndicadorGerarBoletimCadastro(
			String indicadorGerarBoletimCadastro) {
		this.indicadorGerarBoletimCadastro = indicadorGerarBoletimCadastro;
	}

	public String getIndicadorImoveisDebito() {
		return indicadorImoveisDebito;
	}

	public void setIndicadorImoveisDebito(String indicadorImoveisDebito) {
		this.indicadorImoveisDebito = indicadorImoveisDebito;
	}

	public String getQuantidadeMaximaDocumentos() {
		return quantidadeMaximaDocumentos;
	}

	public void setQuantidadeMaximaDocumentos(String quantidadeMaximaDocumentos) {
		this.quantidadeMaximaDocumentos = quantidadeMaximaDocumentos;
	}

	public String getCodigoClienteSuperior() {
		return codigoClienteSuperior;
	}

	public void setCodigoClienteSuperior(String codigoClienteSuperior) {
		this.codigoClienteSuperior = codigoClienteSuperior;
	}

	public String getNomeClienteSuperior() {
		return nomeClienteSuperior;
	}

	public void setNomeClienteSuperior(String nomeClienteSuperior) {
		this.nomeClienteSuperior = nomeClienteSuperior;
	}

	/**
	 * @return Retorna o campo valorLimiteObrigatoria.
	 */
	public String getValorLimiteObrigatoria() {
		return valorLimiteObrigatoria;
	}

	/**
	 * @param valorLimiteObrigatoria O valorLimiteObrigatoria a ser setado.
	 */
	public void setValorLimiteObrigatoria(String valorLimiteObrigatoria) {
		this.valorLimiteObrigatoria = valorLimiteObrigatoria;
	}
	
	public String getTipoConsumo() {
		return tipoConsumo;
	}

	public void setTipoConsumo(String tipoConsumo) {
		this.tipoConsumo = tipoConsumo;
	}

	public String getConsumoMedioInicial() {
		return consumoMedioInicial;
	}

	public void setConsumoMedioInicial(String consumoMedioInicial) {
		this.consumoMedioInicial = consumoMedioInicial;
	}

	public String getConsumoMedioFinal() {
		return consumoMedioFinal;
	}

	public void setConsumoMedioFinal(String consumoMedioFinal) {
		this.consumoMedioFinal = consumoMedioFinal;
	}

	public String getPeriodoInicialFiscalizacao() {
		return periodoInicialFiscalizacao;
	}

	public void setPeriodoInicialFiscalizacao(String periodoInicialFiscalizacao) {
		this.periodoInicialFiscalizacao = periodoInicialFiscalizacao;
	}

	public String getPeriodoFinalFiscalizacao() {
		return periodoFinalFiscalizacao;
	}

	public void setPeriodoFinalFiscalizacao(String periodoFinalFiscalizacao) {
		this.periodoFinalFiscalizacao = periodoFinalFiscalizacao;
	}

	public String[] getSituacaoFiscalizacao() {
		return situacaoFiscalizacao;
	}

	public void setSituacaoFiscalizacao(String[] situacaoFiscalizacao) {
		this.situacaoFiscalizacao = situacaoFiscalizacao;
	}

	public String getNumeroQuadraFinal() {
		return numeroQuadraFinal;
	}

	public void setNumeroQuadraFinal(String numeroQuadraFinal) {
		this.numeroQuadraFinal = numeroQuadraFinal;
	}

	public String getNumeroQuadraInicial() {
		return numeroQuadraInicial;
	}

	public void setNumeroQuadraInicial(String numeroQuadraInicial) {
		this.numeroQuadraInicial = numeroQuadraInicial;
	}
	
	

}
