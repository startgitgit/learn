package com.zyq.dropwizard.resources;


import com.zyq.dropwizard.dao.PositionDao;
import com.zyq.dropwizard.model.Position;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author zhouyq
 */
@Path("position")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PositionResource {
    private PositionDao positionDao;

    public PositionResource(PositionDao positionDao) {
        this.positionDao = positionDao;
    }

    @Path("/getposition")
    @GET
    public Response queryPositionById(@QueryParam("id") int id) {
        try {
            Position position = positionDao.queryPostionById(id);
            return Response
                    .status(Response.Status.OK)
                    .entity(position)
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage())
                    .build();
        }
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
            e.printStackTrace();
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage())
                    .build();
        }
    }


}
