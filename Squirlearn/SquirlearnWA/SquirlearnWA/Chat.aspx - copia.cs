using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SquirlearnWA
{
    public partial class Chat : Page
    {
        // Propiedad temporal para simular mensajes en memoria
        private List<string> Mensajes
        {
            get
            {
                // Si no existe aún, crea una nueva lista vacía
                if (ViewState["Mensajes"] == null)
                    ViewState["Mensajes"] = new List<string>();
                return (List<string>)ViewState["Mensajes"];
            }
            set
            {
                ViewState["Mensajes"] = value;
            }
        }

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                // Aquí podrías cargar los mensajes desde la BD (más adelante)
                // Por ahora mostramos un ejemplo base.
                Mensajes.Add("Claro, podemos quedar en la Facultad de Arquitectura el lunes.");
                Mensajes.Add("Ya estoy por FARES, ¿dónde andas?");
                CargarMensajes();
            }
        }

        protected void btnEnviar_Click(object sender, EventArgs e)
        {
            string nuevoMensaje = txtMensaje.Text.Trim();
            if (!string.IsNullOrEmpty(nuevoMensaje))
            {
                Mensajes.Add(nuevoMensaje);
                txtMensaje.Text = string.Empty;
                CargarMensajes();
            }
        }

        private void CargarMensajes()
        {
            // Construye dinámicamente el HTML del chat
            string html = "";
            foreach (var mensaje in Mensajes)
            {
                html += $"<div class='text-end mb-2'>" +
                        $"<div class='bg-primary text-white d-inline-block px-3 py-2 rounded-3'>{mensaje}</div>" +
                        $"</div>";
            }

            chatContainer.InnerHtml = html;
        }
    }
}