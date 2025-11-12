<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/SquirLearn.Master" AutoEventWireup="true" CodeBehind="AdminInicio.aspx.cs" Inherits="SquirlearnWA.AdminInicio" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphContenido" runat="server">


    <h2>Bienvenido, administrador <%= Session["Usuario"] %>!</h2>
</asp:Content>
