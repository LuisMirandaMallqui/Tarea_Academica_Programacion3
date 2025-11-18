<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/SquirLearn.Master" AutoEventWireup="true" CodeBehind="SolicitudPedidosAdmin.aspx.cs" Inherits="SquirlearnWA.SolicitudPedidosAdmin" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphContenido" runat="server">

    <asp:LinkButton ID="btnVolver" runat="server" CssClass="btn btn-link text-dark btn-flecha me-3" OnClick="btnVolver_Click">
    <i class="fa fa-arrow-left"></i>
</asp:LinkButton>

    <div class="container mt-4">
    <h4 class="fw-bold mb-4">Solicitud de publicación</h4>

   <asp:FormView ID="fvPedido" runat="server">
    <ItemTemplate>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label>Vendedor:</label>
                <div class="form-control-plaintext border rounded p-2 bg-light">
                    <%# Eval("persona.nombres") + " " + Eval("persona.primerApellido") + " " + 
                          Eval("persona.segundoApellido")  %>
                </div>
            </div>




            <div class="col-md-6 mb-3">
                <label>Fecha de envío:</label>
                <div class="form-control-plaintext border rounded p-2 bg-light">
                    <%# Eval("fechaEnvio") %>
                </div>
            </div>

            <div class="col-md-6 mb-3">
                <label>Categoría del producto:</label>
                <div class="form-control-plaintext border rounded p-2 bg-light">
                    <%# Eval("item.categoria.nombre") %>
                </div>
            </div>

            <div class="col-md-6 mb-3">
                <label>Subcategoría del producto:</label>
                <div class="form-control-plaintext border rounded p-2 bg-light">
                    <%# Eval("item.subcategoria.nombre") %>
                </div>
            </div>

            <div class="col-md-6 mb-3">
                <label>Título del producto:</label>
                <div class="form-control-plaintext border rounded p-2 bg-light">
                    <%# Eval("item.nombre") %>
                </div>
            </div>

            <div class="col-md-6 mb-3">
                <label>Descripción:</label>
                <div class="form-control-plaintext border rounded p-2 bg-light">
                    <%# Eval("item.descripcion") %>
                </div>
            </div>

            <div class="col-md-6 mb-3">
                <label>Acción:</label>
                <div class="form-control-plaintext border rounded p-2 bg-light">
                   <span><%# (bool)Eval("item.esVenta") ? "VENTA" : "ALQUILER" %></span>
                </div>
            </div>

              <div class="col-md-6 mb-3">
                    <label>Periodo de tiempo:</label>
                    <div class="form-control-plaintext border rounded p-2 bg-light">
                        <%# !(bool)Eval("item.esVenta") ? Eval("item.periodo") + " días" : "" %>
                    </div>
                </div>

            <div class="col-md-6 mb-3">
                <label>Precio Unitario:</label>
                <div class="form-control-plaintext border rounded p-2 bg-light">
                    S/. <%# String.Format("{0:0.00}", Eval("item.precio")) %>
                </div>
            </div>

            <div class="col-md-6 mb-3">
                <label>Tipo de publicación:</label>
                <div class="form-control-plaintext border rounded p-2 bg-light">
                    <%# Eval("item.color.nombre") %>
                </div>
            </div>

            <div class="col-md-6 mb-3">
                <label>Formato del producto:</label>
                <div class="form-control-plaintext border rounded p-2 bg-light">
                    <%# Eval("item.formato.nombre") %>
                </div>
            </div>
             <div class="col-md-6 mb-3">
                 <label>Tamaño del producto:</label>
                 <div class="form-control-plaintext border rounded p-2 bg-light">
                     <%# Eval("item.tamano.nombre") %>
                 </div>
             </div>

            <div class="col-md-6 mb-3">
                <label>Estado del producto:</label>
                <div class="form-control-plaintext border rounded p-2 bg-light">
                    <%# Eval("item.condicion.nombre") %>
                </div>
            </div>

          
        </div>

       

        <div class="text-center mt-5">
            <a href="RechazoPublicacion.aspx" class="btn btn-danger px-5 py-2 me-3 fw-bold">Rechazar Pedido</a>
            <a href="AceptacionPublicacion.aspx" class="btn btn-primary px-5 py-2 fw-bold">Aceptar Pedido</a>
        </div>
    </ItemTemplate>
</asp:FormView>
</div>

</asp:Content>
