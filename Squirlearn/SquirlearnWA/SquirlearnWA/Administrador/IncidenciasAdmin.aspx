<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/SquirLearn.Master" AutoEventWireup="true" CodeBehind="IncidenciasAdmin.aspx.cs" Inherits="SquirlearnWA.IncidenciasAdmin" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphContenido" runat="server">

    
    <h3 class="fw-bold mb-4">Listado de Incidencias</h3>

    <div class="d-flex justify-content-start mb-3">
        <asp:DropDownList ID="ddlEstado" runat="server" AutoPostBack="true"
            CssClass="form-select w-auto"
            OnSelectedIndexChanged="ddlEstado_SelectedIndexChanged">
            <asp:ListItem Value="">-- Estado --</asp:ListItem>
            <asp:ListItem Value="true">Resueltas</asp:ListItem>
            <asp:ListItem Value="false">Pendientes</asp:ListItem>
        </asp:DropDownList>
    </div>

    <div class="table-responsive" style="max-height:400px; overflow-y:auto;">
    <table class="table tabla-incidencias align-middle">
    <thead>
        <tr>
            <th>  Usuario</th>
            <th> Motivo</th>
             <th style="padding-left:1px;">Estado</th>
            <th style="padding-left:1px;">Acción</th>
        </tr>
    </thead>

    <tbody>
        <asp:Repeater ID="rptIncidencias" runat="server" OnItemDataBound="rptIncidencias_ItemDataBound">
            <ItemTemplate>
                <tr>

                    <td>
                         <div class="d-flex justify-content-between">
                            <span><asp:Label ID="lblUsuario" runat="server"></asp:Label></span>
                            <span><asp:Label ID="lblMotivo" runat="server"></asp:Label></span>
                        </div>
                    </td>

                    <td>
                        <%# ((SquirlearnWA.incidenciaSOAP.incidenciaDto)Container.DataItem).motivo.nombre %>
                    </td>

                    <td>
                        <%# Convert.ToBoolean(Eval("resuelto"))
                                ? "<span class='estado-resuelta'>Resuelta</span>"
                                : "<span class='estado-pendiente'>Pendiente</span>" %>
                    </td>

                    <td>
                       <%# !Convert.ToBoolean(Eval("resuelto"))
            ? string.Format("<a href='ResponderIncidencia.aspx?id={0}' class='btn btn-responder'>Responder</a>", Eval("incidenciaId"))
            : string.Format("<a href='ResponderIncidencia.aspx?id={0}' class='btn btn-info text-white'>Ver</a>", Eval("incidenciaId")) %>
                    </td>

                </tr>
            </ItemTemplate>
        </asp:Repeater>
    </tbody>
</table>
    </div>



</asp:Content>
