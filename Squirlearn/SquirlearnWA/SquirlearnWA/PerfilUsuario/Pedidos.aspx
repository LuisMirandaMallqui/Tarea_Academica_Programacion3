<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/SquirLearn.Master" AutoEventWireup="true" CodeBehind="Pedidos.aspx.cs" Inherits="SquirlearnWA.Pedidos" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphContenido" runat="server">

<div class="container mt-4">

    <!-- Encabezado -->
    <div class="d-flex justify-content-between align-items-center mb-3">
        <div>
            <asp:LinkButton ID="btnVolver" runat="server" CssClass="btn btn-link text-dark btn-flecha me-3" OnClick="btnVolver_Click3">
                <i class="fa fa-arrow-left"></i>Volver
            </asp:LinkButton>
            <span class="h3 fw-bold">PEDIDOS</span>
        </div>

        <div class="d-flex align-items-center mb-2">
                <asp:Label ID="lblCantidadResultados" runat="server" CssClass="fw-semibold"></asp:Label>
        </div>

             <!-- 🔹 Paginador -->
       <div class="d-flex justify-content-center mt-3">
           <asp:PlaceHolder ID="phPaginacion" runat="server">
               <div class="d-flex gap-3">
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
        <!-- Dropdown de categoría -->
                   <div class="dropdown">
                <button class="btn btn-light dropdown-toggle border border-secondary-subtle px-3 py-2"
                        type="button" id="dropdownCategoria" data-bs-toggle="dropdown" aria-expanded="false">
                    Categoría
                </button>

                <ul class="dropdown-menu dropdown-menu-end p-2" aria-labelledby="dropdownCategoria">
                    <li>
                        <div class="form-check d-flex align-items-center">
                            <asp:CheckBox ID="chkCompra" runat="server" CssClass="form-check-input me-2"
                                AutoPostBack="true" OnCheckedChanged="btnFiltrarCompra_Click" Checked="true" />
                            <label class="form-check-label w-100 d-flex justify-content-between align-items-center" for="chkCompra">
                                <span>Compra</span>
                                <i class="fa fa-shopping-cart"></i>
                            </label>
                        </div>
                    </li>
                    <hr class="my-2" />
                    <li>
                        <div class="form-check d-flex align-items-center">
                            <asp:CheckBox ID="chkAlquiler" runat="server" CssClass="form-check-input me-2"
                                AutoPostBack="true" OnCheckedChanged="btnFiltrarAlquiler_Click" />
                            <label class="form-check-label w-100 d-flex justify-content-between align-items-center" for="chkAlquiler">
                                <span>Alquiler</span>
                                <i class="fa fa-hourglass-half"></i>
                            </label>
                        </div>
                    </li>
                </ul>
            </div>
        </div>


     <div class="notificaciones-container">
            <asp:Repeater ID="rptPedidos" runat="server">
                <ItemTemplate>
                    <div class="card mb-3 shadow-sm border-0 bg-light-subtle p-3">
                        <div class="d-flex justify-content-between small text-muted">
                            <span><%# Eval("TipoPedido") %>: <%# Eval("Pedido.fechaCompra") %></span>
                            
                        </div>
                        <div class="fw-bold fs-5 mt-2"><%# Eval("Publicacion.item.nombre") %></div>

                        <div class="d-flex justify-content-between mt-2">
                                 <div>
                                     <div class="text-secondary small mb-1"><%# Eval("Publicacion.item.categoria.nombre") %></div>
                                      <div class="text-secondary small mb-1"><%# Eval("Publicacion.item.subcategoria.nombre") %></div>
                                   <h4 class="text-secondary small mb-1">
                                            <%# Eval("TipoPedido").ToString() == "Alquilado" ? "Cantidad días alquilado: " + Eval("Pedido.dias") : "" %>
                                        </h4>

                                 </div>
                                 <div class="text-end">
                                     <span class="fw-semibold">S/. <%# Eval("Pedido.totalCompra") %></span>
                                 </div>
                             </div>

                        <div class="text-end mt-2">
                            <asp:Button ID="btnReseña" runat="server" CssClass="btn btn-primary btn-sm px-4"
                                        Text="Reseñas" OnClick="btnReseña_Click" />
                        </div>
                    </div>

                </ItemTemplate>
            </asp:Repeater>
        </div>
</div>
</asp:Content>
