<%@ include file="common/cabecalho.jspf" %>

<div class="container">

    <h1>Lista de Projetos</h1>

    <form:form>
        <c:if test="${erro}">
            <div id="alert" class="alert alert-danger alert-dismissible fade show">
                <strong>Alerta: </strong>
                ${mensagem}
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>

        <table class="table table-bordered">
            <tr>
                <th>Nome</th>
                <th>Descricao</th>
                <th>Inicio</th>
                <th>Previsao</th>
                <th>Fim</th>
                <th>Orcamento</th>
                <th>Gerente</th>
                <th>Status</th>
                <th>Editar</th>
                <th>Excluir</th>
            </tr>

            <c:forEach var="projeto" items="${projetos}">
                <tr>
                    <td>${projeto.nome}</td>
                    <td>${projeto.descricao}</td>
                    <td>${projeto.dataInicio}</td>
                    <td>${projeto.dataPrevisaoFim}</td>
                    <td>${projeto.dataFim}</td>
                    <td>${projeto.orcamento}</td>
                    <td>${projeto.gerente.nome}</td>
                    <td>${projeto.status}</td>
                    <td>
                        <button type="button" class="btn btn-primary" onclick="window.location.href='atualizar-projeto?id=${projeto.id}'">Editar</button>
                    </td>
                    <td>
                        <button type="button" class="btn btn-danger" onclick="window.location.href='excluir-projeto?id=${projeto.id}'">Excluir</button>
                    </td>
                </tr>

            </c:forEach>

        </table>

    </form:form>

    <button type="button" class="btn btn-primary btn-block" onclick="window.location.href='adicionar-projeto'">
        Adicionar Projeto
    </button>

</div>

<%@ include file="common/rodape.jspf" %>