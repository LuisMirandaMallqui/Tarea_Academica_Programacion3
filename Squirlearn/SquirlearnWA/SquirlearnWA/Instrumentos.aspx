<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/SquirLearn.Master" AutoEventWireup="true" CodeBehind="Instrumentos.aspx.cs" Inherits="SquirlearnWA.Instrumentos" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphContenido" runat="server">

    <div class="container-fluid px-5 py-4">
        <!-- Flecha de regreso -->
        <div class="mb-3">
            <a href="SquirLearnInicio.aspx" class="text-decoration-none text-dark fw-semibold">
                <i class="fa fa-arrow-left"></i> Volver
            </a>
        </div>

        <div class="row">
        <!-- 🔹 FILTROS -->
        <div class="col-md-3">
            <div class="bg-light rounded p-3 shadow-sm">
                <h6 class="fw-bold mb-3">Realizar nueva búsqueda</h6>

                <label class="form-label small">Buscar por palabras</label>
                <asp:TextBox ID="txtBusqueda" runat="server" CssClass="form-control mb-3" placeholder="Ingresar texto"></asp:TextBox>

                <label class="form-label small">Escoger condiciones</label>
                <asp:DropDownList ID="ddlCondicion" runat="server" CssClass="form-select mb-3">
                    <asp:ListItem Text="Condición" Value="" />
                    <asp:ListItem Text="Nuevo" Value="Nuevo" />
                    <asp:ListItem Text="Usado" Value="Usado" />
                </asp:DropDownList>

                <label class="form-label small">Escoger subcategoría</label>
                <asp:DropDownList ID="ddlSubcategoria" runat="server" CssClass="form-select mb-3">
                    <asp:ListItem Text="Subcategoría" Value="" />
                    <asp:ListItem Text="Cálculo y medición" Value="CalculoMedicion" />
                    <asp:ListItem Text="Dibujo técnico" Value="DibujoTecnico" />
                    <asp:ListItem Text="Accesorios electrónicos" Value="Electronica" />
                    <asp:ListItem Text="Laboratorio químico" Value="Quimica" />
                    <asp:ListItem Text="Arte y diseño" Value="ArteDiseno" />
                    <asp:ListItem Text="Otros" Value="Otros" />
                </asp:DropDownList>

                <asp:Button ID="btnBuscar" runat="server" Text="Buscar" CssClass="btn btn-primary w-100 mb-2" OnClick="btnBuscar_Click" />
            </div>
        </div>

        <!-- 🔹 LISTADO -->
        <div class="col-md-9">

            <div class="d-flex justify-content-between align-items-center mb-3">
                <h3 class="fw-bold mb-0">
                    INSTRUMENTOS <span id="lblCategoria" runat="server" class="text-primary fw-bold ms-2"></span>
                </h3>
                <div>
                    <asp:Button ID="btnCompra" runat="server" Text="Compra" CssClass="btn btn-outline-primary me-2" OnClick="btnCompra_Click" />
                    <asp:Button ID="btnAlquiler" runat="server" Text="Alquiler" CssClass="btn btn-outline-secondary" OnClick="btnAlquiler_Click" />
                </div>
            </div>

            <hr />

            <!-- 🔹 Cantidad de resultados -->
            <div class="mb-3 text-end">
                <asp:Label ID="lblTotalResultados" runat="server" CssClass="fw-semibold text-secondary"></asp:Label>
            </div>

            <!-- 🔹 Repeater -->
            <div class="d-flex flex-wrap justify-content-start">
                <asp:Repeater ID="rptInstrumentos" runat="server" OnItemCommand="rptInstrumentos_ItemCommand">
                    <ItemTemplate>
                        <div class="card shadow-sm border-0 p-3 text-center mx-2 mb-4" style="width: 18rem;">
                            <img src='<%# Eval("ImagenUrl") %>' alt="Instrumento"
                                 class="card-img-top img-fluid mb-3"
                                 style="max-width: 120px; height: 160px; object-fit: contain; margin: auto;">
                            <div class="card-body p-0">
                                <h5 class="fw-bold"><%# Eval("Titulo") %></h5>
                                <p class="text-muted small mb-2"><%# Eval("Subcategoria") %></p>
                                <p class="text-primary fw-semibold mb-3">S/ <%# Eval("Precio","{0:N2}") %></p>
                                <asp:Button ID="btnDetalle" runat="server"
                                    CssClass="btn btn-primary btn-sm"
                                    Text="Ver Detalle"
                                    CommandName="VerDetalle"
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

            <!-- 🔹 Paginación -->
            <div class="d-flex justify-content-center mt-4">
                <asp:Button ID="btnAnterior" runat="server" Text="« Anterior" CssClass="btn btn-outline-secondary me-2" OnClick="btnAnterior_Click" />
                <asp:Label ID="lblPagina" runat="server" CssClass="align-self-center fw-semibold"></asp:Label>
                <asp:Button ID="btnSiguiente" runat="server" Text="Siguiente »" CssClass="btn btn-outline-secondary ms-2" OnClick="btnSiguiente_Click" />
            </div>
        </div>
    </div>
</div>
</asp:Content>