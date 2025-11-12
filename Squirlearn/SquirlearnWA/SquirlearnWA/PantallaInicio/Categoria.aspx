<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/SquirLearn.Master" AutoEventWireup="true" CodeBehind="Categoria.aspx.cs" Inherits="SquirlearnWA.PantallaInicio.Categoria" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphContenido" runat="server">

     <div class="container-fluid px-5 py-4">

     <!-- 🔙 Flecha de regreso -->
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

                 <label class="form-label small">Buscar por palabras</label>
                 <asp:TextBox ID="txtBusqueda" runat="server" CssClass="form-control mb-3"
                     placeholder="Ingresar texto"></asp:TextBox>

                 <label class="form-label small">Escoger condiciones</label>
                 <asp:DropDownList ID="ddlCondicion" runat="server" CssClass="form-select mb-3">
                     <asp:ListItem Text="Condición" Value="" />
                     <asp:ListItem Text="Nuevo" Value="Nuevo" />
                     <asp:ListItem Text="Usado" Value="Usado" />
                 </asp:DropDownList>

                 <!-- 🔹 Subcategorías dinámicas -->
                 <asp:Panel ID="pnlSubcategorias" runat="server">
                     <label class="form-label small">Escoger subcategoría</label>
                     <asp:DropDownList ID="ddlSubcategoria" runat="server" CssClass="form-select mb-3"></asp:DropDownList>
                 </asp:Panel>

                 <!-- 🔹 Filtros extra para "Otros" -->
                 <asp:Panel ID="pnlOtrosFiltros" runat="server" Visible="false">
                     <hr />
                     <h6 class="fw-bold mb-2">Filtros adicionales</h6>

                     <label class="form-label small">Tipo de publicación</label>
                     <asp:DropDownList ID="ddlTipoPublicacion" runat="server" CssClass="form-select mb-3">
                         <asp:ListItem Text="Seleccionar" Value="" />
                         <asp:ListItem Text="Aviso" Value="Aviso" />
                         <asp:ListItem Text="Evento" Value="Evento" />
                         <asp:ListItem Text="Servicio" Value="Servicio" />
                     </asp:DropDownList>

                     <label class="form-label small">Ubicación</label>
                     <asp:TextBox ID="txtUbicacion" runat="server" CssClass="form-control mb-3" placeholder="Ej. Lima, Cusco"></asp:TextBox>
                 </asp:Panel>

                 <asp:Button ID="btnBuscar" runat="server" Text="Buscar"
                     CssClass="btn btn-primary w-100 mb-2" OnClick="btnBuscar_Click" />
             </div>
         </div>

         <!-- 🔹 CONTENIDO PRINCIPAL -->
         <div class="col-md-9">
             <div class="d-flex justify-content-between align-items-center mb-4">
                 <h2 class="fw-bold mb-0">
                     <asp:Label ID="lblCategoria" runat="server" Text="CATEGORÍA"></asp:Label>
                    
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
                                  <h5 class="fw-bold"><%# Eval("Titulo") %></h5>
                                  <p class="text-muted small mb-2"><%# Eval("Subcategoria") %></p>
                                  <p class="text-primary fw-semibold mb-3">S/ <%# Eval("Precio","{0:N2}") %></p>
                                  <asp:Button ID="btnDetalle" runat="server"
                                      CssClass="btn btn-primary btn-sm"
                                      Text="Ver Detalle"
                                      CommandName="VerDetalle"
                                      CommandArgument='<%# Eval("Titulo") + "|" + Eval("Subcategoria") + "|" + Eval("Precio") + "|" + Eval("ImagenUrl") %>' />
                              </div>
                          </div>
                      </ItemTemplate>
                  </asp:Repeater>
                 </div>
         </div>

     </div>
 </div>






</asp:Content>
