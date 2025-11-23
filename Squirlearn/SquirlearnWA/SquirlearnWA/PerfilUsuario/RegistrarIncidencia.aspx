<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/SquirLearn.Master" AutoEventWireup="true" CodeBehind="RegistrarIncidencia.aspx.cs" Inherits="SquirlearnWA.RegistrarIncidencia" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphContenido" runat="server">


    <div class="container mt-5">
        <asp:LinkButton ID="btnVolver" runat="server" CssClass="btn btn-link text-dark mb-3 btn-flecha" OnClick="btnVolver_Click">
            <i class="fa fa-arrow-left"></i>Volver
        </asp:LinkButton>
        <!-- Título -->
        <h2 class="text-center fw-bold mb-4">REGISTRO DE INCIDENCIA</h2>

        <!-- Tipo de motivo -->
        <div class="mb-3">
            <asp:DropDownList ID="ddlTipoIncidencia" runat="server" CssClass="form-select"></asp:DropDownList>


            <!-- Texto y área de texto -->
            <div class="mb-3">
                <label for="txtIncidencia" class="form-label fw-semibold">Por favor, redacte su incidencia:</label>
                <asp:TextBox ID="txtIncidencia" runat="server" TextMode="MultiLine" Rows="5" CssClass="form-control"></asp:TextBox>
            </div>

            <!-- Botón Enviar -->
            <asp:Button ID="btnEnviar" runat="server" Text="ENVIAR" CssClass="btn btn-primary fw-semibold" OnClick="btnEnviar_Click" />

            <!-- Modal de confirmación -->
            <div class="modal fade" id="modalConfirmacion" tabindex="-1" aria-labelledby="modalConfirmacionLabel" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">
                        <div class="modal-header border-0">
                            <h5 class="modal-title fw-bold w-100 text-center" id="modalConfirmacionLabel">Incidencia enviada</h5>
                        </div>
                        <div class="modal-body text-center">
                            <p>
                                Su incidencia se ha enviado correctamente.<br />
                                Nos estaremos contactando con usted<br />
                                lo más pronto posible.
                            </p>
                        </div>
                        <div class="modal-footer border-0 d-flex justify-content-center">
                            <asp:Button ID="btnContinuar" runat="server" type="button" Text="CONTINUAR" CssClass="btn btn-primary fw-semibold" OnClick="btnContinuar_Click" />
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Script para mostrar el modal -->
        <script type="text/javascript">
            function mostrarModalConfirmacion() {
                var myModal = new bootstrap.Modal(document.getElementById('modalConfirmacion'));
                myModal.show();
            }
    </script>

        <!-- Modal: Motivo no seleccionado -->
        <div class="modal fade" id="modalErrorMotivo" tabindex="-1" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                    <div class="modal-header border-0">
                        <h5 class="modal-title w-100 text-center fw-bold text-danger">Advertencia</h5>
                    </div>
                    <div class="modal-body text-center">
                        <p>Debe seleccionar todos los campos antes de enviar una incidencia.</p>
                    </div>
                    <div class="modal-footer border-0 d-flex justify-content-center">
                        <button type="button" class="btn btn-secondary fw-semibold" data-bs-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>

        <script>
            function mostrarModalErrorMotivo() {
                var modal = new bootstrap.Modal(document.getElementById('modalErrorMotivo'));
                modal.show();
            }
</script>
</asp:Content>
