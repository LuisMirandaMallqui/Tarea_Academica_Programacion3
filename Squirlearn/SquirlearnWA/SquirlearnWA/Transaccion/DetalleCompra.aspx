<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/SquirLearn.Master" AutoEventWireup="true" CodeBehind="DetalleCompra.aspx.cs" Inherits="SquirlearnWA.DetalleCompra" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphContenido" runat="server">

    <div class="container-fluid px-5 py-4">
        <div class="row g-4 align-items-start">

            <!-- Flecha de regreso -->
            <div class="col-12 mb-3">
                <asp:LinkButton ID="btnVolver" runat="server" CssClass="text-decoration-none text-dark fw-semibold"
                    OnClick="btnVolver_Click">
                    <i class="fa fa-arrow-left"></i> Volver
                </asp:LinkButton>
            </div>

            <!-- DETALLE – COMPRA -->
            <div class="col-md-8 border-end">
                <div class="px-4">
                    <h1 class="fw-bold text-secondary">DETALLE – COMPRA</h1>

                    <div class="d-flex align-items-center mb-3">
                        <asp:Image ID="imgProducto" runat="server"
                                   Style="width:100px; height:100px; object-fit:contain; margin-right:15px;" />
                        <div>
                            <h5 class="fw-bold mb-1"><asp:Label ID="lblNombre" runat="server" /></h5>
                            <p class="text-muted small mb-0"><asp:Label ID="lblDescripcion" runat="server" /></p>
                        </div>
                    </div>

                    <asp:Label ID="lblTipo" runat="server" CssClass="fw-semibold d-block" Text="Tipo: Compra"></asp:Label>
                    <asp:Label ID="lblPrecioDia" runat="server" CssClass="text-primary d-block mt-1" Text="Precio: S/ 0.00"></asp:Label>

                    <div class="text-primary fw-bold fs-4 mb-2">
                        <asp:Label ID="lblPrecio" runat="server" />
                    </div>

                    <!-- Información -->
                    <p class="text-muted small">Entrega y acceso coordinados directamente con el vendedor.</p>
                </div>
            </div>

            <!-- PAGO -->
            <div class="col-md-4">
                <div class="px-4">
                    <h6 class="fw-bold text-secondary">PAGO</h6>

                   <!-- Opción Tarjeta -->
                        <asp:RadioButton ID="rdbTarjeta" runat="server" 
                            GroupName="metodoPago" 
                            Text="Pagar con tarjeta de crédito/débito" 
                            Checked="true" 
                            CssClass="form-check-input" />

                         <div> </div> 

                        <!-- Opción Yape -->
                        <asp:RadioButton ID="rdbYape" runat="server" 
                            GroupName="metodoPago" 
                            Text="Pagar con Yape" 
                            CssClass="form-check-input mt-2" />

                    <hr />

                    <!-- Resumen -->
                    <div class="mt-4">
                        <h6 class="fw-bold">Resumen</h6>
                        <p class="mb-1">Subtotal: <span class="float-end">s/. <asp:Label ID="lblSubtotal" runat="server" Text="0.00"></asp:Label></span></p>
                        <h5>Total: <span id="lblTotal" runat="server" class="float-end fw-bold text-primary">s/. 0.00</span></h5>
                    </div>

                    <asp:Button ID="btnConfirmar" runat="server" CssClass="btn btn-primary w-100 mt-3"
                                Text="Realizar pago" OnClick="btnConfirmar_Click" />
                </div>
            </div>
        </div>
    </div>

</asp:Content>