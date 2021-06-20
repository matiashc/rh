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
<div class="modal-body">
          <form action="${pageContext.request.contextPath}/departamento?accion=modificar&numero=${departamentodto.numero}"
                method="POST" class="was-validated">
          <div class="mb-3">
            <label for="recipient-name" class="col-form-label">Numero:</label>
            <input type="text" disabled="disabled" name="numeroo" value="${departamentodto.numero}" class="form-control" id="numeroo" required>
          </div>
            <div class="mb-3">
            <label for="recipient-name" class="col-form-label">Nombre:</label>
            <input type="text" name="nombre" value="${departamentodto.nombre}" class="form-control" id="nombre" required>
          </div>
            
            <div class="mb-3">
            <label for="recipient-name" class="col-form-label">Localización:</label>
            <input type="text" name="localizacion" value="${departamentodto.localizacion}" class="form-control" id="localizacion" required>
          </div>
          <div class="modal-footer">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/departamento" role="button">Cerrar</a>
            <input type="submit" class="btn btn-primary" value="Editar"/>
            </div>
        </form>
</div>
    </div>
            </<section>
<%@include file="../pages/footer.jsp" %>
          
  