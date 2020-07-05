package zookeeper;

import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * @author zhouyq
 * @version 1.0
 * @date 2020/6/26 20:30
 */
public class ZookeeperApp {
    private static final Logger logger = LoggerFactory.getLogger(ZookeeperApp.class);

    public static void main(String[] args) throws Exception {
        BaseZookeeper zookeeper = new BaseZookeeper();
        zookeeper.connectZookeeper("127.0.0.1:2181");
        String nodePath = "/zte";
        Stat exists = zookeeper.exists(nodePath, true);
        if (exists == null) {
            String node = zookeeper.createNode(nodePath, "zte");
            logger.info(node);
        }
        String zte = zookeeper.getData(nodePath);
        logger.info(zte);

        List<String> children = zookeeper.getChildren("/");
        logger.info(children.toString());

        TimeUnit.SECONDS.sleep(20000);

    }

}
