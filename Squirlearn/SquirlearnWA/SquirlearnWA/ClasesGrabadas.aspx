<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/SquirLearn.Master" AutoEventWireup="true" CodeBehind="ClasesGrabadas.aspx.cs" Inherits="SquirlearnWA.ClasesGrabadas" %>
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
                CLASES GRABADAS <span id="lblCategoria" runat="server" class="text-primary fw-bold ms-2">(COMPRA)</span>
            </h2>
        </div>

        <hr />

        <div class="row">
            <!-- Panel lateral de filtros -->
            <div class="col-md-3">
                <div class="card shadow-sm p-3">
                    <h6 class="fw-bold mb-3">Buscar clases grabadas</h6>

                    <div class="mb-3">
                        <label class="form-label fw-semibold small">Buscar por palabras</label>
                        <asp:TextBox ID="txtBusqueda" runat="server" CssClass="form-control" Placeholder="Ingresar texto"></asp:TextBox>
                    </div>

        
                    <div class="mb-3">
                        <label class="form-label fw-semibold small">Seleccionar subcategoría</label>
                        <asp:DropDownList ID="ddlSubcategoria" runat="server" CssClass="form-select">
                            <asp:ListItem Text="Todas" Value=""></asp:ListItem>
                            <asp:ListItem Text="Estudios generales ciencias" Value="ciencias"></asp:ListItem>
                            <asp:ListItem Text="Estudios generales letras" Value="letras"></asp:ListItem>
                            <asp:ListItem Text="Facultad de ciencias e ingineria" Value="ingenieria"></asp:ListItem>
                            <asp:ListItem Text="Facultad de economia" Value="economia"></asp:ListItem>
                            <asp:ListItem Text="Facultad de derecho" Value="derecho"></asp:ListItem>
                            <asp:ListItem Text="Facultad psicologia" Value="psicologia"></asp:ListItem>
                            <asp:ListItem Text="Facultad gestión y alta dirección" Value="gestion"></asp:ListItem>
                            <asp:ListItem Text="Facultad educación" Value="educacion"></asp:ListItem>
                            <asp:ListItem Text="Facultad ciencias sociales" Value="sociales"></asp:ListItem>
                            <asp:ListItem Text="Facultad comunicación" Value="comunicacion"></asp:ListItem>
                            <asp:ListItem Text="Facultad artes" Value="artes"></asp:ListItem>
                            <asp:ListItem Text="Facultad arquitectura" Value="arquitectura"></asp:ListItem>

                        </asp:DropDownList>
                    </div>

                    <asp:Button ID="btnBuscar" runat="server" Text="Buscar" CssClass="btn btn-primary w-100 mb-2"
                        OnClick="btnBuscar_Click" />
                    
                </div>
            </div>

            <!-- Lista de clases -->
            <div class="col-md-9">
                <div class="d-flex flex-wrap justify-content-start">
                    <asp:Repeater ID="rptClases" runat="server" OnItemCommand="rptClases_ItemCommand">
                        <ItemTemplate>
                            <div class="card shadow-sm border-0 p-3 mx-2 mb-4" style="width: 20rem;">
                                <div class="d-flex align-items-center mb-3">
                                    <img src='<%# Eval("ImagenUrl") %>' alt="Clase Grabada"
                                         class="img-fluid me-3"
                                         style="width:80px; height:80px; object-fit:contain;">
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
