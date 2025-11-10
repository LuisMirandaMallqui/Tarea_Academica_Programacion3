<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/Login.Master" AutoEventWireup="true" CodeBehind="LoginInicio.aspx.cs" Inherits="SquirlearnWA.LogIn.LoginInicio" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphContenido" runat="server">

    <div class="container text-center vh-100 d-flex align-items-center justify-content-center">
        <div class="row align-items-center w-100">

            <!-- Imagen lateral -->
            <div class="col-md-6 mb-4 mb-md-0">
                <img src="../Imagenes/ardilla2.png" alt="SquirLearn" 
                     class="img-fluid" style="max-width: 70%;">
            </div>

            <!-- Formulario de inicio de sesión -->
            <div class="col-md-6">
                <h2 class="fw-bold mb-0">BIENVENIDO A</h2>
                <h2 class="text-primary fw-bold mb-4">SQUIRLEARN</h2>

                <div class="mt-2 text-start mx-auto" style="max-width: 350px;">

                    <!-- Usuario -->
                    <label for="txtUsuario" class="fw-semibold mb-1">Usuario</label>
                    <div class="input-group mb-3">
                        <span class="input-group-text bg-light">
                            <i class="fa fa-user"></i>
                        </span>
                        <asp:TextBox ID="txtUsuario" runat="server" 
                            CssClass="form-control" placeholder="Correo PUCP"></asp:TextBox>
                    </div>

                    <!-- Contraseña -->
                    <label for="txtContraseña" class="fw-semibold mb-1">Contraseña</label>
                    <div class="input-group mb-1">
                        <span class="input-group-text bg-light">
                            <i class="fa fa-key"></i>
                        </span>
                        <asp:TextBox ID="txtContraseña" runat="server" 
                            CssClass="form-control" TextMode="Password" placeholder="Contraseña"></asp:TextBox>
                    </div>

                    <!-- Botones -->
                    <asp:Button ID="btnLogin" runat="server" 
                        Text="INICIAR SESIÓN" 
                        CssClass="btn btn-primary w-100 mb-2 fw-semibold" 
                        OnClick="btnLogin_Click" />

                    <asp:Button ID="btnRegistro" runat="server" 
                        Text="REGISTRARSE" 
                        CssClass="btn btn-outline-dark w-100 fw-semibold" 
                        OnClick="btnRegistro_Click" />

                </div>
            </div>
        </div>
    </div>

</asp:Content>
