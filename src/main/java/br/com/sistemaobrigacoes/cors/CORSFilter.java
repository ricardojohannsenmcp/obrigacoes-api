package br.com.sistemaobrigacoes.cors;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Configuration
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)

public class CORSFilter implements Filter{

	
	// Disabling CORS for the purpose of Demo.
    // Ideally a production should have well defined set of domain address instead of '*'

  @Override
   public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
	  
      HttpServletRequest request =  (HttpServletRequest) req;
	  
	//  System.out.println("=== entrou no filtro do cors ===");
	  
		  
       HttpServletResponse response = (HttpServletResponse) res;
       response.setHeader("Access-Control-Allow-Origin", "*");
       response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE, PATCH");
       response.setHeader("Access-Control-Max-Age", "3600");
       response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, Accept, X-Requested-With");
       response.setHeader("Access-Control-Expose-Headers", "Location");
       
     //  System.out.println("=== antes de fazer o chain ===");
       if("OPTIONS".equalsIgnoreCase(request.getMethod())) {
           response.setStatus(HttpServletResponse.SC_OK);

       } else {
           chain.doFilter(req, res);
       }
   }

   @Override
   public void init(FilterConfig filterConfig) {}

   @Override
   public void destroy() {}

}
