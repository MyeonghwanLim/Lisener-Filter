package model;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;



/**
 * Application Lifecycle Listener implementation class TestCgv
 *
 */
@WebListener
public class TestCgv implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public TestCgv() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	ServletContext sc= sce.getServletContext(); // 어플리케이션 스코프에 해당한다.
        CgvVO cgv=new CgvVO();
        ArrayList<CgvVO> datas=new ArrayList<CgvVO>();
        CgvDAO cDAO = new CgvDAO();
        System.out.println("로그1");
        if(!cDAO.hasSample(cgv)) {
        	Crawling.sample();
        }
        datas= cDAO.selectAll(cgv);
        	
        
        System.out.println("로그2"+ datas);
        sc.setAttribute("datas", datas);
        System.out.println("로그3");
        System.out.println("TestListener: contextInitialized(): 톰캣 시작이 감지됨");
    }
	
}


