<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/SquirLearn.Master" AutoEventWireup="true" CodeBehind="AdminInicio.aspx.cs" Inherits="SquirlearnWA.AdminInicio" %>


<asp:Content ID="Content1" ContentPlaceHolderID="cphContenido" runat="server">
    <h2 class="mb-2">
        ¡Hola de nuevo, <%= Session["Usuario"] %>!
    </h2>
    <p class="lead">
        Todo listo para sus tareas de administración. ¡Empecemos a trabajar!
    </p>
</asp:Content>
