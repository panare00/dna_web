<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.text.*" %>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>DNA - Digital News Analysis </title>
  <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.js"></script> 
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.11.4/jquery-ui.js"></script> 
  <link href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.11.4/jquery-ui.css" rel="stylesheet">
  <!-- Bootstrap core CSS-->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Page level plugin CSS-->
  <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">
  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>    
  <script type="text/javascript">
  	function comma(num){
	    var len, point, str; 
	       
	    num = num + ""; 
	    point = num.length % 3 ;
	    len = num.length; 
	   
	    str = num.substring(0, point); 
	    while (point < len) { 
	        if (str != "") str += ","; 
	        str += num.substring(point, point + 3); 
	        point += 3; 
	    } 	     
	    return str;	 
	}
  </script>        
</head>
<body class="fixed-nav sticky-footer bg-dark" id="page-top">
<!-- Navigation-->
<jsp:include page="include/navigation.jsp" flush="false"/>
<div class="content-wrapper">
    <div class="container-fluid">
	<form action="report_view.do" method="get">
	  <ol class="breadcrumb">      	
      	<li class="h4 mb-0 text-alert">디지털뉴스 일일보고</li>
      	<li class="col-md-6 text-right"><input type="text" id="dt" name="dt" class="from-control" value=${ref_date} style="width:100px"><button type="submit" id="submit" value="Submit">조회</button>&nbsp;&nbsp;(지표 : 어제 기준)</li>    
      </ol>
	  <script type="text/javascript">
		$( "#dt" ).datepicker({
	         showButtonPanel: true, 
	         currentText: '오늘 날짜', 
	         closeText: '닫기', 
	         dateFormat: "yy-mm-dd",
	         showButtonPanel: true
		});
	  </script>	  
	  </form>
      <!-- Icon Cards-->
      <div class="row">
        <div class="col-lg-8">
          <!-- Example Area Chart Card-->
          <div class="card mb-3">
            <div class="card-header">
              <i class="fa fa-bar-chart"></i> 홈페이지 페이지뷰 </div>
            <div class="card-body">
              <div class="row">
                <div class="col-sm-4 text-center my-auto">                
                  <div class="small text-muted">Total</div>
                  <div class="h4 mb-0 text-primary"><fmt:formatNumber value="${homepagePv_view[0].total}" pattern="#,###" /></div>
                  <!-- <hr> -->
                  <div class="small text-muted">Mobile</div>
                  <div class="h4 mb-0 text-alert"> <fmt:formatNumber value="${homepagePv_view[0].mo}" pattern="#,###" /></div>
                  <!-- <hr> -->
                  <div class="small text-muted">PC</div>
                  <div class="h4 mb-0 text-warning"><fmt:formatNumber value="${homepagePv_view[0].pc}" pattern="#,###" /></div>
                  <!-- <hr> -->
                  <div class="small text-muted">APP</div>
                  <div class="h4 mb-0 text-success"><fmt:formatNumber value="${homepagePv_view[0].app}" pattern="#,###" /></div>                                     
                </div>
                
                <div class="col-sm-8 my-auto">
                <!--  그래프 자바스크립트  -->
				<script type="text/javascript">
				      google.charts.load('current', {'packages':['corechart']});
				      google.charts.setOnLoadCallback(drawChart);				
				      function drawChart() {				    	  
				        var data = google.visualization.arrayToDataTable([
				          ['date', 'Total', 'Mobile' , 'PC', 'APP'],
				          ['${homepagePv_view[6].dt}'.replace('2018-','').replace('-','/'),  ${homepagePv_view[6].total}, ${homepagePv_view[6].mo}, ${homepagePv_view[6].pc},${homepagePv_view[6].app}],
				          ['${homepagePv_view[5].dt}'.replace('2018-','').replace('-','/'),  ${homepagePv_view[5].total}, ${homepagePv_view[5].mo}, ${homepagePv_view[5].pc},${homepagePv_view[5].app}],
				          ['${homepagePv_view[4].dt}'.replace('2018-','').replace('-','/'),  ${homepagePv_view[4].total}, ${homepagePv_view[4].mo}, ${homepagePv_view[4].pc},${homepagePv_view[4].app}],
				          ['${homepagePv_view[3].dt}'.replace('2018-','').replace('-','/'),  ${homepagePv_view[3].total}, ${homepagePv_view[3].mo}, ${homepagePv_view[3].pc},${homepagePv_view[3].app}],
				          ['${homepagePv_view[2].dt}'.replace('2018-','').replace('-','/'),  ${homepagePv_view[2].total}, ${homepagePv_view[2].mo}, ${homepagePv_view[2].pc},${homepagePv_view[2].app}],
				          ['${homepagePv_view[1].dt}'.replace('2018-','').replace('-','/'),  ${homepagePv_view[1].total}, ${homepagePv_view[1].mo}, ${homepagePv_view[1].pc},${homepagePv_view[1].app}],
				          ['${homepagePv_view[0].dt}'.replace('2018-','').replace('-','/'),  ${homepagePv_view[0].total}, ${homepagePv_view[0].mo}, ${homepagePv_view[0].pc},${homepagePv_view[0].app}]
				        ]);
				
				        var options = {
				          title: '추이',
				          curveType: 'function',
				          legend: { position: 'bottom' }
				        };
				
				        var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));
				        chart.draw(data, options);
				      }
				    </script>
                  <div id="curve_chart" style="width: 100%; height: 50"></div>
                </div>                
              </div>
            </div>
            <!-- <div class="card-footer small text-muted">기준 : ${homepagePv_view[0].dt}</div>  -->
          </div>          
        </div>
      </div>
      <!-- 홈페이지 주요 기사-->
      <div class="card mb-3">
        <div class="card-header">
          <i class="fa fa-table"></i> 홈페이지 인기 기사</div>
        <div class="card-body">
          <div class="table-responsive">
             <table class="table table-bordered" width="100%" cellspacing="0">
              <thead>
                <tr>
                  <th class="text-center">기사</th>
                  <th class="text-center">출처</th>
                  <th class="text-center">기자</th>
                  <th class="text-center">페이지뷰</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach items="${homepageArticle_view}" var="dto">
                <tr>                  
                  <td><a href="${dto.url}" target="_blank">${dto.newsTitle}</a></td>
                  <td class="text-center">${dto.positionName}</td>
                  <td class="text-center">${dto.reporterName}</td>
                  <td class="text-center"><fmt:formatNumber value="${dto.totalViews}" pattern="#,###" /></td>                  
                </tr>
                </c:forEach>	                
              </tbody>
            </table>
          </div>
        </div>        
      </div>
      <!-- 네이버 주요 기사-->
      <div class="card mb-3">
        <div class="card-header">
          <i class="fa fa-table"></i> 네이버 인기 기사</div>
        <div class="card-body">
          <div class="table-responsive">
            <table class="table table-bordered" width="100%" cellspacing="0">
              <thead>
                <tr>
                  <th class="text-center">기사</th>
                  <th class="text-center">조회수</th>
                  <th class="text-center">기자</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach items="${naverNews_view}" var="naverNewsdto">
                <tr>                  
                  <td><a href="${naverNewsdto.url}" target="_blank">${naverNewsdto.title}</a></td>
                  <td class="text-center"><fmt:formatNumber value="${naverNewsdto.pv}" pattern="#,###" /></td>
                  <td class="text-center">${naverNewsdto.reporter}</td>                  
                </tr>
                </c:forEach>	                
              </tbody>
            </table>
          </div>
        </div>        
      </div>
      <!-- daum 주요 기사-->
      <div class="card mb-3">
        <div class="card-header">
          <i class="fa fa-table"></i> 다음 인기 기사</div>
        <div class="card-body">
          <div class="table-responsive">
            <table class="table table-bordered" width="100%" cellspacing="0">
              <thead>
                <tr>
                  <th class="text-center">기사</th>
                  <th class="text-center">조회수</th>
                  <th class="text-center">기자</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach items="${daumNews_view}" var="daumNewsdto">
                <tr>                  
                  <td><a href="${daumNewsdto.url}" target="_blank">${daumNewsdto.title}</a></td>
                  <td class="text-center"><fmt:formatNumber value="${daumNewsdto.pv}" pattern="#,###" /></td>
                  <td class="text-center">${daumNewsdto.reporter}</td>                  
                </tr>
                </c:forEach>	                
              </tbody>
            </table>
          </div>
        </div>        
      </div>
      <!-- 페이스북 주요 기사-->
      <div class="card mb-3">
        <div class="card-header">
          <i class="fa fa-table"></i> 페이스북 인기 기사</div>
        <div class="card-body">
          <div class="table-responsive">
            <table class="table table-bordered" width="100%" cellspacing="0">
              <thead>
                <tr>
                  <th class="text-center">기사</th>
                  <th class="text-center">타입</th>
                  <th class="text-center">도달</th>
                  <th class="text-center">공감</th>
                  <th class="text-center">공유</th>                  
                </tr>
              </thead>
              <tbody>
                <c:forEach items="${facebookArticle_view}" var="dto">
                <tr>                  
                  <td><a href="${dto.url}" target="_blank">${dto.title}</a></td>
                  <td class="text-center">${dto.type}</td>
                  <td class="text-center"><fmt:formatNumber value="${dto.reach}" pattern="#,###" /></td>
                  <td class="text-center"><fmt:formatNumber value="${dto.reaction}" pattern="#,###" /></td>
                  <td class="text-center"><fmt:formatNumber value="${dto.share}" pattern="#,###" /></td>                                                      
                </tr>
                </c:forEach>	                
              </tbody>
            </table>
          </div>
        </div>        
      </div>
      <!-- 유튜브 주요 기사-->
      <div class="card mb-3">
        <div class="card-header">
          <i class="fa fa-table"></i> 유튜브 인기 기사</div>
        <div class="card-body">
          <div class="table-responsive">
            <table class="table table-bordered" width="100%" cellspacing="0">
              <thead>
                <tr>
                  <th class="text-center">기사</th>
                  <th class="text-center">조회수</th>
                  <th class="text-center">좋아요</th>
                  <th class="text-center">댓글</th>                  
                </tr>
              </thead>
              <tbody>
                <c:forEach items="${youtubeArticle_view}" var="youtube_dto">
                <tr>                  
                  <td><a href="${youtube_dto.url}" target="_blank">${youtube_dto.title}</a></td>                  
                  <td class="text-center"><fmt:formatNumber value="${youtube_dto.viewCount}" pattern="#,###" /></td>
                  <td class="text-center"><fmt:formatNumber value="${youtube_dto.likeCount}" pattern="#,###" /></td>
                  <td class="text-center"><fmt:formatNumber value="${youtube_dto.commentCount}" pattern="#,###" /></td>                  
                </tr>
                </c:forEach>	                
              </tbody>
            </table>
          </div>
        </div>        
      </div>
      <!-- 회의자료 -->
      <div class="card mb-3">
        <div class="card-header">
          <i class="fa fa-table"></i> 디지털 회의 자료</div>
        <div class="card-body">
          <div class="table-responsive">
            <table class="table table-bordered" width="100%" cellspacing="0">
              <tbody>
                <tr>                  
                  <td class="text-center">디지털 관심 아이템</td>
                  <td>${briefReport_view.interestReport}</td>
                </tr>
                <tr>
				  <td class="text-center"> 디지털 출고 기사 </td>
				  <td> ${briefReport_view.digitalReport}</td>
				</tr>                				                	                
              </tbody>
            </table>
          </div>
        </div>        
      </div>
    </div>
	<!-- footer -->
	<jsp:include page="include/footer.jsp" flush="false"/>
    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
    <!-- Page level plugin JavaScript-->
    <script src="vendor/chart.js/Chart.min.js"></script>
    <script src="vendor/datatables/jquery.dataTables.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.js"></script>
    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin.min.js"></script>
    <!-- Custom scripts for this page-->
    <script src="js/sb-admin-datatables.min.js"></script>
    <script src="js/sb-admin-charts.min.js"></script>
  </div>
</body>
</html>