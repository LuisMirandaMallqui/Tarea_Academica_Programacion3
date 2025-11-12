<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/SquirLearn.Master" AutoEventWireup="true" CodeBehind="ListadoPublicaciones.aspx.cs" Inherits="SquirlearnWA.ListadoPublicaciones" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphContenido" runat="server">

    <div class="container py-4">
    <!-- Flecha de regreso -->
    <a href="../PantallaInicio/SquirLearnInicio.aspx" class="text-decoration-none text-dark fw-semibold mb-3 d-inline-block">
        <i class="fa fa-arrow-left"></i> Volver
    </a>


        <h2 class="fw-bold mb-4">Listado de publicaciones</h2>

    <!-- Barra superior con botones -->
    <div class="d-flex justify-content-end mb-3">
        <asp:Button ID="btnCrear" runat="server" Text="CREAR PUBLICACIÓN"
            CssClass="btn btn-success me-2"
            OnClick="btnCrear_Click" />

        <asp:Button ID="btnEditar" runat="server" Text="EDITAR PUBLICACIÓN"  
            CssClass="btn btn-warning me-2"
            OnClick="btnEditar_Click" />

       <asp:Button ID="btnEliminar" runat="server" Text="ELIMINAR PUBLICACIÓN"
    CssClass="btn btn-danger"
    OnClientClick="mostrarModalEliminar(); return false;" />
    </div>

    <!-- Filtro de estados -->
    <div class="d-flex align-items-center mb-4">
        <label for="ddlEstados" class="me-2 fw-semibold">Estados:</label>
        <asp:DropDownList ID="ddlEstados" runat="server"
            AutoPostBack="true"
            OnSelectedIndexChanged="ddlEstados_SelectedIndexChanged"
            CssClass="form-select w-auto">
            <asp:ListItem Text="Todos" Value="Todos" />
            <asp:ListItem Text="Borrador" Value="Borrador" />
            <asp:ListItem Text="Pendiente" Value="Pendiente" />
            <asp:ListItem Text="Aceptado" Value="Aceptado" />
            <asp:ListItem Text="Rechazado" Value="Rechazado" />
        </asp:DropDownList>
    </div>
            <div id="contenedorPublicaciones" runat="server" style="max-height: 400px; overflow-y: auto;"></div>

        <div class="notificaciones-container">

 <!-- Listado de publicaciones -->
        <asp:Repeater ID="rptPublicaciones" runat="server">
        <ItemTemplate>
            
            <div class="card mb-3 p-3">
                <small>Enviado: <%# Eval("FechaEnvio", "{0:dd/MM/yyyy}") %></small>
                <h5><%# Eval("Categoria") %> - <%# Eval("Titulo") %></h5>

                <asp:Label ID="lblEstado" runat="server"
                    CssClass='<%# GetEstadoColor(Eval("EstadoPublicacion").ToString()) %>'
                    Text='<%# Eval("EstadoPublicacion").ToString().ToUpper() %>'>
                </asp:Label>
            </div>
        </ItemTemplate>
    </asp:Repeater>


        </div>

    </div>




<!-- 🔹 Modal de confirmación de eliminación -->
<div class="modal fade" id="modalEliminar" tabindex="-1" aria-labelledby="modalEliminarLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">
      <div class="modal-header border-0">
        <h5 class="modal-title fw-bold w-100 text-center" id="modalEliminarLabel">Confirmar eliminación</h5>
      </div>
      <div class="modal-body text-center">
        <p>¿Está seguro que desea eliminar su publicación?<br />
           Esta acción no se puede deshacer.</p>
      </div>
      <div class="modal-footer border-0 d-flex justify-content-center">
        <button type="button" class="btn btn-secondary fw-semibold px-4" data-bs-dismiss="modal">
          REGRESAR
        </button>
        <asp:Button ID="btnConfirmarEliminar" runat="server"
          CssClass="btn btn-danger fw-semibold px-4"
          Text="ACEPTAR"
          OnClick="btnConfirmarEliminar_Click" />
      </div>
    </div>
  </div>
</div>

<!-- 🔹 Script para mostrar el modal -->
<script type="text/javascript">
    function mostrarModalEliminar() {
        var myModal = new bootstrap.Modal(document.getElementById('modalEliminar'));
        myModal.show();
    }
</script>

</asp:Content>
