<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/SquirLearn.Master" AutoEventWireup="true" CodeBehind="Mensajes.aspx.cs" Inherits="SquirlearnWA.Mensajes" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="container-fluid px-5 py-4">

        <!-- Título -->
        <h2 class="fw-bold mb-4">BANDEJA DE ENTRADA</h2>

        <!-- Filtros de mensajes -->
        <div class="mb-3">
            <button class="btn btn-secondary btn-sm me-2">Todos</button>
            <button class="btn btn-outline-secondary btn-sm">No leídos</button>
        </div>

        <!-- Lista de chats (estática por ahora) -->
        <div class="list-group">
            <a href="Chat.aspx" class="list-group-item list-group-item-action d-flex justify-content-between align-items-center">
                <div class="d-flex align-items-center">
                    <img src="../Imagenes/avatar.png" alt="Usuario" class="me-3 rounded-circle" style="width:50px; height:50px;">
                    <div>
                        <h6 class="mb-0 fw-semibold">Oscar Ibañez</h6>
                        <small class="text-muted">Hola, ¿confirmamos la entrega el lunes?</small>
                    </div>
                </div>
                <div class="text-end">
                    <span class="badge bg-primary rounded-pill mb-1">2</span>
                    <br />
                    <small class="text-muted">10:45 p.m<br />02/10/25</small>
                </div>
            </a>

            <a href="Chat.aspx" class="list-group-item list-group-item-action d-flex justify-content-between align-items-center">
                <div class="d-flex align-items-center">
                    <img src="../Imagenes/avatar.png" alt="Usuario" class="me-3 rounded-circle" style="width:50px; height:50px;">
                    <div>
                        <h6 class="mb-0 fw-semibold">Sara Pizarro</h6>
                        <small class="text-muted">Te mandé el archivo del material.</small>
                    </div>
                </div>
                <div class="text-end">
                    <span class="badge bg-primary rounded-pill mb-1">1</span>
                    <br />
                    <small class="text-muted">2:00 p.m<br />02/10/24</small>
                </div>
            </a>

            <a href="Chat.aspx" class="list-group-item list-group-item-action d-flex justify-content-between align-items-center">
                <div class="d-flex align-items-center">
                    <img src="../Imagenes/avatar.png" alt="Usuario" class="me-3 rounded-circle" style="width:50px; height:50px;">
                    <div>
                        <h6 class="mb-0 fw-semibold">Estefanya Gómez</h6>
                        <small class="text-muted">Confirmado, nos vemos en el FARES.</small>
                    </div>
                </div>
                <div class="text-end">
                    <span class="badge bg-primary rounded-pill mb-1">1</span>
                    <br />
                    <small class="text-muted">10:45 p.m<br />02/09/24</small>
                </div>
            </a>
        </div>
    </div>
</asp:Content>