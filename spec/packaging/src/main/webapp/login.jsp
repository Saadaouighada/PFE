<%@page import="java.util.*" %>
<html:html class="body" >
<head>
<title>Test fwk Login</title>
    <script type="text/javascript">
        function empty(obj) {
            var el = document.getElementById(obj);
            el.value = '';
        }
        function toggle(obj) {
            var el = document.getElementById(obj);
            if ( el.style.display != 'none' ) {
                el.style.display = 'none';
            }
            else {
                el.style.display = '';
            }
        }    
        function changepassword() {
            empty('j_new_password');
            empty('j_confirm_password');
            toggle('passwordfields');
            toggle('changePasswordButton');
            toggle('cancelButton');
        }
    </script>
    <style type="text/css">
    
        .image {
            background: url("/images/logo.png") no-repeat scroll right bottom transparent;
        }
    
        .body{
            width: 100%; 
            margin: 0;
             padding: 0;"
        }
        .errorblock {
            color: #ff0000;
            background-color: #ffEEEE;
            border: 3px solid #ff0000;
            padding: 8px;
            margin: 0 0 10px;
        }
    </style>
</head>
<body class="body">
    <div style="height: 593px; width: 100%;">
        <div style="right: 30%; position: absolute; top: 73px;">
            <% if((request.getParameter("error"))!=null && !(request.getParameter("error")).isEmpty()){  %>
                <div class="errorblock">
                    Your login attempt was not successful, try again.<br />
                </div>
            <% } else if((request.getParameter("changePasswordError"))!=null && !(request.getParameter("changePasswordError")).isEmpty()){  %>
                <div class="errorblock">
                    Invalid new password.<br />
                </div>
            <% } %> 
            <div class="image" style="width: 620px; border-color: #99BBE8; border-style: solid; border-width: 1px;">
                <form style="height: 480px; overflow: hidden; width: 620px; margin-bottom: 0" method="post" action="j_spring_security_check">
                    <div>
                        <label style="margin-left:10px; color: #FF9933;font-size: 177%;">Test fwk</label>
                    </div>
                    <div style="height: 5px;"><br></div>
                    <div>
                        <label style="margin-left:10px; font-size: 177%;">A global solution committed to the</label>
                    </div>
                    <div style="height: 1px;" ><br></div>
                    <div>
                        <label style="margin-left:10px; font-size: 177%;">leasing &amp; credit industry</label>
                    </div>
                    <div style="height: 1px;"><br></div>
                    <div style="border-style: solid; border-width: 0 0 20px; color: #FF9933; position: relative; width: 102%;"><br></div>
                    <div style="height: 70px;"><br></div>
                    <div  style="margin-left: 20%;">
                        <div style="float: left;width : 140px;"> User:  </div>
                        <div style="float: left; margin-left: 10px;" >
                            <input name="j_username" value="" type="text" />
                        </div>
                        <div style="clear: both;"></div>
                        <br>
                        <div style="float: left;width : 140px;">Password:  </div>
                        <div style="float: left; margin-left: 10px;"><input name="j_password" type="password" /></div>
                        <div style="clear: both;"></div>
                        <br>
                        <div id="passwordfields" style="display: none;">            
                            <div style="float: left;width : 140px;">New Password:  </div>
                            <div style="float: left; margin-left: 10px;"><input id="j_new_password" name="j_new_password" type="password" /></div>
                            <div style="clear: both;"></div>
                            <br>            
                            <div style="float: left;width : 140px;">Confirm Password:</div>
                            <div style="float: left; margin-left: 10px;"><input id="j_confirm_password" name="j_confirm_password" type="password" /></div>
                            <div style="clear: both;"></div>
                            <br>            
                        </div>           
                        <div style="float: left; margin-left: 20%;">
                            <input type="button" id="cancelButton" value="Cancel" onclick="changepassword()" style="display: none;" />
                            <input type="button" id="changePasswordButton" value="Change Password" onclick="changepassword()" />
                            <input value="Connection" type="submit" />
                        </div>
                        <div style="clear: both;"></div>
                    </div>
                </form>
            </div>
            </div>
    </div>
</body>
</html:html>
