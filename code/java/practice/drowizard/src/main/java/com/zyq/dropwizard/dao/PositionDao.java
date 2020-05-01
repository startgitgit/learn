package com.zyq.dropwizard.dao;


import com.zyq.dropwizard.mapper.PositionMapper;
import com.zyq.dropwizard.model.Position;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Define;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.skife.jdbi.v2.sqlobject.stringtemplate.UseStringTemplate3StatementLocator;
import org.skife.jdbi.v2.unstable.BindIn;

import java.util.List;

/**
 * @author zhouyq
 */


@RegisterMapper(PositionMapper.class)
@UseStringTemplate3StatementLocator
public interface PositionDao {

    @SqlQuery("select * from position where id = :id")
    Position queryPostionById(@Bind("id") int id);

    //    @SqlUpdate("insert into position (id,name,createDate) values (:id,:name,:createDate) on duplicate key update name=:name")
    @SqlUpdate("replace into position (id,name,createDate) values (:id,:name,:createDate)")
    void createPosition(@BindBean Position position);


    //    @SqlQuery("select * from position where <if(id)> id = <id> <else> name =<name> <endif>")
    @SqlQuery
    List<Position> queryPostions(@Define("id") Integer id, @BindIn("names") List<String> names);


}
