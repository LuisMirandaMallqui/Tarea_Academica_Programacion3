<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/SquirLearn.Master" AutoEventWireup="true" CodeBehind="Perfil.aspx.cs" Inherits="SquirlearnWA.Perfil" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphContenido" runat="server">


     <div class="container perfil-container mt-4">
        <!-- 🔙 Flecha para volver atrás -->
        <asp:LinkButton ID="btnVolver" runat="server" CssClass="btn btn-link text-dark mb-3 btn-flecha" OnClick="btnVolver_Click">
             <i class="fa fa-arrow-left"></i>
        </asp:LinkButton>
        <div class="row">
            <!-- Columna izquierda -->
            <div class="col-md-5 text-center">
                <h6 class="text-uppercase fw-bold mb-3">Mi Perfil</h6>
                <img src="../Imagenes/Avatar.png" alt="Avatar" class="rounded-circle mb-3" style="width:100px;height:100px;">
                
                <!-- Nombre dinámico -->
                <h6><asp:Label ID="lblNombreUsuario" runat="server" Text="Usuario"></asp:Label></h6>

                <!-- Botones -->
                <div class="d-grid gap-3 mt-4">
                    <a href="Pedidos.aspx" class="btn btn-outline-primary">Pedidos</a>
                    <a href="VentasAlquiler.aspx" class="btn btn-outline-primary">Ventas/Alquiler</a>
                </div>
            </div>

            <!-- Columna derecha -->
            <div class="col-md-6 offset-md-1">
                <h5 class="fw-bold mb-4">Configuración</h5>
                <ul class="list-unstyled">
                    <li class="mb-3"><a href="Notificaciones.aspx" class="text-decoration-none text-primary fw-semibold">Notificaciones</a></li>
                    
                    <li class="mb-4"><a href="ReestablecerContraseña.aspx" class="text-decoration-none text-primary fw-semibold">Reestablecer Contraseña</a></li>
                </ul>

                <a href="RegistrarIncidencia.aspx" class="text-decoration-none text-primary fw-semibold">
                    <i class="fa fa-exclamation-circle"></i> Registrar incidencia
                </a>
            </div>
        </div>
    </div>

  


</asp:Content>
