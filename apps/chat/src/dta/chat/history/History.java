package dta.chat.history;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import dta.chat.exception.ChatClientException;
import dta.chat.model.ChatMessage;

public class History {

	public static final Path PATH = Paths.get("data/history.txt");

	public History() {
		super();
	}

	public List<ChatMessage> findLastMessages() throws ChatClientException {

		try {
			List<ChatMessage> listM = new ArrayList<>();
			Files.readAllLines(PATH).forEach(line -> listM.add(ChatMessage.decode(line.split("\\|\\|\\|"))));
			return listM;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void saveMessage(ChatMessage message) {

		try {
			Files.write(PATH, (message.encode() + "\n").getBytes(), StandardOpenOption.CREATE,
					StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
