<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/SquirLearn.Master" AutoEventWireup="true" CodeBehind="AdminInicio.aspx.cs" Inherits="SquirlearnWA.Principal.AdminInicio" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphContenido" runat="server">
    <h1 class="fw-bold text-primary mb-3">Bienvenido</h1>
    <h2 class="text-dark">
        Administrador <span class="text-success"><%= Session["Usuario"] %></span> 👋
    </h2>
    <p class="text-muted mt-3">Accede a las funciones de gestión desde el menú lateral.</p>
</asp:Content>
