package pe.pucp.edu.prog3.softmkp.modelChat;

import pe.pucp.edu.prog3.softmkp.modelChat.ChatDTO;
import java.util.Date;
import pe.pucp.edu.prog3.softmkp.modelPersona.PersonaDTO;

public class PersonaChatDTO {
    
    private PersonaDTO persona;
    private ChatDTO chat;
    private Date ultimaActividad;
    
    // Constructor vacío (todo en null)
    public PersonaChatDTO() {
        this.persona = null;
        this.chat = null;
        this.ultimaActividad = null;
    }

    // Constructor con parámetros
    public PersonaChatDTO(PersonaDTO persona, ChatDTO chat, Date ultimaActividad) {
        this.persona = persona;
        this.chat = chat;
        this.ultimaActividad = ultimaActividad;
    }

    // Getters y Setters
    public PersonaDTO getPersona() {
        return persona;
    }

    public void setPersona(PersonaDTO persona) {
        this.persona = persona;
    }

    public ChatDTO getChat() {
        return chat;
    }

    public void setChat(ChatDTO chat) {
        this.chat = chat;
    }

    public Date getUltimaActividad() {
        return ultimaActividad;
    }

    public void setUltimaActividad(Date ultimaActividad) {
        this.ultimaActividad = ultimaActividad;
    }
    
}
