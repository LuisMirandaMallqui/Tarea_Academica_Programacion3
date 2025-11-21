<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/Login.Master" AutoEventWireup="true" CodeBehind="LoginRegistro.aspx.cs" Inherits="SquirlearnWA.Registro" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphContenido" runat="server">

    <div class="d-flex justify-content-center mt-5">
        <div class="card shadow p-4" style="width: 600px;">

            <h2 class="text-center mb-3 fw-bold">Bienvenido,<br />
                cuéntanos de ti
            </h2>
            <p class="text-center mb-4">
                Ingresa tus datos para registrar tu cuenta
           
            </p>

            <asp:Panel ID="pnlRegistro" runat="server">

                <div class="mb-3">
                    <label for="txtNombre" class="fw-semibold">¿Cuál es tu nombre?</label>
                    <asp:TextBox ID="txtNombre" runat="server" CssClass="form-control"
                        placeholder="Ej: Juan"></asp:TextBox>
                </div>

                <div class="mb-3">
                    <label for="txtPrimerApellido" class="fw-semibold">¿Cuál es tu apellido paterno?</label>
                    <asp:TextBox ID="txtPrimerApellido" runat="server" CssClass="form-control"
                        placeholder="Ej: Perez"></asp:TextBox>
                </div>

                <div class="mb-3">
                    <label for="txtSegundoApellido" class="fw-semibold">¿Cuál es tu apellido materno?</label>
                    <asp:TextBox ID="txtSegundoApellido" runat="server" CssClass="form-control"
                        placeholder="Ej: Quispe"></asp:TextBox>
                </div>

                <div class="mb-3">
                    <label for="txtEmail" class="fw-semibold">¿Cuál es tu correo PUCP?</label>
                    <asp:TextBox ID="txtEmail" runat="server" CssClass="form-control"
                        placeholder="ejemplo@pucp.edu.pe"></asp:TextBox>
                </div>

                <div class="mb-3">
                    <label for="txtCodigo" class="fw-semibold">¿Cuál es tu código PUCP?</label>
                    <asp:TextBox ID="txtCodigo" runat="server" CssClass="form-control"
                        placeholder="Ej: 20231414"></asp:TextBox>
                </div>

                <div class="mb-3">
                    <label for="txtContraseña" class="fw-semibold">Contraseña</label>
                    <asp:TextBox ID="txtContraseña" runat="server" CssClass="form-control"
                        TextMode="Password" placeholder="Contraseña"></asp:TextBox>
                    <p class="text-muted">
                        La contraseña debe tener:<br>
                        - 8 caracteres<br>
                        - 1 letra mayúscula<br>
                        - 1 letra minúscula<br>
                        - 1 caracter especial (". - / @ #")
                    </p>
                </div>

                <div class="mb-3">
                    <label for="txtConfirmarContraseña" class="fw-semibold">Ingrese nuevamente su contraseña</label>
                    <asp:TextBox ID="txtConfirmarContraseña" runat="server" CssClass="form-control"
                        TextMode="Password" placeholder="Confirmar contraseña"></asp:TextBox>
                </div>

                <style>
                    .form-check {
                        font-size: 1.3rem; /* o 1.1rem si lo quieres un poquito más grande */
                    }
                </style>

                <div class="form-check mb-3">
                    <asp:CheckBox ID="chkTerminos" runat="server"
                        CssClass="chk-terminos" />
                    <label for="<%= chkTerminos.ClientID %>"
                        class="form-check-label small label-terminos">
                        Acepto los términos y condiciones impuestos por la empresa
                    </label>
                </div>

                <div class="d-grid gap-2">
                    <asp:Button ID="btnRegistrar" runat="server"
                        CssClass="btn btn-primary"
                        Text="Registrar" OnClick="btnRegistrar_Click" />

                    <asp:Button ID="btnRegresar" runat="server"
                        CssClass="btn btn-secondary"
                        Text="Regresar" OnClick="btnRegresar_Click" />
                </div>


                <asp:Label ID="lblError" runat="server" CssClass="d-block mt-3 text-center"
                    ForeColor="Red"></asp:Label>

            </asp:Panel>
        </div>
    </div>

</asp:Content>
