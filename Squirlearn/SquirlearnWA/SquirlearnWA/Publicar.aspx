<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/SquirLearn.Master" AutoEventWireup="true" CodeBehind="Publicar.aspx.cs" Inherits="SquirlearnWA.Publicar" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphContenido" runat="server">

    <div class="container py-4">
        <!-- Flecha de regreso -->
        <a href="SquirLearnInicio.aspx" class="text-decoration-none text-dark fw-semibold mb-3 d-inline-block">
            <i class="fa fa-arrow-left"></i> Volver
        </a>

        <h3 class="fw-bold mb-4">NUEVA PUBLICACIÓN</h3>

        <div class="row g-4">
            <!-- Columna izquierda -->
            <div class="col-md-6">
                <label class="fw-semibold mb-1">¿Qué producto deseas ofrecer?</label>
                <asp:TextBox ID="txtNombre" runat="server" CssClass="form-control mb-3"
                             Placeholder="Nombre del producto"></asp:TextBox>

                <label class="fw-semibold mb-1">Añade una descripción</label>
                <asp:TextBox ID="txtDescripcion" runat="server" CssClass="form-control mb-3"
                             TextMode="MultiLine" Rows="5"
                             Placeholder="Descripción del producto"></asp:TextBox>

                <label class="fw-semibold mb-1">¿Qué categoría corresponde?</label>
                <asp:DropDownList ID="ddlCategoria" runat="server" CssClass="form-select mb-4">
                    <asp:ListItem Text="Seleccionar categoría" Value=""></asp:ListItem>
                    <asp:ListItem Text="Libros" Value="1"></asp:ListItem>
                    <asp:ListItem Text="Electrónicos" Value="2"></asp:ListItem>
                    <asp:ListItem Text="Útiles y accesorios" Value="3"></asp:ListItem>
                    <asp:ListItem Text="Apuntes" Value="4"></asp:ListItem>
                </asp:DropDownList>
            </div>

            <!-- Columna derecha -->
            <div class="col-md-6">
                <label class="fw-semibold mb-1">¿Qué deseas hacer?</label>
                <div class="mb-3">
                    <asp:RadioButtonList ID="rblTipo" runat="server" RepeatDirection="Horizontal">
                        <asp:ListItem Text="Alquilar" Value="Alquiler" Selected="True"></asp:ListItem>
                        <asp:ListItem Text="Vender" Value="Venta"></asp:ListItem>
                    </asp:RadioButtonList>
                </div>

                <label class="fw-semibold mb-1">Ahora establece un precio</label>
                <asp:TextBox ID="txtPrecio" runat="server" CssClass="form-control mb-3"
                             Placeholder="Precio por producto"></asp:TextBox>

                <label class="fw-semibold mb-1">Establece un periodo de alquiler (opcional)</label>
                <asp:TextBox ID="txtPeriodo" runat="server" CssClass="form-control mb-3"
                             Placeholder="Tiempo de alquiler (en días)"></asp:TextBox>

                <label class="fw-semibold mb-1">Añade fotos</label>
                <asp:FileUpload ID="fuImagen" runat="server" CssClass="form-control mb-4" />

                <div class="d-flex justify-content-end">
                    <asp:Button ID="btnCancelar" runat="server" CssClass="btn btn-secondary me-2"
                                Text="Cancelar" OnClick="btnCancelar_Click" />
                    <asp:Button ID="btnSiguiente" runat="server" CssClass="btn btn-primary"
                                Text="Siguiente" OnClick="btnSiguiente_Click" />
                </div>
            </div>
        </div>
    </div>

</asp:Content>
