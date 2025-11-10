<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/SquirLearn.Master" AutoEventWireup="true" CodeBehind="DetalleAlquiler.aspx.cs" Inherits="SquirlearnWA.Transaccion.DetalleAlquiler" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphContenido" runat="server">
    
     <!-- Flecha de regreso -->
     <asp:LinkButton ID="btnVolver" runat="server" CssClass="btn btn-link text-dark btn-flecha me-3" OnClick="btnVolver_Click">
         <i class="fa fa-arrow-left"></i>Volver
     </asp:LinkButton>
    
    <div class="container-fluid px-5 py-4">
        <div class="row g-4 align-items-start">

            <!-- 🧾 DETALLE DEL PRODUCTO -->
            <div class="col-md-8 border-end">
                <div class="px-4">
                    <h1 class="fw-bold text-secondary mb-4">DETALLE DEL PRODUCTO</h1>

                    <!-- 📸 Imagen + Info principal -->
                    <div class="row align-items-center mb-4">
                        <div class="col-md-5 text-center">
                            <asp:Image ID="imgProducto" runat="server"
                                Style="width:220px; height:220px; object-fit:contain; border-radius:10px;" />
                        </div>
                        <div class="col-md-7">
                            <h4 class="fw-bold mb-2">
                                <asp:Label ID="lblNombre" runat="server"/>
                            </h4>
                            <p class="mb-1 text-secondary small">
                                Vendedor: <span class="fw-semibold"><asp:Label ID="lblVendedor" runat="server" /></span>
                            </p>
                            <p class="text-muted mb-2"><asp:Label ID="lblDescripcion" runat="server" /></p>
                            <h5 class="fw-bold text-primary mt-3">S/ <asp:Label ID="lblPrecio" runat="server" /></h5>
                        </div>
                    </div>

                    <hr />

                    <!-- 🧩 Detalles técnicos -->
                    <h6 class="fw-semibold mb-3 text-secondary">Características del producto</h6>
                    <dl class="row small mb-4">
                        <dt class="col-5 text-muted">Categoría:</dt>
                        <dd class="col-7"><asp:Label ID="lblCategoria" runat="server" /></dd>

                        <dt class="col-5 text-muted">Subcategoría:</dt>
                        <dd class="col-7"><asp:Label ID="lblSubcategoria" runat="server" /></dd>

                        <dt class="col-5 text-muted">Color:</dt>
                        <dd class="col-7"><asp:Label ID="lblColor" runat="server" /></dd>

                        <dt class="col-5 text-muted">Estado:</dt>
                        <dd class="col-7"><asp:Label ID="lblEstado" runat="server" /></dd>

                        <dt class="col-5 text-muted">Condición:</dt>
                        <dd class="col-7"><asp:Label ID="lblCondicion" runat="server" /></dd>

                        <dt class="col-5 text-muted">Tamaño:</dt>
                        <dd class="col-7"><asp:Label ID="lblTamano" runat="server" /></dd>

                        <dt class="col-5 text-muted">Formato:</dt>
                        <dd class="col-7"><asp:Label ID="lblFormato" runat="server" /></dd>

                        <dt class="col-5 text-muted">Tipo:</dt>
                        <dd class="col-7"><asp:Label ID="lblTipo" runat="server" /></dd>
                    </dl>

                    <!-- 📅 Fechas (solo si es alquiler) -->
                    <asp:Panel ID="pnlFechas" runat="server" Visible="false">
                        <hr />
                        <h6 class="fw-semibold">Selecciona el periodo de alquiler</h6>
                        <div class="row g-2 mt-2">
                            <div class="col-md-6">
                                <label>Fecha de inicio</label>
                                <asp:TextBox ID="txtFechaInicio" runat="server" TextMode="Date" CssClass="form-control" />
                            </div>
                            <div class="col-md-6">
                                <label>Fecha de devolución</label>
                                <asp:TextBox ID="txtFechaFin" runat="server" TextMode="Date" CssClass="form-control" />
                            </div>
                        </div>
                        <p class="text-primary small mt-2">Máximo 14 días de alquiler.</p>
                    </asp:Panel>
                </div>
            </div>

            <!-- PAGO -->
            <div class="col-md-4">
                <div class="px-4">
                    <h6 class="fw-bold text-secondary">PAGO</h6>

                               <!-- Opción Tarjeta -->
                      <asp:RadioButton ID="rdbTarjeta" runat="server" 
                          GroupName="metodoPago" 
                          Text="Pagar con tarjeta de crédito/débito" 
                          Checked="true" 
                          CssClass="form-check-input" />
                    <div> </div> 

      

                      <!-- Opción Yape -->
                      <asp:RadioButton ID="rdbYape" runat="server" 
                          GroupName="metodoPago" 
                          Text="Pagar con Yape" 
                          CssClass="form-check-input mt-2" />

                    <hr />

                    <!-- Resumen -->
                    <div class="mt-4">
                        <h6 class="fw-bold">Resumen</h6>
                        <p class="mb-1">Subtotal: <span class="float-end">s/. <asp:Label ID="lblSubtotal" runat="server" Text="0.00"></asp:Label></span></p>
                        <hr />
                        <h5>Total: <span id="lblTotal" runat="server" class="float-end fw-bold text-primary">s/. 0.00</span></h5>
                    </div>

                    <!-- Aceptar términos y condiciones -->
                    <div class="mt-4"> 
                        <div class="form-check">
                            <asp:CheckBox ID="chkAceptar" runat="server" CssClass="form-check-input me-2" /> 
                            <label class="form-check-label" for="chkAceptar"> Acepto <a href="#" data-bs-toggle="modal" data-bs-target="#modalTerminos" class="text-primary text-decoration-underline"> los términos y condiciones </a> </label> 
                        </div> 
                         <asp:Label ID="lblErrorTerminos" runat="server" CssClass="text-danger small mt-1 d-block" Visible="false" Text="Debe aceptar los términos y condiciones antes de continuar."></asp:Label> 
                    </div> 
                    <!-- Modal Términos y Condiciones --> 
                    <div class="modal fade" id="modalTerminos" tabindex="-1" aria-labelledby="modalTerminosLabel" aria-hidden="true"> 
                        <div class="modal-dialog modal-dialog-centered">
                            <div class="modal-content shadow"> 
                                <div class="modal-header"> 
                                    <h5 class="modal-title fw-bold text-secondary" id="modalTerminosLabel">Términos y condiciones</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Cerrar"></button> 
                                </div> 
                                <div class="modal-body text-justify" style="white-space: pre-line;"> Los términos y condiciones para alquilar material académico especifican el período de alquiler,
                                    las tarifas y los depósitos requeridos. El arrendatario se compromete a devolver el material en buen estado y a protegerlo durante el 
                                    período de alquiler. Se prohíbe cualquier modificación sin autorización previa y el uso del material para fines distintos a los académicos.
                                    El incumplimiento de estas condiciones puede resultar en penalizaciones adicionales. El arrendatario acepta que el material es propiedad del arrendador y se compromete
                                    a no infringir los derechos de autor. Estos términos y condiciones constituyen un acuerdo legal vinculante entre ambas partes para el alquiler del material académico.
                                </div> 
                            </div> 
                        </div> 
                    </div>

                    <asp:Button ID="btnTransaccionar" runat="server" CssClass="btn btn-primary w-100 mt-3"
                                Text="Realizar pago" OnClick="btnTransaccionar_Click" />

        </div>
    </div>
</asp:Content>