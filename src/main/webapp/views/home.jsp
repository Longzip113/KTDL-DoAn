<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dư đoán địa điểm du lịch</title>
    <!-- Bootstrap core CSS -->
    <link href="<c:url value='/template/vendor/bootstrap/css/bootstrap.min.css' />" rel="stylesheet">
    <style>

        #wrapper {
            overflow-x: hidden;
        }

        #sidebar-wrapper {
            min-height: 100vh;
            margin-left: -15rem;
            -webkit-transition: margin .25s ease-out;
            -moz-transition: margin .25s ease-out;
            -o-transition: margin .25s ease-out;
            transition: margin .25s ease-out;
        }

        #sidebar-wrapper .sidebar-heading {
            padding: 0.875rem 1.25rem;
            font-size: 1.2rem;
        }

        #sidebar-wrapper .list-group {
            width: 15rem;
        }

        #page-content-wrapper {
            min-width: 100vw;
        }

        #wrapper.toggled #sidebar-wrapper {
            margin-left: 0;
        }

        @media (min-width: 768px) {
            #sidebar-wrapper {
                margin-left: 0;
            }

            #page-content-wrapper {
                min-width: 0;
                width: 100%;
            }

            #wrapper.toggled #sidebar-wrapper {
                margin-left: -15rem;
            }
        }
        .content-background{
            background-image: url("<c:url value='/template/img/background3.jpg' />");
            background-size: cover;
        }
    </style>
</head>
<body>
<div class="d-flex" id="wrapper">

    <!-- Sidebar -->
    <div class="bg-info text-white border-right" id="sidebar-wrapper">
        <div class="sidebar-heading">Trang chủ</div>
        <div class="list-group list-group-flush">
            <a href="./web-home" class="list-group-item list-group-item-action bg-info text-white">Gợi ý địa điểm du
                lịch</a>
            <a href="./web-member" class="list-group-item list-group-item-action bg-info text-white">Thành viên</a>
        </div>
    </div>
    <!-- /#sidebar-wrapper -->

    <!-- Page Content -->
    <div id="page-content-wrapper" class="content-background">
        <div class="container">
            <div class="text-center">
                <button class="btn btn-primary float-left" id="menu-toggle">Menu</button>
                <h1 class="text-danger">Gợi ý địa điểm du lịch</h1>
            </div>
            <form action="<c:url value='/run'/>" id="formSubmit" method="POST">
                <div class="row">
                    <div class="col-6">
                        <div class="card" style="min-height: 300px;">
                            <div class="card-header text-center">
                                <h3>Thông tin du lịch</h3>
                            </div>
                            <div class="card-body">
                                <p>Số người tham gia</p>
                                <select name="NumberOfPeople" id="numPerson" style="width:100%">
                                    <option value="0"></option>
                                    <option value="alone">Một mình</option>
                                    <option value="groups2pTo4p">Nhóm 2-4 người</option>
                                    <option value="groups5pTo8p">Nhóm 5-8 người</option>
                                    <option value="groupsofover20P">Nhóm trên 20 người</option>
                                </select>
                                <p>Địa điểm ở miền nào?</p>
                                <select name="domain" id="domain" style="width:100%">
                                    <option value="0"></option>
                                    <option value="Northern">Miền Bắc</option>
                                    <option value="Central">Miền Trung</option>
                                    <option value="South">Miền Nam</option>
                                </select>
                                <p>Nơi nghỉ ngơi</p>
                                <select name="restingPlace" id="location" style="width:100%">
                                    <option value="0"></option>
                                    <option value="hotel">Khách sạn</option>
                                    <option value="Homestay">Homestay</option>
                                    <option value="home">Nhà riêng</option>
                                    <option value="No">Không ở</option>
                                </select>
                                <p>Phương tiện di chuyển</p>
                                <select name="vehicle" id="trans" style="width:100%">
                                    <option value="0"></option>
                                    <option value="motorcycle">Xe máy</option>
                                    <option value="coach">Xe khách</option>
                                    <option value="planes">Máy bay</option>

                                </select>
                                <p>Loại hình đi du lịch</p>
                                <select name="tyleTravel" id="tyleTravel" style="width:100%">
                                    <option value="0"></option>
                                    <option value="Bien">Đi biển</option>
                                    <option value="Nui">Đi núi</option>
                                    <option value="DanhLam">Đi danh lam thắng cảnh</option>

                                </select>
                                <p>Số ngày đi du lịch</p>
                                <select name="day" id="day" style="width:100%">
                                    <option value="0"></option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                    <option value="7">7</option>
                                    <option value="8">8</option>
                                    <option value="9">9</option>
                                    <option value="10">10</option>
                                    <option value="11">11</option>
                                    <option value="12">12</option>
                                    <option value="13">13</option>
                                    <option value="14">14</option>
                                    <option value="15">15</option>
                                    <option value="16">16</option>
                                    <option value="17">17</option>
                                    <option value="18">18</option>
                                    <option value="19">19</option>
                                    <option value="20">20</option>
                                    <option value="21">21</option>
                                    <option value="22">22</option>
                                    <option value="23">23</option>
                                    <option value="24">24+</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="col-2">
                        <br />
                        <br />
                        <button type="submit" class="btn btn-primary btn-lg btn-block">
                            Gợi ý
                            <svg style="margin-top:-5px" width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-cursor-fill"
                                 fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                <path fill-rule="evenodd"
                                      d="M14.082 2.182a.5.5 0 0 1 .103.557L8.528 15.467a.5.5 0 0 1-.917-.007L5.57 10.694.803 8.652a.5.5 0 0 1-.006-.916l12.728-5.657a.5.5 0 0 1 .556.103z" />
                            </svg>
                        </button>
                        <br />
                        <br />
                    </div>
                    <div class="col-4">
                        <div class="card" style="min-height: 300px;">
                            <div class="card-header text-center">
                                <h3>Gởi ý địa điểm du lịch</h3>
                            </div>
                            <div class="card-body">
                                <p>${ketqua}</p>
                            </div>
                        </div>
                        <div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!-- /#page-content-wrapper -->

</div>
<!-- /#wrapper -->

<!-- Bootstrap core JavaScript -->
<script src="<c:url value='/template/vendor/jquery/jquery.min.js' />"></script>
<script src="<c:url value='/template/vendor/bootstrap/js/bootstrap.bundle.min.js' />"></script>
<script >
    $(document).ready(function () {
        $('#dt-vertical-scroll').dataTable({
            "paging": false,
            "fnInitComplete": function () {
                var myCustomScrollbar = document.querySelector('#dt-vertical-scroll_wrapper .dataTables_scrollBody');
                var ps = new PerfectScrollbar(myCustomScrollbar);
            },
            "scrollY": 450,
        });
    });
</script>
<!-- Menu Toggle Script -->
<script>
    $("#menu-toggle").click(function (e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
</script>
</body>
</html>
