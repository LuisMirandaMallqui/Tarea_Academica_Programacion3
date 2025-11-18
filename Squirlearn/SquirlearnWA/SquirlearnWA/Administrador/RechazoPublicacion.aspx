<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/SquirLearn.Master" AutoEventWireup="true" CodeBehind="RechazoPublicacion.aspx.cs" Inherits="SquirlearnWA.RechazoPublicacion" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphContenido" runat="server">
        <asp:LinkButton ID="btnVolver" runat="server" CssClass="btn btn-link text-dark btn-flecha me-3" OnClick="btnVolver_Click">
    <i class="fa fa-arrow-left"></i>
</asp:LinkButton>
     <div class="container mt-5">
     <!-- Título -->
     <h2 class="text-center fw-bold mb-4">RECHAZO DE PUBLICACIÓN</h2>

     <!-- Texto y área de texto -->
     <div class="mb-3">
         <label for="txtIncidencia" class="form-label fw-semibold">Añadir un comentario para el vendedor:</label>
         <asp:TextBox ID="txtIncidencia" runat="server" TextMode="MultiLine" Rows="5" CssClass="form-control" ></asp:TextBox>
     </div>

     <!-- Botón Enviar -->
     <asp:Button ID="btnEnviar" runat="server" Text="ENVIAR" CssClass="btn btn-primary fw-semibold" OnClick="btnEnviar_Click" />
  
 </div>

</asp:Content>
