<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/SquirLearn.Master" AutoEventWireup="true" CodeBehind="SquirLearnInicio.aspx.cs" Inherits="SquirlearnWA.SquirLearnInicio" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphContenido" runat="server">
    <!-- Dentro del formulario ASP.NET -->
    
        <div class="input-group">
            <asp:TextBox ID="txtBuscar" runat="server" CssClass="form-control" 
                Placeholder="Busca libros, cursos..."></asp:TextBox>
            <asp:LinkButton ID="btnBuscar" runat="server" CssClass="input-group-text bg-light" 
                OnClick="btnBuscar_Click">
                <i class="fa fa-search"></i>
            </asp:LinkButton>
        </div>
   

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
