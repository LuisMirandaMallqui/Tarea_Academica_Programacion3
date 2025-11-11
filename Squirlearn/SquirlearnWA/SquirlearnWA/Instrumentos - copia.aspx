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
            <!-- 🔹 FILTROS DE BÚSQUEDA -->
            <div class="col-md-3">
                <div class="bg-light rounded p-3 shadow-sm">
                    <h6 class="fw-bold mb-3">Realizar nueva búsqueda</h6>

                    <!-- Buscar por palabras -->
                    <label class="form-label small">Buscar por palabras</label>
                    <asp:TextBox ID="txtBusqueda" runat="server" CssClass="form-control mb-3" placeholder="Ingresar texto"></asp:TextBox>

                    <!-- Escoger condiciones -->
                    <label class="form-label small">Escoger condiciones</label>
                    <asp:DropDownList ID="ddlCondicion" runat="server" CssClass="form-select mb-3">
                        <asp:ListItem Text="Condición" Value="" />
                        <asp:ListItem Text="Nuevo" Value="Nuevo" />
                        <asp:ListItem Text="Usado" Value="Usado" />
                    </asp:DropDownList>


           

                    <!-- Escoger subcategoría -->
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

                    <!-- Botones -->
                    <asp:Button ID="btnBuscar" runat="server" Text="Buscar" CssClass="btn btn-primary w-100 mb-2" OnClick="btnBuscar_Click" />
                    
                </div>
            </div>

            <!-- 🔹 LISTADO DE PRODUCTOS -->
            <div class="col-md-9">
                <div class="d-flex justify-content-between align-items-center mb-3">
                    <h3 class="fw-bold mb-0">
                        INSTRUMENTOS <span id="lblCategoria" runat="server" class="text-primary fw-bold ms-2"></span>
                    </h3>
                    <div>
                        <asp:Button ID="btnCompra" runat="server" Text="Compra" CssClass="btn btn-outline-primary me-2"
                            OnClick="btnCompra_Click" />
                        <asp:Button ID="btnAlquiler" runat="server" Text="Alquiler" CssClass="btn btn-outline-secondary"
                            OnClick="btnAlquiler_Click" />
                    </div>
                </div>

                <hr />

                <asp:Repeater ID="rptInstrumentos" runat="server" OnItemCommand="rptInstrumentos_ItemCommand">
                    <ItemTemplate>
                         <div class="card shadow-sm border-0 p-3 text-center mx-2 mb-4" style="width: 18rem;">
                            <asp:Image ID="imgProducto" runat="server" ImageUrl='<%# Eval("ImagenUrl") %>' 
                                       CssClass="card-img-top img-fluid mb-3"
                                       style="max-width: 120px; height: 120px; object-fit: contain; margin: auto;" />
                            <div class="card-body p-0">
                                <asp:Label ID="lblNombre" runat="server" Text='<%# Eval("Nombre") %>' CssClass="fw-bold d-block" />
                                <asp:Label ID="lblDescripcion" runat="server" Text='<%# Eval("Descripcion") %>' CssClass="text-muted small d-block mb-2" />
                                <asp:Label ID="lblPrecio" runat="server" Text='<%# "S/ " + Eval("Precio", "{0:N2}") %>'  CssClass="text-primary fw-semibold d-block mb-3" />
                                <asp:Button ID="btnDetalle" runat="server" CssClass="btn btn-primary btn-sm" 
                                            Text="Ver Detalle" CommandName="VerDetalle" />
                            </div>
                        </div>
                    </ItemTemplate>
                </asp:Repeater>
            </div>
        </div>
    </div>

</asp:Content>