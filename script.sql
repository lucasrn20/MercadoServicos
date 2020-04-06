CREATE DATABASE `mercadoservicos` /*!40100 DEFAULT CHARACTER SET latin1 */;
use mercadoservicos;

CREATE TABLE `categoria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

CREATE TABLE `servicos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) NOT NULL,
  `preco` double NOT NULL,
  `idCategoria` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `categoria_fk_idx` (`idCategoria`),
  CONSTRAINT `categoria_fk` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `senha` varchar(100) NOT NULL,
  `tipo` varchar(1) NOT NULL,
  `cpf` varchar(45) DEFAULT NULL,
  `cnpj` varchar(45) DEFAULT NULL,
  `dtNasc` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `ordemservico` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dataHora` datetime NOT NULL,
  `observacao` varchar(200) DEFAULT NULL,
  `idCliente` int(11) NOT NULL,
  `idEmpresa` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cliente_fk_idx` (`idCliente`),
  KEY `empresa_fk_idx` (`idEmpresa`),
  CONSTRAINT `cliente_fk` FOREIGN KEY (`idCliente`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `empresa_fk` FOREIGN KEY (`idEmpresa`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `itensos` (
  `idOrdemServico` int(11) NOT NULL,
  `sequencia` int(11) NOT NULL,
  `idServico` int(11) NOT NULL,
  `preco` double NOT NULL,
  `quantidade` double NOT NULL,
  PRIMARY KEY (`idOrdemServico`,`sequencia`),
  KEY `servico_fk_idx` (`idServico`),
  CONSTRAINT `ordem_servico_fk` FOREIGN KEY (`idOrdemServico`) REFERENCES `ordemservico` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `servico_fk` FOREIGN KEY (`idServico`) REFERENCES `servicos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
