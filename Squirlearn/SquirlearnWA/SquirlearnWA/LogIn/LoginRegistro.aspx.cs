using SquirlearnWA.personaSOAP;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SquirlearnWA
{
    public partial class Registro : System.Web.UI.Page
    {

        private PersonaClient personaSoap;

        public Registro()
        {
            personaSoap = new PersonaClient();
        }

        protected void Page_Load(object sender, EventArgs e)
        {

        }
        

        public static bool EsCorreoPucp(string correo)
        {
            if (string.IsNullOrWhiteSpace(correo)) return false;

            // Algo antes del @, sin espacios, y que termine exactamente en @pucp.edu.pe
            var regex = new Regex(@"^[^@\s]+@pucp\.edu\.pe$", RegexOptions.IgnoreCase);
            return regex.IsMatch(correo);
        }

        public bool soloTieneLetras(string texto)
        {
            if (string.IsNullOrEmpty(texto)) return false;

            foreach (char c in texto)
            {
                if (!char.IsLetter(c))
                    return false;
            }
            return true;
        }
        public bool soloTieneNumeros(string texto)
        {
            if (string.IsNullOrEmpty(texto)) return false;

            foreach (char c in texto)
            {
                if (!char.IsDigit(c))
                    return false;
            }
            return true;
        }
        public static bool EsContraseñaValida(string password)
        {
            if (string.IsNullOrEmpty(password)) return false;

            bool tieneMayuscula = false;
            bool tieneMinuscula = false;
            bool tieneNumero = false;
            bool tieneEspecial = false;

            foreach (char c in password)
            {
                if (char.IsUpper(c))
                    tieneMayuscula = true;
                else if (char.IsLower(c))
                    tieneMinuscula = true;
                else if (char.IsDigit(c))
                    tieneNumero=true;
                else
                    tieneEspecial = true;
            }

            return tieneMayuscula && tieneMinuscula && tieneEspecial && tieneNumero && password.Length >= 8;
        }

        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
            string nombre = txtNombre.Text.Trim();
            string primerApellido = txtPrimerApellido.Text.Trim();
            string segundoApellido = txtSegundoApellido.Text.Trim();
            string correo = txtEmail.Text.Trim();
            string codigo = txtCodigo.Text.Trim();
            string contraseña1 = txtContraseña.Text.Trim();
            string contraseña2 = txtConfirmarContraseña.Text.Trim();
            string fechaActividad = DateTime.Now.ToString("yyyy-MM-dd");

            if(!soloTieneLetras(nombre))
            {
                lblError.Text = "Debes ingresar un nombre válido.";
                return;
            }
            if(!soloTieneLetras(primerApellido))
            {
                lblError.Text = "Debes ingresar tu apellido paterno válido. ";
                return;
            }
            if(!soloTieneLetras(segundoApellido))
            {
                lblError.Text = "Debes ingresar tu apellido materno válido. ";
                return;
            }
            if(!EsCorreoPucp(correo))
            {
                lblError.Text = "Debes ingresar un correo válido. ";
                return;
            }
            if(!soloTieneNumeros(codigo) || !(codigo.Length==8))
            {
                lblError.Text = "Debes ingresar tu codigo PUCP. ";
                return;
            }
            if(!EsContraseñaValida(contraseña1))
            {
                lblError.Text = "Debes ingresar una contraseña válida. ";
                return;
            }
            if (contraseña1 == contraseña2)
            {
                if (!chkTerminos.Checked)
                {
                    lblError.Text = "Debes aceptar los términos y condiciones.";
                    return;
                }
                else
                {
                    int resultado = personaSoap.insertarPersona(nombre, primerApellido, segundoApellido, codigo, correo, contraseña1,
                        nombre + primerApellido + segundoApellido, fechaActividad);
                    if (resultado == 0)
                    {
                        lblError.Text = "No se pudo registrar al usuario";
                        return;
                    }
                    lblError.Text = "";
                    Response.Redirect("../PantallaInicio/SquirLearnInicio.aspx");
                }
                   
            }
            else
            {
                // Mostrar mensaje de error
                ClientScript.RegisterStartupScript(this.GetType(), "alert", "alert('Las contraseñas no coinciden');", true);
            }
        }
        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("../Login/LoginInicio.aspx");
        }

    }
}