package com.zyq.dropwizard.dao;


import com.zyq.dropwizard.mapper.PositionMapper;
import com.zyq.dropwizard.model.Position;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

/**
 * @author zhouyq
 */
@RegisterMapper(PositionMapper.class)
public interface PositionDao {
    @SqlQuery("select * from position where id = :id")
    Position queryPostionById(@Bind("id") int id);

//    @SqlUpdate("insert into position (id,name,createDate) values (:id,:name,:createDate) on duplicate key update name=:name")
    @SqlUpdate("replace into position (id,name,createDate) values (:id,:name,:createDate)")
    void createPosition(@BindBean Position position);
}
