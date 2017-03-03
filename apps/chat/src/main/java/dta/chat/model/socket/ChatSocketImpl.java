package dta.chat.model.socket;

import java.io.IOException;

import dta.chat.exception.ChatClientException;
import dta.chat.model.ChatMessage;

public class ChatSocketImpl implements ChatSocket {

	private ClientSocket client;

	public ChatSocketImpl(String hostname, Integer port) {
		try {
			client = new ClientSocket(hostname, port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void sendMessage(ChatMessage msg) throws ChatClientException {
		try {
			client.sendObject(msg);
		} catch (IOException e) {
			throw new ChatClientException(e);
		}
	}

	@Override
	public ChatMessage readMessage() throws ChatClientException {
		try {
			return (ChatMessage) client.readObject();
		} catch (ClassNotFoundException | IOException e) {
			throw new ChatClientException(e);
		}
	}

	@Override
	public void close() {
		try {
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
