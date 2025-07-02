package br.com.mercadoturbo.mercadolivre.dto;

import java.time.OffsetDateTime;
import java.util.List;

public class ClaimMessagesResponse {
    public List<Message> messages;

    public static class Message {
        public String sender_role;
        public String receiver_role;
        public String message;
        public String translated_message;
        public OffsetDateTime date_created;
        public OffsetDateTime last_updated;
        public OffsetDateTime message_date;
        public OffsetDateTime date_read;
        public List<Attachment> attachments;
        public String status;
        public String stage;
        public MessageModeration message_moderation;
        public boolean repeated;
    }

    public static class Attachment {
        public String filename;
        public String original_filename;
        public long size;
        public OffsetDateTime date_created;
        public String type;
    }

    public static class MessageModeration {
        public String status;
        public String reason;
        public String source;
        public OffsetDateTime date_moderated;
    }
}
