<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/SquirLearn.Master" AutoEventWireup="true" CodeBehind="Notificaciones.aspx.cs" Inherits="SquirlearnWA.Notificaciones" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphContenido" runat="server">

    <div class="container perfil-container mt-4">
        <!-- 🔙 Flecha para volver atrás -->
        <asp:LinkButton ID="btnVolver" runat="server" CssClass="btn btn-link text-dark mb-3 btn-flecha" OnClick="btnVolver_Click">
            <i class="fa fa-arrow-left"></i>
        </asp:LinkButton>

       <div class="container mt-4">
    <h2 class="text-center mb-4 fw-bold">NOTIFICACIONES</h2>

    <!-- 🔽 Filtro -->
        <div class="d-flex justify-content-between align-items-center mb-3">
            <div>
                <label class="fw-semibold me-2">Ordenar por:</label>
                <asp:DropDownList ID="ddlOrden" runat="server" CssClass="form-select d-inline-block w-auto">
                    <asp:ListItem Text="Más recientes" Value="desc"></asp:ListItem>
                    <asp:ListItem Text="Más antiguos" Value="asc"></asp:ListItem>
                </asp:DropDownList>
                <asp:Button ID="btnFiltrar" runat="server" Text="Filtrar" CssClass="btn btn-primary btn-sm ms-2"
                            OnClick="btnFiltrar_Click" />
            </div>

            <asp:Label ID="lblTotalResultados" runat="server" CssClass="fw-semibold text-muted"></asp:Label>
        </div>

        <!-- 🧾 Listado -->
        <asp:Repeater ID="rptNotificaciones" runat="server">
            <ItemTemplate>
                <div class="card shadow-sm border-0 p-3 mb-3">
                    <div class="d-flex justify-content-between align-items-center">
                        <p class="mb-0 fw-semibold"><%# Eval("Mensaje") %></p>
                        <small class="text-muted"><%# Eval("Fecha", "{0:dd/MM/yyyy}") %></small>
                    </div>
                </div>
            </ItemTemplate>
        </asp:Repeater>

        <!-- ⚠️ Sin resultados -->
        <asp:Label ID="lblSinResultados" runat="server" CssClass="text-danger fw-semibold d-block text-center mt-3"></asp:Label>

        <!-- 📄 Paginación -->
        <div class="d-flex justify-content-between align-items-center mt-4">
            <asp:Button ID="btnAnterior" runat="server" Text="Anterior" CssClass="btn btn-outline-primary"
                        OnClick="btnAnterior_Click" />
            <asp:Label ID="lblPagina" runat="server" CssClass="fw-semibold text-secondary"></asp:Label>
            <asp:Button ID="btnSiguiente" runat="server" Text="Siguiente" CssClass="btn btn-outline-primary"
                        OnClick="btnSiguiente_Click" />
        </div>
    </div>
</asp:Content>
