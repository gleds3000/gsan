package gcom.gui.arrecadacao.pagamento;

import gcom.arrecadacao.bean.PagamentoHelperCodigoBarras;
import gcom.arrecadacao.bean.RegistroHelperCodigoBarras;
import gcom.arrecadacao.pagamento.bean.InserirPagamentoViaCanetaHelper;
import gcom.cadastro.sistemaparametro.SistemaParametro;
import gcom.fachada.Fachada;
import gcom.gui.ActionServletException;
import gcom.gui.GcomAction;
import gcom.seguranca.acesso.usuario.Usuario;
import gcom.util.Util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorActionForm;

/**
 * Action que inicializa a segunda p�gina do processo de inserir pagamentos 
 * se o tipo de inclus�o for por leitura de c�digo de barras 
 * Este action tamb�m � respons�vel por inserir ou remover um documento na lista de c�digos de barra
 * e gerar os pagamento para cada c�digo de barra informado por leitura �ptica ou por digita��o 
 * 
 * @author 	Pedro Alexandre
 * @date	16/02/2006
 */
public class ExibirInserirPagamentosTipoInclusaoCanetaAction extends GcomAction {

    
	/**
     * Inserir pagamentos no sistema
     *
     * [UC0265] Inserir Pagamentos
     *
     * @author Pedro Alexandre 
     * @date 16/02/2006
     *
     * @param actionMapping
     * @param actionForm
     * @param httpServletRequest
     * @param httpServletResponse
     * @return
     */
    public ActionForward execute(ActionMapping actionMapping,
            					 ActionForm actionForm, 
            					 HttpServletRequest httpServletRequest,
            					 HttpServletResponse httpServletResponse) {
    	
        //Seta o mapeamento de retorno de retorno para po iniserir pagamento por caneta 
        ActionForward retorno = actionMapping.findForward("inserirPagamentosTipoInclusaoCaneta");

        //Recupera o form de pagamento
        DynaValidatorActionForm pagamentoActionForm = (DynaValidatorActionForm) actionForm;
        
        //Cria uma inst�ncia da sess�o
        HttpSession sessao = httpServletRequest.getSession(false);

        //Cria uma inst�ncia da fachada
        Fachada fachada = Fachada.getInstancia();
        
        //Usuario Logado
        Usuario usuarioLogado = (Usuario) sessao.getAttribute("usuarioLogado");
        
        //Verifica se o usu�rio selecionou um documento para remo��o da cole�a�de c�dgos de barra
        String codigoBarraRemocao = httpServletRequest.getParameter("codigoBarraRemocao");
        
        //Recupera o c�digo da forma de arrecada��o
        String idFormaArrecadacao = (String)pagamentoActionForm.get("idFormaArrecadacao");
        
        //Recupera a data do pagamento e verifica se a data � uma data v�lida
        //Caso contr�rio levanta uma exce��o para o usu�rio indicando que a data de
        //pagamento n�o � uma data v�lida
        String dataPagamentoString = (String)pagamentoActionForm.get("dataPagamento");
        Date dataPagamento = null;
        SimpleDateFormat dataFormato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            dataPagamento = dataFormato.parse(dataPagamentoString);
        } catch (ParseException ex) {
        	throw new ActionServletException("atencao.data_pagamento_invalida");
        }
        
        //Recupera os par�metros do sistemas 
        SistemaParametro sistemaParametro = fachada.pesquisarParametrosDoSistema();
        
        //Recupera a cole��o dos objetos que armazenam as informa��es necess�rias dos c�digos de barra
        Collection<InserirPagamentoViaCanetaHelper> colecaoInserirPagamentoViaCanetaHelper = (Collection<InserirPagamentoViaCanetaHelper>) sessao.getAttribute("colecaoInserirPagamentoViaCanetaHelper");
        
        //Se nenhum documento de c�digo de barra na sess�o
        if(colecaoInserirPagamentoViaCanetaHelper == null ){
        	//Inst�ncia a cole��o de documentos
        	colecaoInserirPagamentoViaCanetaHelper = new ArrayList();
        	
        	//Caso exista documentos de c�digo de barra na sess�o
        }else if(!colecaoInserirPagamentoViaCanetaHelper.isEmpty()){
        	
        	//Verifica se o usu�rio indicou um documento para ser removido da cole��o
        	if(codigoBarraRemocao != null && !codigoBarraRemocao.trim().equalsIgnoreCase("")){
        		
        		Iterator iteratorRemocaoCodigoBarra = colecaoInserirPagamentoViaCanetaHelper.iterator();
        		
        		//La�o para encontrar o documento para ser removido
        		lacoWhile : while(iteratorRemocaoCodigoBarra.hasNext()){
        			//Recupera o documento do iterator
        			InserirPagamentoViaCanetaHelper inserirPagamentoViaCanetaHelperParaRemocao = (InserirPagamentoViaCanetaHelper) iteratorRemocaoCodigoBarra.next();
        			
        			//Se o c�digo de barra indicado pelo usu�rio for igual ao 
        			//c�digo de barra do documento
        			if(inserirPagamentoViaCanetaHelperParaRemocao.getCodigoBarra().equalsIgnoreCase(codigoBarraRemocao)){
        				
        				//Remove o documento e termina o la�o
        				iteratorRemocaoCodigoBarra.remove();
        				
        				break lacoWhile;
        			}
        		}
        	}
        }
        
        //Cria a vari�vel que vai armazenar o valor do pagamento
        BigDecimal valorPagamento = null;
        
        //Cria a vari�vel que vai armazenar o c�digo de barras
        String codigoBarra = null;
        
        //Cria as vari�veis que v�o armazenar o c�digo de barra separado por campos
        //e seus respectivos d�gitos verificadores se existirem
        String codigoBarraDigitadoCampo1 = null;
        String codigoBarraDigitadoDigitoVerificadorCampo1 = null;
        String codigoBarraDigitadoCampo2 = null; 
        String codigoBarraDigitadoDigitoVerificadorCampo2 = null;
        String codigoBarraDigitadoCampo3 = null;
        String codigoBarraDigitadoDigitoVerificadorCampo3 = null;
        String codigoBarraDigitadoCampo4 = null;
        String codigoBarraDigitadoDigitoVerificadorCampo4 = null;
        
        
        //Verifica se o c�digo de barras foi lido por caneta �ptica
        String codigoBarraLeituraOtica = (String)pagamentoActionForm.get("codigoBarraPorLeituraOtica");
        
        //Caso o c�digo de barras foi indicado por leitura �tica, recupera todos os campos do c�digo de barra
        //Caso contr�rio recupera os campos de c�digo de barra digitado e seus d�gitos verificadores
        if(codigoBarraLeituraOtica != null && !codigoBarraLeituraOtica.equalsIgnoreCase("")){
        	codigoBarraDigitadoCampo1                  = codigoBarraLeituraOtica.substring(0,11);
        	codigoBarraDigitadoCampo2                  = codigoBarraLeituraOtica.substring(11,22);
        	codigoBarraDigitadoCampo3                  = codigoBarraLeituraOtica.substring(22,33);
        	codigoBarraDigitadoCampo4                  = codigoBarraLeituraOtica.substring(33,44);

        }else{
        	codigoBarraDigitadoCampo1                  = (String)pagamentoActionForm.get("codigoBarraDigitadoCampo1");
        	codigoBarraDigitadoDigitoVerificadorCampo1 = (String)pagamentoActionForm.get("codigoBarraDigitadoDigitoVerificadorCampo1");
        	codigoBarraDigitadoCampo2                  = (String)pagamentoActionForm.get("codigoBarraDigitadoCampo2");
        	codigoBarraDigitadoDigitoVerificadorCampo2 = (String)pagamentoActionForm.get("codigoBarraDigitadoDigitoVerificadorCampo2");
        	codigoBarraDigitadoCampo3                  = (String)pagamentoActionForm.get("codigoBarraDigitadoCampo3");
        	codigoBarraDigitadoDigitoVerificadorCampo3 = (String)pagamentoActionForm.get("codigoBarraDigitadoDigitoVerificadorCampo3");
        	codigoBarraDigitadoCampo4                  = (String)pagamentoActionForm.get("codigoBarraDigitadoCampo4");
        	codigoBarraDigitadoDigitoVerificadorCampo4 = (String)pagamentoActionForm.get("codigoBarraDigitadoDigitoVerificadorCampo4");
        }
        
        //Monta o c�digo de barra sem os d�gitos verificadores
        codigoBarra = codigoBarraDigitadoCampo1 + 
    				  codigoBarraDigitadoCampo2 +
    				  codigoBarraDigitadoCampo3 +
    				  codigoBarraDigitadoCampo4 ;
        
        //Se o c�digo de barra n�o estiver vazio e o tamanho for igual a 44(quarenta e quatro)
        if(codigoBarra != null && !codigoBarra.trim().equalsIgnoreCase("") && codigoBarra.trim().length() == 44){
        	
        	
          //Caso o usu�rio n�o tenha informado a remo��o de c�digo de barra	
          if(codigoBarraRemocao == null || codigoBarraRemocao.trim().equalsIgnoreCase("")){	
        	
        	//Caso o c�digo de barra tenha sido informado por digita��o 
            if(codigoBarraLeituraOtica == null || codigoBarraLeituraOtica.equalsIgnoreCase("")){	
              //[FS0003] E [FS0005] - Validar d�gito verificador do c�digo de barra
              this.validarDigitoVerificador(codigoBarraDigitadoCampo1,codigoBarraDigitadoDigitoVerificadorCampo1,codigoBarraDigitadoCampo2,codigoBarraDigitadoDigitoVerificadorCampo2,codigoBarraDigitadoCampo3,codigoBarraDigitadoDigitoVerificadorCampo3,codigoBarraDigitadoCampo4,codigoBarraDigitadoDigitoVerificadorCampo4);
            }
          
            //Caso o c�digo de barra j� tenha sido informado pelo usu�rio e esteja na lista de documentos
            //[FS0004] - Verificar exist�ncia do documento na lista 
            if(this.verificarExistenciaDocumentoNaLista(codigoBarra, colecaoInserirPagamentoViaCanetaHelper)){
              //Levanta a exce��o para o usu�rio indicando que o documento j� foi informado	
        	  throw new ActionServletException("atencao.documento_informado");
            }else{
        	
        	  //[SB0003] - Processar pagamento com C�digo de Barra
        	  PagamentoHelperCodigoBarras pagamentoHelperCodigoBarras = fachada.processarPagamentosCodigoBarras(codigoBarra, dataPagamento,new Integer(idFormaArrecadacao),sistemaParametro, usuarioLogado);  
        	  
        	  //Recupera a descri��o a ocorr�ncia do movimento
         	  String descricaoOcorrenciaMovimento = pagamentoHelperCodigoBarras.getDescricaoOcorrencia();
         	  
         	  //Recupera o inidicador de aceita��o do registro do movimento
        	  Integer indicadorAceitacaoRegistroMovimento = Integer.parseInt(pagamentoHelperCodigoBarras.getIndicadorAceitacaoRegistro());        	

        	  //Caso o inidicador de aceita��o do registro do movimento seja igual a 1 (SIM) e
        	  //a descri��o a ocorr�ncia do movimento seja igual a "OK"
        	  //Caso contr�rio levanta uma exce��o com a descri��o da ocorr�ncia do movimento
        	  if(indicadorAceitacaoRegistroMovimento == 1 && descricaoOcorrenciaMovimento.equalsIgnoreCase("OK")){
        		
        		/*
        		 * Colocado por Raphael Rossiter em 30/10/2007
        		 * OBJ: Gerar as devoluc�es
        		 */
        		  
        		//Cria o documento para o c�digo de barras informado pelo usu�rio
                InserirPagamentoViaCanetaHelper inserirPagamentoViaCanetaHelper = new InserirPagamentoViaCanetaHelper();  
        		
        		//Adiciona a cole��o de pagamentos retornada pelo [SB0003]  
                inserirPagamentoViaCanetaHelper.setColecaoPagamento(pagamentoHelperCodigoBarras.getColecaoPagamentos());
                
                //Adiciona a devolucao retornada pelo [SB0003]  
                inserirPagamentoViaCanetaHelper.setColecaoDevolucao(pagamentoHelperCodigoBarras.getColecaoDevolucao());
        		
        		//Chama o caso de uso [UC0264] para recuperar todos os dados contidos no c�digode barras
        		RegistroHelperCodigoBarras distribuirDadosCodigoBarras = fachada.distribuirDadosCodigoBarras(codigoBarra);

        		//Recupera o valor do pagamento do c�digo de barra 
        		valorPagamento = (Util.formatarMoedaRealparaBigDecimal(distribuirDadosCodigoBarras.getValorPagamento())).divide(new BigDecimal("100.00"));
        		//valorPagamento = new BigDecimal(distribuirDadosCodigoBarras.getValorPagamento());
        		
                inserirPagamentoViaCanetaHelper.setCodigoBarra(codigoBarraDigitadoCampo1 + codigoBarraDigitadoCampo2 + codigoBarraDigitadoCampo3 + codigoBarraDigitadoCampo4);
                inserirPagamentoViaCanetaHelper.setValorPagamento(valorPagamento);
              
                //Adiciona o documento na cole��o
                colecaoInserirPagamentoViaCanetaHelper.add(inserirPagamentoViaCanetaHelper);
                
                //Limpa os c�digos de barras do form
                pagamentoActionForm.set("codigoBarraDigitadoCampo1","");
            	pagamentoActionForm.set("codigoBarraDigitadoDigitoVerificadorCampo1","");
            	pagamentoActionForm.set("codigoBarraDigitadoCampo2","");
            	pagamentoActionForm.set("codigoBarraDigitadoDigitoVerificadorCampo2","");
            	pagamentoActionForm.set("codigoBarraDigitadoCampo3","");
            	pagamentoActionForm.set("codigoBarraDigitadoDigitoVerificadorCampo3","");
            	pagamentoActionForm.set("codigoBarraDigitadoCampo4","");
            	pagamentoActionForm.set("codigoBarraDigitadoDigitoVerificadorCampo4","");
            	pagamentoActionForm.set("codigoBarraPorLeituraOtica","");  
        	  }else{
        		throw new ActionServletException("atencao.descricao_ocorrencia_movimento",null,descricaoOcorrenciaMovimento);
        	  }
            }
          }
        }
        
        
        //Seta na sess�o a cole��o de documento de c�digos de barra informados e a cole��o de pagamentos gerados
        sessao.setAttribute("colecaoInserirPagamentoViaCanetaHelper",colecaoInserirPagamentoViaCanetaHelper);
        
        //Retorna o mapeamento contido na vari�vel retorno
        return retorno;
    }
    
    /**
     * Verifica se o c�digode barras informado pelo usu�rio j� est� contido na lista de documentos
     *
     * [FS0004] Verificar exist�ncia do documento na lista
     *
     * @author Pedro Alexandre
     * @date 16/02/2006
     *
     * @param codigoBarra
     * @param colecaoPagamentos
     * @return
     */
    private boolean verificarExistenciaDocumentoNaLista(String codigoBarra, Collection<InserirPagamentoViaCanetaHelper> colecaoInserirPagamentoViaCanetaHelper){
    	
    	//Flag para indicar se o c�digode barras j� est� contido na lista de documentos
    	boolean retorno = false;
    	
    	//Caso a lista de documentos n�o esteja vazia
    	if(colecaoInserirPagamentoViaCanetaHelper != null && !colecaoInserirPagamentoViaCanetaHelper.isEmpty()){
    		
    		//La�o para verificar se o documento j� esta na cole��o
    		loopPagamento : for(InserirPagamentoViaCanetaHelper inserirPagamentoViaCanetaHelper : colecaoInserirPagamentoViaCanetaHelper){
    			//Caso o c�digo de barras do documento seja igual ao informado pelo usu�rio
    			if(inserirPagamentoViaCanetaHelper.getCodigoBarra().equals(codigoBarra)){
    				//Indica que o documento j� existe na cole��o
    				retorno = true;
    				
    				//Para o loop
    				break loopPagamento;
    			}
    		}
    	}
    	
    	//Retorna a flag indicando se o documento est� na cole��o
    	return retorno;
    }
    
    /**
     * Valida o c�digo de barras, caso esse tenha sido digitado com seus  d�gitos verificadores
     *
     * [FS0005] Validar D�gito verificador do C�digo de Barras 
     *
     * @author Pedro Alexandre
     * @date 16/02/2006
     *
     * @param campo1
     * @param dvCampo1
     * @param campo2
     * @param dvCampo2
     * @param campo3
     * @param dvCampo3
     * @param campo4
     * @param dvCampo4
     * @return
     */
    private void validarDigitoVerificador(String campo1,String dvCampo1, String campo2,String dvCampo2,String campo3,String dvCampo3,String campo4,String dvCampo4){
    	
    	//Cria as vari�veis quevai armazenar os d�gitos verificadores do m�dulo 11 e 10 respectivamente
    	String dvModulo11 = null;
    	String dvModulo10 = null; 
    	
    	//Caso a terceira posi��o do primeiro campo do c�digo de barras for igual a 6(seis)
    	//Obt�m o digito verificador para o modulo 10(dez)
    	if((campo1.substring(2,3)).equals("6")){
    	  dvModulo10 = Util.obterDigitoVerificadorModulo10(new Long(campo1)).toString();
    	  if(!dvModulo10.equals(dvCampo1)){
    		  throw new ActionServletException("atencao.digitoverificador_invalido");  
    	  }
    	  
    	  dvModulo10 = Util.obterDigitoVerificadorModulo10(new Long(campo2)).toString();
    	  if(!dvModulo10.equals(dvCampo2)){
    		  throw new ActionServletException("atencao.digitoverificador_invalido");
    	  }
    	  
    	  dvModulo10 = Util.obterDigitoVerificadorModulo10(new Long(campo3)).toString();
    	  if(!dvModulo10.equals(dvCampo3)){
    		  throw new ActionServletException("atencao.digitoverificador_invalido");
    	  }
    	  
    	  dvModulo10 = Util.obterDigitoVerificadorModulo10(new Long(campo4)).toString();
    	  if(!dvModulo10.equals(dvCampo4)){
    		  throw new ActionServletException("atencao.digitoverificador_invalido");
    	  }
    	  
    	//Caso a terceira posi��o do primeiro campo do c�digo de barras for igual a 8(oito)
      	//Obt�m o digito verificador para o modulo 11(onze)
    	}else if((campo1.substring(2,3)).equals("8")){
    		dvModulo11 = Util.obterDigitoVerificadorModulo11(new Long(campo1)).toString();
    		if(!dvModulo11.equals(dvCampo1)){
    			throw new ActionServletException("atencao.digitoverificador_invalido");
        	  }
    		
    		dvModulo11 = Util.obterDigitoVerificadorModulo11(new Long(campo2)).toString();
    		if(!dvModulo11.equals(dvCampo2)){
    			throw new ActionServletException("atencao.digitoverificador_invalido");
        	  }

    		dvModulo11 = Util.obterDigitoVerificadorModulo11(new Long(campo3)).toString();
    		if(!dvModulo11.equals(dvCampo3)){
    			throw new ActionServletException("atencao.digitoverificador_invalido");
        	  }

    		dvModulo11 = Util.obterDigitoVerificadorModulo11(new Long(campo4)).toString();
    		if(!dvModulo11.equals(dvCampo4)){
    			throw new ActionServletException("atencao.digitoverificador_invalido");
        	  }

    		//Caso a terceira posi��o do primeiro campo do c�digo de barras n�o for igual a 6(seis)
    		//ou n�o for igual a 8(oito), levanta uma exce��o indicando que a indica��o do m�dulo � inv�lida
    	}else{
    		throw new ActionServletException("atencao.indicacaomodulo_invalido");
    	}
    }    
}
