<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/SquirLearn.Master" AutoEventWireup="true" CodeBehind="Otros.aspx.cs" Inherits="SquirlearnWA.Otros" %>
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
            <h2 class="fw-bold mb-0">ÚTILES Y ACCESORIOS</h2>
        </div>

        <p class="text-muted mb-4">
            Encuentra mochilas, estuches, materiales de escritorio y más artículos complementarios para tus clases o prácticas.
        </p>

        <hr />

        <div class="row">
            <!-- Panel lateral de filtros -->
            <div class="col-md-3">
                <div class="card shadow-sm p-3">
                    <h6 class="fw-bold mb-3">Filtros de búsqueda</h6>

                    <div class="mb-3">
                        <label class="form-label fw-semibold small">Buscar por nombre</label>
                        <asp:TextBox ID="txtBusqueda" runat="server" CssClass="form-control" Placeholder="Ej: Mochila, Estuche..."></asp:TextBox>
                    </div>

                    <div class="mb-3">
                        <label class="form-label fw-semibold small">Condición</label>
                        <asp:DropDownList ID="ddlCondicion" runat="server" CssClass="form-select">
                            <asp:ListItem Text="Todas" Value=""></asp:ListItem>
                            <asp:ListItem Text="Nuevo" Value="Nuevo"></asp:ListItem>
                            <asp:ListItem Text="Seminuevo" Value="Seminuevo"></asp:ListItem>
                            <asp:ListItem Text="Antiguo" Value="Antiguo"></asp:ListItem>
                        </asp:DropDownList>
                    </div>

                    <div class="mb-3">
                        <label class="form-label fw-semibold small">Tamaño</label>
                        <asp:DropDownList ID="ddlTamano" runat="server" CssClass="form-select">
                            <asp:ListItem Text="Todos" Value=""></asp:ListItem>
                            <asp:ListItem Text="Grande" Value="Grande"></asp:ListItem>
                            <asp:ListItem Text="Mediano" Value="Mediano"></asp:ListItem>
                            <asp:ListItem Text="Chico" Value="Chico"></asp:ListItem>
                        </asp:DropDownList>
                    </div>

                    <div class="mb-3">
                        <label class="form-label fw-semibold small">Color</label>
                        <asp:DropDownList ID="ddlColor" runat="server" CssClass="form-select">
                            <asp:ListItem Text="Todos" Value=""></asp:ListItem>
                            <asp:ListItem Text="Rojo" Value="Rojo"></asp:ListItem>
                            <asp:ListItem Text="Azul" Value="Azul"></asp:ListItem>
                            <asp:ListItem Text="Negro" Value="Negro"></asp:ListItem>
                        </asp:DropDownList>
                    </div>

                    <div class="mb-3">
                        <label class="form-label fw-semibold small">Subcategoría</label>
                        <asp:DropDownList ID="ddlSubcategoria" runat="server" CssClass="form-select">
                            <asp:ListItem Text="Todas" Value=""></asp:ListItem>
                            <asp:ListItem Text="Mochila" Value="Mochila"></asp:ListItem>
                            <asp:ListItem Text="Estuche" Value="Estuche"></asp:ListItem>
                            <asp:ListItem Text="Material de escritorio" Value="Material de escritorio"></asp:ListItem>
                            <asp:ListItem Text="Ropa" Value="Ropa"></asp:ListItem>
                        </asp:DropDownList>
                    </div>

                    <asp:Button ID="btnBuscar" runat="server" Text="Buscar" CssClass="btn btn-primary w-100 mb-2"
                        OnClick="btnBuscar_Click" />
                    <asp:Button ID="btnInicio" runat="server" Text="Regresar al inicio" CssClass="btn btn-outline-secondary w-100"
                        OnClick="btnInicio_Click" />
                </div>
            </div>

            <!-- Lista de productos -->
            <div class="col-md-9">
                <div class="d-flex flex-wrap justify-content-start">
                    <asp:Repeater ID="rptOtros" runat="server" OnItemCommand="rptOtros_ItemCommand">
                        <ItemTemplate>
                            <div class="card shadow-sm border-0 p-3 mx-2 mb-4" style="width: 19rem;">
                                <img src='<%# Eval("ImagenUrl") %>' alt="Producto" class="img-fluid mb-3"
                                     style="width:100%; height:150px; object-fit:contain;">
                                <div class="card-body p-0">
                                    <h5 class="fw-bold mb-1"><%# Eval("Nombre") %></h5>
                                    <p class="text-muted small mb-1"><%# Eval("Descripcion") %></p>
                                    <p class="text-primary fw-semibold mb-2">s/. <%# Eval("Precio") %></p>
                                    <asp:Button ID="btnDetalle" runat="server" CssClass="btn btn-outline-primary btn-sm w-100"
                                        Text="Ver Detalle" CommandName="VerDetalle"
                                        CommandArgument='<%# Eval("Nombre") + "|" + Eval("Descripcion") + "|" + Eval("Precio") + "|" + Eval("ImagenUrl") %>' />
                                </div>
                            </div>
                        </ItemTemplate>
                    </asp:Repeater>
                </div>
            </div>
        </div>
    </div>
</asp:Content>
