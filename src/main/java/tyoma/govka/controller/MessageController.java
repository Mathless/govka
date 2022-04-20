package tyoma.govka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tyoma.govka.services.MessagesDataBase;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("message")
public class MessageController {

    private MessagesDataBase messagesDataBase = new MessagesDataBase();

    @GetMapping
    public List<Map<String, String>> list() {
        return messagesDataBase.getAllMessages();
    }

    @GetMapping("{id}")
    public Map<String, String> getOne(@PathVariable String id) {
        return messagesDataBase.getMessageById(id);
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> create(@RequestBody Map<String, String> message) {
        return ResponseEntity.of(Optional.of(messagesDataBase.addMessage(message)));
    }

    @PutMapping("{id}")
    public Map<String, String> update(@PathVariable String id, @RequestBody Map<String, String> message) {
        return messagesDataBase.changeMessageById(id, message);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        messagesDataBase.deleteMessage(id);
    }
}
