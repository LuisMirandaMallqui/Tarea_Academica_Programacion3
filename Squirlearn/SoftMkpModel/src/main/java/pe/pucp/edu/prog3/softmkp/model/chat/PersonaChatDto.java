package pe.pucp.edu.prog3.softmkp.model.chat;

import pe.pucp.edu.prog3.softmkp.model.chat.ChatDto;
import java.util.Date;
import pe.pucp.edu.prog3.softmkp.model.persona.PersonaDto;

public class PersonaChatDto {
    
    private PersonaDto persona;
    private ChatDto chat;
    private Date ultimaActividad;
    
    // Constructor vacío
    public PersonaChatDto() {
        this.persona = null;
        this.chat = null;
        this.ultimaActividad = null;
    }

    // Constructor con parámetros
    public PersonaChatDto(PersonaDto persona, ChatDto chat, Date ultimaActividad) {
        this.persona = persona;
        this.chat = chat;
        this.ultimaActividad = ultimaActividad;
    }

    // Getters y Setters
    public PersonaDto getPersona() {
        return persona;
    }

    public void setPersona(PersonaDto persona) {
        this.persona = persona;
    }

    public ChatDto getChat() {
        return chat;
    }

    public void setChat(ChatDto chat) {
        this.chat = chat;
    }

    public Date getUltimaActividad() {
        return ultimaActividad;
    }

    public void setUltimaActividad(Date ultimaActividad) {
        this.ultimaActividad = ultimaActividad;
    }
    
}
