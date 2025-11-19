<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/SquirLearn.Master" AutoEventWireup="true" CodeBehind="Pedidos.aspx.cs" Inherits="SquirlearnWA.Pedidos" %>


<asp:Content ID="Content1" ContentPlaceHolderID="cphContenido" runat="server">
    
    <!-- Importante para los UpdatePanel si usaras -->
    <asp:ScriptManager ID="ScriptManager1" runat="server"></asp:ScriptManager>

    <div class="container mt-4">

        <!-- Encabezado -->
        <div class="d-flex justify-content-between align-items-center mb-3">
            <div>
                <asp:LinkButton ID="btnVolver" runat="server" CssClass="btn btn-link text-dark btn-flecha me-3" OnClick="btnVolver_Click3">
                    <i class="fa fa-arrow-left"></i>Volver
                </asp:LinkButton>
                <span class="h3 fw-bold">MIS PEDIDOS</span>
            </div>

            <div class="d-flex align-items-center mb-2">
                <asp:Label ID="lblCantidadResultados" runat="server" CssClass="fw-semibold text-muted"></asp:Label>
            </div>
        </div>

        <div class="row">
            <!-- 🔹 Columna Izquierda: Filtros -->
            <div class="col-md-3 mb-4">
                <div class="card border-0 shadow-sm p-3">
                    <h6 class="fw-bold mb-3">Filtrar por Categoría</h6>
                    
                    <div class="form-check d-flex align-items-center mb-2">
                        <asp:CheckBox ID="chkCompra" runat="server" CssClass="form-check-input me-2"
                            AutoPostBack="true" OnCheckedChanged="btnFiltrarCompra_Click" Checked="true" />
                        <label class="form-check-label w-100 d-flex justify-content-between" for="<%= chkCompra.ClientID %>">
                            <span>Compras</span> <i class="fa fa-shopping-bag text-secondary"></i>
                        </label>
                    </div>

                    <div class="form-check d-flex align-items-center">
                        <asp:CheckBox ID="chkAlquiler" runat="server" CssClass="form-check-input me-2"
                            AutoPostBack="true" OnCheckedChanged="btnFiltrarAlquiler_Click" />
                        <label class="form-check-label w-100 d-flex justify-content-between" for="<%= chkAlquiler.ClientID %>">
                            <span>Alquileres</span> <i class="fa fa-clock-o text-secondary"></i>
                        </label>
                    </div>
                </div>
            </div>

            <!-- 🔹 Columna Derecha: Listado -->
            <div class="col-md-9">
                <div class="notificaciones-container">
                    <asp:Repeater ID="rptPedidos" runat="server">
                        <ItemTemplate>
                            <div class="card mb-3 shadow-sm border-0 bg-white p-4">
                                
                                <!-- Cabecera de la Tarjeta -->
                                <div class="d-flex justify-content-between small text-muted mb-2">
                                    <span>
                                        <i class="fa fa-calendar me-1"></i> <%# Eval("fechaEmision") %>
                                    </span>
                                    <span class="fw-bold text-primary"><%# Eval("transaccion") %></span>
                                </div>

                                <!-- Cuerpo Principal -->
                                <div class="row align-items-center">
                                    <div class="col-md-8">
                                        <div class="fw-bold fs-5 text-dark"><%# Eval("descripcion") %></div>
                                        <div class="mt-2">
                                            <span class="badge rounded-pill bg-light text-dark border">
                                                <%# (bool)Eval("esVenta") ? "COMPRA" : "ALQUILER" %>
                                            </span>
                                        </div>
                                    </div>

                                    <div class="col-md-4 text-end mt-3 mt-md-0">
                                        <div class="fs-4 fw-bold text-success">
                                            S/ <%# Eval("monto", "{0:N2}") %>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </ItemTemplate>
                    </asp:Repeater>
                </div>

                <!-- 🔹 Paginador -->
                <div class="d-flex justify-content-center mt-4">
                    <asp:PlaceHolder ID="phPaginacion" runat="server">
                        <div class="btn-group shadow-sm">
                            <asp:Button ID="btnAnterior" runat="server"
                                CssClass="btn btn-light border"
                                Text="← Anterior"
                                OnClick="btnAnterior_Click" />

                            <asp:Button ID="btnSiguiente" runat="server"
                                CssClass="btn btn-light border"
                                Text="Siguiente →"
                                OnClick="btnSiguiente_Click" />
                        </div>
                    </asp:PlaceHolder>
                </div>

            </div>
        </div>
    </div>

</asp:Content>
