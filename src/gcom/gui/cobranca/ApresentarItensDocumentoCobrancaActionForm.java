package gcom.gui.cobranca;

import org.apache.struts.action.*;

import javax.servlet.http.*;

/**
 * 
 * @author Raphael Rossiter
 * @date 05/04/2006
 */
public class ApresentarItensDocumentoCobrancaActionForm extends ActionForm {
	
	private static final long serialVersionUID = 1L;

	private String matriculaImovel;
	private String inscricaoImovel;
	private String situacaoAguaImovel;
	private String situacaoEsgotoImovel;
	private String sequencial;
	private String valorDocumento;
	private String valorDesconto;
	private String formaEmissao;
	private String dataHoraEmissao;
	private String motivoNaoEntregaDocumento;
	private String qtdItens;
	
	
	public String getFormaEmissao() {
		return formaEmissao;
	}
	public void setFormaEmissao(String formaEmissao) {
		this.formaEmissao = formaEmissao;
	}
	public String getInscricaoImovel() {
		return inscricaoImovel;
	}
	public void setInscricaoImovel(String inscricaoImovel) {
		this.inscricaoImovel = inscricaoImovel;
	}
	public String getMatriculaImovel() {
		return matriculaImovel;
	}
	public void setMatriculaImovel(String matriculaImovel) {
		this.matriculaImovel = matriculaImovel;
	}
	public String getMotivoNaoEntregaDocumento() {
		return motivoNaoEntregaDocumento;
	}
	public void setMotivoNaoEntregaDocumento(String motivoNaoEntregaDocumento) {
		this.motivoNaoEntregaDocumento = motivoNaoEntregaDocumento;
	}
	public String getQtdItens() {
		return qtdItens;
	}
	public void setQtdItens(String qtdItens) {
		this.qtdItens = qtdItens;
	}
	public String getSequencial() {
		return sequencial;
	}
	public void setSequencial(String sequencial) {
		this.sequencial = sequencial;
	}
	public String getSituacaoAguaImovel() {
		return situacaoAguaImovel;
	}
	public void setSituacaoAguaImovel(String situacaoAguaImovel) {
		this.situacaoAguaImovel = situacaoAguaImovel;
	}
	public String getSituacaoEsgotoImovel() {
		return situacaoEsgotoImovel;
	}
	public void setSituacaoEsgotoImovel(String situacaoEsgotoImovel) {
		this.situacaoEsgotoImovel = situacaoEsgotoImovel;
	}
	public String getValorDesconto() {
		return valorDesconto;
	}
	public void setValorDesconto(String valorDesconto) {
		this.valorDesconto = valorDesconto;
	}
	public String getValorDocumento() {
		return valorDocumento;
	}
	public void setValorDocumento(String valorDocumento) {
		this.valorDocumento = valorDocumento;
	}
	
	public ActionErrors validate(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
	    /**@todo: finish this method, this is just the skeleton.*/
	    return null;
	}
	public void reset(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
	}
	public String getDataHoraEmissao() {
		return dataHoraEmissao;
	}
	public void setDataHoraEmissao(String dataHoraEmissao) {
		this.dataHoraEmissao = dataHoraEmissao;
	}
}
