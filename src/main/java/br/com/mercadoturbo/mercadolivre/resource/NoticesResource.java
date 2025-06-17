package br.com.mercadoturbo.mercadolivre.resource;

import br.com.mercadoturbo.mercadolivre.dto.NoticesResponse;
import br.com.mercadoturbo.mercadolivre.service.NoticesService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.io.Serializable;
import java.util.List;

@Path("/communications")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NoticesResource implements Serializable{

    @Inject
    NoticesService service;

    @Path("/notices")
    @GET
    public Uni<NoticesResponse> getNotices(
            @HeaderParam("Authorization") String authorization,
            @QueryParam("limit") @DefaultValue("10") Integer limit,
            @QueryParam("offset") @DefaultValue("0") Integer offset) {
        // Recebe Authorization: Bearer <token> do frontend/cliente e repassa para Mercado Livre
        return service.fetchNotices(authorization, limit, offset);
    }

    @GET
    @Path("/notices/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<List<NoticesResponse.Notice>> getAllNotices(@HeaderParam("Authorization") String auth) {
        return service.fetchAllNotices(auth);
    }


// exemplo de chamada reativa encadeada
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public Uni<List<NoticeFull>> getFull(
//            @HeaderParam("Authorization") String auth,
//            @QueryParam("limit") @DefaultValue("5") int limit,
//            @QueryParam("offset") @DefaultValue("0") int offset) {
//
//        String token = auth.replace("Bearer ", "");
//
//        return client.getNotices(token, limit, offset)
//            .onItem().transformToMulti(noticesResp -> Multi.createFrom().iterable(noticesResp.results))
//
//            .onItem().transformToUniAndMerge(notice -> {
//                Uni<Detail> detailUni = client.getDetail(notice.id, token);
//                Uni<Attachment> attachUni = client.getAttachment(notice.id, token);
//
//                return Uni.combine().all().unis(detailUni, attachUni)
//                    .asTuple()
//                    .map(tuple -> new NoticeFull(notice, tuple.getItem1(), tuple.getItem2()));
//            })
//
//            .collect().asList();
//    }
//}


// exemplo com retry e fallback
//.onItem().transformToUniAndMerge(notice -> {
//    Uni<Detail> detailUni = client.getDetail(notice.id, token)
//        .onFailure().retry().atMost(2) // Retry até 2 vezes
//        .onFailure().recoverWithItem(th -> {
//            Detail fallback = new Detail();
//            fallback.noticeId = notice.id;
//            fallback.extraInfo = "Detalhes indisponíveis";
//            return fallback;
//        });
//
//    Uni<Attachment> attachUni = client.getAttachment(notice.id, token)
//        .onFailure().retry().atMost(2)
//        .onFailure().recoverWithItem(th -> {
//            Attachment fallback = new Attachment();
//            fallback.noticeId = notice.id;
//            fallback.files = List.of(); // nenhum anexo
//            return fallback;
//        });
//
//    return Uni.combine().all().unis(detailUni, attachUni)
//        .asTuple()
//        .map(tuple -> new NoticeFull(notice, tuple.getItem1(), tuple.getItem2()));
//})

}
