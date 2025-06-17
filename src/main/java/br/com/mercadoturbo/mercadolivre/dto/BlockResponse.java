package br.com.mercadoturbo.mercadolivre.dto;


import java.time.OffsetDateTime;
import java.util.List;

public class BlockResponse  extends ProxyEnabledDTO{
    public List<User> users;
    public Paging paging;

    public static class User {
        public Long id;
        public OffsetDateTime blocked_at;
    }

    public static class Paging {
        public int offset;
        public int limit;
        public int total;
    }
}
