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
        var onePrice = parseFloat('${f.fcList[0].price}');
        var totalPrice = parseFloat('${f.fcList[0].price}');
        //删除一个乘客信息
        function delone(btn){
        	$(btn).parent().remove();
        	totalPrice -= onePrice;
        	//toFixed(1)四舍五入保留一位小数
    		$("#totalPrice").html("￥"+totalPrice.toFixed(1));
        }
       
        $(function(){
        	$("#addBtn").click(function(){
        		var copy = $("#bookingForm div.customerdiv:first").clone();
        		copy.append('<button type="button" style="border-style:none" onclick="delone(this)" class="btn btn-white btn-sm">'+
			             '<span style="color:red">X</span></button>');
        		copy.css("display","block");
        		copy.find(":text").val("");
        		$("#customerDiv").append(copy);
        		totalPrice += onePrice;
        		$("#totalPrice").html("￥"+totalPrice.toFixed(1));
        	});
        	
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
							<li class="active">下单</li>
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
													填写订单
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
																		<b class="bigger-120">${f.fno}</b>
																		<input type="hidden" name="fno" value="${f.fno}">
																	</li>
																	<li>
																		<i class="icon-caret-right blue"></i>
																		<b class="bigger-120 blue">${f.route.fromCity}(始)-${f.route.toCity}(终)</b>
																		<input type="hidden" name="route" value="${f.route.fromCity}(始)-${f.route.toCity}(终)">
																	</li>
                                                                    <li>
																		<i class="icon-caret-right blue"></i>
																		<b class="blue">${f.type}</b>
																		<input type="hidden" name="flightType" value="${f.type}">
																	</li>
																	<li>
																		<i class="icon-caret-right blue"></i>
																		<b class="blue"><f:formatDate value="${f.fromDate}" 
																		pattern="yyyy-MM-dd HH:mm" /> 出发</b>
																		<input type="hidden" name="fromDate" value="<f:formatDate value="${f.fromDate}" 
																		pattern="yyyy-MM-dd HH:mm" /> 出发">
																	</li>

																	<li>
																		<i class="icon-caret-right blue"></i>
																		<b class="blue"><f:formatDate value="${f.toDate}" 
																		pattern="yyyy-MM-dd HH:mm" /> 到达</b>
																		<input type="hidden" name="toDate" value="<f:formatDate value="${f.toDate}" 
																		pattern="yyyy-MM-dd HH:mm" /> 到达">
																	</li>
																	
                                                                     <li>
																		<i class="icon-caret-right blue"></i>
																		<b class="blue">${f.plane.type}</b>
																		<input type="hidden" name="planeType" value="${f.plane.type}">
																	</li>
																	<li>
																		<i class="icon-caret-right blue"></i>
																		<b class="blue">${f.fcList[0].carbinLevel.name}</b>
																		<input type="hidden" name="carbinLevel" value="${f.fcList[0].carbinLevel.name}">
																	</li>
																	<li>
																		<i class="icon-caret-right blue"></i>
																		<b class="blue">剩余座位:${f.fcList[0].seats}</b>
																	</li>
																	<li>
																		<i class="icon-caret-right blue"></i>
																		<b class="red bigger-120">￥${f.fcList[0].price}</b>
																		<input type="hidden" name="price" value="￥${f.fcList[0].price}">
																	</li>
																</ul>
															</div>
													
														</div><!-- /span -->
													     <div class="space"></div>
                                                         <div class="col-sm-12">
															<div class="row">
																<div class="col-sm-11 label label-lg label-success arrowed-in arrowed-right">
																	<b>乘客信息</b>
																</div>
															</div>

												<div class="widget-body">
												    <div class="widget-main" id="customerDiv">
													
													<input type="hidden" name="fid" value="${f.id}">
													<input type="hidden" name="clid" value="${f.fcList[0].carbinLevel.id}">
													 <div class="customerdiv">
														<label class="inline">
															<span class="lbl">姓名:</span>
														</label>
														<input type="text" id="name" name="name" class="input-medium" required="required"/>
														<label class="inline">
															<span class="lbl">身份证号:</span>
														</label>
														<input type="text" id="idcard"  name="idcard" class="input-xlarge" 
														required="required"/>
													 </div>
													    <button type="button" class="btn btn-primary btn-sm" id="addBtn">
													             继续添加
													    </button>
													
												</div>
											</div>
													</div>
													<div class="hr hr8 hr-double hr-dotted"></div>

													<div class="row">
														<div class="col-sm-5 pull-right">
															<h4 class="pull-right">
																预计支付 :
																<span class="red bigger-150" id="totalPrice">￥${f.fcList[0].price}</span>
															</h4>
														</div>
														<div class="col-sm-7 pull-left"> </div>
													</div>

													<div class="space-6"></div>
													<div class="row">
														<div class="col-sm-5 pull-right">
															<h4 class="pull-right">
															<button class="btn btn-danger btn-lg" form="bookingForm">下单	</button>
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
					</div><!-- /.page-content -->
					</form>
</body>
</html>