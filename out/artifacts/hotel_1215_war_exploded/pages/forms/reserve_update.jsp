<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>修改预定信息界面</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="../../bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="../../bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="../../bower_components/Ionicons/css/ionicons.min.css">
    <!-- jvectormap -->
    <link rel="stylesheet" href="../../bower_components/jvectormap/jquery-jvectormap.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="../../dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="../../dist/css/skins/_all-skins.min.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Google Font -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body class="hold-transition skin-blue sidebar-mini" min-height="5000px;">

<div class="wrapper">

    <header class="main-header">

        <!-- Logo -->
        <a href="#" class="logo">
            <!-- mini logo for sidebar mini 50x50 pixels -->
            <span class="logo-mini"><b>后台</b>管理</span>
            <!-- logo for regular state and mobile devices -->
            <span class="logo-lg"><b>AI智慧酒店</b>后台系统</span>
        </a>

        <!-- Header Navbar: style can be found in header.less -->
        <nav class="navbar navbar-static-top">
            <!-- Sidebar toggle button-->
            <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
                <span class="sr-only">Toggle navigation</span>
            </a>
            <!-- Navbar Right Menu -->
            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <!-- Messages: style can be found in dropdown.less-->
                    <li class="dropdown messages-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="fa fa-envelope-o"></i>
                            <span class="label label-success">4</span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="header">你有4条未读信息</li>
                            <li class="header">你有4条未读信息</li>
                            <li>
                                <!-- inner menu: contains the actual data -->
                                <ul class="menu">
                                    <li><!-- start message -->
                                        <a href="#">
                                            <div class="pull-left">
                                                <img src="../../dist/img/user2-160x160.jpg" class="img-circle"
                                                     alt="User Image">
                                            </div>
                                            <h4>
                                                总管理员
                                                <small><i class="fa fa-clock-o"></i> 5 mins</small>
                                            </h4>
                                            <p></p>
                                        </a>
                                    </li>
                                    <!-- end message -->
                                    <li>
                                        <a href="#">
                                            <div class="pull-left">
                                                <img src="../../dist/img/user3-128x128.jpg" class="img-circle"
                                                     alt="User Image">
                                            </div>
                                            <h4>
                                                超级管理员
                                                <small><i class="fa fa-clock-o"></i> 2 hours</small>
                                            </h4>
                                            <p></p>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            <div class="pull-left">
                                                <img src="../../dist/img/user4-128x128.jpg" class="img-circle"
                                                     alt="User Image">
                                            </div>
                                            <h4>
                                                总管理员
                                                <small><i class="fa fa-clock-o"></i> Today</small>
                                            </h4>
                                            <p></p>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            <div class="pull-left">
                                                <img src="../../dist/img/user3-128x128.jpg" class="img-circle"
                                                     alt="User Image">
                                            </div>
                                            <h4>
                                                超级管理员
                                                <small><i class="fa fa-clock-o"></i> Yesterday</small>
                                            </h4>
                                            <p></p>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            <div class="pull-left">
                                                <img src="../../dist/img/user4-128x128.jpg" class="img-circle"
                                                     alt="User Image">
                                            </div>
                                            <h4>
                                                总管理员
                                                <small><i class="fa fa-clock-o"></i> 2 days</small>
                                            </h4>
                                            <p></p>
                                        </a>
                                    </li>
                                </ul>
                            </li>
                            <li class="footer"><a href="#">查看所有信息</a></li>
                        </ul>
                    </li>
                    <!-- Notifications: style can be found in dropdown.less -->
                    <li class="dropdown notifications-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="fa fa-bell-o"></i>
                            <span class="label label-warning">10</span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="header">你有10条未读消息</li>
                            <li>
                                <!-- inner menu: contains the actual data -->
                                <ul class="menu">
                                    <li>
                                        <a href="#">
                                            <i class="fa fa-users text-aqua"></i> 有5位用户完成预定
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            <i class="fa fa-warning text-yellow"></i> 设备问题反馈
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            <i class="fa fa-users text-red"></i> 1位客户checkout
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            <i class="fa fa-shopping-cart text-green"></i> 25 条消费记录
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            <i class="fa fa-user text-red"></i> 你刚刚修改了你的用户名
                                        </a>
                                    </li>
                                </ul>
                            </li>
                            <li class="footer"><a href="#">查看全部信息</a></li>
                        </ul>
                    </li>

                    <!-- User Account: style can be found in dropdown.less -->
                    <li class="dropdown user user-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <img src="../../dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
                            <span class="hidden-xs">总管理员</span>
                        </a>
                        <ul class="dropdown-menu">
                            <!-- User image -->
                            <li class="user-header">
                                <img src="../../dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">

                                <p>
                                    总管理员 - 007
                                    <small>注册日期 Nov. 2019</small>
                                </p>
                            </li>
                            <!-- Menu Body -->
                            <li class="user-body">
                                <div class="row">
                                    <div class="col-xs-4 text-center">
                                        <a href="#">个人中心</a>
                                    </div>
                                    <div class="col-xs-4 text-center">
                                        <a href="#">我的好友</a>
                                    </div>
                                </div>
                                <!-- /.row -->
                            </li>
                            <!-- Menu Footer-->
                            <li class="user-footer">
                                <div class="pull-left">
                                    <a href="index.jsp" class="btn btn-default btn-flat">重新登录</a>
                                </div>
                                <%--<div class="pull-right">
                                    <a href="index.jsp" class="btn btn-default btn-flat">退出登录</a>
                                </div>--%>
                            </li>
                        </ul>
                    </li>
                    <!-- Control Sidebar Toggle Button -->
                    <li>
                        <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
                    </li>
                </ul>
            </div>

        </nav>
    </header>
    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
            <!-- Sidebar user panel -->
            <div class="user-panel">
                <div class="pull-left image">
                    <img src="../../dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                </div>
                <div class="pull-left info">
                    <p>总管理员</p>
                    <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
                </div>
            </div>
            <!-- search form -->
            <form action="#" method="get" class="sidebar-form">
                <div class="input-group">
                    <input type="text" name="q" class="form-control" placeholder="查找信息...">
                    <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat">
                  <i class="fa fa-search"></i>
                </button>
              </span>
                </div>
            </form>
            <!-- /.search form -->
            <!-- sidebar menu: : style can be found in sidebar.less -->
            <ul class="sidebar-menu" data-widget="tree">
                <li class="header">主菜单</li>


                <li>
                    <a href="../../head.jsp">
                        <i class="fa fa-bar-chart"></i> <span>图表统计</span>
                        <span class="pull-right-container">
                            <%--<small class="label pull-right bg-green">记录</small>--%>
                        </span>
                    </a>
                </li>

                <li>
                    <a href="../../roomConsumeSel.do">
                        <i class="fa fa-table"></i> <span>房间消费查询</span>
                        <span class="pull-right-container">
              <!--<small class="label pull-right bg-green">所有消费记录</small>-->
            </span>
                    </a>
                </li>

                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-edit"></i> <span>入住管理</span>
                        <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
              <small class="label pull-right bg-green">预定 & 房客</small>
            </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="../../SelAllReserve.do"><i class="fa fa-list-ul"></i> 查看所有预定信息</a></li>
                        <li><a href="../../pages/forms/reserve_add.jsp"><i class="fa fa-plus"></i> 增加预定信息</a></li>
                        <li><a href="../../pages/forms/reserve_update.jsp"><i class="fa fa-pencil-square-o"></i> 修改预定信息</a></li>
                        <li><a href="../../pages/forms/reserve_delete.jsp"><i class="fa  fa-remove"></i> 删除预定信息</a></li>
                        <li><a href="../../SelAllCheckIn.do"><i class="fa fa-users"></i> 查看所有房客信息</a></li>
                        <li><a href="../../pages/forms/checkin_add.jsp"><i class="fa fa-user-plus"></i> 增加房客信息</a></li>
                        <li><a href="../../pages/forms/checkin_update.jsp"><i class="fa fa-user"></i> 修改房客信息</a></li>
                        <li><a href="../../pages/forms/checkin_delete.jsp"><i class="fa fa-user-times"></i> 删除房客信息</a></li>
                    </ul>
                </li>

                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-edit"></i> <span>房间管理</span>
                        <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="../../SelAllRoom.do"><i class="fa fa-list-ul"></i> 查看所有房间信息</a></li>
                        <li><a href="../../pages/forms/room_add.jsp"><i class="fa fa-plus"></i> 增加房间信息</a></li>
                        <li><a href="../../pages/forms/room_update.jsp"><i class="fa fa-pencil-square-o"></i> 修改房间信息</a></li>
                        <li><a href="../../pages/forms/room_delete.jsp"><i class="fa  fa-remove"></i> 删除房间信息</a></li>
                    </ul>
                </li>

                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-edit"></i> <span>会议室管理</span>
                        <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
              <small class="label pull-right bg-green">预定 & 管理</small>
            </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="../../SelAllMeeting.do"><i class="fa fa-list-ul"></i> 查看所有会议室</a></li>
                        <li><a href="../../pages/forms/meeting_add.jsp"><i class="fa fa-plus"></i> 增加会议室</a></li>
                        <li><a href="../../pages/forms/meeting_update.jsp"><i class="fa fa-pencil-square-o"></i> 修改会议室</a></li>
                        <li><a href="../../pages/forms/meeting_delete.jsp"><i class="fa  fa-remove"></i> 删除会议室</a></li>
                        <li><a href="../../SelAllMeetingReserve.do"><i class="fa fa-list-ul"></i> 查看所有会议室预定</a></li>
                        <li><a href="../../pages/forms/meetingReserve_add.jsp"><i class="fa fa-plus"></i> 增加会议室预定</a></li>
                        <li><a href="../../pages/forms/meetingReserve_update.jsp"><i class="fa fa-pencil-square-o"></i> 修改会议室预定</a></li>
                        <li><a href="../../pages/forms/meetingReserve_delete.jsp"><i class="fa  fa-remove"></i> 删除会议室预定</a></li>
                    </ul>
                </li>

                <li>
                    <a href="../../SelAllVisitors.do">
                        <i class="fa fa-table"></i> <span>访客记录查询</span>
                        <span class="pull-right-container">
              <!--<small class="label pull-right bg-green">所有访客记录</small>-->
            </span>
                    </a>
                </li>

                <li>
                    <a href="../../pages/forms/face_select.jsp">
                        <i class="fa fa-user"></i> <span>人脸检索</span>
                        <span class="pull-right-container">
            </span>
                    </a>
                </li>

                <li class="header">以下功能只有超级管理员才能使用</li>
                <li><a href="../../pages/admin/login.jsp"><i class="fa fa-circle-o text-aqua"></i> 员工管理<span>

                </span></a></li>
            </ul>
        </section>
        <!-- /.sidebar -->
    </aside>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            修改预定信息
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="#">预定管理</a></li>
            <li class="active">修改预定信息</li>
        </ol>
    </section>

    <!-- Main content -->
    <section class="content">
        <form method="post" action="../../UpdReserve.do">

            <div class="box box-primary">
                <div class="box-header">
                    <h3 class="box-title">请输入要修改的预定信息</h3>
                </div>

                <div class="box-body">
                    <div class="form-group">
                        <label>住户名：</label>
                        <div class="input-group">
                            <div class="input-group-addon">
                                <i class="fa fa-user"></i>
                            </div>
                            <input name="name" id="name" type="text" class="form-control">
                        </div>
                    </div>

                    <div class="form-group">
                        <label>入住时间：</label>
                        <div class="input-group">
                            <div class="input-group-addon">
                                <i class="fa fa-calendar-check-o"></i>
                            </div>
                            <input name="checkin_date" id="checkin_date" type="date" class="form-control" placeholder="例：2019-12-17 18:00">
                        </div>
                    </div>

                    <div class="form-group">
                        <label>退房时间：</label>
                        <div class="input-group">
                            <div class="input-group-addon">
                                <i class="fa fa-calendar-minus-o"></i>
                            </div>
                            <input name="checkout_date" id="checkout_date" type="date" class="form-control" placeholder="例：2019-12-17 18:00">
                        </div>
                    </div>

                    <div class="form-group">
                        <label>房间类型：</label>
                        <div class="input-group">
                            <div class="input-group-addon">
                                <i class="fa fa-home"></i>
                            </div>
                            <select name="room_type" id="room_type" class="form-control">
                                <option value="房1">房1</option>
                                <option value="房2">房2</option>
                                <option value="房3">房3</option>
                                <option value="房4">房4</option>
                                <option value="房5">房5</option>
                            </select>
                        </div>
                    </div>

                    <%--<div class="form-group">
                        <label>是否已入住：</label>
                        <div class="input-group">
                            <div class="input-group-addon">
                                <i class="fa fa-tag"></i>
                            </div>
                            <select name="checkin_out" id="checkin_out" class="form-control">
                                <option value="0" id="0" name="0">是</option>
                                <option value="1" id="1" name="1">否</option>
                            </select>
                        </div>
                    </div>--%>
                </div>

                <div class="box-footer">
                    <button type="submit" class="btn btn-primary pull-right" style="margin-left: 20px">确定</button>
                    <button type="reset" class="btn btn-default pull-right">取消</button>
                </div>
            </div>
        </form>
    </section>
</div>
<!-- /.box -->

</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->


<footer class="main-footer">
    <div class="pull-right hidden-xs">
        <b>Version</b> 2.4.0
    </div>
    <strong>Copyright &copy; 2019-2021 <a href="https://adminlte.io">ZJUT</a>.</strong> All rights
    reserved.
</footer>

<!-- /.control-sidebar -->
<!-- Add the sidebar's background. This div must be placed
     immediately after the control sidebar -->
<!-- ./wrapper -->

<!-- jQuery 3 -->
<script src="../../bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="../../bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="../../bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="../../bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="../../dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../../dist/js/demo.js"></script>
<script>
    $(document).ready(function () {
        $('.sidebar-menu').tree()
    })
</script>
<script src="../../layer/layer.js"></script>
<%
    String msg=(String)session.getAttribute("msg");
    if(msg!=null){
        if(msg.equals("预定信息修改成功！")){
%>
<script>
    var index = layer.msg('<%=msg%>',{time:1500})
    layer.style(index, {
        background:'#28a649',
        color:'#fff'
    });
</script>
<%
}else{
%>
<script>
    var index = layer.msg('<%=msg%>',{time:1500})
    layer.style(index, {
        background:'#c20c05',
        color:'#fff'
    });
</script>
<%
        }
    }
    session.setAttribute("msg",null);
%>
</div>
</body>
</html>
