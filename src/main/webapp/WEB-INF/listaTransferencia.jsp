<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<html>
   <head>
      <title>Lista de Agendamentos de Transferência</title>
   </head>
   <body style="background-color: #e8e8ff; font-family: verdana">
      <h2 style="font-family: verdana; background-color:; color: navy; text-align: center;">Transferências Agendadas</h2>
      <c:if test="${not empty agendamentos}">
		<blockquote>
			<blockquote>
				<blockquote>
					<blockquote>
						<blockquote>
							<blockquote>
								<blockquote>
									<blockquote>
										<table BORDER="1" style="text-align: center">
											<tr>
												<th
													style="font-family: verdana; background-color: silver; font-size: 10pt">Conta
													Origem</th>
												<th
													style="font-family: verdana; background-color: silver; font-size: 10pt">Conta
													Destino</th>
												<th
													style="font-family: verdana; background-color: silver; font-size: 10pt">Valor</th>
												<th
													style="font-family: verdana; background-color: silver; font-size: 10pt">Taxa</th>
												<th
													style="font-family: verdana; background-color: silver; font-size: 10pt">Tipo
													de Taxa</th>
												<th
													style="font-family: verdana; background-color: silver; font-size: 10pt">Data de
													Cadastro</th>
												<th
													style="font-family: verdana; background-color: silver; font-size: 10pt">Data do Agendamento</th>
											</tr>
											<c:forEach var="listaAgendamentos" items="${agendamentos}">
												<tr>
													<td style="background-color: #eeeeee; font-family: Verdana;font-size: 10pt">${listaAgendamentos.contaOrigem}</td>
													<td style="background-color: #eeeeee; font-family: Verdana;font-size: 10pt">${listaAgendamentos.contaDestino}</td>
													<td style="background-color: #eeeeee; font-family: Verdana;font-size: 10pt">${listaAgendamentos.valorTransferencia}</td>
													<td style="background-color: #eeeeee; font-family: Verdana;font-size: 10pt">${listaAgendamentos.taxa}</td>
													<td style="background-color: #eeeeee; font-family: Verdana;font-size: 10pt">${listaAgendamentos.tipoTaxa}</td>
													<td  style="background-color: #eeeeee; font-family: Verdana;font-size: 10pt">
								                  <joda:format value="${listaAgendamentos.dataCadastro}" pattern="dd/MM/yyyy"/>
								                  </td>
								                  <td  style="background-color: #eeeeee; font-family: Verdana;font-size: 10pt">
								                  <joda:format value="${listaAgendamentos.dataAgendada}" pattern="dd/MM/yyyy"/>
								                  </td>
												</tr>
											</c:forEach>
										</table>
									</blockquote>
								</blockquote>
							</blockquote>
						</blockquote>
					</blockquote>
				</blockquote>
			</blockquote>
		</blockquote>
	</c:if>
      <br>
	<blockquote>
		<blockquote>
			<blockquote>
				<blockquote>
					<blockquote>
						<blockquote>
							<blockquote>
								<blockquote>
									<b><a href="/provaReservaFacil/"
										style="font-family: verdana; background-color: silver; font-size: 10pt">Efetuar
											nova transferência</a></b>
								</blockquote>
							</blockquote>
						</blockquote>
					</blockquote>
				</blockquote>
			</blockquote>
		</blockquote>
	</blockquote>
</body>
</html>