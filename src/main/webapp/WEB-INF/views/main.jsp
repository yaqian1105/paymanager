<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <%@include file="../../base/resource_menu.jsp" %>
    <!--导航图标-->
    <link rel="shortcut icon" href="${rootPath}/static/images/logo.ico" type="image/x-icon"/>
    <link rel="stylesheet" type="text/css" href="${rootPath}/static/css/base.css"/>
    <link rel="stylesheet" type="text/css" href="${rootPath}/static/css/common.css"/>

</head>
<body class="hold-transition skin-blue sidebar-mini fixed">
<div class="wrapperMain">

    <div class="sidebar">
        <div class="sidebar-head">
            <img src="${rootPath}/static/images/logo_home.png"/>
            <div>旗鱼点餐移动支付平台</div>
            <div>经营从未变得如此简单</div>
        </div>
        <ul class="sidebar-menu sidebar-nav">
            <li class="active"><a data-href="/echart/welcome"><img src="${rootPath}/static/images/icon_home.png"/>首页</a>
            </li>
            <li><a data-href="/merchant/index"><img src="${rootPath}/static/images/icon_bussiness.png"/>商户管理</a></li>
            <li><a data-href="/agent/index"><img src="${rootPath}/static/images/icon_agent.png"/>代理商管理</a></li>
            <li><a data-href="/transaction/index"><img src="${rootPath}/static/images/icon_transition.png"/>交易管理</a>
            </li>
            <li><a data-href="/withdrawl/index"><img src="${rootPath}/static/images/icon_cash.png"/>提现管理</a></li>

        </ul>
    </div>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper clearfix p20" style="position: relative;">
        <iframe id="contentIFrame" src="${rootPath}/echart/welcome" frameborder="0">
        </iframe>
    </div>
</div>
</body>

<script type="text/javascript">
    $(function () {
        //初始化链接
        var hash = "/echart/welcome";
        location.hash && location.hash.substr(1) ? hash = location.hash.substr(1) : "";
        $("#contentIFrame").attr("src", ROOT + hash);

        $(".sidebar-menu a").each(function (index, item) {
            var href = item.dataset.href;
            item.href = "javascript:;"
            if (!href || href == "#") {
                return;
            }
            item.onclick = function (e) {
                location.hash.substr(1) == href ? location.reload() : location.hash = href;
            }
            if (location.hash.substr(1) === href) {
                $(item).parents('li').addClass("active");
            }
        });
        window.onhashchange = function () {
            var hash = location.hash.substr(1);
            $("#contentIFrame").attr("src", ROOT + hash);
            $(".sidebar a[data-href='" + hash + "']").parent("li").addClass("active").siblings("li.active").removeClass("active");
        }
    })
</script>
</html>