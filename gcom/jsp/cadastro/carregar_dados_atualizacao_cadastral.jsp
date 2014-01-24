<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/gsanLib.tld" prefix="gsan"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html>

<head>

<%@ include file="/jsp/util/titulo.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<link rel="stylesheet"
	href="<bean:message key="caminho.css"/>EstilosCompesa.css"
	type="text/css">
<script language="JavaScript"
	src="<bean:message key="caminho.js"/>util.js"></script>
	<script language="JavaScript" src="<bean:message key="caminho.js"/>validacao/regras_validator.js"></script><html:javascript staticJavascript="false"  formName="CarregarDadosAtualizacaoCadastralAction" />
<script language="JavaScript">
<!--

	function validarForm(){
	   var form = document.forms[0];
	   var mensagem = '';
	   
	   if(form.arquivo.value == '') {
		  mensagem = 'Informe o Arquivo Texto';
		  alert(mensagem);
	   }else{
	   	 form.submit();		
	   	 //submitForm(form);
	   }
	   
	}


-->
</script>

</head>

<body leftmargin="5" topmargin="5">
<form action="/gsan/carregarDadosAtualizacaoCadastralAction.do"
	method="post" enctype="multipart/form-data">

	<%@ include file="/jsp/util/cabecalho.jsp"%>
	<%@ include file="/jsp/util/menu.jsp"%>
	
	<table width="770" border="0" cellspacing="5" cellpadding="0">
		<tr>
			<td width="130" valign="top" class="leftcoltext">
			<div align="center">
			<p align="left">&nbsp;</p>
			<p align="left">&nbsp;</p>
			<p align="left">&nbsp;</p>
			<%@ include file="/jsp/util/informacoes_usuario.jsp"%>
			<p align="left">&nbsp;</p>
			<p align="left">&nbsp;</p>
			<p align="left">&nbsp;</p>
			<p align="left">&nbsp;</p>
			<p align="left">&nbsp;</p>
			<p align="left">&nbsp;</p>
			<p align="left">&nbsp;</p>
			<p align="left">&nbsp;</p>
			<p align="left">&nbsp;</p>
			<p align="left">&nbsp;</p>
			<p align="left">&nbsp;</p>
			<p align="left">&nbsp;</p>
			<%@ include file="/jsp/util/mensagens.jsp"%>
			<p align="left">&nbsp;</p>
			<p align="left">&nbsp;</p>
			<p align="left">&nbsp;</p>
			<p align="left">&nbsp;</p>
			<p align="left">&nbsp;</p>
			<p align="left">&nbsp;</p>
			<p align="left">&nbsp;</p>
			</div>
			</td>
			<td width="615" valign="top" class="centercoltext">
			<table height="100%">
				<tr>
					<td></td>
				</tr>
			</table>
			<!--In�cio Tabela Reference a P�gina��o da Tela de Processo-->

            <table>
              <tr>
                <td></td>
              </tr>
            </table>
            <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td width="11"><img border="0" src="imagens/parahead_left.gif"/></td>
                <td class="parabg">Gerar Diferen�a Arquivo Texto</td>

                <td width="11" valign="top"><img border="0" src="imagens/parahead_right.gif"/></td>
              </tr>
            </table>
            <!--Fim Tabela Reference a P�gina��o da Tela de Processo-->
            <p>&nbsp;</p>
            <table width="100%" border="0" >
               <tr> 
                  <td colspan="3">Para carregar dados da atualiza��o cadastral, informe os dados abaixo:</td>
                    <tr> 
                  <td width="27%" class="style1">Nome do Arquivo:<strong><font color="#FF0000">*</font></strong></td>
                  <td width="73%" colspan="2" class="style1">
                  <input type="file" style="textbox" name="arquivo"
					size="50" tabindex="1"/> 
                  </td>
                </tr>
                <tr> 
                  <td class="style1">&nbsp;</td>
                  <td colspan="2" class="style1">&nbsp;</td>

                </tr>
                <tr> 
                  <td class="style1"><p>&nbsp;</p></td>
                  <td colspan="2" class="style1">
                   <table>
                      <tr> 
                        <td width="500" align="right">
                        	<div align="left">
                        		<strong>
                        			<font color="#FF0000">*</font>
                        		</strong> 
                            	Campos obrigat&oacute;rios
                            </div>
                        </td>
                        <td>&nbsp;</td>

                      </tr>
             	   </table>
                 </td>
                </tr>
                <tr> 
                  <td class="style1"><p>&nbsp;</p></td>
                  <td colspan="2" class="style1"> 
                   <table>
                      <tr> 
                        <td width="500" align="right"> 
                    	    <input type="button" onClick="javascript:validarForm();"  name="botaoConcluir" class="bottonRightCol" value="Atualizar">
                        </td>
                        <td>&nbsp;</td>

                      </tr>
                   </table>
                  </td>
               </tr>
               

              <logic:present name="colecaoErrosCadastro">
              <tr>
                <td colspan="2">
                  <strong>
                    <font color="#FF0000">Arquivo de atualiza�&atilde;o cadastral possui erros</font>
                  </strong> 
                </td>
              </tr>
              <tr>
                <td colspan="2">                
                  <div style="width: 100%; height: 100%; overflow: auto;">
                    <table width="100%" bgcolor="#99CCFF">
                      <tr bordercolor="#FFFFFF" bgcolor="#90c7fc">
                        <td width="140"> Matr&iacute;cula do im&oacute;vel</td>
                        <td> Descri&ccedil;&atilde;o do erro </td>
                      </tr>
                      <% String cor = "#cbe5fe";%>
                      <logic:iterate name="colecaoErrosCadastro" id="element">
                      <%  if (cor.equalsIgnoreCase("#cbe5fe")){ 
                        cor = "#FFFFFF";%>
                      <tr bgcolor="#FFFFFF" height="18">  
                      <%} else{ 
                        cor = "#cbe5fe";%>
                      <tr bgcolor="#cbe5fe" height="18">    
                      <%}%>
                  
                        <td><bean:write name="element" property="key"/></td>
                        <td>
                          <table>
                            <logic:iterate name="element" property="value" id="erro">
                              <tr>
                              <td><bean:write name="erro"/></td>
                              </tr>
                            </logic:iterate>
                          
                          </table>
                        </td>
                      </tr>                      
                      </logic:iterate>
                    </table>
                  </div>
                </td>
            </tr>
            </logic:present>
                       
            </table>
          	<p class="style1">&nbsp;</p>
          </td>
		</tr>
		<!-- Rodap� -->
		<%@ include file="/jsp/util/rodape.jsp"%>
	</table>
	
</form>
</body>
</html:html>
