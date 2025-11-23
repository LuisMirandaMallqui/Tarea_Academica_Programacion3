<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/SquirLearn.Master" AutoEventWireup="true" CodeBehind="SquirLearnInicio.aspx.cs" Inherits="SquirlearnWA.SquirLearnInicio" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphContenido" runat="server">
    <!-- Dentro del formulario ASP.NET -->

    <div class="d-flex justify-content-end mb-3">
        <asp:Button ID="btnBusqueda" runat="server" CssClass="btn btn-primary" Text="Buscar Productos"
            OnClick="btnBusqueda_Click" />
    </div>
    <style>
        .categorias-wrapper{
            margin-top: 3rem;   
        }       
    </style>
    <div class="categorias-wrapper">
        <asp:Repeater ID="rptCategorias" runat="server" OnItemCommand="rptCategorias_ItemCommand">
            <HeaderTemplate>
                <div class="card-grid">
            </HeaderTemplate>

            <ItemTemplate>
                <asp:LinkButton ID="lnkCategoria" runat="server"
                    CssClass="card-option text-decoration-none text-dark"
                    CommandName="VerCategoria"
                    CommandArgument='<%# Eval("categoriaId") %>'>
                    <img src='<%# ResolveUrl("../Imagenes/" + Eval("nombre")+ ".png") %>' alt='<%# Eval("nombre") %>' />
                    <asp:Label ID="lblNombreCategoria" runat="server" Text='<%# Eval("nombre") %>' CssClass="d-block fw-semibold"></asp:Label>
                </asp:LinkButton>


            </ItemTemplate>

            <FooterTemplate>
                </div>
       
            </FooterTemplate>
        </asp:Repeater>
    </div>
</asp:Content>
