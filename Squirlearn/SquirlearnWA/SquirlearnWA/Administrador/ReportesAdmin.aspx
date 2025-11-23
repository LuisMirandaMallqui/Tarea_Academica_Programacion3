<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/SquirLearn.Master" AutoEventWireup="true" CodeBehind="ReportesAdmin.aspx.cs" Inherits="SquirlearnWA.ReportesAdmin" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphContenido" runat="server">


    <div class="d-flex justify-content-between align-items-center mb-3">
    <div>
        
        <span class="h3 fw-bold">GENERAR REPORTES</span>


        <div class="container py-5">
    <div class="row text-center">

        <!-- Columna izquierda -->
        <div class="col-md-6 mb-4">
            <h5 class="fw-bold">Generar reporte de incidencias hasta la fecha</h5>
            <asp:Button ID="btnGenerarIncidencias" runat="server" Text="GENERAR"
                        CssClass="btn btn-primary mt-3" OnClick="btnGenerarIncidencias_Click" />
        </div>

        <!-- Columna derecha -->
        <div class="col-md-6 mb-4">
            <h5 class="fw-bold">Generar reporte de ventas de los vendedores por periodo</h5>
            <button type="button" class="btn btn-primary mt-3" onclick="mostrarModalVentas()">
                GENERAR
            </button>
        </div>

    </div>
</div>

<!-- Modal de ingreso de fechas -->
<div class="modal fade" id="modalVentas" tabindex="-1" aria-labelledby="modalVentasLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title fw-bold" id="modalVentasLabel">Ingresar periodo</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Cerrar"></button>
      </div>
      <div class="modal-body">
        <div class="mb-3">
            <label for="fechaInicio" class="form-label">Fecha inicio:</label>
            <input type="date" id="fechaInicio" class="form-control" />
        </div>
        <div class="mb-3">
            <label for="fechaFin" class="form-label">Fecha fin:</label>
            <input type="date" id="fechaFin" class="form-control" />
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary">Aceptar</button>
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
      </div>
    </div>
  </div>
</div>

<script type="text/javascript">
    function mostrarModalVentas() {
        var myModal = new bootstrap.Modal(document.getElementById('modalVentas'));
        myModal.show();
    }
</script>
    </div>

</asp:Content>
