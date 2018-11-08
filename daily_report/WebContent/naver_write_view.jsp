<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>DNA - Digital News Analysis </title>
  <!-- Bootstrap core CSS-->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Page level plugin CSS-->
  <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">
  <script type="text/javascript">
  	// 입력폼 숫자 자동 변환 
  	function onlyNumber(obj) {
	    $(obj).keyup(function(){
	         $(this).val($(this).val().replace(/[^0-9]/g,""));
	    }); 
	}  
  </script>
</head>
<body class="fixed-nav sticky-footer bg-dark" id="page-top">
<!-- Navigation-->
<jsp:include page="include/navigation.jsp" flush="false"/>
<div class="content-wrapper">
    <div class="container-fluid">
    	<div class="card">
		  <div class="card-header">주의 사항</div>
		  <div class="card-body">
		    <li class="card-title">디지털뉴스 담당자 입력 전용</li>
		    <li class="card-title">입력 개수 : 평일 5개(월요일 보고 3개씩)</li>
		    <li class="card-title">첫번째 줄에는 '전체PV'를 입력해주세요.</li>		    		    
		    <li class="card-title">네이버 통계툴 : <a href="https://friend.navercorp.com" target="__blank">https://friend.navercorp.com</a>&nbsp;&nbsp;(메뉴 : 콘텐츠 통계 > 기사순위 > 기사PV순위)</li>
		  </div>
		</div>      
      <!-- Example DataTables Card-->
      <div class="card mb-3">
        <div class="card-header">
          <i class="fa fa-table"></i> 네이버 인기 기사 입력</div>
        <div class="card-body">
          <div class="table-responsive">            
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
				<form action="naver_write.do" method="post">
					<thead>
                		<tr>
                		  <th style="width:10%">업로드 날짜<br/>(yyyy-mm-dd)</th>
		                  <th>제목</th>
		                  <th style="width:10%">PV</th>
		                  <th style="width:10%">URL</th>
		                  <th style="width:10%">기자 명</th>		                  
		                </tr>
		              </thead>
		              <tbody>
		            <% 
		              	for(int i = 1;i <= 6 ; i++){		              
		            %>		              	
		              	<tr>
		              		<td><input type="text" name="dt" rows="10" style="width:100%" /></td>							
							<td><input type="text" name="title" rows="10" style="width:100%" /></td>
							<td><input type="text" name="pv" rows="10" style="width:100%" onkeydown="onlyNumber(this)" /></td>
							<td><input type="text" name="url" rows="10" style="width:100%" /></td>
							<td><input type="text" name="reporter" rows="10" style="width:100%" /></td>					
						</tr>
					<% 
						} 
					%>	
						<tr>
							<td> 
								<input type="submit" class="btn btn-primary btn-block" value="입력" style="width:100%">
							</td>
							<td>	 
								<a class="btn btn-primary" href="naver_list.do" role="button">목록</a>								
							</td>
						</tr>
					</tbody>	
				</form>
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