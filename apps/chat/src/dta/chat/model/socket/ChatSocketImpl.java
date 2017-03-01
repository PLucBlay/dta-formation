package dta.chat.model.socket;

import java.io.IOException;

import dta.chat.exception.ChatClientException;
import dta.chat.model.ChatMessage;

public class ChatSocketImpl extends ClientSocket implements ChatSocket {

	public ChatSocketImpl(String hostname, Integer port) throws IOException {
		super(hostname, port);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sendMessage(ChatMessage msg) throws ChatClientException {
		try {
			this.serverOuput.writeObject(obj);
		} catch (IOException e) {
			throw new ChatClientException(e);
		}
	}

	@Override
	public ChatMessage readMessage() throws ChatClientException {
		try {
			return (ChatMessage) this.serverInput.readObject();
		} catch (ClassNotFoundException | IOException e) {
			throw new ChatClientException(e);
		}
	}

}
