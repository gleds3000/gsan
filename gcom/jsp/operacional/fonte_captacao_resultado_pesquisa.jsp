<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/pager-taglib.tld" prefix="pg" %>
<html:html>

<%@ page import="java.util.Collection,gcom.util.ConstantesSistema" %>

<head>
<title>GSAN - Sistema Integrado de Gest&atilde;o de Servi&ccedil;os de Saneamento</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<link rel="stylesheet" href="<bean:message key="caminho.css"/>EstilosCompesa.css" type="text/css">
<script language="JavaScript" src="<bean:message key="caminho.js"/>util.js"></script>
<script language="JavaScript">
function enviarIdParaInserir(idFonteCaptacao) {
	opener.redirecionarSubmitAtualizar(idFonteCaptacao);
	self.close();
}
</script>
</head>

<body leftmargin="0" topmargin="0" onload="resizePageSemLink(660, 430);">
<table width="630" border="0" cellspacing="5" cellpadding="0">
  <tr>
    <td width="630" valign="top" class="centercoltext"> <table height="100%">
        <tr>
          <td></td>
        </tr>
      </table>
      <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td width="11"><img border="0" src="<bean:message key="caminho.imagens"/>parahead_left.gif"/></td>
          <td class="parabg">Pesquisa de Fonte de Captacao</td>
          <td width="11"><img border="0" src="<bean:message key="caminho.imagens"/>parahead_right.gif"/></td>
        </tr>
      </table>
      <p>&nbsp;</p>
      <table width="100%" border="0" bgcolor="#90c7fc">
        <tr align="left" >
          <td width="15%" align="center"><strong>Tipo de Capta��o</strong></td>
          <td align="center" width="15%"><strong>C�digo Fonte de Capta��o</strong></td>
          <td width="35%" align="center"><strong>Descri��o</strong></td>
          <td width="35%" align="center"><strong>Descri��o Abreviada</strong></td>
        </tr>
	<%--Esquema de pagina��o--%>
		<pg:pager isOffset="true" index="half-full" maxIndexPages="10"
			export="currentPageNumber=pageNumber;pageOffset"
			maxPageItems="10" items="${sessionScope.totalRegistros}">
			<pg:param name="q" />
				<%int cont = 0;%>


         <logic:iterate name="fonteCaptacao" id="fonteCaptacao">
          <pg:item>
			<%cont = cont + 1;
			if (cont % 2 == 0) {%>
				<tr bgcolor="#cbe5fe">
			<%} else {	%>
				<tr bgcolor="#FFFFFF">
			<%}%>
			
			
		  <td align="center">
            <logic:notEqual name="fonteCaptacao" property="indicadorUso" value="<%=ConstantesSistema.INDICADOR_USO_DESATIVO.toString()%>">            
				<bean:write name="fonteCaptacao" property="tipoCaptacao.descricao"/>
            </logic:notEqual>
            <logic:equal name="fonteCaptacao" property="indicadorUso" value="<%=ConstantesSistema.INDICADOR_USO_DESATIVO.toString()%>">            
				<font color="#CC0000"> 
					<bean:write name="fonteCaptacao" property="tipoCaptacao.descricao"/>
				</font>
            </logic:equal>
          </td>
			
			
			
        <td align="center">
            <logic:notEqual name="fonteCaptacao" property="indicadorUso" value="<%=ConstantesSistema.INDICADOR_USO_DESATIVO.toString()%>">            
				<bean:write name="fonteCaptacao" property="id"/>
            </logic:notEqual>
            <logic:equal name="fonteCaptacao" property="indicadorUso" value="<%=ConstantesSistema.INDICADOR_USO_DESATIVO.toString()%>">            
				<font color="#CC0000"> 
					<bean:write name="fonteCaptacao" property="id"/>
				</font>
            </logic:equal>
          </td>
			
			
          <td align="center">
            <logic:notEqual name="fonteCaptacao" property="indicadorUso" value="<%=ConstantesSistema.INDICADOR_USO_DESATIVO.toString()%>">            
				<a href="javascript:enviarDados('<bean:write name="fonteCaptacao" property="id"/>', '<bean:write name="fonteCaptacao" property="descricao"/>', 'fonteCaptacao');"> 
				
				<bean:write name="fonteCaptacao" property="descricao"/>
            </logic:notEqual>
            <logic:equal name="fonteCaptacao" property="indicadorUso" value="<%=ConstantesSistema.INDICADOR_USO_DESATIVO.toString()%>">            
				<font color="#CC0000"> 
					<bean:write name="fonteCaptacao" property="descricao"/>
				</font>
            </logic:equal>
          </td>
          
          <td align="center">
				<bean:write name="fonteCaptacao" property="descricaoAbreviada"/>
          </td>
		  
        </tr>
	</pg:item>
      </logic:iterate>
		</table>

		<table width="100%" border="0">
			<tr>
				<td>
				<div align="center"><strong><%@ include
					file="/jsp/util/indice_pager_novo.jsp"%></strong></div>
				</td>
				</pg:pager>
				<%-- Fim do esquema de pagina��o --%>
			</tr>
		</table>
      <table width="100%" border="0">

         <tr>
          <td height="24"><input type="button" class="bottonRightCol" value="Voltar Pesquisa" onclick="window.location.href='<html:rewrite page="/exibirPesquisarFonteCaptacaoAction.do?objetoConsulta=1"/>'"/></td>
        </tr>
      </table>
      <%-- Fim do esquema de pagina��o --%>
      </td>
  </tr>
  </table>

</body>
</html:html>
