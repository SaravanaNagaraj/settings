<!doctype html>
<html lang="en">
<head>
<title>Database | Pointel</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">

<!-- VENDOR CSS -->
<link rel="stylesheet" href="assets/vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/vendor/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="assets/vendor/linearicons/style.css">
<link rel="stylesheet" href="assets/vendor/chartist/css/chartist-custom.css">

<!-- MAIN CSS -->
<link rel="stylesheet" href="assets/css/main.css">

<!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
<link rel="stylesheet" href="assets/css/demo.css">

<!-- GOOGLE FONTS -->
<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">

<!-- ICONS -->
<link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
<link rel="icon" type="image/png" sizes="96x96" href="assets/img/Logo1.png">
</head>

<body>
	<!-- WRAPPER -->
	<div id="wrapper">

		<!-- NAVBAR -->
		<nav class="navbar navbar-default navbar-fixed-top">
			<div class="brand">
				<a href="Database.html"><img src="assets/img/lo.png" alt="Klorofil Logo" class="img-responsive logo"></a>
			</div>
			<div class="container-fluid">
				<div class="navbar-btn">
					<button type="button" class="btn-toggle-fullwidth">
						<i class="lnr lnr-arrow-left-circle"></i>
					</button>
				</div>
				<div id="navbar-menu">
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"><i class="fa fa-user-circle"></i><span>Settings</span>
								<i class="icon-submenu lnr lnr-chevron-down"></i></a>
							<ul class="dropdown-menu">
								<li><a href="Logout.html"><i class="lnr lnr-exit"></i> <span>Logout</span></a></li>
							</ul></li>
					</ul>
				</div>
			</div>
		</nav>
		<!-- END NAVBAR -->

		<!-- LEFT SIDEBAR -->
		<div id="sidebar-nav" class="sidebar">
			<div class="sidebar-scroll">
				<nav>
					<ul class="nav">
						<li><a href="Database.html" class="active"><i
								class="fa fa-cogs"></i> <span>Database</span></a></li>
						<li><a href="Logger.html" class=""><i
								class="lnr lnr-dice"></i> <span>Logger</span></a></li>
						<li><a href="#subPages" data-toggle="collapse"
							class="collapsed"><i class="lnr lnr-file-empty"></i> <span>Application</span>
								<i class="icon-submenu lnr lnr-chevron-left"></i></a>
							<div id="subPages" class="collapse ">
								<ul class="nav">
									<li><a href="General.html" class="">General</a></li>
								</ul>
							</div></li>
						<li><a href="ChangePassword.html" class=""><i
						class="fa fa-key"></i> <span>Change Password</span></a></li>
					</ul>
				</nav>
			</div>
		</div>
		<!-- END LEFT SIDEBAR -->

		<!-- MAIN -->
		<div class="main">
			<!-- MAIN CONTENT -->
			<div class="main-content">
				<div class="container-fluid">
					<div class="panel panel-default">
						<div class="panel-heading">Database Settings</div>
						<div class="panel-body">
							<form class="form-horizontal" action="Database.html"
								method="post">
								<div class="form-group">
									<label class="control-label col-sm-4" for="ip">IP :</label>
									<div class="col-sm-5">
										<input type="text" class="form-control" id="ip" name="ip" value="${database.ip}">
									</div>
								</div>
								
								<div class="form-group">
									<label class="control-label col-sm-4" for="port">Port :</label>
									<div class="col-sm-5">
										<input type="text" class="form-control" id="port" name="port" value="${database.port}">
									</div>
								</div>
								
								<div class="form-group">
									<label class="control-label col-sm-4" for="dbName">
										Database :</label>
									<div class="col-sm-5">
										<input type="text" class="form-control" id="dbName" name="dbName" value="${database.dbName}">
									</div>
								</div>
								
								<div class="form-group">
									<label class="control-label col-sm-4" for="userName">User
										Name :</label>
									<div class="col-sm-5">
										<input type="text" class="form-control" id="userName" name="userName" value="${database.userName}">
									</div>
								</div>
								
								<div class="form-group">
									<label class="control-label col-sm-4" for="pwd">Password :</label>
									<div class="col-sm-5">
										<input type="text" class="form-control" id="pwd" name="password" value="${database.password}">
									</div>
								</div>

								<div class="form-group">
									<div class="col-sm-offset-6 col-sm-6">
										<button type="submit" class="btn btn-info btn-md">Save</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- END MAIN CONTENT -->

		<!-- END MAIN -->
		<div class="clearfix"></div>
		<footer>
			<div class="container-fluid">
				<p class="copyright">
					&copy; 2018 <a href="#">Pointel</a>. All Rights Reserved.
				</p>
			</div>
		</footer>
	</div>
	<!-- END WRAPPER -->

	<!-- Javascript -->
	<script src="assets/vendor/jquery/jquery.min.js"></script>
	<script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<script src="assets/vendor/jquery.easy-pie-chart/jquery.easypiechart.min.js"></script>
	<script src="assets/vendor/chartist/js/chartist.min.js"></script>
	<script src="assets/scripts/klorofil-common.js"></script>
	<!--END Javascript -->

</body>
</html>