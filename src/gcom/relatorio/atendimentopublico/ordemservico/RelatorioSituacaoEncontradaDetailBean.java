package gcom.relatorio.atendimentopublico.ordemservico;

import gcom.relatorio.RelatorioBean;

/**
 * @author Vivianne Sousa
 * @date 23/05/2011
 */
public class RelatorioSituacaoEncontradaDetailBean implements RelatorioBean {
	
	private String descricaoSituacaoEncontrada;

	public String getDescricaoSituacaoEncontrada() {
		return descricaoSituacaoEncontrada;
	}

	public void setDescricaoSituacaoEncontrada(String descricaoSituacaoEncontrada) {
		this.descricaoSituacaoEncontrada = descricaoSituacaoEncontrada;
	}

	public RelatorioSituacaoEncontradaDetailBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RelatorioSituacaoEncontradaDetailBean(String descricaoSituacaoEncontrada) {
		super();
		// TODO Auto-generated constructor stub
		this.descricaoSituacaoEncontrada = descricaoSituacaoEncontrada;
	} 
	
}
