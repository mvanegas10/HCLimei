import codecs

rfd = '/Users/Meili/Downloads/backup_db2017-01-16.sql'
wfd = '/Users/Meili/Downloads/backup.sql'

reader = codecs.open(rfd,'r','utf-8')

writer = codecs.open(wfd,'w','utf-8')

for rline in reader:
	try:
		rline.index('CREATE ALGORITHM=UNDEFINED DEFINER=`serapise_serapis`@`localhost`')
		break
	except:
		new_line = rline.replace('date NOT NULL', 'date')
		new_line = rline.replace('NOT NULL', '')
		new_line = new_line.replace('CREATE TABLE ', "SET sql_mode = 'ALLOW_INVALID_DATES'; \n CREATE TABLE ")
		# new_line = new_line.replace('CREATE ALGORITHM=UNDEFINED DEFINER=`serapise_serapis`@`localhost`', 'CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost`")
		new_line = new_line.replace("'0000-00-00'","NULL")
		new_line = new_line.replace("'David Giraldo'","'Meili Vanegas'")
		new_line = new_line.replace("'dgiraldo'","'mvanegas10'")
		writer.write(new_line)

writer.write('ALTER TABLE pacientes MODIFY id_religion tinyint(3) unsigned;\n')
writer.write('ALTER TABLE pacientes MODIFY id_ocupacion tinyint(3) unsigned;\n')
writer.write('ALTER TABLE pacientes MODIFY id_escolaridad tinyint(3) unsigned;\n')
writer.write('ALTER TABLE pacientes MODIFY id_profesion tinyint(3) unsigned;\n')
writer.write('ALTER TABLE pacientes MODIFY id_estadocivil tinyint(3) unsigned;\n')
writer.write('ALTER TABLE pacientes MODIFY tel_oficina varchar(50);\n')
writer.write('ALTER TABLE pacientes MODIFY fax varchar(50);\n')
writer.write('ALTER TABLE pacientes MODIFY fecha_hora_atencion TIMESTAMP DEFAULT CURRENT_TIMESTAMP;\n')
writer.write('ALTER TABLE pacientes MODIFY id_tipo_ss tinyint(3) unsigned;\n')
writer.write('ALTER TABLE pacientes MODIFY tipo_ss_2 varchar(20);\n')
writer.write('ALTER TABLE pacientes MODIFY foto varchar(200);\n')
writer.write('ALTER TABLE pacientes MODIFY huella varchar(200);\n')
writer.write('ALTER TABLE pacientes MODIFY firma varchar(200);\n')
writer.write('ALTER TABLE pacientes MODIFY informante varchar(200);\n')
writer.write('ALTER TABLE pacientes MODIFY acompanante varchar(200);\n')
writer.write('ALTER TABLE pacientes MODIFY id_parentesco tinyint(3) unsigned;\n')
writer.write('ALTER TABLE pacientes MODIFY id_captacion tinyint(3) unsigned;\n')
writer.write('ALTER TABLE pacientes MODIFY departamento varchar(3);\n')
writer.write('ALTER TABLE pacientes MODIFY municipio varchar(10);\n')
writer.write('ALTER TABLE pacientes MODIFY rh varchar(4);\n')

writer.write('ALTER TABLE pacientes ADD ocupacion VARCHAR(200);\n')
writer.write('UPDATE pacientes p LEFT JOIN ocupacion o ON p.id_ocupacion = o.id_ocupacion SET p.ocupacion = o.ocupacion;\n')

writer.write("# | Vaciado de tabla 'a_patologicos'\nDROP TABLE IF EXISTS `a_patologicos`;\n# | Estructura de la tabla 'a_patologicos'\nSET sql_mode = 'ALLOW_INVALID_DATES';\n CREATE TABLE `a_patologicos` (\n`id_patologicos` bigint(20) unsigned NOT NULL AUTO_INCREMENT,\n`fecha_antecedente` date,\n`id_paciente` bigint(20) unsigned NOT NULL,\n`tipo` text,\n`descripcion` text NOT NULL,\nPRIMARY KEY (`id_patologicos`))ENGINE=InnoDB AUTO_INCREMENT=758 DEFAULT CHARSET=utf8;\n")
writer.write("INSERT INTO a_patologicos (id_paciente,fecha_antecedente,descripcion) SELECT id_paciente,fecha as fecha_antecedente,otro as descripcion FROM ap_boca;\n")
writer.write("UPDATE a_patologicos SET tipo = 'boca' WHERE tipo IS NULL;\n")

writer.write("INSERT INTO a_patologicos (id_paciente,fecha_antecedente,descripcion) SELECT id_paciente,fecha as fecha_antecedente,cancer as descripcion FROM ap_cancer;\n")
writer.write("UPDATE a_patologicos SET tipo = 'cancer' WHERE tipo IS NULL;\n")

writer.write("INSERT INTO a_patologicos (id_paciente,fecha_antecedente,descripcion) SELECT id_paciente,fecha as fecha_antecedente,otro as descripcion FROM ap_cardiovascular;\n")
writer.write("UPDATE a_patologicos SET tipo = 'cardiovascular' WHERE tipo IS NULL;\n")

writer.write("INSERT INTO a_patologicos (id_paciente,fecha_antecedente,descripcion) SELECT id_paciente,fecha as fecha_antecedente,otro as descripcion FROM ap_dermatologicos;\n")
writer.write("UPDATE a_patologicos SET tipo = 'dermatologicos' WHERE tipo IS NULL;\n")

writer.write("INSERT INTO a_patologicos (id_paciente,fecha_antecedente,descripcion) SELECT id_paciente,fecha as fecha_antecedente,otro as descripcion FROM ap_endocrino;\n")
writer.write("UPDATE a_patologicos SET tipo = 'endocrino' WHERE tipo IS NULL;\n")

writer.write("INSERT INTO a_patologicos (id_paciente,fecha_antecedente,descripcion) SELECT id_paciente,fecha as fecha_antecedente,otro as descripcion FROM ap_gastrointestinal;\n")
writer.write("UPDATE a_patologicos SET tipo = 'gastrointestinal' WHERE tipo IS NULL;\n")

writer.write("INSERT INTO a_patologicos (id_paciente,fecha_antecedente,descripcion) SELECT id_paciente,fecha as fecha_antecedente,otro as descripcion FROM ap_genitales;\n")
writer.write("UPDATE a_patologicos SET tipo = 'genitales' WHERE tipo IS NULL;\n")

writer.write("INSERT INTO a_patologicos (id_paciente,fecha_antecedente,descripcion) SELECT id_paciente,fecha as fecha_antecedente,otro as descripcion FROM ap_ginecologico;\n")
writer.write("UPDATE a_patologicos SET tipo = 'ginecologico' WHERE tipo IS NULL;\n")

writer.write("INSERT INTO a_patologicos (id_paciente,fecha_antecedente,descripcion) SELECT id_paciente,fecha as fecha_antecedente,otro as descripcion FROM ap_nervioso;\n")
writer.write("UPDATE a_patologicos SET tipo = 'nervioso' WHERE tipo IS NULL;\n")

writer.write("INSERT INTO a_patologicos (id_paciente,fecha_antecedente,descripcion) SELECT id_paciente,fecha as fecha_antecedente,otro as descripcion FROM ap_oftalmologicos;\n")
writer.write("UPDATE a_patologicos SET tipo = 'oftalmologicos' WHERE tipo IS NULL;\n")

writer.write("INSERT INTO a_patologicos (id_paciente,fecha_antecedente,descripcion) SELECT id_paciente,fecha as fecha_antecedente,otro as descripcion FROM ap_osteomuscular;\n")
writer.write("UPDATE a_patologicos SET tipo = 'osteomuscular' WHERE tipo IS NULL;\n")

writer.write("INSERT INTO a_patologicos (id_paciente,fecha_antecedente,descripcion) SELECT id_paciente,fecha as fecha_antecedente,otro as descripcion FROM ap_otorrino;\n")
writer.write("UPDATE a_patologicos SET tipo = 'otorrino' WHERE tipo IS NULL;\n")

writer.write("INSERT INTO a_patologicos (id_paciente,fecha_antecedente,descripcion) SELECT id_paciente,fecha as fecha_antecedente,otro as descripcion FROM ap_respiratorio;\n")
writer.write("UPDATE a_patologicos SET tipo = 'respiratorio' WHERE tipo IS NULL;\n")

writer.write("INSERT INTO a_patologicos (id_paciente,fecha_antecedente,descripcion) SELECT id_paciente,fecha as fecha_antecedente,otro as descripcion FROM ap_urinario;\n")
writer.write("UPDATE a_patologicos SET tipo = 'urinario' WHERE tipo IS NULL;\n")

writer.write("ALTER TABLE a_farmacologicos_hospitalarios MODIFY farmacologicos text DEFAULT NULL;\n")
writer.write("ALTER TABLE a_farmacologicos_hospitalarios MODIFY hospitalarios text DEFAULT NULL;\n")

writer.write("ALTER TABLE a_quirurgicos_alergicos MODIFY quirurgicos text DEFAULT NULL;\n")
writer.write("ALTER TABLE a_quirurgicos_alergicos MODIFY alergicos text DEFAULT NULL;\n")

writer.write("ALTER TABLE a_toxicos MODIFY tabaquismo text DEFAULT NULL;\n")
writer.write("ALTER TABLE a_toxicos MODIFY alcohol text DEFAULT NULL;\n")
writer.write("ALTER TABLE a_toxicos MODIFY drogas text DEFAULT NULL;\n")
writer.write("ALTER TABLE a_toxicos MODIFY otro text DEFAULT NULL;\n")

writer.write("ALTER TABLE a_traumaticos MODIFY traumaticos text DEFAULT NULL;\n")
writer.write("ALTER TABLE a_traumaticos MODIFY transfusionales text DEFAULT NULL;\n")

writer.write("ALTER TABLE a_ginecologicos MODIFY menarquia tinyint(3) unsigned;\n")
writer.write("ALTER TABLE a_ginecologicos MODIFY menopausia int(10) unsigned;\n")
writer.write("ALTER TABLE a_ginecologicos MODIFY embarazada varchar(3);\n")
writer.write("ALTER TABLE a_ginecologicos MODIFY G varchar(5);\n")
writer.write("ALTER TABLE a_ginecologicos MODIFY P varchar(5);\n")
writer.write("ALTER TABLE a_ginecologicos MODIFY C varchar(5);\n")
writer.write("ALTER TABLE a_ginecologicos MODIFY A varchar(5);\n")
writer.write("ALTER TABLE a_ginecologicos MODIFY V varchar(5);\n")
writer.write("ALTER TABLE a_ginecologicos MODIFY planifica varchar(3);\n")
writer.write("ALTER TABLE a_ginecologicos MODIFY texto_planifica varchar(100) DEFAULT 'NO REFIERE';\n")
writer.write("ALTER TABLE a_ginecologicos MODIFY otro varchar(200) DEFAULT 'NO REFIERE';\n")
writer.write("ALTER TABLE a_ginecologicos MODIFY periodos varchar(45) DEFAULT 'NO REFIERE';\n")
writer.write("ALTER TABLE a_ginecologicos MODIFY tiempo varchar(45) DEFAULT 'NO REFIERE';\n")


reader.close()
writer.close()
