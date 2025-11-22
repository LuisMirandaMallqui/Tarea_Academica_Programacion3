<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/SquirLearn.Master" AutoEventWireup="true" CodeBehind="DetalleProductoAlquiler.aspx.cs" Inherits="SquirlearnWA.DetalleProductoAlquiler" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="container-fluid px-5 py-4">
        <!-- Flecha de regreso -->
        <div class="mb-3">
            <asp:LinkButton ID="btnVolver" runat="server" CssClass="text-decoration-none text-dark fw-semibold" OnClick="btnVolver_Click">
                <i class="fa fa-arrow-left"></i> Volver
            </asp:LinkButton>
        </div>

        <div class="row align-items-start">
            <!-- Imagen y vendedor -->
            <div class="col-md-5 text-center">
                <asp:Image ID="imgProducto" runat="server"
                    Style="width:200px; height:200px; object-fit:contain; margin-bottom:20px;" />
                <div class="text-center">
                    <img src="../Imagenes/Avatar.png" alt="Vendedor"
                        style="width:90px; height:90px; border-radius:50%;">
                    <h5 class="fw-semibold mt-2">GATITADINÁMICA</h5>
                    <div class="text-warning mb-1">
                        <i class="fa fa-star"></i><i class="fa fa-star"></i>
                        <i class="fa fa-star"></i><i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                    </div>
                    <p class="text-muted small">Excelente reputación y tiempo de respuesta rápido</p>
                </div>
            </div>

            <!-- Detalle -->
            <div class="col-md-7">
                <div class="card border-0 shadow-sm p-4 bg-light">
                    <h4 class="fw-bold mb-3">
                        <asp:Label ID="lblNombre" runat="server" />
                    </h4>

                    <p><asp:Label ID="lblTipo" runat="server" CssClass="fw-semibold" /></p>
                    <p><strong>Precio por día:</strong> <asp:Label ID="lblPrecio" runat="server" /></p>
                    <p><asp:Label ID="lblPeriodo" runat="server" /></p>

                    <p class="fw-semibold mt-3 mb-1">Descripción:</p>
                    <ul class="text-muted small">
                        <li><asp:Label ID="lblDescripcion" runat="server" /></li>
                    </ul>

                    <div class="text-primary fw-bold fs-4 mb-3">
                        <asp:Label ID="lblPrecioDia" runat="server" />
                    </div>

                    <div class="d-flex justify-content-between">
                        <asp:Button ID="btnVolver2" runat="server"
                            CssClass="btn btn-outline-secondary w-50 me-2"
                            Text="Volver" OnClick="btnVolver_Click" />
                        <asp:Button ID="btnAlquilar" runat="server"
                            CssClass="btn btn-primary w-50"
                            Text="Alquilar" OnClick="btnAlquilar_Click" />
                    </div>
                </div>
            </div>
        </div>
    </div>
</asp:Content>
