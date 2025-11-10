<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/SquirLearn.Master" AutoEventWireup="true" CodeBehind="ListadoDeSolicitudesAdmin.aspx.cs" Inherits="SquirlearnWA.ListadoDeSolicitudesAdmin" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphContenido" runat="server">

    <div class="container mt-4">
    <h4 class="fw-bold mb-4">Listado de solicitudes</h4>

   <div class="notificaciones-container">
    <asp:Repeater ID="rptSolicitudes" runat="server">
        <ItemTemplate>
            <div class="p-4 mb-3 rounded" style="background-color:#d9dee3; max-width:800px;">
                <div class="text-center mb-3">
                    <span class="fw-semibold">SOLICITUD : </span>
                    <span><%# Eval("NombreUsuario") %></span>
                    <span><%#Eval("FechaSolicitud", "{0:dd MMM yyyy}") %></span>
                    
                </div>
                <div class="text-center">
                    <a href='SolicitudPedidosAdmin.aspx?id=<%# Eval("IdPublicacion") %>' 
                       class="btn fw-bold"
                       style="background-color:limegreen; color:black; border-radius:25px; padding:10px 40px; font-size:18px;">
                       REVISAR
                    </a>
                </div>
            </div>
        </ItemTemplate>
    </asp:Repeater>
</div>


</asp:Content>
