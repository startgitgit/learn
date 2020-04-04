package com.zyq.dropwizard.mapper;

import com.zyq.dropwizard.model.Position;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author zhouyq
 */
public class PositionMapper implements ResultSetMapper<Position> {
    @Override
    public Position map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        Position position = new Position();
        position.setId(r.getInt("id"));
        position.setName(r.getString("name"));
        position.setCreateDate(r.getDate("createDate"));
        return position;

    }
}
