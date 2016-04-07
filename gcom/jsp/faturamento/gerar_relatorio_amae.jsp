<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/gsanLib.tld" prefix="gsan" %>

<%@page isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html>
<head>

<%@ include file="/jsp/util/titulo.jsp"%>
<link rel="stylesheet" href="<bean:message key="caminho.css"/>EstilosCompesa.css" type="text/css">
<script language="JavaScript" src="<bean:message key="caminho.js"/>util.js"></script>
<script language="JavaScript" src="<bean:message key="caminho.js"/>validacao/regras_validator.js"></script>

<script language="JavaScript">
	function validarForm(){
	   var form = document.forms[0];
	   form.submit();
	}
</script>

</head>
<body leftmargin="5" topmargin="5" onload="javascript:setarFoco('${requestScope.nomeCampo}');">

<html:form action="/gerarRelatorioAMAEAction.do"
	name="GerarRelatorioAMAEActionForm"
	type="gcom.gui.faturamento.GerarRelatorioAMAEActionForm"
	method="post">

<%@ include file="/jsp/util/cabecalho.jsp"%> 
<%@ include file="/jsp/util/menu.jsp"%>

<table width="770" border="0" cellspacing="5" cellpadding="0">
	<tr>
		<td width="115" valign="top" class="leftcoltext">
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


		<td valign="top" class="centercoltext">
		<table>
			<tr>
				<td></td>
			</tr>
		</table>
		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="11"><img border="0"
					src="<bean:message key="caminho.imagens"/>parahead_left.gif" /></td>
				<td class="parabg">Gerar Relat�rio AMAE</td>
				<td width="11" valign="top"><img border="0"
					src="<bean:message key="caminho.imagens"/>parahead_right.gif" /></td>
			</tr>
		</table>

		<p>&nbsp;</p>
		<table width="100%" border="0">

			<tr>
				<td colspan="2">Para gerar relat�rio para AMAE, informe os dados abaixo:</td>
			</tr>

			<tr>
				<td width="30%"><strong>M�s/Ano refer�ncia:<font color="#FF0000">*</font></strong></td>
       			<td width="70%">
       				<html:text property="mesAno" size="7"  maxlength="7" onkeypress="javascript:mascaraAnoMes(this, event);"/>
       				&nbsp;mm/aaaa
   				</td>
			</tr>
			
			<tr>
					<td><strong>Munic&iacute;pio:</strong></td>
					<td colspan="3"><strong> <html:text maxlength="4"
						property="codigoMunicipio" size="4"
						onkeypress="javascript:form.target = ''; return validaEnter(event, 'filtrarRelatorioAMAEAction.do', 'codigoMunicipio');"
						onkeyup="limparBairro(); limparLogradouro();" /> <img width="23"
						height="21"
						src="<bean:message key="caminho.imagens"/>pesquisa.gif"
						style="cursor:hand;"
						onclick="abrirPopup('exibirPesquisarMunicipioAction.do', 400, 800); limparBairro(); limparLogradouro();"
						alt="Pesquisar" /> <logic:present name="municipioNaoEncontrado"
						scope="request">
						<html:text property="descricaoMunicipio" size="40"
							maxlength="30" readonly="true"
							style="background-color:#EFEFEF; border:0; color: #ff0000" />
					</logic:present> <logic:notPresent name="municipioNaoEncontrado"
						scope="request">
						<html:text property="descricaoMunicipio" size="40"
							maxlength="30" readonly="true"
							style="background-color:#EFEFEF; border:0; color: #000000" />
					</logic:notPresent> <a href="javascript:limparMunicipio();"> <img
						src="<bean:message key="caminho.imagens"/>limparcampo.gif"
						border="0" title="Apagar" /></a> </strong></td>
				</tr>
			
			<tr>
				<td>&nbsp;</td>
				<td align="left"><font color="#FF0000">*</font> Campo
				Obrigat&oacute;rio</td>
			</tr>
		</table>

		<table width="100%">
			<tr>
				<td align="left">
						
					<input type="button"
						name="ButtonCancelar" 
						class="bottonRightCol" 
						value="Cancelar"
						onClick="javascript:window.location.href='/gsan/telaPrincipal.do'">
				</td>
				
				<td align="right">
					<gsan:controleAcessoBotao name="Button" 
				  		value="Gerar" 
				  		onclick="javascript:validarForm();" 
				  		url="gerarRelatorioAMAEAction.do"/>
				  	
				</td>
			</tr>
		</table>
	</tr>


</table>
<%@ include file="/jsp/util/rodape.jsp"%></html:form>
</body>
</html:html>
