<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/SquirLearn.Master" AutoEventWireup="true" CodeBehind="IncidenciasAdmin.aspx.cs" Inherits="SquirlearnWA.IncidenciasAdmin" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphContenido" runat="server">

    
    <h3 class="fw-bold mb-4">Listado de Incidencias</h3>

    <div class="table-responsive">
        <table class="table tabla-incidencias align-middle">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Descripción</th>
                    <th>Estado</th>
                    <th>Acción</th>
                </tr>
            </thead>
            <tbody>
                 <div class="notificaciones-container">
                <asp:Repeater ID="rptIncidencias" runat="server">
                    <ItemTemplate>
                        <tr>
                            <td><%# Eval("ID") %></td>
                            <td><%# Eval("Descripcion") %></td>
                            <td>
                                <%# (Eval("Estado").ToString() == "Pendiente") 
                                    ? "<span class='estado-pendiente'>Pendiente</span>" 
                                    : "<span class='estado-resuelta'>Resuelta</span>" %>
                            </td>
                            <td>
                                <%# (Eval("Estado").ToString() == "Pendiente") 
                                    ? $"<a href='ResponderIncidencia.aspx?id={Eval("ID")}' class='btn btn-responder'>Responder</a>" 
                                    : "<span class='btn btn-resuelta'>Resuelta</span>" %>
                            </td>
                        </tr>
                    </ItemTemplate>
                </asp:Repeater>
               </div>
            </tbody>
        </table>
    </div>



</asp:Content>
