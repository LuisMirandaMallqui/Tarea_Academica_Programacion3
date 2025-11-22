<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/SquirLearn.Master" AutoEventWireup="true" CodeBehind="ListadoPublicaciones.aspx.cs" Inherits="SquirlearnWA.ListadoPublicaciones" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphContenido" runat="server">

    <asp:ScriptManager ID="ScriptManager1" runat="server"></asp:ScriptManager>

    <div class="container pt-0">
        <a href="../PantallaInicio/SquirLearnInicio.aspx" class="text-decoration-none text-dark fw-semibold mb-3 d-inline-block">
            <i class="fa fa-arrow-left"></i>Volver
        </a>

        <h2 class="fw-bold mb-0">Listado de publicaciones</h2>

    <div class="d-flex justify-content-end mb-2">
    <asp:Button ID="btnCrear" runat="server" Text="CREAR PUBLICACIÓN" CssClass="btn btn-outline-custom me-2" OnClick="btnCrear_Click" />
    <asp:Button ID="btnEditar" runat="server" Text="EDITAR PUBLICACIÓN" CssClass="btn btn-outline-custom me-2" OnClick="btnEditar_Click" />
    <asp:Button ID="btnEliminar" runat="server" Text="ELIMINAR PUBLICACIÓN" CssClass="btn btn-outline-custom" OnClientClick="mostrarModalEliminar(); return false;" />
</div>



        <asp:UpdatePanel ID="upPanelPublicaciones" runat="server">
            <ContentTemplate>
                <div class="d-flex align-items-center mb-3">
                    <label for="<%= ddlEstados.ClientID %>" class="me-2 fw-semibold">Estados:</label>
                    <asp:DropDownList ID="ddlEstados" runat="server"
                        AutoPostBack="true"
                        OnSelectedIndexChanged="ddlEstados_SelectedIndexChanged"
                        CssClass="form-select w-auto">
                    </asp:DropDownList>
                    <div class="ms-auto">
                        <asp:Label ID="lblCantidadResultados" runat="server" CssClass="fw-semibold"></asp:Label>
                    </div>
                </div>

                <div style="max-height: 400px; overflow-y: auto;">
                    
                    <asp:Repeater ID="rptPublicaciones" runat="server" OnItemDataBound="rptPublicaciones_ItemDataBound">
                        <ItemTemplate>
                            <div class="card p-3 mb-3 bg-light rounded shadow-sm">
                                
                                <%--    <small>Enviado: <%# Eval("fechaEnvio", "{0:dd/MM/yyyy}") %></small>--%>
                                
                                <strong><%# Eval("categoriaNombre") %> - <%# Eval("nombre") %></strong>

                                <div class="d-flex align-items-center mt-2">
                                    
                                    <asp:CheckBox ID="chkSeleccion" runat="server" CssClass="form-check-input me-2" />
                                    
                                    <asp:HiddenField ID="hdnPublicacionId" runat="server" Value='<%# Eval("publicacionId") %>' />
                                    
                                    <asp:Label ID="lblEstado" runat="server" 
                                        CssClass="badge p-2 me-2" 
                                        Text='<%# Eval("estadoNombre") %>' />
                                    
                                    <asp:Button ID="btnRevisar" runat="server" 
                                        Text="Revisar" 
                                        CssClass="btn btn-outline-dark btn-sm"
                                        CommandArgument='<%# Eval("publicacionId") %>'
                                        OnClick="BtnRevisar_Click"
                                        Visible="false" /> 
                                </div>
                            </div>
                        </ItemTemplate>
                        <FooterTemplate>
                            <asp:Panel ID="pnlNoResultados" runat="server" Visible='<%# rptPublicaciones.Items.Count == 0 %>'>
                                <div class="alert alert-info text-center">
                                    No se encontraron publicaciones con los filtros seleccionados.
                                </div>
                            </asp:Panel>
                        </FooterTemplate>
                    </asp:Repeater>
                </div>

                <!-- Paginación estilo Anterior / Siguiente -->
                    <div class="d-flex justify-content-between align-items-center mt-4">
                        <asp:Button ID="btnAnterior" runat="server" Text="Anterior" CssClass="btn btn-outline-primary"
                            OnClick="btnAnterior_Click" />
                        <asp:Label ID="lblPagina" runat="server" CssClass="fw-semibold text-secondary"></asp:Label>
                        <asp:Button ID="btnSiguiente" runat="server" Text="Siguiente" CssClass="btn btn-outline-primary"
                            OnClick="btnSiguiente_Click" />
                    </div>
            </ContentTemplate>
        </asp:UpdatePanel>

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

            <style>
        .btn-outline-custom {
            background-color: transparent;  /* Fondo transparente */
            color: #0d6efd;                 /* Texto azul */
            border: 2px solid #0d6efd;      /* Borde azul */
            transition: all 0.3s ease;      /* Animación suave */
        }

        .btn-outline-custom:hover {
            background-color: #0d6efd;      /* Fondo azul al pasar mouse */
            color: #fff;                     /* Texto blanco */
            border-color: #0d6efd;          /* Borde permanece azul */
        }
        </style>
</asp:Content>
