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
                    <input type="text" class="form-control" readonly value='<%# Eval("VendedorNombre") %>' />
                </div>

                <div class="col-md-6 mb-3">
                    <label>Stock:</label>
                    <input type="text" class="form-control" readonly value='<%# Eval("Stock") %> unidades' />
                </div>

                <div class="col-md-6 mb-3">
                    <label>Nombre del producto:</label>
                    <input type="text" class="form-control" readonly value='<%# Eval("NombreProducto") %>' />
                </div>

                <div class="col-md-6 mb-3">
                    <label>Precio Unitario:</label>
                    <input type="text" class="form-control" readonly value='S/. <%# String.Format("{0:0.00}", Eval("PrecioUnitario")) %>' />
                </div>

                <div class="col-md-6 mb-3">
                    <label>Tipo de publicación:</label>
                    <input type="text" class="form-control" readonly value='<%# Eval("TipoPublicacion") %>' />
                </div>

                <div class="col-md-6 mb-3">
                    <label>Periodo de tiempo:</label>
                    <input type="text" class="form-control" readonly value='<%# Eval("PeriodoTiempo") %> días' />
                </div>
            </div>

            <div class="row mt-4">
                <div class="col-md-6">
                    <label>Foto del producto:</label>
                    <div class="border rounded p-3 bg-light text-center">
                        <img src='<%# Eval("ImagenUrl") %>' class="img-fluid rounded" style="max-height:250px;" />
                    </div>
                </div>

                <div class="col-md-6">
                    <label>Descripción del producto:</label>
                    <textarea class="form-control bg-light" rows="8" readonly><%# Eval("Descripcion") %></textarea>
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
