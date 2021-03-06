package gcom.cadastro.imovel;

import gcom.util.filtro.Filtro;

import java.io.Serializable;

/**
 * Description of the Class
 * 
 * @author S�vio Luiz
 */
public class FiltroImovelSubCategoria extends Filtro implements Serializable {
	
	private static final long serialVersionUID = 1L;
    /**
     * Constructor for the FiltroImovelSubCategoria object
     */
    public FiltroImovelSubCategoria() {
    }

    /**
     * Constructor for the FiltroCliente object
     * 
     * @param campoOrderBy
     *            Description of the Parameter
     */
    public FiltroImovelSubCategoria(String campoOrderBy) {
        this.campoOrderBy = campoOrderBy;
    }

    /**
     * Description of the Field
     */
    public final static String IMOVEL_ID = "comp_id.imovel.id";
    // Para o distinct
    public final static String IMOVEL = "objeto.comp_id.imovel";
    
    public final static String IMOVEL_INDICADOR_EXCLUSAO = "comp_id.imovel.indicadorExclusao";

    /**
     * Description of the Field
     */
    public final static String SUBCATEGORIA_ID = "comp_id.subcategoria.id";
    
    /**
     * Description of the Field
     */
    public final static String SUBCATEGORIA = "comp_id.subcategoria";
    
    /**
     * Description of the Field
     */
    public final static String SUBCATEGORIA_CATEGORIA_ID = "comp_id.subcategoria.categoria.id";
    
    /**
     * Description of the Field
     */
    public final static String SUBCATEGORIA_CATEGORIA = "comp_id.subcategoria.categoria";

    /**
     * Description of the Field
     */
    public final static String IMOVEL_ECONOMIAS = "imovelEconomias";
    
    public final static String IMOVEL_CONDOMINIO_ID = "comp_id.imovel.imovelCondominio.id";
    
    public final static String GRUPO_FATURAMENTO = "comp_id.imovel.quadra.rota.faturamentoGrupo.id";
    
    public final static String EMPRESA_LEITURA = "comp_id.imovel.quadra.rota.empresa.id";
    
    public final static String IMOVEL_LOCALIDADE = "comp_id.imovel.localidade.id";
    
    public final static String IMOVEL_SETOR_COMERCIAL = "comp_id.imovel.setorComercial.id";
    
    public final static String IMOVEL_SETOR_COMERCIAL_CODIGO = "comp_id.imovel.setorComercial.codigo";
    
    public final static String IMOVEL_QUADRA = "comp_id.imovel.quadra.id";
    
    public final static String IMOVEL_QUADRA_NUMERO = "comp_id.imovel.quadra.numeroQuadra";
    
    public final static String IMOVEL_INDICADOR_CONDOMINIO = "comp_id.imovel.indicadorImovelCondominio";
    
    public final static String IMOVEL_PERFIL = "comp_id.imovel.imovelPerfil.id";
    
    public final static String IMOVEL_CATEGORIA = "comp_id.subcategoria.categoria.id";
    
    public final static String IMOVEL_EMPRESA = "comp_id.imovel.quadra.rota.empresa.id";
    
    public final static String IMOVEL_QTD_ECONOMIAS = "comp_id.imovel.quantidadeEconomias";
    
    public final static String CODIGO_TARIFA_SOCIAL = "comp_id.subcategoria.codigoTarifaSocial";
    
}
