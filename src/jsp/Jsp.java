package jsp;
/*
 * 2016_12_28
 * 
 * JSP(Java Server Page) 란?
 *  JSP = Servlet = Java
 *  어렵게 구현하던 서블릿을 스크립트언어로 구현한 것.
 *  
 * JSP 의 장점
 *  - 서블릿보다 쉽고, 빠르게 작성이 가능하다.
 *  - 디자인부분과 로직부분을 분리시킬 수 있다.
 *  - 자바의 기능을 사용할 수 있다.
 *  - 사용자가 만든 서블릿보다 좀더 최적화된 서블릿을 생성 시켜준다.
 * 
 * JSP의 실행 순서
 *  JSP -> Servlet 변환 -> 컴파일 -> 실행
 *   E:\조준현\jspstudy\.metadata\.plugins\org.eclipse.wst.server.core\tmp0 -> 더미서버 폴더
 *   E:\조준현\jspstudy\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps 에 프로젝트가 복사되어 실행된다.
 *   E:\조준현\jspstudy\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work 에 jsp파일을 servlet 으로 변환하고 java로 컴파일하여 실행한 파일이 저장.
 *   
 *   
 * JSP 의 구성요소
 *  1. 디렉티브(Directive)
 *      - 설정 정보를 지정할때 사용 <%@로 시작을 한다.
 *        ㄱ. page - JSP 페이지에 대한 정보를 지정한다. JSP가 생성하는 문서의 타입,
 *                   출력 버퍼의 크기, 에러 페이지 등 JSP 페이지에서 필요로 하는 정보를 입력한다.
 *                   * page 디렉티브 속성
 *                    A. language - JSP 스트립트 코드에서 사용되는 프로그래밍 언어를 지정한다. ex) "java"
 *                    B. contentType - JSP가 생성할 문서의 타입을 지정한다. ex) "text/html"
 *                    C. import - JSP 페이지에서 사용할 자바 클래스를 지정한다.
 *                    D. session - JSP 페이지가 세션을 사용할지의 여부를 지정한다. (임시 저장공간) ex)"true"
 *                    E. buffer - JSP 페이지의 출력 버퍼 크기를 지정한다. ex) "none" "8kb"
 *                    F. autoFlush - 출력 버퍼가 다 찼을 경우 자동으로 버퍼에 있는 데이터를 출력 스트림에 보내고
 *                                   비울지의 여부를 나타낸다. ex) "true"일 경우 보내고 비우며 "false"일경우 에러 발생
 *                    G. info - JSP 페이지에 대한 설명을 입력한다.
 *                    H. errorPage - JSP 페이지를 실행하는 도중에 에러가 발생할 때 보여줄 페이지를 지정한다.
 *                    I. isErrorPage - 현재 페이지가 에러가 발생할 때 보여지는 페이지인지의 여부를 지정한다. ex) "false"
 *                    J. pageEncoding - JSP 페이지 자체의 캐릭터 인코딩을 지정한다.
 *                    K. isELIgnored - "true"일 경우 표현언어를 지원하며, "false"일 경우 표현언어를 지원하지 않는다.
 *                    
 *        ㄴ. taglib - JSP 페이지에서 사용할 태그 라이브러리를 지정한다. ex) jstl
 *        ㄷ. include - JSP 페이지의 특정 영역에 다른 문서를 포함시킨다.
 *  2. 스크립트(Script)
 *  	- 선언부(Declaration) <%!자바코드%> -> 클래스 안에 삽입이 된다. ex) 멤버 변수
 * 		- 스크립트릿(Scriptlet) <%자바코드%> -> service 메소드 안에 삽입이 된다. ex) 지역 변수
 *      - 표현식(Expression) <%=자바코드%> ->    
 *  3. 표현 언어(Expression Language)
 *  4. 기본 객체(implicit object)
 *  5. 정적인 데이터(텍스트 HTML 코드)
 *  6. 액션 태그(Action Tag) -> 서버에서 실행하는 태그
 *  7. 커스텀 태그(Custom Tag) -> 사용자가 반복적으로 사용하는 태그들을 태그로 만든 것
 * 
 * 개발 순서
 *  1. 정보에 대한 수집 : 어떤정보를 전할지 결정
 *  2. 레이아웃 설계 : 수집한 정보를 어떤식으로 전달할지 레이아웃을 결정
 *  3. 컨텐츠의 순서 정의 
 *     a. 로그인 | 회원가입
 *     b. 제목
 *     c. 메뉴
 *     d. 사진
 *     e. 하위메뉴 
 *     f. 사이트정보
 *     
 * Request 객체 기본기능
 *  
 *  
 *  
 * 자바빈 (JavaBean)
 *  JavaBean은 데이터를 표현하는 것을 목적으로 하는 자바 클래스로 보통 DTO라는 키워드를 붙여 저장한다.
 *   *DAO (Data Access Object) - 기능 클래스 ( 데이터베이스 연동 기능 )
 *    DTO (Data Transfer Object) - 정보 클래스 ( 카트 )    
 *
 *    
 *   멤버 변수 = Property 
 *   
 *   
 * 쿠키
 *  저장 Step
 *   1. 쿠키 객체 생성 (키, 벨류)
 *   2. 나이를 지정
 *   3. 사용자에게 심기
 *   
 *  불러오기 Step
 *   1. 쿠키들을 가져온다 (배열)
 *   2. 원하는 키를 찾음
 *   3. 키에 해당하는 값을 추출
 *   
 *   
 *   
 *   
 *   
 *   
 *   
 *   
 *   
 *   
 *   
 *   
 *   
 *   
 *   
 *   
 *   
 *   
 *   
 *   
 *   
 */

public class Jsp {
	String str = "java";
	
	public void service2(){
		String str = "jsp";
		System.out.println(str);
		System.out.println(this.str);
	}
	
	public static void main(String[] args){
		
		Jsp s = new Jsp();
		s.service2();
	
	}
}
/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.73
 * Generated at: 2016-12-28 00:47:29 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
//package org.apache.jsp;
//
//import javax.servlet.*;
//import javax.servlet.http.*;
//import javax.servlet.jsp.*;
//
//public final class testC_jsp extends org.apache.jasper.runtime.HttpJspBase
//    implements org.apache.jasper.runtime.JspSourceDependent {
//
//  private static final javax.servlet.jsp.JspFactory _jspxFactory =
//          javax.servlet.jsp.JspFactory.getDefaultFactory();
//
//  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;
//
//  private volatile javax.el.ExpressionFactory _el_expressionfactory;
//  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;
//
//  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
//    return _jspx_dependants;
//  }
//
//  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
//    if (_el_expressionfactory == null) {
//      synchronized (this) {
//        if (_el_expressionfactory == null) {
//          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
//        }
//      }
//    }
//    return _el_expressionfactory;
//  }
//
//  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
//    if (_jsp_instancemanager == null) {
//      synchronized (this) {
//        if (_jsp_instancemanager == null) {
//          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
//        }
//      }
//    }
//    return _jsp_instancemanager;
//  }
//
//  public void _jspInit() {
//  }
//
//  public void _jspDestroy() {
//  }
//
//  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
//        throws java.io.IOException, javax.servlet.ServletException {
//
//    final javax.servlet.jsp.PageContext pageContext;
//    javax.servlet.http.HttpSession session = null;
//    final javax.servlet.ServletContext application;
//    final javax.servlet.ServletConfig config;
//    javax.servlet.jsp.JspWriter out = null;
//    final java.lang.Object page = this;
//    javax.servlet.jsp.JspWriter _jspx_out = null;
//    javax.servlet.jsp.PageContext _jspx_page_context = null;
//
//
//    try {
//      response.setContentType("text/html; charset=UTF-8");
//      pageContext = _jspxFactory.getPageContext(this, request, response,
//      			null, true, 8192, true);
//      _jspx_page_context = pageContext;
//      application = pageContext.getServletContext();
//      config = pageContext.getServletConfig();
//      session = pageContext.getSession();
//      out = pageContext.getOut();
//      _jspx_out = out;
//
//      out.write("\r\n");
//      out.write("<!DOCTYPE html>\r\n");
//      out.write("<html>\r\n");
//      out.write("<head>\r\n");
//      out.write("<meta charset=\"UTF-8\">\r\n");
//      out.write("<title>Insert title here</title>\r\n");
//      out.write("</head>\r\n");
//      out.write("<body>\r\n");
//      out.write("\t<h2>이것은 둘쨋날 만든 jsp 페이지</h2>\r\n");
//      out.write("</body>\r\n");
//      out.write("</html>");
//    } catch (java.lang.Throwable t) {
//      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
//        out = _jspx_out;
//        if (out != null && out.getBufferSize() != 0)
//          try {
//            if (response.isCommitted()) {
//              out.flush();
//            } else {
//              out.clearBuffer();
//            }
//          } catch (java.io.IOException e) {}
//        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
//        else throw new ServletException(t);
//      }
//    } finally {
//      _jspxFactory.releasePageContext(_jspx_page_context);
//    }
//  }
//}

