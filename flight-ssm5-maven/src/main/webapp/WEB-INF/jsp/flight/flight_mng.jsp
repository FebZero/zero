<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%pageContext.setAttribute("p", request.getContextPath()); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
		<title>Java-Bootstrap后台管理系统</title>
		<meta name="keywords" content="Bootstrap模版,Bootstrap模版下载,Bootstrap教程,Bootstrap中文" />
		<meta name="description" content="站长素材提供Bootstrap模版,Bootstrap教程,Bootstrap中文翻译等相关Bootstrap插件下载" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<!-- basic styles -->
		<link href="${p}/assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="${p}/assets/css/bootstrapValidator.min.css" />
		<link rel="stylesheet" href="${p}/assets/css/font-awesome.min.css" />
		<!-- ace styles -->
		<link rel="stylesheet" href="${p}/assets/css/ace.min.css" />
		<link rel="stylesheet" href="${p}/assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="${p}/assets/css/ace-skins.min.css" />
		<link rel="stylesheet" href="${p}/assets/select2/select2.css" />
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
var oldFno;
var oldFromDate;
//点击修改按钮后
function edit(id) {
    $.getJSON("${p}/flight/detail",{"id":id},function(flight){
    	console.log(flight)
    	op = "mod";
        $("#id").val(flight.id)
        $("#fno").val(flight.fno);
        oldFno = flight.fno;
        $("#fromDate").val(flight.fromDate);
        oldFromDate = flight.fromDate;
        $("#toDate").val(flight.toDate);
        $("#jingjiseat").val(flight.fcList[0].seats);
        $("#jingjiprice").val(flight.fcList[0].price);
        //让select2下拉框插件选中某个值
       var routeSel =  $("#routeId").select2();
       routeSel.val(flight.route.id).trigger("change");
       var planeSel =  $("#planeId").select2();
       planeSel.val(flight.plane.id).trigger("change");
       
        if(flight.fcList[1]){
        	 $("#shangwuseat").val(flight.fcList[1].seats);
             $("#shangwuprice").val(flight.fcList[1].price);
        }
        if(flight.fcList[2]){
       	 $("#toudengseat").val(flight.fcList[2].seats);
            $("#toudengprice").val(flight.fcList[2].price);
       }
        if(flight.type=="单程")
            $(":radio[value='单程']").prop("checked",true);
        else
        	$(":radio[value='往返']").prop("checked",false);
        //打开修改窗口
        $("#myModal").modal("show");
    })
}

//删除一个
function del(id) {
	var r = confirm("您确定删除吗?");
	if(!r)
		return;
    $.ajax({
        url: "${p}/flight/del",
        data: {
            "id": id
        }, success: function (data) {
        	$("#alertdiv").html('<div id="myAlert" class="alert alert-success" align="center" id="successdiv" >\
    				<a href="#" class="close" data-dismiss="alert">&times;</a>\
    				<strong class="bigger-220">'+data.info+'</strong>\
    			</div>');
        	oTable1.ajax.reload();
      	    $("#infoModal").modal("show");
        }
    });
}
//群删
function delMany(idArr) {
	var r = confirm("您确定删除这些数据吗？");
	if(!r)
		return;
    $.ajax({
        url: "${p}/flight/del?"+idArr.join("&"),
        success: function (data) {
        	$("#alertdiv").html('<div id="myAlert" class="alert alert-success" align="center" id="successdiv" >\
    				<a href="#" class="close" data-dismiss="alert">&times;</a>\
    				<strong class="bigger-220">'+data.info+'</strong>\
    			</div>');
        	oTable1.ajax.reload();
        	 $("#infoModal").modal("show");
        }
    });
}
//订票
function order(fid,clid){
	location = '${p}/booking/pre?fid='+fid+"&clid="+clid;
}

//生成展开的详细信息表格
function detail(a) {
	  var tr = $(a).parent().parent();
	  var row = oTable1.row(tr);
	  console.log("data="+row.data())
	  if ( row.child.isShown() ) {
            //隐藏表格
            row.child.hide();
            tr.removeClass('shown');
        }
        else {
            //绘制表格
            row.child(function(){
            	var innerTable = '<table  class="table table-striped table-bordered table-hover ">';
            	$.each(row.data().fcList,function(i,e){
            		console.log(e)
            		//不显示价格为0的舱位
            		if(e.price > 0){
            		innerTable += '<tr><th class="text-info text-center bigger-160">'+
                    e.carbinLevel.name+'</th><td class="text-danger bigger-160">'+
            		'￥'+e.price+'</td><td class="text-dark  bigger-120">剩余座位数:'+e.seats+
            		'</td><td><a href="#" class="btn btn-app btn-yellow btn-xs" ';
            		//如果没有座位，则让预订按钮失效
            		if(e.seats <= 0){
            		 	innerTable += "disabled=disabled";
            		}
            		innerTable += 'onclick="order(\''+
        					row.data().id+'\',\''+e.carbinLevel.id+'\')">'+
        					'<i class="icon-shopping-cart bigger-160"></i>预订</a></td></tr>';
            		}
            	})
            	innerTable +='<tr><td>客机编号:</td><td>'+row.data().plane.planeno+
            	'</td><td>机型:</td><td>'+row.data().plane.type+'</td></tr>'+
            '<tr><td>客机购买时间:</td><td>'+row.data().plane.buyDate+'</td>'+
            '<td>客机服务时间:</td><td>'+row.data().plane.serviceDate+'</td></tr></table>';
            	return innerTable;
            }).show();
            tr.addClass('shown');
        }
			}

//表格
var oTable1;
//修改前的课程编号
var oldCnoVal;
//操作类型
var op = "add";
$(function(){
	$("#shangwudiv").hide();
	$("#toudengdiv").hide();
	$("#queryBtn").click(function(){
		var fromCity = $("#queryFromCity").val();
		var toCity = $("#queryToCity").val();
		var fromDate = $("#queryFromDate").val();
		if(oTable1){
			var param = {
			        "fromCity": fromCity,
			        "toCity": toCity,
			        "fromDate":fromDate
			    };
			//封装参数
			oTable1.settings()[0].ajax.data = param;
			//重新加载
			oTable1.ajax.reload();
			return;
		}

		//绘制Datatable
		oTable1 = $('#sample-table-2').DataTable({
		"processing": true,
        "serverSide": true,//启用服务端处理
        "searching": false,//取消搜索框
        "paging":   true,//分页
        "ordering": true,//排序
        "bInfo": false,//不显示左下角的记录数
       // "pagingType":   "full_numbers",
		 ajax:{
			 "url":'${p}/flight/query',
			 //post方式提交参数
			 "data": {
				 //这里不能用route.fromCity做参数名，因此也无法利用spring自动封装pojo
		            "fromCity": fromCity,
		            "toCity": toCity,
		            "fromDate":fromDate
		        }
		 },
		 //column数量一定要和表格实际的列数一致，否则无法发送ajax请求
		 columns: [
			{"data": null,"sortable":false},
          //  {"data": "id"},
            {"data": "fno"},
            {"data": "type"},
            {"data": "route.fromCity"},
            {"data": "route.toCity"},
            {"data": "fromDate"},
            {"data": "toDate"},
            {"data": null,"sortable":false}
        ],
        lengthMenu:[10,15,20],
        columnDefs: [
        	{
                targets: 0,//设置第一列
                render: function (data, type, row, meta) {
                    var html = '<div class="center"><label><input type="checkbox" class="ace" name="id" value="'+row.id+'"/>\
							<span class="lbl"></span></label></div>'
                 return html;
                }
            },
            {
                targets: 5,//设置第6列
                render: function (data, type, row, meta) {
                 return data.replace('T',' ');//日期去掉T
                }
            },
            {
                targets: 6,//设置第7列
                render: function (data, type, row, meta) {
                 return data.replace('T',' ');//日期去掉T
                }
            },
            {
                targets: 7,//设置第8列
                render: function (data, type, row, meta) {
                    var html ='<a class="blue" href="#" onclick="detail(this)">'+
					               '<i class="icon-zoom-in bigger-130"></i></a> '+ 
                    	      '<a class="green" href="#" onclick="edit(\''+row.id+'\')">'+
							       '<i class="icon-pencil bigger-130"></i></a> '+
						      '<a class="red" href="#" onclick="del(\''+row.id+'\')"><i class="icon-trash bigger-130"></i></a>';
                    return html;
                }
            }

        ],
        "language": i18n_cn,
        /* "dom": "<'row'<'col-xs-2'l><'#mytool.col-xs-4'><'col-xs-6'f>r>t\
        <'row'<'col-xs-6'i><'col-xs-6'p>>", */
      /*   "dom": '<"toolbar">frtip', */
        "dom":'Bflrtip',
        //初始化完毕后
        initComplete: function () {
	
}
	});
	
	});
	
	//点击大的删除按钮
	$("#delBtn").on("click",function(){
		var checkedCheckbox = $(":checkbox[name='id']:checked")
		
		if(checkedCheckbox.size()==0){
			alert("请至少选择一条数据");
			return;
		}
	
		var idArr =[];
		
		checkedCheckbox.each(function(i,box){
			idArr.push("id="+box.value);
		});
		delMany(idArr);
	}); 
	
	//复选框全选
	$('table th input:checkbox').on('click' , function(){
		var that = this;
		$(this).closest('table').find('tr > td:first-child input:checkbox')
		.each(function(){
			this.checked = that.checked;
			$(this).closest('tr').toggleClass('selected');
		});
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
								<a href="#">航班信息管理</a>
							</li>
							<!-- <li class="active">Simple &amp; Dynamic</li> -->
						</ul><!-- .breadcrumb -->


	                    <div class="row">
									<div class="col-xs-12">
											<div class="col-sm-12">
										<div class="widget-box">
											<div class="widget-header">
												<h4>航班信息查询</h4>
											</div>

											<div class="widget-body">
												<div class="widget-main">
													<form class="form-inline" id="queryForm"> 
														<label class="inline">
															<span class="lbl">出发城市:</span>
														</label>
														<input type="text" id="queryFromCity" name="route.fromCity" class="input-small" placeholder="" />
														<label class="inline">
															<span class="lbl">到达城市:</span>
														</label>
														<input type="text" id="queryToCity"   name="route.toCity" class="input-small" placeholder="" />
														<label class="inline">
															<span class="lbl">出发日期:</span>
														</label>
														<input type="date" id="queryFromDate" name="fromDate" class="input-big" />
             
														<button type="button" class="btn btn-info btn-sm" id="queryBtn">
															<i class="icon-key bigger-110"></i>
															查询
														</button>
													    <label class="inline col-sm-offset-2">
														</label>
														<!-- 点击新增按钮后 会自动展开模式窗口 -->
														<button class="btn btn-sm btn-success" type="button" 
       			                                          id="addBtn" data-toggle="modal" data-target="#myModal">新增航班</button>
       		                                            <button class="btn  btn-sm btn-pink" type="button" id="delBtn">删除航班</button>
													</form>
												</div>
											</div>
										</div>
                                    </div>


								<div class="row">
									<div class="col-xs-12">
										<!-- <h3 class="header smaller lighter blue">jQuery dataTables</h3> -->
										<div class="table-header">
											航班信息表
										</div>

										<div class="table-responsive">
										<form action="" method="post" id="delForm">
											<table id="sample-table-2" class="table table-striped table-bordered table-hover">
												<thead>
													<tr>
														<th>
														<div  class="center">
															<label>
																<input type="checkbox" class="ace" />
																<span class="lbl"></span>
															</label>
															</div>
														</th>
														<th>航班编号</th>
														<th>航班类型</th>
														<th>出发城市</th>
														<th>到达城市</th>
														<th>出发时间</th>
														<th>到达时间</th>
														<th></th>
													</tr>
												</thead>
                                               
												<tbody>
												
												</tbody>
											</table>
											</form>
										</div>
									</div>
								</div>
							</div><!-- /.col -->
                    </div>
                    </div>
		<!--
		 tabindex="-1" 会引起冲突 造成第三方插件select2出现异常
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"-->
		<div class="modal fade" id="myModal"  role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content" >
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">新增航班</h4>
					</div>
						
					<form id="modelForm" class="form-horizontal" method="post">
					<div class="modal-body">
						<input type="hidden" id="id" name="id">
						<div class="form-group">
							<label for="fno" class="col-sm-3 control-label"> 航班编号: </label>
							<div class="col-sm-7">
							<input type="text" name="fno" id="fno" class="form-control" 
											required="required"  placeholder="必填"/>
							</div>
						</div>
						<div class="form-group">
							<label for="fno" class="col-sm-3 control-label"> 航班类型: </label>
							<div class="col-sm-7">
							<div class="radio">
								<label>
									<input name="type" value="单程" type="radio" class="ace" checked="checked"/>
									<span class="lbl"> 单程</span>
								</label>
								<label>
									<input name="type" value="往返" type="radio" class="ace" />
									<span class="lbl"> 往返</span>
								</label>
							 </div>
							</div>
						</div>
					    <div class="form-group">
						  <label for="routeId" class="col-sm-3 control-label"> 航线: </label>
							<div class="col-sm-7">
							  <select class="select2" name="routeId" id="routeId" style="width: 100%;">
							  <option value="0" selected="selected">请选择</option>
                             </select>
                             </div>
                         </div>  
						<div class="form-group">
						<label for="text" class="col-sm-3 control-label">出发时间: </label>
							<div class="col-sm-7">
							<input type="datetime-local" class="form-control" id="fromDate" name="fromDate" required="required">
							</div>
						</div>
					   <div class="form-group">
						<label for="text" class="col-sm-3 control-label">到达时间: </label>
							<div class="col-sm-7">
							<input type="datetime-local" class="form-control" id="toDate" name="toDate" required="required">
							</div>
						</div>
						 <div class="form-group">
						  <label for="planeId" class="col-sm-3 control-label"> 客机: </label>
							<div class="col-sm-7">
							  <select class="select2" name="planeId" id="planeId" style="width: 100%;">
							  <option value="0" selected="selected">请选择</option>
                             </select>
                             </div>
                         </div>  
							<div class="form-group">
							<label for="jingjiseat" class="col-sm-3 control-label">经济舱座位数: </label>
							<div class="col-sm-7">
							<input type="number" name="fcList[0].seats" id="jingjiseat" class="form-control" 
											required="required"  placeholder="必填" min="0"  />
							</div>
						</div>
						<div class="form-group">
							<label for="jingjiprice" class="col-sm-3 control-label">经济舱价格: </label>
							<div class="col-sm-7">
							<input type="number" name="fcList[0].price" id="jingjiprice" class="form-control" 
											required="required"  placeholder="必填" min="0"  />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">
								商务舱<input id="shangwubtn" name="shangwubtn" class="ace ace-switch ace-switch-2" type="checkbox" />
								<span class="lbl"></span>
							</label>
						</div>
						<div id="shangwudiv">
						<div class="form-group">
							<label for="shangwuseat" class="col-sm-3 control-label">商务舱座位数: </label>
							<div class="col-sm-7">
							<input type="number" name="fcList[1].seats" id="shangwuseat" class="form-control" 
											required="required"  placeholder="必填" min="0" value="0" />
							</div>
						</div>
						<div class="form-group">
							<label for="shangwuprice" class="col-sm-3 control-label">商务舱价格: </label>
							<div class="col-sm-7">
							<input type="number" name="fcList[1].price" id="shangwuprice" class="form-control" 
											required="required"  placeholder="必填" min="0" value="0"/>
							</div>
						</div>
						</div>
							<div class="form-group">
							<label class="col-sm-3 control-label">
								头等舱<input id="toudengbtn" name="toudengbtn" class="ace ace-switch ace-switch-2" type="checkbox" />
								<span class="lbl"></span>
							</label>
						    </div>
						<div id="toudengdiv">
						<div class="form-group">
							<label for="toudengseat" class="col-sm-3 control-label">头等舱座位数: </label>
							<div class="col-sm-7">
							<input type="number" name="fcList[2].seats" id="toudengseat" class="form-control" 
											required="required"  placeholder="必填" min="0" value="0"/>
							</div>
						</div>
						<div class="form-group">
							<label for="toudengprice" class="col-sm-3 control-label">头等舱价格: </label>
							<div class="col-sm-7">
							<input type="number" name="fcList[2].price" id="toudengprice" class="form-control" 
											required="required"  placeholder="必填" min="0" value="0"/>
							</div>
						</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary" id="saveBtn">保存</button>
					</div>
					</form>
				</div>
			</div>
		</div>
		<script type="text/javascript">
		//用select2插件生成航线下拉框
		 $.ajax({
         	url: "${p}/route/ajax4select2",
         	dataType:'json',
         	cache:false,
         	success:function(data){
         		console.log(data)
         		 $('#routeId').select2({
                 	 data:data,
                 //	 placeholder:'请选择',//默认文字提示
                	     language: "zh-CN",//汉化
                 	});
         	}
         });
		
		//用select2插件生成飞机下拉框
		 $.ajax({
         	url: "${p}/plane/ajax4select2",
         	dataType:'json',
         	cache:false,
         	success:function(data){
         		//console.log(data)
         		 $('#planeId').select2({
                 	 data:data,
                 //	 placeholder:'请选择',//默认文字提示
                	     language: "zh-CN",//汉化
                 	});
         	}
         });
		
		//商务舱开关
		$("#shangwubtn").click(function(){
			if($("#shangwuseat").val()=="")
				$("#shangwuseat").val("0")
			if($("#shangwuprice").val()=="")
			    $("#shangwuprice").val("0")
			    $("#shangwudiv").slideToggle();
			
		})
		//头等舱开关
        $("#toudengbtn").click(function(){
        	if($("#toudengseat").val()=="")
        	$("#toudengseat").val("0")
        	if($("#toudengprice").val()=="")
		    $("#toudengprice").val("0")
			$("#toudengdiv").slideToggle();
			
		})
		
		    //点击提交按钮
			$("#saveBtn").click(function(){
				//手动触发表单校验
				$("#modelForm").data("bootstrapValidator").validate();
				var flag = $("#modelForm").data("bootstrapValidator").isValid();//获取当前表单验证状态
		        if (!flag) {//验证不通过则不提交表单
		    　            　 return;
		    　　 }
				//提交表单数据
				 var options = {   
					       // target:  '#infodiv',   
					        url: "${p}/flight/"+op,        // 覆盖表单'action'属性   
					        type:      'post',  
					        headers : {"ClientCallMode" : "ajax"}, 
					        dataType:  'json',        // 'xml', 'script', or 'json' (expected server response type)   
					      //  clearForm: true,        // 提交后清空表单
					       // beforeSubmit:  ,  // 提交前
					        success:  function(data,statusText){
					        	if(data.ok){
					        		clearForm();
					        	if(oTable1)
					                	oTable1.ajax.reload();
					        	      $("#alertdiv").html('<div id="myAlert" class="alert alert-success" align="center" id="successdiv" >\
					    				<a href="#" class="close" data-dismiss="alert">&times;</a>\
					    				<strong class="bigger-220">'+data.info+'</strong>\
					    			</div>');
					        	}else{
					        		$("#alertdiv").html('<div id="myAlert" class="alert alert-danger" align="center">\
						    				<a href="#" class="close" data-dismiss="alert">&times;</a>\
						    				<strong class="bigger-220">'+data.info+'</strong>\
						    			</div>');
					        	}
					        	  $("#myModal").modal("hide");
					        	  $("#infoModal").modal();
					        }
					    };   
				     //提交表单
				     $("#modelForm").ajaxSubmit(options);  
				
			});
		
		//加载校验器
		formValidate();
		
		function formValidate(){
		//表单校验
		$('#modelForm').bootstrapValidator({
	        message: '输入不合法',
	        feedbackIcons: {
	         //   valid: 'icon-user',
	           // invalid: 'icon-user',
	          //  validating: 'icon-user'
	        },
	        fields: {
	        	fno: {
	        		    trigger:'blur',//失去焦点校验
		                //   message: 'The username is not valid',
		                validators: {
		                    notEmpty: {
		                    message: '不可为空'
		                    },
		                    stringLength: {
		                        min: 4,
		                        max: 30,
		                        message: '长度必须4-30位'
		                    },
		                    regexp: {
		                        regexp: /^[a-zA-Z0-9_\.]+$/,
		                        message: '必须是字母数字和下划线构成'
		                    },
		                    callback: {
			                    message: '同一天的航班编号不允许重复',
			                	callback: function(value, validator) {
			                		if($('#fromDate').val()==""||value.trim()=="")
			                			return true;
			                		//修改的情况下，如果fno和fromdate没有更改，则校验通过
			                		if(op=="mod"&&value==oldFno&&$('#fromDate').val()==oldFromDate)
			                			return true
			                		var result;
			                		$.ajax({
			                			url:"${p}/flight/checkfno?fno="+value+
			                    		"&fromDate="+$('#fromDate').val(),
			                    		async:false,
			                    		dataType:'json',
			                    		success:function(json){
			                    			result = json.valid;
			                    		}
			                		});
			                		//更新fromDate校验状态为正确
			                		if(result){
			                		 validator.updateStatus('fromDate', 'VALID');
			                		}
			                		//更新fromDate校验状态为不正确，第三个参数为校验器名称
			                		 else{
			                	     validator.updateStatus('fromDate', 'INVALID','callback');	
			                		 }
			                	     return result;
			                	 }
			                 }
		                }
		        	},
		            routeId: {
		                validators: {
		                	greaterThan: {
		                        value:1,
		                        inclusive: true,//是否包含改值
		                        message: '必须选择一条航线'
		                    }
		                }
		            },
		            planeId: {
			                validators: {
			                	greaterThan: {
			                        value:1,
			                        inclusive: true,//是否包含改值
			                        message: '必须选择一架客机'
			                    }
			                }
			            },
		            fromDate: {
		            	trigger:'blur',//失去焦点校验
		              //  message: 'The username is not valid',
		                validators: {
		                    notEmpty: {
		                    message: '出发时间不可为空'
		                    },
		                    /**
		                                               由于这里需要联合两个字段校验，因此用这个方法不合适，改用callback
		                   remote: {
		                    	//ajax验证。server result:{"valid",true or false} 向服务发送当前input name值，获得一个json数据。表示正确：{"valid",true}  
		                         url: '${p}/flight/checkfno',//验证航空编号当天是否重复
		                         message: '该航班当天已存在，请确认航班编号或者该日期是否有误',//提示消息
		                        // threshold : 4,//输入4个字符以后才提交ajax请求
		                         //delay :  1000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置1秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
		                         type: 'GET',//请求方式
		                         //自定义提交数据，默认值提交当前input value
		                           data: function(validator) {
		                               return {
		                                   fno: $("#fno").val(),
		                                   fromDate: $("#fromDate").val()
		                               };
		                            }
		                     }
			                }
		                **/
		                callback: {
		                    message: '同一天的航班编号不允许重复',
		                	callback: function(value, validator) {
		                		//先校验出发时间必须小于到达时间
		                		if($('#toDate').val()!=""&&$('#toDate').val() <= value){
		                			validator.updateStatus("toDate", "INVALID", "callback")
		                		}
		                		else{
		                			validator.updateStatus("toDate", "VALID", "callback")
		                		}
		                		if($('#fno').val()==""||value.trim()=="")
		                			return true;
		                		//修改的情况下，如果fno和fromdate没有更改，则校验通过
		                		if(op=="mod"&&value==oldFromDate&&$('#fno').val()==oldFno)
		                			return true
		                		var result;
		                		$.ajax({
		                			url:"${p}/flight/checkfno?fno="+$('#fno').val()+
		                    		"&fromDate="+value,
		                    		async:false,
		                    		dataType:'json',
		                    		success:function(json){
		                    			result = json.valid;
		                    		}
		                		});
		                		//更新fno校验状态为正确
		                		if(result){
		                			validator.updateStatus('fno', 'VALID');	
		                		}else{
		                			//更新fno校验状态为不正确，第三个参数为校验器名称
		                			validator.updateStatus('fno', 'INVALID','callback');	
		                		}
		                	     return result;
		                	 }
		                 }
		               }
		            },
	        toDate: {
	        	    trigger:'blur',//失去焦点校验
	                validators: {
	                    notEmpty: {
	                    message: '到达时间不可为空'
	                    },
	                    callback: {
		                    message: '出发时间必须小于到达时间',
		                	callback: function(value, validator) {
		                		if($('#fromDate').val()!=""&&$('#fromDate').val() >= value)
		                			return false;
		                		else{
		                		return true;
		                		}
		                	 }
		                 }
	                }
	        }
	    }
		});
	}
		function clearForm(){
			$("#id").val("");
			$("#fno").val("");
			$(":radio[value='单程']").prop("checked",true);
			$("#fromDate").val("");
			$("#toDate").val("");
			//让select2下拉框插件选中某个值
		    var routeSel =  $("#routeId").select2();
		    routeSel.val("0").trigger("change");
		    var planeSel =  $("#planeId").select2();
		    planeSel.val("0").trigger("change");
			$('#routeId').val(null).trigger("change");//重置select2插件
		    $('#planeId').val(null).trigger("change");//重置select2插件
		    
		    $("#jingjiseat").val("");
		    $("#jingjiprice").val("");
		    $("#shangwuseat").val("");
		    $("#shangwuprice").val("");
		    $("#toudengseat").val("");
		    $("#toudengprice").val("");
		    $("#shangwubtn").prop("checked",false);//重置商务舱展开按钮
	    	$("#toudengbtn").prop("checked",false);//重置头等舱展开按钮
	    	$("#shangwudiv").hide();//隐藏商务舱输入框
	    	$("#toudengdiv").hide();//隐藏头等舱舱输入框
		}
				//myModal关闭时的事件
			    $('#myModal').on('hidden.bs.modal', function() {
			    	op="add";
			    	$("#myModalLabel").text("新增航班");
			    	clearForm();
			        $("#modelForm").data('bootstrapValidator').destroy();
			        $('#modelForm').data('bootstrapValidator', null);
			        //重新加载校验器
			        formValidate();
			        
			    });
		 </script>
	<!-- 提示信息模态框 -->
	<div class="modal fade" id="infoModal"  role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content" >
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body" id="alertdiv">
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					</div>
				</div>
			</div>
		</div>	 
</body>
</html>