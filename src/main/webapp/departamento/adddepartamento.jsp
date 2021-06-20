<%@include file="../pages/cabecera.jsp" %>
<section class="page-section portfolio" id="portfolio">
    <div class="container">
        <!-- Portfolio Section Heading-->
        <h2 class="page-section-heading text-center text-uppercase text-secondary mb-0">Deparmentos</h2>
        <!-- Icon Divider-->
        <div class="divider-custom">
            <div class="divider-custom-line"></div>
            <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
            <div class="divider-custom-line"></div>
        </div>
        <form method="post" action="${pageContext.request.contextPath}/departamento?accion=crear">
            <div>
                <div class="mb-3">
                    <label  class="form-label">Numero</label>
                    <input type="text" class="form-control" id="numero" name="numero" >
                </div>
                
                <div class="mb-3">
                    <label  class="form-label">Nombre</label>
                    <input type="text" class="form-control" id="nombre" name="nombre" >
                </div>
                <div class="mb-3">
                    <label  class="form-label">Ciudad</label>
                    <input type="text" class="form-control" id="localizacion" name="localizacion" >
                </div>

                <button type="submit" class="btn btn-primary">Guardar</button>
            </div>
        </form>
    </div>
</section>
<%@include file="../pages/footer.jsp" %>