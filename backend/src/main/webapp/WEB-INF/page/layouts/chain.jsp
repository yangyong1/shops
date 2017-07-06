<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Chain Responsive Bootstrap3 Admin</title>
    <link href="${resources}/css/style.default.css" rel="stylesheet">
    <link href="${resources}/css/select2.css" rel="stylesheet" />
    <link href="${resources}/css/style.datatables.css" rel="stylesheet">
    <link href="${resources}/css/jquery.gritter.css" rel="stylesheet">


    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="${resources}/js/html5shiv.js"></script>
    <script src="${resources}/js/respond.min.js"></script>
    <![endif]-->
    <script src="${resources}/js/jquery-1.11.1.min.js"></script>
    <script src="${resources}/js/jquery-migrate-1.2.1.min.js"></script>
    <script src="${resources}/js/jquery.form.js"></script>

</head>

<body>
<header>
    <div class="headerwrapper">
        <div class="header-left">
            <a href="index.html" class="logo">
                <img src="${resources}/images/logo.png" alt="" />
            </a>
            <div class="pull-right">
                <a href="" class="menu-collapse">
                    <i class="fa fa-bars"></i>
                </a>
            </div>
        </div><!-- header-left -->

        <div class="header-right">

            <div class="pull-right">
                <div class="btn-group btn-group-option">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                        <i class="fa fa-caret-down"></i>
                    </button>
                    <ul class="dropdown-menu pull-right" role="menu">
                        <li><a href="#"><i class="glyphicon glyphicon-user"></i> My Profile</a></li>
                        <li><a href="#"><i class="glyphicon glyphicon-star"></i> Activity Log</a></li>
                        <li><a href="#"><i class="glyphicon glyphicon-cog"></i> Account Settings</a></li>
                        <li><a href="#"><i class="glyphicon glyphicon-question-sign"></i> Help</a></li>
                        <li class="divider"></li>
                        <li><a href="#"><i class="glyphicon glyphicon-log-out"></i>Sign Out</a></li>
                    </ul>
                </div><!-- btn-group -->

            </div><!-- pull-right -->

        </div><!-- header-right -->

    </div><!-- headerwrapper -->
</header>

<section>
    <div class="mainwrapper">
        <div class="leftpanel">
            <div class="media profile-left">
                <a class="pull-left profile-thumb" href="profile.html">
                    <img class="img-circle" src="${resources}/images/photos/profile.png" alt="">
                </a>
                <div class="media-body">
                    <h4 class="media-heading">Elen Adarna</h4>
                    <small class="text-muted">Beach Lover</small>
                </div>
            </div><!-- media -->

            <h5 class="leftpanel-title">导航栏</h5>
            <ul class="nav nav-pills nav-stacked">
                <li><a href="index.html"><i class="fa fa-home"></i> <span>Dashboard</span></a></li>
                <c:forEach var="menu" items="${menubar.mainitems}">
                    <c:if test="${menu.hasChildren}">
                        <li class="parent">
                            <a  href="javascript:;">
                            <i class="${menu.iconCls}"></i>
                            <span>
                            <c:if test="${menu.hasText}">${menu.text}</c:if>
                            <%--<c:if test="${!menu.hasText}"><sp:message code="${menu.key}" /></c:if>--%>
                            </span>
                            </a>
                            <ul class="children">
                                <c:forEach var="subMenu" items="${menu.submenus}">
                                    <li>
                                        <a href="<sp:url value='${subMenu.path}' />">
                                            <c:if test="${subMenu.hasText}">${subMenu.text}</c:if>
                                                <%--<c:if test="${!subMenu.hasText}"><sp:message code="${subMenu.key}" /></c:if>--%>
                                        </a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </li>
                    </c:if>
                    <c:if test="${!menu.hasChildren}">
                        <li>
                            <a href="<sp:url value='${menu.path}' />">
                                <i class="${menu.iconCls}"></i>
                            <span>
                            <c:if test="${menu.hasText}">${menu.text}</c:if>
                            <%--<c:if test="${!menu.hasText}"><sp:message code="${menu.key}" /></c:if>--%>
                            </span>
                            </a>
                        </li>
                    </c:if>
                </c:forEach>

            </ul>

        </div><!-- leftpanel -->
        <div class="row">
        <jsp:include page="${mainPage}" />
    </div><!-- mainwrapper -->
</section>


<script src="${resources}/js/bootstrap.min.js"></script>
<script src="${resources}/js/modernizr.min.js"></script>
<script src="${resources}/js/pace.min.js"></script>
<script src="${resources}/js/retina.min.js"></script>
<script src="${resources}/js/jquery.cookies.js"></script>
<script src="${resources}/js/bootstrap-dialog.min.js"></script>

<script src="${resources}/js/jquery.dataTables.min.js"></script>
<script src="${resources}/js/dataTables.bootstrap.js"></script>
<script src="${resources}/js/dataTables.responsive.js"></script>
<script src="${resources}/js/select2.min.js"></script>
<script src="${resources}/vendor/jquery-validation/jquery.validate.min.js"></script>
<script src="${resources}/vendor/jquery-validation/localization/messages_zh.min.js"></script>
<script src="${resources}/js/jquery.gritter.min.js"></script>
<script src="${resources}/js/custom.js"></script>


</body>
</html>
