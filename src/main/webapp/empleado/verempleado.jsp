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
        <!-- Portfolio Section-->

        <!-- Portfolio Grid Items-->
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/empleado/addempleado.jsp" role="button"><i class="fas fa-plus fa-1x"></i></a>
        <br/>
        <div class="row justify-content-center">
            
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Ingreso</th>
                       

                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="emp" items="${empleados}">
                        <tr>
                            <th scope="row">${emp.id}</th>
                            <td>${emp.nombre}</td>
                            <td>${emp.ingreso}</td>
                            <td>
                                <a class="btn btn-primary" href="${pageContext.request.contextPath}/empleado?id=${emp.id}&accion=borrar" role="button"><i class="fas fa-trash-alt fa-1x"></i></a>
                                <a class="btn btn-primary" href="${pageContext.request.contextPath}/empleado?id=${emp.id}&accion=editar" role="button"><i class="fas fa-edit fa-1x"></i></a>
                                <a class="btn btn-primary" href="${pageContext.request.contextPath}/empleado?id=${emp.id}&accion=editar" role="button"><i class="fas fa-address-card fa-1x"></i></a>
                            </td>
                           
                        </tr>
                        

                    </c:forEach>     
                </tbody>
            </table>

        </div>
    </div>
</section>
<%@include file="../pages/footer.jsp" %>
