<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/SquirLearn.Master" AutoEventWireup="true" CodeBehind="Publicar.aspx.cs" Inherits="SquirlearnWA.PublicacionDelUsuario.Publicar" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphContenido" runat="server">
    
    <asp:ScriptManager ID="ScriptManager1" runat="server"></asp:ScriptManager>

    <div class="container py-4">
        <a href="../PublicacionDelUsuario/ListadoPublicaciones.aspx" class="text-decoration-none text-dark fw-semibold mb-3 d-inline-block">
            <i class="fa fa-arrow-left"></i> Volver
        </a>

        <h3 id="hTitulo" class="fw-bold mb-4" runat="server">NUEVA PUBLICACIÓN</h3>

        <asp:DropDownList ID="ddlCategoria" runat="server" CssClass="form-select" AutoPostBack="true"
            OnSelectedIndexChanged="ddlCategoria_SelectedIndexChanged">
            </asp:DropDownList>

        <asp:Panel ID="panelGeneral" runat="server" Visible="false">

            <div class="mt-3">
                <label>Elija una subcategoría</label>
                <asp:DropDownList ID="ddlSubcategoria" runat="server" CssClass="form-select" Enabled="false">
                </asp:DropDownList>
            </div>

            <div class="mt-3">
                <label>¿Qué titulo tendrá su publicación?</label>
                <asp:TextBox ID="txtNombreLibro" runat="server" CssClass="form-control" placeholder="Nombre del producto" />
            </div>

            <div class="mt-3">
                <label>Añade una descripción</label>
                <asp:TextBox ID="txtDescripcionLibro" runat="server" TextMode="MultiLine" CssClass="form-control"
                    placeholder="Descripción del producto" />
            </div>

            <asp:Panel ID="panelAccion" runat="server" CssClass="mt-3">
                <label>¿Qué deseas hacer?</label><br />
                <asp:RadioButtonList ID="rblAccionLibro" runat="server" RepeatDirection="Horizontal" AutoPostBack="true">
                    <asp:ListItem Text="Alquilar" Value="Alquilar" />
                    <asp:ListItem Text="Vender" Value="Vender" />
                </asp:RadioButtonList>
            </asp:Panel>

            <div class="mt-3">
                <label>Establece un precio</label>
                <asp:TextBox ID="txtPrecioLibro" runat="server" CssClass="form-control" placeholder="Precio por producto" />
            </div>
            
            <asp:Panel ID="panelFormato" runat="server" CssClass="mt-3">
                <label>¿Cuál es el formato del producto?</label>
                <asp:DropDownList ID="ddlFormato" runat="server" CssClass="form-select">
                    </asp:DropDownList>
            </asp:Panel>

            <asp:Panel ID="panelEstado" runat="server" CssClass="mt-3">
                <label>¿Cuál es el estado del producto?</label>
                <asp:DropDownList ID="ddlCondicion" runat="server" CssClass="form-select">
                    </asp:DropDownList>
            </asp:Panel>

            <asp:Panel ID="panelTamanoProducto" runat="server" CssClass="mt-3" Visible="true">
                <label>¿Cuál es el tamaño del producto? (Opcional)</label>
                <asp:DropDownList ID="ddlTamano" runat="server" CssClass="form-select">
                    </asp:DropDownList>
            </asp:Panel>

            <asp:Panel ID="panelColorProducto" runat="server" CssClass="mt-3" Visible="true">
                <label>¿Cuál es el color del producto?</label>
                <asp:DropDownList ID="ddlColor" runat="server" CssClass="form-select">
                    </asp:DropDownList>
            </asp:Panel>

            <asp:Panel ID="panelFoto" runat="server" CssClass="mt-3">
                <label>Añade fotos de tu producto</label>
                <asp:FileUpload ID="fuFotoLibro" runat="server" CssClass="form-control" />
            </asp:Panel>

            <div class="d-flex justify-content-end mt-3">
                <asp:Button ID="btnGuardarBorrador_Click" runat="server" CssClass="btn btn-secondary me-2"
                    Text="Guardar borrador" OnClick="btnGuardarBorrador_Click_Click" />
                <asp:Button ID="btnCancelar" runat="server" CssClass="btn btn-secondary me-2"
                    Text="Cancelar" OnClick="btnCancelar_Click" />
                <asp:Button ID="btnEnviarPublicacion_Click" runat="server" CssClass="btn btn-primary"
                    Text="Enviar" OnClick="btnEnviarPublicacion_Click_Click" />
            </div>

        </asp:Panel>


        <div class="modal fade" id="modalConfirmacion" tabindex="-1" aria-labelledby="modalConfirmacionLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                    <div class="modal-header border-0">
                        <h5 class="modal-title fw-bold w-100 text-center" id="modalConfirmacionLabel">Publicación enviada</h5>
                    </div>
                    <div class="modal-body text-center">
                        <p>Su publicación se ha enviado con éxito.<br />
                            Será revisada por los administradores<br />
                            lo más pronto posible.</p>
                    </div>
                    <div class="modal-footer border-0 d-flex justify-content-center">
                        <asp:Button ID="btnContinuar" runat="server" CssClass="btn btn-primary fw-semibold px-4"
                            Text="CONTINUAR" OnClick="btnContinuar_Click" />
                    </div>
                </div>
            </div>
        </div>

        <script type="text/javascript">
            function mostrarModalConfirmacion() {
                var myModal = new bootstrap.Modal(document.getElementById('modalConfirmacion'));
                myModal.show();
            }
        </script>
    </div>
</asp:Content>
