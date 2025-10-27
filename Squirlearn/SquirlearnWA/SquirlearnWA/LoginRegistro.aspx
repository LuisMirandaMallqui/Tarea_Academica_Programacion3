<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/Login.Master" AutoEventWireup="true" CodeBehind="LoginRegistro.aspx.cs" Inherits="SquirlearnWA.Registro" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphContenido" runat="server">


    <div class="d-flex justify-content-center align-items-center vh-100">
    <div class="card shadow" style="width: 600px;">
        <h2 class="text-center mb-3 fw-bold">Bienvenido,<br>cuéntanos de ti</h2>
        <p class="text-center mb-4">Ingresa tus datos para registrar tu cuenta</p>

        <form>
            <div class="mb-3">
                <label class="fw-semibold">¿Cuál es tu nombre?</label>
                <asp:TextBox ID="txtNombre" runat="server" CssClass="form-control" placeholder="Nombres"></asp:TextBox>

            </div>
            <div class="mb-3">
                    <label class="fw-semibold">¿Cuál es tu apellido?</label>
                    <asp:TextBox ID="txtApellido" runat="server" CssClass="form-control" placeholder="Apellidos"></asp:TextBox>

                </div>

            <div class="mb-3">
                <label class="fw-semibold">¿Cuál es tu correo PUCP?</label>
                <asp:TextBox ID="txtEmail" runat="server" CssClass="form-control" placeholder="email PUCP"></asp:TextBox>

            </div>

            <div class="mb-3">
                <label class="fw-semibold">¿Cuál es tu código PUCP?</label>
                <asp:TextBox ID="txtCodigo" runat="server" CssClass="form-control" placeholder="Codigo PUCP"></asp:TextBox>

            </div>

            <div class="mb-3">
                <label class="fw-semibold">Contraseña nueva</label>
                <asp:TextBox ID="txtContraseña" runat="server" CssClass="form-control" placeholder="Contraseña"></asp:TextBox>

            </div>

            <div class="mb-3">
                <label class="fw-semibold">Ingrese nuevamente su contraseña</label>
                <asp:TextBox ID="txtConfirmarContraseña" runat="server" CssClass="form-control" placeholder="Contraseña"></asp:TextBox>

            </div>

            <div class="form-check mb-3">
                <asp:CheckBox ID="chkTerminos" runat="server" CssClass="form-check-input" />
                <label for="chkTerminos" class="form-check-label small">
                    Acepto los términos y condiciones impuestos por la empresa
                </label>
            </div>
            <asp:Button ID="btnRegistrar" runat="server" CssClass="btn btn-primary w-100" Text="Registrar"  OnClick="btnRegistrar_Click" />
           <asp:Label ID="lblError" runat="server" ForeColor="Red"></asp:Label>
        </form>                                                          
    </div>
</div>
</asp:Content>
