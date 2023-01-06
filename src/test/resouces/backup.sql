create database corallosmart;
use corallosmart;

CREATE TABLE `Utente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(32) NOT NULL,
  `cognome` varchar(32) NOT NULL,
  `codiceFiscale` varchar(16) NOT NULL,
  `username` varchar(32) NOT NULL,
  `email` varchar(32) NOT NULL,
  `telefono` varchar(14) DEFAULT NULL,
  `tipo` tinyint(4) NOT NULL,
  `password` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `Dispositivo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `latitudine` varchar(16) NOT NULL,
  `longitudine` varchar(16) NOT NULL,
  `qualita` varchar(32) DEFAULT NULL,
  `dataImmersione` date NOT NULL,
  `DOSensor` int(11) NOT NULL,
  `ORPSensor` int(11) NOT NULL,
  `pHSensor` int(11) NOT NULL,
  `TurbiditySensor` int(11) NOT NULL,
  `TDSSensor` int(11) NOT NULL,
  `TempSensor` int(11) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `Rilevamento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dataRicezione` date NOT NULL,
  `latitudine` varchar(16) NOT NULL,
  `longitudine` varchar(16) NOT NULL,
  `DissolvedOxygen` double DEFAULT NULL,
  `OxidationReductionPotential` double DEFAULT NULL,
  `pHTurbidity` double DEFAULT NULL,
  `TotalDissolvedSolids` double DEFAULT NULL,
  `turbidity` double DEFAULT NULL,
  `temperatura` varchar(10) DEFAULT NULL,
  `idDispositivo` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `dispositivo_idx` (`idDispositivo`),
  CONSTRAINT `dispositivo` FOREIGN KEY (`idDispositivo`) REFERENCES `Dispositivo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `voucher` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descrizione` varchar(100) DEFAULT NULL,
  `importo` double NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `email` (
  `id` int NOT NULL AUTO_INCREMENT,
  `oggetto` varchar(32) NOT NULL,
  `corpo` varchar(100) NOT NULL,
  `idUtente2` int NOT NULL,
  `idVoucher` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `utente_idx2` (`idUtente2`),
  KEY `voucher_idx` (`idVoucher`),
  CONSTRAINT `utente2` FOREIGN KEY (`idUtente2`) REFERENCES `utente` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `voucher` FOREIGN KEY (`idVoucher`) REFERENCES `voucher` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `contributo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `data` date NOT NULL,
  `importo` double NOT NULL,
  `idUtente` int NOT NULL,
  `idEmail` int NOT NULL,
  `idVoucher2` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `utente_idx` (`idUtente`),
  KEY `email_idx` (`idEmail`),
  KEY `voucher2_idx` (`idVoucher2`),
  CONSTRAINT `email` FOREIGN KEY (`idEmail`) REFERENCES `email` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `utente` FOREIGN KEY (`idUtente`) REFERENCES `utente` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `voucher2` FOREIGN KEY (`idVoucher2`) REFERENCES `voucher` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `monitorarilevamento` (
  `idRilevamento` int NOT NULL,
  `idUtente` int NOT NULL,
  PRIMARY KEY (`idRilevamento`,`idUtente`),
  KEY `rilevamento_idx` (`idRilevamento`),
  KEY `Utente6_idx` (`idUtente`),
  CONSTRAINT `rilevamento` FOREIGN KEY (`idRilevamento`) REFERENCES `rilevamento` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Utente6` FOREIGN KEY (`idUtente`) REFERENCES `utente` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `monitoradispositivo` (
  `idDispositivo` int NOT NULL,
  `idUtente` int NOT NULL,
  PRIMARY KEY (`idDispositivo`,`idUtente`),
  KEY `dispositivo2_idx` (`idDispositivo`),
  KEY `Utente5_idx` (`idUtente`),
  CONSTRAINT `dispositivo2` FOREIGN KEY (`idDispositivo`) REFERENCES `dispositivo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Utente5` FOREIGN KEY (`idUtente`) REFERENCES `utente` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `supervisiona` (
  `idContributo` int NOT NULL,
  `idUtente` int NOT NULL,
  PRIMARY KEY (`idContributo`,`idUtente`),
  KEY `contributo3_idx` (`idContributo`),
  KEY `utente3_idx` (`idUtente`),
  CONSTRAINT `contributo3` FOREIGN KEY (`idContributo`) REFERENCES `contributo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `utente3` FOREIGN KEY (`idUtente`) REFERENCES `utente` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO `corallosmart`.`utente` (`nome`, `cognome`, `codiceFiscale`, `username`, `email`, `telefono`, `tipo`, `password`) VALUES ('giuseppe', 'adinolfi', 'DNLGPP01B05G813S', 'adi', 'giu.adi@gmail.com', '+39 3273734000', '0', 'root');
INSERT INTO `corallosmart`.`utente` (`nome`, `cognome`, `codiceFiscale`, `username`, `email`, `telefono`, `tipo`, `password`) VALUES ('graziano', 'giuseffi', 'DNRGGP02B05G823S', 'giuseffi', 'graziano.giu@gmail.com', '+39 3222222222', '0', 'root');
INSERT INTO `corallosmart`.`utente` (`nome`, `cognome`, `codiceFiscale`, `username`, `email`, `tipo`, `password`) VALUES ('ersilio', 'petretta', 'DNRGGP01B02G813S', 'ersilio', 'ersi.petre@gmail.com', '1', 'root');

INSERT INTO `corallosmart`.`dispositivo` (`latitudine`, `longitudine`, `qualita`, `dataImmersione`, `DOSensor`, `ORPSensor`, `pHSensor`, `TurbiditySensor`, `TDSSensor`, `TempSensor`) VALUES ('40.631786', '14.611058', 'alta', '2020-11-13', '1', '1', '1', '1', '2', '0');
INSERT INTO `corallosmart`.`dispositivo` (`latitudine`, `longitudine`, `qualita`, `dataImmersione`, `DOSensor`, `ORPSensor`, `pHSensor`, `TurbiditySensor`, `TDSSensor`, `TempSensor`) VALUES ('42.631786', '14.611558', 'media', '2021-10-20', '1', '1', '2', '1', '0', '0');
INSERT INTO `corallosmart`.`dispositivo` (`latitudine`, `longitudine`, `qualita`, `dataImmersione`, `DOSensor`, `ORPSensor`, `pHSensor`, `TurbiditySensor`, `TDSSensor`, `TempSensor`) VALUES ('42.631788', '15.611558', 'bassa', '2022-10-25', '0', '0', '1', '1', '0', '2');

INSERT INTO `corallosmart`.`rilevamento` (`dataRicezione`, `latitudine`, `longitudine`, `DissolvedOxygen`, `OxidationReductionPotential`, `pHTurbidity`, `TotalDissolvedSolids`, `turbidity`, `temperatura`, `idDispositivo`) VALUES ('2022-05-06', '40.631786', '14.611058', '6.3', '22.2', '3.2', '3.3', '2.6', '10°C', '1');
INSERT INTO `corallosmart`.`rilevamento` (`dataRicezione`, `latitudine`, `longitudine`, `DissolvedOxygen`, `OxidationReductionPotential`, `turbidity`, `idDispositivo`) VALUES ('2021-12-07', '42.631786', '14.611558', '4.3', '13.3', '3.5', '2');
INSERT INTO `corallosmart`.`rilevamento` (`dataRicezione`, `latitudine`, `longitudine`, `pHTurbidity`, `turbidity`, `idDispositivo`) VALUES ('2022-12-15', '42.631788', '15.611558', '12.4', '12.4', '3');

INSERT INTO `corallosmart`.`voucher` (`descrizione`, `importo`) VALUES ('giro in barca', '40');
INSERT INTO `corallosmart`.`voucher` (`descrizione`, `importo`) VALUES ('giro in barca + immersione', '70');
INSERT INTO `corallosmart`.`voucher` (`descrizione`, `importo`) VALUES ('giro in barca + immersione + pranzo', '100');

INSERT INTO `corallosmart`.`email` (`oggetto`, `corpo`, `idUtente2`, `idVoucher`) VALUES ('voucher ottenuto', 'è stato ottenuto il voucher \"giro in barca\"', '1', '1');
INSERT INTO `corallosmart`.`email` (`oggetto`, `corpo`, `idUtente2`, `idVoucher`) VALUES ('voucher ottenuto', 'è stato ottenuto il voucher \"giro in barca + immersione\"', '2', '2');

INSERT INTO `corallosmart`.`contributo` (`data`, `importo`, `idUtente`, `idEmail`, `idVoucher2`) VALUES ('2021-11-12', '40', '1', '1', '1');
INSERT INTO `corallosmart`.`contributo` (`data`, `importo`, `idUtente`, `idEmail`, `idVoucher2`) VALUES ('2021-10-22', '70', '2', '2', '2');

INSERT INTO `corallosmart`.`monitorarilevamento` (`idRilevamento`, `idUtente`) VALUES ('1', '2');
INSERT INTO `corallosmart`.`monitorarilevamento` (`idRilevamento`, `idUtente`) VALUES ('2', '1');
INSERT INTO `corallosmart`.`monitorarilevamento` (`idRilevamento`, `idUtente`) VALUES ('3', '3');

INSERT INTO `corallosmart`.`monitoradispositivo` (`idDispositivo`, `idUtente`) VALUES ('1', '1');
INSERT INTO `corallosmart`.`monitoradispositivo` (`idDispositivo`, `idUtente`) VALUES ('2', '2');
INSERT INTO `corallosmart`.`monitoradispositivo` (`idDispositivo`, `idUtente`) VALUES ('3', '3');

INSERT INTO `corallosmart`.`supervisiona` (`idContributo`, `idUtente`) VALUES ('1', '2');
INSERT INTO `corallosmart`.`supervisiona` (`idContributo`, `idUtente`) VALUES ('2', '2');