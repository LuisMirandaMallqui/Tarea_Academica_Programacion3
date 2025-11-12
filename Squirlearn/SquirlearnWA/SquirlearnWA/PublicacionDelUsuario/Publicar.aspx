<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/SquirLearn.Master" AutoEventWireup="true" CodeBehind="Publicar.aspx.cs" Inherits="SquirlearnWA.Publicar" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphContenido" runat="server">

    <div class="container py-4">
        <!-- Flecha de regreso -->
        <a href="../PublicacionDelUsuario/ListadoPublicaciones.aspx" class="text-decoration-none text-dark fw-semibold mb-3 d-inline-block">
            <i class="fa fa-arrow-left"></i> Volver
        </a>

        <h3 class="fw-bold mb-4">NUEVA PUBLICACIÓN</h3>

        <asp:DropDownList ID="ddlCategoria" runat="server" CssClass="form-select" AutoPostBack="true"
                OnSelectedIndexChanged="ddlCategoria_SelectedIndexChanged">
                <asp:ListItem Text="Seleccionar categoría" Value="" />
                <asp:ListItem Text="Libros" Value="Libro" />
                <asp:ListItem Text="Instrumentos" Value="Instrumento" />
                <asp:ListItem Text="Clase grabada" Value="Clases" />
                <asp:ListItem Text="Apuntes de clase" Value="Apuntes" />
                <asp:ListItem Text="Cursos" Value="Cursos" />
                <asp:ListItem Text="Otros" Value="otros" />
            </asp:DropDownList>

            <!-- Panel que aparece solo si se selecciona "Libro" -->
            <asp:Panel ID="panelGeneral" runat="server" Visible="false">

                <div class="mt-3">
                    <label>¿Qué titulo tendrá su publicación?</label>
                    <asp:TextBox ID="txtNombreLibro" runat="server" CssClass="form-control" placeholder="Nombre del producto" />
                </div>

                <div class="mt-3">
                    <label>Añade una descripción</label>
                    <asp:TextBox ID="txtDescripcionLibro" runat="server" TextMode="MultiLine" CssClass="form-control"
                        placeholder="Descripción del producto" />
                </div>

                <asp:Panel ID="panelAccion" runat="server" CssClass="mt-3">
                    <label>¿Qué deseas hacer?</label><br />
                    <asp:RadioButtonList ID="rblAccionLibro" runat="server" RepeatDirection="Horizontal" AutoPostBack="true"
                        OnSelectedIndexChanged="rblAccionLibro_SelectedIndexChanged">
                        <asp:ListItem Text="Alquilar" Value="Alquilar" />
                        <asp:ListItem Text="Vender" Value="Vender" />
                    </asp:RadioButtonList>
                </asp:Panel>

                <div class="mt-3">
                    <label>Establece un precio</label>
                    <asp:TextBox ID="txtPrecioLibro" runat="server" CssClass="form-control" placeholder="Precio por producto" />
                </div>

                <!-- Se muestra solo si elige “Alquilar” -->
                <asp:Panel ID="panelAlquiler" runat="server" Visible="false">
                    <div class="mt-3">
                        <label>Establece un periodo de alquiler (en días)</label>
                        <asp:TextBox ID="txtPeriodoLibro" runat="server" CssClass="form-control" placeholder="Tiempo de alquiler" />
                    </div>
                </asp:Panel>

                <asp:Panel ID="panelFormato" runat="server" CssClass="mt-3">
                    <label>¿Cuál es el formato del producto?</label>
                    <asp:DropDownList ID="ddlFormatoLibro" runat="server" CssClass="form-select">
                        <asp:ListItem Text="Seleccionar formato" Value="" />
                        <asp:ListItem Text="Físico" Value="Fisico" />
                        <asp:ListItem Text="Virtual" Value="Virtual" />
                    </asp:DropDownList>
                </asp:Panel>    

                <asp:Panel ID="panelEstado" runat="server" CssClass="mt-3">
                    <label>¿Cuál es el estado del producto?</label>
                    <asp:DropDownList ID="ddlEstadoLibro" runat="server" CssClass="form-select">
                        <asp:ListItem Text="Seleccionar estado" Value="" />
                        <asp:ListItem Text="Nuevo" Value="Nuevo" />
                        <asp:ListItem Text="Usado" Value="Usado" />
                    </asp:DropDownList>
                </asp:Panel>

                <asp:Panel ID="panelColorProducto" runat="server" CssClass="mt-3" Visible="false">
                            <label>¿Cuál es el color del producto</label>
                            <asp:TextBox ID="TextBox1" runat="server" TextMode="MultiLine" CssClass="form-control"
                                placeholder="Color del producto"></asp:TextBox>                  
                  </asp:Panel>

                <asp:Panel ID="panelTamanoProducto" runat="server" CssClass="mt-3" Visible="false">
                        <label>¿Cuál es el tamaño del producto?</label>
                        <asp:DropDownList ID="DropDownList1" runat="server" CssClass="form-select">
                            <asp:ListItem Text="Seleccionar tamaño" Value="" />
                            <asp:ListItem Text="Grande" Value="grande" />
                            <asp:ListItem Text="Mediano" Value="mediano" />
                            <asp:ListItem Text="pequeño" Value="pequeño" />
                        </asp:DropDownList>
                    </asp:Panel>


                  <!-- 🔹 Nuevo campo: Subcategoría -->
                   <!-- 🔹 Subcategoría dinámica -->
                        <div class="mt-3">
                            <label>Elija una subcategoría</label>
                            <asp:DropDownList ID="ddlSubcategoria" runat="server" CssClass="form-select">
                            </asp:DropDownList>
                        </div>

               <asp:Panel ID="panelFoto" runat="server" CssClass="mt-3">
                    <label>Añade fotos</label>
                    <asp:FileUpload ID="fuFotoLibro" runat="server" CssClass="form-control" />
                </asp:Panel>

                
                <div class="d-flex justify-content-end">
                     <asp:Button ID="btnGuardarBorrador_Click" runat="server" CssClass="btn btn-secondary me-2"
                     Text="Guardar borrador" OnClick="btnGuardarBorrador_Click_Click" />

                    <asp:Button ID="btnCancelar" runat="server" CssClass="btn btn-secondary me-2"
                                Text="Cancelar" OnClick="btnCancelar_Click" />
                    <asp:Button ID="btnEnviarPublicacion_Click" runat="server" CssClass="btn btn-primary"
                                Text="Enviar" OnClick="btnEnviarPublicacion_Click_Click" />
                </div>

            </asp:Panel>





        <!-- Modal de confirmación -->
        <div class="modal fade" id="modalConfirmacion" tabindex="-1" aria-labelledby="modalConfirmacionLabel" aria-hidden="true">
          <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
              <div class="modal-header border-0">
                <h5 class="modal-title fw-bold w-100 text-center" id="modalConfirmacionLabel">Publicación enviada</h5>
              </div>
              <div class="modal-body text-center">
                <p>Su publicación se ha enviado con éxito.<br />
                   Será revisada por los administradores<br />
                   lo más pronto posible.</p>
              </div>
              <div class="modal-footer border-0 d-flex justify-content-center">
                <asp:Button ID="btnContinuar" runat="server" CssClass="btn btn-primary fw-semibold px-4"
                    Text="CONTINUAR" OnClick="btnContinuar_Click" />
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
