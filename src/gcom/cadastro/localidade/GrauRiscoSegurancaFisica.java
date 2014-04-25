package gcom.cadastro.localidade;import gcom.interceptor.ObjetoTransacao;import gcom.util.filtro.Filtro;import gcom.util.filtro.ParametroSimples;import java.util.Date;
/** @author Hibernate CodeGenerator *//** * Descri��o da classe *  * @author Hugo Leonardo * @date 27/04/2010 */
public class GrauRiscoSegurancaFisica extends ObjetoTransacao{		private static final long serialVersionUID = 1L;	/** persistent field */
	private Integer id;		/** persistent field */	private Short indicativoGrauRiscoSegurancaFisica;		/** persistent field */	private String descricao;		/** persistent field */	private Date ultimaAlteracao;	public String[] retornaCamposChavePrimaria(){		String[] retorno = new String[1];		retorno[0] = "id";		return retorno;	}
	public GrauRiscoSegurancaFisica() {
	}	public Integer getId() {		return id;	}	public void setId(Integer id) {		this.id = id;	}	public Date getUltimaAlteracao() {		return ultimaAlteracao;	}	public void setUltimaAlteracao(Date ultimaAlteracao) {		this.ultimaAlteracao = ultimaAlteracao;	}	public String getDescricao() {		return descricao;	}	public void setDescricao(String descricao) {		this.descricao = descricao;	}	public Short getIndicativoGrauRiscoSegurancaFisica() {		return indicativoGrauRiscoSegurancaFisica;	}	public void setIndicativoGrauRiscoSegurancaFisica(			Short indicativoGrauRiscoSegurancaFisica) {		this.indicativoGrauRiscoSegurancaFisica = indicativoGrauRiscoSegurancaFisica;	}	public Filtro retornaFiltro() {		FiltroGrauRiscoSegurancaFisica filtroGrauRiscoSegurancaFisica = new FiltroGrauRiscoSegurancaFisica();		filtroGrauRiscoSegurancaFisica.adicionarParametro(new ParametroSimples(FiltroGrauRiscoSegurancaFisica.ID,				this.getId()));						return filtroGrauRiscoSegurancaFisica;	}	}
