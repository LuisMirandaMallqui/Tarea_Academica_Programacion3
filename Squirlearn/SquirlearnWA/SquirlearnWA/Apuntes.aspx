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
            <h2 class="fw-bold mb-0">APUNTES DE CLASE</h2>
        </div>

        <hr />

        <div class="row">
            <!-- Panel lateral de filtros -->
            <div class="col-md-3">
                <div class="card shadow-sm p-3">
                    <h6 class="fw-bold mb-3">Realizar nueva búsqueda</h6>

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
                            <asp:ListItem Text="Guias de práctica" Value="guia"></asp:ListItem>
                            <asp:ListItem Text="otros" Value="otros"></asp:ListItem>
                        </asp:DropDownList>
                    </div>

     



                    <asp:Button ID="btnBuscar" runat="server" Text="Buscar" CssClass="btn btn-primary w-100 mb-2"
                        OnClick="btnBuscar_Click" />
                    
                </div>
            </div>

            <!-- Lista de apuntes -->
            <div class="col-md-9">
                <div class="d-flex flex-wrap justify-content-start">
                    <asp:Repeater ID="rptApuntes" runat="server" OnItemCommand="rptApuntes_ItemCommand">
                        <ItemTemplate>
                            <div class="card shadow-sm border-0 p-3 mx-2 mb-4" style="width: 20rem;">
                                <div class="d-flex align-items-center mb-3">
                                    <img src='<%# Eval("ImagenUrl") %>' alt="Apunte" class="img-fluid me-3"
                                         style="width:70px; height:70px; object-fit:contain;">
                                    <div>
                                        <h5 class="fw-bold mb-1"><%# Eval("Nombre") %></h5>
                                        <p class="text-muted small mb-0"><%# Eval("Descripcion") %></p>
                                    </div>
                                </div>

                                <div class="d-flex justify-content-between align-items-center mt-2">
                                    <span class="text-primary fw-semibold">S/ <%# Eval("Precio","{0:N2}") %></span>
                                    <asp:Button ID="btnDetalle" runat="server" CssClass="btn btn-primary btn-sm"
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