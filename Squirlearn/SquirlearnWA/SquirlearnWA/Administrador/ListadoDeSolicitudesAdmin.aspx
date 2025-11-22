<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/SquirLearn.Master" AutoEventWireup="true" CodeBehind="ListadoDeSolicitudesAdmin.aspx.cs" Inherits="SquirlearnWA.Administrador.ListadoDeSolicitudesAdmin" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphContenido" runat="server">
    <asp:ScriptManager ID="ScriptManager1" runat="server"></asp:ScriptManager>

    <div class="container py-4 mt-1"">
        <h2 class="fw-bold mb-4">Gestión de Publicaciones (Admin)</h2>

        <asp:UpdatePanel ID="upPanelPublicaciones" runat="server">
            <ContentTemplate>
                <div class="d-flex align-items-center mb-1">
                    <div class="ms-auto">
                        <asp:Label ID="lblCantidadResultados" runat="server" CssClass="fw-semibold"></asp:Label>
                    </div>
                </div>

                <div  style="height:400px; overflow-y:auto;" >
                    <asp:Repeater ID="rptSolicitudes" runat="server" OnItemDataBound="rptSolicitudes_ItemDataBound">
                        <ItemTemplate>
                            <div class="card p-3 mb-1 bg-light rounded shadow-sm">
                                <div class="d-flex justify-content-between align-items-center">
                                    <div>
                                        <%--<small>Enviado: <%# Eval("fechaEnvio", "{0:dd/MM/yyyy}") %></small>--%>
                                        
                                        <strong><%# Eval("categoriaNombre") %> - <%# Eval("nombre") %></strong>
                                        <br/>
                                        
                                        <small class="text-muted">De:  <strong><%# Eval("NombrePersona") %></strong></small>
                                    </div>
                                    <div class="d-flex align-items-center">
                                        <asp:Label ID="lblEstado" runat="server" 
                                            CssClass="badge p-2 me-3" 
                                            Text='<%# Eval("estadoNombre") %>' />
                                        
                                        <a href='SolicitudPedidosAdmin.aspx?id=<%# Eval("publicacionId") %>' 
                                           class="btn btn-primary btn-sm fw-semibold">
                                            REVISAR
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </ItemTemplate>
                        <FooterTemplate>
                            <asp:Panel ID="pnlNoResultados" runat="server" Visible='<%# rptSolicitudes.Items.Count == 0 %>'>
                                <div class="alert alert-info text-center">
                                    No se encontraron publicaciones con los filtros seleccionados.
                                </div>
                            </asp:Panel>
                        </FooterTemplate>
                    </asp:Repeater>
                </div>

               <!-- Paginación estilo Anterior / Siguiente -->
                    <div class="d-flex justify-content-between align-items-center mt-2">
                        <asp:Button ID="btnAnterior" runat="server" Text="Anterior" CssClass="btn btn-outline-primary"
                            OnClick="btnAnterior_Click" />
                        <asp:Label ID="lblPagina" runat="server" CssClass="fw-semibold text-secondary"></asp:Label>
                        <asp:Button ID="btnSiguiente" runat="server" Text="Siguiente" CssClass="btn btn-outline-primary"
                            OnClick="btnSiguiente_Click" />
                    </div>
            </ContentTemplate>
        </asp:UpdatePanel>
    </div>
</asp:Content>