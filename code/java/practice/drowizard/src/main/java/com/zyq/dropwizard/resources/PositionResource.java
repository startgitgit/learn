package com.zyq.dropwizard.resources;


import com.zyq.dropwizard.dao.PositionDao;
import com.zyq.dropwizard.model.Position;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhouyq
 */
@Path("position")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PositionResource {
    private PositionDao positionDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(PositionResource.class);
    public PositionResource(PositionDao positionDao) {
        this.positionDao = positionDao;
    }


    @Path("{id}")
    @GET
    public Response get(@PathParam("id") int id) {
        try {
            Position position = positionDao.queryPostionById(id);
            return Response
                    .status(Response.Status.OK)
                    .entity(position)
                    .build();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(),e);
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage())
                    .build();
        }
    }

    @Path("/create")
    @POST
    public Response create(Position position) {

        try {
            positionDao.createPosition(position);
            return Response
                    .status(Response.Status.OK)
                    .entity(position)
                    .build();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(),e);
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage())
                    .build();
        }
    }

    @GET
    public Response queryPositionByIdOrName(@QueryParam("id") Integer id,@QueryParam("name") String name) {
        try {
            LOGGER.info("name:{}",name);
            Position position = positionDao.queryPostionByIdOrName(id,StringUtils.wrap(name,"'"));
            return Response
                    .status(Response.Status.OK)
                    .entity(position)
                    .build();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(),e);
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage())
                    .build();
        }
    }

    @Path("/querypositionsbynames")
    @GET
    public Response queryPositionsByNames() {
        try {
            List<String> names = Arrays.asList("技术总监","软件工程师");
            List<Position> positions = positionDao.queryPostionsByNames(names);
            return Response
                    .status(Response.Status.OK)
                    .entity(positions)
                    .build();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(),e);
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage())
                    .build();
        }
    }


}
