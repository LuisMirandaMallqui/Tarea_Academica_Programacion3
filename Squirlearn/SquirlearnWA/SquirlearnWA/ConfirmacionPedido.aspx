<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/SquirLearn.Master" AutoEventWireup="true" CodeBehind="ConfirmacionPedido.aspx.cs" Inherits="SquirlearnWA.ConfirmacionPedido" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="text-center mt-5">
        

        <div class="mt-5">
            <img src="https://cdn-icons-png.flaticon.com/512/845/845646.png" 
                 alt="Confirmado" style="width:120px; margin-bottom:20px;">
            <h5 class="fw-bold text-success">Proceso realizado con éxito.</h5>
            <p class="text-muted mb-4">El pedido llegará pronto.</p>

            <asp:Button ID="btnVolverInicio" runat="server" CssClass="btn btn-primary" 
                        Text="Volver a la página principal" OnClick="btnVolverInicio_Click" />
        </div>
    </div>
</asp:Content>