<%@ taglib prefix="cs" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<cs:layout title="DashBoard" admin="true">
  <script src="/js/formControl.js"></script>
  <div id="wrapper">
    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">
      <!-- Main Content -->
      <div id="content">

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h3 mb-0 text-gray-800">Dashboard del Responsabile ARPA</h1>
          </div>

          <!-- Content Row -->
          <div class="row">

            <!-- Earnings (Monthly) Card Example -->
            <div class="col-xl-3 col-md-6 mb-4">
              <div class="card border-left-primary shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                        Guadagni Ente (Mensili)
                      </div>
                      <div class="h5 mb-0 font-weight-bold text-gray-800">&euro;400,000</div>
                    </div>
                    <div class="col-auto">
                      <i class="fas fa-calendar fa-2x text-gray-300"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <!-- Earnings (Monthly) Card Example -->
            <div class="col-xl-3 col-md-6 mb-4">
              <div class="card border-left-success shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="text-xs font-weight-bold text-success text-uppercase mb-1">
                        Guadagni Ente (Annuali)
                      </div>
                      <div class="h5 mb-0 font-weight-bold text-gray-800">&euro;${incassoTotale}</div>
                    </div>
                    <div class="col-auto">
                      <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <!-- Pending Requests Card Example -->
            <div class="col-xl-3 col-md-6 mb-4">
              <div class="card border-left-warning shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="text-xs font-weight-bold text-warning text-uppercase mb-1">
                        Prenotazioni effettuate attualmente
                      </div>
                      <div class="h5 mb-0 font-weight-bold text-gray-800">${numeroPrenotazioni}</div>
                    </div>
                    <div class="col-auto">
                      <i class="fas fa-comments fa-2x text-gray-300"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <!-- Content Row -->

          <div class="row">

            <!-- Content Column -->
            <div class="col-xl-12 col-lg-12 ">

              <!-- Project Card Example -->
              <div class="card shadow mb-4">
                <div class="card-header py-3">
                  <h6 class="m-0 font-weight-bold text-primary">Affluenza Settimanale Totale</h6>
                </div>
                <div class="card-body">
                  <div class=section-top-border">
                    <div class="progress-table-wrap">
                      <div class="progress-table">
                        <div class="table-head">
                          <div class="country" style="margin: 10px">Giorni</div>
                          <div class="visit">% Prenotazioni</div>
                          <div class="percentage">Grafico</div>
                        </div>
                        <div class="table-row">
                          <div class="country" style="margin: 10px">Luned&igrave;</div>
                          <div class="visit">${lun}</div>
                          <div class="percentage">
                            <div class="progress">
                              <div class="progress-bar color-1" role="progressbar" style="width: ${lun}%"
                                   aria-valuenow="${lun}" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                          </div>
                        </div>

                        <div class="table-row">
                          <div class="country" style="margin: 10px">Marted&igrave;</div>
                          <div class="visit">${mar}</div>
                          <div class="percentage">
                            <div class="progress">
                              <div class="progress-bar color-2" role="progressbar" style="width: ${mar}%"
                                   aria-valuenow="${mar}" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                          </div>
                        </div>
                        <div class="table-row">

                          <div class="country" style="margin: 10px">Mercoled&igrave;</div>
                          <div class="visit">${mer}</div>
                          <div class="percentage">
                            <div class="progress">
                              <div class="progress-bar color-3" role="progressbar" style="width: ${mer}%"
                                   aria-valuenow="${mer}" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                          </div>
                        </div>
                        <div class="table-row">

                          <div class="country" style="margin: 10px">Gioved&igrave;</div>
                          <div class="visit">${gio}</div>
                          <div class="percentage">
                            <div class="progress">
                              <div class="progress-bar color-4" role="progressbar" style="width: ${gio}%"
                                   aria-valuenow="${gio}" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                          </div>
                        </div>
                        <div class="table-row">

                          <div class="country" style="margin: 10px">Venerd&igrave;</div>
                          <div class="visit">${ven}</div>
                          <div class="percentage">
                            <div class="progress">
                              <div class="progress-bar color-5" role="progressbar" style="width: ${ven}%"
                                   aria-valuenow="${ven}" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                          </div>
                        </div>
                        <div class="table-row">

                          <div class="country" style="margin: 10px">Sabato</div>
                          <div class="visit">${sab}</div>
                          <div class="percentage">
                            <div class="progress">
                              <div class="progress-bar color-6" role="progressbar" style="width: ${sab}%"
                                   aria-valuenow="${sab}" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                          </div>
                        </div>
                        <div class="table-row">

                          <div class="country" style="margin: 10px">Domenica</div>
                          <div class="visit">${dom}</div>
                          <div class="percentage">
                            <div class="progress">
                              <div class="progress-bar color-7" role="progressbar" style="width: ${dom}%"
                                   aria-valuenow="${dom}" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>

          </div><!-- chiusura row -->

        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->

      <!-- Footer -->
      <footer class="sticky-footer bg-white">
        <div class="container my-auto">
          <div class="copyright text-center my-auto">
            <span>Copyright &copy; CoralloSmart 2022</span>
          </div>
        </div>
      </footer>
      <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

</cs:layout>
