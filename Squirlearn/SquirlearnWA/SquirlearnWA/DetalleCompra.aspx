<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/SquirLearn.Master" AutoEventWireup="true" CodeBehind="DetalleCompra.aspx.cs" Inherits="SquirlearnWA.DetalleCompra" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphContenido" runat="server">

    <div class="container-fluid px-5 py-4">
        <div class="row g-4 align-items-start">

            <!-- Flecha de regreso -->
            <div class="col-12 mb-3">
                <asp:LinkButton ID="btnVolver" runat="server" CssClass="text-decoration-none text-dark fw-semibold" OnClick="btnVolver_Click">
                    <i class="fa fa-arrow-left"></i>
                </asp:LinkButton>
            </div>
             <!-- ESTOS DATOS SE TRAEN DEL BO -->
            <!-- VENDEDOR -->
            <div class="col-md-3 text-center border-end">
                <img src="../Imagenes/Avatar.png" 
                     alt="Vendedor" style="width:120px; height:120px; border-radius:50%;">
                <h5 class="fw-semibold mt-3">JAVIER PEREZ</h5>
                <div class="text-warning mb-2">
                    <i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i>
                </div>
                <p class="text-muted small mt-2">Excelente reputación y tiempo de respuesta rápido</p>
            </div>

            <!-- DETALLE – COMPRA -->
            <div class="col-md-5 border-end">
                <div class="px-4">
                    <h6 class="fw-bold text-secondary">DETALLE – COMPRA</h6>

                    <div class="d-flex align-items-center mb-3">
                        <img src="../Imagenes/instrumentos.png"
                             alt="Calculadora científica" style="width:100px; height:100px; object-fit:contain; margin-right:15px;">
                        <div>
                            <h5 class="fw-bold mb-1">Calculadora Científica</h5>
                            <p class="text-muted small mb-0">Modelo fx-350 PLUS</p>
                        </div>
                    </div>

                    <div class="text-primary fw-bold fs-4 mb-2">s/. 30.50</div>
                    <p class="text-muted small mb-1">Envío: s/. 2.00</p>
                    <p class="text-muted small mb-3">Entrega estimada: 28 JUL</p>

                    <label class="fw-semibold">Cantidad:</label>
                    <div class="d-flex align-items-center mt-1">
                        <button type="button" class="btn btn-outline-secondary btn-sm px-2">-</button>
                        <span class="px-3 fw-semibold">1</span>
                        <button type="button" class="btn btn-outline-secondary btn-sm px-2">+</button>
                    </div>
                </div>
            </div>

            <!-- PAGO -->
            <div class="col-md-4">
                <div class="px-4">
                    <h6 class="fw-bold text-secondary">PAGO</h6>

                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="metodoPago" id="tarjeta" checked>
                        <label class="form-check-label" for="tarjeta">
                            Pagar con tarjeta de crédito 
                            <i class="fa fa-cc-visa"></i> 
                            <i class="fa fa-cc-mastercard"></i>
                        </label>
                    </div>

                    <div class="form-check mt-2">
                        <input class="form-check-input" type="radio" name="metodoPago" id="yape">
                        <label class="form-check-label" for="yape">Pagar con Yape</label>
                    </div>

                    <hr />
                    <h6 class="fw-bold">Resumen</h6>
                    <p class="mb-1">Subtotal: <span class="float-end">s/. 30.50</span></p>
                    <p class="mb-1">Ahorro: <span class="float-end">-s/. 1.50</span></p>
                    <p class="mb-1">Código promocional 
                        <a href="CodigoPromocional.aspx" class="small text-primary">más info</a>
                    </p>
                    <p class="mb-1">Total de envío: <span class="float-end">s/. 2.00</span></p>

                    <hr />
                    <h5>Total: <span class="float-end fw-bold">s/. 31.00</span></h5>

                    <asp:Button ID="btnConfirmar" runat="server" CssClass="btn btn-primary w-100 mt-3" 
                                Text="Realizar pedido" OnClick="btnConfirmar_Click" />
                </div>
            </div>
        </div>
    </div>

</asp:Content>

