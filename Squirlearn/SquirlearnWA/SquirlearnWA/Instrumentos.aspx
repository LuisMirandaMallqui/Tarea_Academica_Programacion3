<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/SquirLearn.Master" AutoEventWireup="true" CodeBehind="Instrumentos.aspx.cs" Inherits="SquirlearnWA.Instrumentos" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphContenido" runat="server">

<div class="container-fluid px-5 py-4">
      <a href="SquirLearnInicio.aspx" class="btn btn-link text-dark">
      <i class="fa fa-arrow-left"></i> 
        </a>
    <h2 class="fw-bold mb-4">INSTRUMENTOS</h2>

    <!-- Filtros -->
    <div class="d-flex justify-content-between mb-3">
        <div>
            <button class="btn btn-outline-secondary me-2">Compra</button>
            <button class="btn btn-outline-secondary">Alquiler</button>
        </div>
      
    </div>

    <!-- Lista de productos -->
    <div class="row">
        <div class="col-md-6 mb-3">
            <div class="card shadow-sm p-3">
                <div class="d-flex align-items-center">
                     <!-- TODOS ESTOS DATOS SE DEBERIA TRAER DE BO -->
                    <img src="../Imagenes/instrumentos.png" alt="Calculadora" width="70" height="70" class="me-3" />
                    <div>
                        <h5 class="fw-bold mb-1">Calculadora fx-1500</h5>
                        <p class="text-muted small mb-0">Calculadora científica modelo fx-350 PLUS</p>
                    </div>
                    <div class="ms-auto text-end">
                        <p class="fw-bold mb-1">s/. 30.50</p>
                        <asp:Button ID="btnVerDetalle1" runat="server" CssClass="btn btn-primary btn-sm"
                            Text="Ver Detalle" OnClick="btnVerDetalle1_Click" />
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
    
</asp:Content>
