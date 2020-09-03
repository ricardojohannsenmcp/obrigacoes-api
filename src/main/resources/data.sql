insert into grupo_usuario(grupo_usuario_id, nome) values (1,'Administrador');
insert into grupo_usuario(grupo_usuario_id, nome) values(2,'Coordenador');
insert into grupo_usuario(grupo_usuario_id, nome) values(3,'Contador');


insert into permissao(permissao_id,descricao) values (1,'Módulo Processo');
insert into permissao(permissao_id,descricao) values(2,'Módulo Obrigações');


insert into grupo_permissao(grupo_usuario_id,permissao_id) values (1,1);
insert into grupo_permissao(grupo_usuario_id,permissao_id) values (1,2);

insert into grupo_permissao(grupo_usuario_id,permissao_id) values (2,1);
insert into grupo_permissao(grupo_usuario_id,permissao_id) values (2,2);


insert into grupo_permissao(grupo_usuario_id,permissao_id) values (3,1);
insert into grupo_permissao(grupo_usuario_id,permissao_id) values (3,2);




insert into tipo_evento_processo(tipo_evento_processo_id,descricao) values (1,'Rit inicial');
insert into tipo_evento_processo(tipo_evento_processo_id,descricao) values (2,'Pedido de prorrogação de prazo');
insert into tipo_evento_processo(tipo_evento_processo_id,descricao) values (3,'Defesa');
insert into tipo_evento_processo(tipo_evento_processo_id,descricao) values (4,'Rit conclusivo');
insert into tipo_evento_processo(tipo_evento_processo_id,descricao) values (5,'Parecer do MP');
insert into tipo_evento_processo(tipo_evento_processo_id,descricao) values (6,'Voto');
insert into tipo_evento_processo(tipo_evento_processo_id,descricao) values (7,'Embargo');
insert into tipo_evento_processo(tipo_evento_processo_id,descricao) values (8,'Recurso de revisão');
insert into tipo_evento_processo(tipo_evento_processo_id,descricao) values (9,'Recurso de reconsideração');


insert into frequencia (frequencia_id,descricao) values (1,'Mensal');
insert into frequencia (frequencia_id,descricao) values (2,'Bimestral');
insert into frequencia (frequencia_id,descricao) values (3,'Quadrimestral');
insert into frequencia (frequencia_id,descricao) values (4,'Semestral');
insert into frequencia (frequencia_id,descricao) values (5,'Anual');


insert into periodo (periodo_id,descricao,frequencia_id) values (1,'Janeiro',1);
insert into periodo (periodo_id,descricao,frequencia_id) values (2,'Fevereiro',1);
insert into periodo (periodo_id,descricao,frequencia_id) values (3,'Março',1);
insert into periodo (periodo_id,descricao,frequencia_id) values (4,'Abril',1);
insert into periodo (periodo_id,descricao,frequencia_id) values (5,'Maio',1);
insert into periodo (periodo_id,descricao,frequencia_id) values (6,'Junho',1);
insert into periodo (periodo_id,descricao,frequencia_id) values (7,'Julho',1);
insert into periodo (periodo_id,descricao,frequencia_id) values (8,'Agosto',1);
insert into periodo (periodo_id,descricao,frequencia_id) values (9,'Setembro',1);
insert into periodo (periodo_id,descricao,frequencia_id) values (10,'Outubro',1);
insert into periodo (periodo_id,descricao,frequencia_id) values (11,'Novembro',1);
insert into periodo (periodo_id,descricao,frequencia_id) values (12,'Dezembro',1);

insert into periodo (periodo_id,descricao,frequencia_id) values (13,'Primeiro Bimestre',2);
insert into periodo (periodo_id,descricao,frequencia_id) values (14,'Segundo Bimestre',2);
insert into periodo (periodo_id,descricao,frequencia_id) values (15,'Terceiro Bimestre',2);
insert into periodo (periodo_id,descricao,frequencia_id) values (16,'Quarto Bimestre',2);
insert into periodo (periodo_id,descricao,frequencia_id) values (17,'Quinto Bimestre',2);
insert into periodo (periodo_id,descricao,frequencia_id) values (18,'Sexto Bimestre',2);


insert into periodo (periodo_id,descricao,frequencia_id) values (19,'Primeiro Quadrimestre',3);
insert into periodo (periodo_id,descricao,frequencia_id) values (20,'Segundo Quadrimestre',3);
insert into periodo (periodo_id,descricao,frequencia_id) values (21,'Terceiro Quadrimestre',3);


insert into periodo (periodo_id,descricao,frequencia_id) values (22,'Primeiro Semestre',4);
insert into periodo (periodo_id,descricao,frequencia_id) values (23,'SegundomSemestre',4);


insert into periodo (periodo_id,descricao,frequencia_id) values (24,'Exercício',5);


insert into ente(ente_id,nome) values (2111300,'São Luís'),(2100055,'Açailândia'),(2102200,'Buriti');


insert into sistema (sistema_id,nome) values (1,'PGFN/RFB');
insert into sistema (sistema_id,nome) values (2,'CAIXA');
insert into sistema (sistema_id,nome) values (3,'SAHEM');
insert into sistema (sistema_id,nome) values (4,'CADIN');
insert into sistema (sistema_id,nome) values (5,'SIAFI/Subsistema Transferências');
insert into sistema (sistema_id,nome) values (6,'SICONV');
insert into sistema (sistema_id,nome) values (7,'SICONFI');
insert into sistema (sistema_id,nome) values (8,'SIOPE');
insert into sistema (sistema_id,nome) values (9,'SADIPEM');
insert into sistema (sistema_id,nome) values (10,'MS/SIOPS');
insert into sistema (sistema_id,nome) values (11,'SPPS');



insert into grupo_obrigacao (grupo_obrigacao_id,descricao) values (1,'Obrigações de Adimplência Financeira');


insert into obrigacao (obrigacao_id,grupo_obrigacao_id,descricao,sistema_id,frequencia_id) values (1,1,'Regularidade quanto a Tributos, a Contribuições Previdenciárias Federais e à Dívida Ativa da União',1,5);
insert into obrigacao (obrigacao_id,grupo_obrigacao_id,descricao,sistema_id,frequencia_id) values (2,1,'Regularidade quanto a Contribuições para o FGTS',2,5);
insert into obrigacao (obrigacao_id,grupo_obrigacao_id,descricao,sistema_id,frequencia_id) values (3,1,'Regularidade em relação à Adimplência Financeira em Empréstimos e Financiamentos concedidos pela União',3,5);
insert into obrigacao (obrigacao_id,grupo_obrigacao_id,descricao,sistema_id,frequencia_id) values (4,1,'Regularidade perante o Poder Público Federal ',4,5);




insert into grupo_obrigacao  (grupo_obrigacao_id,descricao) values (2,'Adimplemento na Prestação de Contas de Convênios');

insert into obrigacao (obrigacao_id,grupo_obrigacao_id,descricao,sistema_id,frequencia_id) values (5,2,'SIAFI/Subsistema Transferências',5,3);
insert into obrigacao (obrigacao_id,grupo_obrigacao_id,descricao,sistema_id,frequencia_id) values (6,2,'SICONVI',6,3);



insert into grupo_obrigacao   (grupo_obrigacao_id,descricao) values (3, 'Obrigações de Transparência');

insert into obrigacao (obrigacao_id,grupo_obrigacao_id,descricao,sistema_id,frequencia_id) values (7,3,'Encaminhamento do Relatório de Gestão Fiscal - RGF',7,3);
insert into obrigacao (obrigacao_id,grupo_obrigacao_id,descricao,sistema_id,frequencia_id) values (8,3,'Encaminhamento do Relatório Resumido de Execução Orçamentária ao Siconfi',7,3);
insert into obrigacao (obrigacao_id,grupo_obrigacao_id,descricao,sistema_id,frequencia_id) values (9,3,'Encaminhamento do Anexo 8 do Relatório Resumido de Execução Orçamentária ao Siope ',8,3);
insert into obrigacao (obrigacao_id,grupo_obrigacao_id,descricao,sistema_id,frequencia_id) values (10,3,'Encaminhamento das Contas Anuais ',7,3);
insert into obrigacao (obrigacao_id,grupo_obrigacao_id,descricao,sistema_id,frequencia_id) values (11,3,'Encaminhamento da Matriz de Saldos Contábeis',7,3);
insert into obrigacao (obrigacao_id,grupo_obrigacao_id,descricao,sistema_id,frequencia_id) values (12,3,'Encaminhamento de Informações para o Cadastro da Dívida Pública - CDP',9,3);


insert into grupo_obrigacao (grupo_obrigacao_id,descricao) values (4,'Adimplemento de Obrigações Constitucionais ou Legais');
insert into obrigacao (obrigacao_id,grupo_obrigacao_id,descricao,sistema_id,frequencia_id) values (14,4,'Exercício da Plena Competência Tributária ',7,3);
insert into obrigacao (obrigacao_id,grupo_obrigacao_id,descricao,sistema_id,frequencia_id) values (15,4,'Aplicação Mínima de recursos em Educação ',8,3);
insert into obrigacao (obrigacao_id,grupo_obrigacao_id,descricao,sistema_id,frequencia_id) values (16,4,'Aplicação Mínima de recursos em Saúde ',10,3);
insert into obrigacao (obrigacao_id,grupo_obrigacao_id,descricao,sistema_id,frequencia_id) values (17,4,'Regularidade Previdenciária',11,3);

