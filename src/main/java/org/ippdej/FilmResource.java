package org.ippdej;

import org.eclipse.microprofile.openapi.annotations.Operation;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Path("/film")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FilmResource {

    @GET
    @Operation(summary = "Get Films", description = "Lists all availables films")
    public List<Film> getFilms() {
        return FilmEntity.<FilmEntity>streamAll()
                .map(this::fromEntity)
                .collect(Collectors.toList());
    }

    @GET
    @Path("/{title}")
    public Film getFilm(@PathParam("title") String title) {
        return fromEntity(FilmEntity.find("title", title).firstResult());
    }

    @POST
    @Transactional
    public Response addFilm(Film film) {
        FilmEntity.persist(toEntity(film));
        return Response.ok().build();
    }

    private Film fromEntity(FilmEntity entity) {
        Film dto = new Film();
        dto.setTitle(entity.getTitle());
        dto.setSynopsis(entity.getSynopsis());
        return dto;
    }

    private FilmEntity toEntity(Film film) {
        FilmEntity entity = new FilmEntity();
        entity.setTitle(film.getTitle());
        entity.setSynopsis(film.getSynopsis());
        return entity;
    }
}
