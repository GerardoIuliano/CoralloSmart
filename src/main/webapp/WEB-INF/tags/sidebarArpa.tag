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

  <li class="nav-item active">
    <a class="nav-link" >
      <i class="fas fa-fw"></i>
      <span>AREA PRIVATA</span></a>
  </li>

  <!-- Divider -->
  <hr class="sidebar-divider">

  <!-- Heading -->
  <div class="sidebar-heading">
    Responsabile Arpa
  </div>

  <li class="nav-item">
    <a class="nav-link" href="mioProfiloARPA">
      <i class="fas fa-fw fa-user"></i>
      <span>Il Mio Profilo</span></a>
  </li>

  <li class="nav-item">
    <a class="nav-link" href="tutteRecensioni">
      <i class="fas fa-fw fa-comments"></i>
      <span>Modifica Profilo</span></a>
  </li>

  <li class="nav-item">
    <a class="nav-link" href="tuttiAnnunci">
      <i class="fas fa-fw fa-ad"></i>
      <span>Crea Responsabile ARPA</span></a>
  </li>

  <!-- Divider -->
  <hr class="sidebar-divider my-0">

  <!-- Nav Item - Dashboard -->
  <li class="nav-item active">
    <a class="nav-link" href="visualizzaIncassi">
      <i class="fas fa-fw fa-tachometer-alt"></i>
      <span>Visualizza Incassi</span></a>
  </li>

  <!-- Nav Item - Dashboard -->
  <li class="nav-item active">
    <a class="nav-link" href="statoDispositivi">
      <i class="fas fa-fw fa-tachometer-alt"></i>
      <span>Stato Dispositivi</span></a>
  </li>

  <li class="nav-item active">
    <a class="nav-link" href="monitoraggio">
      <i class="fas fa-fw fa-tachometer-alt"></i>
      <span>Monitoraggio</span></a>
  </li>

  <li class="nav-item active">
    <a class="nav-link" href="">
      <i class="fas fa-fw fa-tachometer-alt"></i>
      <span>Aggiungi Voucher</span></a>
  </li>

  <li class="nav-item active">
    <a class="nav-link" href="">
      <i class="fas fa-fw fa-tachometer-alt"></i>
      <span>Gestione Voucher</span></a>
  </li>

  <!-- Divider -->
  <hr class="sidebar-divider d-none d-md-block">

  <!-- Sidebar Toggler (Sidebar) -->
  <div class="text-center d-none d-md-inline">
    <button class="rounded-circle border-0" id="sidebarToggle"></button>
  </div>

</ul>
<!-- End of Sidebar -->
