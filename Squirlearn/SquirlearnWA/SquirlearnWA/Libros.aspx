<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/SquirLearn.Master" AutoEventWireup="true" CodeBehind="Libros.aspx.cs" Inherits="SquirlearnWA.Libros" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphContenido" runat="server">

    <div class="container-fluid px-5 py-4">
        <!-- Flecha de regreso -->
        <div class="mb-3">
            <a href="SquirLearnInicio.aspx" class="text-decoration-none text-dark fw-semibold">
                <i class="fa fa-arrow-left"></i> Volver
            </a>
        </div>

        <!-- Título -->
        <div class="d-flex justify-content-between align-items-center mb-4">
            <h2 class="fw-bold mb-0">
                LIBROS <span id="lblCategoria" runat="server" class="text-primary fw-bold ms-2"></span>
            </h2>
            <div>
                <asp:Button ID="btnCompra" runat="server" Text="Compra" CssClass="btn btn-outline-primary me-2"
                    OnClick="btnCompra_Click" />
                <asp:Button ID="btnAlquiler" runat="server" Text="Alquiler" CssClass="btn btn-outline-secondary"
                    OnClick="btnAlquiler_Click" />
            </div>
        </div>

        <hr />

        <!-- Lista de productos -->
        <div class="d-flex flex-wrap justify-content-start">
            <asp:Repeater ID="rptLibros" runat="server" OnItemCommand="rptLibros_ItemCommand">
                <ItemTemplate>
                    <div class="card shadow-sm border-0 p-3 text-center mx-2 mb-4" style="width: 18rem;">
                        <img src='<%# Eval("ImagenUrl") %>' alt="Libro" 
                             class="card-img-top img-fluid mb-3" 
                             style="max-width: 120px; height: 160px; object-fit: contain; margin: auto;">
                        <div class="card-body p-0">
                            <h5 class="fw-bold"><%# Eval("Nombre") %></h5>
                            <p class="text-muted small mb-2"><%# Eval("Descripcion") %></p>
                            <p class="text-primary fw-semibold mb-3">s/. <%# Eval("Precio") %></p>
                            <asp:Button ID="btnDetalle" runat="server"
                                CssClass="btn btn-primary btn-sm"
                                Text="Ver Detalle"
                                CommandName="VerDetalle"
                                CommandArgument='<%# Eval("Nombre") + "|" + Eval("Descripcion") + "|" + Eval("Precio") + "|" + Eval("ImagenUrl") %>' />
                        </div>
                    </div>
                </ItemTemplate>
            </asp:Repeater>
        </div>
    </div>

</asp:Content>
