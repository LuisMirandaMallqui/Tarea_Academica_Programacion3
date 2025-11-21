<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/SquirLearn.Master" AutoEventWireup="true" CodeBehind="Notificaciones.aspx.cs" Inherits="SquirlearnWA.Notificaciones" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphContenido" runat="server">

    <div class="container perfil-container mt-4">
        <asp:LinkButton ID="btnVolver" runat="server" CssClass="btn btn-link text-dark mb-3 btn-flecha" OnClick="btnVolver_Click">
            <i class="fa fa-arrow-left"></i>
        </asp:LinkButton>

       <div class="container mt-4">
    <h2 class="text-center mb-4 fw-bold">NOTIFICACIONES</h2>

    <div class="d-flex justify-content-end align-items-center mb-3">
        <asp:Label ID="lblTotalResultados" runat="server" CssClass="fw-semibold text-muted"></asp:Label>
    </div>

    <asp:Repeater ID="rptNotificaciones" runat="server">
        <ItemTemplate>
            <div class="card shadow-sm border-0 p-3 mb-3">
                <div class="d-flex justify-content-between align-items-center">
                    <p class="mb-0 fw-semibold"><%# Eval("mensaje") %></p>
                    <small class="text-muted"><%# Eval("fecha") %></small>
                </div>
            </div>
        </ItemTemplate>
    </asp:Repeater>

    <asp:Label ID="lblSinResultados" runat="server" CssClass="text-danger fw-semibold d-block text-center mt-3"></asp:Label>

    <div class="d-flex justify-content-between align-items-center mt-4">
        <asp:Button ID="btnAnterior" runat="server" Text="Anterior" CssClass="btn btn-outline-primary"
            OnClick="btnAnterior_Click" />
        <asp:Label ID="lblPagina" runat="server" CssClass="fw-semibold text-secondary"></asp:Label>
        <asp:Button ID="btnSiguiente" runat="server" Text="Siguiente" CssClass="btn btn-outline-primary"
            OnClick="btnSiguiente_Click" />
    </div>
</div>
</asp:Content>
