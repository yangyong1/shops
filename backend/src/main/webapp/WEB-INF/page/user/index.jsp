<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../taglib.jsp"%>
<sp:url var="listUserURL" value="/user/list" />
<sp:url var="saveUserURL" value="/user/save" />
<sp:url var="delUserURL" value="/user/del" />
<div class="mainpanel">
    <div class="pageheader">
        <div class="media">
            <%--<div class="pageicon pull-left">--%>
                <%--<i class="glyphicon  glyphicon-user"></i>--%>
            <%--</div>--%>
            <div class="media-body">
                <br/>
                <h4>系统用户管理</h4>
            </div>
        </div><!-- media -->
    </div><!-- pageheader -->

    <div class="contentpanel">
        <div class="panel panel-primary-head">
            <div class="panel-heading">
                <div class="pull-right">
                    <button class="btn btn-xs btn-default" data-toggle="modal" data-target="#modal-add-user">新增用户</button>
                </div>
                <h3 class="panel-title">用户列表</h3>
            </div><!-- panel-heading -->
            <table id="basicTable" class="table table-striped table-bordered " width="100%">
                <thead >
                <tr>
                    <th width="20%">用户名</th>
                    <th width="30%">所属角色</th>
                    <th width="30%">创建时期</th>
                    <th width="15%">操作</th>
                </tr>
                </thead>
            </table>
        </div><!-- panel -->

    </div><!-- contentpanel -->

    <div class="modal fade" id="modal-add-user" data-backdrop="static" >
        <div class="modal-dialog ">
            <div class="modal-content">
                <form class="form-horizontal form-bordered"  id="form-add-user">
                <div class="modal-header">
                    <button aria-hidden="true" data-dismiss="modal" class="close" type="button">&times;</button>
                    <h4 class="modal-title">新增用户</h4>
                </div>
                <div class="modal-body">
                        <div class="form-group">
                            <label class="col-sm-2 control-label" >用户名 <span class="asterisk">*</span></label>
                            <div class="col-sm-10">
                                <input type="text" name="username" class="form-control" placeholder="请输入英文字母..." required>
                            </div>
                        </div><!-- form-group -->
                        <div class="form-group">
                            <label class="col-sm-2 control-label">昵称 <span class="asterisk">*</span></label>
                            <div class="col-sm-10">
                                <input type="text" name="dispName" class="form-control" placeholder="必填..."  required="">
                            </div>
                        </div><!-- form-group -->
                        <div class="form-group">
                            <label class="col-sm-2 control-label">手机 </label>
                            <div class="col-sm-10">
                                <input type="text" name="mobile" class="form-control" placeholder="选填..." required="Number">
                            </div>
                        </div><!-- form-group -->
                        <div class="form-group">
                            <label class="col-sm-2 control-label">密码 <span class="asterisk">*</span></label>
                            <div class="col-sm-10">
                                <input type="text" name="pwd1" class="form-control" placeholder="必填..." required="">
                            </div>
                        </div><!-- form-group -->
                        <div class="form-group">
                            <label class="col-sm-2 control-label">确认密码 <span class="asterisk">*</span></label>
                            <div class="col-sm-10">
                                <input type="text" name="pwd2" class="form-control"  placeholder="必填..."  required="">
                            </div>
                        </div><!-- form-group -->

                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary ">保存</button>
                    <button  class="btn btn-dark"  data-dismiss="modal">关闭</button>
                    <button   class=" hidden"  type="reset">重置</button>
                </div>
                </form>
            </div>

        </div>
    </div>


</div><!-- mainpanel -->
<script>
    $(document).ready(function(){

        $('#basicTable').DataTable({
            processing: true,
            serverSide: true,
            ajax: "${listUserURL}",
            columns: [
                { data: "username" },
                { data: "username" },
                { data: "createdAt" },
                { data: "username" }
            ],
            "columnDefs": [
                {
                    "render": function ( data, type, row ) {
                        return '<div class="btn-group mr5">' +
                                '<button type="button" class="btn btn-xs btn-primary dropdown-toggle" data-toggle="dropdown">Action <span class="caret"></span> </button>' +
                                ' <ul class="dropdown-menu" role="menu"> ' +
                                '<li><a href="javascript:delUser(\''+data+'\')">删除</a></li> ' +
                                '<li><a href="javascript:updateUser(\''+data+'\')">修改</a></li>' +
                                ' <li><a href="#">分配角色</a></li> ' +
                                '</ul> </div>'
                    },
                    "targets": [3]
                }
            ]
        });

        // Basic Form
        $("#form-add-user").validate({
            highlight: function(element) {
                jQuery(element).closest('.form-group').removeClass('has-success').addClass('has-error');
            },
            success: function(element) {
                jQuery(element).closest('.form-group').removeClass('has-error');
                $(this).ajaxSubmit({
                    type: 'post', // 提交方式 get/post
                    url: '${saveUserURL}', // 需要提交的 url
                    data: $('form-add-user').formSerialize(),
                    success: function(data) {
                        $('#modal-add-user').modal('hide');
                        showSuccess();
                        $('#basicTable').DataTable().draw();

                    }
                });
            }
        });

    });
    function delUser(userName) {
        BootstrapDialog.confirm("确定删除选中的记录吗？<br />" + userName, function (re) {
            if (re) {
                $.post('${delUserURL}', {"userName": userName}, function () {
                    showSuccess();
                    $('#basicTable').DataTable().draw();
                });
            }
        });
    }


</script>