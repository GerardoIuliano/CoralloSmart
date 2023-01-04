<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Sidebar -->
<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

    <!-- Sidebar - Brand -->
    <div class="sidebar-brand d-flex align-items-center justify-content-center" href="/CoralloSmart/" style="height: 120px">

        <a href="index"><img src="<c:url value="/images/logoCoralloSmart.png"/>" width="100px" height="100px"
                             alt=""></a>
    </div>

    <!-- Divider -->
    <hr class="sidebar-divider my-0">

    <!-- Nav Item - Dashboard -->
    <li class="nav-item active">
        <a class="nav-link" >
            <i class="fas fa-fw"></i>
            <span>AREA PRIVATA</span></a>
    </li>

    <!-- Divider -->
    <hr class="sidebar-divider">

    <!-- Heading -->
    <div class="sidebar-heading">
        Utente
    </div>

    <li class="nav-item">
        <a class="nav-link" href="mioProfilo">
            <i class="fas fa-fw fa-user"></i>
            <span>Il Mio Profilo</span></a>
    </li>

    <!-- Nav Item - Modifica Profilo -->
    <li class="nav-item">
        <a class="nav-link" href="modificaProfilo">
            <i class="fas fa-edit"></i>
            <span>Modifica Profilo</span></a>
    </li>

    <!-- Nav Item - Tables -->
    <li class="nav-item">
        <a class="nav-link" href="contributiEvoucher">
            <i class="fas fa-gift"></i>
            <span>Contributi e Voucher</span></a>
    </li>

    <!-- Divider -->
    <hr class="sidebar-divider d-none d-md-block">

    <!-- Sidebar Toggler (Sidebar) -->
    <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
    </div>

</ul>
<!-- End of Sidebar -->