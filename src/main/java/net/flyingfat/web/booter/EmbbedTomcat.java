package net.flyingfat.web.booter;

import java.io.File;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.core.AprLifecycleListener;
import org.apache.catalina.core.StandardServer;
import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmbbedTomcat
{
  private static final Logger logger = LoggerFactory.getLogger(EmbbedTomcat.class);
  private String hostname = "localhost";
  private int port = 80;
  private String webAppDir = "WebRoot";
  private String contextPath = "/";
  private String URIEncoding = "UTF-8";
  private String baseDir = ".";
  private String appBase = ".";
  private Tomcat tomcat = null;
  
  public String getHostname()
  {
    return this.hostname;
  }
  
  public void setHostname(String hostname)
  {
    this.hostname = hostname;
  }
  
  public int getPort()
  {
    return this.port;
  }
  
  public void setPort(int port)
  {
    this.port = port;
  }
  
  public String getWebAppDir()
  {
    return this.webAppDir;
  }
  
  public void setWebAppDir(String webAppDir)
  {
    this.webAppDir = webAppDir;
  }
  
  public String getContextPath()
  {
    return this.contextPath;
  }
  
  public void setContextPath(String contextPath)
  {
    this.contextPath = contextPath;
  }
  
  public String getBaseDir()
  {
    return this.baseDir;
  }
  
  public void setBaseDir(String baseDir)
  {
    this.baseDir = baseDir;
  }
  
  public String getAppBase()
  {
    return this.appBase;
  }
  
  public void setAppBase(String appBase)
  {
    this.appBase = appBase;
  }
  
  public void setURIEncoding(String uRIEncoding)
  {
    this.URIEncoding = uRIEncoding;
  }
  
  public void start()
    throws Exception
  {
    this.tomcat = new Tomcat();
    
    this.tomcat.setPort(this.port);
    this.tomcat.setHostname(this.hostname);
    this.tomcat.setSilent(false);
    this.tomcat.setBaseDir(this.baseDir);
    this.tomcat.getConnector().setURIEncoding(this.URIEncoding);
    

    this.tomcat.getHost().setAppBase(System.getProperty("user.dir") + File.separator + this.appBase);
    

    StandardServer server = (StandardServer)this.tomcat.getServer();
    AprLifecycleListener listener = new AprLifecycleListener();
    server.addLifecycleListener(listener);
    

    this.tomcat.addWebapp(this.contextPath, this.webAppDir);
    
    this.tomcat.start();
    

    Runtime.getRuntime().addShutdownHook(new Thread()
    {
      public void run()
      {
        try
        {
          tomcat.stop();
        }
        catch (LifecycleException e)
        {
          EmbbedTomcat.logger.error("failed to stop tomcat.", e);
        }
      }
    });
    this.tomcat.getServer().await();
  }
  
  public static void main(String[] args)
  {
    int port = 0;
    String appBase = null;
    String contextPath = null;
    String webAppDir = null;
    String baseDir = null;
    String URIEncoding = null;
    for (String arg : args)
    {
      if (arg.startsWith("-httpPort")) {
        port = Integer.parseInt(arg.substring(arg.indexOf("=") + 1));
      }
      if (arg.startsWith("-appBase")) {
        appBase = arg.substring(arg.indexOf("=") + 1);
      }
      if (arg.startsWith("-contextPath")) {
        contextPath = arg.substring(arg.indexOf("=") + 1);
      }
      if (arg.startsWith("-webAppDir")) {
        webAppDir = arg.substring(arg.indexOf("=") + 1);
      }
      if (arg.startsWith("-baseDir")) {
        baseDir = arg.substring(arg.indexOf("=") + 1);
      }
      if (arg.startsWith("-URIEncoding")) {
        URIEncoding = arg.substring(arg.indexOf("=") + 1);
      }
    }
    EmbbedTomcat tomcat = new EmbbedTomcat();
    if (port > 0) {
      tomcat.setPort(port);
    }
    if ((appBase != null) && (appBase.length() > 0)) {
      tomcat.setAppBase(appBase);
    }
    if ((contextPath != null) && (contextPath.length() > 0)) {
      tomcat.setContextPath(contextPath);
    }
    if ((webAppDir != null) && (webAppDir.length() > 0)) {
      tomcat.setWebAppDir(webAppDir);
    }
    if ((baseDir != null) && (baseDir.length() > 0)) {
      tomcat.setBaseDir(baseDir);
    }
    if ((URIEncoding != null) && (URIEncoding.length() > 0)) {
      tomcat.setURIEncoding(URIEncoding);
    }
    try
    {
      tomcat.start();
    }
    catch (Exception e)
    {
      logger.error("Server Start Error: ", e);
      System.exit(-1);
    }
  }
}
