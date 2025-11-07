<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/SquirLearn.Master" AutoEventWireup="true" CodeBehind="ModalPago.aspx.cs" Inherits="SquirlearnWA.ModalPago" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphContenido" runat="server">
    <!-- Modal para Tarjeta -->
<div id="tarjetaModal" runat="server" visible="false" class="modal fade show" style="display:block;">
    

  <div class="modal-dialog modal-dialog-centered" style="transform: translateY(60px);" >
    <div class="modal-content p-4" >
        <asp:LinkButton ID="btnVolver" runat="server" CssClass="btn btn-link text-dark btn-flecha me-3" OnClick="btnVolver_Click">
        <i class="fa fa-arrow-left"></i>Volver
        </asp:LinkButton>
      <h5 class="mb-3">Pago con Tarjeta</h5>
      <asp:TextBox ID="txtNumeroTarjeta" runat="server" CssClass="form-control mb-2" Placeholder="Número de tarjeta"></asp:TextBox>
      <div class="row">
        <div class="col">
          <asp:TextBox ID="txtMes" runat="server" CssClass="form-control" Placeholder="Mes (MM)"></asp:TextBox>
        </div>
        <div class="col">
          <asp:TextBox ID="txtAnio" runat="server" CssClass="form-control" Placeholder="Año (YY)"></asp:TextBox>
        </div>
      </div>
      <asp:TextBox ID="txtCVV" runat="server" CssClass="form-control mt-2" TextMode="Password" Placeholder="CVV"></asp:TextBox>
      <asp:TextBox ID="txtTitular" runat="server" CssClass="form-control mt-2" Placeholder="Titular de la tarjeta"></asp:TextBox>
      <asp:Button ID="btnConfirmarTarjeta" runat="server" CssClass="btn btn-primary mt-3 w-100" Text="Confirmar pago" OnClick="btnConfirmar" />
    </div>
  </div>
</div>

<!-- Modal para Yape -->
<div id="yapeModal" runat="server" visible="false" class="modal fade show" style="display:block;">
  <div class="modal-dialog modal-dialog-centered" style="transform: translateY(60px);">
    <div class="modal-content p-4">
        <asp:LinkButton ID="LinkButton1" runat="server" CssClass="btn btn-link text-dark btn-flecha me-3" OnClick="btnVolver_Click">
        <i class="fa fa-arrow-left"></i>Volver
        </asp:LinkButton>
      <h5 class="mb-3">Pago con Yape</h5>
      <asp:TextBox ID="txtNumeroYape" runat="server" CssClass="form-control mb-2" Placeholder="Número asociado a Yape"></asp:TextBox>
      <asp:TextBox ID="txtCodigoYape" runat="server" CssClass="form-control mb-2" Placeholder="Código de pago"></asp:TextBox>
      <asp:Button ID="btnConfirmarYape" runat="server" CssClass="btn btn-primary mt-3 w-100" Text="Confirmar pago" Onclick="btnConfirmar" />
    </div>
  </div>
</div>
</asp:Content>
