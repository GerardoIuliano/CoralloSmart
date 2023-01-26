<%@ taglib prefix="cs" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<cs:layout title="HomePage" admin="false">
    <cs:header/>
    <main>
        <!-- Form di ricerca Start-->
        <div class="slider-area ">
            <!-- Mobile Menu -->
            <div class="slider-active">
                <div class="single-slider hero-overly  slider-height d-flex align-items-center"
                     style="background-image: url('/images/fondalemarino.jpg')">
                    <div class="container">
                        <div class="container">
                            <div class="row justify-content-lg-center">
                                <div class="col-xl-9 col-lg-9 col-md-9 center">
                                    <a href="sostienici" class="btn-block genric-btn warning radius btn-lg" name="sostieniciBtn">Sostienici!</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Support Company Start-->
        <div class="support-company-area support-padding fix">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-xl-6 col-lg-6">
                        <div class="support-location-img mb-50">
                            <img src="<c:url value="/images/fondalemarino.jpg"/>" alt="">
                            <div class="support-img-cap">
                                <span>Dispositivi IoT</span>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-6 col-lg-6">
                        <div class="right-caption">
                            <!-- Section Tittle -->
                            <div class="section-tittle section-tittle2">
                                <h2>${numDispositivi} dispositivi installati</h2>
                            </div>
                            <div class="support-caption">
                                <p>Il numero di dispositivi IoT che l'ARPA ha comprato e installato lungo la costa grazie al contributo dei sostenitori</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Support Company End-->

        <!-- Support Company Start-->
        <div class="support-company-area support-padding fix">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-xl-6 col-lg-6">
                        <div class="right-caption">
                            <!-- Section Tittle -->
                            <div class="section-tittle section-tittle2">
                                <h2>${kmBarriera} km di costa monitorati</h2>
                            </div>
                            <div class="support-caption">
                                <p>Questi sono i km di barriera corallina, situata lungo la costa, monitorati e protetti dall'ARPA grazie ai suoi dispositivi IoT</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-6 col-lg-6">
                        <div class="support-location-img mb-50">
                            <img src="<c:url value="/images/fondalemarino.jpg"/>" alt="">
                            <div class="support-img-cap">
                                <span>Monitoraggio</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Support Company End-->

        <!-- Support Company Start-->
        <div class="support-company-area support-padding fix">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-xl-6 col-lg-6">
                        <div class="support-location-img mb-50">
                            <img src="<c:url value="/images/fondalemarino.jpg"/>" alt="">
                            <div class="support-img-cap">
                                <span>Pesci Salvati</span>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-6 col-lg-6">
                        <div class="right-caption">
                            <!-- Section Tittle -->
                            <div class="section-tittle section-tittle2">
                                <h2>${numPesci} pesci salvati</h2>
                            </div>
                            <div class="support-caption">
                                <p>Questi sono i pesci monitorati e protetti dall'ARPA grazie ai suoi dispositivi IoT</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Support Company End-->
    </main>
    <cs:footer/>
</cs:layout>