<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/SquirLearn.Master" AutoEventWireup="true" CodeBehind="Apuntes.aspx.cs" Inherits="SquirlearnWA.Apuntes" %>
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
            APUNTES DE CLASE <span id="Span1" runat="server" class="text-primary fw-bold ms-2">COMPRA</span>

        </h2>
    </div>

        <hr />

        <div class="row">
            <!-- Panel lateral de filtros -->
            <div class="col-md-3">
                <div class="card shadow-sm p-3">
                    <h6 class="fw-bold mb-3">Buscar apuntes</h6>

                    <div class="mb-3">
                        <label class="form-label fw-semibold small">Buscar por palabras</label>
                        <asp:TextBox ID="txtBusqueda" runat="server" CssClass="form-control" Placeholder="Ingresar texto"></asp:TextBox>
                    </div>

                    <div class="mb-3">
                        <label class="form-label fw-semibold small">Escoger subcategoría</label>
                        <asp:DropDownList ID="ddlSubcategoria" runat="server" CssClass="form-select">
                            <asp:ListItem Text="Todas" Value=""></asp:ListItem>
                            <asp:ListItem Text="Apuntes de clase" Value="apuntes"></asp:ListItem>
                            <asp:ListItem Text="Resúmenes" Value="resumen"></asp:ListItem>
                            <asp:ListItem Text="Guías de práctica" Value="guia"></asp:ListItem>
                            <asp:ListItem Text="Otros" Value="otros"></asp:ListItem>
                        </asp:DropDownList>
                    </div>

                    <asp:Button ID="btnBuscar" runat="server" Text="Buscar" CssClass="btn btn-primary w-100 mb-2" OnClick="btnBuscar_Click" />
                </div>
            </div>

            <!-- Listado -->
            <div class="col-md-9">

                <!-- Mensajes -->
                <div class="mb-3 text-center">
                    <asp:Label ID="lblTotalResultados" runat="server" CssClass="fw-semibold text-success d-block"></asp:Label>
                   
                </div>

                <div class="d-flex flex-wrap justify-content-start">
                    <asp:Repeater ID="rptApuntes" runat="server" OnItemCommand="rptApuntes_ItemCommand">
                        <ItemTemplate>
                            <div class="card shadow-sm border-0 p-3 mx-2 mb-4" style="width: 20rem;">
                                <img src='<%# Eval("ImagenUrl") %>' alt="Apunte"
                                     class="card-img-top img-fluid mb-3"
                                     style="max-width: 140px; height: 160px; object-fit: contain; margin: auto;">
                                <div class="card-body p-0 text-center">
                                    <h5 class="fw-bold"><%# Eval("Titulo") %></h5>
                                    <p class="text-muted small mb-2"><%# Eval("Subcategoria") %></p>
                                    <p class="text-primary fw-semibold mb-3">S/ <%# Eval("Precio", "{0:N2}") %></p>
                                    <asp:Button ID="btnDetalle" runat="server" CssClass="btn btn-primary btn-sm"
                                                Text="Ver Detalle" CommandName="VerDetalle"
                                                CommandArgument='<%# Eval("IdVendedor") + "|" + Eval("ImagenUrl")  + "|" + Eval("Titulo") + "|" + Eval("Subcategoria") 
                                                    + "|"  + Eval("Precio") + "|"  + Eval("Descripcion")  + "|" + Eval("EstadoProducto")
                                                    + "|" + Eval("Periodo") + "|" + Eval("IdPublicacion") + "|" + Eval("Tipo")  %>' />
                                </div>
                            </div>
                        </ItemTemplate>
                    </asp:Repeater>
                </div>
                    <!-- 🔹 Sin resultados -->
                        <div class="text-center mt-3">
                            <asp:Label ID="lblSinResultados" runat="server" CssClass="text-danger fw-semibold"></asp:Label>
                        </div>
                <!-- Paginación -->
                <div class="d-flex justify-content-center mt-3">
                    <asp:Button ID="btnAnterior" runat="server" Text="Anterior" CssClass="btn btn-outline-secondary me-2" OnClick="btnAnterior_Click" />
                    <asp:Label ID="lblPagina" runat="server" Text="Página 1" CssClass="align-self-center fw-bold"></asp:Label>
                    <asp:Button ID="btnSiguiente" runat="server" Text="Siguiente" CssClass="btn btn-outline-secondary ms-2" OnClick="btnSiguiente_Click" />
                </div>

            </div>
        </div>
    </div>
</asp:Content>