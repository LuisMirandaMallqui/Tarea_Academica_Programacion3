<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/SquirLearn.Master" AutoEventWireup="true" CodeBehind="SquirLearnInicio.aspx.cs" Inherits="SquirlearnWA.SquirLearnInicio" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphContenido" runat="server">
    <!-- Dentro del formulario ASP.NET -->
    
        <div class="input-group mb-3">
    <asp:TextBox ID="txtBuscar" runat="server" CssClass="form-control" 
        Placeholder="Busca libros, cursos..."></asp:TextBox>
    <asp:LinkButton ID="btnMostrarFiltro" runat="server" CssClass="input-group-text bg-light"
        OnClick="btnMostrarFiltro_Click">
        <i class="fa fa-filter"></i>
    </asp:LinkButton>
</div>


   <div class="row">
    <div class="col-md-4">
        <!-- Panel del filtro oculto inicialmente -->
        <asp:Panel ID="pnlFiltro" runat="server" CssClass="p-3 border bg-light position-relative" Visible="false">
            
            <!-- Botón "X" para cerrar -->
            <button type="button" class="btn-close position-absolute top-0 end-0 m-2" aria-label="Close" onclick="cerrarFiltro()"></button>

            <div class="mb-2">
                <label for="ddlCategoria">Categoría:</label>
                <asp:DropDownList ID="ddlCategoria" runat="server" CssClass="form-select">
                    <asp:ListItem Text="Todos" Value=""></asp:ListItem>
                    <asp:ListItem Text="Libros" Value="Libros"></asp:ListItem>
                    <asp:ListItem Text="Instrumentos" Value="Instrumentos"></asp:ListItem>
                    <asp:ListItem Text="Clases Grabadas" Value="Clases Grabadas"></asp:ListItem>
                    <asp:ListItem Text="Apuntes de Clase" Value="Apuntes de Clase"></asp:ListItem>
                    <asp:ListItem Text="Cursos" Value="Cursos"></asp:ListItem>
                    <asp:ListItem Text="Otros" Value="Otros"></asp:ListItem>
                </asp:DropDownList>
            </div>

            <div class="mb-2">
                <label>Venta / Alquiler:</label>
                <asp:RadioButtonList ID="rblVentaAlquiler" runat="server" CssClass="form-check">
                    <asp:ListItem Text="Todos" Value=""></asp:ListItem>
                    <asp:ListItem Text="Venta" Value="Venta"></asp:ListItem>
                    <asp:ListItem Text="Alquiler" Value="Alquiler"></asp:ListItem>
                </asp:RadioButtonList>
            </div>

            <div class="mb-2">
                <label>Estado del Producto:</label>
                <asp:RadioButtonList ID="rblEstado" runat="server" CssClass="form-check">
                    <asp:ListItem Text="Todos" Value=""></asp:ListItem>
                    <asp:ListItem Text="Nuevo" Value="Nuevo"></asp:ListItem>
                    <asp:ListItem Text="Usado" Value="Usado"></asp:ListItem>
                </asp:RadioButtonList>
            </div>

            <div class="mb-2">
                <label>Tamaño del producto del Producto:</label>
                <asp:RadioButtonList ID="RadioButtonList1" runat="server" CssClass="form-check">
                    <asp:ListItem Text="Todos" Value=""></asp:ListItem>
                    <asp:ListItem Text="Pequeño" Value="Nuevo"></asp:ListItem>
                    <asp:ListItem Text="Mediano" Value="Nuevo"></asp:ListItem>
                    <asp:ListItem Text="Grande" Value="Usado"></asp:ListItem>
                </asp:RadioButtonList>
            </div>

            <asp:Button ID="btnFiltrar" runat="server" CssClass="btn btn-primary" Text="Buscar" OnClick="btnFiltrar_Click" />
            <asp:Button ID="btnLimpiar" runat="server" CssClass="btn btn-secondary" Text="Limpiar" OnClick="btnLimpiar_Click" />
        </asp:Panel>
    </div>

    <div class="col-md-8">
        <asp:Label ID="lblNoResultados" runat="server" CssClass="text-danger"></asp:Label>
        <asp:GridView ID="gvResultados" runat="server" CssClass="table table-striped" AutoGenerateColumns="false">
            <Columns>
                <asp:BoundField DataField="Nombre" HeaderText="Nombre" />
                <asp:BoundField DataField="Categoria" HeaderText="Categoría" />
                <asp:BoundField DataField="Tipo" HeaderText="Venta/Alquiler" />
                <asp:BoundField DataField="Estado" HeaderText="Estado" />
            </Columns>
        </asp:GridView>
    </div>
</div>

<script type="text/javascript">
    function cerrarFiltro() {
        var panel = document.getElementById('<%= pnlFiltro.ClientID %>');
        panel.style.display = 'none';
    }
</script>

    <div class="card-grid">
    <a href="Libros.aspx" class="card-option text-decoration-none text-dark">
        <img src="../Imagenes/libros.png" alt="Libros" />
        <h5>Libros</h5>
    </a>

    <a href="Instrumentos.aspx" class="card-option text-decoration-none text-dark">
        <img src="../Imagenes/instrumentos.png" alt="Instrumentos" />
        <h5>Instrumentos</h5>
    </a>

    <a href="ClasesGrabadas.aspx" class="card-option text-decoration-none text-dark">
        <img src="../Imagenes/clases.png" alt="Clases grabadas" />
        <h5>Clases Grabadas</h5>
    </a>

    <a href="Apuntes.aspx" class="card-option text-decoration-none text-dark">
        <img src="../Imagenes/apuntes.png" alt="Apuntes" />
        <h5>Apuntes de Clase</h5>
    </a>

    <a href="Cursos.aspx" class="card-option text-decoration-none text-dark">
        <img src="../Imagenes/cursos.png" alt="Cursos" />
        <h5>Cursos</h5>
    </a>

    <a href="Otros.aspx" class="card-option text-decoration-none text-dark">
        <img src="../Imagenes/más.png" alt="Otros" />
        <h5>Otros</h5>
    </a>
</div>
</asp:Content>
