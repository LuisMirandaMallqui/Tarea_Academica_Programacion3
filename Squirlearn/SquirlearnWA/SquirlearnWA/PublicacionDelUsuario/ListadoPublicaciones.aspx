<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/SquirLearn.Master" AutoEventWireup="true" CodeBehind="ListadoPublicaciones.aspx.cs" Inherits="SquirlearnWA.ListadoPublicaciones" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphContenido" runat="server">

    <asp:ScriptManager ID="ScriptManager1" runat="server"></asp:ScriptManager>

    <div class="container py-4">
        <a href="../PantallaInicio/SquirLearnInicio.aspx" class="text-decoration-none text-dark fw-semibold mb-3 d-inline-block">
            <i class="fa fa-arrow-left"></i>Volver
        </a>

        <h2 class="fw-bold mb-4">Listado de publicaciones</h2>

        <div class="d-flex justify-content-end mb-3">
            <asp:Button ID="btnCrear" runat="server" Text="CREAR PUBLICACIÓN" CssClass="btn btn-success me-2" OnClick="btnCrear_Click" />
            <asp:Button ID="btnEditar" runat="server" Text="EDITAR PUBLICACIÓN" CssClass="btn btn-warning me-2" OnClick="btnEditar_Click" />
            <asp:Button ID="btnEliminar" runat="server" Text="ELIMINAR PUBLICACIÓN" CssClass="btn btn-danger" OnClientClick="mostrarModalEliminar(); return false;" />
        </div>

        <asp:UpdatePanel ID="upPanelPublicaciones" runat="server">
            <ContentTemplate>
                <div class="d-flex align-items-center mb-4">
                    <label for="<%= ddlEstados.ClientID %>" class="me-2 fw-semibold">Estados:</label>
                    <asp:DropDownList ID="ddlEstados" runat="server"
                        AutoPostBack="true"
                        OnSelectedIndexChanged="ddlEstados_SelectedIndexChanged"
                        CssClass="form-select w-auto">
                    </asp:DropDownList>
                    <div class="ms-auto">
                        <asp:Label ID="lblCantidadResultados" runat="server" CssClass="fw-semibold"></asp:Label>
                    </div>
                </div>

                <div style="max-height: 400px; overflow-y: auto;">
                    
                    <asp:Repeater ID="rptPublicaciones" runat="server" OnItemDataBound="rptPublicaciones_ItemDataBound">
                        <ItemTemplate>
                            <div class="card p-3 mb-3 bg-light rounded shadow-sm">
                                
                                <small>Enviado: <%# Eval("fechaEnvio", "{0:dd/MM/yyyy}") %></small>
                                
                                <strong><%# Eval("categoriaNombre") %> - <%# Eval("nombre") %></strong>

                                <div class="d-flex align-items-center mt-2">
                                    
                                    <asp:CheckBox ID="chkSeleccion" runat="server" CssClass="form-check-input me-2" />
                                    
                                    <asp:HiddenField ID="hdnPublicacionId" runat="server" Value='<%# Eval("publicacionId") %>' />
                                    
                                    <asp:Label ID="lblEstado" runat="server" 
                                        CssClass="badge p-2 me-2" 
                                        Text='<%# Eval("estadoNombre") %>' />
                                    
                                    <asp:Button ID="btnRevisar" runat="server" 
                                        Text="Revisar" 
                                        CssClass="btn btn-outline-dark btn-sm"
                                        CommandArgument='<%# Eval("publicacionId") %>'
                                        OnClick="BtnRevisar_Click"
                                        Visible="false" /> 
                                </div>
                            </div>
                        </ItemTemplate>
                        <FooterTemplate>
                            <asp:Panel ID="pnlNoResultados" runat="server" Visible='<%# rptPublicaciones.Items.Count == 0 %>'>
                                <div class="alert alert-info text-center">
                                    No se encontraron publicaciones con los filtros seleccionados.
                                </div>
                            </asp:Panel>
                        </FooterTemplate>
                    </asp:Repeater>
                </div>

                <div class="d-flex justify-content-center mt-3">
                    <asp:PlaceHolder ID="phPaginacion" runat="server"></asp:PlaceHolder>
                </div>
            </ContentTemplate>
        </asp:UpdatePanel>

    </div>

    <div class="modal fade" id="modalEliminar" ...>
        </div>

    <script type="text/javascript">
        // ...
    </script>
</asp:Content>
