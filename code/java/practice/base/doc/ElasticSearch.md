# ElasticSearch


```
# 会聚查询
GET _search
{
  "size": 0,
  "aggs": {
    "max_id": {
      "max": {
        "field": "id"
      }
    },
    "sum_id": {
      "sum": {
        "field": "id"
      }
    },
    "avg_id": {
      "avg": {
        "field": "id"
      }
    }
  }
}



#创建
PUT test 
{
  "settings": {
    "number_of_shards": 1,
    "number_of_replicas": 1
  }
}

#查看索引设置
GET pms

GET test

GET *


#查看索引是否存在
HEAD pms

#删除索引
DELETE test

#创建映射字段 
PUT test/_mapping/data
{
  "properties": {
    "name":{
      "type": "text",
      "index": true,
      "store": true,
      "analyzer": "ik_max_word"
    }
  }
}

# 查看映射字段
GET test/_mapping

#fulk增加增加数据ovr增加数据数据
POST test/data
{
  "name":"zhouyanqing"
}










```

