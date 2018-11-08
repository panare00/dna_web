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
  <script type="text/javascript" class="init">
  $(document).ready(function() {
	    $('#list-table').DataTable( {
	        "order": [[ 0, "desc" ]]
	    } );
	} );  
  </script>
</head>
<body class="fixed-nav sticky-footer bg-dark" id="page-top">
<!-- Navigation-->
<jsp:include page="include/navigation.jsp" flush="false"/>
<div class="content-wrapper">
    <div class="container-fluid">
      <!-- Breadcrumbs-->
      <ol class="breadcrumb">
        <li class="breadcrumb-item active"> <a href="write_view.do?dt=${dto.dt}"> 일일보고 입력하기(디지털뉴스 주간,팀장 전용)</a> </li>
      </ol>
      <!-- Example DataTables Card-->
      <div class="card mb-3">
        <div class="card-header">
          <i class="fa fa-table"></i> 회의자료 리스트 </div>
        <div class="card-body">
          <div class="table-responsive">            
            <table id="list-table" class="table table-bordered" width="100%" cellspacing="0">
              <thead>
                <tr>
                  <th class="text-center">날짜</th>
                  <th class="text-center">링크</th>                  
                </tr>
              </thead>
              <tbody>
                <c:forEach items="${list}" var="dto">
                <tr>                  
                  <td class="text-center">${dto.dt}</td>
				  <td class="text-center"><a href="content_view.do?dt=${dto.dt}">상세내용/수정/삭제</a></td>			                  
                </tr>
                </c:forEach>	                
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