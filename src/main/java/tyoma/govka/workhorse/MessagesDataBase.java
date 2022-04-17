package tyoma.govka.workhorse;

import tyoma.govka.exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessagesDataBase {
    private int counter;
    private List<Map<String, String>> messages;

    public MessagesDataBase() {
        counter = 4;
        messages = new ArrayList<>() {{
            add(new HashMap<String, String>() {{
                put("id", "1");
                put("text", "First message");
            }});
            add(new HashMap<String, String>() {{
                put("id", "2");
                put("text", "Second message");
            }});
            add(new HashMap<String, String>() {{
                put("id", "3");
                put("text", "Third message");
            }});
        }};
    }

    public Map<String, String> getMessageById(String id) {
        return messages.stream().filter(message -> message.get("id").equals(id)).findFirst().orElseThrow(NotFoundException::new);
    }

    public List<Map<String, String>> getAllMessages(){
        return messages;
    }

    public Map<String, String> addMessage(Map<String, String> message) {
        message.put("id", String.valueOf(counter++));
        messages.add(message);
        return message;
    }

    public Map<String, String> changeMessageById(String id, Map<String, String> message){
        Map<String, String> messageFromDb = getMessageById(id);
        messageFromDb.putAll(message);
        message.put("id", id);

        return messageFromDb;
    }
    public void deleteMessage(String id){
        Map<String, String> message = getMessageById(id);

        messages.remove(message);
    }

}
