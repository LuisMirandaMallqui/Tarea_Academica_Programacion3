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

            <!-- VENDEDOR -->
            <div class="col-md-3 text-center border-end">
                <img src="../Imagenes/avatar.png"
                     alt="Vendedor" style="width:120px; height:120px; border-radius:50%;">
                <h5 class="fw-semibold mt-3"><asp:Label ID="lblVendedor" runat="server" /></h5>
                <div class="text-warning mb-2">
                    <i class="fa fa-star"></i><i class="fa fa-star"></i>
                    <i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i>
                </div>
                <p class="text-muted small mt-2">Excelente reputación y tiempo de respuesta rápido</p>
            </div>

            <!-- DETALLE – ALQUILER -->
            <div class="col-md-5 border-end">
                <div class="px-4">
                    <h1 class="fw-bold text-secondary">DETALLE – ALQUILER</h1>

                    <div class="d-flex align-items-center mb-3">
                        <asp:Image ID="imgProducto" runat="server"
                                   Style="width:100px; height:100px; object-fit:contain; margin-right:15px;" />
                        <div>
                            <h5 class="fw-bold mb-1"><asp:Label ID="lblNombre" runat="server" /></h5>
                            <p class="text-muted small mb-0"><asp:Label ID="lblDescripcion" runat="server" /></p>
                        </div>
                    </div>

                    <asp:Label ID="lblTipo" runat="server" CssClass="fw-semibold d-block" Text="Tipo: Alquiler"></asp:Label>
                    <asp:Label ID="lblPrecioDia" runat="server" CssClass="text-primary d-block mt-1" Text="Precio por día: S/ 0.00"></asp:Label>
                    <asp:Label ID="lblPeriodo" runat="server" CssClass="text-muted small d-block mb-3" Text="Periodo máximo: 0 días"></asp:Label>

                    <div class="mt-3">
                        <label class="fw-semibold">Tiempo de alquiler (días):</label>
                        <div class="d-flex align-items-center mt-1">
                            <asp:Button ID="btnRestar" runat="server" Text="-" CssClass="btn btn-outline-secondary btn-sm px-2" OnClick="btnRestar_Click" />
                            <asp:Label ID="lblDias" runat="server" CssClass="px-3 fw-semibold" Text="1"></asp:Label>
                            <asp:Button ID="btnSumar" runat="server" Text="+" CssClass="btn btn-outline-secondary btn-sm px-2" OnClick="btnSumar_Click" />
                        </div>
                        <p class="text-primary small mt-2">Tiempo de alquiler máximo de 2 semanas</p>
                        <p class="text-muted small mt-3">Entrega y devolución coordinadas directamente con el vendedor.</p>
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

                    <!-- Código promocional -->
                    <div class="mt-4">
                        <label class="fw-semibold">Código promocional:</label>
                        <div class="input-group">
                            <asp:TextBox ID="txtCodigoPromo" runat="server" CssClass="form-control" Placeholder="Ingresa tu código aquí"></asp:TextBox>
                            <asp:Button ID="btnAplicarCodigo" runat="server" Text="Aplicar" CssClass="btn btn-outline-primary" OnClick="btnAplicarCodigo_Click" />
                        </div>
                    </div>

                    <!-- Resumen -->
                    <div class="mt-4">
                        <h6 class="fw-bold">Resumen</h6>
                        <p class="mb-1">Subtotal: <span class="float-end">s/. <asp:Label ID="lblSubtotal" runat="server" Text="0.00"></asp:Label></span></p>
                        <p class="mb-1">Ahorro: <span class="float-end">- s/. 1.50</span></p>
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