import codecs

rfd = '/home/meili/Downloads/backup_db2016-12-27.sql'
wfd = '/home/meili/Downloads/backup.sql'

reader = codecs.open(rfd,'r','utf-8')

writer = codecs.open(wfd,'w','utf-8')

for rline in reader:
	try:
		rline.index('CREATE ALGORITHM=UNDEFINED DEFINER=`serapise_serapis`@`localhost`')
		break
	except:
		new_line = rline.replace('date NOT NULL', 'date')
		new_line = new_line.replace('CREATE TABLE ', "SET sql_mode = 'ALLOW_INVALID_DATES'; \n CREATE TABLE ")
		# new_line = new_line.replace('CREATE ALGORITHM=UNDEFINED DEFINER=`serapise_serapis`@`localhost`', 'CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost`")
		new_line = new_line.replace("'0000-00-00'","NULL")
		new_line = new_line.replace("'David Giraldo'","'Meili Vanegas'")
		new_line = new_line.replace("'dgiraldo'","'mvanegas10'")
		writer.write(new_line)

writer.write('ALTER TABLE pacientes MODIFY id_religion tinyint(3) unsigned;')
writer.write('ALTER TABLE pacientes MODIFY id_ocupacion tinyint(3) unsigned;')
writer.write('ALTER TABLE pacientes MODIFY id_escolaridad tinyint(3) unsigned;')
writer.write('ALTER TABLE pacientes MODIFY id_profesion tinyint(3) unsigned;')
writer.write('ALTER TABLE pacientes MODIFY id_estadocivil tinyint(3) unsigned;')
writer.write('ALTER TABLE pacientes MODIFY tel_oficina varchar(50);')
writer.write('ALTER TABLE pacientes MODIFY fax varchar(50);')
writer.write('ALTER TABLE pacientes MODIFY fecha_hora_atencion TIMESTAMP DEFAULT CURRENT_TIMESTAMP;')
writer.write('ALTER TABLE pacientes MODIFY id_tipo_ss tinyint(3) unsigned;')
writer.write('ALTER TABLE pacientes MODIFY tipo_ss_2 varchar(20);')
writer.write('ALTER TABLE pacientes MODIFY foto varchar(200);')
writer.write('ALTER TABLE pacientes MODIFY huella varchar(200);')
writer.write('ALTER TABLE pacientes MODIFY firma varchar(200);')
writer.write('ALTER TABLE pacientes MODIFY informante varchar(200);')
writer.write('ALTER TABLE pacientes MODIFY acompanante varchar(200);')
writer.write('ALTER TABLE pacientes MODIFY id_parentesco tinyint(3) unsigned;')
writer.write('ALTER TABLE pacientes MODIFY id_captacion tinyint(3) unsigned;')
writer.write('ALTER TABLE pacientes MODIFY departamento varchar(3);')
writer.write('ALTER TABLE pacientes MODIFY municipio varchar(10);')
writer.write('ALTER TABLE pacientes MODIFY rh varchar(4);')

writer.write('ALTER TABLE pacientes ADD ocupacion VARCHAR(200);')
writer.write('UPDATE pacientes p LEFT JOIN ocupacion o ON p.id_ocupacion = o.id_ocupacion SET p.ocupacion = o.ocupacion;')

reader.close()
writer.close()
