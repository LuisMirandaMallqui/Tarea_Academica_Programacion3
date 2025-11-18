<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/SquirLearn.Master" AutoEventWireup="true" CodeBehind="DetalleAlquiler.aspx.cs" Inherits="SquirlearnWA.DetalleAlquiler" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="container-fluid px-5 py-4">
        <div class="row g-4 align-items-start">

            <!-- Flecha de regreso -->
            <div class="col-12 mb-3">
                <a href="javascript:history.back()" class="text-decoration-none text-dark fw-semibold">
                    <i class="fa fa-arrow-left"></i> Volver
                </a>
            </div>

            <!-- DETALLE – ALQUILER -->
            <div class="col-md-8 border-end">
                <div class="px-4">
                    <h1 class="fw-bold text-secondary">DETALLE – ALQUILER</h1>

                    <div class="d-flex align-items-center mb-3">
                        <asp:Image ID="imgProducto" runat="server"
                                   Style="width:100px; height:100px; object-fit:contain; margin-right:15px;" />
                        <div>
                            <h5 class="fw-bold mb-1"><asp:Label ID="lblNombre" runat="server" /></h5>
                        </div>
                    </div>

                    <asp:Label ID="lblTipo" runat="server" CssClass="fw-semibold d-block" Text="Tipo: Alquiler"></asp:Label>
                    <asp:Label ID="lblPrecioDia" runat="server" CssClass="text-primary d-block mt-1" Text="Precio por día: S/ 0.00"></asp:Label>

                    <div class="mt-3">
                        <label class="fw-semibold d-block mb-2">Selecciona las fechas de alquiler:</label>
    
                        <div class="row g-2 align-items-center">
                            <div class="col-md-5">
                                <label for="txtFechaInicio" class="form-label small">Fecha de Inicio</label>
                                <asp:TextBox ID="txtFechaInicio" runat="server" 
                                    CssClass="form-control" 
                                    TextMode="Date" AutoPostBack="true" 
                                    OnTextChanged="txtFechas_TextChanged"></asp:TextBox>
                            </div>
        
                            <div class="col-md-5">
                                <label for="txtFechaFin" class="form-label small">Fecha de Fin</label>
                                <asp:TextBox ID="txtFechaFin" runat="server" 
                                    CssClass="form-control" 
                                    TextMode="Date" 
                                    AutoPostBack="true" 
                                    OnTextChanged="txtFechas_TextChanged"></asp:TextBox>
                            </div>
        
                            <div class="col-md-2 text-center">
                                <label class="form-label small d-block invisible">Días</label> 
                                <asp:Label ID="lblDiasCalculados" runat="server" 
                                    CssClass="fw-bold fs-5 text-primary" 
                                    Text="0"></asp:Label>
                                <small class="text-muted d-block">días</small>
                            </div>
                        </div>
    
                        <asp:Label ID="lblMensajeFechas" runat="server" CssClass="text-danger small mt-2 d-block"></asp:Label>

                        <p class="text-primary small mt-3">Tiempo de alquiler máximo: **14 días**.</p>
                        <p class="text-muted small mt-1">Entrega y devolución coordinadas directamente con el vendedor.</p>
                    </div>

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
                            <label class="form-check-label" for="chkAceptar">
                                Acepto 
                                <a href="#" data-bs-toggle="modal" data-bs-target="#modalTerminos"
                                   class="text-primary text-decoration-underline">
                                   los términos y condiciones
                                </a>
                            </label>
                        </div>
                        <asp:Label ID="lblErrorTerminos" runat="server" CssClass="text-danger small mt-1 d-block" Visible="false"
                            Text="Debe aceptar los términos y condiciones antes de continuar."></asp:Label>
                    </div>

                    <!-- Modal Términos y Condiciones -->
                    <div class="modal fade" id="modalTerminos" tabindex="-1" aria-labelledby="modalTerminosLabel" aria-hidden="true">
                        <div class="modal-dialog modal-dialog-centered">
                            <div class="modal-content shadow">
                                <div class="modal-header">
                                    <h5 class="modal-title fw-bold text-secondary" id="modalTerminosLabel">Términos y condiciones</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Cerrar"></button>
                                </div>
                                <div class="modal-body text-justify" style="white-space: pre-line;">
                                    Los términos y condiciones para alquilar material académico especifican el período de alquiler, 
                                    las tarifas y los depósitos requeridos. El arrendatario se compromete a devolver el material en 
                                    buen estado y a protegerlo durante el período de alquiler. Se prohíbe cualquier modificación sin 
                                    autorización previa y el uso del material para fines distintos a los académicos. El incumplimiento 
                                    de estas condiciones puede resultar en penalizaciones adicionales. El arrendatario acepta que el 
                                    material es propiedad del arrendador y se compromete a no infringir los derechos de autor. 
                                    Estos términos y condiciones constituyen un acuerdo legal vinculante entre ambas partes para 
                                    el alquiler del material académico.
                                </div>
                            </div>
                        </div>
                    </div>


                    <asp:Button ID="btnAlquilar" runat="server" CssClass="btn btn-primary w-100 mt-3"
                                Text="Realizar pago" OnClick="btnAlquilar_Click" />
                </div>
            </div>
        </div>
    </div>
</asp:Content>