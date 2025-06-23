package br.com.mercadoturbo.mercadolivre.dto;

import java.time.OffsetDateTime;

public class MigrationStatusResponse {

    public String item_id;
    public Boolean migration_completed;
    public Boolean activation_completed;
    public OffsetDateTime date_created;
    public OffsetDateTime last_updated;
    public NewItem[] new_items;

    public static class NewItem {
        public String new_item_id;
        public Long variation_id;
        public String migration_status;
    }
}
