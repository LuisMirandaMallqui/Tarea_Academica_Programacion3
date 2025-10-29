<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/SquirLearn.Master" AutoEventWireup="true" CodeBehind="Promociones.aspx.cs" Inherits="SquirlearnWA.Promociones" %>
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
            <h2 class="fw-bold mb-0">PROMOCIONES ESPECIALES 🎉</h2>
        </div>

        <p class="text-muted mb-4">
            Encuentra descuentos exclusivos en libros, instrumentos, apuntes y más.  
            ¡Aprovecha las ofertas por tiempo limitado!
        </p>

        <hr />

        <!-- Panel lateral de filtros -->
        <div class="row">
            <div class="col-md-3">
                <div class="card shadow-sm p-3">
                    <h6 class="fw-bold mb-3">Filtrar promociones</h6>

                    <div class="mb-3">
                        <label class="form-label fw-semibold small">Buscar por nombre</label>
                        <asp:TextBox ID="txtBusqueda" runat="server" CssClass="form-control" Placeholder="Ej: Física, Cálculo..."></asp:TextBox>
                    </div>

                    <div class="mb-3">
                        <label class="form-label fw-semibold small">Filtrar por tipo</label>
                        <asp:DropDownList ID="ddlTipo" runat="server" CssClass="form-select">
                            <asp:ListItem Text="Todos" Value=""></asp:ListItem>
                            <asp:ListItem Text="Libros" Value="Libro"></asp:ListItem>
                            <asp:ListItem Text="Instrumentos" Value="Instrumento"></asp:ListItem>
                            <asp:ListItem Text="Clases Grabadas" Value="Clase"></asp:ListItem>
                            <asp:ListItem Text="Apuntes" Value="Apunte"></asp:ListItem>
                        </asp:DropDownList>
                    </div>

                    <asp:Button ID="btnBuscar" runat="server" Text="Buscar" CssClass="btn btn-primary w-100 mb-2"
                        OnClick="btnBuscar_Click" />
                    <asp:Button ID="btnInicio" runat="server" Text="Regresar al inicio" CssClass="btn btn-outline-secondary w-100"
                        OnClick="btnInicio_Click" />
                </div>
            </div>

            <!-- Listado de promociones -->
            <div class="col-md-9">
                <div class="d-flex flex-wrap justify-content-start">
                    <asp:Repeater ID="rptPromociones" runat="server" OnItemCommand="rptPromociones_ItemCommand">
                        <ItemTemplate>
                            <div class="card shadow-sm border-0 p-3 mx-2 mb-4" style="width: 20rem; position: relative;">
                                
                                <!-- Etiqueta de descuento -->
                                <div style="position: absolute; top:10px; right:10px; background:#ff4757; color:white; font-size:0.9em; padding:2px 8px; border-radius:5px;">
                                    - <%# Eval("Descuento") %>%
                                </div>

                                <img src='<%# Eval("ImagenUrl") %>' alt="Promoción" class="img-fluid mb-3"
                                     style="width:100%; height:160px; object-fit:contain;">
                                <div class="card-body p-0">
                                    <h5 class="fw-bold mb-1"><%# Eval("Nombre") %></h5>
                                    <p class="text-muted small mb-1"><%# Eval("Descripcion") %></p>
                                    <p class="text-primary fw-bold mb-0">Ahora: s/. <%# Eval("PrecioFinal") %></p>
                                    <p class="text-muted small text-decoration-line-through mb-2">Antes: s/. <%# Eval("PrecioOriginal") %></p>
                                    <asp:Button ID="btnDetalle" runat="server" CssClass="btn btn-outline-primary btn-sm w-100"
                                                Text="Ver Detalle" CommandName="VerDetalle"
                                                CommandArgument='<%# Eval("Nombre") + "|" + Eval("Descripcion") + "|" + Eval("PrecioFinal") + "|" + Eval("ImagenUrl") + "|" + Eval("Tipo") %>' />
                                </div>
                            </div>
                        </ItemTemplate>
                    </asp:Repeater>
                </div>
            </div>
        </div>
    </div>
</asp:Content>
