<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="https://kit.fontawesome.com/d2fb96c0f6.js" crossorigin="anonymous"></script>

<!-- Sidebar -->
<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

  <!-- Sidebar - Brand -->
  <div class="sidebar-brand d-flex align-items-center justify-content-center" href="/CoralloSmart/" style="height: 120px">

        <a href="goToIndexARPA"><img src="<c:url value="/images/logoCoralloSmart.png"/>" width="100px" height="100px"
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

  <!-- Nav Item - Modifica Profilo -->
  <li class="nav-item">
    <a class="nav-link" href="modificaProfiloARPA">
      <i class="fas fa-edit"></i>
      <span>Modifica Profilo</span></a>
  </li>

  <!-- Nav Item - Crea responsabile ARPA -->
  <li class="nav-item">
    <a class="nav-link" href="registrationResponsabileARPA">
      <i class="fa fa-user-plus"></i>
      <span>Registra un responsabile ARPA</span></a>
  </li>

  <!-- Nav Item - Dashboard -->
  <li class="nav-item">
    <a class="nav-link" href="visualizzaIncassi">
      <i class="fas fa-donate"></i>
      <span>Visualizza Incassi</span></a>
  </li>

  <!-- Nav Item - Dashboard -->
  <li class="nav-item">
    <a class="nav-link" href="statoDispositivi">
      <i class="fas fa-fw fa-chart-area"></i>
      <span>Stato Dispositivi</span></a>
  </li>

  <li class="nav-item">
    <a class="nav-link" href="monitoraggio">
      <i class="fab fa-watchman-monitoring"></i>
      <span>Monitoraggio</span></a>
  </li>

  <li class="nav-item">
    <a class="nav-link" href="aggiungiVoucher">
      <i class="fa-solid fa-plus"></i>
      <span>Aggiungi Voucher</span></a>
  </li>

  <li class="nav-item">
    <a class="nav-link" href="gestioneVoucher">
      <i class="fa fa-tasks"></i>
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
