/**
 * cas-login v1.0.0
 * Miaozhen cas login module
 * 
 * http://www.miaozhen.com
 */

!function(){
	
	'use strict';
	
	var root = this;
	
	//Default Settigns
	var defaults = {
			productCast : {
				"DASHBOARD" : "Dashboard",
				"PLANNexDTV" : "PlanNexDTV",
				"PLANNEX" : "PlanNex"
			}
	}
	
	/**
	 * Parse URI parameters utility
	 * @Private
	 */
	var parseParameter = function(paramName) {
			var url = location.search; //获取url中"?"符后的字串
		    var theRequest = new Object();
		    if (url.indexOf("?") != -1) {
		    	var str = url.substr(1);
		    	var strs = str.split("&");
		    	for(var i = 0; i < strs.length; i ++) {
		    		theRequest[strs[i].split("=")[0]]=(strs[i].split("=")[1]);
		    	}
		    } 
		    return theRequest[paramName];		
	}
	
	
	/**
	 * Show info in a pop element
	 * @Private
	 */
    var showPopErrTip = function(tipContent) {
           
            $('.failure-pop').find('.asp-content').html(tipContent);
            $('.failure-pop').fadeIn(300);
            window.setTimeout(function(){
                   $('.failure-pop').fadeOut(150);
            },1000);
    }
    
    /**
     * Validate form data utility
     * @Private
     */
    var validateFormInfo = function() {     
            if($('#username').val().trim() == '') {
                    return false;
            }        
            if($('#password').val().trim() == '') {
                    return false;
            }      
            return true;
    }
    
    
  
    
    /**
     * Submit form
     * @Private
     */
    var postForm = function() {
    	var curProduct = parseParam('type');
    	
    	
    	if(typeof curProduct != "undefined") {
    		$('#product').val(defaults.productCast[curProduct.toUpperCase()])
    	}
    	
    	$('form').submit();
    }
    

    /**
     * Handle Button Click Event
     * @Private
     */
    var handleSubmitForm = function() {
    	$('#login').on('click',function(){
            postForm();
    	})
    }
    
    /**
     * Handle PressKey Event
     */
    var handleEnterKeyEvent = function() {
        $(document).keyup(function(event){
                if(event.keyCode ==13){
                        if($('#username').val().trim() != '' && $('#password').val().trim() != '') {
                                postForm();   
                        }          
                }
         }); 
    }

    
    /**
     * Handle Error Info
     * @Private
     */
    var handleErrorInfo = function() {
    	var msg = $('#msg')
    	if(typeof msg != "undefined" && msg.length > 0) {
    		showPopErrTip(msg.html())
    	}
    }
	
    
    //对外接口
    var initAllEvent = function() {
    		handleErrorInfo();
            handleSubmitForm();
            handleEnterKeyEvent();
    }
    
	
	parent.parseParam = parseParameter;
	
	parent.LoginModule = function(){
	    return {
	            init : initAllEvent      
	    }
	}()
	
	

	
}()