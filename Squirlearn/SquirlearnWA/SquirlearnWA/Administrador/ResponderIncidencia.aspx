<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/SquirLearn.Master" AutoEventWireup="true" CodeBehind="ResponderIncidencia.aspx.cs" Inherits="SquirlearnWA.Administrador.ResponderIncidencia" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphContenido" runat="server">

    <asp:LinkButton ID="btnVolver" runat="server" CssClass="btn btn-link text-dark btn-flecha me-3" OnClick="btnVolver_Click">
    <i class="fa fa-arrow-left"></i>Volver
    </asp:LinkButton>
    <div class="container mt-2">
    <div class="card p-4 shadow-sm" style="max-height:500px; overflow-y:auto;">
        <h3 class="mb-4">Responder Incidencia</h3>

        <div class="mb-3">
            <label for="txtID" class="form-label">Nombre del ususario</label>
            <asp:TextBox ID="txtID" runat="server" CssClass="form-control readonly" ReadOnly="true"></asp:TextBox>
        </div>

         <div class="mb-3">
             <label for="txtID" class="form-label">Correo del usuario</label>
             <asp:TextBox ID="txtCorreo" runat="server" CssClass="form-control readonly" ReadOnly="true"></asp:TextBox>
         </div>

         <div class="mb-3">
             <label for="txtID" class="form-label">Motivo</label>
             <asp:TextBox ID="txtMotivo" runat="server" CssClass="form-control readonly" ReadOnly="true"></asp:TextBox>
         </div>

        <div class="mb-3">
            <label for="txtDescripcion" class="form-label">Descripción de la incidencia</label>
            <asp:TextBox ID="txtDescripcion" runat="server" TextMode="MultiLine" Rows="3" CssClass="form-control readonly" ReadOnly="true"></asp:TextBox>
        </div>

        <div class="mb-3">
            <label for="txtRespuesta" class="form-label">Tu respuesta</label>
            <asp:TextBox ID="txtRespuesta" runat="server" TextMode="MultiLine" Rows="3" CssClass="form-control" placeholder="Escribe tu respuesta aquí..."></asp:TextBox>
        </div>

        <div class="mb-3">
            <label for="ddlEstado" class="form-label">Actualizar Estado</label>
            <asp:DropDownList ID="ddlEstado" runat="server" CssClass="form-select">
                <asp:ListItem Text="Pendiente" Value="Pendiente"></asp:ListItem>
                <asp:ListItem Text="Resuelta" Value="Resuelta"></asp:ListItem>
            </asp:DropDownList>
        </div>

        <asp:Button ID="btnGuardar" runat="server" Text="Guardar cambios" CssClass="btn btn-primary w-100" OnClick="btnGuardar_Click" />
    </div>
</div>

</asp:Content>
