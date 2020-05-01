package com.zyq.dropwizard.resources;


import com.zyq.dropwizard.dao.PositionDao;
import com.zyq.dropwizard.model.Position;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhouyq
 */
@Path("positions")
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
            LOGGER.error(e.getMessage(), e);
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
            LOGGER.error(e.getMessage(), e);
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage())
                    .build();
        }
    }

    @GET
    public Response queryPositions(@QueryParam("id") Integer id, @QueryParam("names") String names, @Context UriInfo ui, @Context HttpHeaders hh, @Context HttpServletRequest httpServletRequest) {
        try {
            LOGGER.info("name:{}", names);
            List<String> nameList = null;
            if (names != null) {
                nameList = Arrays.asList(names.split(","));
            }

            List<Position> positions = positionDao.queryPostions(id, nameList);
            return Response
                    .status(Response.Status.OK)
                    .entity(positions)
                    .build();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage())
                    .build();
        }
    }


}
