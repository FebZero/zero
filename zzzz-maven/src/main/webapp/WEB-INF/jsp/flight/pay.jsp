<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%pageContext.setAttribute("p", request.getContextPath()); %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${p}/assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="${p}/assets/css/bootstrapValidator.min.css" />
		<link rel="stylesheet" href="${p}/assets/css/font-awesome.min.css" />
		<!-- ace styles -->
		<link rel="stylesheet" href="${p}/assets/css/ace.min.css" />
		<link rel="stylesheet" href="${p}/assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="${p}/assets/css/ace-skins.min.css" />
		<link rel="stylesheet" href="${p}/assets/select2/select2.css" />
		<style type="text/css">
		.customerdiv{
		display:inline
		}
		</style>
		<script src="${p}/assets/js/jquery-2.0.3.min.js"></script>
		<script src="${p}/assets/js/bootstrap.min.js"></script>
		<script src="${p}/assets/js/dataTables.bootstrap.min.js"></script>
	    <script src="${p}/assets/js/typeahead-bs2.min.js"></script>
	    <script src="${p}/assets/js/jquery.dataTables.min.js"></script>
	    <script src="${p}/assets/js/jquery.dataTables.bootstrap.js"></script>
	    <script src="${p}/assets/js/bootstrapValidator.min.js"></script>
	    <script src="${p}/assets/js/language/zh_CN.js"></script>
        <script src="${p}/assets/js/dataTablesi-i18n-zh_cn.js"></script>
        <script src="${p}/assets/js/jquery.form.min.js"></script>
        <script src="${p}/assets/select2/select2.min.js"></script>
        <script type="text/javascript">
        
        $(function(){
        	var totalPrice = 0;
        	console.log($("#bookingTab tbody tr td").html())
        	$("#bookingTab tbody tr td:last-child").each(function(i,e){
        		console.log($(e).html())
        		totalPrice += parseFloat($(e).html());
        	});
        	//显示总价
        	$("#totalPrice").html("￥"+totalPrice.toFixed(1))
        });
        
        </script>
</head>
<body>
<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>

						<ul class="breadcrumb">
							<li>
								<i class="icon-home home-icon"></i>
								<a href="#">后台管理</a>
							</li>
							<li>
								<a href="#">订票管理</a>
							</li>
							<li class="active">付款</li>
						</ul><!-- .breadcrumb -->
					</div>
     <form class="form-inline" id="bookingForm" action="${p}/booking/add"> 
					<div class="page-content">
						<div class="row">
							<div class="col-xs-12">
								<div class="space-6"></div>
								<div class="row">
									<div class="col-sm-10 col-sm-offset-1">
										<div class="widget-box transparent invoice-box">
											<div class="widget-header widget-header-large">
												<h3 class="grey lighter pull-left position-relative">
													<i class="icon-leaf green"></i>
													确认订单
												</h3>
											</div>
											<div class="widget-body">
												<div class="widget-main padding-24">
													<div class="row">
														<div class="col-sm-12">
															<div class="row">
																<div class="col-sm-11 label label-lg label-info arrowed-in arrowed-right">
																	<b>航班信息</b>
																</div>
															</div>
                                     
															<div class="row">
																<ul class="list-unstyled spaced  bigger-120">
																<li>
																		<i class="icon-caret-right blue"></i>
																		<b class="bigger-120">${biv.fno}</b>
																	</li>
																	<li>
																		<i class="icon-caret-right blue"></i>
																		<b class="bigger-120 blue">${biv.route}</b>
																	</li>
                                                                    <li>
																		<i class="icon-caret-right blue"></i>
																		<b class="blue">${biv.flightType}</b>
																	</li>
																	<li>
																		<i class="icon-caret-right blue"></i>
																		<b class="blue">${biv.fromDate}</b>
																	</li>

																	<li>
																		<i class="icon-caret-right blue"></i>
																		<b class="blue">${biv.toDate}</b>
																	</li>
																	
                                                                     <li>
																		<i class="icon-caret-right blue"></i>
																		<b class="blue">${biv.planeType}</b>
																	</li>
																	<li>
																		<i class="icon-caret-right blue"></i>
																		<b class="blue">${biv.carbinLevel}</b>
																	</li>
																	<li>
																		<i class="icon-caret-right blue"></i>
																		<b class="red bigger-120">${biv.price}</b>
																	</li>
																</ul>
															</div>
													
														</div><!-- /span -->
													     <div class="space"></div>
                                                         <div class="col-sm-12">
															<div class="row">
																<div class="col-sm-11 label label-lg label-success arrowed-in arrowed-right">
																	<b>订单信息</b>
																</div>
															</div>
<div>
														<table class="table table-striped table-bordered" id="bookingTab">
															<thead>
																<tr>
																	<th class="center">#</th>
																	<th>订单编号</th>
																	<th class="hidden-xs">下单时间</th>
																	<th class="hidden-480">乘客姓名</th>
																	<th>乘客证件号</th>
																	<th>乘客VIP</th>
																	<th>折扣后价格</th>
																</tr>
															</thead>

															<tbody>
															<c:forEach items="${blist}" var="bkl" varStatus="s">
																<tr>
																	<td class="center">${s.index+1}</td>
																	<td>
																		<a href="#">${bkl.btno}</a>
																	</td>
																	<td class="hidden-xs">
																		<f:formatDate value="${bkl.bookDate}" 
																		pattern="yyyy-MM-dd HH:mm:ss" />
																	</td>
																	<td class="hidden-480">${bkl.customer.name}</td>
																	<td class="hidden-480">${bkl.customer.cardno}</td>
																	<td class="hidden-480">${bkl.customer.vip}</td>
																	<td>${bkl.price}</td>
																</tr>
                                                           </c:forEach>
															</tbody>
														</table>
													</div>
											</div>
													</div>
													<div class="hr hr8 hr-double hr-dotted"></div>

													<div class="row">
														<div class="col-sm-5 pull-right">
															<h4 class="pull-right">
																总付款 :
																<span class="red bigger-150" id="totalPrice"></span>
															</h4>
														</div>
														<div class="col-sm-7 pull-left"> </div>
													</div>

													<div class="space-6"></div>
													<div class="row">
														<div class="col-sm-5 pull-right">
															<h4 class="pull-right">
															<button class="btn btn-danger btn-lg" type="button" onclick="alert('暂不支持此功能')">支付</button>
															<button class="btn btn-inverse btn-lg" onclick="history.back()">取消</button>
															</h4>
														</div>
														<div class="col-sm-7 pull-left"> </div>
													</div>
												</div>
											</div>		
										</div>
									</div>
								</div>
                              </div>
								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</form>
</body>
</html>