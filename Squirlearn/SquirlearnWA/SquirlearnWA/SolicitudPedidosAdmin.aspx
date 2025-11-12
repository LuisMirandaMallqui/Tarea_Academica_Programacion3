<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/SquirLearn.Master" AutoEventWireup="true" CodeBehind="SolicitudPedidosAdmin.aspx.cs" Inherits="SquirlearnWA.SolicitudPedidosAdmin" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphContenido" runat="server">

    <asp:LinkButton ID="btnVolver" runat="server" CssClass="btn btn-link text-dark btn-flecha me-3" OnClick="btnVolver_Click">
    <i class="fa fa-arrow-left"></i>
</asp:LinkButton>

    <div class="container mt-4">
    <h4 class="fw-bold mb-4">Solicitud de publicación</h4>

   <asp:FormView ID="fvPedido" runat="server">
    <ItemTemplate>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label>Vendedor:</label>
                <div class="form-control-plaintext border rounded p-2 bg-light">
                    <%# Eval("NombreUsuario") %>
                </div>
            </div>

            <div class="col-md-6 mb-3">
                <label>Fecha de envío:</label>
                <div class="form-control-plaintext border rounded p-2 bg-light">
                    <%# Eval("FechaEnvio") %>
                </div>
            </div>

            <div class="col-md-6 mb-3">
                <label>Categoría del producto:</label>
                <div class="form-control-plaintext border rounded p-2 bg-light">
                    <%# Eval("Categoria") %>
                </div>
            </div>

            <div class="col-md-6 mb-3">
                <label>Subcategoría del producto:</label>
                <div class="form-control-plaintext border rounded p-2 bg-light">
                    <%# Eval("Subcategoria") %>
                </div>
            </div>

            <div class="col-md-6 mb-3">
                <label>Título del producto:</label>
                <div class="form-control-plaintext border rounded p-2 bg-light">
                    <%# Eval("Titulo") %>
                </div>
            </div>

            <div class="col-md-6 mb-3">
                <label>Descripción:</label>
                <div class="form-control-plaintext border rounded p-2 bg-light">
                    <%# Eval("Descripcion") %>
                </div>
            </div>

            <div class="col-md-6 mb-3">
                <label>Acción:</label>
                <div class="form-control-plaintext border rounded p-2 bg-light">
                    <%# Eval("Accion") %>
                </div>
            </div>

            <div class="col-md-6 mb-3">
                <label>Precio Unitario:</label>
                <div class="form-control-plaintext border rounded p-2 bg-light">
                    S/. <%# String.Format("{0:0.00}", Eval("Precio")) %>
                </div>
            </div>

            <div class="col-md-6 mb-3">
                <label>Tipo de publicación:</label>
                <div class="form-control-plaintext border rounded p-2 bg-light">
                    <%# Eval("TipoPublicacion") %>
                </div>
            </div>

            <div class="col-md-6 mb-3">
                <label>Formato del producto:</label>
                <div class="form-control-plaintext border rounded p-2 bg-light">
                    <%# Eval("Formato") %>
                </div>
            </div>

            <div class="col-md-6 mb-3">
                <label>Estado del producto:</label>
                <div class="form-control-plaintext border rounded p-2 bg-light">
                    <%# Eval("Estado") %>
                </div>
            </div>

            <div class="col-md-6 mb-3">
                <label>Periodo de tiempo:</label>
                <div class="form-control-plaintext border rounded p-2 bg-light">
                    <%# Eval("Periodo") %> días
                </div>
            </div>
        </div>

        <div class="row mt-4">
            <div class="col-md-6">
                <label>Foto del producto:</label>
                <div class="border rounded p-3 bg-light text-center">
                    <img src='<%# Eval("Foto") %>' class="img-fluid rounded" style="max-height:250px;" />
                </div>
            </div>
        </div>

        <div class="text-center mt-5">
            <a href="RechazoPublicacion.aspx" class="btn btn-danger px-5 py-2 me-3 fw-bold">Rechazar Pedido</a>
            <a href="AceptacionPublicacion.aspx" class="btn btn-primary px-5 py-2 fw-bold">Aceptar Pedido</a>
        </div>
    </ItemTemplate>
</asp:FormView>
</div>

</asp:Content>
