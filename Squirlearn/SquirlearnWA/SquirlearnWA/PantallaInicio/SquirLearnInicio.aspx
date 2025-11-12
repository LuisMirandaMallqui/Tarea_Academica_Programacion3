<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/SquirLearn.Master" AutoEventWireup="true" CodeBehind="SquirLearnInicio.aspx.cs" Inherits="SquirlearnWA.SquirLearnInicio" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphContenido" runat="server">
    <!-- Dentro del formulario ASP.NET -->

    <asp:Button ID="btnBusqueda" runat="server" CssClass="btn btn-primary" Text="Buscar Productos" OnClick="btnBusqueda_Click" />

    <asp:Repeater ID="rptCategorias" runat="server" OnItemCommand="rptCategorias_ItemCommand">
        <HeaderTemplate>
            <div class="card-grid">
        </HeaderTemplate>

        <ItemTemplate>
            <asp:LinkButton ID="lnkCategoria" runat="server"
                CssClass="card-option text-decoration-none text-dark"
                CommandName="VerCategoria"
                CommandArgument='<%# Eval("IdCategoria") %>'>
                <img src='<%# ResolveUrl("~/Imagenes/" + Eval("UrlImagen")) %>' alt='<%# Eval("Nombre") %>' />
                <asp:Label ID="lblNombreCategoria" runat="server" Text='<%# Eval("Nombre") %>' CssClass="d-block fw-semibold"></asp:Label>
            </asp:LinkButton>


        </ItemTemplate>

        <FooterTemplate>
            </div>
        </FooterTemplate>
    </asp:Repeater>
    
</asp:Content>
