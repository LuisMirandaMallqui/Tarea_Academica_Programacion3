<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/SquirLearn.Master" AutoEventWireup="true" CodeBehind="Busqueda.aspx.cs" Inherits="SquirlearnWA.PantallaInicio.Busqueda" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphContenido" runat="server">

     <div class="container-fluid px-5 py-4">

     <!-- 🔙 Flecha de regreso -->
     <div class="mb-3">
         <a href="SquirLearnInicio.aspx" class="text-decoration-none text-dark fw-semibold">
             <i class="fa fa-arrow-left"></i> Volver
         </a>
     </div>

         <!-- Búsqueda -->
         <div class="d-flex mb-3">
             <asp:TextBox ID="txtBuscar" runat="server" CssClass="form-control me-2" placeholder="Buscar productos..." />
             <asp:Button ID="btnBuscar" runat="server" CssClass="btn btn-outline-primary" Text="Buscar" OnClick="btnBuscar_Click" />
         </div>

     <div class="row">

         <!-- 🧩 Filtros -->
         <div class="col-md-3 col-lg-2 border-end">
             <h5 class="fw-bold mb-3">Filtros</h5>

             <div class="accordion" id="accordionFiltros">
                 <!-- VEnta/Alquiler -->
                 <div class="accordion-item">
                     <h2 class="accordion-header" id="headingEntrega">
                         <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseEntrega" aria-expanded="true" aria-controls="collapseEntrega">
                             Venta / Alquiler</button>
                     </h2>
                     <div id="collapseEntrega" class="accordion-collapse collapse show" aria-labelledby="headingEntrega" data-bs-parent="#accordionFiltros">
                         <div class="accordion-body">
                             <div class="form-check mb-2">
                                 <asp:RadioButton ID="rbVenta" GroupName="Entrega" runat="server" CssClass="form-check-input" />
                                 <label class="form-check-label">Venta</label>
                             </div>
                             <div class="form-check">
                                 <asp:RadioButton ID="rbAlquiler" GroupName="Entrega" runat="server" CssClass="form-check-input" />
                                 <label class="form-check-label">Alquiler</label>
                             </div>
                         </div>
                     </div>
                 </div>


                 <!-- Categoría -->

                 <div class="accordion-item">
                    <div id="collapseCategoria" class="accordion-collapse collapse" aria-labelledby="headingCategoria" data-bs-parent="#accordionFiltros">
                        <div class="accordion-body">
                            <asp:DropDownList 
                                ID="ddlCategoria" 
                                runat="server" 
                                CssClass="form-select mb-2" 
                                AppendDataBoundItems="true"
                                AutoPostBack="true" 
                                OnSelectedIndexChanged="ddlCategoria_SelectedIndexChanged">
                            </asp:DropDownList>
                        </div>
                    </div>
                </div>

                 <!-- Subcategoría -->
                 <div class="accordion-item">
                     <h2 class="accordion-header" id="headingSubcatgoria">
                         <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseSubcategoria" aria-expanded="false" aria-controls="collapseSubcategoria">
                             Subcategoría</button>
                     </h2>
                     <div id="collapseSubcategoria" class="accordion-collapse collapse" aria-labelledby="headingSubcategoria" data-bs-parent="#accordionFiltros">
                         <div class="accordion-body">
                             <asp:DropDownList ID="ddlSubcategoria" runat="server" CssClass="form-select mb-2" AppendDataBoundItems="true">
                             </asp:DropDownList>
                         </div>
                     </div>
                 </div>

                 <!-- Condicion -->
                 <div class="accordion-item">
                     <h2 class="accordion-header" id="headingCondicion">
                         <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseCondicion" aria-expanded="false" aria-controls="collapseCondicion">
                             Condicion</button>
                     </h2>
                     <div id="collapseCondicion" class="accordion-collapse collapse" aria-labelledby="headingCondicion" data-bs-parent="#accordionFiltros">
                         <div class="accordion-body">
                             <asp:RadioButtonList ID="rblCondicion" runat="server" CssClass="form-check">
                             </asp:RadioButtonList>
                         </div>
                     </div>
                 </div>

                 <!-- Formato -->
                 <div class="accordion-item">
                     <h2 class="accordion-header" id="headingFormato">
                         <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseFormato" aria-expanded="false" aria-controls="collapseFormato">
                             Formato</button>
                     </h2>
                     <div id="collapseFormato" class="accordion-collapse collapse" aria-labelledby="headingFormato" data-bs-parent="#accordionFiltros">
                         <div class="accordion-body">
                             <asp:RadioButtonList ID="rblFormato" runat="server" CssClass="form-check">
                             </asp:RadioButtonList>
                         </div>
                     </div>
                 </div>

                 <!-- Tamaño -->
                 <div class="accordion-item">
                     <h2 class="accordion-header" id="headingTamano">
                         <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTamano" aria-expanded="false" aria-controls="collapseTamano">
                             Tamaño</button>
                     </h2>
                     <div id="collapseTamano" class="accordion-collapse collapse" aria-labelledby="headingTamano" data-bs-parent="#accordionFiltros">
                         <div class="accordion-body">
                             <asp:RadioButtonList ID="rblTamano" runat="server" CssClass="form-check">
                             </asp:RadioButtonList>
                         </div>
                     </div>
                 </div>

                 <!-- Color -->
                 <div class="accordion-item">
                     <h2 class="accordion-header" id="headingColor">
                         <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseColor" aria-expanded="false" aria-controls="collapseColor">
                             Subcategoría</button>
                     </h2>
                     <div id="collapseColor" class="accordion-collapse collapse" aria-labelledby="headingColor" data-bs-parent="#accordionFiltros">
                         <div class="accordion-body">
                             <asp:DropDownList ID="ddlColor" runat="server" CssClass="form-select mb-2" AppendDataBoundItems="true">
                             </asp:DropDownList>
                         </div>
                     </div>
                 </div>
             </div>

             <!-- 🔘 Botones de acción -->
             <div class="d-grid gap-2 mt-3">
                 <asp:Button ID="btnFiltrar" runat="server" CssClass="btn btn-primary fw-semibold" Text="Aplicar filtros" OnClick="btnFiltrar_Click" />
                 <asp:Button ID="btnLimpiar" runat="server" CssClass="btn btn-outline-secondary fw-semibold" Text="Borrar filtros" OnClick="btnLimpiar_Click" />
             </div>

         </div>

         <!-- 🔹 CONTENIDO PRINCIPAL -->
         <div class="col-md-9">
             <div class="d-flex justify-content-between align-items-center mb-4">
                 <h2 class="fw-bold mb-0">
                     <asp:Label ID="lblCategoria" runat="server" Text="CATEGORÍA"></asp:Label>

                 </h2>
             </div>
             <hr />

             <!-- 📦 Cards de productos -->
             <div class="row row-cols-1 row-cols-md-3 row-cols-lg-4 g-4">
                 <asp:Repeater ID="rptProductos" runat="server">
                     <ItemTemplate>
                         <div class="col">
                             <div class="card h-100 shadow-sm border-0">
                                 <img src="https://via.placeholder.com/250" class="card-img-top rounded" alt='<%# Eval("nombre") %>' />
                                 <div class="card-body">
                                     <!-- Nombre -->
                                     <h6 class="fw-semibold mb-1"><%# Eval("nombre") %></h6>

                                     <!-- Precio -->
                                     <h5 class="fw-bold text-danger mb-1">S/ <%# String.Format("{0:N2}", Eval("precio")) %></h5>

                                     <!-- Tipo (Venta o Alquiler) -->
                                     <p class="text-muted small mb-2"><%# (bool)Eval("esVenta") ? "En venta" : "En alquiler" %> </p>

                                     <!-- Botón para solicitar -->
                                     <asp:LinkButton
                                         ID="btnSolicitar"
                                         runat="server"
                                         CssClass="btn btn-primary w-100 fw-semibold"
                                         Text="Solicitar"
                                         CommandName="Solicitar"
                                         CommandArgument='<%# Eval("publicacionId") + "|" + Eval("esVenta") + "|" + Eval("nombre") +  "|" + Eval("itemId") + "|" + Eval("precio") + "|" + Eval("personaId)#%>'/>
                                 </div>
                             </div>
                         </div>
                     </ItemTemplate>
                 </asp:Repeater>
             </div>

             <div class="col-md-9">
                
                <asp:UpdatePanel ID="upResultados" runat="server" UpdateMode="Conditional">
                    <ContentTemplate>
                        <div class="d-flex justify-content-between align-items-center mb-4">
                            <h2 class="fw-bold mb-0">
                                <asp:Label ID="Label1" runat="server" Text="CATEGORÍA"></asp:Label>
                            </h2>
                        </div>
                        <hr />

                        <div class="row row-cols-1 row-cols-md-3 row-cols-lg-4 g-4">
                            
                            <asp:Repeater ID="Repeater1" runat="server" OnItemCommand="rptProductos_ItemCommand">
                                <ItemTemplate>
                                    <div class="col">
                                        <div class="card h-100 shadow-sm border-0">
                                            <asp:LinkButton
                                                ID="btnSolicitar"
                                                runat="server"
                                                CssClass="btn btn-primary w-100 fw-semibold"
                                                Text="Solicitar"
                                                CommandName="Solicitar"
                                                
                                                CommandArgument='<%# Eval("publicacionId") + "|" + Eval("esVenta") + "|" + Eval("nombre") +  "|" + Eval("itemId") + "|" + Eval("precio") + "|" + Eval("personaId") %>' />
                                        </div>
                                    </div>
                                </ItemTemplate>
                            </asp:Repeater>
                        </div>
                        
                        <div class="d-flex justify-content-center mt-4">
                            <asp:PlaceHolder ID="phPaginacion" runat="server"></asp:PlaceHolder>
                        </div>

                    </ContentTemplate>
                    <Triggers>
                        <asp:AsyncPostBackTrigger ControlID="btnBuscar" EventName="Click" />
                        <asp:AsyncPostBackTrigger ControlID="btnFiltrar" EventName="Click" />
                        <asp:AsyncPostBackTrigger ControlID="btnLimpiar" EventName="Click" />
                    </Triggers>
                </asp:UpdatePanel>
            </div>


         </div>
     </div>
     </div>
</asp:Content>
