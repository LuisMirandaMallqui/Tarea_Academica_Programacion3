<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/SquirLearn.Master" AutoEventWireup="true" CodeBehind="DetalleProductoCompra.aspx.cs" Inherits="SquirlearnWA.DetalleProductoCompra" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphContenido" runat="server">

    <div class="container py-4">

        <!-- Flecha de regreso -->
        <div class="mb-3">
            <asp:LinkButton ID="btnVolver" runat="server" CssClass="btn btn-link text-dark fw-semibold" OnClick="btnVolver_Click">
                <i class="fa fa-arrow-left"></i> Volver
            </asp:LinkButton>
        </div>

        <div class="row align-items-center">
            <!-- TODOS ESTOS DATOS SE TRAE DEL BO  -->
            <!-- Imagen del producto -->
            <div class="col-md-5 text-center">
                <img src="../Imagenes/instrumentos.png" 
                     alt="Calculadora Científica" 
                     style="width:200px; height:200px; object-fit:contain; margin-bottom:15px;" />

                <div class="text-center">
                    <img src="../Imagenes/Avatar.png" alt="Vendedor" 
                         style="width:90px; height:90px; border-radius:50%;">
                    <h5 class="fw-semibold mt-2">JAVIER PEREZ</h5>
                    <div class="text-warning mb-1">
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                    </div>
                    <p class="text-muted small">Excelente reputación y tiempo de respuesta rápido</p>
                </div>
            </div>

            <!-- Detalle del producto -->
            <div class="col-md-7">
                <div class="card border-0 shadow-sm p-4 bg-light">
                    <h4 class="fw-bold mb-3">Calculadora Científica</h4>

                    <p><strong>Estado:</strong> Usado</p>
                    <p><strong>Descripción:</strong></p>
                    <ul>
                        <li>Calculadora científica modelo fx-350 PLUS.</li>
                        <li>Incluye manual de instrucciones dentro de la caja.</li>
                    </ul>

                    <div class="text-primary fw-bold fs-4 mb-3">s/. 30.50</div>

                    <div class="d-flex justify-content-between">
                        <asp:Button ID="btnVolver2" runat="server" CssClass="btn btn-outline-secondary w-50 me-2" 
                                    Text="Volver" OnClick="btnVolver_Click" />
                        <asp:Button ID="btnComprar" runat="server" CssClass="btn btn-primary w-50" 
                                    Text="Comprar" OnClick="btnComprar_Click" />
                    </div>
                </div>
            </div>
        </div>

    </div>

</asp:Content>