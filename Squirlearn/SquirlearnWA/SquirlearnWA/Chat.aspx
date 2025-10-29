<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/SquirLearn.Master" AutoEventWireup="true" CodeBehind="Chat.aspx.cs" Inherits="SquirlearnWA.Chat" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphContenido" runat="server">

    <div class="container-fluid px-5 py-4">

        <!-- Botón volver -->
        <a href="Mensajes.aspx" class="text-decoration-none text-dark fw-semibold mb-3 d-inline-block">
            <i class="fa fa-arrow-left"></i> Volver
        </a>

        <!-- Cabecera del chat -->
        <div class="d-flex align-items-center justify-content-between bg-light p-3 rounded-3 mb-3 shadow-sm">
            <div class="d-flex align-items-center">
                <img src="../Imagenes/avatar.png" alt="Usuario" class="rounded-circle me-3" style="width:60px; height:60px;">
                <div>
                    <h5 class="fw-bold mb-0">Oscar Ibañez</h5>
                    <div class="text-warning small">
                        <i class="fa fa-star"></i><i class="fa fa-star"></i>
                        <i class="fa fa-star"></i><i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                    </div>
                </div>
            </div>
            <div class="text-muted small">
                <i class="fa fa-circle text-success"></i> En línea
            </div>
        </div>

        <!-- Contenedor principal del chat -->
        <div id="chatContainer" runat="server"
             style="height:400px; overflow-y:auto; background:#f8f9fa; border-radius:10px; padding:15px; box-shadow:inset 0 0 5px rgba(0,0,0,0.1);">

            <!-- Mensajes iniciales estáticos de ejemplo -->
            <div class="text-end mb-2">
                <div class="bg-primary text-white d-inline-block px-3 py-2 rounded-3 shadow-sm">
                    Ya estoy por FARES, ¿dónde andas?
                </div>
                <div class="small text-muted">10:46 p.m</div>
            </div>

            <div class="text-start mb-2">
                <div class="bg-light d-inline-block px-3 py-2 rounded-3 shadow-sm">
                    Claro, podemos quedar en la Facultad de Arquitectura el lunes.
                </div>
                <div class="small text-muted">10:47 p.m</div>
            </div>

        </div>

        <!-- Input de mensaje -->
        <div class="input-group mt-3">
            <asp:TextBox ID="txtMensaje" runat="server" CssClass="form-control" Placeholder="Escribe un mensaje..."></asp:TextBox>
            <asp:Button ID="btnEnviar" runat="server" Text="Enviar" CssClass="btn btn-primary" OnClick="btnEnviar_Click" />
        </div>

    </div>

</asp:Content>
