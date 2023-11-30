<%@ include file="common/cabecalho.jspf" %>

<div class="container">

    <h1>Preencha os detalhes do Projeto</h1>

    <form:form method="post" modelAttribute="projeto">
        <fieldset class="mb-3">
            <form:label path="nome">Nome</form:label>
            <form:input type="text" path="nome" required="required" />
            <form:errors path="nome" cssClass="text-warning"/>
        </fieldset>

        <fieldset class="mb-3">
            <form:label path="dataInicio">Data Inicio</form:label>
            <form:input type="text" path="dataInicio" required="required" />
            <form:errors path="dataInicio" cssClass="text-warning"/>
        </fieldset>

        <fieldset class="mb-3">
            <form:label path="gerente">Gerente Respons&aacute;vel</form:label>
            <form:select path="gerente">
                 <form:options items="${gerentes}" itemValue="id" itemLabel="nome" />
            </form:select>
            <form:errors path="gerente" cssClass="text-warning"/>
        </fieldset>

        <fieldset class="mb-3">
            <form:label path="dataPrevisaoFim">Previs&atilde;o de T&eacute;rmino</form:label>
            <form:input type="text" path="dataPrevisaoFim" required="required" />
            <form:errors path="dataPrevisaoFim" cssClass="text-warning"/>
        </fieldset>

        <fieldset class="mb-3">
            <form:label path="orcamento">Or&ccedil;amento Total</form:label>
            <form:input type="text" path="orcamento" required="required" />
            <form:errors path="orcamento" cssClass="text-warning"/>
        </fieldset>

        <fieldset class="mb-3">
            <form:label path="descricao">Descri&ccedil;&atilde;o</form:label>
            <form:input type="text" path="descricao" required="required" />
            <form:errors path="descricao" cssClass="text-warning"/>
        </fieldset>

        <fieldset class="mb-3">
            <form:label path="status">Status</form:label>
            <form:select path="status">
                 <form:options items="${statusEnum}" />
            </form:select>
            <form:errors path="status" cssClass="text-warning"/>
        </fieldset>

        <input type="submit" class="btn btn-success"/>
    </form:form>

</div>

<%@ include file="common/rodape.jspf" %>

<script type="text/javascript">
    $('#dataInicio').datepicker({
        format: 'yyyy-mm-dd'
    });

    $('#dataPrevisaoFim').datepicker({
        format: 'yyyy-mm-dd'
    });
</script>