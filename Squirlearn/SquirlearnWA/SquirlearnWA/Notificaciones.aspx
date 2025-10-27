<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/SquirLearn.Master" AutoEventWireup="true" CodeBehind="Notificaciones.aspx.cs" Inherits="SquirlearnWA.Notificaciones" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphContenido" runat="server">

    <div class="container perfil-container mt-4">
        <!-- 🔙 Flecha para volver atrás -->
        <asp:LinkButton ID="btnVolver" runat="server" CssClass="btn btn-link text-dark mb-3 btn-flecha" OnClick="btnVolver_Click">
            <i class="fa fa-arrow-left"></i>
        </asp:LinkButton>

       <div class="container mt-4">
    <h2 class="text-center mb-4 fw-bold">NOTIFICACIONES</h2>

    <div class="notificaciones-container">
        <asp:Repeater ID="rptNotificaciones" runat="server">
            <ItemTemplate>
                <div class="list-group-item d-flex align-items-center border-bottom py-2">
                    <i class="fa fa-check-circle text-success me-3"></i>
                    
                        <div class="d-flex justify-content-between flex-grow-1 align-items-center">
                            <p class="mb-0 fw-semibold"><%# Eval("Mensaje") %></p>
                            <small class="text-muted ms-3"><%# Eval("Fecha", "{0:dd MMM yyyy}") %></small>
                        </div>
                </div>
            </ItemTemplate>
        </asp:Repeater>
    </div>
</div>

        
    </div>
</asp:Content>
