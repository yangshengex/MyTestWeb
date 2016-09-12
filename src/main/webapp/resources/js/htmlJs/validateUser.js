$('#mealert').click(function(){
	//动态给出弹出位置
//    $('#myModal').css({  
//        'top': function () {  
//            //$(window).height()浏览器高度,然后减去自己的高度/2,实现弹出层垂直居中  
//            alert($(window).height());  
//            alert($(document).height());  
//            return $(window).height()-400; 
//
//        } ,
//        'left':function(){
//        	 alert($('#myModal').width())
//        	  alert($('#myModal').width())
//        	 return $(document).width()-800;  
//        }
//    });
    		$('#myModal').modal({
    			show:true,
    			backdrop:'static',
    			keyboard:false
    		});
    		//设置定时消失，我们可以用来做通知
//    		setTimeout(function(){
//    			$('#myModal').modal('hide');
//    		}, 2000);
    		/**
    		 * 1.倒计定时器：timename=setTimeout("function();",delaytime);
				2.循环定时器：timename=setInterval("function();",delaytime);
				
				clearTimeout(对象timename) 清除已设置的setTimeout对象
				clearInterval(对象timename) 清除已设置的setInterval对象
    		 */
    	});
//跳转指定url
$('#btn_submit').click(function(){
	$('#my_from1').attr('action','http://www.baidu.com').submit();
});
/**
 * 得到验证码
 */
$('#vimg').click(function(){
	var imgid = document.getElementById("vimg");
	imgid.setAttribute("src", "${pageContext.request.contextPath}/CreateVerificationCode.do?t=" + Math.random());
});


/**
 * 验证表单数据
 */
    	$( "#my_from1" ).validate( {
            onfocus: true,
            onsubmit: true,
            onkeyup: true,//这个地方要注意，修改去控制器验证的事件。
			rules: {
				username: {
					required: true,
					minlength: 2,
					maxlength:10
				},
				password: {
					required: true,
					minlength: 5
				},
				password2: {
					required: true,
					minlength: 5,
					equalTo: "#password"
				},
				agree1:"required",
				txt_statu:{
					
					required:true,
							remote : {
								url : "/PhoneValidata/RemoteValidate",
								type : "post",
								dataType : "json",
								data : {
									pwd : function() {
										return $("#txt_statu").val();// 这个是取要验证的密码
									}
								},
								dataFilter : function(data) {// 判断控制器返回的内容
									if (data == "true") {
										return true;
									} else {
										return false;
									}
								}
							}
						}
					},
			messages: {
				username: {
					required: "Please enter a username",
					minlength: "Your username must consist of at least 2 characters",
					maxlength: "Your username must consist of at least 10 characters"
				},
				password: {
					required: "Please provide a password",
					minlength: "Your password must be at least 5 characters long"
				},
				password2: {
					required: "Please provide a password",
					minlength: "Your password must be at least 5 characters long",
					equalTo: "Please enter the same password as above"
				},
				agree1:'',
				txt_statu:"验证不通过"
			},
			errorElement: "em",
			errorPlacement: function ( error, element ) {
				// Add the `help-block` class to the error element
				error.addClass( "help-block" );
				//找到错误的以有class为form-group的父级元素
				element.parents( ".form-group" ).addClass( "has-feedback" );
				//需要对checkBox进行单独处理
				if ( element.prop( "type" ) === "checkbox" ) {
					//错误时在checkbox的那个div上插入元素
					error.insertAfter( element.parents( "label" ) );
				} else {
					error.insertAfter( element );
				}
				// Add the span element, if doesn't exists, and apply the icon classes to it.
				if ( !element.next( "span" )[ 0 ] ) {
					$( "<span class='glyphicon glyphicon-remove form-control-feedback'></span>" ).insertAfter( element );
				}
			},
			success: function ( label, element ) {
				// Add the span element, if doesn't exists, and apply the icon classes to it.
				if ( !$( element ).next( "span" )[ 0 ] ) {
					$( "<span class='glyphicon glyphicon-ok form-control-feedback'></span>" ).insertAfter( $( element ) );
				}
			},
			highlight: function ( element, errorClass, validClass ) {
				$( element ).parents( ".form-group" ).addClass( "has-error" ).removeClass( "has-success" );
				$( element ).next( "span" ).addClass( "glyphicon-remove" ).removeClass( "glyphicon-ok" );//修改span的图标
			},
			unhighlight: function ( element, errorClass, validClass ) {
				$( element ).parents( ".form-group" ).addClass( "has-success" ).removeClass( "has-error" );
				$( element ).next( "span" ).addClass( "glyphicon-ok" ).removeClass( "glyphicon-remove" );
			}
});