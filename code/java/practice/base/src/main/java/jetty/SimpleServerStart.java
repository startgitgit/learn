package jetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

import java.util.Objects;

public class SimpleServerStart {
    public static void main(String[] args) throws Exception {
        int port = 8080;
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        String webapp = Objects.requireNonNull(contextClassLoader.getResource("webapp")).getPath();
        Server server = new Server(port);
        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setDescriptor(webapp + "/WEB-INF/web.xml");
        webAppContext.setResourceBase(webapp);
        webAppContext.setContextPath("/app");
        webAppContext.setConfigurationDiscovered(true);
        webAppContext.setParentLoaderPriority(true);
        webAppContext.setClassLoader(contextClassLoader);

        server.setHandler(webAppContext);
        System.out.println(webAppContext.getContextPath());
        System.out.println(webAppContext.getDescriptor());
        System.out.println(webAppContext.getResourceBase());
        System.out.println(webAppContext.getBaseResource());

        server.start();
        System.out.println("server is  start, port is " + port + "............");
        
    }
}