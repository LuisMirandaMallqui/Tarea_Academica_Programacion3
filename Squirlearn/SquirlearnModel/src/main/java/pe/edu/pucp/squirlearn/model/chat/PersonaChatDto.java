package pe.edu.pucp.squirlearn.model.chat;

import java.sql.Date;
import pe.edu.pucp.squirlearn.model.persona.PersonaDto;

public class PersonaChatDto {
    
    private PersonaDto persona;
    private ChatDto chat;
    
    // Constructor vacío
    public PersonaChatDto() {
        this.persona = null;
        this.chat = null;
    }

    // Constructor con parámetros
    public PersonaChatDto(PersonaDto persona, ChatDto chat, Date ultimaActividad) {
        this.persona = persona;
        this.chat = chat;
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
    
}
