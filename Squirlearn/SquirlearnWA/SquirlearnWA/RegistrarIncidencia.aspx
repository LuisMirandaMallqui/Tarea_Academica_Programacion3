<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/SquirLearn.Master" AutoEventWireup="true" CodeBehind="RegistrarIncidencia.aspx.cs" Inherits="SquirlearnWA.RegistrarIncidencia" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphContenido" runat="server">


    <div class="container mt-5">
        <!-- Título -->
        <h2 class="text-center fw-bold mb-4">REGISTRO DE INCIDENCIA</h2>

        <!-- Texto y área de texto -->
        <div class="mb-3">
            <label for="txtIncidencia" class="form-label fw-semibold">Por favor, redacte su incidencia:</label>
            <asp:TextBox ID="txtIncidencia" runat="server" TextMode="MultiLine" Rows="5" CssClass="form-control" ></asp:TextBox>
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
                        <p>Su incidencia se ha enviado correctamente.<br />
                           Nos estaremos contactando con usted<br />
                           lo más pronto posible.</p>
                    </div>
                    <div class="modal-footer border-0 d-flex justify-content-center">
                        <asp:Button ID="btnContinuar" runat="server" type="button"  Text="CONTINUAR" CssClass="btn btn-primary fw-semibold" Onclick="btnContinuar_Click" />
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




</asp:Content>
