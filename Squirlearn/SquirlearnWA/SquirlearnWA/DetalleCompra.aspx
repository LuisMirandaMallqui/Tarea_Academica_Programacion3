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

            <!-- VENDEDOR -->
            <div class="col-md-3 text-center border-end">
                <img src="../Imagenes/Avatar.png" alt="Vendedor" style="width:120px; height:120px; border-radius:50%;">
                <h5 class="fw-semibold mt-3"><asp:Label ID="lblVendedor" runat="server" /></h5>
                <div class="text-warning mb-2">
                    <i class="fa fa-star"></i><i class="fa fa-star"></i>
                    <i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i>
                </div>
                <p class="text-muted small mt-2">Excelente reputación y tiempo de respuesta rápido</p>
            </div>

            <!-- DETALLE – COMPRA -->
            <div class="col-md-5 border-end">
                <div class="px-4">
                    <h1 class="fw-bold text-secondary">DETALLE – COMPRA</h1>

                    <div class="d-flex align-items-center mb-3">
                        <asp:Image ID="imgProducto" runat="server" Style="width:100px; height:100px; object-fit:contain; margin-right:15px;" />
                        <div>
                            <h5 class="fw-bold mb-1">
                                <asp:Label ID="lblNombreProducto" runat="server" />
                            </h5>
                            <p class="text-muted small mb-0">
                                <asp:Label ID="lblDescripcion" runat="server" />
                            </p>
                        </div>
                    </div>

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

                    <!-- Código promocional -->
                    <div class="mt-3">
                        <label class="fw-semibold">Código promocional:</label>
                        <div class="input-group">
                            <asp:TextBox ID="txtCodigoPromo" runat="server" CssClass="form-control" Placeholder="Ingresa tu código aquí"></asp:TextBox>
                            <asp:Button ID="btnAplicarCodigo" runat="server" Text="Aplicar" CssClass="btn btn-outline-primary" OnClick="btnAplicarCodigo_Click" />
                        </div>
                    </div>

                    <!-- Resumen -->
                    <div class="mt-4">
                        <h6 class="fw-bold">Resumen</h6>
                        <p class="mb-1">Subtotal: <span class="float-end">s/. <asp:Label ID="lblSubtotal" runat="server" Text="0.00"></asp:Label></span></p>
                        <p class="mb-1">Ahorro: <span class="float-end">- s/. <asp:Label ID="lblAhorro" runat="server" Text="0.00"></asp:Label></span></p>
                        <hr />
                        <h5>Total: <span id="lblTotal" runat="server" class="float-end fw-bold text-primary">s/. 0.00</span></h5>
                    </div>

                    <asp:Button ID="btnConfirmar" runat="server" CssClass="btn btn-primary w-100 mt-3"
                                Text="Realizar pago" OnClick="btnConfirmar_Click" />
                </div>
            </div>
        </div>
    </div>

</asp:Content>