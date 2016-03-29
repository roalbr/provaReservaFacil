<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<html>
   <head>
      <title>Agendar Transferência Bancária</title>
   </head>
   <body style="background-color: #e8e8ff; font-family: verdana"  >
      <h2 style="font-family: verdana; text-align: center; color: navy">Agendar Transferência Bancária</h2>
      <form:form method="POST" action="adiciona">
      <fieldset>
 		<legend style="font-family: verdana">Dados Transferência</legend>
         <table cellspacing="10">
            <tr>
               <td style="font-family: verdana; background-color: silver; font-size: 10pt">
                  <form:label path="contaOrigem">Conta Origem</form:label>
               </td>
               <td>
                   <input type="text" class="form-control" name="contaOrigem" placeholder="XXXXX-XX" required  maxlength="6"/>
               </td>
               <td style="font-family: verdana; background-color: silver; font-size: 10pt">
                  <form:label path="contaDestino">Conta Destino</form:label>
               </td>
               <td>
                  <input type="text" class="form-control" name="contaDestino" placeholder="XXXXX-XX" required maxlength="6"/>
               </td>
            </tr>
            <tr>
               <td style="font-family: verdana; background-color: silver; font-size: 10pt">
                  <form:label path="valorTransferencia">Valor:</form:label>
               </td>
               <td>
                  <form:input type="number" step="any" min="0" path="valorTransferencia" required='required'/>
               </td>
               <td style="font-family: verdana; background-color: silver; font-size: 10pt">
                  <form:label path="dataAgendada">Data do agendamento:</form:label>
               </td>
               <td>
                 <input type="text" class="form-control" name="dataAgendada" placeholder="DD/MM/AAAA" required/>
               </td>
            </tr>
            <tr>
            	<td style="font-family: verdana; background-color: silver; font-size: 10pt">
                  <form:label path="tipoTaxa">Tipo de Taxa:</form:label>
               </td>
               <td>
               <form:radiobuttons path="tipoTaxa" items="${tipoDeTaxas}" required='required'/>
               </td>
            </tr>
            <tr>
            	<td style="background-color: silver; font-family: verdana">
               </td>
               <td>
               </td>
            </tr>
            <tr>
               <td colspan="4" style="text-align: center; background-color: #c7daeb"> <input type="submit" value="Agendar" style="font-family: verdana"/> </td>
            </tr>
         </table>
         </fieldset>
         
      </form:form>
      <b><a href="lista">Lista de agendamentos cadastrados</a></b>
   </body>
</html>
